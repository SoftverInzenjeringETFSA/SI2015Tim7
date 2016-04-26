package vozniPark.forme.izvjestaji;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class IzvjestajOOdabranomVozilu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajOOdabranomVozilu window = new IzvjestajOOdabranomVozilu();
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
	public IzvjestajOOdabranomVozilu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 780, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIzvjetajOOdabranom = new JLabel("Izvje\u0161taj o odabranom vozilu");
		lblIzvjetajOOdabranom.setBounds(10, 11, 229, 14);
		frame.getContentPane().add(lblIzvjetajOOdabranom);
		
		JLabel lblVozilo = new JLabel("Vozilo:");
		lblVozilo.setBounds(54, 39, 45, 14);
		frame.getContentPane().add(lblVozilo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(100, 36, 173, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 64, 173, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblBrojRegistracije = new JLabel("Registracija:");
		lblBrojRegistracije.setBounds(20, 66, 89, 14);
		frame.getContentPane().add(lblBrojRegistracije);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 95, 173, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblZaPeriodOd = new JLabel("Za period od:");
		lblZaPeriodOd.setBounds(20, 98, 82, 14);
		frame.getContentPane().add(lblZaPeriodOd);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(307, 95, 173, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblDo = new JLabel("do :");
		lblDo.setBounds(283, 98, 27, 14);
		frame.getContentPane().add(lblDo);
		
		JButton btnNewButton = new JButton("Prika\u017Ei");
		btnNewButton.setBounds(490, 94, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 744, 210);
		frame.getContentPane().add(scrollPane);

		String[] columnNames = {"Servisirano kod:", "Datum i vrijeme odvoženja vozila na servis:","Datum i vrijeme vraćanja vozila:","Cijena servisiranja(KM):","Pređeni kilometri:","Dosipanje goriva(KM):","Dosipanje goriva(l):"};
        Object[][] data ={};
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(333, 335, 421, 38);
		frame.getContentPane().add(scrollPane_1);
		String[] columnNames1 = {"Ukupno(KM):","Ukupno(km):","Ukupno(KM):","Ukupno(l):"};
        Object[][] data1 ={};
		table_1 = new JTable(data1,columnNames1);
		scrollPane_1.setViewportView(table_1);
		
		
	}
}
