package vozniPark.View;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

public class PrikazAktivnostiVozaca {
	
	final static Logger logger = Logger.getLogger(PrikazAktivnostiVozaca.class);

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikazAktivnostiVozaca window = new PrikazAktivnostiVozaca();
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
	public PrikazAktivnostiVozaca() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1077, 453);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] columnNames = {"Preuzeto vozilo:", "Broj registracije:","Datum i vrijeme preuzimanja vozila:","Datum i vrijeme vraćanja vozila:","Pređeni kilometri:","Dosipanje goriva(KM):","Dosipanje goriva(l):","Svrha upotrebe:"};
        Object[][] data ={};

        
		
		
		
		JLabel lblIzvjetajO = new JLabel("Prikaz aktivnosti vozača");
		lblIzvjetajO.setBounds(10, 11, 229, 14);
		frame.getContentPane().add(lblIzvjetajO);
		
		JLabel lblNewLabel = new JLabel("Vozač :");
		lblNewLabel.setBounds(10, 44, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(66, 41, 173, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnPrikaz = new JButton("Prikaži");
		btnPrikaz.setBounds(252, 40, 89, 23);
		frame.getContentPane().add(btnPrikaz);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 1041, 303);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table = new JTable(data,columnNames);
		textField.setBounds(61, 41, 178, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		table.getTableHeader().setPreferredSize(new Dimension(10,50));
	}

}
