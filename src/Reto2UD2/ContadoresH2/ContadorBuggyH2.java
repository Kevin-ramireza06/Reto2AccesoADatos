package Reto2UD2.ContadoresH2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContadorBuggyH2 {
	static final String SQL_CONSULTA=
			"select cuenta from contadores where nombre='contador1'";
	static final String SQL_ACTUALIZA=
			"update contadores set cuenta=? where nombre='contador1'";
	//FUNCIONA
	public static void main(String[] args) {
		try (Connection con =
			DriverManager.getConnection("jdbc:h2:/home/alumno/IdeaProjects/Reto2AccesoADatos/contadores.db", "sa", "");
		)
		{
            Class.forName("org.h2.Driver");
			int cuenta = 0;
			for (int i=1; i<=1000; i++) {
				Statement consulta = con.createStatement();
				PreparedStatement actualiza = con.prepareStatement(SQL_ACTUALIZA);
				ResultSet res = consulta.executeQuery(SQL_CONSULTA);
				if (res.next()) cuenta = res.getInt(1) + 1;
				actualiza.setInt(1, cuenta);
				actualiza.executeUpdate();
			}
			System.out.println("Valor final: " + cuenta);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		

	}

}
