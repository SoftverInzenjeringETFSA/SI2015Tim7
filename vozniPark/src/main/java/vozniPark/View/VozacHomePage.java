package vozniPark.View;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import org.apache.log4j.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VozacHomePage {

	final static Logger logger = Logger.getLogger(VozacHomePage.class);

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VozacHomePage window = new VozacHomePage();
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
		frame.setResizable(false);
		
		JLabel lblDobroDoaoMeho = new JLabel("Dobro došao, Meho!");
		lblDobroDoaoMeho.setBounds(12, 12, 153, 15);
		frame.getContentPane().add(lblDobroDoaoMeho);
		
		JButton btnNewButton = new JButton("Prijava preuzetog vozila");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrijavljivanjePreuzetogVozila prijava = new PrijavljivanjePreuzetogVozila();
				prijava.main(null);
			}
		});
		btnNewButton.setBounds(12, 74, 220, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnOdjavaPreuzetogVozila = new JButton("Odjava preuzetog vozila");
		btnOdjavaPreuzetogVozila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OdjavljivanjePreuzetogVozila odjava = new OdjavljivanjePreuzetogVozila();
				odjava.main(null);
			}
		});
		btnOdjavaPreuzetogVozila.setBounds(12, 120, 220, 25);
		frame.getContentPane().add(btnOdjavaPreuzetogVozila);
		
		JButton btnOdjaviSe = new JButton("Odjavi se");
		btnOdjaviSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.gc();
				for (Window window : Window.getWindows()) {
				    window.dispose();
				}
				JOptionPane.showMessageDialog(null, "Uspješno ste odjavljeni!");
				Login login = new Login();
				login.main();
			}
		});
		btnOdjaviSe.setBounds(440, 176, 117, 25);
		frame.getContentPane().add(btnOdjaviSe);
		
		JButton PregledSlobodnihVozila = new JButton("Pregled slobodnih vozila");
		PregledSlobodnihVozila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PregledSlobodnihVozila pregledSlobodnih = new PregledSlobodnihVozila();
				pregledSlobodnih.main(null);
			}
		});
		PregledSlobodnihVozila.setBounds(12, 157, 220, 25);
		frame.getContentPane().add(PregledSlobodnihVozila);
	}

}
