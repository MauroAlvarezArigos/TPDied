package dao;

import java.util.List;
import java.util.Map;

import tp.dominio.Linea;

public class LineaDaoSQL implements LineaDao{
	
	private static final String SELECT_ALL_LINEAS = 
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Linea l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Linea> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Linea> buscarPorAtributos(Map<String, ?> atributos) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
