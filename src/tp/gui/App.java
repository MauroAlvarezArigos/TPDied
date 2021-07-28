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
		JButton boton2 = new JButton("Busqueda Estacion");

		menu.add(boton);
		menu.add(boton2);
		
		boton.addActionListener(e -> {
			EstacionGUI eb = new EstacionGUI();
			eb.setVisible(true);
		});
		
		boton2.addActionListener(e -> {
			EstacionBusquedaGUI eb = new EstacionBusquedaGUI();
			eb.setVisible(true);
		});

		frame.setContentPane(menu);
		
		frame.pack();
		frame.setSize(600,300);
		frame.setVisible(true);
		
	}
	
}
