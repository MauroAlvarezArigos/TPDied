package tp.dao;

import java.util.List;

import tp.dominio.Ruta;

public interface RutaDao {
	
	public Ruta insert(Ruta r);
	public List<Ruta> buscarTodas();

}
