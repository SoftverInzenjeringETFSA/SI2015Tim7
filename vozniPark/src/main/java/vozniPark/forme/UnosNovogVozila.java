package vozniPark.forme;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class UnosNovogVozila {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnosNovogVozila window = new UnosNovogVozila();
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
	public UnosNovogVozila() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 482, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 142, 212, 0};
		gridBagLayout.rowHeights = new int[]{34, 20, 23, 23, 23, 23, 23, 23, 23, 57, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Broj saobra\u0107ajne dozvole:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblBrojVlasnikeDozvole = new JLabel("Broj vlasni\u010Dke dozvole :");
		GridBagConstraints gbc_lblBrojVlasnikeDozvole = new GridBagConstraints();
		gbc_lblBrojVlasnikeDozvole.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblBrojVlasnikeDozvole.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrojVlasnikeDozvole.gridx = 1;
		gbc_lblBrojVlasnikeDozvole.gridy = 2;
		frame.getContentPane().add(lblBrojVlasnikeDozvole, gbc_lblBrojVlasnikeDozvole);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.SOUTHWEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		
		JLabel lblRegistracija = new JLabel("Registracija :");
		GridBagConstraints gbc_lblRegistracija = new GridBagConstraints();
		gbc_lblRegistracija.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblRegistracija.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistracija.gridx = 1;
		gbc_lblRegistracija.gridy = 3;
		frame.getContentPane().add(lblRegistracija, gbc_lblRegistracija);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.SOUTHWEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		frame.getContentPane().add(textField_2, gbc_textField_2);
		
		JLabel lblIntervalServisamjeseci = new JLabel("Interval servisa(mjeseci) :");
		GridBagConstraints gbc_lblIntervalServisamjeseci = new GridBagConstraints();
		gbc_lblIntervalServisamjeseci.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblIntervalServisamjeseci.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntervalServisamjeseci.gridx = 1;
		gbc_lblIntervalServisamjeseci.gridy = 4;
		frame.getContentPane().add(lblIntervalServisamjeseci, gbc_lblIntervalServisamjeseci);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.SOUTHWEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		frame.getContentPane().add(textField_3, gbc_textField_3);
		
		JLabel lblIntervalServisakilometri = new JLabel("Interval servisa(kilometri) :");
		GridBagConstraints gbc_lblIntervalServisakilometri = new GridBagConstraints();
		gbc_lblIntervalServisakilometri.anchor = GridBagConstraints.NORTH;
		gbc_lblIntervalServisakilometri.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIntervalServisakilometri.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntervalServisakilometri.gridx = 1;
		gbc_lblIntervalServisakilometri.gridy = 5;
		frame.getContentPane().add(lblIntervalServisakilometri, gbc_lblIntervalServisakilometri);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.SOUTHWEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 5;
		frame.getContentPane().add(textField_4, gbc_textField_4);
		
		JLabel lblNazivVozila = new JLabel("Naziv vozila :");
		GridBagConstraints gbc_lblNazivVozila = new GridBagConstraints();
		gbc_lblNazivVozila.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNazivVozila.insets = new Insets(0, 0, 5, 5);
		gbc_lblNazivVozila.gridx = 1;
		gbc_lblNazivVozila.gridy = 6;
		frame.getContentPane().add(lblNazivVozila, gbc_lblNazivVozila);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.SOUTHWEST;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 6;
		frame.getContentPane().add(textField_5, gbc_textField_5);
		
		JLabel lblGodinaProizvodnje = new JLabel("Godina proizvodnje :");
		GridBagConstraints gbc_lblGodinaProizvodnje = new GridBagConstraints();
		gbc_lblGodinaProizvodnje.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblGodinaProizvodnje.insets = new Insets(0, 0, 5, 5);
		gbc_lblGodinaProizvodnje.gridx = 1;
		gbc_lblGodinaProizvodnje.gridy = 7;
		frame.getContentPane().add(lblGodinaProizvodnje, gbc_lblGodinaProizvodnje);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.anchor = GridBagConstraints.SOUTHWEST;
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 7;
		frame.getContentPane().add(textField_6, gbc_textField_6);
		
		JLabel lblProizvoa = new JLabel("Proizvo\u0111a\u010D :");
		GridBagConstraints gbc_lblProizvoa = new GridBagConstraints();
		gbc_lblProizvoa.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblProizvoa.insets = new Insets(0, 0, 5, 5);
		gbc_lblProizvoa.gridx = 1;
		gbc_lblProizvoa.gridy = 8;
		frame.getContentPane().add(lblProizvoa, gbc_lblProizvoa);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.anchor = GridBagConstraints.SOUTHWEST;
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 8;
		frame.getContentPane().add(textField_7, gbc_textField_7);
		
		JLabel lblOpis = new JLabel("Opis :");
		GridBagConstraints gbc_lblOpis = new GridBagConstraints();
		gbc_lblOpis.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblOpis.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpis.gridx = 1;
		gbc_lblOpis.gridy = 9;
		frame.getContentPane().add(lblOpis, gbc_lblOpis);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.fill = GridBagConstraints.BOTH;
		gbc_textField_8.insets = new Insets(0, 0, 5, 0);
		gbc_textField_8.gridx = 2;
		gbc_textField_8.gridy = 9;
		frame.getContentPane().add(textField_8, gbc_textField_8);
		
		JButton btnUnesi = new JButton("Unesi");
		GridBagConstraints gbc_btnUnesi = new GridBagConstraints();
		gbc_btnUnesi.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnUnesi.gridx = 2;
		gbc_btnUnesi.gridy = 10;
		frame.getContentPane().add(btnUnesi, gbc_btnUnesi);
	}
}
