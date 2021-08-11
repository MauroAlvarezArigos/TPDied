package tp.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;

import tp.Excepciones.DatosObligatoriosException;
import tp.dominio.Boleto;
import tp.dominio.Estacion;
import tp.dominio.Ruta;
import tp.gui.BoletoGUI;
import tp.gui.RegistrarTrayectoGUI;
import tp.servicios.BoletoServicio;
import tp.servicios.EstacionServicio;

public class TrayectoController {
	private List<Estacion> lista;
	private EstacionServicio estacionServicio;
	private RegistrarTrayectoGUI registrartrayectogui;
	private Ruta r;
	private List<Ruta> rutas;
	private Set<Integer> usadas;
	private Integer orden = 0;
	private int lastAdded = -1;
	
	public TrayectoController(RegistrarTrayectoGUI t) {
		this.estacionServicio = new EstacionServicio();
		this.lista = new ArrayList<Estacion>();
		this.registrartrayectogui = t;
		this.rutas = new ArrayList<Ruta>();
		this.r = new Ruta();
		this.usadas = new HashSet<Integer>();
	}
	
	public void cargarEstaciones(){
		lista = estacionServicio.buscarTodas();
		
		JComboBox<Estacion> cbxOrigen = new JComboBox<Estacion>();
		JComboBox<Estacion> cbxDestino = new JComboBox<Estacion>();
		
		for(Estacion e : lista) cbxOrigen.addItem(e);
		for(Estacion e : lista) cbxDestino.addItem(e);
		
		
		registrartrayectogui.setCbxOrigen(cbxOrigen);
		registrartrayectogui.setCbxDestino(cbxDestino);
		
	}
	
	
	
	public void checkItem() throws DatosObligatoriosException{
		try {
			
			if(registrartrayectogui.getTbxCMPasajeros() != null && !registrartrayectogui.getTbxCMPasajeros().getText().equals("")) {
				r.setMaxPasajeros(Integer.parseInt(registrartrayectogui.getTbxCMPasajeros().getText()));
			}
			else {
				throw new DatosObligatoriosException("Cantidad Maxima de Pasajeros", "La Cantidad Maxima de Pasajeros es obligatoria");
			}
			
			if(registrartrayectogui.getTbxCosto() != null && !registrartrayectogui.getTbxCosto().getText().equals("")) {
				r.setCosto(Integer.parseInt(registrartrayectogui.getTbxCosto().getText()));
			}
			else {
				throw new DatosObligatoriosException("Costo", "El costo es obligatorio");
			}
			
			if(registrartrayectogui.getTbxDistancia() != null && !registrartrayectogui.getTbxDistancia().getText().equals("")) {
				r.setDistancia(Integer.parseInt(registrartrayectogui.getTbxDistancia().getText()));
			}
			else {
				throw new DatosObligatoriosException("Distancia", "La distancia es obligatoria");
			}
			
			if(registrartrayectogui.getTbxDurViaje() != null && !registrartrayectogui.getTbxDurViaje().getText().equals("")) {
				r.setTiempoViaje(Integer.parseInt(registrartrayectogui.getTbxDurViaje().getText()));
			}
			else {
				throw new DatosObligatoriosException("Tiempo viaje", "El tiempo de viaje es obligatorio");
			}
			
			if(registrartrayectogui.getCbxOrigen().getSelectedIndex() != registrartrayectogui.getCbxDestino().getSelectedIndex()) {
				Object aux = registrartrayectogui.getCbxOrigen().getSelectedItem();
				Estacion estOrigen = (Estacion) aux;
				Object aux2 = registrartrayectogui.getCbxDestino().getSelectedItem();
				Estacion estDestino = (Estacion) aux2;
				if(lastAdded != -1 && lastAdded != estOrigen.getId()) {
					throw new DatosObligatoriosException("trayecto continuo", "El trayecto tiene que continuar desde la ultima estacion");
				}
				if(usadas.contains(estDestino.getId())) {
					throw new DatosObligatoriosException("genero ciclo", "No se puede generar un trayecto que sea un ciclo");
				}
				usadas.add(estOrigen.getId());
				lastAdded = estDestino.getId();
				r.setOrigen(estOrigen);
				r.setDestino(estDestino);
				r.setOrden(orden);
				orden++;
			}
			else throw new DatosObligatoriosException("Origen es igual a destino", "El origen tiene que ser distinto del Destino");
			
		}
		catch(DatosObligatoriosException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public void agregarItem() throws DatosObligatoriosException{
		try {
			checkItem();
			Ruta auxRuta = new Ruta(r.getOrigen(), r.getDestino(), r.getDistancia(), r.getTiempoViaje(), r.getMaxPasajeros(), r.getEstado2(), r.getCosto(), r.getOrden());
			rutas.add(auxRuta);
//			for(int i = 0; i < rutas.size(); i++) {
//				System.out.println("AGREGOX " + rutas.get(i).getOrigen().getNombre() + " " + rutas.get(i).getDestino().getNombre()); 
//			}
//			System.out.println("AGREGO " + r.getOrigen().getNombre() + " " + r.getDestino().getNombre()); 
		}
		catch(DatosObligatoriosException e){
			e.printStackTrace();
			throw e;
		}
	}
	public void imprimir() {
		for(Ruta r : rutas) {
			System.out.println(r.getOrigen().getNombre() + " " + r.getDestino().getNombre());
		}
	}
}
