package tp.dominio;

import java.sql.Time;
import java.util.*;

public class PageRank {
	public static void main(String[] args) {
		ArrayList<Linea> lineas = new ArrayList<Linea>(); // pedir a la BD que me de todas las lineas 
		//genero 3 lineas
		lineas.add(new Linea("linea 1", "azul", true));
		lineas.add(new Linea("linea 2", "verde", true));
		lineas.add(new Linea("linea 3", "roja", true));
		ArrayList<Estacion> estaciones = new ArrayList<Estacion>();
		//genero 6 estaciones
		Time time1 = new Time(System.currentTimeMillis());
		Time time2 = new Time(System.currentTimeMillis()+60000);
		estaciones.add(new Estacion(0, "Est 0", time1, time2, true));
		estaciones.add(new Estacion(1, "Est 1", time1, time2, true));
		estaciones.add(new Estacion(2, "Est 2", time1, time2, true));
		estaciones.add(new Estacion(3, "Est 3", time1, time2, true));
		estaciones.add(new Estacion(4, "Est 4", time1, time2, true));
		estaciones.add(new Estacion(5, "Est 5", time1, time2, true));
		ArrayList<Ruta> recorridoLinea = new ArrayList<Ruta>();
		//relleno 3 lineas con rutas
		recorridoLinea.add(new Ruta(estaciones.get(4), estaciones.get(3), 85, 69,10,true,23));
		recorridoLinea.add(new Ruta(estaciones.get(3), estaciones.get(0), 61, 41,15,true,45));
		recorridoLinea.add(new Ruta(estaciones.get(0), estaciones.get(2), 67, 91,25,true,30));
		lineas.get(0).setRecorrido(recorridoLinea);
		recorridoLinea.clear();
		recorridoLinea.add(new Ruta(estaciones.get(0), estaciones.get(3), 96, 28,20,true,63));
		recorridoLinea.add(new Ruta(estaciones.get(3), estaciones.get(5), 36, 12,25,true,15));
		recorridoLinea.add(new Ruta(estaciones.get(5), estaciones.get(2), 55, 31,19,true,10));
		lineas.get(1).setRecorrido(recorridoLinea);
		recorridoLinea.clear();
		recorridoLinea.add(new Ruta(estaciones.get(1), estaciones.get(4), 73, 53,20,true,31));
		recorridoLinea.add(new Ruta(estaciones.get(4), estaciones.get(5), 65, 96,17,true,49));
		recorridoLinea.add(new Ruta(estaciones.get(5), estaciones.get(3), 40, 52,22,true,29));
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
		int[] pageRank = new int[N];
		for(int i=0; i<N; i++) pageRank[i]=0;
		for(Linea l : lineas) {
			ArrayList<Ruta> recorrido = l.getRecorrido();
			for(Ruta r : recorrido) {
				pageRank[r.getDestino().getId()]++;
			}
		}
		ArrayList<Pair> pRank= new ArrayList<Pair>();
		for(Estacion e : estaciones) pRank.add(new Pair(pageRank[e.getId()], e));
		System.out.println(" SIN ORDENAR ");
		for(Pair p : pRank) {
			System.out.println(p.first + " " + p.second.getId());
		}
		pRank.sort((o1,o2) -> o1.comparator(o1,o2));
		System.out.println(" ORDENADO ");
		for(Pair p : pRank) {
			System.out.println(p.first + " " + p.second.getId() + " " + p.second.getNombre());
		}
 	}
}