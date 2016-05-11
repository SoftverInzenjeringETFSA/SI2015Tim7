package vozniPark.Model;

import java.util.List;

import org.hibernate.Session;

public class VozniPark {

	private List<Vozilo> listaVozila;
	private List<Vozac> listaVozaca;
	private Session s;

	public List<Vozilo> getListaVozila() {
		return listaVozila;
	}

	public void setListaVozila(List<Vozilo> listaVozila) {
		this.listaVozila = listaVozila;
	}

	public List<Vozac> getListaVozaca() {
		return listaVozaca;
	}

	public void setListaVozaca(List<Vozac> listaVozaca) {
		this.listaVozaca = listaVozaca;
	}

	public VozniPark() {
	}

	public VozniPark(Session s) {
		this.s=s;
	}
}
