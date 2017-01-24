package Kalkulator;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Testy jednostkowe klasy <code>Dzialanie</code>. Sprawdzają poprawność
 * pobierania pobierania danych
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DzialanieTest {
	@Mock
	private Dzialanie mockDzialanie;

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
	public void testGetLiczba() {
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
	 * Test wykonania działania dzielenia przez 0
	 * @throws DzielenikZaDuzyException 
	 */
	@Test
	public void testDzielenie0Exception() throws Dzielenie0Exception, BlednaLiczbaException, DzielenikZaDuzyException {
		when(mockDzialanie.wykonajDzialanie("0", RodzajDzialania.DZIELENIE)).thenThrow(new Dzielenie0Exception());
	}
	/**
	 * Test wykonania działania zbyt duży dzielnik
	 * @throws DzielenikZaDuzyException 
	 */
	@Test
	public void testDzielnikException() throws Dzielenie0Exception, BlednaLiczbaException, DzielenikZaDuzyException {
		when(mockDzialanie.wykonajDzialanie("10000000001", RodzajDzialania.DZIELENIE)).thenThrow(new DzielenikZaDuzyException());
	}
}