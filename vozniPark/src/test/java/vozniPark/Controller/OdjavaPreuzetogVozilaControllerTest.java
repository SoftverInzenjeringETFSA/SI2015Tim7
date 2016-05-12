package vozniPark.Controller;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import junit.framework.TestCase;

public class OdjavaPreuzetogVozilaControllerTest extends TestCase {

	public void testOdjavaPreuzetogVozilaController() {
		OdjavaPreuzetogVozilaController opvc = new OdjavaPreuzetogVozilaController();
		assertEquals(0,opvc.getListaVozila().size());
	}

	public void testUcitajVozilaIzBaze() {
		OdjavaPreuzetogVozilaController opvc = new OdjavaPreuzetogVozilaController();
		JFrame frame = new JFrame();
		JComboBox comboBox = new JComboBox();
		
		opvc.ucitajVozilaIzBaze(frame, comboBox);
		assertEquals(3,opvc.getListaVozila().size());
	}

	public void testOdjaviVozilo() {
		String registracija = "100-A-100";
		String datum = "12-5-2016";
		String vrijeme = "14:20:00";
		Long kilometri = 5000L; 
		String opis = "testiramo junit testove";
		long potrosnja = 100;
		
		JFrame frame = new JFrame();
		JComboBox comboBox = new JComboBox();
		
		OdjavaPreuzetogVozilaController opvc = new OdjavaPreuzetogVozilaController();
		opvc.ucitajVozilaIzBaze(frame, comboBox);
		opvc.odjaviVozilo(registracija, datum, vrijeme, kilometri, opis, potrosnja);
		
		opvc.ucitajVozilaIzBaze(frame, comboBox);
		assertEquals("Slobodan",opvc.getListaVozila().get(0).getStatus());
	}

}
