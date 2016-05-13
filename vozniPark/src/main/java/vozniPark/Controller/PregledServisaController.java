package vozniPark.Controller;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vozniPark.Model.Vozilo;
import vozniPark.Util.HibernateUtil;

import java.sql.Date;
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
	
}
