package Kalkulator;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Testy jednostkowe klasy <code>KalkulatorPanel</code>. Sprawdzają poprawność
 * wyświetlanych
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class KalkulatorPanelTest {
	@Mock
	private Dzialanie mockDzialanie;
	/**
	 * Test wyświetlania komunikatu o błedzie dzielenia przez 0
	 */
	@Test
	public void testKomunikat1() {
		KalkulatorPanel panel = new KalkulatorPanel();
		panel.komunikatBl0();
		Assert.assertEquals("Nie można dzielić przez 0", panel.getLbKomunikat().getText());
	}

	/**
	 * Test wyświetlania komunikatu o błednej liczbie
	 */
	@Test
	public void testKomunikat2() {
		KalkulatorPanel panel = new KalkulatorPanel();
		panel.komunikatBl();
		Assert.assertEquals("W celu wykonania działania podaj liczbę całkowitą", panel.getLbKomunikat().getText());
	}
	/**
	 * Test braku wyświetlania komunikatu dla zerowej pamięci
	 */
	@Test
	public void testKomunikat3() {
		when(mockDzialanie.getPamiec()).thenReturn("0");
		KalkulatorPanel panel = new KalkulatorPanel();
		panel.komunikat();
		Assert.assertEquals("", panel.getLbKomunikat().getText());
	}
	/**
	 * Test braku wyświetlania komunikatu dla niezerowej pamięci
	 */
	@Test
	public void testKomunikat4() {
//		KalkulatorPanel panel = new KalkulatorPanel();
//		when(mockDzialanie.getPamiec()).thenReturn("555");
//		panel.komunikat();
//		Assert.assertEquals("W pamięci:   555", panel.getLbKomunikat().getText());
	}
}