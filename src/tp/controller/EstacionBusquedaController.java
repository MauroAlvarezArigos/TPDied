package tp.controller;


import java.util.*;

import javax.swing.JTable;

import tp.dominio.Estacion;
import tp.dao.EstacionDaoSQL;

public class EstacionBusquedaController {
	
//	private JTable ret;
	
	public List<Estacion> buscar(Map<String, ?> datos) {
		EstacionDaoSQL estDAO = new EstacionDaoSQL();
		List<Estacion> resultados = estDAO.buscarPorAtributos(datos);
//		int tam = resultados.size();
//		Object[][] tabla = new Object[tam][3];
//		for(int i=0; i<tam; i++) {
//			tabla[i][0] = resultados.get(i).getId();
//			tabla[i][1] = resultados.get(i).getNombre();
//			tabla[i][2] = resultados.get(i).getEstado(); // esto hay q modificarlo
//		}
		return resultados;
	}
	
}
