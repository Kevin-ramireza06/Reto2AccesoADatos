package Reto2UD2.Contadores;

import java.sql.*;

public class ContadorEnBDUpdatable {
    //Funciona
    public static void main(String[] args) {
        final String claveContador = "contador1";
        final String sqlSelect = "SELECT cuenta FROM contadores WHERE nombre = ?";
        final String sqlUpdate = "UPDATE contadores SET cuenta = ? WHERE nombre = ?";
        final String sqlInsert = "INSERT INTO contadores(nombre, cuenta) VALUES(?, ?)";

        try {
            // Cargar el driver (opcional en Java 11+, pero útil por compatibilidad)
            Class.forName("org.sqlite.JDBC");

            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlite:/home/alumno/IdeaProjects/Reto2AccesoADatos/contadores.db"
            );

            int cuenta = 0;

            for (int i = 0; i < 1000; i++) {
                try (PreparedStatement select = connection.prepareStatement(sqlSelect)) {
                    select.setString(1, claveContador);
                    try (ResultSet rs = select.executeQuery()) {
                        if (rs.next()) {
                            cuenta = rs.getInt("cuenta") + 1;
                            try (PreparedStatement update = connection.prepareStatement(sqlUpdate)) {
                                update.setInt(1, cuenta);
                                update.setString(2, claveContador);
                                update.executeUpdate();
                            }
                        } else {
                            // Si no existe el contador, se inserta con valor inicial 1
                            cuenta = 1;
                            try (PreparedStatement insert = connection.prepareStatement(sqlInsert)) {
                                insert.setString(1, claveContador);
                                insert.setInt(2, cuenta);
                                insert.executeUpdate();
                            }
                        }
                    }
                }
            }

            System.out.println("Valor final del contador '" + claveContador + "': " + cuenta);

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
