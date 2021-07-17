package tp.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class EstacionGUI extends JPanel {
	
	private JTextField tbxNombre;
	private JTextField tbxApertura;
	private JTextField tbxCierre;
	
	public EstacionGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		
		JLabel lblEstacion = new JLabel("Gestión de Estaciones");
		lblEstacion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblEstacion = new GridBagConstraints();
		gbc_lblEstacion.gridwidth = 5;
		gbc_lblEstacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstacion.gridx = 4;
		gbc_lblEstacion.gridy = 4;
		this.add(lblEstacion, gbc_lblEstacion);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 6;
		this.add(lblNombre, gbc_lblNombre);
		
		tbxNombre = new JTextField();
		GridBagConstraints gbc_tbxNombre = new GridBagConstraints();
		gbc_tbxNombre.gridwidth = 2;
		gbc_tbxNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tbxNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbxNombre.gridx = 4;
		gbc_tbxNombre.gridy = 6;
		this.add(tbxNombre, gbc_tbxNombre);
		tbxNombre.setColumns(20);
		
		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 3;
		gbc_lblEstado.gridy = 7;
		this.add(lblEstado, gbc_lblEstado);
		
		JComboBox<String> cbxEstado = new JComboBox<String>();
		cbxEstado.setMaximumRowCount(10);
		cbxEstado.addItem("Operativa");
		cbxEstado.addItem("En Mantenimiento");
		GridBagConstraints gbc_cbxEstado = new GridBagConstraints();
		gbc_cbxEstado.gridwidth = 2;
		gbc_cbxEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cbxEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxEstado.gridx = 4;
		gbc_cbxEstado.gridy = 7;
		this.add(cbxEstado, gbc_cbxEstado);
		
		JLabel lblHorarios = new JLabel("Horarios");
		GridBagConstraints gbc_lblHorarios = new GridBagConstraints();
		gbc_lblHorarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorarios.gridx = 7;
		gbc_lblHorarios.gridy = 7;
		this.add(lblHorarios, gbc_lblHorarios);
		
		JLabel lblApertura = new JLabel("Apertura:");
		GridBagConstraints gbc_lblApertura = new GridBagConstraints();
		gbc_lblApertura.anchor = GridBagConstraints.EAST;
		gbc_lblApertura.insets = new Insets(0, 0, 5, 5);
		gbc_lblApertura.gridx = 6;
		gbc_lblApertura.gridy = 8;
		this.add(lblApertura, gbc_lblApertura);
		
		tbxApertura = new JTextField();
		GridBagConstraints gbc_tbxApertura = new GridBagConstraints();
		gbc_tbxApertura.insets = new Insets(0, 0, 5, 5);
		gbc_tbxApertura.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbxApertura.gridx = 7;
		gbc_tbxApertura.gridy = 8;
		this.add(tbxApertura, gbc_tbxApertura);
		tbxApertura.setColumns(10);
		
		JLabel lblCierre = new JLabel("Cierre:");
		GridBagConstraints gbc_lblCierre = new GridBagConstraints();
		gbc_lblCierre.anchor = GridBagConstraints.EAST;
		gbc_lblCierre.insets = new Insets(0, 0, 5, 5);
		gbc_lblCierre.gridx = 6;
		gbc_lblCierre.gridy = 9;
		this.add(lblCierre, gbc_lblCierre);
		
		tbxCierre = new JTextField();
		GridBagConstraints gbc_tbxCierre = new GridBagConstraints();
		gbc_tbxCierre.insets = new Insets(0, 0, 5, 5);
		gbc_tbxCierre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbxCierre.gridx = 7;
		gbc_tbxCierre.gridy = 9;
		this.add(tbxCierre, gbc_tbxCierre);
		tbxCierre.setColumns(10);
		
		JEditorPane editorObservaciones = new JEditorPane();
		editorObservaciones.setText("Observaciones");
		GridBagConstraints gbc_editorObservaciones = new GridBagConstraints();
		gbc_editorObservaciones.gridheight = 5;
		gbc_editorObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_editorObservaciones.fill = GridBagConstraints.BOTH;
		gbc_editorObservaciones.gridx = 8;
		gbc_editorObservaciones.gridy = 7;
		this.add(editorObservaciones, gbc_editorObservaciones);
	
		

		//Buttons
		JButton btnBuscar = new JButton();
		btnBuscar.setIcon(new ImageIcon(".\\res\\buscar.png"));
		btnBuscar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.WEST;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 12;
		this.add(btnBuscar, gbc_btnBuscar);
		
		JButton btnAlta = new JButton();
		btnAlta.setIcon(new ImageIcon(".\\res\\alta.png"));
		btnAlta.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnAlta = new GridBagConstraints();
		gbc_btnAlta.insets = new Insets(0, 0, 5, 5);
		gbc_btnAlta.gridx = 4;
		gbc_btnAlta.gridy = 12;
		this.add(btnAlta, gbc_btnAlta);
		
		JButton btnModificar = new JButton();
		btnModificar.setIcon(new ImageIcon(".\\res\\modificar.png"));
		btnModificar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 5;
		gbc_btnModificar.gridy = 12;
		this.add(btnModificar, gbc_btnModificar);
		
		JButton btnBaja = new JButton();
		btnBaja.setIcon(new ImageIcon(".\\res\\borrar.png"));
		btnBaja.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnBaja = new GridBagConstraints();
		gbc_btnBaja.anchor = GridBagConstraints.WEST;
		gbc_btnBaja.insets = new Insets(0, 0, 5, 5);
		gbc_btnBaja.gridx = 6;
		gbc_btnBaja.gridy = 12;
		this.add(btnBaja, gbc_btnBaja);
		
		JButton btnGuardar = new JButton();
		btnGuardar.setIcon(new ImageIcon(".\\res\\guardar.png"));
		btnGuardar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 7;
		gbc_btnGuardar.gridy = 12;
		this.add(btnGuardar, gbc_btnGuardar);
		
		JButton btnCancelar = new JButton();
		btnCancelar.setIcon(new ImageIcon(".\\res\\cancelar.png"));
		btnCancelar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 8;
		gbc_btnCancelar.gridy = 12;
		this.add(btnCancelar, gbc_btnCancelar);
		
		JButton btnSalir = new JButton();
		btnSalir.setIcon(new ImageIcon(".\\res\\salir.png"));
		btnSalir.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalir.gridx = 9;
		gbc_btnSalir.gridy = 12;
		this.add(btnSalir, gbc_btnSalir);
		
	}
}
