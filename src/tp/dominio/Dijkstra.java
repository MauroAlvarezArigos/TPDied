package tp.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class Dijkstra {
	private static ArrayList<String> caminoUsado;
	public Pair getDijkstra(int src, int to, int tipo, ArrayList<ArrayList<Ruta>> grafo, int N) {

		long INF = 100000009; // me gustaria que sea const, averiguar si se puede. no me deja static
		long[] dist = new long[N];
		Ruta[] dad = new Ruta[N];
		for(int i=0; i<N; i++) dist[i] = INF;
		PriorityQueue<long[]> pq = new PriorityQueue<long[]>((x,y)->Long.compare(x[1], y[1]));
		dist[src] = 0;
		dad[src]=null;
		pq.add(new long[] {src,0});
		while(!pq.isEmpty())
		{
			long[] cur = pq.remove();
			int node=(int)cur[0];
			long cost=cur[1];
			if(cost > dist[node]) continue;
			for(Ruta nxt: grafo.get(node)) {
				if(cost + nxt.getDato(tipo) < dist[nxt.getDestino().getId()]) {
					dad[nxt.getDestino().getId()] = nxt;
					pq.add(new long[] {nxt.getDestino().getId(), dist[nxt.getDestino().getId()] = cost + nxt.getDato(tipo) });
				}
			}
		}
		
		//descomentar esto para obtener el recorrido
		ArrayList<Ruta> camino = new ArrayList<Ruta>();
		long costoTotal;
		if(dist[to] < INF) {
			costoTotal = (long)0;
			int actual = to;
			while(dad[actual] != null) {
				camino.add(dad[actual]);
				actual = dad[actual].getOrigen().getId();
			}
			//tengo que imprimir la ruta al reves
			Collections.reverse(camino);
			for(Ruta r: camino) {
				System.out.println("TRAMO " + r.getOrigen().getNombre() + " " + r.getDestino().getNombre());
			}
			for(Ruta r : camino) costoTotal += r.getCosto();
			caminoUsado = new ArrayList<String>();
			String last = "";
			for(Ruta r : camino) {
				caminoUsado.add(r.getOrigen().getNombre());
				last = r.getDestino().getNombre();
			}
			caminoUsado.add(last);
			//System.out.println("El costo total es " + costoTotal);
		}
		else {
			costoTotal = INF;
			//System.out.println("La estacion " + to + " es inalcanzable desde " + src);
		}
		return new Pair(dist[to], costoTotal);
	}
	
	public  ArrayList<String> getCamino() {
		return caminoUsado;
	}
	
	public static void main(String[] args) {
		
		GenerarGrafo aux = new GenerarGrafo();
		ArrayList<ArrayList<Ruta>> grafo = aux.getGrafo();
		int N = grafo.size();
		
//		for(int i=0; i<N; i++) {
//			if(grafo.get(i).size() > 0) {
//				System.out.println("Dijkstra para el nodo (por tiempo) " + i);
//				for(int j=0; j<N;j++) if(j!=i) System.out.println("To " + j + " dist " + getDijkstra(i,j,0,grafo,N));
//				System.out.println("Dijkstra para el nodo (por dist) " + i);
//				for(int j=0; j<N;j++) if(j!=i) System.out.println("To " + j + " dist " + getDijkstra(i,j,1,grafo,N));
//				System.out.println("Dijkstra para el nodo (por costo) " + i);
//				for(int j=0; j<N;j++) if(j!=i) System.out.println("To " + j + " dist " + getDijkstra(i,j,2,grafo,N));
//				break;
//			}
//		}
//		
	}
}
