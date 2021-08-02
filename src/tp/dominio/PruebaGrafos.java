package tp.dominio;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;



public class PruebaGrafos {
	
	public static int rint(int mod) {
		long x = System.nanoTime();
		x ^= (x << 21);
		x ^= (x >>> 35);
		x ^= (x << 4);
		return ((int)x%mod+mod)%mod; // XORshift random, porque el random de java no es muy bueno
	}
	public static double rdb(int mod) {
		double ret = Math.random()*100 % mod;
		return ret;
	}
	public static long dijkstra(int src, int to, int tipo, ArrayList<ArrayList<Ruta>> grafo, int N) {
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
		if(dist[to] < INF) {
			long costoTotal = (long)0;
			int actual = to;
			while(dad[actual] != null) {
				camino.add(dad[actual]);
				actual = dad[actual].getOrigen().getId();
			}
			//tengo que imprimir la ruta al reves
			Collections.reverse(camino);
			System.out.println("Imprimo el camino de " + src + " to " + to);
			for(Ruta r : camino) {
				costoTotal += r.getCosto();
				System.out.println(r.getOrigen().getId() + " " + r.getDestino().getId());
			}
			System.out.println("El costo total es " + costoTotal);
		}
		else 	System.out.println("La estacion " + to + " es inalcanzable desde " + src);
		return dist[to];
	}
	
//	
//		if(dist[t]<INF)//path generator
//			for(int i=t; i!=-1; i=dad[i])
//				printf("%d%c", i, (i==s?'\n':' '));}
	
	
	public static void main(String[] args) {
		
		//for(int i=0; i<30; i++) System.out.print(rint(8) + " ");
		
		
		//esto hay que moverlo
		//Map<Integer, ArrayList<Ruta>> grafo = new HashMap<Integer, ArrayList<Ruta>>();
		// con cada linea reconstruimos el grafo
		ArrayList<Linea> lineas = new ArrayList<Linea>(); // pedir a la BD que me de todas las lineas 
		
		//genero 2 lineas
		lineas.add(new Linea("linea 1", "azul", true));
		lineas.add(new Linea("linea 2", "verde", true));
		lineas.add(new Linea("linea 3", "roja", true));
		
		//genero 8 estaciones
		ArrayList<Estacion> e = new ArrayList<Estacion>();
		for(int i=0; i<8; i++) {
			LocalTime time1 = LocalTime.now();
			LocalTime time2 = LocalTime.now();
			String aux = "est ";
			aux = aux+(char)(i+'0');
			Estacion est = new Estacion(i, aux, time1, time2, true);
			e.add(est);
		}
		
		//nuevo generador
		ArrayList<Ruta> aux = new ArrayList<Ruta>();
		
		for(int i=0; i<3; i++) {
			aux.clear();
			int cnt = 0;
			int ix = -1;
			Boolean[] used = new Boolean[8];
			for(int j=0; j<8; j++) used[j]=false;
			while(cnt < 3) {
				int dist = rint(100),t1=rint(100), mxp = rint(100);
				if(ix == -1) ix = rint(8);
				used[ix]=true;
				System.out.print(" ");
				int ix2 = rint(8);
				while(used[ix2] == true) ix2=rint(8);
				System.out.print(ix + " " + ix2 + " ");
				Ruta ruta = new Ruta(e.get(ix), e.get(ix2), dist,t1,mxp,true,rint(100));      
				System.out.println("Ruta numero " + i + " " + ruta.getOrigen().getId() + " " + ruta.getDestino().getId());
				aux.add(ruta);
				cnt++;
				ix = ix2; 
			}
			lineas.get(i).setRecorrido(aux);
		}
		
		
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
				System.out.println("Edge to " + j.getDestino().getId() + " tiempo " + j.getDato(0) + " dist " + j.getDato(1));
			}          
		}
		//hay que controlar los multiedges? eso agrega complejidad n^2, puedo hacer nlogn tb y se amortiza con dijk
		
		//sig paso armar el dijkstra :)
		for(int i=0; i<N; i++) {
			if(grafo.get(i).size() > 0) {
				System.out.println("Dijkstra para el nodo (por tiempo) " + i);
				for(int j=0; j<N;j++) if(j!=i) System.out.println("To " + j + " dist " + dijkstra(i,j,0,grafo,N));
				System.out.println("Dijkstra para el nodo (por dist) " + i);
				for(int j=0; j<N;j++) if(j!=i) System.out.println("To " + j + " dist " + dijkstra(i,j,1,grafo,N));
				break;
			}
		}
//		
	}
}
