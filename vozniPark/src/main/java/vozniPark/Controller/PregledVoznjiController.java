package vozniPark.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vozniPark.Model.TocenjeGoriva;
import vozniPark.Model.Vozac;
import vozniPark.Model.Vozilo;
import vozniPark.Model.Voznje;
import vozniPark.Util.HibernateUtil;

public class PregledVoznjiController {
	final static Logger logger = Logger.getLogger(PregledVoznjiController.class);
	private List<Voznje> listaVoznji;
	private double kolicina;
	private double cijena;
	private double kilometri;
	public PregledVoznjiController()
	{
		listaVoznji=new ArrayList<Voznje>();
		kolicina=0;
		cijena=0;
		kilometri=0;
	}
	
	public Vector<Vector<String>> ucitajVoznjeZaVozaca(JFrame frame,JTextField ime,JTextField prezime) 
	{
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		listaVoznji = session.createCriteria(Voznje.class).list();

		for(int i=0; i<listaVoznji.size(); i++) 
		{
			Vector<String> vp = new Vector<String>();
			if(listaVoznji.get(i).getVozac().getIme().contentEquals(ime.getText()) && 
					listaVoznji.get(i).getVozac().getPrezime().contentEquals(prezime.getText()) && listaVoznji.get(i).getDatumVracanja() != null)
			{
				vp.add(listaVoznji.get(i).getVozilo().getNaziv());
				vp.add(listaVoznji.get(i).getVozilo().getRegistracija());
				vp.add(listaVoznji.get(i).getDatumPreuzimanja().toString());
				vp.add(listaVoznji.get(i).getDatumVracanja().toString());
				vp.add(String.valueOf(listaVoznji.get(i).getPredjeniKilometri()));
				vp.add(String.valueOf(listaVoznji.get(i).getTocenje().getCijena()));
				vp.add(String.valueOf(listaVoznji.get(i).getTocenje().getKolicina()));				
				vp.add(listaVoznji.get(i).getOpisUpotrebe());
			
				kolicina=kolicina+listaVoznji.get(i).getTocenje().getKolicina();
				cijena=cijena+ listaVoznji.get(i).getTocenje().getCijena();
				kilometri=kilometri+listaVoznji.get(i).getPredjeniKilometri();
				
				v.add(vp);
			}
		}

	    return v;
	}
	
	public Vector<Vector<String>> dajUkupno()
	{
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		Vector<String> vu = new Vector<String>();
		vu.addElement(String.valueOf(kilometri));
		vu.addElement(String.valueOf(cijena));
		vu.addElement(String.valueOf(kolicina));
		v.add(vu);
		kolicina=0;
		cijena=0;
		kilometri=0;
		return v;
	}
}
