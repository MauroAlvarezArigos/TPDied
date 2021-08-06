package tp.gui;

import java.awt.event.ActionEvent;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tp.dao.EstacionDaoSQL;
import tp.dao.LineaDaoSQL;
import tp.dao.utils.DB;
import tp.dominio.Estacion;


public class App extends JFrame {
	
	public static void main(String[] args) {
		/*
		DB.getConexion();
		
		Timestamp time1 = new Timestamp (System.currentTimeMillis());
		Timestamp time2 = new Timestamp (System.currentTimeMillis()+60000);
		Estacion esta = new Estacion(2, "estacion2", time1, time2, true);
		System.out.println(esta.toString());
		
		EstacionDaoSQL est = new EstacionDaoSQL();
		
		
		est.borrar(esta);

		est.saveOrUpdate(esta);
		
		*/
		
		JFrame frame = new JFrame("Mi JFrame");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Ejemplo de JFrame");
		
		JPanel menu = new JPanel();
		
		JButton boton = new JButton("Estacion");
		JButton boton2 = new JButton("Boleto");
		JButton boton3 = new JButton("Linea");
		JButton boton4 = new JButton("Parametros");
		

		menu.add(boton);
		menu.add(boton2);
 		menu.add(boton3);
 		menu.add(boton4);
		
		boton.addActionListener(e -> {
			EstacionGUI eg = new EstacionGUI();
			eg.setVisible(true);
		});
		
		boton2.addActionListener(e -> {
			BoletoGUI eg = new BoletoGUI();
			eg.setVisible(true);
		});
		
		boton3.addActionListener(e -> {
			LineaGUI lg = new LineaGUI();
			lg.setVisible(true);
		});
		
		boton4.addActionListener(e -> {
			ParametrosGUI pg = new ParametrosGUI();
			pg.setVisible(true);
		});

		
		frame.setContentPane(menu);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(600,300);
		frame.setVisible(true);
		
	}
	
}