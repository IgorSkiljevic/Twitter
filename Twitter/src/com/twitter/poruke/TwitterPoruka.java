package com.twitter.poruke;

import javax.print.attribute.standard.RequestingUserName;

/**
 * Klasa predstavlja poruku na Twitteru
 * 
 * @author Igor Skiljevic
 * 
 * @version 1.0
 */

public class TwitterPoruka {
	/**
	 * Atribut predstavlja ime korisnika
	 */
	private String korisnik;
	/**
	 * atribut koji predstavlja poruku
	 */
	private String poruka;

	/**
	 * Metoda koja vraca korisnika
	 * 
	 * @return vraca String korisnik, koji predstavlja ime korisnika.
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda postavlja atribut korisnik na zadatu vrednost
	 * 
	 * @param korisnik-
	 *            Predstavlja ime korisnika
	 * @throws java.lang.RuntimeException
	 *             Dolazi do izuzetka ako je ulazini parametar Korisnik prazan
	 *             String ili ako ima vrednost null
	 */

	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.trim().isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda vraca vrednost atributa poruka
	 * 
	 * @return String poruka
	 */
	public String getPoruka() {
		return poruka;
	}

	/**
	 * Metoda postavlja vrednost atributa poruka
	 * 
	 * @param poruka-
	 *            predstavlja sadrzaj poruke
	 * @throws java.lang.RuntimeException
	 *             Do izuzetka dolazi ako je vrednost ulaznog atributa poruka
	 *             prazan String ili null
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.trim().isEmpty() || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Metoda vraca string sa svim atributima klase TwitterPoruka u
	 * odgovarajucem formatu
	 * 
	 * @return String - vraca String sa svim podacima o TwitterPoruci u tacno
	 *         odredjenom formatu
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

	/**
	 * Metoda proverava da li je objekat koji poredimo sa datim objektom klase
	 * TwitterPoruka jedan datom objektu. Objekti su jednaki ako su im atributi
	 * korisnik i poruka jednaki.
	 * 
	 * @return true(ako su objekti jednaki) ili false(ako su objekti razliciti)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwitterPoruka other = (TwitterPoruka) obj;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		if (poruka == null) {
			if (other.poruka != null)
				return false;
		} else if (!poruka.equals(other.poruka))
			return false;
		return true;
	}

}
