package Liczba;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Kalkulator.BlednaLiczbaException;
import Kalkulator.Dzielenie0Exception;
import Kalkulator.DzielenikZaDuzyException;

/**
 * Testy jednostkowe klasy <code>Arytmetyka</code>. Sprawdzają poprawność działań arytmetycznych
 *
 */
public class ArytmetykaTest {

	/**
	 * Test dodawania liczb reprezentowanych przez dwie tablice
	 */
	@Test
	public void dodawanieTablic() {
		int[] liczba1 = new int[] {5};
		int[] liczba2 = new int[] {9};
		assertEquals("14", new Arytmetyka().add(liczba1, liczba2));
	}

	/**
	 * Test dodawania liczb reprezentowanych przez obiekty <code>DuzaLiczba</code>
	 * @throws BlednaLiczbaException 
	 */
	@Test
	public void dodawanie() throws BlednaLiczbaException {
		DuzaLiczba liczba1 = new DuzaLiczba("10000000000000000000000000000000000000000000000000000000000000000000000000");
		DuzaLiczba liczba2 = new DuzaLiczba("20000000000000000000000000000000000000000000000000000000000000000000000000");
		assertEquals("30000000000000000000000000000000000000000000000000000000000000000000000000", new Arytmetyka().add(liczba1, liczba2));
	}
	
	/**
	 * Test odejmowania liczb reprezentowanych przez dwie tablice
	 */
	@Test
	public void odejmowanieTablic() {
//		int[] liczba1 = new int[] {5};
//		int[] liczba2 = new int[] {5};
//		assertEquals("0", new Arytmetyka().subtract(liczba1, liczba2));
	}
	
	/**
	 * Test odejmowania liczb reprezentowanych przez obiekty <code>DuzaLiczba</code>
	 * @throws BlednaLiczbaException 
	 */
	@Test
	public void odejmowanie() throws BlednaLiczbaException {
		DuzaLiczba liczba1 = new DuzaLiczba("10000000000000000000000000000000000000000000000000000000000000000000000000");
		DuzaLiczba liczba2 = new DuzaLiczba("20000000000000000000000000000000000000000000000000000000000000000000000000");
		assertEquals("-10000000000000000000000000000000000000000000000000000000000000000000000000", new Arytmetyka().subtract(liczba1, liczba2));
	}
	
	/**
	 * Test mnozenia liczb reprezentowanych przez dwie tablice
	 */
	@Test
	public void mnozenieTablic() {
		int[] liczba1 = new int[] {5};
		int[] liczba2 = new int[] {5};
		assertEquals("25", new Arytmetyka().multiply(liczba1, liczba2));
	}
	
	/**
	 * Test mnozenia duzych liczb reprezentowanych przez obiekty <code>DuzaLiczba</code>
	 * @throws BlednaLiczbaException 
	 */
	@Test
	public void mnozenie() throws BlednaLiczbaException {
		DuzaLiczba liczba1 = new DuzaLiczba("37975227936943673922808872755445627854565536638199");
		DuzaLiczba liczba2 = new DuzaLiczba("40094690950920881030683735292761468389214899724061");
		assertEquals("1522605027922533360535618378132637429718068114961380688657908494580122963258952897654000350692006139", 
				new Arytmetyka().multiply(liczba1, liczba2));
	}
	
	/**
	 * Test dzielenia liczb 
	 * @throws Dzielenie0Exception 
	 */
	@Test
	public void dzielenieLiczb() throws Dzielenie0Exception {
		assertEquals(4, new Arytmetyka().divide(8, 2));
	}
	
	/**
	 * Test dzielenia liczby reprezentowanej przez obiekt przez liczbę podaną w String
	 * @throws BlednaLiczbaException 
	 * @throws Dzielenie0Exception 
	 * @throws DzielenikZaDuzyException 
	 */
	@Test
	public void dzielenie() throws BlednaLiczbaException, Dzielenie0Exception, DzielenikZaDuzyException {
		DuzaLiczba liczba1 = new DuzaLiczba("4442");
		DuzaLiczba liczba2 = new DuzaLiczba("2");
	 	assertEquals("2221", new Arytmetyka().divide(liczba1, liczba2.getLiczbaStr()));
	}
	/**
	 * Test dzielenia liczby reprezentowanej przez obiekt przez za dużą liczbę podaną w String
	 * @throws BlednaLiczbaException 
	 * @throws Dzielenie0Exception 
	 * @throws DzielenikZaDuzyException 
	 */
	@Test(expected = BlednaLiczbaException.class)
	public void dzielenieBlednaLiczba() throws BlednaLiczbaException, Dzielenie0Exception, DzielenikZaDuzyException {
		DuzaLiczba liczba1 = new DuzaLiczba("1234567891028343958413");
		DuzaLiczba liczba2 = new DuzaLiczba("84537543756437548274954854");
	 	new Arytmetyka().divide(liczba1, liczba2.getLiczbaStr());
	}
	/**
	 * Test dzielenia przez 0
	 * @throws Dzielenie0Exception
	 */
	@Test(expected = Dzielenie0Exception.class)
	public void dzielenieLiczb0() throws Dzielenie0Exception {
		new Arytmetyka().divide(8, 0);
	}
	
	/**
	 * Test dzielenia  0
	 * @throws Dzielenie0Exception
	 */
	@Test 
	public void dzielenieLiczby0() throws Dzielenie0Exception {
		assertEquals(0, new Arytmetyka().divide(0, 1));
	}
}
