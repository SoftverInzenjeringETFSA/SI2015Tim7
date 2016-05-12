package vozniPark.Model;

import java.io.Serializable;
import java.util.Date;

public class Voznje implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDatumPreuzimanja() {
		return datumPreuzimanja;
	}
	public void setDatumPreuzimanja(Date datumPreuzimanja) {
		this.datumPreuzimanja = datumPreuzimanja;
	}
	public Date getDatumVracanja() {
		return datumVracanja;
	}
	public void setDatumVracanja(Date datumVracanja) {
		this.datumVracanja = datumVracanja;
	} 
	public long getPredjeniKilometri() {
		return predjeniKilometri;
	}
	public void setPredjeniKilometri(long predjeniKilometri) {
		this.predjeniKilometri = predjeniKilometri;
	}
	public String getOpisUpotrebe() {
		return opisUpotrebe;
	}
	public void setOpisUpotrebe(String opisUpotrebe) {
		this.opisUpotrebe = opisUpotrebe;
	}
	public Vozilo getVozilo() {
		return vozilo;
	}
	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}
	public Vozac getVozac() {
		return vozac;
	}
	public void setVozac(Vozac vozac) {
		this.vozac = vozac;
	}
	public long getPotrosnjaGoriva() {
		return potrosnjaGoriva;
	}
	public void setPotrosnjaGoriva(long potrosnjaGoriva) {
		this.potrosnjaGoriva = potrosnjaGoriva;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private Date datumPreuzimanja;
	private Date datumVracanja;
	private long predjeniKilometri;
	private String opisUpotrebe;
	private Vozilo vozilo;
	private Vozac vozac;
	private long potrosnjaGoriva;
	
	
	public Voznje() {}
}
