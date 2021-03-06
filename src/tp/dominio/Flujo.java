package tp.dominio;

import java.util.*;


public class Flujo {
	
	public static ArrayList<ArrayList<Ruta>> grafoValido(int src, ArrayList<ArrayList<Ruta>> grafo){
		int N = grafo.size();
		ArrayList<ArrayList<Ruta>> ret = new ArrayList<ArrayList<Ruta>>();
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(src);
		Boolean[] visited = new Boolean[N];
		for(int i=0; i<N; i++) visited[i] = false;
		for(int i=0; i<N; i++) ret.add(new ArrayList<Ruta>());
		visited[src] = true;
		while(!q.isEmpty()) {
			int aux = q.getLast();
			q.pollLast();
			for(Ruta nxt : grafo.get(aux)) ret.get(aux).add(nxt);
			for(Ruta nxt : grafo.get(aux)) {
				if(!visited[nxt.getDestino().getId()]) {
					visited[nxt.getDestino().getId()] = true;
					q.push(nxt.getDestino().getId());
				}
			}
		}
		return ret;
	}
	
	
	public static long maxFlow(int src, int snk, ArrayList<ArrayList<Ruta>> grafo) {
		int N = grafo.size();
		int f, Mf = 0;
		int INF = 100000000; 
		int SRC = N, SNK = N+1;
		N+=2;
		int[] p = new int[N];
		for(int i = 0; i<N; i++) p[i] = 0; // el +2 de los nuevos nodos
		grafo.add(new ArrayList<Ruta>()); // agrego nodo SRC
		grafo.add(new ArrayList<Ruta>()); // agrego nodo SNK
		Estacion e = new Estacion(src, null, null, null, true);
		grafo.get(SRC).add(new Ruta(e, INF));
		Estacion e2 = new Estacion(SNK, null, null, null, true);
		grafo.get(snk).add(new Ruta(e2, INF));
		do {
			f=0;
			Boolean[] used = new Boolean[N];
			for(int i=0; i<N; i++) used[i] = false;
			LinkedList<Integer> q = new LinkedList<Integer>();
			q.add(SRC);
			for(int i = 0; i<N; i++) p[i] = -1;
			while(!q.isEmpty()) {
				int u = q.getLast();
				q.pollLast();
				if(u==SNK) break;
				for(Ruta r : grafo.get(u)) {
					if(r.getDato(3) > 0 && !used[r.getDestino().getId()]) {
						used[r.getDestino().getId()] = true;
						q.push(r.getDestino().getId());
						p[r.getDestino().getId()] = u;
					}
				}
			}
			class Local{
				int f;
				public void aumentar(int v, int minE){
					if(v==SRC) f=minE;
					else if(p[v] != -1) {
						int index = 0;
						for(Ruta r : grafo.get(p[v])) {
							if(r.getDestino().getId() != v) index++;
							else break;
						}
						if(index == grafo.get(p[v]).size()) {
							Estacion est = new Estacion(v, null, null, null, true);
							grafo.get(p[v]).add(new Ruta(est, 0));
						}
						aumentar(p[v], Math.min(minE, grafo.get(p[v]).get(index).getMaxPasajeros()));
						grafo.get(p[v]).get(index).changeFlow(-f);
						index = 0;
						for(Ruta r : grafo.get(v)) {
							if(r.getDestino().getId() != p[v]) index++;
							else break;
						}
						if(index == grafo.get(v).size()) {
							Estacion est = new Estacion(p[v], null, null, null, true);
							grafo.get(v).add(new Ruta(est, 0));
						}
						grafo.get(v).get(index).changeFlow(f);	
					}
				}
			}
			Local aux = new Local();
			aux.f = f;
			aux.aumentar(SNK, INF);
			Mf+=aux.f;
			f=aux.f;
		} while(f > 0);
		return Mf;
	}
	
	public long getMaxFlow(int src, int snk, ArrayList<ArrayList<Ruta>> grafo) {

		return maxFlow(src,snk, grafoValido(src, grafo));
	}
	
	public static void main(String[] args) {
		GenerarGrafo aux = new GenerarGrafo();
		ArrayList<ArrayList<Ruta>> grafo = aux.getGrafo();
		int N = grafo.size();
		System.out.println("Cant nodos " + N);
		for(int i=0; i<N; i++) {
			System.out.println("Aristas salientes del nodo " + i);
			for(Ruta j : grafo.get(i)) {
				System.out.println("Edge to " + j.getDestino().getId() + " dist:" + j.getDato(1) + " tiempo:" + j.getDato(0) + " costo:" + j.getDato(2) + " maxFlow:" + j.getDato(3));
			}          
		}
		ArrayList<ArrayList<Ruta>> grafoBFS = grafoValido(0, grafo);
		System.out.println(" Grafo BFSeado");
		for(int i=0; i<N; i++) {
			System.out.println("Aristas salientes del nodo " + i);
			for(Ruta j : grafoBFS.get(i)) {
				System.out.println("Edge to " + j.getDestino().getId() + " dist:" + j.getDato(1) + " tiempo:" + j.getDato(0) + " costo:" + j.getDato(2) + " maxFlow:" + j.getDato(3));
			} 
		}
		// con un BFS obtengo todos los Edges validos
		System.out.println(maxFlow(0, 2, grafoBFS));
		//pruebo algo
	}
}
