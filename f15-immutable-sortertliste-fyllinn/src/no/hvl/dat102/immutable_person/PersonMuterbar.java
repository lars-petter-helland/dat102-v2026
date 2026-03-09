package no.hvl.dat102.immutable_person;

import java.util.Objects;

public class PersonMuterbar {

	public NavnMuterbar navn;
	public int fodselsaar;
	
	public PersonMuterbar(NavnMuterbar navn, int fodselsaar) {
		this.navn = navn;
		this.fodselsaar = fodselsaar;
	}
	
	public NavnMuterbar getNavn() {
		return navn;
	}

	public void setNavn(NavnMuterbar navn) {
		this.navn = navn;
	}

	public int getFodselsaar() {
		return fodselsaar;
	}

	public void setFodselsaar(int fodselsaar) {
		this.fodselsaar = fodselsaar;
	}

	@Override
	public String toString() {
		return "PersonMuterbar{" +
				"navn=" + navn +
				", fodselsaar=" + fodselsaar +
				'}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(fodselsaar, navn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonMuterbar other = (PersonMuterbar) obj;
		return fodselsaar == other.fodselsaar && Objects.equals(navn, other.navn);
	}
}
