package Reto2UD2.ContadoresH2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBDContadoresH2 {

    public static void main(String[] args) {
        try {
            // Ruta del archivo de base de datos (se crea automáticamente si no existe)
            String url = "jdbc:h2:/home/alumno/IdeaProjects/Reto2AccesoADatos/contadores.db";

            // Sentencia SQL para crear la tabla
            String sql = "CREATE TABLE IF NOT EXISTS contadores (" +
                    "nombre VARCHAR(50) PRIMARY KEY, " +
                    "cuenta INT NOT NULL DEFAULT 0" +
                    ");";

            String insert = "INSERT INTO contadores(nombre, cuenta) VALUES('contador1', 0);";

            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(url, "sa", "");
            Statement stmt = conn.createStatement();

            stmt.execute(sql);
            stmt.execute(insert);
            System.out.println("Base de datos y tabla 'contadores' creadas correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
