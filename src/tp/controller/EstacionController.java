package tp.controller;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;

import javax.swing.JTextField;

import tp.dominio.ComboItem;
import tp.dominio.Estacion;
import tp.gui.EstacionGUI;
import tp.servicios.EstacionServicio;
import tp.Excepciones.*;
import tp.dao.EstacionDaoSQL;

public class EstacionController {
	private EstacionServicio estacionServicio;
	private Estacion estacion;
	private List<Estacion> lista;
	private EstacionGUI estaciongui;
	private Timestamp ts;

	private Integer estado;
	
	public EstacionController(EstacionGUI eg) {
		this.estacionServicio = new EstacionServicio();
		this.lista = new ArrayList<Estacion>();
		this.estaciongui = eg;
		this.ts = null;
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
				ts = getFormato(this.estaciongui.getTbxApertura().getText());
				if(ts != null) {
					this.estacion.setHorarioApertura(ts);
				} else {
					throw new DatosObligatoriosException("Formato Invalido", "El formato del horario de Apertura es incorrecto HH:MM");
				}
			} else {
				throw new DatosObligatoriosException("Horario Apertura", "El Horario de Apertura es Obligatorio");
			}
			if(this.estaciongui.getTbxCierre() != null && !this.estaciongui.getTbxCierre().getText().equals("")) {
				ts = getFormato(this.estaciongui.getTbxCierre().getText());
				if(ts != null) {
					this.estacion.setHorarioCierre(ts);
				} else {
					throw new DatosObligatoriosException("Formato Invalido", "El formato del horario de Cierre es incorrecto HH:MM");
				}
			} else {
				throw new DatosObligatoriosException("Horario Cierre", "El Horario de Cierre es Obligatorio");
			}
			this.estacion.setEstado(this.estaciongui.getCbxEstado().getSelectedItem().equals("Operativa")? true : false);
			
		} catch (DatosObligatoriosException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void modificarModelo() throws DatosObligatoriosException{
		try{
			if((this.estaciongui).getTbxNombre() != null && !this.estaciongui.getTbxNombre().getText().equals("")) {
				estacion.setNombre(this.estaciongui.getTbxNombre().getText());
			} else {
				throw new DatosObligatoriosException("Nombre", "El Nombre de la Estacion es Obligatorio");
			}
			if(this.estaciongui.getTbxApertura() != null && !this.estaciongui.getTbxApertura().getText().equals("")) {
				ts = getFormato(this.estaciongui.getTbxApertura().getText());
				if(ts != null) {
					this.estacion.setHorarioApertura(ts);
				} else {
					throw new DatosObligatoriosException("Formato Invalido", "El formato del horario de Apertura es incorrecto HH:MM");
				}
			} else {
				throw new DatosObligatoriosException("Horario Apertura", "El Horario de Apertura es Obligatorio");
			}
			if(this.estaciongui.getTbxCierre() != null && !this.estaciongui.getTbxCierre().getText().equals("")) {
				ts = getFormato(this.estaciongui.getTbxCierre().getText());
				if(ts != null) {
					this.estacion.setHorarioCierre(ts);
				} else {
					throw new DatosObligatoriosException("Formato Invalido", "El formato del horario de Cierre es incorrecto HH:MM");
				}
			} else {
				throw new DatosObligatoriosException("Horario Cierre", "El Horario de Cierre es Obligatorio");
			}
			//VER ESTA LOGICA
			estado = this.estaciongui.getCbxEstado().getSelectedItem().equals("Operativa")? 1 : 0;
			
			if(this.estacion.getEstado() != estado) {
				mantenimiento(estacion);
			}
			this.estacion.setEstado(this.estaciongui.getCbxEstado().getSelectedItem().equals("Operativa")? true : false);
			
		} catch (DatosObligatoriosException e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public void mantenimiento(Estacion es) {
		try{
			System.out.println("Estado = "+estado);
			if(estado == 0) {
				//Crea el mantenimiento
				estacionServicio.crearMantenimiento(es.getId(), this.estaciongui.getEditorObservaciones().getText());
			}
			else {
				//Finaliza el mantenimiento
				estacionServicio.finalizarMantenimiento(es.getId(), this.estaciongui.getEditorObservaciones().getText());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Estacion modificar() throws DatosObligatoriosException{
		try {
			System.out.println(estacion.getId());
			modificarModelo();
			System.out.println("Modificado "+ estacion.toString());
			estacionServicio.modificarEstacion(estacion);
			this.lista.clear();
			this.lista.addAll(estacionServicio.buscarTodas());
			return estacion;
		}catch(DatosObligatoriosException e) {
			System.out.println(e.getMensaje());
			throw e;
		}
	}
	
	public Estacion guardar() throws DatosObligatoriosException {
		try{
			altaModelo();
			System.out.println("INICIADO "+estacion.toString());
			estacionServicio.crearEstacion(estacion);
			this.lista.clear();
			this.lista.addAll(estacionServicio.buscarTodas());
			return estacion;
		}catch(DatosObligatoriosException e) {
			System.out.println(e.getMensaje());
			throw e;
		}
	}
	public void mostrarGUI() {
		this.estaciongui.setVisible(true);
	}
	
	public void eliminar() {
		this.estacionServicio.borrarEstacion(estacion);		
	}
	
	public List<Estacion> buscar(Map<String, ?> datos) {
		EstacionDaoSQL estDAO = new EstacionDaoSQL();
		List<Estacion> resultados = estDAO.buscarPorAtributos(datos);
		return resultados;
	}
	
	public List<Estacion> listarTodos(){
		this.lista.clear();
		this.lista.addAll(estacionServicio.buscarTodas());
		System.out.println("Resultado res "+lista);
		return this.lista;
	}
	
	public void cargarDatosEncontrados(Estacion es) {
		
		System.out.println(es.getNombre());
		
		estacion = es;
		
		estaciongui.getTbxNombre().setText(es.getNombre());
		
		estaciongui.getTbxApertura().setText(ComboItem.getHoraString(es.getHorarioApertura()));
		estaciongui.getTbxCierre().setText(ComboItem.getHoraString(es.getHorarioCierre()));
		estaciongui.getCbxEstado().setSelectedIndex(es.getEstado() == 1 ? 0 : 1);
		estaciongui.setModifyDeleteState();

	}
	
	public Timestamp getFormato(String s) {
		Timestamp ts = new Timestamp(0); 
		Boolean valid = true;
		if(s.length() != 5) return null;
		for(int i=0; i<5; i++) {
			if(i!=2) valid &= isNumber(s.charAt(0));
		}
		if(s.charAt(2) != ':') valid&=false;
		if(!valid) return null;
		long segxmin = 60000;
		long hora = (s.charAt(0)-'0')*10 + s.charAt(1)-'0';
		long min = (s.charAt(3)-'0')*10 + s.charAt(4)-'0';
		if(hora>=24 || min>=60) return null;
		ts.setTime((long) segxmin * 60 * 3 + (long) segxmin * min + hora*segxmin*60); 
		return ts;
	}
	
	public Boolean isNumber(char x) {
		if(x >= '0' && x<='9') return true;
		return false;
	}
}
