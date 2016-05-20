package vozniPark.View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PregledSlobodnihVozila {
	
	final static Logger logger = Logger.getLogger(PregledSlobodnihVozila.class);

	private JFrame frmPregledSlobodnihVozila;
	private JTable table;
	private JTextField naziv;
	private JTextField registracija;
	private PregledSlobodnihVozilaController controller;
	private DefaultTableModel model;
	private String registracijaBr;
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
		frmPregledSlobodnihVozila.setResizable(false);
		
		model = new DefaultTableModel(new Object[]{"Naziv vozila","Proizvođač","God. proizvodnje","Registracija","Status","Opis"},0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 12, 625, 239);
		frmPregledSlobodnihVozila.getContentPane().add(scrollPane);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		//klik na red tabele
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		    	//sprijeci double-click 
		    	if (!event.getValueIsAdjusting()) {
		    		 if (table.getSelectedRow() > -1) {
			    			//otvori prozor sa podacima
		    			    //proslijedi br. registracije
		    			 	registracijaBr = table.getValueAt(table.getSelectedRow(), 3).toString();
				            PodaciOVozilu p = new PodaciOVozilu(registracijaBr);
				            p.main(null); 
				        }
		    	    }		    		
		    }
		});
		
		
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
