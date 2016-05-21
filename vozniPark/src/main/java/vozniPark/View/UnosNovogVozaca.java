package vozniPark.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.apache.log4j.Logger;
import vozniPark.Controller.UnosNovogVozacaController;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UnosNovogVozaca {

	final static Logger logger = Logger.getLogger(UnosNovogVozaca.class);
	private UnosNovogVozacaController unvc;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnosNovogVozaca window = new UnosNovogVozaca();
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
	public UnosNovogVozaca() {
		initialize();
		unvc = new UnosNovogVozacaController();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 709, 592);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setResizable(false);
		
		JButton btnPotvrdi = new JButton("Registruj voza\u010Da");
		
		final JTextPane Ime = new JTextPane();
		
		JLabel lblIme = new JLabel("Ime:");
		
		JLabel lblPrezime = new JLabel("Prezime:");
		
		final JTextPane Prezime = new JTextPane();
		
		final JEditorPane BrojVozacke = new JEditorPane();
		
		JLabel lblBrojVozackeDozvole = new JLabel("Broj voza\u010Dke dozvole:");
		
		final JTextPane Adresa = new JTextPane();
		
		JLabel lblAdresa = new JLabel("Adresa:");
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona:");
		
		final JTextPane Username = new JTextPane();
		
		JLabel lblUsername = new JLabel("Username:");
		
		final JTextPane Sifra = new JTextPane();
		
		JLabel lblSifra = new JLabel("\u0160ifra:");
		
		JPanel panel = new JPanel();
		
		final JTextPane BrojTelefona = new JTextPane();
		
		JButton btnPomo = new JButton("Pomoć");
		btnPomo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Unesite sve potrebne podatke, kako bi uspješno registrovali novog vozača.");
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(188)
							.addComponent(lblSifra)
							.addGap(18)
							.addComponent(Sifra, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(206)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(131)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnPomo)
								.addComponent(btnPotvrdi, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(193)
									.addComponent(lblIme))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(96)
									.addComponent(lblBrojVozackeDozvole))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(175)
									.addComponent(lblAdresa))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(142)
									.addComponent(lblBrojTelefona))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(157)
									.addComponent(lblUsername))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(169)
									.addComponent(lblPrezime)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(Username, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
								.addComponent(BrojTelefona, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
								.addComponent(Adresa, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
								.addComponent(BrojVozacke, GroupLayout.PREFERRED_SIZE, 236, Short.MAX_VALUE)
								.addComponent(Prezime, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(Ime))))
					.addGap(138))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblIme))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(Ime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(Prezime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblPrezime)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblBrojVozackeDozvole))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(BrojVozacke, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblAdresa))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(Adresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBrojTelefona)
						.addComponent(BrojTelefona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(lblUsername))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(Username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblSifra))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(Sifra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(71)
					.addComponent(btnPotvrdi)
					.addGap(32)
					.addComponent(btnPomo)
					.addGap(47))
		);
		
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(unvc.UnosVozaca(Ime.getText(), Prezime.getText(), BrojVozacke.getText(), Adresa.getText(), BrojTelefona.getText(), Username.getText(), Sifra.getText())) {
					frame.dispose();
				}
			}
		});
		
		
		JLabel lblUnosNovogVozaa = new JLabel("Unos novog voza\u010Da");
		lblUnosNovogVozaa.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblUnosNovogVozaa);
		frame.getContentPane().setLayout(groupLayout);
	}
}
