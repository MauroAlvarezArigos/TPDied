package tp.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import tp.dominio.Dpair;
import tp.dominio.Estacion;
import tp.dominio.Flujo;
import tp.dominio.GenerarGrafo;
import tp.dominio.Monticulo;
import tp.dominio.PageRank;
import tp.dominio.Pair;
import tp.dominio.Ruta;
import tp.modelosTabla.PageRankTableModel;
import tp.servicios.EstacionServicio;

public class ParametrosGUI extends JFrame {
	private EstacionServicio estacionservicio;
	
	public ParametrosGUI() {
		estacionservicio = new EstacionServicio();
		this.setResizable(false);
		
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
		
		
		
		JLabel lblEstacion = new JLabel("Estaci?n origen:");
		GridBagConstraints gbc_lblEstacion = new GridBagConstraints();
		gbc_lblEstacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstacion.anchor = GridBagConstraints.EAST;
		gbc_lblEstacion.gridx = 2;
		gbc_lblEstacion.gridy = 1;
		flujoMax.add(lblEstacion, gbc_lblEstacion);
		
		JLabel lblDestino = new JLabel("Estaci?n destino:");
		GridBagConstraints gbc_lblDestino = new GridBagConstraints();
		gbc_lblDestino.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestino.anchor = GridBagConstraints.EAST;
		gbc_lblDestino.gridx = 2;
		gbc_lblDestino.gridy = 2;
		flujoMax.add(lblDestino, gbc_lblDestino);
		
		JComboBox<Estacion> cbxOrigen = new JComboBox<Estacion>();
		GridBagConstraints gbc_cbxOrigen = new GridBagConstraints();
		gbc_cbxOrigen.anchor = GridBagConstraints.WEST;
		gbc_cbxOrigen.insets = new Insets(0, 0, 5, 5);
		gbc_cbxOrigen.gridx = 3;
		gbc_cbxOrigen.gridy = 1;
		
		JComboBox<Estacion> cbxDestino = new JComboBox<Estacion>();
		GridBagConstraints gbc_cbxDestino = new GridBagConstraints();
		gbc_cbxDestino.anchor = GridBagConstraints.WEST;
		gbc_cbxDestino.insets = new Insets(0, 0, 5, 5);
		gbc_cbxDestino.gridx = 3;
		gbc_cbxDestino.gridy = 2;
		
		// pido las estaciones
//		ArrayList<Estacion> estaciones = new ArrayList<Estacion>();
//		Timestamp time1 = new Timestamp(System.currentTimeMillis());
//		Timestamp time2 = new Timestamp(System.currentTimeMillis()+60000);
//		estaciones.add(new Estacion(0, "Est 0", time1, time2, true));
//		estaciones.add(new Estacion(1, "Est 1", time1, time2, true));
//		estaciones.add(new Estacion(2, "Est 2", time1, time2, true));
		ArrayList<Estacion> estaciones = (ArrayList<Estacion>)estacionservicio.buscarTodas();
		for(Estacion e : estaciones) {
			cbxOrigen.addItem(e);
			cbxDestino.addItem(e);
		}
				
		flujoMax.add(cbxOrigen, gbc_cbxOrigen);		
		flujoMax.add(cbxDestino, gbc_cbxDestino);
		
		
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setIcon(new ImageIcon(".\\res\\calcular.png"));
		btnCalcular.setMargin(new Insets(0, 0, 0, 0));
		btnCalcular.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCalcular.setVerticalTextPosition(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnCalcular = new GridBagConstraints();
		gbc_btnCalcular.anchor = GridBagConstraints.CENTER;
		gbc_btnCalcular.insets = new Insets(0, 0, 5, 0);
		gbc_btnCalcular.gridx = 5;
		gbc_btnCalcular.gridy = 2;
		flujoMax.add(btnCalcular, gbc_btnCalcular);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Flujo", TitledBorder.CENTER, TitledBorder.TOP, null, null));
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
			
			ArrayList<ArrayList<Ruta>> grafo = new GenerarGrafo().getGrafo();
			Object aux = cbxOrigen.getSelectedItem();
			Estacion estOrigen = (Estacion) aux;
			aux = cbxDestino.getSelectedItem();
			Estacion estDestino = (Estacion) aux;
			if(estOrigen.getId() == estDestino.getId()) {
				JOptionPane.showMessageDialog(this, "Las estaciones no pueden ser la misma", "ERROR", JOptionPane.WARNING_MESSAGE);
				lblFlujoMax.setText("-");
			}
			else {
				long maxFlow =  new Flujo().getMaxFlow(estOrigen.getId(), estDestino.getId(), grafo);
				if(maxFlow >= 100000000) maxFlow=0;
				lblFlujoMax.setText("" + maxFlow); //PONE ACA LO QUE CALCULASTE 	
				panel.setVisible(true);
			}
		});
		
