package tp.servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tp.dao.LineaDao;
import tp.dao.LineaDaoSQL;
import tp.dominio.Estacion;
import tp.dominio.Linea;

public class LineaServicio {
	
private LineaDao lineadao;
	
	public LineaServicio() {
		lineadao = new LineaDaoSQL();
	}
	
	public Linea crearLinea(Linea l) {
		return this.lineadao.insert(l);
	}
	public Linea modificarLinea(Linea l, String pk) {
		return this.lineadao.modify(l,pk);
	}
	
	public Linea buscarLinea(Linea l) {
		return lineadao.buscarLinea(l.getNombre());
	}
	
	public List<Linea> buscarTodas(){
		return lineadao.buscarTodas();	
	}
	public HashMap<Integer,Linea> buscarTodasMap(){
		return lineadao.buscarTodasMap();	
	}
	
	public List<Linea> buscarPorAtributos(Map<String, ?> atributos)	{
		return lineadao.buscarPorAtributos(atributos);
	}
	
	public void borrarLinea(Linea l) {
		lineadao.borrarLinea(l);
	}

}
