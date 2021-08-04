package tp.dominio;
import java.sql.Time;


public class Mantenimiento {
	Estacion estacion;
	Time inicio;
	Time fin;
	String observaciones;
	
	public Mantenimiento(Estacion estacion, Time inicio, Time fin, String observaciones) {
		super();
		this.estacion= estacion;
		this.inicio = inicio;
		this.fin = fin;
		this.observaciones = observaciones;
	}
	
	public Mantenimiento () {
		
	}
	
	
	public Time getInicio () {
		return inicio;
	}
	
	public void setInicio(Time inicio) {
		this.inicio = inicio;
	}
	
	public Time getFin() {
		return fin;
	}
	
	public void setFin(Time fin) {
		this.fin = fin;
	}
	
	public String getObservaciones(){
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
