package tp.dominio;

import java.sql.Time;
import java.util.*;

public class PageRank {
	public ArrayList<Pair> getRank(ArrayList<Estacion> estaciones) {
		//obtengo el grafo
				GenerarGrafo aux = new GenerarGrafo();
				ArrayList<ArrayList<Ruta>> grafo = aux.getGrafo();
				
				// inicializo pagerank en 0
				int N=grafo.size();
				int[] pageRank = new int[N];
				for(int i=0; i<N; i++) pageRank[i]=0;
				//actualizo pagerank segun corresponda
				for(int i=0; i<N;i++) for(Ruta r : grafo.get(i)) pageRank[r.getDestino().getId()-1]++;
//				System.out.println("PAGE RANK");
//				for(int i=0; i<N;i++) {
//					System.out.println(pageRank[i]);
//				}
				ArrayList<Pair> pRank= new ArrayList<Pair>();
				for(Estacion e : estaciones) pRank.add(new Pair(pageRank[e.getId()-1], e));
				//printeo estaciones por indice
//				System.out.println(" SIN ORDENAR ");
//				for(Pair p : pRank) 	System.out.println(p.first + " " + p.second.getId());
				//ordeno
				pRank.sort((o1,o2) -> o1.comparator(o1,o2));
		return pRank;
	}
	public static void main(String[] args) {
		//aca deberia pedir las estaciones
	}
}
