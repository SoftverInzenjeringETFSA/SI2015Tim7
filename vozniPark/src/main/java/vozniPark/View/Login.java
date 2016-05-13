package vozniPark.View;
import java.awt.EventQueue;
import org.apache.log4j.Logger;

import vozniPark.Controller.LoginController;
import vozniPark.Model.Sef;
import vozniPark.Model.Vozac;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
public class Login {
	
	final static Logger logger = Logger.getLogger(Login.class);

	private JFrame frmLogin;
	private JTextField tf_username;
	private JPasswordField passwordField;

	private LoginController controller;
	

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(() -> {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					logger.info(e);
					//e.printStackTrace();
				}
    		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		 controller = new LoginController();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 361, 246);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(55, 55, 100, 14);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(57, 105, 98, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		tf_username = new JTextField();
		tf_username.setBounds(156, 53, 100, 20);
		frmLogin.getContentPane().add(tf_username);
		tf_username.setColumns(10);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener((e) -> {
				if(controller.login(tf_username.getText(), new String(passwordField.getPassword()))) {
					if(controller.dajKorisnika() instanceof Sef) {
                        frmLogin.dispose();
        				SefHomePage sefHome = new SefHomePage();
    	    			sefHome.main(null);
					}
					else if (controller.dajKorisnika() instanceof Vozac) {
                        frmLogin.dispose();
                        VozacHomePage vozacHome = new VozacHomePage();
                        vozacHome.main(null);
					}
					else {

						JOptionPane.showMessageDialog(null,"Doslo je do greske. Molim vas pokusajte opet ili kontaktirajte podrsku");
                        frmLogin.dispose();
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Pogresni pristupni podaci. Molimo pokusajte ponovo.");
				}
		});
		btnPotvrdi.setBounds(156, 150, 100, 23);
		frmLogin.getContentPane().add(btnPotvrdi);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 101, 100, 23);
		frmLogin.getContentPane().add(passwordField);
	}
}
