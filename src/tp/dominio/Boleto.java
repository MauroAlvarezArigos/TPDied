package tp.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Boleto {
	int numeroBoleto;
	String correo;
	String nombreCliente;
	Date fechaVenta;
	String origen;
	String destino;
	ArrayList<Ruta> recorrido;
	int costo;
	

	
	//Getters and Setters
	public int getNumeroBoleto() {
		return numeroBoleto;
	}
	public void setNumeroBoleto(int numeroBoleto) {
		this.numeroBoleto = numeroBoleto;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
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
	public ArrayList<Ruta> getRecorrido() {
		return recorrido;
	}
	public void setRecorrido(ArrayList<Ruta> recorrido) {
		this.recorrido = recorrido;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public void calcularCosto() {
		this.costo=0;
		for(Ruta r : recorrido ) {
			this.costo += r.getCosto();
		}
		return;
	}
	
	
	
	
	
	
	//esto hay que moverlo
	Map<Integer, ArrayList<Ruta>> grafo = new HashMap<Integer, ArrayList<Ruta>>();
	// con cada linea reconstruimos el grafo
	ArrayList<Linea> lineas; // pedir a la BD que me de todas las lineas
	
	public void generarGrafo() {
		for(Linea l : lineas) {
			ArrayList<Ruta> recorrido = l.getRecorrido();
			for(Ruta r : recorrido) grafo.get(r.getOrigen().getId()).add(r); //agrego las rutas al grafo dirigido
		}
	}
	
	
	
}
