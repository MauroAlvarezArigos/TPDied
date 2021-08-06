package tp.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tp.dao.utils.DB;
import tp.dominio.Estacion;
import tp.dominio.Ruta;

public class EstacionDaoSQL implements EstacionDao{
	
	private static final String SELECT_ALL_ESTACION = 
			"SELECT * FROM ESTACION E";
	
	private static final String SELECT_ESTACION =
			"SELECT * FROM ESTACION E "
			+ " WHERE ID = ?";
	
	private static final String UPDATE_ESTACION =
			"UPDATE ESTACION SET NOMBRE = ?, HORARIO_APERTURA = ?, HORARIO_CIERRE = ?,"
			+ " ESTADO = ?"
			+ " WHERE ID = ?";
	
	private static final String DELETE_ESTACION =
			"DELETE FROM ESTACION"
			+ " WHERE ID = ?";
	
	private static final String INSERT_ESTACION =
			" INSERT INTO ESTACION(NOMBRE, HORARIOAPERTURA, HORARIOCIERRE,  ESTADO) "
			+ " VALUES(?, ?, ?, ?)";
	
	// información que permita consultar para cada estación, el historial de mantenimientos 
	private static final String SELECT_ESTACION_M =
			"SELECT ID, FECHA_INICIO_M, FECHA_FIN_M"
			+ " FROM ESTACION E, MANTENIMIENTO M"
			+ " WHERE E.ID = M.ID " ;
	
	public EstacionDaoSQL() {
		
	}

	@Override
	public Estacion saveOrUpdate(Estacion es) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try{
			if(checkNull(es.getId(), conn)) {
				pstmt = conn.prepareStatement(UPDATE_ESTACION);
				System.out.println("Modo UPDATE");
				pstmt.setString(1, es.getNombre());
				pstmt.setTimestamp(2, es.getHorarioApertura());
				pstmt.setTimestamp(3, es.getHorarioCierre());
				pstmt.setString(4, Integer.toBinaryString(es.getEstado()));
				pstmt.setInt(5, es.getId());
				
				System.out.println("Psmt: "+pstmt.toString());
			}
			else {
				pstmt = conn.prepareStatement(INSERT_ESTACION);
				
				System.out.println("Modo INSERT");
				
				pstmt.setString(1, es.getNombre());
				pstmt.setTimestamp(2, es.getHorarioApertura());
				pstmt.setTimestamp(3, es.getHorarioCierre());
				pstmt.setString(4, Integer.toBinaryString(es.getEstado()));
				
				System.out.println("Psmt: "+pstmt.toString());
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
	
	private boolean checkNull(Integer id, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean ret = false;
		try {
			pstmt = conn.prepareStatement(SELECT_ESTACION, ResultSet.TYPE_SCROLL_INSENSITIVE,	ResultSet.CONCUR_UPDATABLE);
			pstmt.setInt(1,id);
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
	public void borrar(Estacion es) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(DELETE_ESTACION);
			pstmt.setInt(1, es.getId());
			System.out.println("pstmt: "+pstmt.toString());
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
				es.setHorarioApertura(rs.getTimestamp("HORARIO_APERTURA"));
				es.setHorarioCierre(rs.getTimestamp("HORARIO_CIERRE"));
			  	es.setEstado(rs.getBoolean("ESTADO"));
			  	//Integer.toBinaryString(es.setEstado(rs.getBoolean("ESTADO")));
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
		System.out.println(lista);
	return lista;
	}
	
	private String prepararSentencia(Map<String, ?> atrib) {
		String p1 = "SELECT * FROM ESTACION E "
				+ "WHERE ID = ?";
		String values = "";
		for (Map.Entry<String,?> entry : atrib.entrySet()) {
			
			switch(entry.getKey()) {
					
				case "ID":
				values = values.concat(" AND E.ID= "+entry.getValue());
					break;
				
				case "NOMBRE":
					values = values.concat(" AND "+"E."+entry.getKey()+" LIKE '%"+entry.getValue() + "%'");
					break;
				
				case "HORARIO_APERTURA":
					values = values.concat(" AND E.HORARIO_APERTURA = " +entry.getValue());
						break;
				
				case "HORARIO_CIERRE":
					values = values.concat(" AND E.HORARIO_CIERRE = " +entry.getValue());
						break;
						
				default:
					if(entry!=null)
					values = values.concat(" AND "+"E."+entry.getKey()+"='"+entry.getValue() + "'");
					break;
					
			}
		}
		System.out.println(p1 + values);
		return p1.concat(values); 
	}

}
