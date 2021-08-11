package tp.dao;

import java.sql.Array;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tp.Excepciones.ExcepcionNoExisteElemento;
import tp.dao.utils.DB;
import tp.dominio.Boleto;

public class BoletoDaoSQL implements BoletoDao{
	
	private static final String INSERT_BOLETO =
			"INSERT INTO BOLETO(CORREO, NOMBRECLIENTE, FECHAVENTA,"
			+"ORIGEN, DESTINO, COSTO)"
			+ " VALUES(?, ?, ?, ?, ?, ?)";

	@Override
	public Boleto insert(Boleto b) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(INSERT_BOLETO);
			pstmt.setString(1, b.getCorreo());
			pstmt.setString(2, b.getNombreCliente());
			pstmt.setDate(3, (Date) b.getFechaVenta());
			pstmt.setString(4, b.getOrigen());
			pstmt.setString(5, b.getDestino());
			pstmt.setInt(6, b.getCosto());
				
			pstmt.executeUpdate();
		} catch(SQLException e) {
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

}
	


