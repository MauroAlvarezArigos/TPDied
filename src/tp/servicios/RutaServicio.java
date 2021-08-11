package tp.servicios;

import java.util.List;

import tp.dao.RutaDao;
import tp.dao.RutaDaoSQL;
import tp.dominio.Ruta;

public class RutaServicio {
	private RutaDao rutadao;
	public RutaServicio() {
		this.rutadao = new RutaDaoSQL();
	}
	public void crearRuta(Ruta r) {
		this.rutadao.insert(r);
	}
	public List<Ruta> obtenerTodas(){
		return this.rutadao.buscarTodas();
	}
	
}
