package com.twitter.poruke;

import javax.print.attribute.standard.RequestingUserName;

/**
 * Klasa predstavlja poruku na Twitteru
 * 
 * @author Igor Skiljevic
 * 
 *@version 1.0
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
	 * @return Korisnik
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda postavlja atribut korisnik na zadatu vrednost
	 * @param korisnik
	 * @throws java.lang.RuntimeException
	 */

	public void setKorisnik(String korisnik) {
		if (korisnik == null || !korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda vraca vrednost atributa poruka
	 * @return String poruka
	 */
	public String getPoruka() {
		return "poruka";
	}
	
	/**
	 * Metoda postavlja vrednost atributa poruka
	 * @param poruka
	 * @throws java.lang.RuntimeException
	 */
	public void setPoruka(String poruka) {
		if (this.poruka == null || this.poruka == new String("") || this.poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Metoda vraca string sa svim atributima klase TwitterPoruka u odgovarajucem formatu
	 * @return String
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
