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


public class PodaciOVozacu {
	
	final static Logger logger = Logger.getLogger(PodaciOVozacu.class);

	private JFrame frame;
	private JFrame frejm;
	private Vector<String> imena;
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
	public PodaciOVozacu(Vector<String> podaci) {
		imena=podaci;
		pvc=new PregledVozacaController();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 709, 543);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JButton btnPotvrdi = new JButton("Vrati se na pregled vozača");
		btnPotvrdi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblBrojVozackeDozvole = new JLabel("Broj voza\u010Dke dozvole:");
		lblBrojVozackeDozvole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona:");
		lblBrojTelefona.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel = new JPanel();
		
		JLabel lblIrma = new JLabel(pvc.dajVozaca(imena.get(0), imena.get(1)).getIme());
		lblIrma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblKarasoftic = new JLabel(pvc.dajVozaca(imena.get(0), imena.get(1)).getPrezime());
		lblKarasoftic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblike = new JLabel(pvc.dajVozaca(imena.get(0), imena.get(1)).getBrojVozacke());
		lblike.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblEtfovska = new JLabel(pvc.dajVozaca(imena.get(0), imena.get(1)).getAdresa());
		lblEtfovska.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label = new JLabel(pvc.dajVozaca(imena.get(0), imena.get(1)).getBrojTelefona());
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblIkarasofti = new JLabel(pvc.dajVozaca(imena.get(0), imena.get(1)).getUsername());
		lblIkarasofti.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(171)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPrezime)
								.addComponent(lblBrojVozackeDozvole)
								.addComponent(lblAdresa)
								.addComponent(lblBrojTelefona)
								.addComponent(lblUsername)
								.addComponent(lblIme))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEtfovska)
										.addComponent(lblike)
										.addComponent(label)
										.addComponent(lblIkarasofti)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblIrma)
										.addComponent(lblKarasoftic)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(125)
							.addComponent(btnPotvrdi, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(207)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIme)
						.addComponent(lblIrma))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrezime)
						.addComponent(lblKarasoftic))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBrojVozackeDozvole)
						.addComponent(lblike))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdresa)
						.addComponent(lblEtfovska))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBrojTelefona)
						.addComponent(label))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIkarasofti)
						.addComponent(lblUsername))
					.addGap(62)
					.addComponent(btnPotvrdi)
					.addGap(103))
		);
		
		JLabel lblUnosNovogVozaa = new JLabel("Podaci o voza\u010Du");
		lblUnosNovogVozaa.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblUnosNovogVozaa);
		frame.getContentPane().setLayout(groupLayout);
		
	}

	public void PrikaziFormu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PodaciOVozacu window = new PodaciOVozacu(imena);
					window.frejm.setVisible(true);
					window.frejm.setAlwaysOnTop(true);
				} catch (Exception e) {
					logger.info(e);
				}
			}
		});
		
	}
	
}
