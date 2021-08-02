package dao;

import java.util.List;
import java.util.Map;

import tp.dominio.Estacion;

public class EstacionDaoSQL implements EstacionDao{
	
	private static final String SELECT_ALL_ESTACIONES = 
			"SELECT * FROM ESTACION E";
	
	private static final String SELECT_ESTACION =
			"SELECT * FROM ESTACION E "
			+ "WHERE PATENTE = ?";
	
	private static final String UPDATE_ESTACION =
			"UPDATE ESTACION SET ID = ?, NOMBRE = ?, HORARIO_APERTURA = ?, HORARIO_CIERRE = ?,"
			+ " ESTADO = ?"
			+ "WHERE ID = ?";
	
	private static final String DELETE_ESTACION =
			"DELETE FROM ESTACION"
			+ "WHERE ID = ?";
	
	private static final String INSERT_ESTACION =
			"INSERT INTO ESTACION(ID, NOMBRE, HORARIO_APERTURA, HORARIO_CIERRE,  ESTADO"
			+ "VALUES(?, ?, ?, ?, ?)";
	
	// información que permita consultar para cada estación, el historial de mantenimientos 
	private static final String SELECT_ESTACION_M =
			"SELECT ID, FECHA_INICIO_M, FECHA_FIN_M"
			+ "FROM ESTACION E, MANTENIMIENTO M"
			+ "WHERE E.ID = M.ID " ;
	
	private static final Strinf INSERT_ESTACION_M =
			"INSERT INTO MANTENIMIENTO (ID, FECHA_INICIO_M, FECHA_FIN_M)"
			+ "VALUES (?,?,?)";

	@Override
	public Estacion saveOrUpdate(Estacion e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Estacion c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Estacion> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estacion> buscarPorAtributos(Map<String, ?> atributos) {
		// TODO Auto-generated method stub
		return null;
	}

}
