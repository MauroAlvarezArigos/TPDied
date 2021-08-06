package tp.servicios;

import java.util.List;
import java.util.Map;

import tp.dao.EstacionDao;
import tp.dao.EstacionDaoSQL;
import tp.dominio.Estacion;

public class EstacionServicio {
	
	private EstacionDao estacionDao;
	
	public EstacionServicio() {
		estacionDao = new EstacionDaoSQL();
	}
	
	public Estacion crearEstacion(Estacion es) {
		return this.estacionDao.saveOrUpdate(es);
	}
	
	public List<Estacion> buscarTodas(){
		return estacionDao.buscarTodas();
	}
	public List<Estacion> buscarPorAtriburtos (Map<String, ?> atributos) {
		return estacionDao.buscarPorAtributos(atributos);
	}
	
	public void borrarEstacion(Estacion es) {
		estacionDao.borrar(es);
	}
	
	

}
