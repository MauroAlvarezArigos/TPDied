package tp.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BoletoGUI extends JFrame {
	private JTextField tbxNombre;
	private JTextField tbxEmail;

	public BoletoGUI() {
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contentPane);
		
		
		JLabel lblBoletos = new JLabel("Venta Boletos");
		lblBoletos.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoletos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(lblBoletos, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCamino = new JLabel("Camino:");
		GridBagConstraints gbc_lblCamino = new GridBagConstraints();
		gbc_lblCamino.anchor = GridBagConstraints.EAST;
		gbc_lblCamino.insets = new Insets(0, 0, 5, 5);
		gbc_lblCamino.gridx = 1;
		gbc_lblCamino.gridy = 1;
		panel.add(lblCamino, gbc_lblCamino);
		
		JComboBox<String> cbxCamino = new JComboBox<String>();
		GridBagConstraints gbc_cbxCamino = new GridBagConstraints();
		gbc_cbxCamino.anchor = GridBagConstraints.WEST;
		gbc_cbxCamino.insets = new Insets(0, 0, 5, 5);
		gbc_cbxCamino.gridx = 2;
		gbc_cbxCamino.gridy = 1;
		panel.add(cbxCamino, gbc_cbxCamino);
		cbxCamino.addItem("El m�s r�pido");
		cbxCamino.addItem("El de menor distacia");
		cbxCamino.addItem("El m�s barato");
		
		JPanel datosCliente = new JPanel();
		datosCliente.setBorder(BorderFactory.createTitledBorder("Datos Cliente"));
		GridBagConstraints gbc_datosCliente = new GridBagConstraints();
		gbc_datosCliente.insets = new Insets(0, 0, 5, 5);
		gbc_datosCliente.fill = GridBagConstraints.BOTH;
		gbc_datosCliente.gridx = 1;
		gbc_datosCliente.gridy = 2;
		panel.add(datosCliente, gbc_datosCliente);
		GridBagLayout gbl_datosCliente = new GridBagLayout();
		gbl_datosCliente.columnWidths = new int[]{0, 0, 0, 0};
		gbl_datosCliente.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_datosCliente.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_datosCliente.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		datosCliente.setLayout(gbl_datosCliente);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		datosCliente.add(lblNombre, gbc_lblNombre);
		
		tbxNombre = new JTextField();
		GridBagConstraints gbc_tbxNombre = new GridBagConstraints();
		gbc_tbxNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tbxNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbxNombre.gridx = 2;
		gbc_tbxNombre.gridy = 1;
		datosCliente.add(tbxNombre, gbc_tbxNombre);
		tbxNombre.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 2;
		datosCliente.add(lblEmail, gbc_lblEmail);
		
		tbxEmail = new JTextField();
		GridBagConstraints gbc_tbxEmail = new GridBagConstraints();
		gbc_tbxEmail.insets = new Insets(0, 0, 5, 0);
		gbc_tbxEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbxEmail.gridx = 2;
		gbc_tbxEmail.gridy = 2;
		datosCliente.add(tbxEmail, gbc_tbxEmail);
		tbxEmail.setColumns(10);
		
		JPanel panelEstacion = new JPanel();
		panelEstacion.setBorder(BorderFactory.createTitledBorder("Estaciones"));
		GridBagConstraints gbc_panelEstacion = new GridBagConstraints();
		gbc_panelEstacion.insets = new Insets(0, 0, 5, 5);
		gbc_panelEstacion.fill = GridBagConstraints.BOTH;
		gbc_panelEstacion.gridx = 2;
		gbc_panelEstacion.gridy = 2;
		panel.add(panelEstacion, gbc_panelEstacion);
		GridBagLayout gbl_panelEstacion = new GridBagLayout();
		gbl_panelEstacion.columnWidths = new int[]{0, 0, 0};
		gbl_panelEstacion.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelEstacion.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelEstacion.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelEstacion.setLayout(gbl_panelEstacion);
		
		JLabel lblOrigen = new JLabel("Origen:");
		GridBagConstraints gbc_lblOrigen = new GridBagConstraints();
		gbc_lblOrigen.anchor = GridBagConstraints.EAST;
		gbc_lblOrigen.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrigen.gridx = 0;
		gbc_lblOrigen.gridy = 1;
		panelEstacion.add(lblOrigen, gbc_lblOrigen);
		
		JComboBox<String> cbxOrigen = new JComboBox<String>();
		GridBagConstraints gbc_cbxOrigen = new GridBagConstraints();
		gbc_cbxOrigen.anchor = GridBagConstraints.WEST;
		gbc_cbxOrigen.insets = new Insets(0, 0, 5, 0);
		gbc_cbxOrigen.gridx = 1;
		gbc_cbxOrigen.gridy = 1;
		panelEstacion.add(cbxOrigen, gbc_cbxOrigen);
		
		JLabel lblDestino = new JLabel("Destino:");
		GridBagConstraints gbc_lblDestino = new GridBagConstraints();
		gbc_lblDestino.anchor = GridBagConstraints.EAST;
		gbc_lblDestino.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestino.gridx = 0;
		gbc_lblDestino.gridy = 2;
		panelEstacion.add(lblDestino, gbc_lblDestino);
		
		JComboBox<String> cbxDestino = new JComboBox<String>();
		GridBagConstraints gbc_cbxDestino = new GridBagConstraints();
		gbc_cbxDestino.insets = new Insets(0, 0, 5, 0);
		gbc_cbxDestino.anchor = GridBagConstraints.WEST;
		gbc_cbxDestino.gridx = 1;
		gbc_cbxDestino.gridy = 2;
		panelEstacion.add(cbxDestino, gbc_cbxDestino);
		
		JButton btnCalcular = new JButton("Calcular");
		GridBagConstraints gbc_btnCalcular = new GridBagConstraints();
		gbc_btnCalcular.gridx = 1;
		gbc_btnCalcular.gridy = 3;
		panelEstacion.add(btnCalcular, gbc_btnCalcular);
		
		JLabel lblCosto = new JLabel("Precio: ");
		GridBagConstraints gbc_lblCosto = new GridBagConstraints();
		gbc_lblCosto.anchor = GridBagConstraints.WEST;
		gbc_lblCosto.insets = new Insets(0, 0, 0, 5);
		gbc_lblCosto.gridx = 1;
		gbc_lblCosto.gridy = 3;
		panel.add(lblCosto, gbc_lblCosto);
		
		JButton btnFacturar = new JButton("Facturar");
		GridBagConstraints gbc_btnFacturar = new GridBagConstraints();
		gbc_btnFacturar.anchor = GridBagConstraints.WEST;
		gbc_btnFacturar.insets = new Insets(0, 0, 0, 5);
		gbc_btnFacturar.gridx = 2;
		gbc_btnFacturar.gridy = 3;
		panel.add(btnFacturar, gbc_btnFacturar);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.EAST;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 3;
		panel.add(btnCancelar, gbc_btnCancelar);
		
		//Preg si queres cancelar??
		btnCancelar.addActionListener(e -> dispose());
		
		this.pack();
		this.setSize(500,300);			
		
	}

}