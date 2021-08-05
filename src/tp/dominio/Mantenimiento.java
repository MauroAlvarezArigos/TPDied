package tp.dominio;
import java.sql.Timestamp;


public class Mantenimiento {
	Estacion estacion;
	Timestamp inicio;
	Timestamp fin;
	String observaciones=null;
	
	public Mantenimiento(Estacion estacion, Timestamp inicio, Timestamp fin, String observaciones) {
		super();
		this.estacion= estacion;
		this.inicio = inicio;
		this.fin = fin;
		this.observaciones = observaciones;
	}
	
	public Mantenimiento () {
		
	}
	public Estacion getEstacion() {
		return estacion;
	}
	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
	public Timestamp getInicio() {
		return inicio;
	}
	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}
	public Timestamp getFin() {
		return fin;
	}
	public void setFin(Timestamp fin) {
		this.fin = fin;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
