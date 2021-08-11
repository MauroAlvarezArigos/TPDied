package tp.dominio;

import java.util.ArrayList;

public class Linea {
	Integer id;
	String nombre;
	String color;
	Boolean estado; // 0 No activa, 1 Activa
	ArrayList<Ruta> recorrido = new ArrayList<Ruta>();
	
	//Constructor
	public Linea(Integer id, String nombre, String color, Boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.color = color;
		this.estado = estado;
	}
	
	public Linea () {
		
	}

	public ArrayList<Ruta> getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(ArrayList<Ruta> nuevoRecorrido) {
		this.recorrido.addAll(nuevoRecorrido);
	}

	//Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
