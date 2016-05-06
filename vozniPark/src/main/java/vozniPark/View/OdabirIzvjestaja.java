package vozniPark.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class OdabirIzvjestaja {

	private JFrame frmIzvjetaji;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OdabirIzvjestaja window = new OdabirIzvjestaja();
					window.frmIzvjetaji.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
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
		frmIzvjetaji.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIzvjetaji.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Izvještaj o aktivnostima vozača");
		btnNewButton.setBounds(71, 11, 197, 23);
		frmIzvjetaji.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Izvještaj o odabranom vozilu");
		btnNewButton_1.setBounds(71, 61, 197, 23);
		frmIzvjetaji.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Izvještaj o svim servisima");
		btnNewButton_2.setBounds(71, 111, 197, 23);
		frmIzvjetaji.getContentPane().add(btnNewButton_2);
	}

}
