package tp.dominio;

import java.time.LocalTime;

public class Estacion {
	Integer id;
	String nombre;
	LocalTime horarioApertura;
	LocalTime horarioCierre;
	Boolean estado; //1 operativo, 0 en mantenimiento
	
	//Constructor
	public Estacion(Integer id, String nombre, LocalTime horarioApertura, LocalTime horarioCierre, Boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horarioApertura = horarioApertura;
		this.horarioCierre = horarioCierre;
		this.estado = estado;
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
	public LocalTime getHorarioApertura() {
		return horarioApertura;
	}
	public void setHorarioApertura(LocalTime horarioApertura) {
		this.horarioApertura = horarioApertura;
	}
	public LocalTime getHorarioCierre() {
		return horarioCierre;
	}
	public void setHorarioCierre(LocalTime horarioCierre) {
		this.horarioCierre = horarioCierre;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}
