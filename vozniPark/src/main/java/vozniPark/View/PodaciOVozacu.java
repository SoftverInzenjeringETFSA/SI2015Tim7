package vozniPark.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import vozniPark.Controller.PregledVozacaController;
import java.awt.BorderLayout;


public class PodaciOVozacu {
	
	final static Logger logger = Logger.getLogger(PodaciOVozacu.class);

	private JFrame frame;
	private JFrame frejm;
	private int imena;
	private PregledVozacaController pvc;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PodaciOVozacu window = new PodaciOVozacu(imena);
					window.frame.setVisible(true);
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
	public PodaciOVozacu(int podaci) {
		imena=podaci;
		pvc=new PregledVozacaController();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.setBounds(100, 100, 709, 543);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Podaci o vozaču");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(252, 35, 172, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblIme_1 = new JLabel("Ime :");
		lblIme_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIme_1.setBounds(264, 94, 46, 14);
		frame.getContentPane().add(lblIme_1);
		
		JLabel lblPrezime_1 = new JLabel("Prezime :");
		lblPrezime_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrezime_1.setBounds(241, 129, 64, 14);
		frame.getContentPane().add(lblPrezime_1);
		
		JLabel lblBrojVozakeDozvole = new JLabel("Broj vozačke dozvole :");
		lblBrojVozakeDozvole.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBrojVozakeDozvole.setBounds(160, 165, 156, 14);
		frame.getContentPane().add(lblBrojVozakeDozvole);
		
		JLabel lblAdresa_1 = new JLabel("Adresa :");
		lblAdresa_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdresa_1.setBounds(248, 202, 57, 14);
		frame.getContentPane().add(lblAdresa_1);
		
		JLabel lblTelefon = new JLabel("Broj telefona :");
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefon.setBounds(213, 237, 86, 14);
		frame.getContentPane().add(lblTelefon);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(230, 272, 75, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(pvc.dajVozacaINT(imena).getIme());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(322, 96, 195, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel(pvc.dajVozacaINT(imena).getPrezime());
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(322, 131, 195, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel(pvc.dajVozacaINT(imena).getBrojVozacke());
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(322, 167, 195, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel(pvc.dajVozacaINT(imena).getAdresa());
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(322, 204, 195, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel(pvc.dajVozacaINT(imena).getBrojTelefona());
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(322, 239, 195, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel(pvc.dajVozacaINT(imena).getUsername());
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(322, 274, 195, 14);
		frame.getContentPane().add(label_5);
		
		JButton btnNewButton = new JButton("Vrati se na listu vozača");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(174, 314, 264, 23);
		frame.getContentPane().add(btnNewButton);
			
	}

	
}
