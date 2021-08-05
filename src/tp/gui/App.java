package tp.gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JFrame {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mi JFrame");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Ejemplo de JFrame");
		
		JPanel menu = new JPanel();
		
		JButton boton = new JButton("Estacion");
		JButton boton2 = new JButton("Boleto");
		JButton boton3 = new JButton("Linea");
		

		menu.add(boton);
		menu.add(boton2);
 		menu.add(boton3);
		
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

		
		frame.setContentPane(menu);
		
		frame.pack();
		frame.setSize(600,300);
		frame.setVisible(true);
		
	}
	
}
