package vozniPark.Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vozniPark.Model.Vozac;
import vozniPark.Model.Vozilo;
import vozniPark.Util.HibernateUtil;

public class UnosNovogVozacaController {
	final static Logger logger = Logger.getLogger(UnosNovogVozacaController.class);
	private List<Vozac> listaVozaca;
	PregledVozacaController pvc= new PregledVozacaController();
	public UnosNovogVozacaController() {
		listaVozaca=new ArrayList<Vozac>();
	}
	
	public List<Vozac> getListaVozaca() {
		return listaVozaca;
	}
	
	public boolean UnosVozaca(String Ime, String Prezime, String BrojVozacke, String Adresa, String BrojTelefona, String Username, String Sifra)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		if(Ime.length()<2){
			JOptionPane.showMessageDialog(null, "Neispravno uneseno ime");
			return false;
		}
		
		if(Prezime.length()<3){
			JOptionPane.showMessageDialog(null, "Neispravno uneseno prezime");
			return false;
		}
		
		if(BrojVozacke.length()!=9){
			JOptionPane.showMessageDialog(null, "Neispravno unesen broj vozacke");
			return false;
		}

		if(Adresa.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Unesite adresu.");
			return false;
		}
		
		if(BrojTelefona.length()!= 9 && BrojTelefona.length()!=10) {
			JOptionPane.showMessageDialog(null, "Niste pravilno unijeli broj telefona.");
			return false;
		}
		if(Username.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Unesite username.");
			return false;
		}
		else {
			final Vector<String> v = new Vector<String>();
			Session sesija = HibernateUtil.getSessionFactory().openSession();
			
			listaVozaca = sesija.createCriteria(Vozac.class).list();
			for (int i=0; i<listaVozaca.size(); i++) v.addElement(listaVozaca.get(i).getUsername());
			
			for (int i = 0; i < listaVozaca.size(); i++) {
				if(listaVozaca.get(i).getUsername().equals(Username) )
					{
					JOptionPane.showMessageDialog(null, "Username vec postoji");
						return false;
					}
				
			}
			
		}
			
		if(Sifra.length()<2) {
			JOptionPane.showMessageDialog(null, "Sifra mora imati minimalno 4 slova.");
			return false;
		}
		Vozac v=new Vozac();
		v.setIme(Ime);
		v.setPrezime(Prezime);
		v.setBrojVozacke(BrojVozacke);
		v.setAdresa(Adresa);
		v.setBrojTelefona(BrojTelefona);
		v.setUsername(Username);
		v.setPassword(LoginController.getSecurePassword(Sifra));
		session.save(v);
		t.commit();
		return true;
	}

}
