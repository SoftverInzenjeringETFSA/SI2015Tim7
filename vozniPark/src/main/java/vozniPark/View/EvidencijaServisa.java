package vozniPark.View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import org.apache.log4j.Logger;

public class EvidencijaServisa {
	final static Logger logger = Logger.getLogger(Login.class);

	private JFrame frmPrijavaServisa;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_2;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvidencijaServisa window = new EvidencijaServisa();
					window.frmPrijavaServisa.setVisible(true);
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
	public EvidencijaServisa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrijavaServisa = new JFrame();
		frmPrijavaServisa.setTitle("Servis");
		frmPrijavaServisa.setBounds(100, 100, 600, 344);
		frmPrijavaServisa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrijavaServisa.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 564, 284);
		frmPrijavaServisa.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Prijava vozila na servis", null, panel, null);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 30, 300, 200);
		panel.add(table);
		
		JLabel lblRegistracija = new JLabel("Registracija");
		lblRegistracija.setBounds(15, 8, 92, 14);
		panel.add(lblRegistracija);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(99, 8, 8, 17);
		panel.add(separator);
		
		JLabel lblOpisVozila = new JLabel("Opis vozila");
		lblOpisVozila.setBounds(217, 8, 79, 14);
		panel.add(lblOpisVozila);
		
		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setBounds(341, 46, 46, 14);
		panel.add(lblDatum);
		
		textField = new JTextField();
		textField.setBounds(410, 43, 125, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblVrijeme = new JLabel("Vrijeme:");
		lblVrijeme.setBounds(341, 125, 56, 14);
		panel.add(lblVrijeme);
		
		textField_1 = new JTextField();
		textField_1.setBounds(410, 122, 125, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBounds(410, 207, 125, 23);
		panel.add(btnPotvrdi);		
		
		JLabel lblNazivVozila = new JLabel("Naziv vozila");
		lblNazivVozila.setBounds(117, 8, 71, 14);
		panel.add(lblNazivVozila);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setOrientation(SwingConstants.VERTICAL);
		separator_8.setForeground(Color.BLACK);
		separator_8.setBounds(199, 8, 8, 17);
		panel.add(separator_8);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Odjava vozila sa servisa", null, panel_1, null);
		panel_1.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(10, 30, 300, 200);
		panel_1.add(table_1);
		
		JLabel label_1 = new JLabel("Opis vozila");
		label_1.setBounds(217, 8, 79, 14);
		panel_1.add(label_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(99, 8, 8, 17);
		panel_1.add(separator_1);
		
		JLabel label = new JLabel("Registracija");
		label.setBounds(15, 8, 92, 14);
		panel_1.add(label);
		
		JLabel label_3 = new JLabel("Datum:");
		label_3.setBounds(365, 67, 35, 14);
		panel_1.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(410, 64, 125, 20);
		panel_1.add(textField_2);
		
		JLabel label_4 = new JLabel("Vrijeme:");
		label_4.setBounds(361, 96, 39, 14);
		panel_1.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(410, 93, 125, 20);
		panel_1.add(textField_3);
		
		JButton button = new JButton("Potvrdi");
		button.setBounds(410, 207, 125, 23);
		panel_1.add(button);
		
		JLabel lblCijena = new JLabel("Cijena:");
		lblCijena.setBounds(365, 125, 35, 14);
		panel_1.add(lblCijena);
		
		textField_4 = new JTextField();
		textField_4.setBounds(410, 122, 125, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblOpisServisa = new JLabel("Opis servisa:");
		lblOpisServisa.setBounds(338, 153, 62, 14);
		panel_1.add(lblOpisServisa);
		
		textField_5 = new JTextField();
		textField_5.setBounds(410, 149, 125, 47);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNazivVozila_1 = new JLabel("Naziv vozila");
		lblNazivVozila_1.setBounds(117, 8, 71, 14);
		panel_1.add(lblNazivVozila_1);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setOrientation(SwingConstants.VERTICAL);
		separator_9.setForeground(Color.BLACK);
		separator_9.setBounds(199, 8, 8, 17);
		panel_1.add(separator_9);
		
		JLabel lblServisiranoKod_1 = new JLabel("Servisirano kod:");
		lblServisiranoKod_1.setBounds(322, 36, 78, 14);
		panel_1.add(lblServisiranoKod_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(410, 33, 125, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Prikaz svih servisa za sva vozila", null, panel_2, null);
		panel_2.setLayout(null);
		
		table_2 = new JTable();
		table_2.setBounds(10, 40, 539, 200);
		panel_2.add(table_2);
		
		JLabel lblServisiranoVozilo = new JLabel("Vozilo");
		lblServisiranoVozilo.setBounds(15, 11, 45, 18);
		panel_2.add(lblServisiranoVozilo);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(56, 11, 8, 17);
		panel_2.add(separator_2);
		
		JLabel lblRegistracija_1 = new JLabel("Registracija");
		lblRegistracija_1.setBounds(65, 13, 75, 14);
		panel_2.add(lblRegistracija_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(140, 11, 8, 17);
		panel_2.add(separator_3);
		
		JLabel lblServisiranoKod = new JLabel("Servisirano kod");
		lblServisiranoKod.setBounds(147, 13, 96, 14);
		panel_2.add(lblServisiranoKod);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(242, 11, 8, 17);
		panel_2.add(separator_4);
		
		JLabel lblVrijemeod = new JLabel("Vrijeme(od)");
		lblVrijemeod.setBounds(250, 13, 75, 14);
		panel_2.add(lblVrijemeod);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setForeground(Color.BLACK);
		separator_5.setBounds(323, 11, 8, 17);
		panel_2.add(separator_5);
		
		JLabel lblVrijemedo = new JLabel("Vrijeme(do)");
		lblVrijemedo.setBounds(330, 13, 68, 14);
		panel_2.add(lblVrijemedo);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setForeground(Color.BLACK);
		separator_6.setBounds(402, 11, 8, 17);
		panel_2.add(separator_6);
		
		JLabel lblOpis = new JLabel("Opis servisa");
		lblOpis.setBounds(410, 13, 75, 14);
		panel_2.add(lblOpis);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setForeground(Color.BLACK);
		separator_7.setBounds(489, 11, 8, 17);
		panel_2.add(separator_7);
		
		JLabel lblCijena_1 = new JLabel("Cijena");
		lblCijena_1.setBounds(500, 13, 46, 14);
		panel_2.add(lblCijena_1);
	}
}
