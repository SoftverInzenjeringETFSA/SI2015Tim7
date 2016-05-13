package vozniPark.Controller;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import junit.framework.TestCase;

public class UnosNovogVozacaControllerTest extends TestCase {
	
	public void testUnosNovogVozacaController()
	{
		UnosNovogVozacaController unvc=new UnosNovogVozacaController();
		assertEquals(0, unvc.getListaVozaca().size());
	}
	
	public void testUnosVozaca() 
	{
		UnosNovogVozacaController unvc= new UnosNovogVozacaController();
		String Ime="Irma";
		String Prezime = "Karasoftic";
		String BrojVozacke = "48urr4848";
		String Adresa = "Ta i ta";
		String BrojTelefona = "061333333";
		String Username = "Irma";
		String Sifra = "tajna";
		unvc.UnosVozaca(Ime, Prezime, BrojVozacke, Adresa, BrojTelefona, Username, Sifra);
		assertEquals(1, unvc.getListaVozaca().size());
	}
	
	public void testUnosVozaca1() 
	{
		UnosNovogVozacaController unvc= new UnosNovogVozacaController();
		String Ime="Irma";
		String Prezime = "Karasoftic";
		String BrojVozacke = "48urr4848";
		String Adresa = "Ta i ta";
		String BrojTelefona = "061333333";
		String Username = "Irma";
		String Sifra = "tajna";
		
		String Ime1="Amri";
		String Prezime1 = "Citfosarak";
		String BrojVozacke1 = "87ddd8474";
		String Adresa1 = "Ta i taa";
		String BrojTelefona1 = "061133333";
		String Username1 = "Irma";
		String Sifra1 = "tajnaa";
		
		unvc.UnosVozaca(Ime, Prezime, BrojVozacke, Adresa, BrojTelefona, Username, Sifra);
		unvc.UnosVozaca(Ime1, Prezime1, BrojVozacke1, Adresa1, BrojTelefona1, Username1, Sifra1);
		
		assertEquals(1, unvc.getListaVozaca().size());
	}}