		//PageRank
		ArrayList<Dpair> pRank = new PageRank().getRank(estaciones);
		int tam = pRank.size();
		Object[][] tabla = new Object[tam][2];
		for(int i=0; i<tam; i++) {
			tabla[i][0] = pRank.get(i).getEstacion();
			tabla[i][1] = pRank.get(i).getRank();
		}
		
		
		
		String[] columnNames = {"Estacion", "PageRank"};
		DefaultTableModel dtm = new DefaultTableModel(tabla, columnNames);
	    final JTable table = new JTable(dtm);
	    table.setPreferredScrollableViewportSize(new Dimension(250, 100));
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setEnabled(false);
	
		
		//Proximo Mantenimiento
		JPanel mant = new JPanel();
		mant.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mantenimiento URGENTE", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_mant = new GridBagLayout();
		gbl_mant.columnWidths = new int[]{0, 0, 0, 0};
		gbl_mant.rowHeights = new int[]{0, 0, 0, 0};
		gbl_mant.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_mant.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		mant.setLayout(gbl_mant);
		
		
		int N = estaciones.size();
		for(int i=0; i<N; i++) estaciones.get(i).setUltimoMantenimiento(new Timestamp(System.currentTimeMillis()+70000*i));
		estaciones.get(2).setUltimoMantenimiento(new Timestamp(System.currentTimeMillis() - 100000));
		Estacion auxEstacion = Monticulo.ultMantenimiento(estaciones);
		
		JLabel lblEstacionMant = new JLabel(auxEstacion.getNombre());
		lblEstacionMant.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblEstacionMant = new GridBagConstraints();
		gbc_lblEstacionMant.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstacionMant.gridx = 1;
		gbc_lblEstacionMant.gridy = 1;
		mant.add(lblEstacionMant, gbc_lblEstacionMant);

		LocalDateTime now = auxEstacion.getUltimoMantenimiento().toLocalDateTime();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fdt = now.format(formatter);
        
        
		JLabel lblFecha = new JLabel("Ultimo mantenimiento: " + fdt);
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 0, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 2;
		mant.add(lblFecha, gbc_lblFecha);
		
		
		//Botones		
		JPanel botones = new JPanel();
		JButton btnFlujoMax = new JButton("Flujo Maximo");
		btnFlujoMax.setIcon(new ImageIcon(".\\res\\flujomax.png"));
		btnFlujoMax.setMargin(new Insets(0, 0, 0, 0));
		btnFlujoMax.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFlujoMax.setVerticalTextPosition(SwingConstants.BOTTOM);
		JButton btnPageRank = new JButton("Page Rank");
		btnPageRank.setIcon(new ImageIcon(".\\res\\pagerank.png"));
		btnPageRank.setMargin(new Insets(0, 0, 0, 0));
		btnPageRank.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPageRank.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		JButton btnProxMant = new JButton("Proximo Mantenimiento");
		btnProxMant.setIcon(new ImageIcon(".\\res\\mantenimiento.png"));
		btnProxMant.setMargin(new Insets(0, 0, 0, 0));
		btnProxMant.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProxMant.setVerticalTextPosition(SwingConstants.BOTTOM);
		
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
			
			SwingUtilities.updateComponentTreeUI(panelFrame);
			
			panelFrame.add(scrollPane, BorderLayout.CENTER);
			scrollPane.setVisible(true);
			
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
		this.setSize(500,400);	
		
		
	}
	
}
