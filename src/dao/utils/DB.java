package dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private static final String url =" ";
	private static final String user=" ";
	private static final String pass=" ";
	private static boolean conexion = true;
	
	private static Connection crearConexion(){
		Connection conn=null;
		try {
			Class.forName("  ");
			conn= DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		conexion = true;
		return conn;
	}
	

	public static Connection getConexion() {
		if(conexion) return crearConexion();
		return null;
	}
}
