package Reto2UD2.ContadoresH2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContadorEnBDsoloUpdateSqlH2 {

	public static void main(String[] args) {
		final String claveContador = "contador1";
		// La actualización en el propio SQL sí es atómica:
		final String sqlActualización = "UPDATE contadores SET cuenta=cuenta+1 WHERE nombre='" + claveContador + "';";
	//funciona
		 try{
             Class.forName("org.h2.Driver");
			 Connection connection = DriverManager.getConnection(
                     "jdbc:h2:/home/alumno/IdeaProjects/Reto2AccesoADatos/contadores.db","sa","");
			 PreparedStatement actualización = connection.prepareStatement(sqlActualización);
			 for (int i=0; i<1000;i++) {
				 if (actualización.executeUpdate() != 1) break;
				if (i%10==0) System.out.println(i/10 + "%");
			 }
		 } // try
		 catch (SQLException e) {
			 System.out.println(e.getMessage());
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
	} // main

} // class
