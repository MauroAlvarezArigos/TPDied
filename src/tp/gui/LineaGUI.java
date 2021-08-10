package tp.gui;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.*;

import tp.Excepciones.DatosObligatoriosException;
import tp.controller.LineaController;

public class LineaGUI extends JFrame {

	private JTextField tbxNombre;
	private JTextField tbxColor;
	private JComboBox<String> cbxEstado;
	private JButton btnBuscar;
	private JButton btnTrayectos;
	private JButton btnAlta;
	private JButton btnModificar;
	private JButton btnBaja;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnSalir;
	private Byte flag;
	private LineaController controller;

	public LineaGUI() {
		controller = new LineaController(this);
		flag = 0;
		JPanel panelFrame = new JPanel();
		panelFrame.setLayout(new BorderLayout());
		
		JLabel lblLinea = new JLabel("Gestión de Lineas");
		lblLinea.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLinea.setHorizontalAlignment(SwingConstants.CENTER);
		panelFrame.add(lblLinea, BorderLayout.NORTH);
		
		JPanel datos = new JPanel();
		datos.setLayout(new GridBagLayout());
		datos.setBorder(BorderFactory.createTitledBorder("Datos"));
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.LINE_END;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		datos.add(lblNombre, gbc_lblNombre);
		
		tbxNombre = new JTextField();
		GridBagConstraints gbc_tbxNombre = new GridBagConstraints();
		gbc_tbxNombre.anchor = GridBagConstraints.LINE_START;
		gbc_tbxNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tbxNombre.gridx = 2;
		gbc_tbxNombre.gridy = 3;
		tbxNombre.setColumns(20);
		datos.add(tbxNombre, gbc_tbxNombre);
		
		JLabel lblNewLabel = new JLabel("Color:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.LINE_END;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 4;
		datos.add(lblNewLabel, gbc_lblNewLabel);
		
		tbxColor = new JTextField();
		GridBagConstraints gbc_tbxColor = new GridBagConstraints();
		gbc_tbxColor.anchor = GridBagConstraints.LINE_START;
		gbc_tbxColor.insets = new Insets(0, 0, 5, 5);
		gbc_tbxColor.gridx = 2;
		gbc_tbxColor.gridy = 4;
		tbxColor.setColumns(20);
		datos.add(tbxColor, gbc_tbxColor);
		
		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.LINE_END;
		gbc_lblEstado.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 5;
		datos.add(lblEstado, gbc_lblEstado);
		
		cbxEstado = new JComboBox<String>();
		cbxEstado.setMaximumRowCount(10);
		cbxEstado.addItem("Activa");
		cbxEstado.addItem("No Activa");
		GridBagConstraints gbc_cbxEstado = new GridBagConstraints();
		gbc_cbxEstado.anchor = GridBagConstraints.LINE_START;
		gbc_cbxEstado.insets = new Insets(0, 0, 0, 5);
		gbc_cbxEstado.gridx = 2;
		gbc_cbxEstado.gridy = 5;
		datos.add(cbxEstado, gbc_cbxEstado);
	
		//Buttons
		JPanel botones = new JPanel();
		GridBagLayout gbl_botones = new GridBagLayout();
		gbl_botones.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0};
		botones.setLayout(gbl_botones);
				
		btnBuscar = new JButton();
		btnBuscar.setIcon(new ImageIcon(".\\res\\buscar.png"));
		btnBuscar.setMargin(new Insets(0, 0, 0, 0));
		btnBuscar.setText("Buscar");
		btnBuscar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscar.setVerticalTextPosition(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 0;
		gbc_btnBuscar.gridy = 0;
		botones.add(btnBuscar, gbc_btnBuscar);
		
		btnTrayectos = new JButton();
		btnTrayectos.setIcon(new ImageIcon(".\\res\\trayecto.png"));
		btnTrayectos.setMargin(new Insets(0, 0, 0, 0));
		btnTrayectos.setText("Trayectos");
		btnTrayectos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTrayectos.setVerticalTextPosition(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnTrayectos = new GridBagConstraints();
		gbc_btnTrayectos.insets = new Insets(0, 0, 5, 5);
		gbc_btnTrayectos.gridx = 1;
		gbc_btnTrayectos.gridy = 0;
		botones.add(btnTrayectos, gbc_btnTrayectos);
		
		btnAlta = new JButton();
		btnAlta.setIcon(new ImageIcon(".\\res\\alta.png"));
		btnAlta.setMargin(new Insets(0, 0, 0, 0));
		btnAlta.setText("Nuevo");
		btnAlta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAlta.setVerticalTextPosition(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnAlta = new GridBagConstraints();
		gbc_btnAlta.insets = new Insets(0, 0, 5, 5);
		gbc_btnAlta.gridx = 2;
		gbc_btnAlta.gridy = 0;
		botones.add(btnAlta, gbc_btnAlta);
		
		btnModificar = new JButton();
		btnModificar.setIcon(new ImageIcon(".\\res\\modificar.png"));
		btnModificar.setMargin(new Insets(0, 0, 0, 0));
		btnModificar.setText("Modificar");
		btnModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 3;
		gbc_btnModificar.gridy = 0;
		botones.add(btnModificar, gbc_btnModificar);
		
		btnBaja = new JButton();
		btnBaja.setIcon(new ImageIcon(".\\res\\borrar.png"));
		btnBaja.setMargin(new Insets(0, 0, 0, 0));
		btnBaja.setText("Borrar");
		btnBaja.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBaja.setVerticalTextPosition(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnBaja = new GridBagConstraints();
		gbc_btnBaja.insets = new Insets(0, 0, 5, 5);
		gbc_btnBaja.gridx = 4;
		gbc_btnBaja.gridy = 0;
		botones.add(btnBaja, gbc_btnBaja);
		
		btnGuardar = new JButton();
		btnGuardar.setIcon(new ImageIcon(".\\res\\guardar.png"));
		btnGuardar.setMargin(new Insets(0, 0, 0, 0));
		btnGuardar.setText("Guardar");
		btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 6;
		gbc_btnGuardar.gridy = 0;
		botones.add(btnGuardar, gbc_btnGuardar);
		
		//LLamar a la capa de servicio y validar todo, luego guardar en bd
		
		btnCancelar = new JButton();
		btnCancelar.setIcon(new ImageIcon(".\\res\\cancelar.png"));
		btnCancelar.setMargin(new Insets(0, 0, 0, 0));
		btnCancelar.setText("Cancelar");                                  
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);    
		btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 7;
		gbc_btnCancelar.gridy = 0;
		botones.add(btnCancelar, gbc_btnCancelar);
		
		//Preg si esta seguro y si lo esta borrar todo lo lleno
		
		btnSalir = new JButton();
		btnSalir.setIcon(new ImageIcon(".\\res\\salir.png"));
		btnSalir.setMargin(new Insets(0, 0, 0, 0));
		btnSalir.setText("Salir");                             
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalir.gridx = 9;
		gbc_btnSalir.gridy = 0;
		botones.add(btnSalir, gbc_btnSalir);
		
		//Buttons Listeners
		btnBuscar.addActionListener(e -> {
			LineaBusquedaGUI lb = new LineaBusquedaGUI();
			lb.setVisible(true);
		});
		
		btnTrayectos.addActionListener(e -> {
			RegistrarTrayectoGUI rt = new RegistrarTrayectoGUI();
			rt.setVisible(true);
		});
			
		btnAlta.addActionListener(e -> {
			flag = 1;
			activarEdits();
			
			setOperationState();
		});

		btnModificar.addActionListener(e -> {
			flag = 2;
			activarEdits();
			
			setOperationState();
		});
		
		btnBaja.addActionListener(e -> {
			int n = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar la estación?", "CUIDADO!", JOptionPane.YES_NO_OPTION);
			if(n == 0) {
				//Llamar al handler y eliminar elemento de la DB
				System.out.println("Eliminando elemento de la base de datos...");
			}
		});
		
		btnGuardar.addActionListener(e -> {
			
			if(flag == 1) {
				System.out.println("WTF");
				try {
					controller.guardar();
				} catch(DatosObligatoriosException e1) {
					this.mostrarError("Error al guardar", e1.getMensaje());
					System.out.println(e1.getMensaje());
				} catch(Exception e2) {
					this.mostrarError("Error al guardar", e2.getMessage());
				}
				
			}
			else if(flag == 2) {
				try {
					controller.modificar();
				} catch(DatosObligatoriosException e1) {
					this.mostrarError("Error al guardar", e1.getMensaje());
					System.out.println(e1.getMensaje());
				} catch(Exception e2) {
					this.mostrarError("Error al guardar", e2.getMessage());
				}
			}
		});
		
		btnCancelar.addActionListener(e -> {
			int n = JOptionPane.showConfirmDialog(this, "¿Estas seguro?", "CUIDADO!", JOptionPane.YES_NO_OPTION);
			if(n == 0) {
				limpiarCampos();
				setInitialState();
			}
		});
			
		
		
		btnSalir.addActionListener(e -> dispose());
		
		panelFrame.add(datos, BorderLayout.CENTER);
		panelFrame.add(botones, BorderLayout.SOUTH);
		
		setInitialState();
		desactivarEdits();
		
		this.getContentPane().add(panelFrame);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setSize(500,300);

	}
	
	private void setInitialState() {
		btnBuscar.setEnabled(true);
		btnTrayectos.setEnabled(false);
		btnAlta.setEnabled(true);
		btnModificar.setEnabled(false);
		btnBaja.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnSalir.setEnabled(true);
	}
	
	private void setOperationState() {
		btnBuscar.setEnabled(false);
		btnTrayectos.setEnabled(false);
		btnAlta.setEnabled(false);
		btnModificar.setEnabled(false);
		btnBaja.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnSalir.setEnabled(false);
	}
	
	private void limpiarCampos() {
		tbxNombre.setText("");
		tbxColor.setText("");
		cbxEstado.setSelectedIndex(0);
	}
	
	private void desactivarEdits() {
		tbxNombre.setEnabled(false);
		tbxColor.setEnabled(false);
		cbxEstado.setEnabled(false);
	}
	
	private void activarEdits() {
		tbxNombre.setEnabled(true);
		tbxColor.setEnabled(true);
		cbxEstado.setEnabled(true);
	}

	public JTextField getTbxNombre() {
		return tbxNombre;
	}

	public void setTbxNombre(JTextField tbxNombre) {
		this.tbxNombre = tbxNombre;
	}

	public JTextField getTbxColor() {
		return tbxColor;
	}

	public void setTbxColor(JTextField tbxColor) {
		this.tbxColor = tbxColor;
	}

	public JComboBox<String> getCbxEstado() {
		return cbxEstado;
	}

	public void setCbxEstado(JComboBox<String> cbxEstado) {
		this.cbxEstado = cbxEstado;
	}

	public Byte getFlag() {
		return flag;
	}

	public void setFlag(Byte flag) {
		this.flag = flag;
	}

	public void mostrarError(String titulo,String detalle) {
		JFrame padre= (JFrame) SwingUtilities.getWindowAncestor(this);
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.ERROR_MESSAGE);
	}
}
