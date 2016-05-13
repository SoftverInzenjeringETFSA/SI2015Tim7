package vozniPark.View.izvjestaji;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import org.apache.log4j.Logger;

import vozniPark.Controller.PregledServisaController;
import vozniPark.Controller.PregledVozilaController;
import vozniPark.View.Login;

public class IzvjestajOOdabranomVozilu {

	final static Logger logger = Logger.getLogger(IzvjestajOOdabranomVozilu.class);
	private PregledVozilaController pvc;
	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable table_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajOOdabranomVozilu window = new IzvjestajOOdabranomVozilu();
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 780, 421);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIzvjetajOOdabranom = new JLabel("Izvje\u0161taj o odabranom vozilu");
		lblIzvjetajOOdabranom.setBounds(10, 11, 229, 14);
		frame.getContentPane().add(lblIzvjetajOOdabranom);
		
		JLabel lblVozilo = new JLabel("Vozilo:");
		lblVozilo.setBounds(54, 39, 45, 14);
		frame.getContentPane().add(lblVozilo);
		
		JLabel lblBrojRegistracije = new JLabel("Registracija:");
		lblBrojRegistracije.setBounds(20, 66, 89, 14);
		frame.getContentPane().add(lblBrojRegistracije);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 95, 173, 20);
		frame.getContentPane().add(textField_2);
		
		textField_2.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        textField_2.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		       
		    }
		});
		
		JLabel lblZaPeriodOd = new JLabel("Za period od:");
		lblZaPeriodOd.setBounds(20, 98, 82, 14);
		frame.getContentPane().add(lblZaPeriodOd);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(307, 95, 173, 20);
		frame.getContentPane().add(textField_3);
		
		textField_3.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        textField_3.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		       
		    }
		});
		
		
		JLabel lblDo = new JLabel("do :");
		lblDo.setBounds(283, 98, 27, 14);
		frame.getContentPane().add(lblDo);
		
		JButton btnNewButton = new JButton("Prika\u017Ei");
		btnNewButton.setBounds(490, 94, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 744, 210);
		frame.getContentPane().add(scrollPane);

		String[] columnNames = {"Servisirano kod:", "Datum i vrijeme odvoženja vozila na servis:","Datum i vrijeme vraćanja vozila:","Cijena servisiranja(KM):","Pređeni kilometri:","Dosipanje goriva(KM):","Dosipanje goriva(l):"};
        Object[][] data ={};
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(333, 335, 421, 38);
		frame.getContentPane().add(scrollPane_1);
		String[] columnNames1 = {"Ukupno(KM):","Ukupno(km):","Ukupno(KM):","Ukupno(l):"};
        Object[][] data1 ={};
		table_1 = new JTable(data1,columnNames1);
		scrollPane_1.setViewportView(table_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(100, 36, 173, 20);
		frame.getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(100, 63, 173, 20);
		frame.getContentPane().add(comboBox_1);
		
		
	}
	public IzvjestajOOdabranomVozilu() {
		initialize();
		pvc= new PregledVozilaController();
		pvc.ucitajVozilaIzBaze(frame, comboBox, comboBox_1);
	}
}
