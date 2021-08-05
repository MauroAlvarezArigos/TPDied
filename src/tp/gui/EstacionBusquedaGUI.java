package tp.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import tp.modelosTabla.EstacionBusquedaTableModel;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;


public class EstacionBusquedaGUI extends JFrame {
	private JTextField tbxNombre;
	private JTable resultados;	

	public EstacionBusquedaGUI() {
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
			
		ButtonGroup parametros = new ButtonGroup();
		
		JRadioButton rdbtnNombre = new JRadioButton("Nombre:");
		rdbtnNombre.setSelected(true);
		GridBagConstraints gbc_rdbtnNombre = new GridBagConstraints();
		gbc_rdbtnNombre.anchor = GridBagConstraints.EAST;
		gbc_rdbtnNombre.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNombre.gridx = 0;
		gbc_rdbtnNombre.gridy = 0;
		parametrosBusqueda.add(rdbtnNombre, gbc_rdbtnNombre);
		
		parametros.add(rdbtnNombre);
		
		tbxNombre = new JTextField();
		GridBagConstraints gbc_tbxNombre = new GridBagConstraints();
		tbxNombre.setColumns(20);
		gbc_tbxNombre.gridwidth = 2;
		gbc_tbxNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tbxNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbxNombre.gridx = 1;
		gbc_tbxNombre.gridy = 0;
		parametrosBusqueda.add(tbxNombre, gbc_tbxNombre);
		
		JRadioButton rdbtnEstado = new JRadioButton("Estado:");
		GridBagConstraints gbc_rdbtnEstado = new GridBagConstraints();
		gbc_rdbtnEstado.anchor = GridBagConstraints.EAST;
		gbc_rdbtnEstado.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEstado.gridx = 0;
		gbc_rdbtnEstado.gridy = 1;
		parametrosBusqueda.add(rdbtnEstado, gbc_rdbtnEstado);
		
		parametros.add(rdbtnEstado);
		
		JComboBox<String> cbxEstado = new JComboBox<String>();
		GridBagConstraints gbc_cbxEstado = new GridBagConstraints();
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
		this.setSize(526,248);	

	}
	
}
