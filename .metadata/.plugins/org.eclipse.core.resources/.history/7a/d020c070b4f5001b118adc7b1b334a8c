package tp.dominio;

import java.sql.Time;
import java.util.*;

public class PageRank {
	public static void main(String[] args) {
		//aca deberia pedir las estaciones
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
		
		//obtengo el grafo
		GenerarGrafo aux = new GenerarGrafo();
		ArrayList<ArrayList<Ruta>> grafo = aux.getGrafo();
		
		// inicializo pagerank en 0
		int N=grafo.size();
		int[] pageRank = new int[N];
		for(int i=0; i<N; i++) pageRank[i]=0;
		
		//actualizo pagerank segun corresponda
		for(int i=0; i<N;i++) for(Ruta r : grafo.get(i)) pageRank[r.getDestino().getId()]++;
		ArrayList<Pair> pRank= new ArrayList<Pair>();
		for(Estacion e : estaciones) pRank.add(new Pair(pageRank[e.getId()], e));
		
		//printeo estaciones por indice
		System.out.println(" SIN ORDENAR ");
		for(Pair p : pRank) 	System.out.println(p.first + " " + p.second.getId());
		//ordeno
		pRank.sort((o1,o2) -> o1.comparator(o1,o2));
		//printeo las estaciones x pagerank
		System.out.println(" ORDENADO ");
		for(Pair p : pRank) System.out.println(p.first + " " + p.second.getId() + " " + p.second.getNombre());
 	}
}
