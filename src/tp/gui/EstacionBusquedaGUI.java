package tp.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class EstacionBusquedaGUI extends JPanel {
	private JTextField tbxNombre;
	private JTable resultados;
	
	

	public EstacionBusquedaGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		
		JLabel lblBuscarEstacion = new JLabel("Buscar Estación");
		lblBuscarEstacion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblBuscarEstacion = new GridBagConstraints();
		gbc_lblBuscarEstacion.gridwidth = 2;
		gbc_lblBuscarEstacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuscarEstacion.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_lblBuscarEstacion.gridx = 3;
		gbc_lblBuscarEstacion.gridy = 2;
		this.add(lblBuscarEstacion, gbc_lblBuscarEstacion);
		
		JLabel lblResultados = new JLabel("Resultados:");
		GridBagConstraints gbc_lblResultados = new GridBagConstraints();
		gbc_lblResultados.insets = new Insets(0, 0, 5, 5);
		gbc_lblResultados.anchor = GridBagConstraints.LAST_LINE_START;
		gbc_lblResultados.gridx = 6;
		gbc_lblResultados.gridy = 2;
		this.add(lblResultados, gbc_lblResultados);
		
		ButtonGroup parametros = new ButtonGroup();
		
		JRadioButton rdbtnNombre = new JRadioButton("Nombre:");
		rdbtnNombre.setSelected(true);
		GridBagConstraints gbc_rdbtnNombre = new GridBagConstraints();
		gbc_rdbtnNombre.anchor = GridBagConstraints.EAST;
		gbc_rdbtnNombre.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNombre.gridx = 2;
		gbc_rdbtnNombre.gridy = 4;
		this.add(rdbtnNombre, gbc_rdbtnNombre);
		
		parametros.add(rdbtnNombre);
		
		tbxNombre = new JTextField();
		GridBagConstraints gbc_tbxNombre = new GridBagConstraints();
		tbxNombre.setColumns(20);
		gbc_tbxNombre.gridwidth = 2;
		gbc_tbxNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tbxNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbxNombre.gridx = 3;
		gbc_tbxNombre.gridy = 4;
		this.add(tbxNombre, gbc_tbxNombre);
		
		JRadioButton rdbtnEstado = new JRadioButton("Estado:");
		GridBagConstraints gbc_rdbtnEstado = new GridBagConstraints();
		gbc_rdbtnEstado.anchor = GridBagConstraints.EAST;
		gbc_rdbtnEstado.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEstado.gridx = 2;
		gbc_rdbtnEstado.gridy = 5;
		this.add(rdbtnEstado, gbc_rdbtnEstado);
		
		parametros.add(rdbtnEstado);
		
		JComboBox<String> cbxEstado = new JComboBox<String>();
		GridBagConstraints gbc_cbxEstado = new GridBagConstraints();
		cbxEstado.addItem("Operativa");
		cbxEstado.addItem("En Mantenimiento");
		gbc_cbxEstado.gridwidth = 2;
		gbc_cbxEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cbxEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxEstado.gridx = 3;
		gbc_cbxEstado.gridy = 5;
		this.add(cbxEstado, gbc_cbxEstado);
		
		JButton btnBuscar = new JButton();
		btnBuscar.setIcon(new ImageIcon(".\\res\\busqueda.png"));
		btnBuscar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.LINE_END;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 6;
		this.add(btnBuscar, gbc_btnBuscar);
		
		JButton btnCancelar = new JButton();
		btnCancelar.setIcon(new ImageIcon(".\\res\\cancelar.png"));
		btnCancelar.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.LINE_START;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 6;
		this.add(btnCancelar, gbc_btnCancelar);
		
		resultados = new JTable();
		resultados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Estado"
			}
		));
		
		resultados.getColumnModel().getColumn(0).setPreferredWidth(44);
		GridBagConstraints gbc_resultados = new GridBagConstraints();
		gbc_resultados.gridheight = 4;
		gbc_resultados.insets = new Insets(0, 0, 5, 5);
		gbc_resultados.fill = GridBagConstraints.BOTH;
		gbc_resultados.gridx = 6;
		gbc_resultados.gridy = 3;
		add(resultados, gbc_resultados);

	}
}
