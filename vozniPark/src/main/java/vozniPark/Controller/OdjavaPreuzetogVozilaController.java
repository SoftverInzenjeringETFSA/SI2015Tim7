package vozniPark.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vozniPark.Model.Osoba;
import vozniPark.Model.TocenjeGoriva;
import vozniPark.Model.Vozilo;
import vozniPark.Model.Voznje;
import vozniPark.Util.HibernateUtil;

public class OdjavaPreuzetogVozilaController {
	
	final static Logger logger = Logger.getLogger(OdjavaPreuzetogVozilaController.class);
	
	private List<Vozilo> listaVozila;
	public Osoba vozac;
	
	private String imeVozaca;
	private long idVozaca;
	
	public String getIme() {
		return imeVozaca;
	}
	
	public long getId() {
		return idVozaca;
	}
	
	public void setIme(String ime) {
		this.imeVozaca = ime;
	}
	
	public void setId(long id) {
		this.idVozaca = id;
	}
	
	public OdjavaPreuzetogVozilaController() {
		listaVozila = new ArrayList<Vozilo>();
	}
	
	public OdjavaPreuzetogVozilaController(String ime, long id) {
		listaVozila = new ArrayList<Vozilo>();
		setIme(ime);
		setId(id);
	}
	
	public List<Vozilo> getListaVozila() {
		return listaVozila;
	}
	
	public void ucitajVozilaIzBaze(JFrame frame, JComboBox cb) {
		
		final Vector<String> v = new Vector<String>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		List<Voznje> listaVoznji = new ArrayList<Voznje>();
		listaVoznji = session.createCriteria(Voznje.class).list();
		List<Voznje> voznje = new ArrayList<Voznje>();
		for(int j=0; j<listaVoznji.size(); j++) 
		{
			if(listaVoznji.get(j).getDatumVracanja()==null)
			{
			    
			   voznje.add(listaVoznji.get(j));
			}
		}
		listaVozila = session.createCriteria(Vozilo.class).list();
		
		for(int i=0; i<listaVozila.size(); i++) 
		{
			for(int j=0; j<voznje.size(); j++) 
			{
				if(voznje.get(j).getVozilo().getId() == listaVozila.get(i).getId() && voznje.get(j).getVozac().getId() == idVozaca)
				{
					if(listaVozila.get(i).getStatus().contentEquals("Zauzet"))
					{
			    
						v.addElement(listaVozila.get(i).getRegistracija());
			  
					}
				}
			}
		}

		DefaultComboBoxModel model = new DefaultComboBoxModel( v );
		cb.setModel( model );
		t.commit();
	}
	
@SuppressWarnings("deprecation")
public void odjaviVozilo(String registracija, String datum, String vrijeme, Long kilometri, String opis, double potrosnja,double cijena) {
		
		for(int i=0; i< listaVozila.size(); i++) 
		{
			if(listaVozila.get(i).getRegistracija().contentEquals(registracija))
			{	
				long idVozila = listaVozila.get(i).getId();
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				Vozilo v = (Vozilo) session.load(Vozilo.class, idVozila);
				v.setStatus("Slobodan");
				session.save(v);
				
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
				String datumVrijeme = datum + " " + vrijeme;
				Date date = new Date();
				try {
					date = formatter.parse(datumVrijeme);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					logger.info(e);
				}
				date.setHours(date.getHours() + 2);
				
				List<Voznje> listaVoznji = new ArrayList<Voznje>();
				listaVoznji = session.createCriteria(Voznje.class).list();
				Voznje voznje = new Voznje();
				for(int j=0; j<listaVoznji.size(); j++) 
				{
					if(listaVoznji.get(j).getVozilo().getId() == idVozila && listaVoznji.get(j).getDatumVracanja()==null)
					{
					    
					   voznje = listaVoznji.get(j);
					  
					}
				}
				
				//Voznje voznje = (Voznje) session.load(Voznje.class, idVozila);
				voznje.setDatumVracanja(date);
				voznje.setPredjeniKilometri(kilometri);
				voznje.setOpisUpotrebe(opis);
				TocenjeGoriva tg = new TocenjeGoriva();
				tg.setKolicina(potrosnja);
				tg.setCijena(cijena);
				session.save(tg);
				v.getListaTocenja().add(tg);
				session.save(v);
				voznje.setTocenje(tg);
				session.save(voznje);
				
				t.commit();
				JOptionPane.showMessageDialog(null, "Automobil je uspješno odjavljen");
			}
		}
}
}
