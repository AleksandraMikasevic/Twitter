/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author User
 *
 */
public class TwitterPorukaTest {
	private TwitterPoruka poruka;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		poruka = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		poruka = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnikDobarTest() {
		String korisnik = "Pera Peric";
		poruka.setKorisnik(korisnik);
		assertEquals(korisnik, poruka.getKorisnik());
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikProsledjenNull() {
		poruka.setKorisnik(null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikProsledjenPrazanString() {
		poruka.setKorisnik("");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPorukaDobarTest() {
		String p = "La, la , la.";
		poruka.setPoruka(p);
		assertEquals(p, poruka.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaProsledjenNull() {
		poruka.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrekoGranicaDuzine() {
		String p = "";
		for (int i = 0; i < 150; i++) {
			p = p + "La, ";
		}
		poruka.setPoruka(p);
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		String p = "La, la , la.";
		String korisnik = "Pera Peric";
		poruka.setKorisnik(korisnik);
		poruka.setPoruka(p);
		String ocekivano = "KORISNIK:"+korisnik+" PORUKA:"+p;
		assertEquals(ocekivano, poruka.toString());
	}

}
