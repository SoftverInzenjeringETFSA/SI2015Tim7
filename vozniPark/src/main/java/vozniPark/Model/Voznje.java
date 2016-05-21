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
	public Osoba getVozac() {
		return vozac;
	}
	public void setVozac(Osoba vozac) {
		this.vozac = vozac;
	}
	public TocenjeGoriva getTocenje() {
		return tocenje;
	}
	public void setTocenje(TocenjeGoriva potrosnjaGoriva) {
		this.tocenje = potrosnjaGoriva;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private Date datumPreuzimanja;
	private Date datumVracanja;
	private long predjeniKilometri;
	private String opisUpotrebe;
	private Vozilo vozilo;
	//private Vozac vozac;
	private Osoba vozac;
	private TocenjeGoriva tocenje;
	
	
	public Voznje() {}
}
