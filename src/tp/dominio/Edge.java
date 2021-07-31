package tp.dominio;

public class Edge {
	int destino;
	long[] datos = new long[4]; // 0 tiempo, 1 dist, 2 costo, 3 flow;
	
	public Edge(Ruta ruta, Boolean reves) {
		if(reves) this.destino = ruta.getOrigen().getId();
		else this.destino = ruta.getDestino().getId();
		this.datos[0] = (long) ruta.getTiempoViaje();
		this.datos[1] = (long) ruta.getDistancia();
		this.datos[2] = (long) ruta.getCosto();
		this.datos[3] = (long) ruta.getMaxPasajeros();
	}
	
	public int getDestino() {
		return this.destino;
	}
	public long getDato(int tipo) {
		return this.datos[tipo];
	}
}
