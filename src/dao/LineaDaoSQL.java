package dao;

import java.sql.Array;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.utils.DB;
import tp.dominio.Linea;

public class LineaDaoSQL implements LineaDao{
	
	private static final String SELECT_ALL_LINEAS = 
			"SELECT * FROM LINEA L";
	
	private static final String SELECT_LINEA =
			"SELECT * FROM LINEA L "
			+ "WHERE NOMBRE = ?";
	
	private static final String UPDATE_LINEA =
			"UPDATE LINEA SET NOMBRE = ?, COLOR = ?, ESTADO = ?, RECORRIDO = ?,"
			+ "WHERE NOMBRE = ?";
	
	private static final String DELETE_LINEA =
			"DELETE FROM LINEA"
			+ "WHERE NOMBRE = ?";
	
	private static final String INSERT_LINEA =
			"INSERT INTO ESTACION(NOMBRE, COLOR, ESTADO, RECORRIDO"
			+ "VALUES(?, ?, ?, ?)";

	@Override
	public Linea saveOrUpdate(Linea l) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try{
			if(checkNull(l.getNombre(), conn)) {
				pstmt = conn.prepareStatement(UPDATE_LINEA);
				pstmt.setString(1, l.getNombre());
				pstmt.setString(2, l.getColor());
				pstmt.setBoolean(3, l.getEstado());
				pstmt.setArray(4, (Array) l.getRecorrido());
				
				
			}
			else {
				pstmt = conn.prepareStatement(INSERT_LINEA);
				pstmt.setString(1, l.getNombre());
				pstmt.setString(2, l.getColor());
				pstmt.setBoolean(3, l.getEstado());
				pstmt.setArray(4, (Array) l.getRecorrido());
			}
			pstmt.executeUpdate();
		}
			catch(SQLException e){
				e.printStackTrace();
			}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private boolean checkNull(String nombre, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean ret = false;
		try {
			pstmt = conn.prepareStatement(SELECT_LINEA, ResultSet.TYPE_SCROLL_INSENSITIVE,	ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1,nombre);
			rs = pstmt.executeQuery();
			ret = rs.first();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	@Override
	public void borrar(Linea l) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(DELETE_LINEA);
			pstmt.setString(1, l.getNombre());
			pstmt.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}	
	
	@Override
	public List<Linea> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Linea> buscarPorAtributos(Map<String, ?> atributos) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
