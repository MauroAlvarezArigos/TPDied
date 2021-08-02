package tp.dominio;

import java.time.LocalTime;
import java.util.ArrayList;

public class PruebaFlujo {
	
	public ArrayList<ArrayList<Ruta>> grafoValido(ArrayList<ArrayList<Ruta>> grafo){
		ArrayList<ArrayList<Ruta>> ret = new ArrayList<ArrayList<Ruta>>();
		
		
		return ret;
	}
	
	public static void main(String[] args) {
		ArrayList<Linea> lineas = new ArrayList<Linea>(); // pedir a la BD que me de todas las lineas 
		//genero 3 lineas
		lineas.add(new Linea("linea 1", "azul", true));
		lineas.add(new Linea("linea 2", "verde", true));
		lineas.add(new Linea("linea 3", "roja", true));
		ArrayList<Estacion> estaciones = new ArrayList<Estacion>();
		//genero 6 estaciones
		LocalTime time1 = LocalTime.now();
		LocalTime time2 = LocalTime.now();
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
		
		// con un BFS obtengo todos los Edges validos
	}
}
