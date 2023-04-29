package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	public static String host = "localhost";
	public static String puerto = "5432";
	public static String usuario = "postgres";
	public static String password = "postgres";

	public static String baseDeDatos = "sistema_ventas";

	public static Connection conexion;// atributo para establecer conexión con la BD
	public static Statement stm;

	public static void conectar() {
		// url> jdbc:postgresql://localhost/base_de_datos
		try {
			conexion = DriverManager.getConnection("jdbc:postgresql://" + host + "/" + baseDeDatos, usuario, password);
			stm = conexion.createStatement();
			System.out.println("CONECTADO");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void desconectar() {
		try {
			stm.close();
			conexion.close();
			System.out.println("DESCONECTADO");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}