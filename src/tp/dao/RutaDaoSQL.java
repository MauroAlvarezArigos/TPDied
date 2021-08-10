package tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tp.dao.utils.DB;
import tp.dominio.Ruta;

public class RutaDaoSQL implements RutaDao{
	
	
	private static final String INSERT_RUTA =
			" INSERT INTO RUTA (ORIGEN, DESTINO, DISTANCIA,  TIEMPOVIAJE, MAXPASAJEROS, ESTADO, COSTO, ORDEN) "
			+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
	@Override
	public Ruta insert(Ruta r) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		System.out.println("Entre a Insert");
		
		try{
			pstmt = conn.prepareStatement(INSERT_RUTA);
			
			System.out.println("Modo INSERT");
				
			pstmt.setString(1, r.getOrigen().toString());
			pstmt.setString(2, r.getDestino().toString());
			pstmt.setInt(3, r.getDistancia());
			pstmt.setInt(4, r.getTiempoViaje());
			pstmt.setInt(5, r.getMaxPasajeros());
			pstmt.setString(6, Integer.toBinaryString(r.getEstado()));
			pstmt.setInt(7, r.getCosto());
			pstmt.setInt(8,  r.getOrden());
			
			System.out.println("Psmt: "+pstmt.toString());
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
	

}
