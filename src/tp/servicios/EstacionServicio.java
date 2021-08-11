package tp.servicios;

import java.util.HashMap;
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
		return this.estacionDao.insert(es);
	}

	public Estacion modificarEstacion(Estacion es) {
		return this.estacionDao.modify(es);
	}

	public List<Estacion> buscarTodas(){
		return estacionDao.buscarTodas();
	}
	public HashMap<Integer,Estacion> buscarTodasMap(){
		return estacionDao.buscarTodasMap();
	}
	
	public List<Estacion> buscarPorAtriburtos (Map<String, ?> atributos) {
		return estacionDao.buscarPorAtributos(atributos);
	}
	
	public void borrarEstacion(Estacion es) {
		estacionDao.borrar(es);
	}

	public void crearMantenimiento(Integer estacion, String obs) {
		this.estacionDao.crearMantenimiento(estacion, obs);
	}

	public void finalizarMantenimiento(Integer estacion, String obs) {
		this.estacionDao.finalizarMantenimiento(estacion, obs);
	}
	
	

}
