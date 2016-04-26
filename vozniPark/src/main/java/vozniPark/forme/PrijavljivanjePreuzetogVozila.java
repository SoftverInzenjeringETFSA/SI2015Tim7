package vozniPark.forme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrijavljivanjePreuzetogVozila {

	private JFrame frmPrij;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrijavljivanjePreuzetogVozila window = new PrijavljivanjePreuzetogVozila();
					window.frmPrij.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrijavljivanjePreuzetogVozila() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrij = new JFrame();
		frmPrij.setTitle("Prijavljivanje preuzetog vozila");
		frmPrij.setBounds(100, 100, 403, 212);
		frmPrij.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrij.getContentPane().setLayout(null);
		
		JLabel lblBrojRegistarskeTablice = new JLabel("Broj registarske tablice:");
		lblBrojRegistarskeTablice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBrojRegistarskeTablice.setBounds(10, 26, 144, 25);
		frmPrij.getContentPane().add(lblBrojRegistarskeTablice);
		
		JLabel lblDatumPreuzimanja = new JLabel("Datum preuzimanja:");
		lblDatumPreuzimanja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatumPreuzimanja.setBounds(39, 62, 114, 25);
		frmPrij.getContentPane().add(lblDatumPreuzimanja);
		
		JLabel lblVrijemePreuzimanja = new JLabel("Vrijeme preuzimanja:");
		lblVrijemePreuzimanja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVrijemePreuzimanja.setBounds(29, 98, 124, 25);
		frmPrij.getContentPane().add(lblVrijemePreuzimanja);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(177, 28, 161, 20);
		frmPrij.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(177, 64, 161, 20);
		frmPrij.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(177, 100, 161, 20);
		frmPrij.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Prijavi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(39, 134, 299, 23);
		frmPrij.getContentPane().add(btnNewButton);
	}
}
