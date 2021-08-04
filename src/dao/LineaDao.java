package dao;

import java.util.List;
import java.util.Map;


import tp.dominio.Linea;

public interface LineaDao {
	
	public Linea saveOrUpdate(Linea l);
	public void borrarLinea(Linea l);
	public Linea buscarLinea (String nombre);
	public List<Linea> buscarTodas();
	public List<Linea> buscarPorAtributos(Map<String, ?> atributos);

}
