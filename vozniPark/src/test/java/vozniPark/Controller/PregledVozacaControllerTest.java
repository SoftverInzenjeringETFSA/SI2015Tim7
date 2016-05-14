package vozniPark.Controller;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;

import junit.framework.TestCase;

public class PregledVozacaControllerTest extends TestCase{
	public void testPregledVozacaController() {
		PregledVozacaController pvc= new PregledVozacaController();
		assertEquals(0, pvc.getListaVozaca().size());
	}
	
	public void testUcitajVozaceIzBaze() 
	{	
		PregledVozacaController pvc=new PregledVozacaController();
		JFrame frame = new JFrame();
		JTable jt= new JTable();
		pvc.ucitajVozaceIzBaze(frame, jt);
		assertEquals(2, pvc.getListaVozaca().size());
	}

}
