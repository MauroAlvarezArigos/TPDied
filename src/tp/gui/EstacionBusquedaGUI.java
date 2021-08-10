package tp.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import tp.controller.EstacionController;
import tp.dominio.Estacion;
import tp.modelosTabla.EstacionBusquedaTableModel;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;


public class EstacionBusquedaGUI extends JFrame {
	private JTextField tbxNombre;
	private JTable resultados;
	
	private EstacionController controller;
	
	public EstacionBusquedaGUI() {
		controller = new EstacionController(null);
		setResizable(false);
				
		JPanel panelFrame = new JPanel();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
		
		panelFrame.setLayout(new BorderLayout());
		
		TitledBorder parametrosBorder = BorderFactory.createTitledBorder("Parametros");
		TitledBorder resultadosBorder = BorderFactory.createTitledBorder("Resultados");
		
		
		JPanel parametrosBusqueda = new JPanel();
		parametrosBusqueda.setBorder(parametrosBorder);
		parametrosBusqueda.setLayout(gridBagLayout);
		
		
		JLabel lblBuscarEstacion = new JLabel("Buscar Estación");
		lblBuscarEstacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarEstacion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		parametrosBusqueda.add(lblNombre, gbc_lblNombre);

		tbxNombre = new JTextField();
		GridBagConstraints gbc_tbxNombre = new GridBagConstraints();
		tbxNombre.setColumns(20);
		gbc_tbxNombre.gridwidth = 2;
		gbc_tbxNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tbxNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbxNombre.gridx = 1;
		gbc_tbxNombre.gridy = 0;
		parametrosBusqueda.add(tbxNombre, gbc_tbxNombre);
		
		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 1;
		parametrosBusqueda.add(lblEstado, gbc_lblEstado);
		
		JComboBox<String> cbxEstado = new JComboBox<String>();
		GridBagConstraints gbc_cbxEstado = new GridBagConstraints();
		cbxEstado.addItem("Ambos");
		cbxEstado.addItem("Operativa");
		cbxEstado.addItem("En Mantenimiento");
		gbc_cbxEstado.gridwidth = 2;
		gbc_cbxEstado.insets = new Insets(0, 0, 5, 0);
		gbc_cbxEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxEstado.gridx = 1;
		gbc_cbxEstado.gridy = 1;
		parametrosBusqueda.add(cbxEstado, gbc_cbxEstado);
		
		JButton btnBuscar = new JButton();
		btnBuscar.setIcon(new ImageIcon(".\\res\\busqueda.png"));
		btnBuscar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.LINE_END;
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 2;
		parametrosBusqueda.add(btnBuscar, gbc_btnBuscar);
		
		//LLamar al servicio de busqueda
		
		JButton btnCancelar = new JButton();
		btnCancelar.setIcon(new ImageIcon(".\\res\\cancelar.png"));
		btnCancelar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.LINE_START;
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 2;
		parametrosBusqueda.add(btnCancelar, gbc_btnCancelar);
		
		
	  	btnBuscar.addActionListener(e -> {
	  		Map<String, String> atributos = new HashMap<String, String>();
	  		try{
	  			if(cbxEstado.getSelectedItem().toString() == "Operativa"){
	  				atributos.put("ESTADO","1");
				}
				else if(cbxEstado.getSelectedItem().toString() == "En Mantenimiento"){
	  				atributos.put("ESTADO","0");
				}
	  			else {
	  				atributos.put("ESTADO","Ambos");
	  			}
	  			//List<Estacion> lista = new ArrayList<Estacion>();
	  			
	  			atributos.put("NOMBRE",tbxNombre.getText());
				controller.buscar(atributos);
				
				//System.out.println(lista.toString());
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		});
		
		
		btnCancelar.addActionListener(e -> dispose());
		
		/// CREAR TABLA
		EstacionBusquedaTableModel modelo = new EstacionBusquedaTableModel();
		resultados = new JTable(modelo);
		resultados.setBorder(new LineBorder(new Color(0, 0, 0)));
		resultados.setPreferredScrollableViewportSize(new Dimension(500,70));

		JScrollPane scrollPane = new JScrollPane(resultados);
		scrollPane.setBorder(resultadosBorder);		
		///
		
		panelFrame.add(lblBuscarEstacion, BorderLayout.PAGE_START);
		panelFrame.add(parametrosBusqueda, BorderLayout.LINE_START);
		panelFrame.add(scrollPane, BorderLayout.CENTER);
		
		this.getContentPane().add(panelFrame);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setSize(526,248);	

	}
	
}
