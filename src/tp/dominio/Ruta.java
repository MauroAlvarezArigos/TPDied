package tp.dominio;

public class Ruta {
	Estacion origen;
	Estacion destino;
	Integer distancia;
	Integer tiempoViaje;
	Integer maxPasajeros;
	Boolean estado;
	Integer costo;
	
	//Constructor
	public Ruta(Estacion origen, Estacion destino, Integer distancia, Integer tiempoViaje, Integer maxPasajeros,
			Boolean estado, Integer costo) {
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
	}

	//Getters and Setters
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

	public Boolean getEstado() {
		return estado;
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

	
}
