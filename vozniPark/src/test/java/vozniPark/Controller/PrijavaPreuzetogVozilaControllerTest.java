package vozniPark.Controller;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import junit.framework.TestCase;


public class PrijavaPreuzetogVozilaControllerTest extends TestCase {

	public void testPrijavaPreuzetogVozilaController() {
		
		PrijavaPreuzetogVozilaController ppvc = new PrijavaPreuzetogVozilaController();
		assertEquals(0,ppvc.getListaVozila().size());
	}

	public void testUcitajVozilaIzBaze() {
		PrijavaPreuzetogVozilaController ppvc = new PrijavaPreuzetogVozilaController();
		JFrame frame = new JFrame();
		JComboBox comboBox = new JComboBox();
		
		ppvc.ucitajVozilaIzBaze(frame, comboBox);
		assertEquals(3,ppvc.getListaVozila().size());
	}

	public void testPrijaviVoziloZauzetim() {
		PrijavaPreuzetogVozilaController ppvc = new PrijavaPreuzetogVozilaController();
		JFrame frame = new JFrame();
		JComboBox comboBox = new JComboBox();
		
		ppvc.ucitajVozilaIzBaze(frame, comboBox);
		
		
		String registracija = "100-A-100";
		String datum = "12-5-2016";
		String vrijeme = "14:01:25";
		
		ppvc.prijaviVoziloZauzetim(registracija, datum, vrijeme);
		ppvc.ucitajVozilaIzBaze(frame, comboBox);
		assertEquals("Zauzet",ppvc.getListaVozila().get(0).getStatus());
	}

}
