package vozniPark.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vozniPark.Model.TocenjeGoriva;
import vozniPark.Model.Vozilo;
import vozniPark.Model.Voznje;
import vozniPark.Util.HibernateUtil;

public class PregledVozilaController {
	
	final static Logger logger = Logger.getLogger(OdjavaPreuzetogVozilaController.class);
	private List<Vozilo> listaVozila;
	private List<Voznje> listaVoznji;
	private double ukupnaCijenaServis;
	private double kilometri;
	private double cijena;
	private double litri;
	final Vector<String> v1;
	final Vector<String> v2;
	
	public PregledVozilaController() {
		listaVozila = new ArrayList<Vozilo>();
		listaVoznji = new ArrayList<Voznje>();
		v1 = new Vector<String>();
		v2 = new Vector<String>();
		ukupnaCijenaServis=0;
		kilometri=0;
		cijena=0;
		litri=0;
	}
	
	public int DajVozilo(String st)
	{
		for(int i=0; i<v1.size(); i++)
		{
			if(v1.get(i).equals(st))
			{
				return i;
			}
		}
	return 0;
	}
	public int DajRegistraciju(String st)
	{
		for(int i=0; i<v2.size(); i++)
		{
			if(v2.get(i).equals(st))
			{
				return i;
			}
		}
	return 0;
	}
	
	public void ucitajVozilaIzBaze(JFrame frame, JComboBox cb1,JComboBox cb2) {
			
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
		Date d1;
		Date d2;
		if(Datum1.getText().equals("".toString()))
		{
			d1=new Date(1994-1900, 2, 2);
		}
		else
		{
			try
			{
				d1=new Date(Datum1.getText());
			}
			catch (Exception e) {
				logger.info(e);
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Unesite datum(od) u ispravnom formatu!");
				d1=new Date(1994-1900, 2, 2);
			}
		}
		if(Datum2.getText().equals("".toString()))
		{
			d2=new Date(2090-1900, 2, 2);
		}
		else
		{
			try
			{
				d2=new Date(Datum2.getText());
			}
			catch (Exception e) {
				logger.info(e);
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Unesite datum(do) u ispravnom formatu!");
				d2=new Date(2090-1900, 2, 2);
			}
		}
			
			for(int i=0; i<listaVozila.size(); i++) 
			{
				
				if(listaVozila.get(i).getNaziv().equals(cb1.getSelectedItem().toString()) || 
				  (listaVozila.get(i).getRegistracija().equals(cb2.getSelectedItem().toString()) &&
				   listaVozila.get(i).getNaziv().equals(cb1.getSelectedItem().toString())))
				{
					for(int j=0; j<listaVozila.get(i).getListaServisa().size(); j++) 
					{
						Vector<String> vp=new Vector<String>();
						if((listaVozila.get(i).getListaServisa().get(j).getDatumOdlaska().after(d1) && listaVozila.get(i).getListaServisa().get(j).getDatumOdlaska().before(d2)) ||
						   (listaVozila.get(i).getListaServisa().get(j).getDatumVracanja().after(d1) && listaVozila.get(i).getListaServisa().get(j).getDatumVracanja().before(d2)))
						{
							vp.add(listaVozila.get(i).getListaServisa().get(j).getServisiranoKod());
							vp.add(listaVozila.get(i).getListaServisa().get(j).getDatumOdlaska().toString());
							vp.add(listaVozila.get(i).getListaServisa().get(j).getDatumVracanja().toString());
							vp.add(String.valueOf(listaVozila.get(i).getListaServisa().get(j).getCijena()));
							ukupnaCijenaServis=ukupnaCijenaServis+listaVozila.get(i).getListaServisa().get(j).getCijena();
						}
						v.add(vp);
					}
					break;
				}
					
			}
		return v;
	}
	
	public String dajUkupnuCijenuServisa()
	{
		String u=String.valueOf(ukupnaCijenaServis);
		ukupnaCijenaServis=0;
		return u;
	}
	
	public Vector<Vector<String>> ucitajTocenjaUTabelu(JFrame frame,JTextField Datum1, JTextField Datum2,JComboBox cb1,JComboBox cb2) {
		Vector<Vector<String>> v= new Vector<Vector<String>>();
		Date d1;
		Date d2;
		if(Datum1.getText().equals("".toString()))
		{
			d1=new Date(1994-1900, 2, 2);
		}
		else
		{
			try
			{
				d1=new Date(Datum1.getText());
			}
			catch (Exception e) {
				logger.info(e);
				//e.printStackTrace();
				d1=new Date(1994-1900, 2, 2);
			}
		}
		if(Datum2.getText().equals("".toString()))
		{
			d2=new Date(2090-1900, 2, 2);
		}
		else
		{
			try
			{
				d2=new Date(Datum2.getText());
			}
			catch (Exception e) {
				logger.info(e);
				//e.printStackTrace();
				d2=new Date(2090-1900, 2, 2);
			}
		}

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		listaVoznji = session.createCriteria(Voznje.class).list();
		
		for(int i=0; i<listaVoznji.size(); i++) 
		{
			
			if(listaVoznji.get(i).getVozilo().getNaziv().equals(cb1.getSelectedItem().toString()) || 
			  (listaVoznji.get(i).getVozilo().getRegistracija().equals(cb2.getSelectedItem().toString()) &&
					  listaVoznji.get(i).getVozilo().getNaziv().equals(cb1.getSelectedItem().toString())))
			{				
					Vector<String> vp=new Vector<String>();
					if((listaVoznji.get(i).getDatumPreuzimanja().after(d1) && listaVoznji.get(i).getDatumPreuzimanja().before(d2)) ||
					   (listaVoznji.get(i).getDatumVracanja().after(d1) && listaVoznji.get(i).getDatumVracanja().before(d2)))
					{
						if(listaVoznji.get(i).getTocenje() != null)
						{
							vp.add(String.valueOf(listaVoznji.get(i).getPredjeniKilometri()));
							vp.add(String.valueOf(listaVoznji.get(i).getTocenje().getCijena()));
							vp.add(String.valueOf(listaVoznji.get(i).getTocenje().getKolicina()));
							kilometri=kilometri+listaVoznji.get(i).getPredjeniKilometri();
							cijena = cijena +listaVoznji.get(i).getTocenje().getCijena();
							litri=litri+listaVoznji.get(i).getTocenje().getKolicina();
							v.addElement(vp);
						}
					}
			}		
		}
		t.commit();
		return v;
	}
	
	public Vector<String> dajUkupno()
	{
		Vector<String> v=new Vector<String>();
		v.add(this.dajUkupnuCijenuServisa());
		v.add(String.valueOf(kilometri));
		v.add(String.valueOf(cijena));
		v.add(String.valueOf(litri));
		kilometri=0;
		cijena=0;
		litri=0;
		return v;
	}
	
}
