package Liczba;

import Kalkulator.BlednaLiczbaException;

public class DuzaLiczba {
	private String liczbaStr;
	private int[] liczbaInt;
	private int dlugosc;
	private Arytmetyka arytmetyka;  

	public DuzaLiczba(String liczbaStr) throws BlednaLiczbaException {
		inicjuj();
		this.liczbaStr = liczbaStr;
		this.liczbaInt = stringToArray();
	}

	private void inicjuj() {
		this.arytmetyka = new Arytmetyka();
	}

	public DuzaLiczba(int[] liczbaInt) throws BlednaLiczbaException {
		inicjuj();
		this.liczbaInt = liczbaInt;
		this.liczbaStr = arytmetyka.arrayToString(liczbaInt);
	}

	public DuzaLiczba() {
		inicjuj();
	}

	public int[] stringToArray() throws BlednaLiczbaException {
		if (this.getDlugosc() < getLiczbaStr().length()) {
			this.setDlugosc(getLiczbaStr().length());
		}
		int[] array = new int[this.getLiczbaStr().length()];
		int[] resultArray = new int[this.getDlugosc()];
		for (int i = 0; i < this.getLiczbaStr().length(); i++) {
			if (Character.isDigit(this.getLiczbaStr().charAt(i))) {
				array[i] = Character.getNumericValue(this.getLiczbaStr().charAt(i));
			} else {
				System.out.println();
				throw new BlednaLiczbaException();
			}
		}
		for (int i = 0; i < this.getDlugosc(); i++) {
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
