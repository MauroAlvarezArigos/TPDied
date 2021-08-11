package tp.dao;

import java.sql.Connection;


import java.util.List;
import java.util.Map;

import tp.dominio.Estacion;
import tp.dominio.Linea;

public interface EstacionDao {
	public Estacion insert(Estacion e);
	public Estacion modify(Estacion e);
	public void borrar(Estacion e);
	public List<Estacion> buscarPorAtributos(Map<String, ?> atributos);
	public List<Estacion> buscarTodas();
	public void crearMantenimiento(Integer estacion, String obs);
	public void finalizarMantenimiento(Integer estacion, String obs);

}
