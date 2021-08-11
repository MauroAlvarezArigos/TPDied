package tp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import tp.dominio.Boleto;
import tp.dominio.Estacion;
import tp.gui.BoletoGUI;
import tp.gui.RegistrarTrayectoGUI;
import tp.servicios.BoletoServicio;
import tp.servicios.EstacionServicio;

public class TrayectoController {
	private List<Estacion> lista;
	private EstacionServicio estacionServicio;
	private RegistrarTrayectoGUI registrartrayectogui;
	
	public TrayectoController(RegistrarTrayectoGUI t) {
		this.estacionServicio = new EstacionServicio();
		this.lista = new ArrayList<Estacion>();
		this.registrartrayectogui = t;
		
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
}
