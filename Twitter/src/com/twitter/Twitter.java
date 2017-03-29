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
	 * @param korisnik
	 * @param poruka
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
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
	 * @throws java.lang.RuntimeException
	 * @param maxBroj
	 * @param tag
	 * @return niz objekata klase TwitterPoruka
	 */
	
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
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
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}