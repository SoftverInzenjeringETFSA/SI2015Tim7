package vozniPark.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import antlr.DefaultJavaCodeGeneratorPrintWriterManager;
import vozniPark.Model.Vozac;
import vozniPark.Model.Vozilo;
import vozniPark.Model.VozniPark;
import vozniPark.Model.Voznje;
import vozniPark.Util.HibernateUtil;

public class UnosNovogVozacaController {
	final static Logger logger = Logger.getLogger(UnosNovogVozacaController.class);
	private List<Vozac> listaVozaca;
	
	public UnosNovogVozacaController() {
		listaVozaca=new ArrayList<Vozac>();
	}
	
	
	public Vozac UnosVozaca(String Ime, String Prezime, String BrojVozacke, String Adresa, String BrojTelefona, String Username, String Sifra)
	{
		if(Ime.length()<2){
			JOptionPane.showMessageDialog(null, "Neispravno uneseno ime");
		}
		
		if(Prezime.length()<3){
			JOptionPane.showMessageDialog(null, "Neispravno uneseno prezime");
		}
		
		if(BrojVozacke.length()!=9){
			JOptionPane.showMessageDialog(null, "Neispravno unesen broj vozacke");
		}

		if(Adresa.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Unesite adresu.");
			return null;
		}
		
		if(BrojTelefona.length()!= 9 && BrojTelefona.length()!=10) {
			JOptionPane.showMessageDialog(null, "Niste pravilno unijeli broj telefona.");
			return null;
		}
		if(Username.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Unesite username.");
			return null;
		}
		if(Sifra.length()<4) {
			JOptionPane.showMessageDialog(null, "Sifra mora imati minimalno 4 slova.");
			return null;
		}
		Vozac v=new Vozac();
		v.setIme(Ime);
		v.setPrezime(Prezime);
		v.setBrojVozacke(BrojVozacke);
		v.setAdresa(Adresa);
		v.setBrojTelefona(BrojTelefona);
		v.setUsername(Username);
		v.setPassword(Sifra);
		return v;
	
	}

}
