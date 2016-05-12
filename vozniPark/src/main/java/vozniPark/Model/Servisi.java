package vozniPark.Model;

import java.util.Date;

public class Servisi implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private Date datumOdlaska;
	private Date datumVracanja;
	private double cijena;
	private String opis;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDatumOdlaska() {
		return datumOdlaska;
	}
	public void setDatumOdlaska(Date datumOdlaska) {
		this.datumOdlaska = datumOdlaska;
	}
	
	public Date getDatumVracanja() {
		return datumVracanja;
	}
	public void setDatumVracanja(Date datumVracanja) {
		this.datumVracanja = datumVracanja;
	}
	
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public Servisi(){}

}
