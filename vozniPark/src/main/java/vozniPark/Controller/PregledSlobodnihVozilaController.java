package vozniPark.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import vozniPark.Model.Vozilo;
import vozniPark.Util.HibernateUtil;

public class PregledSlobodnihVozilaController {
	
	final static Logger logger = Logger.getLogger(PregledSlobodnihVozilaController.class);
	private List<Vozilo> listaVozila;
	
	public PregledSlobodnihVozilaController(){
		listaVozila = new ArrayList<Vozilo>();
	}
	
	public List<Vozilo> getListaVozila() {
		return listaVozila;
	}
	
	@SuppressWarnings("unchecked")
	public void dajSvaSlobodnaVozila(DefaultTableModel model, JTable table){
		Session session = HibernateUtil.getSessionFactory().openSession();
		listaVozila = session.createCriteria(Vozilo.class).list();
		if(listaVozila.isEmpty()){
			JOptionPane.showMessageDialog(null, "Trenutno nema slobodnih vozila");
			return;
		}
		izbrisiTabelu(model);
		dodajUTabelu(listaVozila, model, table);
    	}

	private void dodajUTabelu(List<Vozilo> lista, DefaultTableModel model, JTable table) {
		// TODO Auto-generated method stub
		for (Vozilo vozilo : lista) {
			if(vozilo.getStatus().equals("Slobodan")) 
			{
				Object[] red = new Object[6];
				red[0] = vozilo.getNaziv();
				red[1] = vozilo.getProizvodjac();
				red[2] = vozilo.getGodinaProizvodnje();
				red[3] = vozilo.getRegistracija();
				red[4] = vozilo.getStatus();
				red[5] = vozilo.getOpis();
				model.addRow(red);
			}
		}
		
		try{
			table.setModel(model);
		}
    
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private boolean praznoPolje(String unos){
		return unos.isEmpty() || unos.replaceAll("\\s","").length() == 0;
	}
	
	@SuppressWarnings("unchecked")
	public List<Vozilo> dajVozilaPoNazivu(String naziv){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Vozilo> lista = session.createCriteria(Vozilo.class).add(Restrictions.like("naziv", naziv + "%")).list();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	private List<Vozilo> dajVozilaPoRegistraciji(String registracija) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Vozilo> lista = session.createCriteria(Vozilo.class).add(Restrictions.like("registracija", registracija + "%")).list();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	private List<Vozilo> dajVozilaPoNazivuIRegistraciji(String naziv, String registracija) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Vozilo> lista = session.createCriteria(Vozilo.class)
							.add(Restrictions.like("registracija", registracija + "%"))
							.add(Restrictions.like("naziv", naziv + "%")).list();
		return lista;
	}
	
	public void pretraziSlobodnaVozila(String naziv, String registracija, DefaultTableModel model, JTable table) {
		
		if(praznoPolje(naziv) && praznoPolje(registracija)){
			JOptionPane.showMessageDialog(null, "Unesite naziv ili registraciju vozila");
			return;
		}
		else{
			//pretraga po nazivu i registraciji
			if(!praznoPolje(naziv) && !praznoPolje(registracija)){
				List<Vozilo> lista = dajVozilaPoNazivuIRegistraciji(naziv, registracija);
				izbrisiTabelu(model);
				dodajUTabelu(lista, model, table);
			}
			//pretraga po nazivu
			else if(!praznoPolje(naziv)){
				List<Vozilo> lista = dajVozilaPoNazivu(naziv);
				izbrisiTabelu(model);
				dodajUTabelu(lista, model, table);
			}
			//pretraga po registraciji
			else{
				List<Vozilo> lista = dajVozilaPoRegistraciji(registracija);
				izbrisiTabelu(model);
				dodajUTabelu(lista, model, table);
			}
		}
		
	}

	private void izbrisiTabelu(DefaultTableModel model) {
		// TODO Auto-generated method stub
		int redovi = model.getRowCount();
		for(int i= redovi - 1; i >= 0; i--){
			model.removeRow(i);
		}
	}
	
}
