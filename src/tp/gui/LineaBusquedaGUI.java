package tp.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;
import javax.swing.table.DefaultTableModel;

import tp.controller.EstacionController;
import tp.controller.LineaController;
import tp.dominio.Estacion;
import tp.dominio.Linea;
import tp.modelosTabla.EstacionBusquedaTableModel;

public class LineaBusquedaGUI extends JFrame {
	private JTextField tbxNombre;
	private JTextField tbxColor;

	private LineaController controller;
	private Linea linea;
	
	public LineaBusquedaGUI(LineaGUI lin) {
		controller = lin.getController();
		init();
	}
	
	public void init() {
		// al seleccionar nombre/color y a la vez estado, se seleccionan ambas xd
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
		
		
		JLabel lblBuscarEstacion = new JLabel("Buscar Linea");
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
		
		JLabel lblColor = new JLabel("Color:");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 1;
		parametrosBusqueda.add(lblColor, gbc_lblColor);
		
		
		tbxColor = new JTextField();
		GridBagConstraints gbc_tbxColor = new GridBagConstraints();
		tbxNombre.setColumns(20);
		gbc_tbxColor.gridwidth = 2;
		gbc_tbxColor.insets = new Insets(0, 0, 5, 0);
		gbc_tbxColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbxColor.gridx = 1;
		gbc_tbxColor.gridy = 1;
		parametrosBusqueda.add(tbxColor, gbc_tbxColor);
		
		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 2;
		parametrosBusqueda.add(lblEstado, gbc_lblEstado);
				
		JComboBox<String> cbxEstado = new JComboBox<String>();
		GridBagConstraints gbc_cbxEstado = new GridBagConstraints();
		cbxEstado.addItem("Ambos");
		cbxEstado.addItem("Activa");
		cbxEstado.addItem("No Activa");
		gbc_cbxEstado.gridwidth = 2;
		gbc_cbxEstado.insets = new Insets(0, 0, 5, 0);
		gbc_cbxEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxEstado.gridx = 1;
		gbc_cbxEstado.gridy = 2;
		parametrosBusqueda.add(cbxEstado, gbc_cbxEstado);
		
		
		//Buttons		
		JButton btnBuscar = new JButton();
		btnBuscar.setIcon(new ImageIcon(".\\res\\busqueda.png"));
		btnBuscar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.LINE_END;
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 3;
		parametrosBusqueda.add(btnBuscar, gbc_btnBuscar);
		
		JButton btnCancelar = new JButton();
		btnCancelar.setIcon(new ImageIcon(".\\res\\cancelar.png"));
		btnCancelar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.LINE_START;
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 3;
		parametrosBusqueda.add(btnCancelar, gbc_btnCancelar);
		
		panelFrame.add(lblBuscarEstacion, BorderLayout.PAGE_START);
		panelFrame.add(parametrosBusqueda, BorderLayout.LINE_START);
	
		this.getContentPane().add(panelFrame);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setSize(526,248);
		
		JScrollPane scrollPane = new JScrollPane();
		btnBuscar.addActionListener(e -> {
	  		Map<String, String> atributos = new HashMap<String, String>();
	  		try{
	  			
	  			if(cbxEstado.getSelectedItem().toString() == "Activa"){
	  				atributos.put("ESTADO","1");
				}
				else if(cbxEstado.getSelectedItem().toString() == "No Activa"){
	  				atributos.put("ESTADO","0");
				}
	  			else {
	  				atributos.put("ESTADO","Ambos");
	  			}
	  			//List<Estacion> lista = new ArrayList<Estacion>();
	  			
	  			atributos.put("NOMBRE",tbxNombre.getText());
	  			atributos.put("COLOR", tbxColor.getText());
				List<Linea> ret = controller.buscar(atributos);
				int tam = ret.size();
				Object[][] tabla = new Object[tam][3];
				for(int i=0; i<tam; i++) {
					tabla[i][0] = ret.get(i).getNombre();
					tabla[i][1] = ret.get(i).getColor();
					tabla[i][2] = ret.get(i).getEstado() == 1 ? "Activa":"No Activa";
				}
				String[] columnNames = {"Nombre", "Color", "Estado"};
				DefaultTableModel dtm = new DefaultTableModel(tabla, columnNames);
			    final JTable table = new JTable(dtm);
			    table.setPreferredScrollableViewportSize(new Dimension(250, 100));
			    scrollPane.setViewportView(table);
			    scrollPane.setBorder(resultadosBorder);	
			    panelFrame.add(scrollPane, BorderLayout.CENTER);
			    scrollPane.setVisible(true);
			    SwingUtilities.updateComponentTreeUI(panelFrame);
			    
			    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				    @Override
				    public void valueChanged(ListSelectionEvent event) {
				        if (table.getSelectedRow() > -1) {
				        	linea = ret.get(table.getSelectedRow());
				        	controller.cargarDatosEncontrados(linea);
				    		dispose();
				        }
				    }

				});
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		});
		
		btnCancelar.addActionListener(e -> dispose());
	}


}
