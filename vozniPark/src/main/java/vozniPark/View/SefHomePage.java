package vozniPark.View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.apache.log4j.Logger;

public class SefHomePage {
	
	final static Logger logger = Logger.getLogger(Login.class);

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SefHomePage window = new SefHomePage();
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
	public SefHomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 577, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDobroDoaoefe = new JLabel("Dobro došao, Šefe!");
		lblDobroDoaoefe.setBounds(12, 12, 145, 21);
		frame.getContentPane().add(lblDobroDoaoefe);
		
		JButton btnNewButton = new JButton("Unesi vozača");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(312, 141, 218, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUnesiVozilo = new JButton("Unesi vozilo");
		btnUnesiVozilo.setBounds(65, 141, 218, 25);
		frame.getContentPane().add(btnUnesiVozilo);
		
		JButton btnPregledSlobodnihVozila = new JButton("Pregled slobodnih vozila");
		btnPregledSlobodnihVozila.setBounds(65, 104, 218, 25);
		frame.getContentPane().add(btnPregledSlobodnihVozila);
		
		JButton btnServisi = new JButton("Servis");
		btnServisi.setBounds(65, 192, 218, 25);
		frame.getContentPane().add(btnServisi);
		
		JLabel lblNemaNovihObavijesti = new JLabel("Nema novih obavijesti");
		lblNemaNovihObavijesti.setBounds(55, 57, 250, 15);
		frame.getContentPane().add(lblNemaNovihObavijesti);
		
		JButton btnNewButton_1 = new JButton("Odjavi se");
		btnNewButton_1.setBounds(418, 242, 117, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnIzvjestaji = new JButton("Izvještaji");
		btnIzvjestaji.setBounds(312, 192, 218, 25);
		frame.getContentPane().add(btnIzvjestaji);
		
		JButton btnPregledVozaa = new JButton("Pregled vozača");
		btnPregledVozaa.setBounds(312, 104, 218, 25);
		frame.getContentPane().add(btnPregledVozaa);
	}
}
