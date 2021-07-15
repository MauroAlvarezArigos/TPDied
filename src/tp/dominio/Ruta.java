package tp.dominio;

public class Ruta {
	String origen;
	String destino;
	Integer distancia;
	Integer tiempoViaje;
	Integer maxPasajeros;
	Boolean estado;
	Double costo;
	
	//Constructor
	public Ruta(String origen, String destino, Integer distancia, Integer tiempoViaje, Integer maxPasajeros,
			Boolean estado, Double costo) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.distancia = distancia;
		this.tiempoViaje = tiempoViaje;
		this.maxPasajeros = maxPasajeros;
		this.estado = estado;
		this.costo = costo;
	}

	//Getters and Setters
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
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

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	
}
