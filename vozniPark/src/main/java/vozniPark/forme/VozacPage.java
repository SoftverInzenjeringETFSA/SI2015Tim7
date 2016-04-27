package vozniPark.forme;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VozacPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VozacPage window = new VozacPage();
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
	public VozacPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 644, 347);
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
		btnNewButton.setBounds(12, 178, 218, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUnesiVozilo = new JButton("Unesi vozilo");
		btnUnesiVozilo.setBounds(12, 127, 218, 25);
		frame.getContentPane().add(btnUnesiVozilo);
		
		JButton btnPregledSlobodnihVozila = new JButton("Pregled slobodnih vozila");
		btnPregledSlobodnihVozila.setBounds(12, 81, 218, 25);
		frame.getContentPane().add(btnPregledSlobodnihVozila);
		
		JButton btnServisi = new JButton("Servis");
		btnServisi.setBounds(12, 228, 218, 25);
		frame.getContentPane().add(btnServisi);
		
		JLabel lblNemaNovihObavijesti = new JLabel("Nema novih obavijesti");
		lblNemaNovihObavijesti.setBounds(312, 137, 250, 15);
		frame.getContentPane().add(lblNemaNovihObavijesti);
		
		JButton btnNewButton_1 = new JButton("Odjavi se");
		btnNewButton_1.setBounds(500, 279, 117, 25);
		frame.getContentPane().add(btnNewButton_1);
	}
}
