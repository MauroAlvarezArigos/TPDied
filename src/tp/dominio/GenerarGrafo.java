package tp.dominio;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public class GenerarGrafo {
	
	public static Boolean isNumber(char x) {
		if(x >= '0' && x<='9') return true;
		return false;
	}
	
	public static Timestamp getFormato(String s) {
		
		Timestamp ts = new Timestamp(0); 
		Boolean valid = true;
		if(s.length() != 5) return null;
		for(int i=0; i<5; i++) {
			if(i!=2) valid &= isNumber(s.charAt(0));
		}
		if(s.charAt(2) != ':') valid&=false;
		if(!valid) return null;
		long segxmin = 60000;
		long hora = (s.charAt(0)-'0')*10 + s.charAt(1)-'0';
		long min = (s.charAt(3)-'0')*10 + s.charAt(4)-'0';
		ts.setTime((long) segxmin * 60 * 3 + (long) segxmin * min + hora*segxmin*60); 
		return ts;
	}
	
	
	public ArrayList<ArrayList<Ruta>> getGrafo(){
		ArrayList<Linea> lineas = new ArrayList<Linea>(); // pedir a la BD que me de todas las lineas 
		//genero 3 lineas
		lineas.add(new Linea("linea 1", "azul", true));
		lineas.add(new Linea("linea 2", "verde", true));
		lineas.add(new Linea("linea 3", "roja", true));
		ArrayList<Estacion> estaciones = new ArrayList<Estacion>();
		//genero 6 estaciones
		Timestamp time1 = new Timestamp(System.currentTimeMillis());
		Timestamp time2 = new Timestamp(System.currentTimeMillis()+60000);
		estaciones.add(new Estacion(0, "Est 0", time1, time2, true));
		estaciones.add(new Estacion(1, "Est 1", time1, time2, true));
		estaciones.add(new Estacion(2, "Est 2", time1, time2, true));
		estaciones.add(new Estacion(3, "Est 3", time1, time2, true));
		estaciones.add(new Estacion(4, "Est 4", time1, time2, true));
		estaciones.add(new Estacion(5, "Est 5", time1, time2, true));
		ArrayList<Ruta> recorridoLinea = new ArrayList<Ruta>();
		//relleno 3 lineas con rutas
		recorridoLinea.add(new Ruta(estaciones.get(4), estaciones.get(3), 85, 69,10,true,23,0));
		recorridoLinea.add(new Ruta(estaciones.get(3), estaciones.get(0), 61, 41,15,true,45,1));
		recorridoLinea.add(new Ruta(estaciones.get(0), estaciones.get(2), 67, 91,25,true,30,2));
		lineas.get(0).setRecorrido(recorridoLinea);
		recorridoLinea.clear();
		recorridoLinea.add(new Ruta(estaciones.get(0), estaciones.get(3), 96, 28,20,true,63,0));
		recorridoLinea.add(new Ruta(estaciones.get(3), estaciones.get(5), 36, 12,25,true,15,1));
		recorridoLinea.add(new Ruta(estaciones.get(5), estaciones.get(2), 55, 31,19,true,10,2));
		lineas.get(1).setRecorrido(recorridoLinea);
		recorridoLinea.clear();
		recorridoLinea.add(new Ruta(estaciones.get(1), estaciones.get(4), 73, 53,20,true,31,0));
		recorridoLinea.add(new Ruta(estaciones.get(4), estaciones.get(5), 65, 96,17,true,49,1));
		recorridoLinea.add(new Ruta(estaciones.get(5), estaciones.get(3), 40, 52,22,true,29,2));
		lineas.get(2).setRecorrido(recorridoLinea);
		int N = 1;
		for(Linea l :lineas) {
			ArrayList<Ruta> recorrido = l.getRecorrido();
			for(Ruta r : recorrido) {
				N = Math.max(N, r.getOrigen().getId()+1);
				N = Math.max(N, r.getDestino().getId()+1);
			}
		}
		ArrayList<ArrayList<Ruta>> grafo = new ArrayList<ArrayList<Ruta>>();
		for(int i=0; i<N; i++) grafo.add(new ArrayList<Ruta>());
		for(Linea l : lineas) {
			if(l.getEstado2()) { // si la linea esta activa
				ArrayList<Ruta> recorrido = l.getRecorrido();
				Boolean activas = true; // rutas y estaciones activas?
				for(Ruta r : recorrido) {
					activas&=r.getEstado2();
					activas&=r.getOrigen().getEstado2();
					activas&=r.getDestino().getEstado2();
				}
				if(!activas) continue;
				for(Ruta r : recorrido) grafo.get(r.getOrigen().getId()).add(r);
			}
		}
		return grafo;
	}
	
	public static void main(String[] args) {
		Timestamp ts = getFormato("12:30");
	}
}
