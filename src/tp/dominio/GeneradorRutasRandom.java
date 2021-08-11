package tp.dominio;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

public class GeneradorRutasRandom {
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
	public static void main(String[] args) {
		
		ArrayList<Linea> lineas = new ArrayList<Linea>(); // pedir a la BD que me de todas las lineas 
		
		//genero 2 lineas
		lineas.add(new Linea("linea 1", "azul", true));
		lineas.add(new Linea("linea 2", "verde", true));
		lineas.add(new Linea("linea 3", "roja", true));
		
		//genero 8 estaciones
		ArrayList<Estacion> e = new ArrayList<Estacion>();
		for(int i=0; i<8; i++) {
			Timestamp time1 = new Timestamp(System.currentTimeMillis());
			Timestamp time2 = new Timestamp(System.currentTimeMillis()+60000);
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
				Ruta ruta = new Ruta(e.get(ix), e.get(ix2), dist,t1,mxp,true,rint(100), cnt);      
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
			if(l.getEstado2()) { // si la linea esta activa
				ArrayList<Ruta> recorrido = l.getRecorrido();
				Boolean activas = true; // rutas y estaciones activas?
				for(Ruta r : recorrido) {
					activas&=r.getEstado2();
					activas&=r.getOrigen().getEstado2();
					activas&=r.getDestino().getEstado2();
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
		return;
		}
}
