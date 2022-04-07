import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	/**
	 * 
	 * Conexion a la base de datos
	 */
	public static Connection getConnection() {

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso?useSSL=false", "root", "root");
		
		} catch (SQLException e) {
			System.out.println("ERROR de conexion");
			e.printStackTrace();
		}

		return con;
	}

}