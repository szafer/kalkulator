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
	 * Sprawdzenie czy liczba podana w postaci stringa dobrze zamienia się 
	 * na tablicę tej samej dlugosci dla dzielenia
	 * @throws BlednaLiczbaException 
	 */
	@Test
	public void testStringToArrayDiv() throws BlednaLiczbaException {
		int[] liczba = Konwersja.stringToArrayDivide("987654321987654321987654321");
		assertArrayEquals(LICZBA_TESTOWA, liczba);
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

}
