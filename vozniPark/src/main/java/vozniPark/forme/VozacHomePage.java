package vozniPark.forme;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VozacHomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VozacHomePage window = new VozacHomePage();
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
	public VozacHomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDobroDoaoMeho = new JLabel("Dobro došao, Meho!");
		lblDobroDoaoMeho.setBounds(12, 12, 153, 15);
		frame.getContentPane().add(lblDobroDoaoMeho);
		
		JButton btnNewButton = new JButton("Prijava preuzetog vozila");
		btnNewButton.setBounds(12, 74, 220, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnOdjavaPreuzetogVozila = new JButton("Odjava preuzetog vozila");
		btnOdjavaPreuzetogVozila.setBounds(12, 120, 220, 25);
		frame.getContentPane().add(btnOdjavaPreuzetogVozila);
		
		JButton btnOdjaviSe = new JButton("Odjavi se");
		btnOdjaviSe.setBounds(450, 182, 117, 25);
		frame.getContentPane().add(btnOdjaviSe);
	}

}
