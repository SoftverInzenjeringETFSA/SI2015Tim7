package vozniPark.View;

import java.awt.EventQueue;
import vozniPark.Controller.OdjavaPreuzetogVozilaController;

import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OdjavljivanjePreuzetogVozila {
	
	private OdjavaPreuzetogVozilaController opvc;
	
	final static Logger logger = Logger.getLogger(OdjavljivanjePreuzetogVozila.class);

	private JFrame frmOdjavljivanjePreuzetogVozila;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OdjavljivanjePreuzetogVozila window = new OdjavljivanjePreuzetogVozila();
					window.frmOdjavljivanjePreuzetogVozila.setVisible(true);
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
	public OdjavljivanjePreuzetogVozila() {
		initialize();
		opvc = new OdjavaPreuzetogVozilaController();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOdjavljivanjePreuzetogVozila = new JFrame();
		frmOdjavljivanjePreuzetogVozila.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				opvc.ucitajVozilaIzBaze(frmOdjavljivanjePreuzetogVozila, comboBox);
			}
		});
		frmOdjavljivanjePreuzetogVozila.setTitle("Odjavljivanje preuzetog vozila");
		frmOdjavljivanjePreuzetogVozila.setBounds(100, 100, 450, 400);
		frmOdjavljivanjePreuzetogVozila.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmOdjavljivanjePreuzetogVozila.getContentPane().setLayout(null);
		frmOdjavljivanjePreuzetogVozila.setResizable(false);
		
		JLabel lblRegistracijskiBroj = new JLabel("Broj registracijske tablice:");
		lblRegistracijskiBroj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegistracijskiBroj.setBounds(29, 29, 152, 25);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(lblRegistracijskiBroj);
		
		JLabel lblDatumVraanja = new JLabel("Datum vra\u0107anja:");
		lblDatumVraanja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatumVraanja.setBounds(58, 65, 123, 25);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(lblDatumVraanja);
		
		JLabel lblVrijemeVraanja = new JLabel("Vrijeme vra\u0107anja:");
		lblVrijemeVraanja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVrijemeVraanja.setBounds(58, 101, 123, 25);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(lblVrijemeVraanja);
		
		JLabel lblBrojPreenihKilometara = new JLabel("Broj pre\u0111enih kilometara:");
		lblBrojPreenihKilometara.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBrojPreenihKilometara.setBounds(35, 137, 145, 25);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(lblBrojPreenihKilometara);
		
		JLabel lblOpisKoritenjaVozila = new JLabel("Opis kori\u0161tenja vozila:");
		lblOpisKoritenjaVozila.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOpisKoritenjaVozila.setBounds(37, 173, 143, 25);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(lblOpisKoritenjaVozila);
		
		JLabel lblPotronjaGorivaopcionalno = new JLabel("Potro\u0161nja goriva (opcionalno):");
		lblPotronjaGorivaopcionalno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPotronjaGorivaopcionalno.setBounds(10, 253, 171, 25);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(lblPotronjaGorivaopcionalno);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 67, 185, 20);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(218, 103, 185, 20);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(218, 139, 185, 20);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(218, 255, 185, 20);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Odjavi vozilo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField_1.getText();
				String s1 = textField_2.getText();
				String s2 = textField_3.getText();
				String s3 = textField_4.getText();
				String s4 = textField_5.getText();
				String s5 = textField_6.getText();
				if(s.length() == 0 || s1.length() == 0 ||s2.length() == 0 ||s4.length() == 0) {
					JOptionPane.showMessageDialog(null, "Nisu svi podaci uneseni.");
					return;
				}
				if(s3.length() == 0) {
					s3 = "0";
					s5 = "0";
				}
				opvc.odjaviVozilo(comboBox.getSelectedItem().toString(), s, s1,Long.valueOf(s2), s4, Double.valueOf(s3),Double.valueOf(s5));
				//zatvara prozor kad se klikne na dugme
				frmOdjavljivanjePreuzetogVozila.dispatchEvent(new WindowEvent(frmOdjavljivanjePreuzetogVozila, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnNewButton.setBounds(36, 325, 367, 25);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(btnNewButton);
		
		textField_5 = new JTextField();
		textField_5.setBounds(218, 175, 185, 69);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(218, 31, 185, 20);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(comboBox);
		
		JLabel lblCijenaGoriva = new JLabel("Cijena goriva:");
		lblCijenaGoriva.setBounds(108, 289, 73, 14);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(lblCijenaGoriva);
		
		textField_6 = new JTextField();
		textField_6.setBounds(218, 286, 185, 20);
		frmOdjavljivanjePreuzetogVozila.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		
	}
}
