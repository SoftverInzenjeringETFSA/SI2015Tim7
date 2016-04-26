package vozniPark.forme;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PrikazPodatakaOVozacima {

	private JFrame frame;
	private JTable table_1;
	private JLabel lblOdaberiteVozaaZa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikazPodatakaOVozacima window = new PrikazPodatakaOVozacima();
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
	public PrikazPodatakaOVozacima() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 681, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		String[] header=new String[]{"Ime", "Prezime", "Adresa", "Broj vozacke dozvole", "Username", "Broj telefona"};

		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Armin", "Nogo"},
				{"Mirnes", "Peljto"},
				{"Aida", "Kanlic"},
				{"Minela", "Mustafi"},
				{"Ajdin", "Mujezinovic"},
				{"Dino", "Mehmedovic"},
				{"Irma", "Karasoftic"},
			},
			new String[] {
				"Ime", "Prezime"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(85);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(95);
		
		lblOdaberiteVozaaZa = new JLabel("Odaberite voza\u010Da za prikaz podataka:");
		lblOdaberiteVozaaZa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(144)
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(187)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(lblOdaberiteVozaaZa)))
					.addContainerGap(142, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(lblOdaberiteVozaaZa)
					.addGap(52)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		
		JLabel lblPodaciOVozau = new JLabel("Podaci o voza\u010Dima");
		lblPodaciOVozau.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblPodaciOVozau);
		frame.getContentPane().setLayout(groupLayout);



	}
}
