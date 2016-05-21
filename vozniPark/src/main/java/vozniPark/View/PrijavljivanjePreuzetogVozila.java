package vozniPark.View;

import java.awt.EventQueue;
import java.util.Date;

import vozniPark.Util.*;
import vozniPark.Model.*;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import vozniPark.Controller.PrijavaPreuzetogVozilaController;

public class PrijavljivanjePreuzetogVozila {
	
	private PrijavaPreuzetogVozilaController ppvc;
	
	final static Logger logger = Logger.getLogger(PrijavljivanjePreuzetogVozila.class);


	private static final String comboBox = null;


	protected static final String DateTimeFormat = null;

	private JFrame frmPrij;
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
					//e.printStackTrace();
					logger.info(e);
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public PrijavljivanjePreuzetogVozila() {
		initialize();
		ppvc = new PrijavaPreuzetogVozilaController();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrij = new JFrame();
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(177, 28, 161, 20);
		frmPrij.getContentPane().add(comboBox_1);
		
		frmPrij.addWindowListener(new WindowAdapter() {
			@Override
			// kad se forma ucita pokupi sva vozila iz baze
			public void windowOpened(WindowEvent arg0) {
				
				ppvc.ucitajVozilaIzBaze(frmPrij,comboBox_1);
				
			}
		});
		frmPrij.setTitle("Prijavljivanje preuzetog vozila");
		frmPrij.setBounds(100, 100, 403, 212);
		frmPrij.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmPrij.getContentPane().setLayout(null);
		frmPrij.setResizable(false);
		
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
				if (!textField_1.getText().matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
					JOptionPane.showMessageDialog(null,
							"Datum nije ispravno unesen");
					return;
				}

				if (!textField_2.getText().matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")) {
					JOptionPane.showMessageDialog(null,
							"Vrijeme nije ispravno uneseno");
					return;
				}
				ppvc.prijaviVoziloZauzetim(comboBox_1.getSelectedItem().toString(),textField_1.getText(),textField_2.getText());
				//zatvara prozor kad se klikne na dugme
				frmPrij.dispatchEvent(new WindowEvent(frmPrij, WindowEvent.WINDOW_CLOSING));			
			}
		});
		btnNewButton.setBounds(39, 134, 299, 23);
		frmPrij.getContentPane().add(btnNewButton);		
		
	}
}
