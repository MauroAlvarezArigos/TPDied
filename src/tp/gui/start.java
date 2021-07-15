package tp.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Font;


public class start extends JFrame {
	private JTextField tbxNombre;
	private JTextField tbxApertura;
	private JTextField tbxCierre;
	public start() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 52, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblEstacion = new JLabel("Gestion de Estaciones");
		lblEstacion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblEstacion = new GridBagConstraints();
		gbc_lblEstacion.gridwidth = 5;
		gbc_lblEstacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstacion.gridx = 5;
		gbc_lblEstacion.gridy = 4;
		getContentPane().add(lblEstacion, gbc_lblEstacion);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 6;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		tbxNombre = new JTextField();
		GridBagConstraints gbc_tbxNombre = new GridBagConstraints();
		gbc_tbxNombre.gridwidth = 2;
		gbc_tbxNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tbxNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbxNombre.gridx = 4;
		gbc_tbxNombre.gridy = 6;
		getContentPane().add(tbxNombre, gbc_tbxNombre);
		tbxNombre.setColumns(20);
		
		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 6;
		gbc_lblEstado.gridy = 6;
		getContentPane().add(lblEstado, gbc_lblEstado);
		
		JComboBox cbxEstado = new JComboBox();
		cbxEstado.setMaximumRowCount(10);
		GridBagConstraints gbc_cbxEstado = new GridBagConstraints();
		gbc_cbxEstado.gridwidth = 3;
		gbc_cbxEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cbxEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxEstado.gridx = 7;
		gbc_cbxEstado.gridy = 6;
		getContentPane().add(cbxEstado, gbc_cbxEstado);
		
		JLabel lblHorarios = new JLabel("Horarios");
		GridBagConstraints gbc_lblHorarios = new GridBagConstraints();
		gbc_lblHorarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorarios.gridx = 7;
		gbc_lblHorarios.gridy = 8;
		getContentPane().add(lblHorarios, gbc_lblHorarios);
		
		JLabel lblApertura = new JLabel("Apertura:");
		GridBagConstraints gbc_lblApertura = new GridBagConstraints();
		gbc_lblApertura.anchor = GridBagConstraints.EAST;
		gbc_lblApertura.insets = new Insets(0, 0, 5, 5);
		gbc_lblApertura.gridx = 6;
		gbc_lblApertura.gridy = 9;
		getContentPane().add(lblApertura, gbc_lblApertura);
		
		tbxApertura = new JTextField();
		GridBagConstraints gbc_tbxApertura = new GridBagConstraints();
		gbc_tbxApertura.insets = new Insets(0, 0, 5, 5);
		gbc_tbxApertura.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbxApertura.gridx = 7;
		gbc_tbxApertura.gridy = 9;
		getContentPane().add(tbxApertura, gbc_tbxApertura);
		tbxApertura.setColumns(10);
		
		JLabel lblCierre = new JLabel("Cierre:");
		GridBagConstraints gbc_lblCierre = new GridBagConstraints();
		gbc_lblCierre.anchor = GridBagConstraints.EAST;
		gbc_lblCierre.insets = new Insets(0, 0, 5, 5);
		gbc_lblCierre.gridx = 6;
		gbc_lblCierre.gridy = 10;
		getContentPane().add(lblCierre, gbc_lblCierre);
		
		tbxCierre = new JTextField();
		GridBagConstraints gbc_tbxCierre = new GridBagConstraints();
		gbc_tbxCierre.insets = new Insets(0, 0, 5, 5);
		gbc_tbxCierre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbxCierre.gridx = 7;
		gbc_tbxCierre.gridy = 10;
		getContentPane().add(tbxCierre, gbc_tbxCierre);
		tbxCierre.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon("E:\\Programacion\\Java\\TPDied\\res\\buscar.png"));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.WEST;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 12;
		getContentPane().add(btnBuscar, gbc_btnBuscar);
		
		JButton btnAlta = new JButton("");
		btnAlta.setIcon(new ImageIcon("E:\\Programacion\\Java\\TPDied\\res\\alta.png"));
		GridBagConstraints gbc_btnAlta = new GridBagConstraints();
		gbc_btnAlta.insets = new Insets(0, 0, 5, 5);
		gbc_btnAlta.gridx = 5;
		gbc_btnAlta.gridy = 12;
		getContentPane().add(btnAlta, gbc_btnAlta);
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon("E:\\Programacion\\Java\\TPDied\\res\\modificar.png"));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 6;
		gbc_btnModificar.gridy = 12;
		getContentPane().add(btnModificar, gbc_btnModificar);
		
		JButton btnBaja = new JButton("");
		btnBaja.setIcon(new ImageIcon("E:\\Programacion\\Java\\TPDied\\res\\borrar.png"));
		GridBagConstraints gbc_btnBaja = new GridBagConstraints();
		gbc_btnBaja.anchor = GridBagConstraints.WEST;
		gbc_btnBaja.insets = new Insets(0, 0, 5, 5);
		gbc_btnBaja.gridx = 7;
		gbc_btnBaja.gridy = 12;
		getContentPane().add(btnBaja, gbc_btnBaja);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon("E:\\Programacion\\Java\\TPDied\\res\\guardar.png"));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 9;
		gbc_btnGuardar.gridy = 12;
		getContentPane().add(btnGuardar, gbc_btnGuardar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon("E:\\Programacion\\Java\\TPDied\\res\\cancelar.png"));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 10;
		gbc_btnCancelar.gridy = 12;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
		
		JButton btnCancelar_1 = new JButton("");
		btnCancelar_1.setIcon(new ImageIcon("E:\\Programacion\\Java\\TPDied\\res\\salir.png"));
		GridBagConstraints gbc_btnCancelar_1 = new GridBagConstraints();
		gbc_btnCancelar_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar_1.gridx = 13;
		gbc_btnCancelar_1.gridy = 12;
		getContentPane().add(btnCancelar_1, gbc_btnCancelar_1);
	}
	
}
