package tp.dao;

import java.sql.Connection;
import java.util.List;

import tp.dominio.Mantenimiento;
import tp.dominio.Estacion;

public interface MantenimientoDao {
	
	public List<Mantenimiento> saveOrUpdate(Integer idEstacion, List<Mantenimiento> lista);
	public List<Mantenimiento> selectHistorialMantenimientos (Estacion estacion, Connection conn);
}
