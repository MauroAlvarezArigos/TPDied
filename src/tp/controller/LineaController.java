package tp.controller;

import java.util.ArrayList;
import java.util.HashSet;

import tp.Excepciones.DatosObligatoriosException;
import tp.dominio.Estacion;
import tp.dominio.Linea;
import tp.gui.LineaGUI;
import tp.servicios.EstacionServicio;
import tp.servicios.LineaServicio;

public class LineaController {
	private LineaServicio lineaServicio;
	HashSet<Integer> visited = new HashSet<Integer>();
	private LineaGUI lineagui;
	private Linea linea;
	
	public LineaController(LineaGUI lg) {
		this.lineaServicio = new LineaServicio();
		this.lineagui = lg;
		linea = new Linea();
	}
	
	public void AltaLinea() throws DatosObligatoriosException {
		try {
			if((this.lineagui).getTbxNombre() != null && !this.lineagui.getTbxNombre().getText().equals("")) {
				linea.setNombre(this.lineagui.getTbxNombre().getText());
			} else {
				throw new DatosObligatoriosException("Nombre", "El nombre de la Linea es obligatorio");
			}
			if((this.lineagui).getTbxColor() != null && !this.lineagui.getTbxNombre().getText().equals("")) {
				linea.setColor(this.lineagui.getTbxColor().getText());
			}
			else {
				throw new DatosObligatoriosException("Color", "El color de la linea es obligatorio");
			}
			this.linea.setEstado(this.lineagui.getCbxEstado().getSelectedItem().equals("Activa")? true : false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
