package vozniPark.View.izvjestaji;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class IzvjestajOSvimServisima {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajOSvimServisima window = new IzvjestajOSvimServisima();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IzvjestajOSvimServisima() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1038, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIzvjetajOSvim = new JLabel("Izvje\u0161taj o svim servisima svih vozila");
		lblIzvjetajOSvim.setBounds(10, 11, 229, 14);
		frame.getContentPane().add(lblIzvjetajOSvim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 1002, 371);
		frame.getContentPane().add(scrollPane);
		
		
		String[] columnNames = {"Servisirano vozilo:","Broj registracije:","Servisirano kod:", "Datum i vrijeme odvoženja vozila na servis:","Datum i vrijeme vraćanja vozila:","Opis servisiranja:","Cijena servisiranja(KM):"};
        Object[][] data ={};
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
	}

}
