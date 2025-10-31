package Reto2UD2.ContadoresH2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContadorEnBDH2 {

	public static void main(String[] args) {
		final String sqlConsulta = "SELECT cuenta FROM contadores WHERE nombre=?;";
		final String sqlActualización = "UPDATE contadores SET cuenta=? WHERE nombre=?;";
		final String claveContador = "contador1";
        //FUNCIONA
		try {
			Connection connection = DriverManager.getConnection("jdbc:h2:/home/alumno/IdeaProjects/Reto2AccesoADatos/contadores.db","sa","");
			PreparedStatement consulta = connection.prepareStatement(sqlConsulta);
			PreparedStatement actualización = connection.prepareStatement(sqlActualización);
			int cuenta = 0;

			consulta.setString(1, claveContador);
			actualización.setString(2, claveContador);
			for (int i = 0; i < 1000; i++) {
				ResultSet res = consulta.executeQuery();
				if (res.next()) {
					cuenta = res.getInt(1) + 1;
					actualización.setInt(1, cuenta);
					actualización.executeUpdate();
				}
				// else break;
				else
					System.out.println("Error");
				// if (i%10==0) System.out.println(i/10 + "%");
			}
			System.out.println("Valor final: " + cuenta);

		} // try
		catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main

} // class
