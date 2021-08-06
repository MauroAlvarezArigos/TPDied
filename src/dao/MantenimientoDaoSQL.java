package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tp.dominio.Estacion;
import tp.dominio.Mantenimiento;

public class MantenimientoDaoSQL implements MantenimientoDao{
	
	private static final String INSERT_MANTENIMIENTO =
			"INSERT INTO MANTENIMIENTO(ID, FECHA_INICIO, FECHA_FIN, OBSERVACIONES)"
			+ " VALUES(?, ?, ?, ?)";
	
	private static final String SELECT_MANTENIMIENTO =
			"SELECT * "
			+ " FROM MANTENIMIENTO M"
			+ " WHERE M.ID = ? ";

	@Override
	public List<Mantenimiento> saveOrUpdate(Integer idEstacion, List<Mantenimiento> lista, Connection conn) {
		PreparedStatement pstmt = null;
		try {
				pstmt = conn.prepareStatement(INSERT_MANTENIMIENTO);
				pstmt.setInt(1, idEstacion);
				for(int i = 0; i<lista.size(); i++) {
					pstmt.setTimestamp(2, lista.get(i).getInicio());
					pstmt.setTimestamp(3, lista.get(i).getFin());
					pstmt.setString(4, lista.get(i).getObservaciones());
					pstmt.executeUpdate();
				}
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
		return lista;
	}
	
	@Override
	public List<Mantenimiento> selectHistorialMantenimientos (Estacion estacion, Connection conn){
		List<Mantenimiento> lista = new ArrayList<Mantenimiento>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Mantenimiento m = null;
		try {
			pstmt = conn.prepareStatement(SELECT_MANTENIMIENTO);
			pstmt.setInt(1, estacion.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				m = new Mantenimiento();
				m.setInicio(rs.getTimestamp("FECHA_INICIO"));
				m.setFin(rs.getTimestamp("FECHA_FIN"));	
				lista.add(m);
			}
			
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
		return lista;
	}
	
	

}
