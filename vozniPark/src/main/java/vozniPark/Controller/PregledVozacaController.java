package vozniPark.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vozniPark.Model.Vozac;
import vozniPark.Util.HibernateUtil;

public class PregledVozacaController {
	
	final static Logger logger = Logger.getLogger(PregledVozacaController.class);
	private List<Vozac> listaVozaca;
	
	public PregledVozacaController() {
		listaVozaca=new ArrayList<Vozac>();
	}

	public List<Vozac> getListaVozaca() {
		return listaVozaca;
	}
	
	public Vector<Vector<String>> ucitajVozaceIzBaze() {

		Vector<Vector<String>> v = new Vector<Vector<String>>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		listaVozaca = session.createCriteria(Vozac.class).list();
		
		for (int i=0; i<listaVozaca.size(); i++)
		{
			Vector<String> vp = new Vector<String>();
			vp.addElement(listaVozaca.get(i).getIme());
			vp.addElement(listaVozaca.get(i).getPrezime());
			v.add(vp);
		}

		t.commit();
		return v;
	}
	
	public Vozac dajVozaca(String ime,String prezime)
	{
		for (int i=0; i<listaVozaca.size(); i++)
		{
			if(listaVozaca.get(i).getIme().equals(ime) && listaVozaca.get(i).getPrezime().equals(prezime))
			{
				return listaVozaca.get(i);
			}
		}
		return new Vozac();
	}
}
