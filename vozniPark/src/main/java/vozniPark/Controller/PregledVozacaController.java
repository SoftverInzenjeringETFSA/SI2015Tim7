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
	
	final static Logger logger = Logger.getLogger(UnosNovogVozacaController.class);
	private List<Vozac> listaVozaca;
	
	public PregledVozacaController() {
		listaVozaca=new ArrayList<Vozac>();
	}
	
	public void ucitajVozaceIzBaze(JFrame frame, JTable jt) {
		final Vector<String> v = new Vector<String>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		listaVozaca = session.createCriteria(Vozac.class).list();
		for (int i=0; i<listaVozaca.size(); i++) v.addElement(listaVozaca.get(i).getUsername());
		DefaultTableModel model=new DefaultTableModel();
		jt.setModel(model);
		t.commit();
	}
}
