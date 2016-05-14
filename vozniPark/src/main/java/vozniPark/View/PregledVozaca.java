package vozniPark.View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.apache.log4j.Logger;

import vozniPark.Controller.PregledVozacaController;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class PregledVozaca {
	
	final static Logger logger = Logger.getLogger(PregledVozaca.class);
	
	private PregledVozacaController pvc;

	private JFrame frame;
	private JTable table_1;
	private JLabel lblOdaberiteVozaaZa;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PregledVozaca window = new PregledVozaca();
					window.frame.setVisible(true);
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
	public PregledVozaca() {
		initialize();
		pvc = new PregledVozacaController();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//framePregled = new JFrame();
		frame.setBounds(100, 100, 681, 537);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		String[] header=new String[]{"Ime", "Prezime", "Adresa", "Broj vozacke dozvole", "Username", "Broj telefona"};

		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		table_1.getColumnModel().getColumn(0).setPreferredWidth(85);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(95);
		
		lblOdaberiteVozaaZa = new JLabel("Odaberite voza\u010Da za prikaz podataka:");
		lblOdaberiteVozaaZa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("Prikaži podatke");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PodaciOVozacu podaci=new PodaciOVozacu();
				
			}
		});
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0)
			{
				pvc.ucitajVozaceIzBaze(frame, table_1);
			}
		});
		
		btnNewButton_1 = new JButton("Prikaz aktivnosti");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrikazAktivnostiVozaca prikaz = new PrikazAktivnostiVozaca();
				prikaz.main(null);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(187)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(lblOdaberiteVozaaZa))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(144)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
								.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(lblOdaberiteVozaaZa)
					.addGap(52)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		
		JLabel lblPodaciOVozau = new JLabel("Pregled vozača");
		lblPodaciOVozau.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblPodaciOVozau);
		frame.getContentPane().setLayout(groupLayout);
	}
	
}
