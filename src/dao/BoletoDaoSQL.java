package dao;

import java.sql.Array
;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Excepciones.ExcepcionNoExisteElemento;
import dao.utils.DB;
import tp.dominio.Boleto;

public class BoletoDaoSQL implements BoletoDao{
	
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
			if(checkNull(b.getNumeroBoleto(), conn)) {
				pstmt = conn.prepareStatement(UPDATE_BOLETO);
				pstmt.setInt(1, b.getNumeroBoleto());
				pstmt.setString(2, b.getCorreo());
				pstmt.setString(3, b.getNombreCliente());
				pstmt.setDate(4, (Date) b.getFechaVenta());
				pstmt.setString(5, b.getOrigen());
				pstmt.setString(6, b.getDestino());
				pstmt.setArray(7, (Array) b.getRecorrido());
				pstmt.setInt(8, b.getCosto());
				
			}
			else {
				pstmt = conn.prepareStatement(INSERT_BOLETO);
				pstmt.setInt(1, b.getNumeroBoleto());
				pstmt.setString(2, b.getCorreo());
				pstmt.setString(3, b.getNombreCliente());
				pstmt.setDate(4, (Date) b.getFechaVenta());
				pstmt.setString(5, b.getOrigen());
				pstmt.setString(6, b.getDestino());
				pstmt.setArray(7, (Array) b.getRecorrido());
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

	private boolean checkNull(int numeroBoleto, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean ret = false;
		try {
			pstmt = conn.prepareStatement(SELECT_BOLETO, ResultSet.TYPE_SCROLL_INSENSITIVE,	ResultSet.CONCUR_UPDATABLE);
			pstmt.setInt(1, numeroBoleto);
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
	public Boleto buscar(Integer numeroBoleto) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boleto b = new Boleto();
		try {
			pstmt = conn.prepareStatement(SELECT_BOLETO);
			rs = pstmt.executeQuery();
			if(!rs.first()) throw new ExcepcionNoExisteElemento();
			b.setNumeroBoleto(rs.getInt("NUMERO_BOLETO"));
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
		return b;
	}
	
	@Override
	public void borrar(Boleto b) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(DELETE_BOLETO);
			pstmt.setInt(1, b.getNumeroBoleto());
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
	
	


	
	
}
	


