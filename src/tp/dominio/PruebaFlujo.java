package tp.dominio;

import java.sql.Time;
import java.util.*;


public class PruebaFlujo {
	
	public static ArrayList<ArrayList<Ruta>> grafoValido(int src, ArrayList<ArrayList<Ruta>> grafo,int N){
		ArrayList<ArrayList<Ruta>> ret = new ArrayList<ArrayList<Ruta>>();
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(src);
		Boolean[] visited = new Boolean[N];
		for(int i=0; i<N; i++) visited[i] = false;
		for(int i=0; i<N; i++) ret.add(new ArrayList<Ruta>());
		visited[src] = true;
		while(!q.isEmpty()) {
			int aux = q.getLast();
			System.out.println("Procesando " + aux);
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
	
	
	public static long maxFlow(int src, int snk, ArrayList<ArrayList<Ruta>> grafo, int N) {
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
					//System.out.println(" PROCESO " + u + " " + r.getDestino().getId() + " " + r.getDato(3));
					if(r.getDato(3) > 0 && !used[r.getDestino().getId()]) {
						//System.out.println("ENTRE " + r.getDestino().getId());
						used[r.getDestino().getId()] = true;
						q.push(r.getDestino().getId());
						p[r.getDestino().getId()] = u;
					}
				}
			}
			class Local{
				int f;
				public void aumentar(int v, int minE){
					//System.out.println("aumentar " + v + " " + minE + " " + f);
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
			//System.out.println("FIN " + f + " " + Mf);
		} while(f > 0);
		return Mf;
	}
	
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
		
		int N=6;
		ArrayList<ArrayList<Ruta>> grafo = new ArrayList<ArrayList<Ruta>>();
		for(int i=0; i<N; i++) grafo.add(new ArrayList<Ruta>());
		for(Linea l : lineas) {
			if(l.getEstado()) { // si la linea esta activa
				ArrayList<Ruta> recorrido = l.getRecorrido();
				Boolean activas = true; // rutas y estaciones activas?
				for(Ruta r : recorrido) {
					activas&=r.getEstado();
					activas&=r.getOrigen().getEstado();
					activas&=r.getDestino().getEstado();
				}
				if(!activas) continue;
				System.out.println("Rutas de " + l.getNombre());
				for(Ruta r : recorrido) {
					System.out.println("from " + r.getOrigen().getId() + " to " + r.getDestino().getId());
					grafo.get(r.getOrigen().getId()).add(r);
				}
			}
		}
		System.out.println("Cant nodos " + N);
		for(int i=0; i<N; i++) {
			System.out.println("Aristas salientes del nodo " + i);
			for(Ruta j : grafo.get(i)) {
				System.out.println("Edge to " + j.getDestino().getId() + " dist:" + j.getDato(1) + " tiempo:" + j.getDato(0) + " costo:" + j.getDato(2) + " maxFlow:" + j.getDato(3));
			}          
		}
		ArrayList<ArrayList<Ruta>> grafoBFS = grafoValido(0, grafo, N);
		System.out.println(" Grafo BFSeado");
		for(int i=0; i<N; i++) {
			System.out.println("Aristas salientes del nodo " + i);
			for(Ruta j : grafoBFS.get(i)) {
				System.out.println("Edge to " + j.getDestino().getId() + " dist:" + j.getDato(1) + " tiempo:" + j.getDato(0) + " costo:" + j.getDato(2) + " maxFlow:" + j.getDato(3));
			} 
		}
		// con un BFS obtengo todos los Edges validos
		System.out.println(maxFlow(0, 2, grafoBFS, N));
		//pruebo algo
	}
}