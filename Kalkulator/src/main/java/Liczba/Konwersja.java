package Liczba;

import Kalkulator.BlednaLiczbaException;

public class Konwersja {

	public static String arrayToString(int[] liczbaInt) {
		String add = "";
		boolean firstNonZero = false;
		for (int i = liczbaInt.length - 1; i >= 0; i--) {

			if (!firstNonZero && liczbaInt[i] == 0) {
				continue;
			} else {
				firstNonZero = true;
			}
			add += liczbaInt[i];

		}
		String sumStr = add.length() == 0 ? "0" : add;
		return sumStr;
	}

	private static int[] konwertuj(String liczbaStr, int dlugosc) throws BlednaLiczbaException {
		if (dlugosc < liczbaStr.length()) {
			dlugosc = liczbaStr.length();
		}
		int[] array = new int[liczbaStr.length()];
		for (int i = 0, n = liczbaStr.length(); i < n; i++) {
			char c = liczbaStr.charAt(i);
			if (Character.isDigit(c)) {
				int digit = Character.getNumericValue(c);
				array[i] = digit;
			} else {
				System.out.println();
				throw new BlednaLiczbaException();
			}
		}

		return array;
	}
	public static int[] stringToArray(String liczbaStr, int dlugosc) throws BlednaLiczbaException {
		int[] resultArray = new int[dlugosc];
		int[] array = konwertuj(liczbaStr, dlugosc);
		for (int i = 0; i < dlugosc; i++) {
			resultArray[i] = (i < array.length ? array[(array.length - 1) - i] : 0);
		}
		return resultArray;
	}

	public static int[] odwrocKolejnosc(int[] liczbaInt) {
		int[] resultArray = new int[liczbaInt.length];
		for (int i = 0; i < liczbaInt.length; i++) {
			resultArray[i] = (i < liczbaInt.length ? liczbaInt[(liczbaInt.length - 1) - i] : 0);
		}
		return resultArray;
	}

	public static int[] stringToArray(String liczbaStr) throws BlednaLiczbaException {
		return stringToArray(liczbaStr, liczbaStr.length());
	}

	public static int[] wyrownajDlugosc(int[] liczbaInt, int dlugosc) {
		int[] resultArray = new int[dlugosc];
		 
		for (int i = 0; i < dlugosc; i++) {
			resultArray[i] = (i < liczbaInt.length ? liczbaInt[i] : 0);
		}
		return resultArray;
	}
}