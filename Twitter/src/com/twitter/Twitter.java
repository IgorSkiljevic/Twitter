package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa predstavlja Twitter
 * 
 * @author Igor Skiljevic
 *
 *@version 1.0
 */
public class Twitter {
	/**
	 * Atribut predstavlja listu objekata klase TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	/**
	 * Metoda vraca sve poruke sa Twittera
	 * 
	 * @return vraca listu poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Metoda za unete parametre korisnik i poruka
	 * Kreira novu poruku i puni je podacima
	 * Poruka se unosi na kraj liste 'poruke'
	 * 
	 * @param korisnik predstavlja ime Korisnika koji se unosi u listu
	 * @param poruka predstavlja pruku koju je postavio korisnik
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Metoda za unete parametre maxBroj i tag
	 * proverava da li postoji poruka sa zadatim tagom.
	 * Ako se pronadje takva poruka, ona se upisuje u niz
	 * koji se vraca kao povratna vrednost.
	 * Ako je maxBroj manji ili jednak nuli, maxBroj je postavlja na 100
	 * 
	 * @throws java.lang.RuntimeException u slucaju da je unet String tag koji je prazan ili ime null vrednost
	 * @param maxBroj Obelezava maksimalan broj poruka koje treba da se vrate
	 * @param tag predstavlja identifikator za pronalazenje poruka
	 * @return niz objekata klase TwitterPoruka
	 */
	
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.trim().isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}


	/**
	 * Metoda proverava da li je objekat koji poredimo sa datim objektom iz klase Twitter
	 * jedan datom objektu. Objekti su jednaki ako su im sve poruke jednake.
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
		Twitter other = (Twitter) obj;
		if (poruke == null) {
			if (other.poruke != null)
				return false;
		} else if (!poruke.equals(other.poruke))
			return false;
		return true;
	}
	
	
}