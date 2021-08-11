package tp.dominio;

import java.sql.Timestamp;

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
	
	public static String getHoraString(Timestamp ts) {
		String ret = "";
		long aux = ts.getTime()%86400;
		long hora = aux/3600;
		long min = (aux%3600)/60;
		System.out.println(hora);
		if(hora < 10) { ret +='0'; ret+=(char)(hora+'0');}
		else {ret += (char)((hora/10)+'0'); ret += (char)((hora%10)+'0');}
		ret+=':';
		if(min < 10) { ret +='0'; ret+=(char)(min+'0');}
		else {ret += (char)((min/10)+'0'); ret += (char)((min%10)+'0');}
		return ret;
	}
	
	public static void main(String[] args) {
	}
	
}
