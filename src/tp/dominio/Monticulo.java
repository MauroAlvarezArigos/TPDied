package tp.dominio;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Monticulo {
	public static Estacion ultMantenimiento(ArrayList<Estacion> estaciones) {
		PriorityQueue<Estacion> pq = new PriorityQueue<Estacion>((x,y)->Estacion.compare(x,y));
		int N = estaciones.size();
//		ArrayList<Estacion> estaciones = new ArrayList<Estacion>();
//		//genero 6 estaciones
//		Time time1 = new Time(System.currentTimeMillis());
//		Time time2 = new Time(System.currentTimeMillis()+60000);
//		estaciones.add(new Estacion(0, "Est 0", time1, time2, true));
//		estaciones.add(new Estacion(1, "Est 1", time1, time2, true));
//		estaciones.add(new Estacion(2, "Est 2", time1, time2, true));
//		estaciones.add(new Estacion(3, "Est 3", time1, time2, true));
//  	for(int i=0; i<N; i++) estaciones.get(i).setUltimoMantenimiento(new Time(System.currentTimeMillis()+70000*i));
		
		for(int i=0; i<N; i++) pq.add(estaciones.get(i));
		//System.out.println(pq.remove());
//		while(!pq.isEmpty()) {
//			Estacion aux = pq.remove();
//			System.out.println(aux.getUltimoMantenimiento());
//		}
		return pq.remove();
	}
	
	public static void main(String[] args) {
	}
}
