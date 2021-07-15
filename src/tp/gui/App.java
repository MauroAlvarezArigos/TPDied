package tp.gui;

import javax.swing.JFrame;

public class App extends JFrame{
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mi JFrame");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Ejemplo de JFrame");
		
		EstacionGUI estacionGUI = new EstacionGUI();
		
		frame.getContentPane().add(estacionGUI);
				
		frame.pack();
		frame.setSize(600,300);
		frame.setVisible(true);
		
	}

}
