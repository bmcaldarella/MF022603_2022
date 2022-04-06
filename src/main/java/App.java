
/**
 *@author bmcaldarella
 *Programa para listar alumnos, cursos y la reseña de los cursos que imparte Elorrieta
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static void main(String[] args) {
//se instancia la clase Menu para llamar al metodo menu 
	Menu.Menu();
	
	

		// TODO Auto-generated method stub
		try {// Se establece conexion a la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false/curso", "root",
					"root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("show databases;");

		} catch (Exception e) {
			System.out.println(e);
		}
	} // main

public void listado() throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = null;
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false/curso", "root",
				"root");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("show databases;");
	
}
	
}
