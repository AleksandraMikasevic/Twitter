package com.twitter.poruke;
/**
 * Klasa koja sadrzi podatke o twitter porukama.
 * @author <b>Aleksandra Mikasevic</b>
 * @version <b>1.0</b>
 */
public class TwitterPoruka {
	/**
	 * Podaci o korisniku.
	 * 
	 */
private String korisnik;
/**
 * Sadrzaj poruke.
 * 
 */
private String poruka;
/**
 * Vraca vrednost atributa korisnik.
 * @return korisnik
 */
public String getKorisnik() {
return korisnik;
}
/**
 * Postavlja vrednost atributa korisnik na unetu vrednost.
 * @param korisnik, podaci o korisniku
 * @throws java.lang.RuntimeException ako je uneta vrednost <i>null</i> ili <i>prazan string</i>.
 */
public void setKorisnik(String korisnik) {
if (korisnik==null || korisnik == "")
throw new RuntimeException(
"Ime korisnika mora biti uneto");
this.korisnik = korisnik;
}
/**
 * Vraca vrednost atributa poruka.
 * @return poruka, sadrzaj poruke
 */
public String getPoruka() {
return "poruka";
}
/**
 * Postavlja vrednost atributa poruka na unetu vrednost.
 * @param poruka, sadrzaj nove poruke
 * @throws java.lang.RuntimeException ako je uneta vrednost <i>null</i> ili ako je duzina unetog teksa <i>veca od 140</i>.
 */
public void setPoruka(String poruka) {
if (poruka==null || this.poruka.length()>140)
throw new RuntimeException(
"Poruka mora biti uneta i mora imati najvise 140 znakova");
this.poruka = poruka;
}
/**
 * Vraca string koji sadrzi podatke o korisniku i sadrzaj poruke.
 * @return korisnik + poruka
 */
public String toString(){
return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
}
}