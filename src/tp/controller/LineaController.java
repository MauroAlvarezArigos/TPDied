package tp.controller;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;

import tp.Excepciones.DatosObligatoriosException;
import tp.dominio.Linea;
import tp.gui.LineaGUI;
import tp.servicios.LineaServicio;

public class LineaController {
	
	private LineaServicio lineaServicio;
	HashSet<Integer> visited = new HashSet<Integer>();
	private LineaGUI lineagui;
	private Linea linea;
	private List<Linea> lista;
	
	public LineaController(LineaGUI lg) {
		this.lineaServicio = new LineaServicio();
		this.lineagui = lg;
		linea = new Linea();
	}
	
	public void altaLinea() throws DatosObligatoriosException {
		try{
			if((this.lineagui).getTbxNombre() != null && !this.lineagui.getTbxNombre().getText().equals("")) {
				linea.setNombre(this.lineagui.getTbxNombre().getText());
			} else {
				throw new DatosObligatoriosException("Nombre", "El nombre de la linea es obligatorio");
			}
			if(this.lineagui.getTbxColor() != null && !this.lineagui.getTbxColor().getText().equals("")) {
				linea.setColor(this.lineagui.getTbxNombre().getText());
			} else {
				throw new DatosObligatoriosException("Color", "El color de la linea es obligatorio");
			}
			this.linea.setEstado(this.lineagui.getCbxEstado().getSelectedItem().equals("Activa")? true : false);
			
		} catch (DatosObligatoriosException e) {
			System.out.println("hola");
			e.printStackTrace();
			throw e;
		}
	}
	
	public Linea modificarLinea() throws DatosObligatoriosException{
		try {
			altaLinea();
			System.out.println("MODIFICADO "+ linea.toString());
			lineaServicio.crearLinea(linea);
			this.lista.clear();
			this.lista.addAll(lineaServicio.buscarTodas());
			return linea;
		}catch(DatosObligatoriosException e) {
			System.out.println(e.getMensaje());
			throw e;
		}
	}
	
	public void eliminar(Linea l) {
		this.lineaServicio.borrarLinea(l);		
	}
	

}
