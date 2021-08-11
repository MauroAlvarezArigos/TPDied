package tp.dao;

import java.sql.Array;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tp.Excepciones.ExcepcionNoExisteElemento;
import tp.dao.utils.DB;
import tp.dominio.Linea;
import tp.dominio.Ruta;

public class LineaDaoSQL implements LineaDao{
	private Linea prueba;
	private static final String SELECT_ALL_LINEA = 
			"SELECT * FROM LINEA L";
	
	private static final String SELECT_LINEA =
			"SELECT * FROM LINEA L"
			+ " WHERE NOMBRE = ? ";
	
	private static final String UPDATE_LINEA =
			"UPDATE LINEA SET NOMBRE = ?, COLOR = ?, ESTADO = ? "
			+ " WHERE NOMBRE = ? ";
	
	private static final String DELETE_LINEA =
			"DELETE FROM LINEA"
			+ " WHERE NOMBRE = ? ";
	
	private static final String INSERT_LINEA =
			"INSERT INTO LINEA(NOMBRE, COLOR, ESTADO)"
			+ " VALUES(?, ?, ?)";
	
	public LineaDaoSQL() {
		
	}

	public Linea insert(Linea l) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(INSERT_LINEA);
			System.out.println("CHECK " + l.getNombre() + " " + l.getColor() + " ");
			pstmt.setString(1, l.getNombre());
			pstmt.setString(2, l.getColor());
			pstmt.setString(3, Integer.toBinaryString(l.getEstado()));
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
	
	@Override
	public Linea modify(Linea l, String pk) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(UPDATE_LINEA);
			pstmt.setString(1, l.getNombre());
			pstmt.setString(2, l.getColor());
			pstmt.setString(3, Integer.toBinaryString(l.getEstado()));
			pstmt.setString(4, pk);
			pstmt.executeUpdate();
	
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
		
		return null;
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
	return lista;
	}
	
	private String prepararSentencia(Map<String, ?> atrib) {
		String p1 = "SELECT * FROM LINEA L";
		String values = "";
		boolean first = true;
		for (Map.Entry<String,?> entry : atrib.entrySet()) {
			if(entry.getKey() == "ESTADO" && entry.getValue() == "Ambos") continue;
			if(first) values=values.concat(" WHERE");
			else values=values.concat(" AND");
			
			switch(entry.getKey()) {
				case "NOMBRE":
					values = values.concat(" L.NOMBRE LIKE '%"+entry.getValue() + "%'");
					break;
					
				case "COLOR":
					values = values.concat(" L.COLOR LIKE '%"+entry.getValue() + "%'");
					break;
					
				case "ESTADO":
					values = values.concat(" L.ESTADO = '"+entry.getValue()+"'");
					break;
				default:
					if(entry!=null)
					values = values.concat(" AND "+"L."+entry.getKey()+"='"+entry.getValue() + "'");
					break;
					
			}
			first=false;
		}
		return p1.concat(values); 
	}
	

}
