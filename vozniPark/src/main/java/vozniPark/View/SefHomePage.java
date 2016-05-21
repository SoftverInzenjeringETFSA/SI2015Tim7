package vozniPark.View;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.apache.log4j.Logger;

public class SefHomePage {
	
	final static Logger logger = Logger.getLogger(SefHomePage.class);

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
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
		frame.setBounds(100, 100, 577, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblDobroDoaoefe = new JLabel("Dobro došao, Šefe!");
		lblDobroDoaoefe.setBounds(12, 12, 145, 21);
		frame.getContentPane().add(lblDobroDoaoefe);
		
		JButton btnNewButton = new JButton("Unesi vozača");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UnosNovogVozaca unosVozaca = new UnosNovogVozaca();
				unosVozaca.main(null);
			}
		});
		btnNewButton.setBounds(312, 141, 218, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUnesiVozilo = new JButton("Unesi vozilo");
		btnUnesiVozilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnosNovogVozila unosVozila = new UnosNovogVozila();
				unosVozila.main(null);
			}
		});
		btnUnesiVozilo.setBounds(65, 141, 218, 25);
		frame.getContentPane().add(btnUnesiVozilo);
		
		JButton btnPregledSlobodnihVozila = new JButton("Pregled slobodnih vozila");
		btnPregledSlobodnihVozila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PregledSlobodnihVozila pregledSlobodnih = new PregledSlobodnihVozila();
				pregledSlobodnih.main(null);
				
			}
		});
		btnPregledSlobodnihVozila.setBounds(65, 104, 218, 25);
		frame.getContentPane().add(btnPregledSlobodnihVozila);
		
		JButton btnServisi = new JButton("Servis");
		btnServisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EvidencijaServisa servis = new EvidencijaServisa();
				servis.main(null);
			}
		});
		btnServisi.setBounds(65, 192, 218, 25);
		frame.getContentPane().add(btnServisi);
		
		JLabel lblNemaNovihObavijesti = new JLabel("Nema novih obavijesti");
		lblNemaNovihObavijesti.setBounds(55, 57, 250, 15);
		frame.getContentPane().add(lblNemaNovihObavijesti);
		
		JButton btnNewButton_1 = new JButton("Odjavi se");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Window window : Window.getWindows()) {
				    window.dispose();
				}
				JOptionPane.showMessageDialog(null, "Uspješno ste odjavljeni!");
				Login login = new Login();
				login.main();
			}
		});
		btnNewButton_1.setBounds(418, 242, 117, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnIzvjestaji = new JButton("Izvještaji");
		btnIzvjestaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OdabirIzvjestaja izvjestaji = new OdabirIzvjestaja();
				izvjestaji.main(null);
			}
		});
		btnIzvjestaji.setBounds(312, 192, 218, 25);
		frame.getContentPane().add(btnIzvjestaji);
		
		JButton btnPregledVozaa = new JButton("Pregled vozača");
		btnPregledVozaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PregledVozaca pregledVozaca = new PregledVozaca();
				pregledVozaca.main(null);
			}
		});
		btnPregledVozaa.setBounds(312, 104, 218, 25);
		frame.getContentPane().add(btnPregledVozaa);
		
		JButton btnPomo = new JButton("Pomoć");
		btnPomo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Odaberite opciju koja vam treba, te ćete dobiti prozor na kojem će se nalaziti detaljnije uputstvo za odabranu opciju.");
			}
		});
		btnPomo.setBounds(446, 278, 89, 23);
		frame.getContentPane().add(btnPomo);
	}
}
