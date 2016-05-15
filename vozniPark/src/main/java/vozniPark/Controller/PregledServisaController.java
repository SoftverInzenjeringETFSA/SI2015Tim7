package vozniPark.Controller;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vozniPark.Model.Servisi;
import vozniPark.Model.Vozilo;
import vozniPark.Util.HibernateUtil;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PregledServisaController {
	
	final static Logger logger = Logger.getLogger(OdjavaPreuzetogVozilaController.class);
	private List<Vozilo> listaVozila;
	private Vector<Vector<String>> li;
	
	public PregledServisaController() {
		listaVozila = new ArrayList<Vozilo>();
	}
	
	public Vector<Vector<String>> ucitajVoznjeZaVozaca() 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		listaVozila = session.createCriteria(Vozilo.class).list();

		li=new Vector<Vector<String>>();
		
		for(int i=0; i<listaVozila.size(); i++) 
		{
			Vector<String> row = new Vector<String>();
			for(int j=0; j<listaVozila.get(i).getListaServisa().size(); j++) 
			{
				row.addElement(listaVozila.get(i).getNaziv());
				row.addElement(listaVozila.get(i).getRegistracija());
				row.addElement(listaVozila.get(i).getListaServisa().get(j).getServisiranoKod());
				row.addElement(listaVozila.get(i).getListaServisa().get(j).getDatumOdlaska().toString());
				row.addElement(listaVozila.get(i).getListaServisa().get(j).getDatumVracanja().toString());
				row.addElement(listaVozila.get(i).getListaServisa().get(j).getOpis());
				row.addElement(String.valueOf(listaVozila.get(i).getListaServisa().get(j).getCijena()));
			}
			li.add(row);
		}
		t.commit();
		return li;
	}
	
	public Vector<Vector<String>> ucitajSlobodnaVozila() 
	{
		Vector<Vector<String>> lista=new Vector<Vector<String>>();
		for(int i=0; i<listaVozila.size(); i++) 
		{	
			if(listaVozila.get(i).getStatus().equals("Slobodan".toString())){
				Vector<String> row = new Vector<String>();
				for(int j=0; j<listaVozila.get(i).getListaServisa().size(); j++) 
				{
					row.addElement(listaVozila.get(i).getRegistracija());
					row.addElement(listaVozila.get(i).getNaziv());
					row.addElement(listaVozila.get(i).getListaServisa().get(j).getOpis());
				}
				li.add(row);
			}
		}
		
	return lista;
	}
	
	public Vector<Vector<String>> ucitajVozilaNaServisu() 
	{
		Vector<Vector<String>> lista=new Vector<Vector<String>>();
		for(int i=0; i<listaVozila.size(); i++) 
		{	
			if(listaVozila.get(i).getStatus().equals("Servis".toString())){
				Vector<String> row = new Vector<String>();
				for(int j=0; j<listaVozila.get(i).getListaServisa().size(); j++) 
				{
					row.addElement(listaVozila.get(i).getRegistracija());
					row.addElement(listaVozila.get(i).getNaziv());
					row.addElement(listaVozila.get(i).getListaServisa().get(j).getOpis());
				}
				li.add(row);
			}
		}
		
	return lista;
	}
	
	public long dajIDVozila(String registracija)
	{
		for(int i=0; i<listaVozila.size(); i++) 
		{
			if(listaVozila.get(i).getRegistracija().equals(registracija))
			{
				return listaVozila.get(i).getId();
			}
		}
		return -1;
	}
	
	public void dodajNaServis(Date datum,long id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Vozilo v = (Vozilo) session.load(Vozilo.class, id);
		v.setStatus("Servis");
		Servisi s=new Servisi();
		s.setDatumOdlaska(datum);
		s.setDatumVracanja(datum);
		s.setCijena(0);
		s.setOpis("Vozilo je jos uvijek na servisu");
		s.setServisiranoKod("Vozilo je jos uvijek na servisu");
		v.getListaServisa().add(s);
		session.save(v);
		t.commit();
	}
	
	public void dodajDovrsenServis(long id,Date datum,String servisiranoKod,String cijena,String opis)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Vozilo v = (Vozilo) session.load(Vozilo.class, id);
		v.setStatus("Slobodan");
		v.getListaServisa().get(v.getListaServisa().size()-1).setDatumVracanja(datum);
		v.getListaServisa().get(v.getListaServisa().size()-1).setCijena(Double.valueOf(cijena));
		v.getListaServisa().get(v.getListaServisa().size()-1).setServisiranoKod(servisiranoKod);
		v.getListaServisa().get(v.getListaServisa().size()-1).setOpis(opis);;
		session.save(v);
		t.commit();
	}
}
