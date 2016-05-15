package vozniPark.Controller;

import javax.swing.JFrame;

import junit.framework.TestCase;

public class UnosNovogVozilaControllerTest extends TestCase {
	
	private UnosNovogVozilaController ctrl;
	
	public UnosNovogVozilaControllerTest(){
		ctrl = new UnosNovogVozilaController();
	}
	
	//test pada ako je u bazi vozilo s istom registracijom
	public void testUnosNovogVozilaControllerTest(){
		String saobracajnaDozvola = "AA1111111";
		String vlasnickaDozvola = "BG8374859";
		String registracija = "A23-J-000";
		String intervalMjeseci = "12";
		String intervalKilometara = "10000";
		String nazivVozila = "Octavia";
		String godinaProizvodnje = "2005";
		String proizvodjac = "Skoda";
		String opis = "neki opis";
		JFrame frame = new JFrame();
		boolean test = ctrl.unesiVozilo(saobracajnaDozvola, vlasnickaDozvola, registracija, intervalMjeseci, intervalKilometara, nazivVozila, godinaProizvodnje, proizvodjac, opis, frame);
		assertTrue(test);
	}
	
	public void testUnosNovogVozilaControllerTest2(){
		String saobracajnaDozvola = "BH7594738";
		String vlasnickaDozvola = "EE6546738";
		String registracija = "A23-J-123";
		String intervalMjeseci = "12";
		String intervalKilometara = "10000";
		String nazivVozila = "Fiesta";
		//godina > trenutne
		String godinaProizvodnje = "2017";
		String proizvodjac = "Ford";
		String opis = "neki opis";
		JFrame frame = new JFrame();
		boolean test = ctrl.unesiVozilo(saobracajnaDozvola, vlasnickaDozvola, registracija, intervalMjeseci, intervalKilometara, nazivVozila, godinaProizvodnje, proizvodjac, opis, frame);
		assertFalse(test);
	}
	
	public void testUnosNovogVozilaControllerTest3(){
		String saobracajnaDozvola = "AA1111111";
		String vlasnickaDozvola = "BB2222222";
		//ista reg
		String registracija = "A23-J-000";
		String intervalMjeseci = "12";
		String intervalKilometara = "10000";
		String nazivVozila = "BMW";
		String godinaProizvodnje = "2005";
		String proizvodjac = "WV";
		JFrame frame = new JFrame();
		boolean test = ctrl.unesiVozilo(saobracajnaDozvola, vlasnickaDozvola, registracija, intervalMjeseci, intervalKilometara, nazivVozila, godinaProizvodnje, proizvodjac, "", frame);
		assertFalse(test);
	}
	
	public void testUnosNovogVozilaControllerTest4(){
		//nepravilan format
		String saobracajnaDozvola = "12345";
		String vlasnickaDozvola = "AB1234567";
		String registracija = "A23-J-666";
		String intervalMjeseci = "12";
		String intervalKilometara = "10000";
		String nazivVozila = "Audi";
		String godinaProizvodnje = "2005";
		String proizvodjac = "WV";
		JFrame frame = new JFrame();
		boolean test = ctrl.unesiVozilo(saobracajnaDozvola, vlasnickaDozvola, registracija, intervalMjeseci, intervalKilometara, nazivVozila, godinaProizvodnje, proizvodjac, "", frame);
		assertFalse(test);
	}
	
	public void testUnosNovogVozilaControllerTest5(){
		String saobracajnaDozvola = "AB1234567";
		String vlasnickaDozvola = "AB1234567";
		String registracija = "D32-J-111";
		//nije broj
		String intervalMjeseci = "hfgh";
		String intervalKilometara = "10000";
		String nazivVozila = "Buba";
		String godinaProizvodnje = "1997";
		String proizvodjac = "WV";
		JFrame frame = new JFrame();
		boolean test = ctrl.unesiVozilo(saobracajnaDozvola, vlasnickaDozvola, registracija, intervalMjeseci, intervalKilometara, nazivVozila, godinaProizvodnje, proizvodjac, "", frame);
		assertFalse(test);
	}
	
	
}
