package tp.gui;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import tp.dao.EstacionDaoSQL;
import tp.dao.LineaDaoSQL;
import tp.dao.utils.DB;
import tp.dominio.Estacion;


public class App extends JFrame {
	
	public static void main(String[] args) {

		JFrame frame = new JFrame("Naurede");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Sistema de Gestion de Viajes");
		
		JPanel menu = new JPanel();
		
		JButton boton = new JButton("Estacion");
		boton.setIcon(new ImageIcon(".\\res\\estacion.png"));
		boton.setMargin(new Insets(0, 0, 0, 0));
		boton.setHorizontalTextPosition(SwingConstants.CENTER);    
		boton.setVerticalTextPosition(SwingConstants.BOTTOM);      
		JButton boton2 = new JButton("Boleto");
		boton2.setIcon(new ImageIcon(".\\res\\boleto.png"));
		boton2.setMargin(new Insets(0, 0, 0, 0));
		boton2.setHorizontalTextPosition(SwingConstants.CENTER);    
		boton2.setVerticalTextPosition(SwingConstants.BOTTOM);      
		JButton boton3 = new JButton("Linea");
		boton3.setIcon(new ImageIcon(".\\res\\ruta.png"));
		boton3.setMargin(new Insets(0, 0, 0, 0));
		boton3.setHorizontalTextPosition(SwingConstants.CENTER);    
		boton3.setVerticalTextPosition(SwingConstants.BOTTOM);      
		JButton boton4 = new JButton("Parametros");
		boton4.setIcon(new ImageIcon(".\\res\\parametros.png"));
		boton4.setMargin(new Insets(0, 0, 0, 0));
		boton4.setHorizontalTextPosition(SwingConstants.CENTER);    
		boton4.setVerticalTextPosition(SwingConstants.BOTTOM);      

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
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		
	}
	
}