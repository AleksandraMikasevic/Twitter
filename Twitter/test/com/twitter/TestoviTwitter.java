package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TestoviTwitter {
	private Twitter twitter;
	@Before
	public void setUp() throws Exception {
		twitter = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		twitter = null;
	}

	@Test
	public void testVratiSvePorukeDobarTest() {
		LinkedList<TwitterPoruka> poruke = new LinkedList<>();
		TwitterPoruka p1 = new TwitterPoruka();
		TwitterPoruka p2 = new TwitterPoruka();
		String korisnik1 = "Pera";
		String korisnik2 = "Maja";
		String poruka1 = "|=Z+fa.";
		String poruka2 = "La, la.";
		twitter.unesi(korisnik1, poruka1);
		twitter.unesi(korisnik2, poruka2);
		p1.setKorisnik(korisnik1);
		p1.setPoruka(poruka1);
		p2.setKorisnik(korisnik2);
		p2.setPoruka(poruka2);
		poruke.addLast(p1);
		poruke.addLast(p2);
		assertEquals(poruke, twitter.vratiSvePoruke());
	}

	@Test
	public void testUnesiDobarTest() {
		LinkedList<TwitterPoruka> poruke = new LinkedList<>();
		TwitterPoruka p1 = new TwitterPoruka();
		TwitterPoruka p2 = new TwitterPoruka();
		String korisnik1 = "Pera";
		String korisnik2 = "Maja";
		String poruka1 = "la, la.";
		String poruka2 = "La, la.";
		twitter.unesi(korisnik1, poruka1);
		twitter.unesi(korisnik2, poruka2);
		p1.setKorisnik(korisnik1);
		p1.setPoruka(poruka1);
		p2.setKorisnik(korisnik2);
		p2.setPoruka(poruka2);
		poruke.addLast(p1);
		poruke.addLast(p2);
		assertEquals(poruke, twitter.vratiSvePoruke());

	}

	@Test
	public void testVratiPorukeDobarTest() {
		TwitterPoruka p1 = new TwitterPoruka();
		TwitterPoruka p2 = new TwitterPoruka();
		int maks = 2;
		TwitterPoruka[] poruke = new TwitterPoruka[maks];
		String korisnik1 = "Peraica";
		String korisnik2 = "Maja";
		String poruka1 = "La, la.";
		String poruka2 = "La, la.";
		String korisnik3 = "Joca";
		String poruka3 = "Programiranje.";
		p1.setKorisnik(korisnik1);
		p1.setPoruka(poruka1);
		p2.setKorisnik(korisnik2);
		p2.setPoruka(poruka2);
		poruke [0] = p1;
		poruke [1] = p2;
		twitter.unesi(korisnik1, poruka1);
		twitter.unesi(korisnik2, poruka2);
		twitter.unesi(korisnik3, poruka3);
		assertArrayEquals(poruke, twitter.vratiPoruke(maks, "la"));
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeProsledjenNull() {
		twitter.vratiPoruke(1, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		twitter.vratiPoruke(1,"");
	}

}
