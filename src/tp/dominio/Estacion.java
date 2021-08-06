package tp.dominio;

import java.sql.Timestamp;

public class Estacion {
	Integer id;
	String nombre;
	Timestamp horarioApertura;
	Timestamp horarioCierre;
	Boolean estado; //1 operativo, 0 en mantenimiento
	Timestamp ultimoMantenimiento = null;
	
	//Constructor
	public Estacion(Integer id, String nombre, Timestamp horarioApertura, Timestamp horarioCierre, Boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horarioApertura = horarioApertura;
		this.horarioCierre = horarioCierre;
		this.estado = estado;
	}
	
	public Estacion() {
		
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
	public Timestamp getHorarioApertura() {
		return horarioApertura;
	}
	public void setHorarioApertura(Timestamp horarioApertura) {
		this.horarioApertura = horarioApertura;
	}
	public Timestamp getHorarioCierre() {
		return horarioCierre;
	}
	public void setHorarioCierre(Timestamp horarioCierre) {
		this.horarioCierre = horarioCierre;
	}
	public Integer getEstado() {
		if(this.estado) return 1;
		else return 0;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public void setUltimoMantenimiento(Timestamp ult) {
		this.ultimoMantenimiento = ult;
	}
	public Timestamp getUltimoMantenimiento() {
		return this.ultimoMantenimiento;
	}

	public static int compare(Estacion x, Estacion y) {
		return (x.ultimoMantenimiento.compareTo(y.ultimoMantenimiento));
	}
	public Boolean getEstado2() {
		return this.estado;
	}
	
	@Override
	public String toString() {
		return this.id + ", "+ this.nombre+ ", " + this.horarioApertura+ ", " + this.horarioCierre+ ", " + this.estado;
	}

}
