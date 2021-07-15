package tp.gui;

import java.awt.Insets;

import javax.swing.*;


public class start extends JFrame {
	public start() {
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mi JFrame");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Ejemplo de JFrame");
		
		JPanel panelDeContenido = new JPanel();
		
		Icon icon = new ImageIcon(".\\res\\buscar.png");
		
		JLabel lblNombre = new JLabel("Nombre: ");
		JTextField tbxNombre = new JTextField(20);
		JButton btnBuscar = new JButton();
		
		btnBuscar.setMargin(new Insets(0, 0, 0, 0));
		btnBuscar.setIcon(icon);
		
		panelDeContenido.add(lblNombre);
		panelDeContenido.add(tbxNombre);
		panelDeContenido.add(btnBuscar);
		
		frame.setContentPane(panelDeContenido);
		
		frame.pack();
		frame.setSize(400,200);
		frame.setVisible(true);
		
		
	}
}
