package tp.controller;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import tp.Excepciones.DatosObligatoriosException;
import tp.dao.EstacionDaoSQL;
import tp.dao.LineaDaoSQL;
import tp.dominio.Estacion;
import tp.dominio.Linea;
import tp.gui.LineaGUI;
import tp.servicios.LineaServicio;

public class LineaController {
	
	private LineaServicio lineaServicio;
	HashSet<Integer> visited = new HashSet<Integer>();
	private LineaGUI lineagui;
	private Linea linea;
	private List<Linea> lista;
	private String pk;
	
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
				linea.setColor(this.lineagui.getTbxColor().getText());
			} else {
				throw new DatosObligatoriosException("Color", "El color de la linea es obligatorio");
			}
			this.linea.setEstado(this.lineagui.getCbxEstado().getSelectedItem().equals("Activa")? true : false);
			
		} catch (DatosObligatoriosException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
		
	public Linea modificar() throws DatosObligatoriosException{
		try {
			pk = linea.getNombre();
			System.out.println("pk: "+pk);
			altaLinea();
			System.out.println("Modificado "+ linea.toString());
			lineaServicio.modificarLinea(linea, pk);
			return linea;
		}catch(DatosObligatoriosException e) {
			System.out.println(e.getMensaje());
			throw e;
		}
	}
	
	public Linea guardar() throws DatosObligatoriosException {
		try{
			altaLinea();
			System.out.println("INICIADO "+linea.toString());
			lineaServicio.crearLinea(linea);
			return linea;
		}catch(DatosObligatoriosException e) {
			System.out.println(e.getMensaje());
			throw e;
		}
	}
	
	public void eliminar() {
		this.lineaServicio.borrarLinea(linea);		
	}
	
	public List<Linea> buscar(Map<String, ?> datos) {
		LineaDaoSQL lineaDAO = new LineaDaoSQL();
		List<Linea> resultados = lineaDAO.buscarPorAtributos(datos);
		return resultados;
	}
	
	public void cargarDatosEncontrados(Linea lin) {
		System.out.println(lin.getNombre());
		
		linea = lin;
		
		lineagui.getTbxNombre().setText(lin.getNombre());
		lineagui.getTbxColor().setText(lin.getColor());
		lineagui.getCbxEstado().setSelectedIndex(lin.getEstado() == 1 ? 0 : 1); 
		lineagui.setModifyDeleteState();
	}
	

}
