package vozniPark.View;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import org.apache.log4j.Logger;

import vozniPark.Model.Osoba;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VozacHomePage {

	final static Logger logger = Logger.getLogger(VozacHomePage.class);

	private JFrame frame;
	private String imeVozaca;
	private long idVozaca;
	
	public String getIme() {
		return imeVozaca;
	}
	
	public long getId() {
		return idVozaca;
	}
	
	public void setIme(String ime) {
		this.imeVozaca = ime;
	}
	
	public void setId(long id) {
		this.idVozaca = id;
	}

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VozacHomePage window = new VozacHomePage(getIme(),getId());
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
	
	public VozacHomePage(String ime, long id) {
		initialize();
		setIme(ime);
		setId(id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		final JLabel lblDobroDoaoMeho = new JLabel("Dobro došao, Meho");
		lblDobroDoaoMeho.setBounds(12, 12, 153, 15);
		frame.getContentPane().add(lblDobroDoaoMeho);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				lblDobroDoaoMeho.setText("Dobro došao, " + getIme() + "e");
			}
		});
		frame.setBounds(100, 100, 583, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		/*
		JLabel lblDobroDoaoMeho = new JLabel("Dobro došao, Meho");
		lblDobroDoaoMeho.setBounds(12, 12, 153, 15);
		frame.getContentPane().add(lblDobroDoaoMeho); */
		
		JButton btnNewButton = new JButton("Prijava preuzetog vozila");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrijavljivanjePreuzetogVozila prijava = new PrijavljivanjePreuzetogVozila(getIme(),getId());
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
		
		JButton btnHelp = new JButton("Pomoć");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Omogućen vam je pregled svih slobodnih vozila. Prijavite ili odjavite"
						+ "vozilo koje namjeravate preuzeti/vratiti.");
				
			}
		});
		btnHelp.setBounds(477, 228, 80, 23);
		frame.getContentPane().add(btnHelp);
	}
}
