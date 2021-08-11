package tp.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import tp.Excepciones.DatosObligatoriosException;
import tp.dominio.Boleto;
import tp.dominio.Estacion;
import tp.gui.BoletoGUI;
import tp.servicios.BoletoServicio;
import tp.servicios.EstacionServicio;

public class BoletoController {
	private EstacionServicio estacionServicio;
	private BoletoServicio boletoServicio;
	private Estacion estacion;
	private List<Estacion> lista;
	private BoletoGUI boletogui;
	private Boleto boleto;
	
	public BoletoController(BoletoGUI b) {
		this.estacionServicio = new EstacionServicio();
		this.boletoServicio = new BoletoServicio();
		this.lista = new ArrayList<Estacion>();
		this.boletogui = b;
		this.boleto = new Boleto();
		
	}
	
	public void altaModelo() throws DatosObligatoriosException{
		try {
			if(this.boletogui.getTbxNombre() != null && !this.boletogui.getTbxNombre().getText().equals("")) {
				boleto.setNombreCliente(this.boletogui.getTbxNombre().getText());
			} else {
				throw new DatosObligatoriosException("Nombre", "El Nombre del Cliente es Obligatorio");
			}
			if(this.boletogui.getTbxEmail() != null && !this.boletogui.getTbxEmail().getText().equals("")) {
				boleto.setCorreo(this.boletogui.getTbxEmail().getText());
			} else {
				throw new DatosObligatoriosException("Email", "El email del Cliente es Obligatorio");
			}
			boleto.setCosto((int) this.boletogui.getCosto());
			System.out.println(boleto.getCosto());
			boleto.setFechaVenta(new java.sql.Date(new java.util.Date().getTime()));
			boleto.setOrigen(this.boletogui.getCbxOrigen().getSelectedItem().toString());
			boleto.setDestino(this.boletogui.getCbxDestino().getSelectedItem().toString());
			
			
		} catch (DatosObligatoriosException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Boleto guardar() throws DatosObligatoriosException{
		try{
			altaModelo();
			boletoServicio.crearBoleto(this.boleto);
			return boleto;
		}catch (DatosObligatoriosException e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	public void cargarEstaciones(){
		lista = estacionServicio.buscarTodas();
		
		JComboBox<Estacion> cbxOrigen = new JComboBox<Estacion>();
		JComboBox<Estacion> cbxDestino = new JComboBox<Estacion>();
		
		for(Estacion e : lista) cbxOrigen.addItem(e);
		for(Estacion e : lista) cbxDestino.addItem(e);
		
		
		boletogui.setCbxOrigen(cbxOrigen);
		boletogui.setCbxDestino(cbxDestino);
		
	}

}
