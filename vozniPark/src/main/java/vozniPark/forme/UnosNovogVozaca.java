package vozniPark.forme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnosNovogVozaca {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnosNovogVozaca window = new UnosNovogVozaca();
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
	public UnosNovogVozaca() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 709, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnPotvrdi = new JButton("Registruj voza\u010Da");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JTextPane textPane = new JTextPane();
		
		JLabel lblIme = new JLabel("Ime:");
		
		JLabel lblPrezime = new JLabel("Prezime:");
		
		JTextPane textPane_1 = new JTextPane();
		
		JEditorPane editorPane = new JEditorPane();
		
		JLabel lblBrojVozackeDozvole = new JLabel("Broj voza\u010Dke dozvole:");
		
		JTextPane textPane_2 = new JTextPane();
		
		JLabel lblAdresa = new JLabel("Adresa:");
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona:");
		
		JTextPane textPane_4 = new JTextPane();
		
		JLabel lblUsername = new JLabel("Username:");
		
		JTextPane textPane_5 = new JTextPane();
		
		JLabel lblSifra = new JLabel("\u0160ifra:");
		
		JPanel panel = new JPanel();
		
		JTextPane textPane_3 = new JTextPane();
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
							.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(188)
							.addComponent(lblSifra)
							.addGap(18)
							.addComponent(textPane_5, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(131)
							.addComponent(btnPotvrdi, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(96)
								.addComponent(lblBrojVozackeDozvole)
								.addGap(18)
								.addComponent(editorPane))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(175)
								.addComponent(lblAdresa)
								.addGap(18)
								.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(142)
								.addComponent(lblBrojTelefona)
								.addGap(18)
								.addComponent(textPane_3))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(157)
								.addComponent(lblUsername)
								.addGap(18)
								.addComponent(textPane_4, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(193)
							.addComponent(lblIme)
							.addGap(18)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblPrezime))
						.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblBrojVozackeDozvole))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblAdresa))
						.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBrojTelefona)
						.addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblUsername))
						.addComponent(textPane_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblSifra))
						.addComponent(textPane_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(71)
					.addComponent(btnPotvrdi)
					.addGap(70))
		);
		
		JLabel lblUnosNovogVozaa = new JLabel("Unos novog voza\u010Da");
		lblUnosNovogVozaa.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblUnosNovogVozaa);
		frame.getContentPane().setLayout(groupLayout);
	}
}
