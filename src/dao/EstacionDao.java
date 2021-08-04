package dao;

import java.sql.Connection;


import java.util.List;
import java.util.Map;

import tp.dominio.Estacion;

public interface EstacionDao {
	public Estacion saveOrUpdate(Estacion e);
	public void borrar(Estacion e);
	public List<Estacion> buscarPorAtributos(Map<String, ?> atributos);

}
