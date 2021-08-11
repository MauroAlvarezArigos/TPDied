package tp.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

import tp.Excepciones.DatosObligatoriosException;
import tp.controller.BoletoController;
import tp.controller.LineaController;
import tp.controller.TrayectoController;
import tp.dominio.Estacion;
import tp.dominio.Linea;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrarTrayectoGUI extends JFrame {
	private JTextField tbxDistancia;
	private JTextField tbxDurViaje;
	private JTextField tbxCMPasajeros;
	private JTextField tbxCosto;
	private JComboBox<String> cbxEstado;
	private JComboBox<Estacion> cbxDestino;
	private JComboBox<Estacion> cbxOrigen;
	private TrayectoController controller;
	
	private Linea linea;
	
	public RegistrarTrayectoGUI(Linea linea) {
		this.setUndecorated(true); 
		this.setResizable(false);
		
		this.linea = linea;
		
		this.controller = new TrayectoController(this);
		controller.cargarEstaciones();

		JPanel panelFrame = new JPanel();
		panelFrame.setLayout(new BorderLayout());

		
		JLabel lblRegistrarTrayectos = new JLabel("Registrar Trayectos");
		lblRegistrarTrayectos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblRegistrarTrayectos.setHorizontalAlignment(SwingConstants.CENTER);
		panelFrame.add(lblRegistrarTrayectos, BorderLayout.NORTH);
		

		JPanel panel = new JPanel();
		panelFrame.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Datos"));
		
		//Con un for cargar las lineas guardadas en la Base de datos, pero solo el nombre
		
		JLabel lblOrigen = new JLabel("Origen:");
		GridBagConstraints gbc_lblOrigen = new GridBagConstraints();
		gbc_lblOrigen.anchor = GridBagConstraints.EAST;
		gbc_lblOrigen.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrigen.gridx = 0;
		gbc_lblOrigen.gridy = 0;
		panel.add(lblOrigen, gbc_lblOrigen);
		
		GridBagConstraints gbc_cbxOrigen = new GridBagConstraints();
		gbc_cbxOrigen.anchor = GridBagConstraints.WEST;
		gbc_cbxOrigen.insets = new Insets(0, 0, 5, 5);
		gbc_cbxOrigen.gridx = 1;
		gbc_cbxOrigen.gridy = 0;
		panel.add(cbxOrigen, gbc_cbxOrigen);
		
		JLabel lblDurViaje = new JLabel("Duraci\u00F3n del Viaje:");
		GridBagConstraints gbc_lblDurViaje = new GridBagConstraints();
		gbc_lblDurViaje.anchor = GridBagConstraints.EAST;
		gbc_lblDurViaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblDurViaje.gridx = 2;
		gbc_lblDurViaje.gridy = 0;
		panel.add(lblDurViaje, gbc_lblDurViaje);
		
		tbxDurViaje = new JTextField();
		GridBagConstraints gbc_tbxDurViaje = new GridBagConstraints();
		gbc_tbxDurViaje.anchor = GridBagConstraints.WEST;
		gbc_tbxDurViaje.insets = new Insets(0, 0, 5, 5);
		gbc_tbxDurViaje.gridx = 3;
		gbc_tbxDurViaje.gridy = 0;
		panel.add(tbxDurViaje, gbc_tbxDurViaje);
		tbxDurViaje.setColumns(10);
		
		tbxDurViaje.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE))) {
		        getToolkit().beep();
		        e.consume();
		      }
		    }
		  });
		
		JLabel lblDestino = new JLabel("Destino:");
		GridBagConstraints gbc_lblDestino = new GridBagConstraints();
		gbc_lblDestino.anchor = GridBagConstraints.EAST;
		gbc_lblDestino.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestino.gridx = 0;
		gbc_lblDestino.gridy = 1;
		panel.add(lblDestino, gbc_lblDestino);
		
		
		GridBagConstraints gbc_cbxDestino = new GridBagConstraints();
		gbc_cbxDestino.anchor = GridBagConstraints.WEST;
		gbc_cbxDestino.insets = new Insets(0, 0, 5, 5);
		gbc_cbxDestino.gridx = 1;
		gbc_cbxDestino.gridy = 1;
		panel.add(cbxDestino, gbc_cbxDestino);
		
		JLabel lblCMPasajeros = new JLabel("Cantidad m\u00E1xima de Pasajeros:");
		GridBagConstraints gbc_lblCMPasajeros = new GridBagConstraints();
		gbc_lblCMPasajeros.anchor = GridBagConstraints.EAST;
		gbc_lblCMPasajeros.insets = new Insets(0, 0, 5, 5);
		gbc_lblCMPasajeros.gridx = 2;
		gbc_lblCMPasajeros.gridy = 1;
		panel.add(lblCMPasajeros, gbc_lblCMPasajeros);
		
		tbxCMPasajeros = new JTextField();
		tbxCMPasajeros.setColumns(10);
		GridBagConstraints gbc_tbxCMPasajeros = new GridBagConstraints();
		gbc_tbxCMPasajeros.anchor = GridBagConstraints.WEST;
		gbc_tbxCMPasajeros.insets = new Insets(0, 0, 5, 5);
		gbc_tbxCMPasajeros.gridx = 3;
		gbc_tbxCMPasajeros.gridy = 1;
		panel.add(tbxCMPasajeros, gbc_tbxCMPasajeros);
		
		tbxCMPasajeros.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE))) {
		        getToolkit().beep();
		        e.consume();
		      }
		    }
		  });
		
		JLabel lblDistancia = new JLabel("Distancia");
		GridBagConstraints gbc_lblDistancia = new GridBagConstraints();
		gbc_lblDistancia.anchor = GridBagConstraints.EAST;
		gbc_lblDistancia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDistancia.gridx = 0;
		gbc_lblDistancia.gridy = 2;
		panel.add(lblDistancia, gbc_lblDistancia);
		
		tbxDistancia = new JTextField();
		GridBagConstraints gbc_tbxDistancia = new GridBagConstraints();
		gbc_tbxDistancia.anchor = GridBagConstraints.WEST;
		gbc_tbxDistancia.insets = new Insets(0, 0, 5, 5);
		gbc_tbxDistancia.gridx = 1;
		gbc_tbxDistancia.gridy = 2;
		panel.add(tbxDistancia, gbc_tbxDistancia);
		tbxDistancia.setColumns(10);
		
		tbxDistancia.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE))) {
		        getToolkit().beep();
		        e.consume();
		      }
		    }
		  });
		
		JLabel lblCosto = new JLabel("Costo ($):");
		GridBagConstraints gbc_lblCosto = new GridBagConstraints();
		gbc_lblCosto.anchor = GridBagConstraints.EAST;
		gbc_lblCosto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCosto.gridx = 2;
		gbc_lblCosto.gridy = 2;
		panel.add(lblCosto, gbc_lblCosto);
		
		tbxCosto = new JTextField();
		tbxCosto.setColumns(10);
		GridBagConstraints gbc_tbxCosto = new GridBagConstraints();
		gbc_tbxCosto.anchor = GridBagConstraints.WEST;
		gbc_tbxCosto.insets = new Insets(0, 0, 5, 5);
		gbc_tbxCosto.gridx = 3;
		gbc_tbxCosto.gridy = 2;
		panel.add(tbxCosto, gbc_tbxCosto);
		tbxCosto.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE))) {
		        getToolkit().beep();
		        e.consume();
		      }
		    }
		  });
		
		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 4;
		panel.add(lblEstado, gbc_lblEstado);
		
		cbxEstado = new JComboBox<String>();
		GridBagConstraints gbc_cbxEstado = new GridBagConstraints();
		gbc_cbxEstado.anchor = GridBagConstraints.WEST;
		gbc_cbxEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cbxEstado.gridx = 1;
		gbc_cbxEstado.gridy = 4;
		cbxEstado.addItem("Activa");
		cbxEstado.addItem("No Activa");
		panel.add(cbxEstado, gbc_cbxEstado);
		
		panelFrame.add(panel, BorderLayout.CENTER);
		
		JPanel botones = new JPanel();
		botones.setLayout(new FlowLayout());
		
		JButton agregarItem = new JButton("Agregar");
		agregarItem.setIcon(new ImageIcon(".\\res\\ruta.png")); 
		agregarItem.setMargin(new Insets(0, 0, 0, 0));             
		agregarItem.setHorizontalTextPosition(SwingConstants.CENTER);
		agregarItem.setVerticalTextPosition(SwingConstants.BOTTOM);
		botones.add(agregarItem);
		
		agregarItem.addActionListener(e->{
			try{
				controller.agregarItem();
			}
			catch(DatosObligatoriosException e1) {
				e1.printStackTrace();
				this.mostrarError("Error al cargar", e1.getMensaje());
			}
		});
		
		JButton guardar = new JButton("Guardar");
		guardar.setIcon(new ImageIcon(".\\res\\guardar.png"));
		guardar.setMargin(new Insets(0, 0, 0, 0));
		guardar.setHorizontalTextPosition(SwingConstants.CENTER);    
		guardar.setVerticalTextPosition(SwingConstants.BOTTOM);      
		botones.add(guardar);
		
		guardar.addActionListener(e->{
			try {
				controller.guardar();
			}
			catch(Exception e2) {
				e2.printStackTrace();
				this.mostrarError("Error al guardar", "Fallo al guardar");
			};
		});
	
		JButton cancelar = new JButton("Cancelar");
		cancelar.setIcon(new ImageIcon(".\\res\\cancelar.png"));
		cancelar.setMargin(new Insets(0, 0, 0, 0));
		cancelar.setHorizontalTextPosition(SwingConstants.CENTER);    
		cancelar.setVerticalTextPosition(SwingConstants.BOTTOM);      
		botones.add(cancelar);
		
		guardar.addActionListener(e->{
			controller.imprimir();
		});
		cancelar.addActionListener(e -> dispose());
		
		panelFrame.add(botones, BorderLayout.SOUTH);
		
		this.getContentPane().add(panelFrame);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setSize(600,300);
		
		
	}
	
	public void refresh() {
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void mostrarError(String titulo,String detalle) {
		JFrame padre= (JFrame) SwingUtilities.getWindowAncestor(this);
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.ERROR_MESSAGE);
	}

	public JComboBox<Estacion> getCbxOrigen() {
		return cbxOrigen;
	}
	public void setCbxOrigen(JComboBox<Estacion> cbxOrigen) {
		this.cbxOrigen = cbxOrigen;
	}
	public JComboBox<Estacion> getCbxDestino() {
		return cbxDestino;
	}
	public void setCbxDestino(JComboBox<Estacion> cbxDestino) {
		this.cbxDestino = cbxDestino;
	}

	public JTextField getTbxDistancia() {
		return tbxDistancia;
	}

	public void setTbxDistancia(JTextField tbxDistancia) {
		this.tbxDistancia = tbxDistancia;
	}

	public JTextField getTbxDurViaje() {
		return tbxDurViaje;
	}

	public void setTbxDurViaje(JTextField tbxDurViaje) {
		this.tbxDurViaje = tbxDurViaje;
	}

	public JTextField getTbxCMPasajeros() {
		return tbxCMPasajeros;
	}

	public void setTbxCMPasajeros(JTextField tbxCMPasajeros) {
		this.tbxCMPasajeros = tbxCMPasajeros;
	}

	public JTextField getTbxCosto() {
		return tbxCosto;
	}

	public void setTbxCosto(JTextField tbxCosto) {
		this.tbxCosto = tbxCosto;
	}
	public JComboBox<String> getCbxEstado() {
		return cbxEstado;
	}
	public void setCbxEstado(JComboBox<String> cbxEstado) {
		this.cbxEstado = cbxEstado;
	}
	
	public Linea getLinea() {
		return this.linea;
	}
	
	
}
