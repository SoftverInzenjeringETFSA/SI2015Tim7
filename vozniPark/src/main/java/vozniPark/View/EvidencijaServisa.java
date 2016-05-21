package vozniPark.View;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import java.awt.Color;

import org.apache.log4j.Logger;

import vozniPark.Controller.PregledServisaController;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class EvidencijaServisa {
	final static Logger logger = Logger.getLogger(EvidencijaServisa.class);

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
	private PregledServisaController psc;
	private Vector<Vector<String>> data1;
	private Vector<Vector<String>> data2;
	private boolean ispravanDatum = true;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvidencijaServisa window = new EvidencijaServisa();
					window.frmPrijavaServisa.setVisible(true);
				} catch (Exception e) {
					logger.info(e);
					// e.printStackTrace();
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
		psc = new PregledServisaController();
		Vector<Vector<String>> nl = new Vector<Vector<String>>();
		nl = psc.ucitajVoznjeZaVozaca();
		frmPrijavaServisa = new JFrame();
		frmPrijavaServisa.setTitle("Servis");
		frmPrijavaServisa.setBounds(100, 100, 600, 344);
		frmPrijavaServisa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmPrijavaServisa.getContentPane().setLayout(null);
		frmPrijavaServisa.setResizable(false);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 564, 294);
		frmPrijavaServisa.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Prijava vozila na servis", null, panel, null);
		panel.setLayout(null);

		Vector<String> columnNames1 = new Vector<String>();
		columnNames1.add("Registracija");
		columnNames1.add("Naziv vozila");
		columnNames1.add("Opis vozila");
		data1 = new Vector<Vector<String>>();
		data1 = psc.ucitajSlobodnaVozila();

		table = new JTable(data1, columnNames1);
		table.setBounds(10, 11, 300, 219);
		panel.add(table);

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

		btnPotvrdi.setBounds(410, 167, 125, 23);
		panel.add(btnPotvrdi);
		
		JButton btnPomo = new JButton("Pomoć");
		btnPomo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Odaberite vozilo koje je trenutno slobodno, da bi isto prijavili na servis, te unesite sve potrebne podatke.");
			}
		});
		btnPomo.setBounds(460, 207, 75, 23);
		panel.add(btnPomo);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Odjava vozila sa servisa", null, panel_1, null);
		panel_1.setLayout(null);

		Vector<String> columnNames2 = new Vector<String>();
		columnNames2.add("Registracija");
		columnNames2.add("Naziv vozila");
		columnNames2.add("Opis vozila");
		data2 = new Vector<Vector<String>>();
		data2 = psc.ucitajVozilaNaServisu();

		table_1 = new JTable(data2, columnNames2);
		table_1.setBounds(10, 11, 300, 219);
		panel_1.add(table_1);

		JLabel label_3 = new JLabel("Datum:");
		label_3.setBounds(366, 67, 49, 14);
		panel_1.add(label_3);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(410, 64, 125, 20);
		panel_1.add(textField_2);

		JLabel label_4 = new JLabel("Vrijeme:");
		label_4.setBounds(360, 96, 53, 14);
		panel_1.add(label_4);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(410, 93, 125, 20);
		panel_1.add(textField_3);

		JButton button = new JButton("Potvrdi");

		button.setBounds(410, 207, 125, 23);
		panel_1.add(button);

		JLabel lblCijena = new JLabel("Cijena:");
		lblCijena.setBounds(367, 125, 49, 14);
		panel_1.add(lblCijena);

		textField_4 = new JTextField();
		textField_4.setBounds(410, 122, 125, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblOpisServisa = new JLabel("Opis servisa:");
		lblOpisServisa.setBounds(333, 153, 76, 14);
		panel_1.add(lblOpisServisa);

		textField_5 = new JTextField();
		textField_5.setBounds(410, 149, 125, 47);
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblServisiranoKod_1 = new JLabel("Servisirano kod:");
		lblServisiranoKod_1.setBounds(315, 36, 92, 14);
		panel_1.add(lblServisiranoKod_1);

		textField_6 = new JTextField();
		textField_6.setBounds(410, 33, 125, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnPomo_1 = new JButton("Pomoć");
		btnPomo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Odaberite vozilo koje je trenutno na servisu da bi isto uspješno odjavili, te unesite sve potrebne parametre.");
			}
		});
		btnPomo_1.setBounds(460, 243, 75, 23);
		panel_1.add(btnPomo_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Prikaz svih servisa za sva vozila", null, panel_2, null);
		panel_2.setLayout(null);

		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Servisirano vozilo:");
		columnNames.add("Broj registracije:");
		columnNames.add("Servisirano kod:");
		columnNames.add("Datum i vrijeme odvoženja vozila na servis:");
		columnNames.add("Datum i vrijeme vraćanja vozila:");
		columnNames.add("Opis servisiranja:");
		columnNames.add("Cijena servisiranja(KM):");

		table_2 = new JTable(nl, columnNames);
		table_2.setBounds(10, 11, 539, 229);
		panel_2.add(table_2);

		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ispravanDatum = true;
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'u' HH:mm:ss");
				String datum = textField.getText();
				String vrijeme = textField_1.getText();
				if (datum.length() <= 0 || vrijeme.length() <= 0) {
					JOptionPane.showMessageDialog(null, "Nisu uneseni svi parametri");
					return;
				}

				if (!datum.matches(
						"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
					JOptionPane.showMessageDialog(null, "Datum nije ispravno unesen");
					return;
				}

				if (!vrijeme.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")) {
					JOptionPane.showMessageDialog(null, "Vrijeme nije ispravno uneseno");
					return;
				}

				String datumVrijeme = textField.getText() + textField_1.getText();
				Date date = new Date();

				try {
					date = formatter.parse(datumVrijeme);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					logger.info(e);
				}

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vozilo nije izabrano", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (ispravanDatum) {
					psc.dodajNaServis(date, psc.dajIDVozila(data1.get(table.getSelectedRow()).get(0)));
					frmPrijavaServisa.dispose();
					EvidencijaServisa servis = new EvidencijaServisa();
					servis.main(null);
				}
			}
		});

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'u' HH:mm:ss");
				String datum = textField_2.getText();
				String vrijeme = textField_3.getText();
				if (datum.length() <= 0 || vrijeme.length() <= 0 || textField_4.getText().length() <= 0 || textField_5.getText().length() <= 0 || textField_6.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Nisu uneseni svi parametri");
					return;
				}

				if (!datum.matches(
						"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
					JOptionPane.showMessageDialog(null, "Datum nije ispravno unesen");
					return;
				}

				if (!vrijeme.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")) {
					JOptionPane.showMessageDialog(null, "Vrijeme nije ispravno uneseno");
					return;
				}
				String datumVrijeme = textField_2.getText() + " " + textField_3.getText();
				Date date = new Date();
				try {
					date = formatter.parse(datumVrijeme);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					logger.info(e);
				}
				if (table_1.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vozilo nije izabrano", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else{
				psc.dodajDovrsenServis(psc.dajIDVozila(data2.get(table_1.getSelectedRow()).get(0)), date,
						textField_6.getText(), textField_4.getText(), textField_5.getText());
				frmPrijavaServisa.dispose();
				EvidencijaServisa servis = new EvidencijaServisa();
				servis.main(null);
				}
			}
		});
	}
}
