package tp.dominio;

public class ComboItem {
	
	Estacion estacion;
	String nombre;
	
	public ComboItem(Estacion e, String s) {
		this.estacion=e;
		this.nombre=s;
	}
	
	public String toString() { 
		return this.nombre;
	}
	public Estacion getItem() {
		return this.estacion;
	}
	
	
}
