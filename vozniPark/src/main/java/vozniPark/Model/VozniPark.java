package vozniPark.Model;

import java.util.List;

public class VozniPark {

	private List<Vozilo> listaVozila;
	private List<Vozac> listaVozaca;

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
}
