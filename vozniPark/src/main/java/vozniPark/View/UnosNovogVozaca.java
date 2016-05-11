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
import org.hibernate.Session;


import vozniPark.Model.Vozac;
import vozniPark.Model.VozniPark;

public class UnosNovogVozaca {

	final static Logger logger = Logger.getLogger(UnosNovogVozaca.class);

	private JFrame frame;
	private Session s;
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 709, 592);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(169)
							.addComponent(lblPrezime)
							.addGap(18)
							.addComponent(Prezime, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(188)
							.addComponent(lblSifra)
							.addGap(18)
							.addComponent(Sifra, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(131)
							.addComponent(btnPotvrdi, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(96)
								.addComponent(lblBrojVozackeDozvole)
								.addGap(18)
								.addComponent(BrojVozacke))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(175)
								.addComponent(lblAdresa)
								.addGap(18)
								.addComponent(Adresa, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(142)
								.addComponent(lblBrojTelefona)
								.addGap(18)
								.addComponent(BrojTelefona))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(157)
								.addComponent(lblUsername)
								.addGap(18)
								.addComponent(Username, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(193)
							.addComponent(lblIme)
							.addGap(18)
							.addComponent(Ime, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(206)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)))
					.addGap(138))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblIme))
						.addComponent(Ime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblPrezime))
						.addComponent(Prezime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblBrojVozackeDozvole))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(BrojVozacke, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblAdresa))
						.addComponent(Adresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBrojTelefona)
						.addComponent(BrojTelefona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblUsername))
						.addComponent(Username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblSifra))
						.addComponent(Sifra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(71)
					.addComponent(btnPotvrdi)
					.addGap(70))
		);
		
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Ime.getText().length()<2){
					JOptionPane.showMessageDialog(null, "Neispravno uneseno ime");
				}
				
				if(Prezime.getText().length()<3){
					JOptionPane.showMessageDialog(null, "Neispravno uneseno prezime");
				}
				
				if(BrojVozacke.getText().length()!=9){
					JOptionPane.showMessageDialog(null, "Neispravno unesen broj vozacke");
				}

				if(Adresa.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Unesite adresu.");
					return;
				}
				
				if(BrojTelefona.getText().length()!= 9 && BrojTelefona.getText().length()!=10) {
					JOptionPane.showMessageDialog(null, "Niste pravilno unijeli broj telefona.");
					return;
				}
				if(Username.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Unesite username.");
					return;
				}
				if(Sifra.getText().length()<4) {
					JOptionPane.showMessageDialog(null, "Sifra mora imati minimalno 4 slova.");
					return;
				}
				VozniPark vp=new VozniPark(s);
				Vozac v=new Vozac();
				v.setIme(Ime.getText());
				v.setPrezime(Prezime.getText());
				v.setBrojVozacke(BrojVozacke.getText());
				v.setAdresa(Adresa.getText());
				v.setBrojTelefona(BrojTelefona.getText());
				v.setUsername(Username.getText());
				v.setPassword(Sifra.getText());
			}
		});
		
		
		JLabel lblUnosNovogVozaa = new JLabel("Unos novog voza\u010Da");
		lblUnosNovogVozaa.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblUnosNovogVozaa);
		frame.getContentPane().setLayout(groupLayout);
	}
}
