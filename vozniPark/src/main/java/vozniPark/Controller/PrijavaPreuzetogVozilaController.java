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

import vozniPark.Util.*;
import vozniPark.Model.*;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.apache.log4j.Logger;

public class PrijavaPreuzetogVozilaController {
	
	final static Logger logger = Logger.getLogger(PrijavaPreuzetogVozilaController.class);
	
	private List<Vozilo> listaVozila;
	
	public PrijavaPreuzetogVozilaController() {
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
			if(listaVozila.get(i).getStatus().contentEquals("Slobodan"))
			{
			    
			    v.addElement(listaVozila.get(i).getRegistracija());
			  
			}
		}
		
		DefaultComboBoxModel model = new DefaultComboBoxModel( v );
		cb.setModel( model );
		t.commit();
	}
	
	public void prijaviVoziloZauzetim(String registracija, String datum, String vrijeme) {
		
		for(int i=0; i< listaVozila.size(); i++) 
		{
			if(listaVozila.get(i).getRegistracija().contentEquals(registracija))
			{	
				long id = listaVozila.get(i).getId();
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				Vozilo v = (Vozilo) session.load(Vozilo.class, id);
				v.setStatus("Zauzet");
				session.save(v);
				
				
				Voznje voznje = new Voznje();
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
				voznje.setDatumPreuzimanja(date);
				voznje.setVozilo(v);			
				
				session.save(voznje);
				
				t.commit();
			}
		}
	}
	
	
}
