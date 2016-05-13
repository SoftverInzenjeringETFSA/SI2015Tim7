package vozniPark.View.izvjestaji;
import java.awt.EventQueue;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import org.apache.log4j.Logger;


import vozniPark.Controller.PregledServisaController;
import vozniPark.View.Login;

public class IzvjestajOSvimServisima {

	final static Logger logger = Logger.getLogger(IzvjestajOSvimServisima.class);
	private PregledServisaController psc;
	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajOSvimServisima window = new IzvjestajOSvimServisima();
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


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1038, 457);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIzvjetajOSvim = new JLabel("Izvje\u0161taj o svim servisima svih vozila");
		lblIzvjetajOSvim.setBounds(10, 11, 229, 14);
		frame.getContentPane().add(lblIzvjetajOSvim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 1002, 371);
		frame.getContentPane().add(scrollPane);
		
		psc= new PregledServisaController();
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Servisirano vozilo:");
		columnNames.add("Broj registracije:");
		columnNames.add("Servisirano kod:");
		columnNames.add("Datum i vrijeme odvoženja vozila na servis:");
		columnNames.add("Datum i vrijeme vraćanja vozila:");
		columnNames.add("Opis servisiranja:");
		columnNames.add("Cijena servisiranja(KM):");
        Vector<Vector<String>> nl=new Vector<Vector<String>>();
        nl=psc.ucitajVoznjeZaVozaca();
		table = new JTable(nl,columnNames);
		scrollPane.setViewportView(table);

	}

	public IzvjestajOSvimServisima() {
		initialize();		
	}
}
