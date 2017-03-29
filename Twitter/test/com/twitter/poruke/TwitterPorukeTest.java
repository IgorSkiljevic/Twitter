package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukeTest {

	TwitterPoruka tp;

	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test
	public void testSetKorisnik() {
		tp.setKorisnik("Igor Skiljevic");
		assertEquals("Igor Skiljevic", tp.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tp.setKorisnik(" ");
	}

	@Test
	public void testSetPoruka() {
		tp.setPoruka("Poruka");

		assertEquals("Poruka", tp.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPraznaPoruka() {
		tp.setPoruka(" ");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaStringDuziOd140Karaktera() {
		String tekst = "Multithreading refers to two or more tasks executing concurrently " + "within a single program."
				+ "A thread is an independent path of execution within a program. Many threads can run concurrently within a program."
				+ " Every thread in Java is created and controlled by the java.lang.Thread class."
				+ " A Java program can have many threads, "
				+ "and these threads can run concurrently, either asynchronously or "
				+ "synchronously.Multithreading has several advantages over Multiprocessing such as;"
				+ "Threads are lightweight compared to processes"
				+ "One way to create a thread in java is to implement the Runnable Interface and then instantiate an object of the class."
				+ "A class implements the Runnable interface, providing the run() method that will be executed by the thread. An object of this class is a Runnable object."
				+ "An object of Thread class is created by passing a Runnable object as argument to the Thread constructor. The Thread object now has a Runnable object that implements the run() method.";

		tp.setPoruka(tekst);
	}

	@Test
	public void testToString() {
		tp.setKorisnik("Igor Skiljevic");
		tp.setPoruka("#JAVA #GIT #JUnit");
		
		String ocekivano = "KORISNIK:" + "Igor Skiljevic" + " PORUKA:" + "#JAVA #GIT #JUnit";
		
		assertEquals(ocekivano, tp.toString());
	}

}
