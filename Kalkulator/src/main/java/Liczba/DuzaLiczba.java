package Liczba;

import Kalkulator.BlednaLiczbaException;

public class DuzaLiczba {
	private String liczbaStr;
	private int[] liczbaInt;
	private int dlugosc;

	public DuzaLiczba(String init) throws BlednaLiczbaException {
		this.liczbaStr = init;
		liczbaInt = stringToArray();
	}

	public DuzaLiczba(int[] liczbaInt) throws BlednaLiczbaException {
		this.liczbaInt = liczbaInt;
		liczbaStr = arrayToString();
	}

	public DuzaLiczba() {
	}


	public  String arrayToString() {
		String add = "";
		boolean firstNonZero = false;
		for (int i = liczbaInt.length - 1; i >= 0; i--) {

			if (!firstNonZero && (liczbaInt[i] == 0)) {
				continue;
			} else {
				firstNonZero = true;
			}
			add += liczbaInt[i];

		}
		String sumStr = add.length() == 0 ? "0" : add;
		return sumStr;
	}

	public String getLiczbaStr() {
		return liczbaStr!=null ? liczbaStr : liczbaInt!=null ? arrayToString(): null;
	}

	public void setLiczbaStr(String liczbaStr) {
		this.liczbaStr = liczbaStr;
	}

	public int[] getLiczbaInt() throws BlednaLiczbaException {
		return  liczbaInt!=null ? liczbaInt : liczbaStr!=null ? stringToArray(): null;
	}
	

	public int[] stringToArray() throws BlednaLiczbaException {
		if (dlugosc < liczbaStr.length()) {
			dlugosc = liczbaStr.length();
		}
		int[] array = new int[liczbaStr.length()];
		int[] resultArray = new int[dlugosc];
		for (int i = 0, n = liczbaStr.length(); i < n; i++) {
			if (Character.isDigit(liczbaStr.charAt(i))) {
				int digit = Character.getNumericValue(liczbaStr.charAt(i));
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

	public void setLiczbaInt(int[] liczbaInt) {
		this.liczbaInt = liczbaInt;
	}

	public int getDlugosc() {
		return dlugosc;
	}

	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}

}
