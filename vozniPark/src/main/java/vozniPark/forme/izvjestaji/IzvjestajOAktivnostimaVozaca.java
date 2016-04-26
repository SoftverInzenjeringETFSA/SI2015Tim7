package vozniPark.forme.izvjestaji;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class IzvjestajOAktivnostimaVozaca {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajOAktivnostimaVozaca window = new IzvjestajOAktivnostimaVozaca();
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
	public IzvjestajOAktivnostimaVozaca() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1168, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Izvještaj o aktivnostima vozača");
		label.setBounds(10, 11, 229, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Vozač :");
		label_1.setBounds(10, 44, 46, 14);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(61, 41, 178, 20);
		frame.getContentPane().add(textField);
		
		JButton button = new JButton("Prikaži");
		button.setBounds(252, 40, 89, 23);
		frame.getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 1132, 251);
		frame.getContentPane().add(scrollPane);
		String[] columnNames = {"Preuzeto vozilo:", "Broj registracije:","Datum i vrijeme preuzimanja vozila:","Datum i vrijeme vraćanja vozila:","Pređeni kilometri:","Dosipanje goriva(KM):","Dosipanje goriva(l):","Svrha upotrebe:"};
        Object[][] data ={};
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(577, 320, 421, 50);
		frame.getContentPane().add(scrollPane_1);
		String[] columnNames1 = {"Ukupno(km):","Ukupno(KM):","Ukupno(l):"};
        Object[][] data1 ={};
		table_1 = new JTable(data1,columnNames1);
		scrollPane_1.setViewportView(table_1);
	}

}
