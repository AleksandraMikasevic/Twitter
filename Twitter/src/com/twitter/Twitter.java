package com.twitter;
import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Klasa koja sadrzi listu twitter poruka.
 * @author <b>Aleksandra Mikasevic</b>
 * @version <b>1.0</b>
 * 
 */
public class Twitter {
	/**
	 * Lista twitter poruka, koja je kreirana i inicijalizovana.
	 * 
	 */
private LinkedList<TwitterPoruka> poruke =
new LinkedList<TwitterPoruka>();
/**
 * Vraca listu twitter poruka.
 * @return poruke
 */
public LinkedList<TwitterPoruka> vratiSvePoruke(){
return poruke;
}
/**
 * Kreira novu poruku i ubacuje potrebne vrednosti u nju, takodje unosi na kraj liste kreiranu poruku.
 * @param korisnik, poruka, odnosno potrebni atributi twitter poruke
 */
public void unesi(String korisnik, String poruka) {
//Pravi se nova poruka i puni podacima.
TwitterPoruka tp = new TwitterPoruka();
tp.setKorisnik(korisnik);
tp.setPoruka(poruka);
//Poruka se unosi u listu na kraj
poruke.addLast(tp);
}
/**
 * 
 * Trazi poruke koje sadrze uneti tag, unosi poruke u niz kapaciteta maxBroj.
 * Ukoliko postoji vise poruka sa zadatim tagom od prosledjenog kapaciteta niza, vraca samo deo poruka koji je ubacen u niz.
 * @param maxBroj, tag
 * @return TwitterPoruka[], niz twitter poruka
 * @throws java.lang.RuntimeException ukoliko je uneta vrednost za tag <i>null</i> ili <i>prazan string</i>.
 */
public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
if (tag==null || tag == "")
throw new RuntimeException("Morate uneti tag");
//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
if (maxBroj<=0)
maxBroj = 100;
 //Pomocna promenljiva koja predstavlja brojac upisanih poruka
int brojac = 0; 
//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
//sve poruke koje u sebi imaju zadati tag
TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
//Pretrazuju se poruke i traze se one koje sadrze tag.
//Ako se nadje neka takva, i ako nije prekoracen maxBroj
//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
//se prekida.
for (int i = 0; i < poruke.size(); i++)
if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
if (brojac < maxBroj){
rezultat[brojac]=poruke.get(i);
brojac++;
}
else break;
return rezultat;
}
}
