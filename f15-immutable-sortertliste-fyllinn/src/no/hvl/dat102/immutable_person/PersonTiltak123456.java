package no.hvl.dat102.immutable_person;

import java.util.Objects;

public final class PersonTiltak123456 {

	//TODO - Gjennomføre tiltak 5 og 6 for å gjøre denne helt ikke-muterbar

	private final NavnMuterbar navn;
	private final int fodselsaar;
	
	public PersonTiltak123456(NavnMuterbar navn, int fodselsaar) {
		this.navn = navn;
		this.fodselsaar = fodselsaar;
	}
	
	public NavnMuterbar getNavn() {
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
		PersonTiltak123456 other = (PersonTiltak123456) obj;
		return fodselsaar == other.fodselsaar && Objects.equals(navn, other.navn);
	}
}
