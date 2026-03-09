package no.hvl.dat102.immutable_person_alt;

import java.util.Objects;

/*
 * En ikke-mutérbar klasse, altså hvor vi ikke kan endre på innholdet i et Navn-objekt.
 */
public final class NavnIkkeMuterbar {
	
	private final String fornavn;
	private final String etternavn;
	
	public NavnIkkeMuterbar(String fornavn, String etternavn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	@Override
	public String toString() {
		return "Navn[fornavn=" + fornavn + ", etternavn=" + etternavn + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(etternavn, fornavn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NavnIkkeMuterbar other = (NavnIkkeMuterbar) obj;
		return Objects.equals(etternavn, other.etternavn) && Objects.equals(fornavn, other.fornavn);
	}

}
