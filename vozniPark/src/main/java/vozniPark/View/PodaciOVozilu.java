package vozniPark.View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import org.apache.log4j.Logger;

import vozniPark.Controller.PodaciOVoziluController;
import vozniPark.Model.Vozilo;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowFocusListener;

public class PodaciOVozilu {

	final static Logger logger = Logger.getLogger(PodaciOVozilu.class);

	private JFrame frame;
	private JLabel saobracajnatxt;
	private JLabel dozvolaTxt;
	private JLabel registracijaTxt;
	private JLabel mjeseciTxt;
	private JLabel kilometriTxt;
	private JLabel nazivTxt;
	private JLabel godinaTxt;
	private JLabel proizvodjacTxt;
	private JLabel opisTxt;
	private String brojRegistracije;
	private PodaciOVoziluController controller;
	private Vozilo vozilo;
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PodaciOVozilu window = new PodaciOVozilu();
					window.frame.setVisible(false);
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
	public PodaciOVozilu() {
		initialize();
	}
	
	public PodaciOVozilu(String s) {
		controller = new PodaciOVoziluController();
		vozilo = controller.nadjiVoziloPoReg(s);
		initialize();
		prikaziPodatke();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 482, 374);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 142, 212, 0};
		gridBagLayout.rowHeights = new int[]{34, 20, 23, 23, 23, 23, 23, 23, 23, 57, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Broj saobra\u0107ajne dozvole:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		saobracajnatxt = new JLabel("");
		GridBagConstraints gbc_saobracajnatxt = new GridBagConstraints();
		gbc_saobracajnatxt.anchor = GridBagConstraints.WEST;
		gbc_saobracajnatxt.insets = new Insets(0, 0, 5, 0);
		gbc_saobracajnatxt.gridx = 2;
		gbc_saobracajnatxt.gridy = 1;
		frame.getContentPane().add(saobracajnatxt, gbc_saobracajnatxt);
		
		JLabel lblBrojVlasnikeDozvole = new JLabel("Broj vlasni\u010Dke dozvole :");
		GridBagConstraints gbc_lblBrojVlasnikeDozvole = new GridBagConstraints();
		gbc_lblBrojVlasnikeDozvole.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblBrojVlasnikeDozvole.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrojVlasnikeDozvole.gridx = 1;
		gbc_lblBrojVlasnikeDozvole.gridy = 2;
		frame.getContentPane().add(lblBrojVlasnikeDozvole, gbc_lblBrojVlasnikeDozvole);
		
		dozvolaTxt = new JLabel("");
		GridBagConstraints gbc_dozvolaTxt = new GridBagConstraints();
		gbc_dozvolaTxt.anchor = GridBagConstraints.WEST;
		gbc_dozvolaTxt.insets = new Insets(0, 0, 5, 0);
		gbc_dozvolaTxt.gridx = 2;
		gbc_dozvolaTxt.gridy = 2;
		frame.getContentPane().add(dozvolaTxt, gbc_dozvolaTxt);
		
		JLabel lblRegistracija = new JLabel("Registracija :");
		GridBagConstraints gbc_lblRegistracija = new GridBagConstraints();
		gbc_lblRegistracija.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblRegistracija.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistracija.gridx = 1;
		gbc_lblRegistracija.gridy = 3;
		frame.getContentPane().add(lblRegistracija, gbc_lblRegistracija);
		
		registracijaTxt = new JLabel("");
		GridBagConstraints gbc_registracijaTxt = new GridBagConstraints();
		gbc_registracijaTxt.anchor = GridBagConstraints.WEST;
		gbc_registracijaTxt.insets = new Insets(0, 0, 5, 0);
		gbc_registracijaTxt.gridx = 2;
		gbc_registracijaTxt.gridy = 3;
		frame.getContentPane().add(registracijaTxt, gbc_registracijaTxt);
		
		JLabel lblIntervalServisamjeseci = new JLabel("Interval servisa(mjeseci) :");
		GridBagConstraints gbc_lblIntervalServisamjeseci = new GridBagConstraints();
		gbc_lblIntervalServisamjeseci.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblIntervalServisamjeseci.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntervalServisamjeseci.gridx = 1;
		gbc_lblIntervalServisamjeseci.gridy = 4;
		frame.getContentPane().add(lblIntervalServisamjeseci, gbc_lblIntervalServisamjeseci);
		
		mjeseciTxt = new JLabel("");
		GridBagConstraints gbc_mjeseciTxt = new GridBagConstraints();
		gbc_mjeseciTxt.anchor = GridBagConstraints.WEST;
		gbc_mjeseciTxt.insets = new Insets(0, 0, 5, 0);
		gbc_mjeseciTxt.gridx = 2;
		gbc_mjeseciTxt.gridy = 4;
		frame.getContentPane().add(mjeseciTxt, gbc_mjeseciTxt);
		
		JLabel lblIntervalServisakilometri = new JLabel("Interval servisa(kilometri) :");
		GridBagConstraints gbc_lblIntervalServisakilometri = new GridBagConstraints();
		gbc_lblIntervalServisakilometri.anchor = GridBagConstraints.NORTH;
		gbc_lblIntervalServisakilometri.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIntervalServisakilometri.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntervalServisakilometri.gridx = 1;
		gbc_lblIntervalServisakilometri.gridy = 5;
		frame.getContentPane().add(lblIntervalServisakilometri, gbc_lblIntervalServisakilometri);
		
		kilometriTxt = new JLabel("");
		GridBagConstraints gbc_kilometriTxt = new GridBagConstraints();
		gbc_kilometriTxt.anchor = GridBagConstraints.WEST;
		gbc_kilometriTxt.insets = new Insets(0, 0, 5, 0);
		gbc_kilometriTxt.gridx = 2;
		gbc_kilometriTxt.gridy = 5;
		frame.getContentPane().add(kilometriTxt, gbc_kilometriTxt);
		
		JLabel lblNazivVozila = new JLabel("Naziv vozila :");
		GridBagConstraints gbc_lblNazivVozila = new GridBagConstraints();
		gbc_lblNazivVozila.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNazivVozila.insets = new Insets(0, 0, 5, 5);
		gbc_lblNazivVozila.gridx = 1;
		gbc_lblNazivVozila.gridy = 6;
		frame.getContentPane().add(lblNazivVozila, gbc_lblNazivVozila);
		
		nazivTxt = new JLabel("");
		GridBagConstraints gbc_nazivTxt = new GridBagConstraints();
		gbc_nazivTxt.anchor = GridBagConstraints.WEST;
		gbc_nazivTxt.insets = new Insets(0, 0, 5, 0);
		gbc_nazivTxt.gridx = 2;
		gbc_nazivTxt.gridy = 6;
		frame.getContentPane().add(nazivTxt, gbc_nazivTxt);
		
		JLabel lblGodinaProizvodnje = new JLabel("Godina proizvodnje :");
		GridBagConstraints gbc_lblGodinaProizvodnje = new GridBagConstraints();
		gbc_lblGodinaProizvodnje.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblGodinaProizvodnje.insets = new Insets(0, 0, 5, 5);
		gbc_lblGodinaProizvodnje.gridx = 1;
		gbc_lblGodinaProizvodnje.gridy = 7;
		frame.getContentPane().add(lblGodinaProizvodnje, gbc_lblGodinaProizvodnje);
		
		godinaTxt = new JLabel("");
		GridBagConstraints gbc_godinaTxt = new GridBagConstraints();
		gbc_godinaTxt.anchor = GridBagConstraints.WEST;
		gbc_godinaTxt.insets = new Insets(0, 0, 5, 0);
		gbc_godinaTxt.gridx = 2;
		gbc_godinaTxt.gridy = 7;
		frame.getContentPane().add(godinaTxt, gbc_godinaTxt);
		
		JLabel lblProizvoa = new JLabel("Proizvo\u0111a\u010D :");
		GridBagConstraints gbc_lblProizvoa = new GridBagConstraints();
		gbc_lblProizvoa.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblProizvoa.insets = new Insets(0, 0, 5, 5);
		gbc_lblProizvoa.gridx = 1;
		gbc_lblProizvoa.gridy = 8;
		frame.getContentPane().add(lblProizvoa, gbc_lblProizvoa);
		
		proizvodjacTxt = new JLabel("");
		GridBagConstraints gbc_proizvodjacTxt = new GridBagConstraints();
		gbc_proizvodjacTxt.anchor = GridBagConstraints.WEST;
		gbc_proizvodjacTxt.insets = new Insets(0, 0, 5, 0);
		gbc_proizvodjacTxt.gridx = 2;
		gbc_proizvodjacTxt.gridy = 8;
		frame.getContentPane().add(proizvodjacTxt, gbc_proizvodjacTxt);
		
		JLabel lblOpis = new JLabel("Opis :");
		GridBagConstraints gbc_lblOpis = new GridBagConstraints();
		gbc_lblOpis.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblOpis.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpis.gridx = 1;
		gbc_lblOpis.gridy = 9;
		frame.getContentPane().add(lblOpis, gbc_lblOpis);
		
		JButton btnNatrag = new JButton("Natrag");
		btnNatrag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		opisTxt = new JLabel("");
		GridBagConstraints gbc_opisTxt = new GridBagConstraints();
		gbc_opisTxt.anchor = GridBagConstraints.WEST;
		gbc_opisTxt.insets = new Insets(0, 0, 5, 0);
		gbc_opisTxt.gridx = 2;
		gbc_opisTxt.gridy = 9;
		frame.getContentPane().add(opisTxt, gbc_opisTxt);
		GridBagConstraints gbc_btnNatrag = new GridBagConstraints();
		gbc_btnNatrag.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNatrag.gridx = 2;
		gbc_btnNatrag.gridy = 10;
		frame.getContentPane().add(btnNatrag, gbc_btnNatrag);
	}
	
	public void prikaziPodatke(){
		
		saobracajnatxt.setText(vozilo.getBrojSaobracajneDozvole());
		dozvolaTxt.setText(vozilo.getBrojVlasnickeDozvole());
		registracijaTxt.setText(vozilo.getRegistracija());
		mjeseciTxt.setText(String.valueOf(vozilo.getIntervalServisaMjeseci()));
		kilometriTxt.setText(String.valueOf(vozilo.getIntervalServisaKilometri()));
		nazivTxt.setText(vozilo.getNaziv());
		godinaTxt.setText(String.valueOf(vozilo.getGodinaProizvodnje()));
		proizvodjacTxt.setText(vozilo.getProizvodjac());
		opisTxt.setText(vozilo.getOpis());
		frame.setVisible(true);
	}
	
}
