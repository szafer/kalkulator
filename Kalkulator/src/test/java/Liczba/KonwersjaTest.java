package Liczba;

import static org.junit.Assert.*;

import org.junit.Test;

import Kalkulator.BlednaLiczbaException;

/**
 * Testy jednostkowe klasy <code>Konwersja</code>
 *
 */
public class KonwersjaTest {

	private static final int[] LICZBA_TESTOWA = new int[] {9,8,7,6,5,4,3,2,1,9,8,7,6,5,4,3,2,1,9,8,7,6,5,4,3,2,1};
	private static final int[] LICZBA_ODWR = new int[] {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9};

	/**
	 * Sprawdzenie czy liczba podana w postaci stringa dobrze zamienia się na tablicę tej samej dlugosci
	 * @throws BlednaLiczbaException 
	 */
	@Test
	public void testStringToArray() throws BlednaLiczbaException {
		int[] liczba = Konwersja.stringToArray("123456789123456789123456789");
		assertArrayEquals(LICZBA_TESTOWA, liczba);
	}
	
	/**
	 * Sprawdzenie czy liczba podana w postaci stringa dobrze zamienia się 
	 * na tablicę innej  dlugosci
	 * @throws BlednaLiczbaException 
	 */
	@Test
	public void testStringToArrayLength() throws BlednaLiczbaException {
		int[] liczba = Konwersja.stringToArray("123456789123456789123456789", 30);
		assertEquals(30, liczba.length);
	}
	
	/**
	 * Sprawdzenie czy liczba podana w postaci tablicy dobrze zamienia się na stringa
	 * @throws BlednaLiczbaException 
	 */
	@Test
	public void testArrayToString() throws BlednaLiczbaException {
		String liczba = Konwersja.arrayToString(LICZBA_TESTOWA);
		assertEquals("123456789123456789123456789", liczba);
	}	

	/**
	 * Sprawdzenie czy tablica  zostaje przepisana na tablice podanego wymiaru
	 * czy jest to inna tablica
	 * @throws BlednaLiczbaException 
	 */
	@Test
	public void testWyrownajDlugosc() throws BlednaLiczbaException {
		int[] liczba = Konwersja.wyrownajDlugosc(LICZBA_TESTOWA, 30);
		assertNotSame(LICZBA_TESTOWA, liczba);
	}
	/**
	 * Sprawdzenie czy tablica  zostaje przepisana na tablice podanego wymiaru
	 * sprawdzenie długości
	 * @throws BlednaLiczbaException 
	 */
	@Test
	public void testWyrownajDlugoscLength() throws BlednaLiczbaException {
		int[] liczba = Konwersja.wyrownajDlugosc(LICZBA_TESTOWA, 30);
		assertEquals(30, liczba.length);
	}
	/**
	 * Sprawdzenie czy tablica  zostaje przepisana na tablice odwrotnej kolejnosc
	 *  czy jest to inna tablica
	 * @throws BlednaLiczbaException 
	 */
	@Test
	public void testOdwrocKolejnosc() throws BlednaLiczbaException {
		int[] liczba = Konwersja.odwrocKolejnosc(LICZBA_TESTOWA);
		assertNotSame(LICZBA_TESTOWA, liczba);
	}
	/**
	 * Sprawdzenie czy tablica  zostaje przepisana na tablice odwrotnej kolejnosc
	 * porównanie zawartosci
	 * @throws BlednaLiczbaException 
	 */
	@Test
	public void testOdwrocKolejnosceEq() throws BlednaLiczbaException {
		int[] liczba = Konwersja.odwrocKolejnosc(LICZBA_TESTOWA);
		assertArrayEquals(LICZBA_ODWR, liczba);
	}
}
