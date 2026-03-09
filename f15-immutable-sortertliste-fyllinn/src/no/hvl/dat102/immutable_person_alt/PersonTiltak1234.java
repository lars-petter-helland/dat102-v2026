package no.hvl.dat102.immutable_person_alt;

import java.util.Objects;

public final class PersonTiltak1234 {

	private final NavnIkkeMuterbar navn;
	private final int fodselsaar;
	
	public PersonTiltak1234(NavnIkkeMuterbar navn, int fodselsaar) {
		this.navn = navn;
		this.fodselsaar = fodselsaar;
	}
	
	public NavnIkkeMuterbar getNavn() {
		return navn;
	}

	public int getFodselsaar() {
		return fodselsaar;
	}

	@Override
	public String toString() {
		return "PersonTiltak1234{" +
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
		PersonTiltak1234 other = (PersonTiltak1234) obj;
		return fodselsaar == other.fodselsaar && Objects.equals(navn, other.navn);
	}
}
