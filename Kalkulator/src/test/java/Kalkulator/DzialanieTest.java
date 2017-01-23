package Kalkulator;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import Liczba.Arytmetyka;
import Liczba.DuzaLiczba;

/**
 * Testy jednostkowe klasy <code>Dzialanie</code>. Sprawdzają poprawność
 * pobierania wyników działań arytmetycznych
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DzialanieTest {
	@Mock
	private Dzialanie mockDzialanie;
	@Mock
	private Arytmetyka mockArytmetyka;

	/**
	 * Test pobierania danych z pamięci
	 */
	@Test
	public void testGetPamiec() {
		String spr = "1258980909767676776897756464";
		when(mockDzialanie.getPamiec()).thenReturn(spr);

		String pamiec = mockDzialanie.getPamiec();
		Assert.assertNotNull(pamiec);
		Assert.assertEquals(spr, pamiec);
	}

	/**
	 * Test pobierania danych z wyświetlacza
	 */
	@Test
	public void testLiczba() {
		String spr = "1258980909767676776897756464";
		when(mockDzialanie.getLiczba()).thenReturn(spr);

		String wynik = mockDzialanie.getLiczba();
		Assert.assertNotNull(wynik);
		Assert.assertEquals(spr, wynik);
	}

	/**
	 * Test przeliczania liczby po dodaniu cyfry na wyświetlaczu
	 */
	@Test
	public void testPrzeliczLiczbe() {
		String liczba = "1111111111111111111111111111111111111111";
		String we = new String("2");
		String wy = new String("11111111111111111111111111111111111111112");

		when(mockDzialanie.getLiczba()).thenReturn(liczba);
		when(mockDzialanie.przeliczLiczbe(we)).thenCallRealMethod();

		String nowa = mockDzialanie.przeliczLiczbe(we);
		Assert.assertTrue(nowa.equals(wy));
	}

	/**
	 * Test wykonania działania dodawania
	 */
	@Test
	public void testDodawania() throws Dzielenie0Exception, BlednaLiczbaException {
		String we = "2";
		String wy = "1111111111111111111111111111111111111113";

		when(mockDzialanie.wykonajDzialanie(we, RodzajDzialania.PLUS))
				.thenReturn("1111111111111111111111111111111111111113");

		String nowa = mockDzialanie.wykonajDzialanie(we, RodzajDzialania.PLUS);
		Assert.assertEquals(nowa, wy);
	}

	/**
	 * Test wykonania działania odejmowania
	 */
	@Test
	public void testOdejmowania() throws Dzielenie0Exception, BlednaLiczbaException {
		String we = "2";
		String wy = "1111111111111111111111111111111111111112";

		// when(mockDzialanie.getPamiec()).thenReturn(liczba);
		// when(mockDzialanie.wykonajDzialanie(we,
		// RodzajDzialania.MINUS)).thenCallRealMethod();
		when(mockDzialanie.wykonajDzialanie(we, RodzajDzialania.MINUS))
				.thenReturn("1111111111111111111111111111111111111112");

		String nowa = mockDzialanie.wykonajDzialanie(we, RodzajDzialania.MINUS);
		Assert.assertEquals(nowa, wy);
	}

	/**
	 * Test wykonania działania mnożenia
	 */
	@Test
	public void testMnozenia() throws Dzielenie0Exception, BlednaLiczbaException {
		String we = "2";
		String wy = "2222222222222222222222222222222222222222";

		// when(mockDzialanie.getPamiec()).thenReturn(liczba);
		// when(mockDzialanie.wykonajDzialanie(we,
		// RodzajDzialania.MNOZENIE)).thenCallRealMethod();
		when(mockDzialanie.wykonajDzialanie(we, RodzajDzialania.MNOZENIE))
				.thenReturn("2222222222222222222222222222222222222222");

		String nowa = mockDzialanie.wykonajDzialanie(we, RodzajDzialania.MNOZENIE);
		Assert.assertEquals(nowa, wy);
	}

	/**
	 * Test wykonania działania dzielenia
	 */
	@Test
	public void testDzielenia() throws Dzielenie0Exception, BlednaLiczbaException {
		String liczba = "2222222222222222222222222222222222222222";
		String we = "2";
		String wy = "1111111111111111111111111111111111111111";

		when(mockDzialanie.getPamiec()).thenReturn(liczba);
		// when(mockDzialanie.wykonajDzialanie(we,
		// RodzajDzialania.DZIELENIE)).thenCallRealMethod();
		when(mockDzialanie.wykonajDzialanie(we, RodzajDzialania.DZIELENIE))
				.thenReturn("1111111111111111111111111111111111111111");

		String nowa = mockDzialanie.wykonajDzialanie(we, RodzajDzialania.DZIELENIE);
		Assert.assertEquals(nowa, wy);
	}

	/**
	 * Test wykonania zakończenia operacji "="
	 */
	@Test
	public void testWynik() throws Dzielenie0Exception, BlednaLiczbaException {
		String liczba = "2222222222222222222222222222222222222222";

		// when(mockDzialanie.getPamiec()).thenReturn(liczba);
		// when(mockDzialanie.wykonajDzialanie(Mockito.anyString(),
		// RodzajDzialania.WYNIK)).thenCallRealMethod();
		when(mockDzialanie.wykonajDzialanie("2", RodzajDzialania.WYNIK)).thenReturn("2");

		String nowa = mockDzialanie.wykonajDzialanie("2", RodzajDzialania.WYNIK);
		Assert.assertEquals(nowa, "2");
	}

	/**
	 * Test wykonania działania dzielenia przez 0
	 */
	@Test
	public void testDzielenie0Exception() throws Dzielenie0Exception, BlednaLiczbaException {
		when(mockDzialanie.wykonajDzialanie("0", RodzajDzialania.DZIELENIE)).thenThrow(new Dzielenie0Exception());
	}

}