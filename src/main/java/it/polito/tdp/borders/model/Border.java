package it.polito.tdp.borders.model;

public class Border {
	private int codice;
	private int year;
	private Country stato1;
	private Country stato2;
	
	public Border(int codice, int year, Country stato1, Country stato2) {
		super();
		this.codice = codice;
		this.year = year;
		this.stato1 = stato1;
		this.stato2 = stato2;
	}
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Country getStato1() {
		return stato1;
	}
	public void setStato1(Country stato1) {
		this.stato1 = stato1;
	}
	public Country getStato2() {
		return stato2;
	}
	public void setStato2(Country stato2) {
		this.stato2 = stato2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codice;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Border other = (Border) obj;
		if (codice != other.codice)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Border [codice=" + codice + ", year=" + year + ", stato1=" + stato1 + ", stato2=" + stato2 + "]";
	}
	
	

}
