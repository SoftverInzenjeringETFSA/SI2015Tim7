package vozniPark.View.izvjestaji;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import org.apache.log4j.Logger;

import vozniPark.Controller.PregledVoznjiController;
import vozniPark.View.Login;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class IzvjestajOAktivnostimaVozaca {

	final static Logger logger = Logger.getLogger(IzvjestajOAktivnostimaVozaca.class);

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTextField textField_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private PregledVoznjiController pvc;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajOAktivnostimaVozaca window = new IzvjestajOAktivnostimaVozaca();
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
	public IzvjestajOAktivnostimaVozaca() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pvc = new PregledVoznjiController();
		frame = new JFrame();
		frame.setBounds(100, 100, 1168, 422);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Izvještaj o aktivnostima vozača");
		label.setBounds(10, 11, 229, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Ime vozača :");
		label_1.setBounds(10, 44, 71, 14);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(94, 41, 178, 20);
		frame.getContentPane().add(textField);
		
		JButton button = new JButton("Prikaži");

		button.setBounds(568, 40, 89, 23);
		frame.getContentPane().add(button);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 1132, 251);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(577, 320, 421, 50);
		frame.getContentPane().add(scrollPane_1);
		

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel label_2 = new JLabel("Prezime vozača :");
		label_2.setBounds(280, 44, 101, 14);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(379, 41, 178, 20);
		frame.getContentPane().add(textField_1);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vector<Vector<String>> data=new Vector<Vector<String>>();
				data=pvc.ucitajVoznjeZaVozaca(frame, textField, textField_1);
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
				
				Vector<Vector<String>> data1=new Vector<Vector<String>>();
				Vector<String> columnNames1=new Vector<String>();
				data1=pvc.dajUkupno();
				
				columnNames1.addElement("Ukupno(km):");
				columnNames1.addElement("Ukupno(KM):");
				columnNames1.addElement("Ukupno(l):");
				table_1 = new JTable(data1,columnNames1);
				scrollPane.setViewportView(table);
				scrollPane_1.setViewportView(table_1);
			}
		});
		
	}
}
