package tp.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import tp.dominio.Estacion;
import tp.modelosTabla.PageRankTableModel;

public class ParametrosGUI extends JFrame {
	
	public ParametrosGUI() {
		JPanel panelFrame = new JPanel();
		panelFrame.setLayout(new BorderLayout());
		
		JLabel lblParametros = new JLabel("Parametros");
		lblParametros.setHorizontalAlignment(SwingConstants.CENTER);
		lblParametros.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelFrame.add(lblParametros, BorderLayout.NORTH);
		
		//Flujo maximo
		JPanel flujoMax = new JPanel();
		flujoMax.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Consultar Flujo Maximo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		flujoMax.setLayout(gridBagLayout);
		
		JLabel lblEstacion = new JLabel("Estaci�n:");
		GridBagConstraints gbc_lblEstacion = new GridBagConstraints();
		gbc_lblEstacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstacion.anchor = GridBagConstraints.EAST;
		gbc_lblEstacion.gridx = 2;
		gbc_lblEstacion.gridy = 1;
		flujoMax.add(lblEstacion, gbc_lblEstacion);
		
		JComboBox<Estacion> cbxEstacion = new JComboBox<Estacion>();
		GridBagConstraints gbc_cbxEstacion = new GridBagConstraints();
		gbc_cbxEstacion.anchor = GridBagConstraints.WEST;
		gbc_cbxEstacion.insets = new Insets(0, 0, 5, 5);
		gbc_cbxEstacion.gridx = 3;
		gbc_cbxEstacion.gridy = 1;
		flujoMax.add(cbxEstacion, gbc_cbxEstacion);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setIcon(new ImageIcon(".\\res\\calcular.png"));
		btnCalcular.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnCalcular = new GridBagConstraints();
		gbc_btnCalcular.anchor = GridBagConstraints.WEST;
		gbc_btnCalcular.insets = new Insets(0, 0, 5, 0);
		gbc_btnCalcular.gridx = 4;
		gbc_btnCalcular.gridy = 1;
		flujoMax.add(btnCalcular, gbc_btnCalcular);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Flujo M�ximo", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 3;
		panel.setVisible(false);
		flujoMax.add(panel, gbc_panel);
		
		JLabel lblFlujoMax = new JLabel("");
		panel.add(lblFlujoMax);
		lblFlujoMax.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		btnCalcular.addActionListener(e -> {
			lblFlujoMax.setText("MauroCAPO"); //PONE ACA LO QUE CALCULASTE 	
			panel.setVisible(true);
		});
		
		//PageRank
		PageRankTableModel modelo = new PageRankTableModel();
		JTable pagerank = new JTable(modelo);
		pagerank.setBorder(new LineBorder(new Color(0, 0, 0)));
		pagerank.setPreferredScrollableViewportSize(new Dimension(500,70));
		
		JScrollPane scrollPane = new JScrollPane(pagerank);
		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Page Rank", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setVisible(false);
		
		//Proximo Mantenimiento
		JPanel mant = new JPanel();
		mant.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mantenimiento URGENTE", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_mant = new GridBagLayout();
		gbl_mant.columnWidths = new int[]{0, 0, 0, 0};
		gbl_mant.rowHeights = new int[]{0, 0, 0, 0};
		gbl_mant.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_mant.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		mant.setLayout(gbl_mant);
		
		JLabel lblEstacionMant = new JLabel("9 de Julio");
		lblEstacionMant.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblEstacionMant = new GridBagConstraints();
		gbc_lblEstacionMant.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstacionMant.gridx = 1;
		gbc_lblEstacionMant.gridy = 1;
		mant.add(lblEstacionMant, gbc_lblEstacionMant);
		
		JLabel lblFecha = new JLabel("Ultimo mantenimiento: 10/12/2019");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 0, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 2;
		mant.add(lblFecha, gbc_lblFecha);
		
		
		//Botones		
		JPanel botones = new JPanel();
		JButton btnFlujoMax = new JButton("Flujo Maximo");
		JButton btnPageRank = new JButton("Page Rank");
		JButton btnProxMant = new JButton("Proximo Mantenimiento");
		
		botones.add(btnFlujoMax);
		btnFlujoMax.addActionListener(e -> {
			scrollPane.setVisible(false);
			mant.setVisible(false);
			
			panelFrame.add(flujoMax, BorderLayout.CENTER);
			flujoMax.setVisible(true);
			SwingUtilities.updateComponentTreeUI(panelFrame);
		});
		
		botones.add(btnPageRank);
		btnPageRank.addActionListener(e -> {
			flujoMax.setVisible(false);
			mant.setVisible(false);
			
			panelFrame.add(scrollPane, BorderLayout.CENTER);
			scrollPane.setVisible(true);
			SwingUtilities.updateComponentTreeUI(panelFrame);
		});
		
		botones.add(btnProxMant);
		btnProxMant.addActionListener(e -> {
			flujoMax.setVisible(false);
			scrollPane.setVisible(false);
			
			panelFrame.add(mant, BorderLayout.CENTER);
			mant.setVisible(true);
			SwingUtilities.updateComponentTreeUI(panelFrame);
		});
		
		
		panelFrame.add(botones, BorderLayout.SOUTH);
		
		this.setContentPane(panelFrame);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setSize(500,300);	
		
		
	}
	
}
