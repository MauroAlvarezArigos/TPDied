package tp.dominio;

import java.awt.List;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;



public class PruebaGrafos {
	
	public static int rint(int mod) {
		int ret = (int)(Math.random()*1000);
		return ret%mod;
	}
	public static double rdb(int mod) {
		double ret = Math.random()*100 % mod;
		return ret;
	}
	public static long dijsktra(int src, int to, int tipo, ArrayList<ArrayList<Edge>> grafo, int N) {
		long INF = 100000009; // me gustaria que sea const, averiguar si se puede. no me deja static
		long[] dist = new long[N];
		for(int i=0; i<N; i++) dist[i] = INF;
		PriorityQueue<long[]> pq = new PriorityQueue<long[]>((x,y)->Long.compare(x[1], y[1]));
		dist[src] = 0;
		pq.add(new long[] {src,0});
		while(!pq.isEmpty())
		{
			long[] cur = pq.remove();
			int node=(int)cur[0];
			long cost=cur[1];
			if(cost > dist[node]) 			//lazy deletion
				continue;
			for(int[] nxt: grafo[node])
				if(cost + nxt[1] < dist[nxt[0]])
					pq.add(new long[] {nxt[0], dist[nxt[0]] = cost + nxt[1] });
		}
		return dist[to];
	}
	
//	
//	long dijkstra(int s, int t){//O(|E| log |V|)
//		static int INF = 1000000009;
//		priority_queue<ii, vector<ii>, greater<ii> > Q;
//		long[] dist = new long[N]; // setear a inf
//		
//		vector<int> dad(N, -1);
//		Q.push(make_pair(0, s)); dist[s] = 0;
//		while(sz(Q)){
//			ii p = Q.top(); Q.pop();
//			if(p.snd == t) break;
//			forall(it, G[p.snd])
//				if(dist[p.snd]+it->first < dist[it->snd]){
//					dist[it->snd] = dist[p.snd] + it->fst;
//					dad[it->snd] = p.snd;
//					Q.push(make_pair(dist[it->snd], it->snd));	}
//		}
//		return dist[t];
//		if(dist[t]<INF)//path generator
//			for(int i=t; i!=-1; i=dad[i])
//				printf("%d%c", i, (i==s?'\n':' '));}
	
	
	public static void main(String[] args) {
		
		
		
		//esto hay que moverlo
		//Map<Integer, ArrayList<Ruta>> grafo = new HashMap<Integer, ArrayList<Ruta>>();
		// con cada linea reconstruimos el grafo
		ArrayList<Linea> lineas = new ArrayList<Linea>(); // pedir a la BD que me de todas las lineas 
		
		//genero 2 lineas
		Linea l1 = new Linea("linea 1", "azul", true);
		Linea l2 = new Linea("linea 2", "rojo", true);
		
		//genero 8 estaciones
		ArrayList<Estacion> e = new ArrayList<Estacion>();
		for(int i=0; i<8; i++) {
			LocalTime time1 = LocalTime.now();
			LocalTime time2 = LocalTime.now();
			String aux = "est ";
			aux = aux+(char)(i+'0');
			Estacion est = new Estacion(i, aux, time1, time2, "op");
			e.add(est);
		}
		for(int i=0; i<8;i++) System.out.println("estacion " + e.get(i).getId());
		//genero ? rutas
		ArrayList<Ruta> rutas = new ArrayList<Ruta>();
		for(int i=0; i<8; i++) {
			int dist = rint(100),t1=rint(100), mxp = rint(100);
			int ix = rint(8), ix2 = rint(8);
			if(ix == ix2) ix2 = (ix2+1)%8;
			if(rint(2) > 0) {
				int aux = ix2;
				ix2 = ix;
				ix = aux;
			}
			Ruta ruta = new Ruta(e.get(ix), e.get(ix2), dist,t1,mxp,true,rint(100));      
			//System.out.println( ruta.getOrigen().getId() + " " + ruta.getDestino().getId());
			rutas.add(ruta);
		}
		ArrayList<Ruta> aux = new ArrayList<Ruta>();
		for(int i=0; i<5; i++) aux.add(rutas.get(rint(8)));
		//for(int i=0; i<5; i++) System.out.println("Estacion de ruta " + aux.get(i).getOrigen().getId());
		l1.setRecorrido(aux);
		
		aux.clear();
		for(int i=0; i<5; i++) aux.add(rutas.get(rint(8)));
		l2.setRecorrido(aux);
		lineas.add(l1); lineas.add(l2);
		
		int N = 1;
		for(Linea l :lineas) {
			ArrayList<Ruta> recorrido = l.getRecorrido();
			for(Ruta r : recorrido) {
				N = Math.max(N, r.getOrigen().getId()+1);
				N = Math.max(N, r.getDestino().getId()+1);
			}
		}
		ArrayList<ArrayList<Edge>> grafo = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<N; i++) grafo.add(new ArrayList<Edge>());
		 
		for(Linea l : lineas) {
			ArrayList<Ruta> recorrido = l.getRecorrido();
			for(Ruta r : recorrido) {
				//System.out.println(r.getOrigen().getId());
				Edge edgeDestino = new Edge(r, false);
				grafo.get(r.getOrigen().getId()).add(edgeDestino);
				Edge edgeOrigen = new Edge(r, true);
				grafo.get(r.getOrigen().getId()).add(edgeOrigen);
			}
		}
		System.out.println("Cant nodos " + N);
		for(int i=0; i<N; i++) {
			for(Edge j : grafo.get(i)) {
				System.out.println("Edge " + j.getDestino() + "  " + j.getDato(0) + " " + j.getDato(1));
			}          
		}
		//hay que controlar los multiedges? eso agrega complejidad n^2, puedo hacer nlogn tb y se amortiza con dijk
		
		
		//sig paso armar el dijkstra :)
		
//		
//		long dijkstra(int s, int t){//O(|E| log |V|)
//			static int INF = 1000000009;
//			priority_queue<ii, vector<ii>, greater<ii> > Q;
//			long[] dist = new long[N]; // setear a inf
//			
//			vector<int> dad(N, -1);
//			Q.push(make_pair(0, s)); dist[s] = 0;
//			while(sz(Q)){
//				ii p = Q.top(); Q.pop();
//				if(p.snd == t) break;
//				forall(it, G[p.snd])
//					if(dist[p.snd]+it->first < dist[it->snd]){
//						dist[it->snd] = dist[p.snd] + it->fst;
//						dad[it->snd] = p.snd;
//						Q.push(make_pair(dist[it->snd], it->snd));	}
//			}
//			return dist[t];
//			if(dist[t]<INF)//path generator
//				for(int i=t; i!=-1; i=dad[i])
//					printf("%d%c", i, (i==s?'\n':' '));}
	}
}
