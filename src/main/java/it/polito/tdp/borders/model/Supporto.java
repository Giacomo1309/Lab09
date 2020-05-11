package it.polito.tdp.borders.model;

public class Supporto {
	private Country stato;
	private int numeroStatiConfinanti;
	
	public Supporto(Country stato, int numeroStatiConfinanti) {
		super();
		this.stato = stato;
		this.numeroStatiConfinanti = numeroStatiConfinanti;
	}
	public Country getStato() {
		return stato;
	}
	public void setStato(Country stato) {
		this.stato = stato;
	}
	public int getNumeroStatiConfinanti() {
		return numeroStatiConfinanti;
	}
	public void setNumeroStatiConfinanti(int numeroStatiConfinanti) {
		this.numeroStatiConfinanti = numeroStatiConfinanti;
	}
	@Override
	public String toString() {
		return "lo stato:" + stato + " confina con "+ numeroStatiConfinanti+" stati" ;
	}
	

}
