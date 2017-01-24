package Liczba;

import Kalkulator.BlednaLiczbaException;

public class DuzaLiczba {
	private String liczbaStr;
	private int[] liczbaInt;
	private int dlugosc;
	private Arytmetyka arytmetyka;  

	public DuzaLiczba(String init) throws BlednaLiczbaException {
		this.arytmetyka = new Arytmetyka();
		this.liczbaStr = init;
		this.liczbaInt = stringToArray();
	}

	public DuzaLiczba(int[] liczbaInt) throws BlednaLiczbaException {
		this.arytmetyka = new Arytmetyka();
		this.liczbaInt = liczbaInt;
		this.liczbaStr = arytmetyka.arrayToString(liczbaInt);
	}

	public DuzaLiczba() {
		this.arytmetyka = new Arytmetyka();
	}

	public int[] stringToArray() throws BlednaLiczbaException {
		if (getDlugosc() < getLiczbaStr().length()) {
			setDlugosc(getLiczbaStr().length());
		}
		int[] array = new int[liczbaStr.length()];
		int[] resultArray = new int[dlugosc];
		for (int i = 0; i < liczbaStr.length(); i++) {
			if (Character.isDigit(liczbaStr.charAt(i))) {
				array[i] = Character.getNumericValue(liczbaStr.charAt(i));
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
	public String getLiczbaStr() throws BlednaLiczbaException {
		return liczbaStr!=null ? liczbaStr : liczbaInt!=null ? arytmetyka.arrayToString(this.getLiczbaInt()) : null;
	}

	public void setLiczbaStr(String liczbaStr) {
		this.liczbaStr = liczbaStr;
	}

	public int[] getLiczbaInt() throws BlednaLiczbaException {
		return  liczbaInt!=null ? liczbaInt : liczbaStr!= null ? stringToArray() : null;
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
