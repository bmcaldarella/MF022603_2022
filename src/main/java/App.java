
/**
 *@author bmcaldarella
 *Programa para listar alumnos, cursos y la reseña de los cursos que imparte Elorrieta
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {

	public static void main(String[] args) {
//se instancia la clase Menu para llamar al metodo menu 
		Menu.Menu();
		Conexion conexion = new Conexion();
		conexion.getConnection();
	} // main

	static void listar() {

		String sql = "select " + "curso_codigo as codigo, " + "c.nombre as curso, " + "horas, " + "fecha, "
				+ "p.nombre as profesor " + "from imparticion i join curso c on i.curso_id=c.curso_id "
				+ "join profesor p on i.profesor_id= p.profesor_id " + "order by fecha desc " + ";";

		try (Connection con = Conexion.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {
			System.out.println("CURSOS:");
			System.out.println("CODIGO" + " " + "CURSO" + "  " + "FECHA" );
			System.out.println("----------------------------------------------");

			while (rs.next()) {

				int codigo = rs.getInt("codigo");
				String curso = rs.getString("curso");

				int horas = rs.getInt("horas");
				String fecha = rs.getString("fecha");

				String profesor = rs.getString("profesor");
		
				
				
				System.out.println(codigo + "  " +  curso + "  " + fecha );
			

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	static void masResenias() {

		String sql = "select "
				+ "p.curso_codigo as codigo, "
				+ "c.nombre as curso, "
				+ "horas, "
				+ "pr.nombre as profesor, "
				+ "alumno_id, "
				+ "resenia, "
				+ "valoracion, "
				+ "fecha "
				+ "from participantes p inner join imparticion i on p.curso_codigo= i.curso_codigo "
				+ "join profesor pr on i.profesor_id=pr.profesor_id "
				+ "join curso c on c.curso_id = i.curso_id "
				+ "where p.curso_codigo=2177 "
				+ "order by valoracion desc "
				+ ";";

		try (Connection con = Conexion.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {
			
			System.out.println("CODIGO" + " " + " CURSO" + " " + " HORAS"+"  "+ "   PROFESOR"+"     "+"ID-ALUMNO" + " " + "RESENIA" + "  "+"VALORACION" + "        "+"FECHA");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

			while (rs.next()) {

				int codigo = rs.getInt("codigo");
				String curso = rs.getString("curso");

				int horas = rs.getInt("horas");
				String profesor = rs.getString("profesor");
				int alumno_id = rs.getInt("alumno_id");
				String resenia = rs.getString("resenia");
				int valoracion = rs.getInt("valoracion");
				String fecha = rs.getString("fecha");
				
			
		
				
				
				System.out.println(codigo + "    " +  curso + "    " + horas +"    "+ profesor + "   "+ alumno_id+ "     "+resenia+ "              "+ valoracion+ "        " + fecha);
			

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	public void detalles(){
		
		String sql = " "
				+ "select "
				+ "curso_codigo as codigo, "
				+ "c.nombre as curso, "
				+ "horas, "
				+ "fecha, "
				+ "p.nombre as profesor "
				+ "from imparticion i join curso c on i.curso_id=c.curso_id "
				+ "join profesor p on i.profesor_id= p.profesor_id "
				+ "order by fecha desc";

		try (Connection con = Conexion.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {
			
			System.out.println("CODIGO" + " " +"CURSO"+ " "+ "HORAS" + "  " + "FECHA" + " " + "   PROFESOR");
			System.out.println("----------------------------------------------");

			while (rs.next()) {

				int codigo = rs.getInt("codigo");
				String curso = rs.getString("curso");

				int horas = rs.getInt("horas");
				String fecha = rs.getString("fecha");

				String profesor = rs.getString("profesor");
		
				
				
				System.out.println(codigo + "  " +  curso +"   "+horas +"   " + fecha +"  "+ profesor);
			

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
	
}//FIN
