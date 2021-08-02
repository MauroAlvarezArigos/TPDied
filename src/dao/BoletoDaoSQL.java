package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.utils.DB;
import dominio.Camion;
import dominio.Modelo;
import tp.dominio.Boleto;

public class BoletoDaoSQL implements BoletoDao{
	
	private static final String SELECT_ALL_BOLETO = 
			"SELECT * FROM BOLETO B";
	
	private static final String SELECT_BOLETO =
			"SELECT * FROM BOLETO B "
			+ "WHERE NUMERO_BOLETO = ?";
	
	private static final String UPDATE_BOLETO =
			"UPDATE BOLETO SET NUMERO_BOLETO = ?, CORREO = ?, NOMBRE_CLIENTE = ?, FECHA_VENTA = ?,"
			+ "ORIGEN, DESTINO, RECORRIDO, COSTO"
			+ "WHERE NUMERO_BOLETO = ?";
	
	private static final String DELETE_BOLETO =
			"DELETE FROM BOLETO"
			+ "WHERE NUMERO_BOLETO = ?";
	
	private static final String INSERT_BOLETO =
			"INSERT INTO ESTACION(NUMERO_BOLETO, CORREO, NOMBRE_CLIENTE, FECHA_VENTA,"
			+"ORIGEN, DESTINO, RECORRIDO, COSTO"
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public Boleto saveOrUpdate(Boleto b) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try{
			if(checkNull(b.getPatente(), conn)) {
				pstmt = conn.prepareStatement(UPDATE_BOLETO);
				pstmt.setInt(1, b.getNumeroBoleto());
				pstmt.setString(2, b.getCorreo());
				pstmt.setString(3, b.getNombreCliente());
				pstmt.setDate(4, b.getFechaVenta());
				pstmt.setString(5, b.getOrigen());
				pstmt.setString(6, b.getDestino());
				pstmt.setArrayList(7, b.getRecorrido());
				pstmt.setInt(8, b.getCosto());
				
			}
			else {
				pstmt = conn.prepareStatement(INSERT_BOLETO);
				pstmt.setInt(1, b.getNumeroBoleto());
				pstmt.setString(2, b.getCorreo());
				pstmt.setString(3, b.getNombreCliente());
				pstmt.setDate(4, b.getFechaVenta());
				pstmt.setString(5, b.getOrigen());
				pstmt.setString(6, b.getDestino());
				pstmt.setArrayList(7, b.getRecorrido());
				pstmt.setInt(8, b.getCosto());
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

	@Override
	public void borrar(Boleto b) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(DELETE_BOLETO);
			pstmt.setString(1, b.getNumeroBoleto());
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
		}b
		
	}

	@Override
	public List<Boleto> buscarTodos() {
		List<Boleto> lista = new ArrayList<Boleto>();
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(SELECT_ALL_BOLETO);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Boleto b = new Boleto();
				b.setNumeroBoleto(rs.getInt("NUMERO_BOLETO"));
				b.setCorreo(rs.getString("CORREO"));
				b.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
				b.setFechaVenta(rs.getDate("FECHA_VENTA"));
			  	b.setOrigen(rs.getString("ORIGEN"));
			  	b.setDestino(rs.getString("DESTINO"));
			  	b.setRecorrido(rs.getArrayList("RECORRIDO"));
			  	b.setCosto(rs.getInt("COSTO"));
				lista.add(b);
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
	public List<Boleto> buscarPorAtributos(Map<String, ?> atributos) {
		List<Boleto> lista = new ArrayList<Boleto>();
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(SELECT_ALL_BOLETO);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Boleto b = new Boleto();
				b.setNumeroBoleto(rs.getInt("NUMERO_BOLETO"));
				b.setCorreo(rs.getString("CORREO"));
				b.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
				b.setFechaVenta(rs.getDate("FECHA_VENTA"));
			  	b.setOrigen(rs.getString("ORIGEN"));
			  	b.setDestino(rs.getString("DESTINO"));
			  	b.setRecorrido(rs.getArrayList("RECORRIDO"));
				lista.add(b);
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
