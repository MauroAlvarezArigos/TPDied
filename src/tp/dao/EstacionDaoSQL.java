package tp.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tp.dao.utils.DB;
import tp.dominio.Estacion;

public class EstacionDaoSQL implements EstacionDao{
	
	private static final String SELECT_ALL_ESTACION = 
			"SELECT * FROM ESTACION E";
	
	private static final String SELECT_ESTACION =
			"SELECT * FROM ESTACION "
			+ " WHERE ID = ?";
	
	private static final String UPDATE_ESTACION =
			"UPDATE ESTACION SET NOMBRE = ?, HORARIOAPERTURA = ?, HORARIOCIERRE = ?,"
			+ " ESTADO = ?"
			+ " WHERE ID = ?";
	
	private static final String DELETE_ESTACION =
			"DELETE FROM ESTACION"
			+ " WHERE ID = ?";
	
	private static final String INSERT_ESTACION =
			" INSERT INTO ESTACION (NOMBRE, HORARIOAPERTURA, HORARIOCIERRE,  ESTADO) "
			+ " VALUES(?, ?, ?, ?)";
	
	private static final String INSERT_MANTENIMIENTO =
			" INSERT INTO MANTENIMIENTO (ESTACION, INICIO, OBSERVACIONES) "
			+ " VALUES(?, ?, ?)";
	
	private static final String UPDATE_MANTENIMIENTO =
			" UPDATE MANTENIMIENTO SET FIN = ?, OBSERVACIONES = ? "
			+ " WHERE ESTACION = ?";
	
	// información que permita consultar para cada estación, el historial de mantenimientos 
	private static final String SELECT_ESTACION_M =
			"SELECT ID, FECHA_INICIO_M, FECHA_FIN_M"
			+ " FROM ESTACION E, MANTENIMIENTO M"
			+ " WHERE E.ID = M.ID " ;
	
	public EstacionDaoSQL() {
		
	}

	@Override
	public Estacion insert(Estacion es) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		
		try{
			pstmt = conn.prepareStatement(INSERT_ESTACION);
			pstmt.setString(1, es.getNombre());
			pstmt.setTimestamp(2, es.getHorarioApertura());
			pstmt.setTimestamp(3, es.getHorarioCierre());
			pstmt.setString(4, Integer.toBinaryString(es.getEstado()));
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
	public Estacion modify(Estacion es) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(UPDATE_ESTACION);
			System.out.println(es.getId());
			
			pstmt.setString(1, es.getNombre());
			pstmt.setTimestamp(2, es.getHorarioApertura());
			pstmt.setTimestamp(3, es.getHorarioCierre());
			pstmt.setString(4, Integer.toBinaryString(es.getEstado()));
			pstmt.setInt(5, es.getId());
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
	public void borrar(Estacion es) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(DELETE_ESTACION);
			pstmt.setInt(1, es.getId());
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
	public List<Estacion> buscarTodas() {
		List<Estacion> lista = new ArrayList<Estacion>();
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Estacion es = null;
		try {
			pstmt = conn.prepareStatement(SELECT_ALL_ESTACION);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				es = new Estacion ();
				es.setId(rs.getInt("ID"));
				es.setNombre(rs.getString("NOMBRE"));
				es.setHorarioApertura(rs.getTimestamp("HORARIOAPERTURA"));
				es.setHorarioCierre(rs.getTimestamp("HORARIOCIERRE"));
			  	es.setEstado(rs.getBoolean("ESTADO"));
				lista.add(es);
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
	public HashMap<Integer,Estacion> buscarTodasMap() {
		HashMap<Integer,Estacion>  lista = new HashMap<Integer,Estacion> ();
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Estacion es = null;
		try {
			pstmt = conn.prepareStatement(SELECT_ALL_ESTACION);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				es = new Estacion ();
				es.setId(rs.getInt("ID"));
				es.setNombre(rs.getString("NOMBRE"));
				es.setHorarioApertura(rs.getTimestamp("HORARIOAPERTURA"));
				es.setHorarioCierre(rs.getTimestamp("HORARIOCIERRE"));
			  	es.setEstado(rs.getBoolean("ESTADO"));
				lista.put(es.getId(), es);
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
	public List<Estacion> buscarPorAtributos(Map<String, ?> atributos) {
		List<Estacion> lista = new ArrayList<Estacion>();
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sentencia = prepararSentencia(atributos);
		try {
			pstmt = conn.prepareStatement(sentencia);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Estacion es = new Estacion();
				es.setId(rs.getInt("ID"));
				es.setNombre(rs.getString("NOMBRE"));
				es.setHorarioApertura(rs.getTimestamp("HORARIOAPERTURA"));
				es.setHorarioCierre(rs.getTimestamp("HORARIOCIERRE"));
			  	es.setEstado(rs.getBoolean("ESTADO"));
				lista.add(es);
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
        String p1 = "SELECT * FROM ESTACION E ";
        String values = "";
        values = values.concat("WHERE E.NOMBRE LIKE '%"+atrib.get("NOMBRE") + "%'");
        if(atrib.get("ESTADO") != "Ambos") {
            values = values.concat(" AND ESTADO = '" + atrib.get("ESTADO")+"'");
        }
        System.out.println(p1 + values);
        return p1.concat(values); 
    }

	@Override
	public void crearMantenimiento(Integer estacion, String obs) {
		System.out.println("Estacion crearMant: "+estacion);
		System.out.println("OBS: "+obs);
		
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(INSERT_MANTENIMIENTO);
			
			pstmt.setInt(1, estacion);
			pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(3, obs);
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
		
	}

	@Override
	public void finalizarMantenimiento(Integer estacion, String obs) {
		System.out.println("Estacion finMant: "+estacion);
		System.out.println("OBS: "+obs);
		
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(UPDATE_MANTENIMIENTO);
			
			pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(2, obs);
			pstmt.setInt(3, estacion);

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
	}

}
