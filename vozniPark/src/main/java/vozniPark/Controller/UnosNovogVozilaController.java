package vozniPark.Controller;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vozniPark.Model.Vozac;
import vozniPark.Model.Vozilo;
import vozniPark.Util.HibernateUtil;

public class UnosNovogVozilaController {
	
	final static Logger logger = Logger.getLogger(UnosNovogVozilaController.class);
	private List<Vozilo> listaVozila;
	private int godinaP;
	private int trenutnaGodina;
	public UnosNovogVozilaController() {
		listaVozila =new ArrayList<Vozilo>();
	}
	
	public List<Vozilo> getListaVozila() {
		return listaVozila;
	}
	
	private boolean praznoPolje(String unos){
		return unos.isEmpty() || unos.replaceAll("\\s","").length() == 0;
	}
	
	public boolean unesiVozilo(String saobracajnaDozvola, String vlasnickaDozvola, String registracija, String intervalMjeseci, String intervalKilometara,
							String nazivVozila, String godinaProizvodnje, String proizvodjac, String opis, JFrame frame){
		
		if(this.praznoPolje(saobracajnaDozvola)){
			JOptionPane.showMessageDialog(null, "Unesite broj saobraćajne dozvole");
			return false;
		}
		if(!saobracajnaDozvola.matches("^[A-Z]{2}[0-9]{7}$")){
			JOptionPane.showMessageDialog(null, "Broj saobraćajne dozvole nije u pravilnom formatu (dva slova + sedam cifri)");
			return false;
		}
		else {
			final Vector<String> v = new Vector<String>();
			Session sesija = HibernateUtil.getSessionFactory().openSession();

			listaVozila = sesija.createCriteria(Vozac.class).list();
			for (int i = 0; i < listaVozila.size(); i++)
				v.addElement(listaVozila.get(i).getBrojSaobracajneDozvole());

			for (int i = 0; i < listaVozila.size(); i++) {
				if (listaVozila.get(i).getBrojSaobracajneDozvole().equals(saobracajnaDozvola)) {
					JOptionPane.showMessageDialog(null, "Vozilo sa unijetom saobracajnom dozvolom vec postoji");
					return false;
				}
			}
		}
		
		if(this.praznoPolje(vlasnickaDozvola)){
			JOptionPane.showMessageDialog(null, "Unesite broj vlasničke dozvole");
			return false;
		}
		if(!vlasnickaDozvola.matches("^[A-Z]{2}[0-9]{7}$")){
			JOptionPane.showMessageDialog(null, "Broj vlasničke dozvole nije u pravilnom formatu (dva slova + sedam cifri)");
			return false;
		}
		else {
			final Vector<String> v = new Vector<String>();
			Session sesija = HibernateUtil.getSessionFactory().openSession();

			listaVozila = sesija.createCriteria(Vozac.class).list();
			for (int i = 0; i < listaVozila.size(); i++)
				v.addElement(listaVozila.get(i).getBrojVlasnickeDozvole());

			for (int i = 0; i < listaVozila.size(); i++) {
				if (listaVozila.get(i).getBrojVlasnickeDozvole().equals(vlasnickaDozvola)) {
					JOptionPane.showMessageDialog(null, "Vozilo sa unijetom vlasničkom dozvolom vec postoji");
					return false;
				}
			}
		}
		
		if(this.praznoPolje(registracija)){
			JOptionPane.showMessageDialog(null, "Unesite registraciju vozila");
			return false;
		}
		//registracija slovo + dvije cifre + znak “-” + slovo + znak “-” + tri cifre (npr. G67-J-765)
		if(!registracija.matches("^[A-Za-z][0-9]{2}-[A-Za-z]-[0-9]{3}$")){
			JOptionPane.showMessageDialog(null, "Registracija vozila nije u pravilnom formatu");
			return false;
		}
		else{
			Session session = HibernateUtil.getSessionFactory().openSession();
			listaVozila = session.createCriteria(Vozilo.class).list();
			for (Vozilo vozilo: listaVozila) {
				if(vozilo.getRegistracija().equals(registracija)) 
				{
					JOptionPane.showMessageDialog(null, "Registracija već postoji");
					return false;
				}
			}
		}

		if(this.praznoPolje(intervalMjeseci)){
			JOptionPane.showMessageDialog(null, "Unesite interval servisa (mjeseci)");
			return false;
		}
		if(!intervalMjeseci.matches("^[0-9]+$")){
			JOptionPane.showMessageDialog(null, "Nepravilan unos za interval servisa (mjeseci)");
			return false;
		}
		if(this.praznoPolje(intervalKilometara)){
			JOptionPane.showMessageDialog(null, "Unesite interval servisa (kilometri)");
			return false;
		}
		if(!intervalKilometara.matches("^[0-9]+$")){
			JOptionPane.showMessageDialog(null, "Nepravilan unos za interval servisa (kilometri)");
			return false;
		}
		if(this.praznoPolje(nazivVozila)){
			JOptionPane.showMessageDialog(null, "Unesite naziv vozila");
			return false;
		}
		else {
			if(!nazivVozila.matches("^[a-zA-Z0-9_ ]*$")) 
			{
				JOptionPane.showMessageDialog(null, "Naziv vozila može sadržavati samo slova i brojeve");
				return false;
			}
		}
		
		if(this.praznoPolje(godinaProizvodnje)){
			JOptionPane.showMessageDialog(null, "Unesite godinu proizvodnje");
			return false;
		}
		if(!godinaProizvodnje.matches("^(19|20)[0-9]{2}$")){
			JOptionPane.showMessageDialog(null, "Nepravilan unos za godinu proizvodnje");
			return false;
		}
		else{
			godinaP = Integer.parseInt(godinaProizvodnje);
			Date date = new Date();
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(date);
		    trenutnaGodina = cal.get(Calendar.YEAR);	    
		}
		if(godinaP > trenutnaGodina){
			JOptionPane.showMessageDialog(null, "Godina proizvodnje mora biti manja ili jednaka trenutnoj");
			return false;
		}
		if(this.praznoPolje(proizvodjac)){
			JOptionPane.showMessageDialog(null, "Unesite proizvođača vozila");
			return false;
		}
		else {
			if(!proizvodjac.matches("^[a-zA-Z0-9_ ]*$")) 
			{
				JOptionPane.showMessageDialog(null, "Naziv proizvođača može sadržavati samo slova i brojeve");
				return false;
			}
		}
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Vozilo vozilo = new Vozilo();
		vozilo.setBrojSaobracajneDozvole(saobracajnaDozvola);
		vozilo.setBrojVlasnickeDozvole(vlasnickaDozvola);
		vozilo.setRegistracija(registracija);
		vozilo.setIntervalServisaMjeseci(Integer.parseInt(intervalMjeseci));
		vozilo.setIntervalServisaKilometri(Integer.parseInt(intervalKilometara));
		vozilo.setNaziv(nazivVozila);
		vozilo.setGodinaProizvodnje(godinaP);
		vozilo.setProizvodjac(proizvodjac);
		vozilo.setStatus("Slobodan");
		vozilo.setOpis(opis);
		session.save(vozilo);
		transaction.commit();
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		return true;
	}
}
