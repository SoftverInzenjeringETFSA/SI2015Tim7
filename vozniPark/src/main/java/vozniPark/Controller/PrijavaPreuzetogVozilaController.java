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

public class PrijavaPreuzetogVozilaController {
	
	private List<Vozilo> listaVozila;
	
	public PrijavaPreuzetogVozilaController() {
		listaVozila = new ArrayList<Vozilo>();
	}
	
	public void ucitajVozilaIzBaze(JFrame frame, JComboBox cb) {
		
		final Vector<String> v = new Vector<String>();
		//JComboBox<String> comboBox = new JComboBox<String>(v);
		
		//comboBox.setBounds(177, 28, 161, 20);
		
		
		//frame.getContentPane().add(comboBox);
		//frame.setVisible(true);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		listaVozila = session.createCriteria(Vozilo.class).list();
		//Vector comboBoxItems=new Vector();
		for(int i=0; i<listaVozila.size(); i++) 
		{
			if(listaVozila.get(i).getStatus().contentEquals("Slobodan"))
			{
			    
			    v.addElement(listaVozila.get(i).getRegistracija());
			  
			}
		}
		//comboBox.setSelectedIndex(0);
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
				Long id2 = (Long) session.save(v);
				
				
				Voznje voznje = new Voznje();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'u' HH:mm:ss");
				String datumVrijeme = datum + vrijeme;
				Date date = new Date();
				try {
					date = formatter.parse(datumVrijeme);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				voznje.setDatumPreuzimanja(date);
				voznje.setVozilo(v);			
				
				session.save(voznje);
				
				t.commit();
			}
		}
	}
	
	
}