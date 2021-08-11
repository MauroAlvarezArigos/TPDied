package tp.dominio;

public class Ruta {
	Estacion origen;
	Estacion destino;
	Integer distancia;
	Integer tiempoViaje;
	Integer maxPasajeros;
	Boolean estado;
	Integer costo;
	Linea linea;
	Integer orden; // define el orden de la ruta, es para la BD
	long[] datos = new long[4]; // 0 tiempo, 1 dist, 2 costo, 3 flow;
	
	//Constructor
	public Ruta() {
		super();
	}
	
	public Ruta(Estacion origen, Estacion destino, Integer distancia, Integer tiempoViaje, Integer maxPasajeros,
			Boolean estado, Integer costo, Linea linea, Integer orden) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.distancia = distancia;
		this.tiempoViaje = tiempoViaje;
		this.maxPasajeros = maxPasajeros;
		this.estado = estado;
		this.costo = costo;
		this.datos[0] = (long)tiempoViaje;
		this.datos[1] = (long) distancia;
		this.datos[2] = (long) costo;
		this.datos[3] = (long) maxPasajeros;
		this.orden = orden;
	}
	
	public Ruta(Estacion destino, Integer maxPasajeros) {
		super();
		this.destino = destino;
		this.maxPasajeros=maxPasajeros;
		this.datos[3]=maxPasajeros;
	}
	public Ruta( Integer maxPasajeros) {
		super();
		this.maxPasajeros=maxPasajeros;
		this.datos[3]=maxPasajeros;
	}

	
	//Getters and Setters
	public Linea getLinea() {
		return linea;
	}
	
	public void setLinea(Linea id) {
		this.linea = id;
	}
	public Estacion getOrigen() {
		return origen;
	}

	public void setOrigen(Estacion origen) {
		this.origen = origen;
	}

	public Estacion getDestino() {
		return destino;
	}

	public void setDestino(Estacion destino) {
		this.destino = destino;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public Integer getTiempoViaje() {
		return tiempoViaje;
	}

	public void setTiempoViaje(Integer tiempoViaje) {
		this.tiempoViaje = tiempoViaje;
	}

	public Integer getMaxPasajeros() {
		return maxPasajeros;
	}

	public void setMaxPasajeros(Integer maxPasajeros) {
		this.maxPasajeros = maxPasajeros;
	}

	public Integer getEstado() {
		if(this.estado) return 1;
		else return 0;
	}
	
	public Boolean getEstado2() {
		return this.estado;
	}
	
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	
	public Integer getOrden() {
		return orden;
	}
	
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public long getDato(int tipo) {
		return this.datos[tipo];
	}
	
	public void changeFlow(int delta) {
		this.maxPasajeros += delta;
		this.datos[3] += delta;
	}

}
