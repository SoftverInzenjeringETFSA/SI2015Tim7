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

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vozniPark.Model.TocenjeGoriva;
import vozniPark.Model.Vozilo;
import vozniPark.Model.Voznje;
import vozniPark.Util.HibernateUtil;

public class OdjavaPreuzetogVozilaController {
	
	final static Logger logger = Logger.getLogger(OdjavaPreuzetogVozilaController.class);
	
	private List<Vozilo> listaVozila;
	
	public OdjavaPreuzetogVozilaController() {
		listaVozila = new ArrayList<Vozilo>();
	}
	
	public List<Vozilo> getListaVozila() {
		return listaVozila;
	}
	
	public void ucitajVozilaIzBaze(JFrame frame, JComboBox cb) {
		
		final Vector<String> v = new Vector<String>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		listaVozila = session.createCriteria(Vozilo.class).list();
		
		for(int i=0; i<listaVozila.size(); i++) 
		{
			if(listaVozila.get(i).getStatus().contentEquals("Zauzet"))
			{
			    
			    v.addElement(listaVozila.get(i).getRegistracija());
			  
			}
		}

		DefaultComboBoxModel model = new DefaultComboBoxModel( v );
		cb.setModel( model );
		t.commit();
	}
	
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
				
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'u' HH:mm:ss");
				String datumVrijeme = datum + vrijeme;
				Date date = new Date();
				try {
					date = formatter.parse(datumVrijeme);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					logger.info(e);
				}
				Voznje voznje = (Voznje) session.load(Voznje.class, idVozila);
				voznje.setDatumVracanja(date);
				voznje.setPredjeniKilometri(kilometri);
				voznje.setOpisUpotrebe(opis);
				TocenjeGoriva tg = new TocenjeGoriva();
				tg.setKolicina(potrosnja);
				tg.setCijena(cijena);
				session.save(tg);
				voznje.setTocenje(tg);
				session.save(voznje);
				
				t.commit();
			}
		}
}
}
