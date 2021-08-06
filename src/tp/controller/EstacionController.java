package tp.controller;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;

import tp.dominio.Estacion;
import tp.gui.EstacionGUI;
import tp.Excepciones.*;

public class EstacionController {
	//private EstacionServicio estacionServicio;
	private Estacion estacion;
	private List<Estacion> lista;
	private EstacionGUI estaciongui;
	
	public EstacionController(EstacionGUI eg) {
		//this.estacionServicio = new EstacionServicio();
		this.lista = new ArrayList<Estacion>();
		this.estaciongui = eg;
		estacion = new Estacion();
	}
	
	public void altaModelo() throws DatosObligatoriosException {
		try{
			if((this.estaciongui).getTbxNombre() != null && !this.estaciongui.getTbxNombre().getText().equals("")) {
				estacion.setNombre(this.estaciongui.getTbxNombre().getText());
			} else {
				throw new DatosObligatoriosException("Nombre", "El Nombre de la Estacion es Obligatorio");
			}
			if(this.estaciongui.getTbxApertura() != null && !this.estaciongui.getTbxApertura().getText().equals("")) {
				try {
					LocalTime t = LocalTime.parse(this.estaciongui.getTbxApertura().getText());
					estacion.setHorarioApertura(t);
				} catch (DateTimeParseException dte) {
					dte.printStackTrace();
					throw new DatosObligatoriosException("Formato Invalido", "El formato del horario es incorrecto HH:MM");
				}
			} else {
				throw new DatosObligatoriosException("Horario Apertura", "El Horario de Apertura es Obligatorio");
			}
			if(this.estaciongui.getTbxCierre() != null && !this.estaciongui.getTbxCierre().getText().equals("")) {
				try {
					LocalTime t = LocalTime.parse(this.estaciongui.getTbxCierre().getText());
				} catch (DateTimeParseException dte) {
					dte.printStackTrace();
					throw new DatosObligatoriosException("Formato Invalido", "El formato del horario es incorrecto HH:MM");
				}
			} else {
				throw new DatosObligatoriosException("Horario Apertura", "El Horario de Apertura es Obligatorio");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void eliminar(Estacion e) {
		//this.estacionServicio.borrarEstacion(e);		
	}
	
	public List<Estacion> listarTodos(){
		this.lista.clear();
		//this.lista.addAll(estacionServicio.buscarTodos());
		System.out.println("Resultado res "+lista);
		return this.lista;
	}
}
