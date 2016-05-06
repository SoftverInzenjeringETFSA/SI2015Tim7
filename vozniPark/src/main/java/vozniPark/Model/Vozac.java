package vozniPark.Model;

public class Vozac extends Osoba implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String brojVozacke;

	public String getBrojVozacke() {
		return brojVozacke;
	}

	public void setBrojVozacke(String brojVozacke) {
		this.brojVozacke = brojVozacke;
	}
	
	public Vozac(){}
}
