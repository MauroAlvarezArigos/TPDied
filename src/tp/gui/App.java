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
		JButton boton3 = new JButton("Linea");
<<<<<<< HEAD
		JButton boton4 = new JButton("Busqueda Linea");
=======
>>>>>>> aeae4cdaec923e60d7fcd607376cdefe3bb6bcfb

		menu.add(boton);
		menu.add(boton2);
		menu.add(boton3);
<<<<<<< HEAD
		menu.add(boton4);
=======
>>>>>>> aeae4cdaec923e60d7fcd607376cdefe3bb6bcfb
		
		boton.addActionListener(e -> {
			EstacionGUI eg = new EstacionGUI();
			eg.setVisible(true);
		});
<<<<<<< HEAD
		
		boton2.addActionListener(e -> {
			EstacionBusquedaGUI eb = new EstacionBusquedaGUI();
			eb.setVisible(true);
		});
		
		boton3.addActionListener(e -> {
			LineaGUI lg = new LineaGUI();
			lg.setVisible(true);
		});
		
		boton4.addActionListener(e -> {
			LineaBusquedaGUI lb = new LineaBusquedaGUI();
			lb.setVisible(true);
		});
		
		
=======
		
		boton2.addActionListener(e -> {
			EstacionBusquedaGUI eb = new EstacionBusquedaGUI();
			eb.setVisible(true);
		});

		boton3.addActionListener(e -> {
			LineaGUI lg = new LineaGUI();
			lg.setVisible(true);
		});
>>>>>>> aeae4cdaec923e60d7fcd607376cdefe3bb6bcfb

		frame.setContentPane(menu);
		
		frame.pack();
		frame.setSize(600,300);
		frame.setVisible(true);
		
	}
	
}
