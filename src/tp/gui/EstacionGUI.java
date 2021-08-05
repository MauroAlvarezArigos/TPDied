package tp.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class EstacionGUI extends JFrame {
	
	private JTextField tbxNombre;
	private JTextField tbxApertura;
	private JTextField tbxCierre;
	
	public EstacionGUI() {
		JPanel panelFrame = new JPanel();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};

		panelFrame.setLayout(new BorderLayout());
		
		JLabel lblEstacion = new JLabel("Gestión de Estaciones");
		lblEstacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstacion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelFrame.add(lblEstacion, BorderLayout.NORTH);
		
		JPanel datos = new JPanel();
		datos.setLayout(gridBagLayout);
		datos.setBorder(BorderFactory.createTitledBorder("Datos"));
		
		JPanel obs = new JPanel();
		GridBagLayout gbl_obs = new GridBagLayout();
		gbl_obs.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
		gbl_obs.columnWeights = new double[]{1.0};
		obs.setLayout(gbl_obs);
		obs.setBorder(BorderFactory.createTitledBorder("Observaciones"));
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		datos.add(lblNombre, gbc_lblNombre);
		
		tbxNombre = new JTextField();
		GridBagConstraints gbc_tbxNombre = new GridBagConstraints();
		gbc_tbxNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tbxNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbxNombre.gridx = 2;
		gbc_tbxNombre.gridy = 1;
		datos.add(tbxNombre, gbc_tbxNombre);
		tbxNombre.setColumns(20);
		
		JComboBox<String> cbxEstado = new JComboBox<String>();
		cbxEstado.setMaximumRowCount(10);
		cbxEstado.addItem("Operativa");
		cbxEstado.addItem("En Mantenimiento");
		
		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 2;
		datos.add(lblEstado, gbc_lblEstado);
		GridBagConstraints gbc_cbxEstado = new GridBagConstraints();
		gbc_cbxEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cbxEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxEstado.gridx = 2;
		gbc_cbxEstado.gridy = 2;
		datos.add(cbxEstado, gbc_cbxEstado);
		
		JLabel lblHorarios = new JLabel("Horarios");
		GridBagConstraints gbc_lblHorarios = new GridBagConstraints();
		gbc_lblHorarios.anchor = GridBagConstraints.WEST;
		gbc_lblHorarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorarios.gridx = 2;
		gbc_lblHorarios.gridy = 3;
		datos.add(lblHorarios, gbc_lblHorarios);
		
		JLabel lblApertura = new JLabel("Apertura:");
		GridBagConstraints gbc_lblApertura = new GridBagConstraints();
		gbc_lblApertura.anchor = GridBagConstraints.EAST;
		gbc_lblApertura.insets = new Insets(0, 0, 5, 5);
		gbc_lblApertura.gridx = 1;
		gbc_lblApertura.gridy = 4;
		datos.add(lblApertura, gbc_lblApertura);
		
		tbxApertura = new JTextField();
		GridBagConstraints gbc_tbxApertura = new GridBagConstraints();
		gbc_tbxApertura.anchor = GridBagConstraints.WEST;
		gbc_tbxApertura.insets = new Insets(0, 0, 5, 5);
		gbc_tbxApertura.gridx = 2;
		gbc_tbxApertura.gridy = 4;
		datos.add(tbxApertura, gbc_tbxApertura);
		tbxApertura.setColumns(10);
		
		JLabel lblCierre = new JLabel("Cierre:");
		GridBagConstraints gbc_lblCierre = new GridBagConstraints();
		gbc_lblCierre.anchor = GridBagConstraints.EAST;
		gbc_lblCierre.insets = new Insets(0, 0, 5, 5);
		gbc_lblCierre.gridx = 1;
		gbc_lblCierre.gridy = 5;
		datos.add(lblCierre, gbc_lblCierre);
		
		JEditorPane editorObservaciones = new JEditorPane();
		GridBagConstraints gbc_editorObservaciones = new GridBagConstraints();
		gbc_editorObservaciones.gridheight = 5;
		gbc_editorObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_editorObservaciones.fill = GridBagConstraints.BOTH;
		gbc_editorObservaciones.gridx = 0;
		gbc_editorObservaciones.gridy = 0;
		obs.add(editorObservaciones, gbc_editorObservaciones);
		panelFrame.add(obs, BorderLayout.EAST);

		
		panelFrame.add(datos, BorderLayout.CENTER);
		
		tbxCierre = new JTextField();
		GridBagConstraints gbc_tbxCierre = new GridBagConstraints();
		gbc_tbxCierre.anchor = GridBagConstraints.WEST;
		gbc_tbxCierre.insets = new Insets(0, 0, 5, 5);
		gbc_tbxCierre.gridx = 2;
		gbc_tbxCierre.gridy = 5;
		datos.add(tbxCierre, gbc_tbxCierre);
		tbxCierre.setColumns(10);
		
		
		//Buttons
		JPanel botones = new JPanel();
		GridBagLayout gbl_botones = new GridBagLayout();
		gbl_botones.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		botones.setLayout(gbl_botones);
		
		JButton btnBuscar = new JButton();
		btnBuscar.setIcon(new ImageIcon(".\\res\\buscar.png"));
		btnBuscar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.WEST;
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 0;
		gbc_btnBuscar.gridy = 0;
		botones.add(btnBuscar, gbc_btnBuscar);
		
		btnBuscar.addActionListener(e -> {
			EstacionBusquedaGUI eb = new EstacionBusquedaGUI();
			eb.setVisible(true);
		});
		
		JButton btnAlta = new JButton();
		btnAlta.setIcon(new ImageIcon(".\\res\\alta.png"));
		btnAlta.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnAlta = new GridBagConstraints();
		gbc_btnAlta.insets = new Insets(0, 0, 0, 5);
		gbc_btnAlta.gridx = 2;
		gbc_btnAlta.gridy = 0;
		botones.add(btnAlta, gbc_btnAlta);
		
		JButton btnModificar = new JButton();
		btnModificar.setIcon(new ImageIcon(".\\res\\modificar.png"));
		btnModificar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 0, 5);
		gbc_btnModificar.gridx = 3;
		gbc_btnModificar.gridy = 0;
		botones.add(btnModificar, gbc_btnModificar);

		JButton btnBaja = new JButton();
		btnBaja.setIcon(new ImageIcon(".\\res\\borrar.png"));
		btnBaja.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnBaja = new GridBagConstraints();
		gbc_btnBaja.anchor = GridBagConstraints.WEST;
		gbc_btnBaja.insets = new Insets(0, 0, 0, 5);
		gbc_btnBaja.gridx = 4;
		gbc_btnBaja.gridy = 0;
		botones.add(btnBaja, gbc_btnBaja);
		
		JButton btnGuardar = new JButton();
		btnGuardar.setIcon(new ImageIcon(".\\res\\guardar.png"));
		btnGuardar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 6;
		gbc_btnGuardar.gridy = 0;
		botones.add(btnGuardar, gbc_btnGuardar);
		
		JButton btnCancelar = new JButton();
		btnCancelar.setIcon(new ImageIcon(".\\res\\cancelar.png"));
		btnCancelar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 7;
		gbc_btnCancelar.gridy = 0;
		botones.add(btnCancelar, gbc_btnCancelar);
		
		JButton btnSalir = new JButton();
		btnSalir.setIcon(new ImageIcon(".\\res\\salir.png"));
		btnSalir.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.gridx = 9;
		gbc_btnSalir.gridy = 0;
		botones.add(btnSalir, gbc_btnSalir);
		
		btnSalir.addActionListener(e -> dispose());
		
		
		panelFrame.add(botones, BorderLayout.SOUTH);
		
		this.getContentPane().add(panelFrame);
		this.pack();
		this.setSize(500,300);	

	}
}
