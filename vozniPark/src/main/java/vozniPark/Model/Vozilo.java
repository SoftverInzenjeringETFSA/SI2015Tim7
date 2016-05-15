package vozniPark.Model;

import java.util.List;
import java.util.Date;

public class Vozilo implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String brojSaobracajneDozvole;
	private String registracija;
	private String naziv;
	private String osnovneKarakteristike;
	private double zadnjiServisKilometri;
	private Date datumZadnjegServisa;
	private List<TocenjeGoriva> listaTocenja;
	private List<Servisi> listaServisa;
	private double brojPredjenihKilometara;
	private String proizvodjac;
	private int godinaProizvodnje;
	private String status;
	private int intervalServisaKilometri;
	private int intervalServisaMjeseci;
	private String opis;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	private String brojVlasnickeDozvole;
	public String getBrojVlasnickeDozvole() {
		return brojVlasnickeDozvole;
	}
	public void setBrojVlasnickeDozvole(String brojVlasnickeDozvole) {
		this.brojVlasnickeDozvole = brojVlasnickeDozvole;
	}
	
	public String getBrojSaobracajneDozvole() {
		return brojSaobracajneDozvole;
	}
	public void setBrojSaobracajneDozvole(String brojSaobracajneDozvole) {
		this.brojSaobracajneDozvole = brojSaobracajneDozvole;
	}
	
	public String getRegistracija() {
		return registracija;
	}
	public void setRegistracija(String registracija) {
		this.registracija = registracija;
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public String getOsnovneKarakteristike() {
		return osnovneKarakteristike;
	}
	public void setOsnovneKarakteristike(String osnovneKarakteristike) {
		this.osnovneKarakteristike = osnovneKarakteristike;
	}
	
	public double getZadnjiServisKilometri() {
		return zadnjiServisKilometri;
	}
	public void setZadnjiServisKilometri(double zadnjiServisKilometri) {
		this.zadnjiServisKilometri = zadnjiServisKilometri;
	}
	
	public Date getDatumZadnjegServisa() {
		return datumZadnjegServisa;
	}
	public void setDatumZadnjegServisa(Date datumZadnjegServisa) {
		this.datumZadnjegServisa = datumZadnjegServisa;
	}
	
	public List<TocenjeGoriva> getListaTocenja() {
		return listaTocenja;
	}
	public void setListaTocenja(List<TocenjeGoriva> listaTocenja) {
		this.listaTocenja = listaTocenja;
	}
	
	public List<Servisi> getListaServisa() {
		return listaServisa;
	}
	public void setListaServisa(List<Servisi> listaServisa) {
		this.listaServisa = listaServisa;
	}
	
	public double getBrojPredjenihKilometara() {
		return brojPredjenihKilometara;
	}
	public void setBrojPredjenihKilometara(double brojPredjenihKilometara) {
		this.brojPredjenihKilometara = brojPredjenihKilometara;
	}
	
	public String getProizvodjac() {
		return proizvodjac;
	}
	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	
	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}
	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Vozilo(){}

	public int getIntervalServisaKilometri() {
		return intervalServisaKilometri;
	}

	public void setIntervalServisaKilometri(int intervalServisaKilometri) {
		this.intervalServisaKilometri = intervalServisaKilometri;
	}

	public int getIntervalServisaMjeseci() {
		return intervalServisaMjeseci;
	}

	public void setIntervalServisaMjeseci(int intervalServisaMjeseci) {
		this.intervalServisaMjeseci = intervalServisaMjeseci;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
}
