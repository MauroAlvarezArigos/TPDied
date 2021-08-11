package tp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tp.dao.utils.DB;
import tp.dominio.Estacion;
import tp.dominio.Linea;
import tp.dominio.Ruta;
import tp.servicios.EstacionServicio;
import tp.servicios.LineaServicio;

public class RutaDaoSQL implements RutaDao{
	
	
	private static final String INSERT_RUTA =
			" INSERT INTO RUTA (ORIGEN, DESTINO, DISTANCIA,  TIEMPOVIAJE, MAXPASAJEROS, ESTADO, COSTO, ORDEN) "
			+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SELECT_ALL_RUTA =
			"SELECT * FROM RUTA";
	
	@Override
	public Ruta insert(Ruta r) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		
		try{
			pstmt = conn.prepareStatement(INSERT_RUTA);
			pstmt.setInt(1, r.getOrigen().getId());
			pstmt.setInt(2, r.getDestino().getId());
			pstmt.setInt(3, r.getDistancia());
			pstmt.setInt(4, r.getTiempoViaje());
			pstmt.setInt(5, r.getMaxPasajeros());
			pstmt.setString(6, Integer.toBinaryString(r.getEstado()));
			pstmt.setInt(7, r.getCosto());
			pstmt.setInt(8, r.getLinea().getId());
			pstmt.setInt(9, r.getOrden());
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
	public List<Ruta> buscarTodas() {
		List<Ruta> lista = new ArrayList<Ruta>();
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Ruta r = null;
		EstacionServicio estacionservicio = new EstacionServicio();
		List<Estacion> estaciones = estacionservicio.buscarTodas();
		LineaServicio lineaservicio = new LineaServicio();
		List<Linea> lineas =  lineaservicio.buscarTodas();
		
		try {
			pstmt = conn.prepareStatement(SELECT_ALL_RUTA);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				r = new Ruta ();
				r.setOrigen(estaciones.get(rs.getInt("ORIGEN")));
				r.setDestino(estaciones.get(rs.getInt("DESTINO")));
				r.setDistancia(rs.getInt("DISTANCIA"));
				r.setTiempoViaje(rs.getInt("TIEMPOVIAJE"));
				r.setMaxPasajeros(rs.getInt("MAXPASAJEROS"));
				r.setEstado(rs.getBoolean("ESTADO"));
				r.setCosto(rs.getInt("COSTO"));
				r.setOrden(rs.getInt("ORDEN"));
				r.setLinea(lineas.get(rs.getInt("LINEA")));
				lista.add(r);
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
	

}
