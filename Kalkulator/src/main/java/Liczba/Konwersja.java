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

	public static int[] stringToArray(String liczbaStr, int dlugosc) throws BlednaLiczbaException {
		if (dlugosc < liczbaStr.length()) {
			dlugosc = liczbaStr.length();
		}
		int[] array = new int[liczbaStr.length()];
		int[] resultArray = new int[dlugosc];
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
		for (int i = 0; i < dlugosc; i++) {
			resultArray[i] = (i < array.length ? array[(array.length - 1) - i] : 0);
		}
		return resultArray;
	}
}