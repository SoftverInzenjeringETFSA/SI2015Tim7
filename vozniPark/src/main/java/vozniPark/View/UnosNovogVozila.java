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

import vozniPark.Controller.UnosNovogVozilaController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnosNovogVozila {

	final static Logger logger = Logger.getLogger(UnosNovogVozila.class);

	private JFrame frame;
	private JTextField saobracajnaDozvola;
	private JTextField vlasnickaDozvola;
	private JTextField registracija;
	private JTextField intervalMjeseci;
	private JTextField intervalKilometara;
	private JTextField nazivVozila;
	private JTextField godinaProizvodnje;
	private JTextField proizvodjac;
	private JTextField opis;
	private UnosNovogVozilaController controller;
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnosNovogVozila window = new UnosNovogVozila();
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
	public UnosNovogVozila() {
		initialize();
		controller = new UnosNovogVozilaController();
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
		
		saobracajnaDozvola = new JTextField();
		GridBagConstraints gbc_saobracajnaDozvola = new GridBagConstraints();
		gbc_saobracajnaDozvola.anchor = GridBagConstraints.NORTHWEST;
		gbc_saobracajnaDozvola.insets = new Insets(0, 0, 5, 0);
		gbc_saobracajnaDozvola.gridx = 2;
		gbc_saobracajnaDozvola.gridy = 1;
		frame.getContentPane().add(saobracajnaDozvola, gbc_saobracajnaDozvola);
		saobracajnaDozvola.setColumns(10);
		
		JLabel lblBrojVlasnikeDozvole = new JLabel("Broj vlasni\u010Dke dozvole :");
		GridBagConstraints gbc_lblBrojVlasnikeDozvole = new GridBagConstraints();
		gbc_lblBrojVlasnikeDozvole.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblBrojVlasnikeDozvole.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrojVlasnikeDozvole.gridx = 1;
		gbc_lblBrojVlasnikeDozvole.gridy = 2;
		frame.getContentPane().add(lblBrojVlasnikeDozvole, gbc_lblBrojVlasnikeDozvole);
		
		vlasnickaDozvola = new JTextField();
		vlasnickaDozvola.setColumns(10);
		GridBagConstraints gbc_vlasnickaDozvola = new GridBagConstraints();
		gbc_vlasnickaDozvola.anchor = GridBagConstraints.SOUTHWEST;
		gbc_vlasnickaDozvola.insets = new Insets(0, 0, 5, 0);
		gbc_vlasnickaDozvola.gridx = 2;
		gbc_vlasnickaDozvola.gridy = 2;
		frame.getContentPane().add(vlasnickaDozvola, gbc_vlasnickaDozvola);
		
		JLabel lblRegistracija = new JLabel("Registracija :");
		GridBagConstraints gbc_lblRegistracija = new GridBagConstraints();
		gbc_lblRegistracija.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblRegistracija.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistracija.gridx = 1;
		gbc_lblRegistracija.gridy = 3;
		frame.getContentPane().add(lblRegistracija, gbc_lblRegistracija);
		
		registracija = new JTextField();
		registracija.setColumns(10);
		GridBagConstraints gbc_registracija = new GridBagConstraints();
		gbc_registracija.anchor = GridBagConstraints.SOUTHWEST;
		gbc_registracija.insets = new Insets(0, 0, 5, 0);
		gbc_registracija.gridx = 2;
		gbc_registracija.gridy = 3;
		frame.getContentPane().add(registracija, gbc_registracija);
		
		JLabel lblIntervalServisamjeseci = new JLabel("Interval servisa(mjeseci) :");
		GridBagConstraints gbc_lblIntervalServisamjeseci = new GridBagConstraints();
		gbc_lblIntervalServisamjeseci.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblIntervalServisamjeseci.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntervalServisamjeseci.gridx = 1;
		gbc_lblIntervalServisamjeseci.gridy = 4;
		frame.getContentPane().add(lblIntervalServisamjeseci, gbc_lblIntervalServisamjeseci);
		
		intervalMjeseci = new JTextField();
		intervalMjeseci.setColumns(10);
		GridBagConstraints gbc_intervalMjeseci = new GridBagConstraints();
		gbc_intervalMjeseci.anchor = GridBagConstraints.SOUTHWEST;
		gbc_intervalMjeseci.insets = new Insets(0, 0, 5, 0);
		gbc_intervalMjeseci.gridx = 2;
		gbc_intervalMjeseci.gridy = 4;
		frame.getContentPane().add(intervalMjeseci, gbc_intervalMjeseci);
		
		JLabel lblIntervalServisakilometri = new JLabel("Interval servisa(kilometri) :");
		GridBagConstraints gbc_lblIntervalServisakilometri = new GridBagConstraints();
		gbc_lblIntervalServisakilometri.anchor = GridBagConstraints.NORTH;
		gbc_lblIntervalServisakilometri.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIntervalServisakilometri.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntervalServisakilometri.gridx = 1;
		gbc_lblIntervalServisakilometri.gridy = 5;
		frame.getContentPane().add(lblIntervalServisakilometri, gbc_lblIntervalServisakilometri);
		
		intervalKilometara = new JTextField();
		intervalKilometara.setColumns(10);
		GridBagConstraints gbc_intervalKilometara = new GridBagConstraints();
		gbc_intervalKilometara.anchor = GridBagConstraints.SOUTHWEST;
		gbc_intervalKilometara.insets = new Insets(0, 0, 5, 0);
		gbc_intervalKilometara.gridx = 2;
		gbc_intervalKilometara.gridy = 5;
		frame.getContentPane().add(intervalKilometara, gbc_intervalKilometara);
		
		JLabel lblNazivVozila = new JLabel("Naziv vozila :");
		GridBagConstraints gbc_lblNazivVozila = new GridBagConstraints();
		gbc_lblNazivVozila.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNazivVozila.insets = new Insets(0, 0, 5, 5);
		gbc_lblNazivVozila.gridx = 1;
		gbc_lblNazivVozila.gridy = 6;
		frame.getContentPane().add(lblNazivVozila, gbc_lblNazivVozila);
		
		nazivVozila = new JTextField();
		nazivVozila.setColumns(10);
		GridBagConstraints gbc_nazivVozila = new GridBagConstraints();
		gbc_nazivVozila.anchor = GridBagConstraints.SOUTHWEST;
		gbc_nazivVozila.insets = new Insets(0, 0, 5, 0);
		gbc_nazivVozila.gridx = 2;
		gbc_nazivVozila.gridy = 6;
		frame.getContentPane().add(nazivVozila, gbc_nazivVozila);
		
		JLabel lblGodinaProizvodnje = new JLabel("Godina proizvodnje :");
		GridBagConstraints gbc_lblGodinaProizvodnje = new GridBagConstraints();
		gbc_lblGodinaProizvodnje.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblGodinaProizvodnje.insets = new Insets(0, 0, 5, 5);
		gbc_lblGodinaProizvodnje.gridx = 1;
		gbc_lblGodinaProizvodnje.gridy = 7;
		frame.getContentPane().add(lblGodinaProizvodnje, gbc_lblGodinaProizvodnje);
		
		godinaProizvodnje = new JTextField();
		godinaProizvodnje.setColumns(10);
		GridBagConstraints gbc_godinaProizvodnje = new GridBagConstraints();
		gbc_godinaProizvodnje.anchor = GridBagConstraints.SOUTHWEST;
		gbc_godinaProizvodnje.insets = new Insets(0, 0, 5, 0);
		gbc_godinaProizvodnje.gridx = 2;
		gbc_godinaProizvodnje.gridy = 7;
		frame.getContentPane().add(godinaProizvodnje, gbc_godinaProizvodnje);
		
		JLabel lblProizvoa = new JLabel("Proizvo\u0111a\u010D :");
		GridBagConstraints gbc_lblProizvoa = new GridBagConstraints();
		gbc_lblProizvoa.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblProizvoa.insets = new Insets(0, 0, 5, 5);
		gbc_lblProizvoa.gridx = 1;
		gbc_lblProizvoa.gridy = 8;
		frame.getContentPane().add(lblProizvoa, gbc_lblProizvoa);
		
		proizvodjac = new JTextField();
		proizvodjac.setColumns(10);
		GridBagConstraints gbc_proizvodjac = new GridBagConstraints();
		gbc_proizvodjac.anchor = GridBagConstraints.SOUTHWEST;
		gbc_proizvodjac.insets = new Insets(0, 0, 5, 0);
		gbc_proizvodjac.gridx = 2;
		gbc_proizvodjac.gridy = 8;
		frame.getContentPane().add(proizvodjac, gbc_proizvodjac);
		
		JLabel lblOpis = new JLabel("Opis :");
		GridBagConstraints gbc_lblOpis = new GridBagConstraints();
		gbc_lblOpis.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblOpis.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpis.gridx = 1;
		gbc_lblOpis.gridy = 9;
		frame.getContentPane().add(lblOpis, gbc_lblOpis);
		
		opis = new JTextField();
		opis.setColumns(10);
		GridBagConstraints gbc_opis = new GridBagConstraints();
		gbc_opis.fill = GridBagConstraints.BOTH;
		gbc_opis.insets = new Insets(0, 0, 5, 0);
		gbc_opis.gridx = 2;
		gbc_opis.gridy = 9;
		frame.getContentPane().add(opis, gbc_opis);
		
		JButton btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.unesiVozilo(saobracajnaDozvola.getText(),
				vlasnickaDozvola.getText(),
				registracija.getText(),
				intervalMjeseci.getText(),
				intervalKilometara.getText(),
				nazivVozila.getText(),
				godinaProizvodnje.getText(),
				proizvodjac.getText(),
				opis.getText(), frame);
			}
		});
		GridBagConstraints gbc_btnUnesi = new GridBagConstraints();
		gbc_btnUnesi.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnUnesi.gridx = 2;
		gbc_btnUnesi.gridy = 10;
		frame.getContentPane().add(btnUnesi, gbc_btnUnesi);
	}
}
