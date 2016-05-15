package vozniPark.Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import junit.framework.TestCase;
import vozniPark.Model.Vozilo;

public class PregledSlobodnihVozilaControllerTest extends TestCase {
	
	private PregledSlobodnihVozilaController ctrl;
	private DefaultTableModel model;
	private JTable table;
	private List<Vozilo> lista;
	
	public PregledSlobodnihVozilaControllerTest(){
		ctrl = new PregledSlobodnihVozilaController();
		model = new DefaultTableModel();
		table = new JTable();
	}
	
	public void testCase1(){
		
		ctrl.dajSvaSlobodnaVozila(model, table);
		lista = ctrl.getListaVozila();
		boolean test = true;
		if(!lista.isEmpty()){
			for(Vozilo v : lista){
				if(!v.getStatus().equals("Slobodan"))
					test = false;
			}
		}
		
		assertTrue(test);
	}
	
	public void testCase2(){
		
		lista = ctrl.getListaVozila();
		ctrl.dodajUTabelu(lista, model, table);
		assertEquals(lista.size(), table.getRowCount());
		
	}
	
	public void testCase3(){
			
		lista = ctrl.dajVozilaPoNazivu("a");
		boolean test = true;
		if(!lista.isEmpty()){
			for(Vozilo v : lista){
				if(!v.getNaziv().contains("a"));
					test = false;
			}
		}
		
		assertTrue(test);
	}
	
	public void testCase4(){
		boolean test = ctrl.pretraziSlobodnaVozila("", "", model, table);
		assertFalse(test);
	}
	
	public void testCase5(){
		boolean test = ctrl.pretraziSlobodnaVozila("audi", "", model, table);
		assertTrue(test);
	}
	
	public void testCase6(){
		boolean test = ctrl.pretraziSlobodnaVozila("", "A21-J-123", model, table);
		assertTrue(test);
	}
	
	public void testCase7(){
		ctrl.izbrisiTabelu(model);
		assertEquals(table.getRowCount(),0);
	}
}
