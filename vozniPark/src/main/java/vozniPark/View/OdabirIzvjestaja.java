package vozniPark.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import org.apache.log4j.Logger;

import vozniPark.View.izvjestaji.IzvjestajOAktivnostimaVozaca;
import vozniPark.View.izvjestaji.IzvjestajOOdabranomVozilu;
import vozniPark.View.izvjestaji.IzvjestajOSvimServisima;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OdabirIzvjestaja {
	
	final static Logger logger = Logger.getLogger(OdabirIzvjestaja.class);

	private JFrame frmIzvjetaji;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OdabirIzvjestaja window = new OdabirIzvjestaja();
					window.frmIzvjetaji.setVisible(true);
				} catch (Exception e) {
					//e.printStackTrace();
					logger.info(e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OdabirIzvjestaja() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIzvjetaji = new JFrame();
		frmIzvjetaji.setTitle("Izvještaji");
		frmIzvjetaji.setBounds(100, 100, 350, 180);
		frmIzvjetaji.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmIzvjetaji.getContentPane().setLayout(null);
		frmIzvjetaji.setResizable(false);
		
		JButton btnNewButton = new JButton("Izvještaj o aktivnostima vozača");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzvjestajOAktivnostimaVozaca aktivnostiVozaca = new IzvjestajOAktivnostimaVozaca();
				aktivnostiVozaca.main(null);
			}
		});
		btnNewButton.setBounds(60, 11, 225, 23);
		frmIzvjetaji.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Izvještaj o odabranom vozilu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzvjestajOOdabranomVozilu vozilo = new IzvjestajOOdabranomVozilu();
				vozilo.main(null);
			}
		});
		btnNewButton_1.setBounds(60, 61, 225, 23);
		frmIzvjetaji.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Izvještaj o svim servisima");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzvjestajOSvimServisima servisi = new IzvjestajOSvimServisima();
				servisi.main(null);
			}
		});
		btnNewButton_2.setBounds(60, 111, 225, 23);
		frmIzvjetaji.getContentPane().add(btnNewButton_2);
	}

}
