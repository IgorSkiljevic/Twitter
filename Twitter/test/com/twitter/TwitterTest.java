package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter t;

	private LinkedList<TwitterPoruka> listaPoruka;

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
		listaPoruka = new LinkedList<>();

		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();

		tp1.setKorisnik("Igor");
		tp1.setPoruka("#Badges");

		tp2.setKorisnik("Nikola Jokic");
		tp2.setPoruka("#NBAVote #Badges");

		listaPoruka.addLast(tp1);
		listaPoruka.addLast(tp2);

	}

	@After
	public void tearDown() throws Exception {
		listaPoruka = null;
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {
		t.unesi("Igor", "#Badges");
		t.unesi("Nikola Jokic", "#NBAVote #Badges");

		for (int i = 0; i < listaPoruka.size(); i++) {
			assertEquals(listaPoruka.get(i), t.vratiSvePoruke().get(i));
		}
	}

	@Test
	public void testUnesi() {
		t.unesi("Igor", "#Badges");
		t.unesi("Nikola Jokic", "#NBAVote #Badges");
		for (int i = 0; i < listaPoruka.size(); i++) {
			assertEquals(listaPoruka.get(i), t.vratiSvePoruke().get(i));
		}
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.vratiPoruke(100, " ");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(100, null);
	}

	@Test
	public void testVratiPoruke() {
		TwitterPoruka[] niz = new TwitterPoruka[2];
		for (int i = 0; i < 2; i++) {
			niz[i] = listaPoruka.get(i);
		}
		t.unesi("Igor", "#Badges");
		t.unesi("Nikola Jokic", "#NBAVote #Badges");
		t.unesi("Zoran", "#git");

		TwitterPoruka[] nizPoruka = t.vratiPoruke(2, "#Badge");

		assertArrayEquals(niz, nizPoruka);

	}

	@Test
	public void testVratiPorukeMaxUMinusu() {
		TwitterPoruka[] niz = new TwitterPoruka[100];
		for (int i = 0; i < 2; i++) {
			niz[i] = listaPoruka.get(i);
		}
		t.unesi("Igor", "#Badges");
		t.unesi("Nikola Jokic", "#NBAVote #Badges");
		t.unesi("Zoran", "#git");

		TwitterPoruka[] nizPoruka = t.vratiPoruke(-5, "#Badge");

		assertArrayEquals(niz, nizPoruka);
	}

}
