package tp.dominio;

import java.sql.Time;
import java.util.*;

public class PageRank {
	public ArrayList<Dpair> getRank(ArrayList<Estacion> estaciones) {
		//obtengo el grafo
				GenerarGrafo aux = new GenerarGrafo();
				ArrayList<ArrayList<Ruta>> grafo = aux.getGrafo();
				
				// inicializo pagerank en 0
				int N=1;
				for(Estacion e : estaciones) 	N = Math.max(N, e.getId()+1);
				Boolean[] exist = new Boolean[N];
				for(int i=0; i<N; i++) exist[i] = false;
				for(Estacion e : estaciones) exist[e.getId()-1]=true;
				int[] cant = new int[N]; // cantidad de nodos en los que incido
				double[] pr = new double[N]; // page rank actual
				double[] nextpr = new double[N]; // page rank futuro
				for(int i=0; i<N; i++) cant[i]=0;
				//actualizo pagerank segun corresponda
				for(int i=0; i<grafo.size();i++) for(Ruta r : grafo.get(i)) {
					if(exist[r.getOrigen().getId()-1] && exist[r.getDestino().getId()-1]) {
						cant[r.getOrigen().getId()-1]++;
					}
				}
				
				for(int i=0; i<N; i++) pr[i] = 1;
				for(int i=0; i<N; i++) nextpr[i]=1;
//				for(int i=0; i<N; i++) System.out.println("CANT " + i + " " + cant[i]);
//				for(int i=0;i<grafo.size();i++) {
//					for(Ruta r : grafo.get(i)) {
//						System.out.println("RUTA FROM " + r.getOrigen().getId() + " to " + r.getDestino().getId());
//					}	
//				}
				int iteraciones = 0;
				while(iteraciones++ < 100) {
					for(int i=0;i<grafo.size();i++) {
						for(Ruta r : grafo.get(i)) {
							if(exist[r.getOrigen().getId()-1] && exist[r.getDestino().getId()-1]) {
								nextpr[r.getDestino().getId()-1] += pr[r.getOrigen().getId()-1]/cant[r.getOrigen().getId()-1];
								nextpr[r.getOrigen().getId()-1] -= pr[r.getOrigen().getId()-1]/cant[r.getOrigen().getId()-1];
							}
						}	
					}
					for(int i=0; i<N; i++) pr[i] = nextpr[i];
//					double sum = 0;
//					for(int i=0; i<N; i++) {
//						System.out.println("PR est " + i + " " + pr[i]);
//						sum+=pr[i];
//					}
//					System.out.println(sum);
				}
				double div = 0;
				for(int i=0; i<N; i++) if(exist[i]) div+=1;
//				for(int i=0; i<N; i++) {
//					System.out.println("Estacion " + i + " :" + (100/div)*pr[i]);
//				}
				ArrayList<Dpair> pRank= new ArrayList<Dpair>();
				for(Estacion e : estaciones) pRank.add(new Dpair((100/div * pr[e.getId()-1]), e));
//				printeo estaciones por indice
//				System.out.println(" SIN ORDENAR ");
//				for(Pair p : pRank) 	System.out.println(p.first + " " + p.second.getId());
//				ordeno
				pRank.sort((o1,o2) -> o1.comparator(o1,o2));
		return pRank;
	}
	public static void main(String[] args) {
		//aca deberia pedir las estaciones
	}
}
