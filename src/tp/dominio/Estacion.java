package tp.dominio;

import java.sql.Time;

public class Estacion {
	Integer id;
	String nombre;
	Time horarioApertura;
	Time horarioCierre;
	Boolean estado; //1 operativo, 0 en mantenimiento
	
	//Constructor
	public Estacion(Integer id, String nombre, Time horarioApertura, Time horarioCierre, Boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horarioApertura = horarioApertura;
		this.horarioCierre = horarioCierre;
		this.estado = estado;
	}
	
	public Estacion () {
		
	}
	
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Time getHorarioApertura() {
		return horarioApertura;
	}
	public void setHorarioApertura(Time horarioApertura) {
		this.horarioApertura = horarioApertura;
	}
	public Time getHorarioCierre() {
		return horarioCierre;
	}
	public void setHorarioCierre(Time horarioCierre) {
		this.horarioCierre = horarioCierre;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	
	
	
}
