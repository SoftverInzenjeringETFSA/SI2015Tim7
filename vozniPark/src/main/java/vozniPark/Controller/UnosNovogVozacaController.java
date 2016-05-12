package vozniPark.Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vozniPark.Model.Vozac;
import vozniPark.Util.HibernateUtil;

public class UnosNovogVozacaController {
	final static Logger logger = Logger.getLogger(UnosNovogVozacaController.class);
	private List<Vozac> listaVozaca;
	
	public UnosNovogVozacaController() {
		listaVozaca=new ArrayList<Vozac>();
	}
	
	
	public void UnosVozaca(String Ime, String Prezime, String BrojVozacke, String Adresa, String BrojTelefona, String Username, String Sifra)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		if(Ime.length()<2){
			JOptionPane.showMessageDialog(null, "Neispravno uneseno ime");
			return;
		}
		
		if(Prezime.length()<3){
			JOptionPane.showMessageDialog(null, "Neispravno uneseno prezime");
			return;
		}
		
		if(BrojVozacke.length()!=9){
			JOptionPane.showMessageDialog(null, "Neispravno unesen broj vozacke");
			return;
		}

		if(Adresa.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Unesite adresu.");
			return;
		}
		
		if(BrojTelefona.length()!= 9 && BrojTelefona.length()!=10) {
			JOptionPane.showMessageDialog(null, "Niste pravilno unijeli broj telefona.");
			return;
		}
		if(Username.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Unesite username.");
			return;
		}
		if(Sifra.length()<4) {
			JOptionPane.showMessageDialog(null, "Sifra mora imati minimalno 4 slova.");
			return;
		}
		Vozac v=new Vozac();
		v.setIme(Ime);
		v.setPrezime(Prezime);
		v.setBrojVozacke(BrojVozacke);
		v.setAdresa(Adresa);
		v.setBrojTelefona(BrojTelefona);
		v.setUsername(Username);
		v.setPassword(Sifra);
		session.save(v);
		t.commit();
	}

}