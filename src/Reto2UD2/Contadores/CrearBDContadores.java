package Reto2UD2.Contadores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBDContadores {

    public static void main(String[] args) {
        try {
        // Ruta del archivo de base de datos (se crea automáticamente si no existe)
        String url = "jdbc:sqlite:/home/alumno/IdeaProjects/Reto2AccesoADatos/contadores.db";

        // Sentencia SQL para crear la tabla
        String sql = "CREATE TABLE IF NOT EXISTS contadores (" +
                "nombre TEXT PRIMARY KEY, " +
                "cuenta INTEGER NOT NULL DEFAULT 0" +
                ");";

            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            stmt.execute(sql);
            System.out.println("Base de datos y tabla 'contadores' creadas correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
