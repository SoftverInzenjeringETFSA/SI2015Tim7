package vozniPark.View;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

import vozniPark.Controller.PregledVoznjiController;

public class PrikazAktivnostiVozaca {
	
	final static Logger logger = Logger.getLogger(PrikazAktivnostiVozaca.class);

	private JFrame frame;
	private JTable table;
	private Vector<String> imeiprezime;
	private PregledVoznjiController pvc;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikazAktivnostiVozaca window = new PrikazAktivnostiVozaca(imeiprezime);
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.info(e);
					//e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrikazAktivnostiVozaca(Vector<String> podaci) {
		imeiprezime=podaci;
		pvc=new PregledVoznjiController();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JTextField jt1=new JTextField(imeiprezime.get(0));
		JTextField jt2=new JTextField(imeiprezime.get(1));
		frame = new JFrame();
		frame.setBounds(100, 100, 1077, 453);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIzvjetajO = new JLabel("Prikaz aktivnosti za vozača "+imeiprezime.get(0)+" "+imeiprezime.get(1));
		lblIzvjetajO.setBounds(10, 35, 513, 14);
		frame.getContentPane().add(lblIzvjetajO);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 1041, 303);
		frame.getContentPane().add(scrollPane);
		
		Vector<Vector<String>> data=new Vector<Vector<String>>();
		data=pvc.ucitajVoznjeZaVozaca(frame, jt1, jt2);
		Vector<String> columnNames=new Vector<String>();
		columnNames.addElement("Preuzeto vozilo:");
		columnNames.addElement("Broj registracije:");
		columnNames.addElement("Datum i vrijeme preuzimanja vozila:");
		columnNames.addElement("Datum i vrijeme vraćanja vozila:");
		columnNames.addElement("Pređeni kilometri:");
		columnNames.addElement("Dosipanje goriva(KM):");
		columnNames.addElement("Dosipanje goriva(l):");
		columnNames.addElement("Svrha upotrebe:");
		
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		
		table = new JTable(data,columnNames);
		table.getTableHeader().setPreferredSize(new Dimension(10,50));
	}

}
