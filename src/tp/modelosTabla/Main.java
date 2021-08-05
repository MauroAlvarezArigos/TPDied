package tp.modelosTabla;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tp.dominio.Estacion;
import tp.dominio.PageRank;
import tp.dominio.Pair;

public class Main extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Main() {

        String[] columnNames = {"Estacion", "Caminos"};
        ArrayList<Estacion> estaciones = new ArrayList<Estacion>();
		Timestamp time1 = new Timestamp(System.currentTimeMillis());
		Timestamp time2 = new Timestamp(System.currentTimeMillis()+60000);
		estaciones.add(new Estacion(0, "Est 0", time1, time2, true));
		estaciones.add(new Estacion(1, "Est 1", time1, time2, true));
		estaciones.add(new Estacion(2, "Est 2", time1, time2, true));
        ArrayList<Pair> pRank = new PageRank().getRank(estaciones);
		int tam = pRank.size();
		Object[][] tabla = new Object[tam][2];
		for(int i=0; i<tam; i++) {
			tabla[i][0] = pRank.get(i).getEstacion();
			tabla[i][1] = pRank.get(i).getRank();
			System.out.println(tabla[i][0]);
		}

        DefaultTableModel dtm = new DefaultTableModel(tabla, columnNames);
        final JTable table = new JTable(dtm);

        table.setPreferredScrollableViewportSize(new Dimension(250, 100));
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);       
        addWindowListener(new WindowAdapter() {           
            public void windowClosing(WindowEvent e) {
                System.exit(0);               
            }
        });
       
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.pack();
        frame.setVisible(true);
    }
   
}
