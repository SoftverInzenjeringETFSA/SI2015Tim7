package vozniPark.Model;

public class Vozac extends Osoba implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String brojVozacke;
	private String username;
	private String password;

	public String getBrojVozacke() {
		return brojVozacke;
	}

	public void setBrojVozacke(String brojVozacke) {
		this.brojVozacke = brojVozacke;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Vozac(){}
}
