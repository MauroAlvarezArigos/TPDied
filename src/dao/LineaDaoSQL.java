package dao;

import java.sql.Array;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.utils.DB;
import Excepciones.ExcepcionNoExisteElemento;
import tp.dominio.Linea;
import tp.dominio.Ruta;

public class LineaDaoSQL implements LineaDao{
	
	private static final String SELECT_ALL_LINEA = 
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
	public void borrarLinea(Linea l) {
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
	public Linea buscarLinea(String nombre) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Linea l = new Linea();
		try {
			pstmt = conn.prepareStatement(SELECT_LINEA);
			rs = pstmt.executeQuery();
			if(!rs.first()) throw new ExcepcionNoExisteElemento();
			l.setNombre(rs.getString("NOMBRE"));
			l.setColor(rs.getString("COLOR"));
		}
		catch(SQLException | ExcepcionNoExisteElemento e) {
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
		return l;
	}
	
	@Override
	public List<Linea> buscarTodas() {
		List<Linea> lista = new ArrayList<Linea>();
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Linea l = null;
		try {
			pstmt = conn.prepareStatement(SELECT_ALL_LINEA);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				l = new Linea ();
				l.setNombre(rs.getString("NOMBRE"));
				l.setColor(rs.getString("COLOR"));
				lista.add(l);
			}
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
		return lista;
	}

	@Override
	public List<Linea> buscarPorAtributos(Map<String, ?> atributos) {
		List<Linea> lista = new ArrayList<Linea>();
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sentencia = prepararSentencia(atributos);
		try {
			pstmt = conn.prepareStatement(sentencia);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Linea l = new Linea();
				l.setNombre(rs.getString("NOMBRE"));
				l.setColor(rs.getString("COLOR"));
				l.setEstado(rs.getBoolean("ESTADO"));
				l.setRecorrido((ArrayList<Ruta>) rs.getArray("RECORRIDO"));
			  	lista.add(l);
			}
		}catch(SQLException e) {
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
		System.out.println(lista);
	return lista;
	}
	
	private String prepararSentencia(Map<String, ?> atrib) {
		String p1 = "SELECT * FROM LINEA L "
				+ "WHERE L.NUMERO_LINEA = ?";
		String values = "";
		for (Map.Entry<String,?> entry : atrib.entrySet()) {
			
			switch(entry.getKey()) {
				case "NUMERO_LINEA":
					values = values.concat(" AND L.NUMERO_LINEA = "+entry.getValue());
					break;
					
				case "COLOR":
					values = values.concat(" AND "+"L."+entry.getKey()+" LIKE '%"+entry.getValue() + "%'");
					break;
					
				case "ESTADO":
					values = values.concat(" AND L.ESTADO = "+entry.getValue());
					break;
					
				case "RECORRIDO":
					values = values.concat(" AND "+"L."+entry.getKey()+" LIKE '%"+entry.getValue() + "%'");
					break;
					
				default:
					if(entry!=null)
					values = values.concat(" AND "+"L."+entry.getKey()+"='"+entry.getValue() + "'");
					break;
					
			}
		}
		System.out.println(p1 + values);
		return p1.concat(values); 
	}
	

}
