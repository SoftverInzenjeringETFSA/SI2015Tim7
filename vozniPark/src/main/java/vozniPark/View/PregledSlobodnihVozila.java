package vozniPark.View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import vozniPark.Controller.PregledSlobodnihVozilaController;
import vozniPark.Model.Vozilo;
import vozniPark.Util.HibernateUtil;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class PregledSlobodnihVozila {
	
	final static Logger logger = Logger.getLogger(PregledSlobodnihVozila.class);

	private JFrame frmPregledSlobodnihVozila;
	private JTable table;
	private JTextField naziv;
	private JTextField registracija;
	private PregledSlobodnihVozilaController controller;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PregledSlobodnihVozila window = new PregledSlobodnihVozila();
					window.frmPregledSlobodnihVozila.setVisible(true);
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
	public PregledSlobodnihVozila() {
		controller = new PregledSlobodnihVozilaController();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPregledSlobodnihVozila = new JFrame();
		frmPregledSlobodnihVozila.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				controller.dajSvaSlobodnaVozila(model, table);
			}
		});

		frmPregledSlobodnihVozila.setTitle("Pregled slobodnih vozila");
		frmPregledSlobodnihVozila.setBounds(100, 100, 899, 300);
		frmPregledSlobodnihVozila.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmPregledSlobodnihVozila.getContentPane().setLayout(null);
		
		model = new DefaultTableModel(new Object[]{"1","2","3","4","5","6"},0);
		table = new JTable();
		table.setBounds(10, 43, 625, 208);
		frmPregledSlobodnihVozila.getContentPane().add(table);
		
		JLabel lblNazivVozila = new JLabel("Naziv vozila");
		lblNazivVozila.setBounds(15, 15, 86, 14);
		frmPregledSlobodnihVozila.getContentPane().add(lblNazivVozila);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(96, 14, 8, 17);
		frmPregledSlobodnihVozila.getContentPane().add(separator);
		
		JLabel lblRegistracija = new JLabel("Registracija");
		lblRegistracija.setBounds(345, 15, 86, 14);
		frmPregledSlobodnihVozila.getContentPane().add(lblRegistracija);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(195, 14, 8, 17);
		frmPregledSlobodnihVozila.getContentPane().add(separator_1);
		
		JLabel lblProizvoa = new JLabel("Proizvo\u0111a\u010D");
		lblProizvoa.setBounds(114, 15, 67, 14);
		frmPregledSlobodnihVozila.getContentPane().add(lblProizvoa);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(327, 14, 8, 17);
		frmPregledSlobodnihVozila.getContentPane().add(separator_2);
		
		JLabel lblGodProizvodnje = new JLabel("God. proizvodnje");
		lblGodProizvodnje.setBounds(215, 15, 105, 14);
		frmPregledSlobodnihVozila.getContentPane().add(lblGodProizvodnje);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(428, 14, 8, 17);
		frmPregledSlobodnihVozila.getContentPane().add(separator_3);
		
		JLabel lblOpis = new JLabel("Opis");
		lblOpis.setBounds(555, 15, 46, 14);
		frmPregledSlobodnihVozila.getContentPane().add(lblOpis);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(500, 14, 8, 17);
		frmPregledSlobodnihVozila.getContentPane().add(separator_4);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(445, 15, 46, 14);
		frmPregledSlobodnihVozila.getContentPane().add(lblStatus);
		
		JLabel lblNazivVozila_1 = new JLabel("Naziv  vozila:");
		lblNazivVozila_1.setBounds(670, 65, 86, 14);
		frmPregledSlobodnihVozila.getContentPane().add(lblNazivVozila_1);
		
		JLabel lblPretragaVozila = new JLabel("Pretraga vozila");
		lblPretragaVozila.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPretragaVozila.setBounds(715, 12, 111, 25);
		frmPregledSlobodnihVozila.getContentPane().add(lblPretragaVozila);
		
		JLabel lblRegistracija_1 = new JLabel("Registracija:");
		lblRegistracija_1.setBounds(670, 100, 86, 14);
		frmPregledSlobodnihVozila.getContentPane().add(lblRegistracija_1);
		
		naziv = new JTextField();
		naziv.setBounds(755, 62, 118, 20);
		frmPregledSlobodnihVozila.getContentPane().add(naziv);
		naziv.setColumns(10);
		
		registracija = new JTextField();
		registracija.setBounds(755, 97, 118, 20);
		frmPregledSlobodnihVozila.getContentPane().add(registracija);
		registracija.setColumns(10);
		
		JButton btnNewButton = new JButton("Prika\u017Ei vozilo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.pretraziSlobodnaVozila(naziv.getText(),registracija.getText(), model, table);
			}
		});
		btnNewButton.setBounds(755, 133, 118, 23);
		frmPregledSlobodnihVozila.getContentPane().add(btnNewButton);
		
		JButton btnPrikaiSvaVozila = new JButton("Prika\u017Ei sva vozila");
		btnPrikaiSvaVozila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.dajSvaSlobodnaVozila(model,table);
			}
		});
		btnPrikaiSvaVozila.setBounds(671, 228, 202, 23);
		frmPregledSlobodnihVozila.getContentPane().add(btnPrikaiSvaVozila);
	}
}
