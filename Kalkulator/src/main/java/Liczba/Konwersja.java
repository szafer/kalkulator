package Liczba;

import Kalkulator.BlednaLiczbaException;
/**
 *  Klasa odpowiedzialna za konwertowanie stringa na tab i odwrotnie
 * @author HK MS
 *
 */
public class Konwersja {

	public static String arrayToString(int[] liczbaInt) {
		String result = "";
		boolean firstNonZero = false;
		for (int i = liczbaInt.length - 1; i >= 0; i--) {
			if (!firstNonZero && liczbaInt[i] == 0) {
				continue;
			} else {
				firstNonZero = true;
			}
			result += liczbaInt[i];

		}
		return result.length() == 0 ? "0" : result;
	}

	public static int[] stringToArray(String liczbaStr, int dlugosc) throws BlednaLiczbaException {
		int[] wynikTab = new int[dlugosc];
		if (dlugosc < liczbaStr.length()) {
			dlugosc = liczbaStr.length();
		}
		int[] tab = new int[liczbaStr.length()];
		for (int i = 0, n = liczbaStr.length(); i < n; i++) {
			if (Character.isDigit(liczbaStr.charAt(i))) {
				tab[i] = Character.getNumericValue(liczbaStr.charAt(i));;
			} else {
				throw new BlednaLiczbaException();
			}
		}
		for (int i = 0; i < dlugosc; i++) {
			wynikTab[i] = (i < tab.length ? tab[(tab.length - 1) - i] : 0);
		}
		return wynikTab;
	}

	public static int[] odwrocKolejnosc(int[] liczbaInt) {
		int[] wynikTab = new int[liczbaInt.length];
		for (int i = 0; i < liczbaInt.length; i++) {
			wynikTab[i] = (i < liczbaInt.length ? liczbaInt[(liczbaInt.length - 1) - i] : 0);
		}
		return wynikTab;
	}

	public static int[] stringToArray(String liczbaStr) throws BlednaLiczbaException {
		return stringToArray(liczbaStr, liczbaStr.length());
	}

	public static int[] wyrownajDlugosc(int[] liczbaInt, int dlugosc) {
		int[] wynikTab = new int[dlugosc];
		 
		for (int i = 0; i < dlugosc; i++) {
			wynikTab[i] = (i < liczbaInt.length ? liczbaInt[i] : 0);
		}
		return wynikTab;
	}
}