package tp.dominio;

public class Ruta {
	Estacion origen;
	Estacion destino;
	Integer distancia;
	Integer tiempoViaje;
	Integer maxPasajeros;
	Boolean estado;
	Integer costo;
	Linea id;
	Integer orden; // define el orden de la ruta, es para la BD
	long[] datos = new long[4]; // 0 tiempo, 1 dist, 2 costo, 3 flow;
	
	//Constructor
	public Ruta(Estacion origen, Estacion destino, Integer distancia, Integer tiempoViaje, Integer maxPasajeros,
			Boolean estado, Integer costo, Integer orden) {
		super();
		this.origen = origen;
		this.destino = destino;
		//al crear una ruta se debe consultar tanto para el origen como para el destino
		//si ya existen dichas estaciones, en cuyo caso utilizar la info que tenemos
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
	public Linea getId() {
		return id;
	}
	
	public void setId(Linea id) {
		this.id = id;
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
