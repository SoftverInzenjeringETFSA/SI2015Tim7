package vozniPark.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vozniPark.Model.Vozilo;
import vozniPark.Util.HibernateUtil;

public class PregledVozilaController {
	
	final static Logger logger = Logger.getLogger(OdjavaPreuzetogVozilaController.class);
	private List<Vozilo> listaVozila;
	
	public PregledVozilaController() {
		listaVozila = new ArrayList<Vozilo>();
	}
	
	public void ucitajVozilaIzBaze(JFrame frame, JComboBox cb1,JComboBox cb2) {
			
			final Vector<String> v1 = new Vector<String>();
			final Vector<String> v2 = new Vector<String>();
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			
			listaVozila = session.createCriteria(Vozilo.class).list();
			
			for(int i=0; i<listaVozila.size(); i++) 
			{
				 v1.add(listaVozila.get(i).getNaziv());
				 v2.add(listaVozila.get(i).getRegistracija());
			}

			DefaultComboBoxModel model1 = new DefaultComboBoxModel( v1 );
			cb1.setModel( model1 );
			DefaultComboBoxModel model2 = new DefaultComboBoxModel( v2 );
			cb2.setModel( model2 );
			t.commit();
	}
	
	public Vector<Vector<String>> ucitajServiseUTabelu(JFrame frame,JTextField Datum1, JTextField Datum2,JComboBox cb1,JComboBox cb2) {
		Vector<Vector<String>> v= new Vector<Vector<String>>();
			
		return v;
	}
	
	
}
