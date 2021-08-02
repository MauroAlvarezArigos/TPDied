package dao;

import java.util.List;
import java.util.Map;


import tp.dominio.Linea;

public interface LineaDao {
	
	public Linea saveOrUpdate(Linea l);
	public void borrar(Linea l);
	public List<Linea> buscarTodos();
	public List<Linea> buscarPorAtributos(Map<String, ?> atributos);

}
