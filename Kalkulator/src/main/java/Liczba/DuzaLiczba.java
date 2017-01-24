package Liczba;

import Kalkulator.BlednaLiczbaException;

public class DuzaLiczba {
	private String liczbaStr;
	private int[] liczbaInt;
	private int dlugosc;
	private Arytmetyka arytmetyka;  

	public DuzaLiczba(String liczbaStr) throws BlednaLiczbaException {
		inicjuj();
		setLiczbaStr(liczbaStr);
		setDlugosc(liczbaStr.length());
		this.liczbaInt = stringToArray();
	}

	private void inicjuj() {
		this.arytmetyka = new Arytmetyka();
	}

	public DuzaLiczba(int[] liczbaInt) throws BlednaLiczbaException {
		inicjuj();
		setLiczbaInt(liczbaInt);
		this.liczbaStr = arrayToString(liczbaInt);
	}

	public DuzaLiczba() {
		inicjuj();
	}

	public int[] stringToArray() throws BlednaLiczbaException {
		int dl = this.getDlugosc();
		int dl_str = this.getLiczbaStr().length();
		if (dl < dl_str) {
			dl = dl_str;
		}
		int[] array = new int[dl_str];
		int[] resultArray = new int[dl];
		for (int i = 0; i < dl_str; i++) {
			if (Character.isDigit(this.getLiczbaStr().charAt(i))) {
				array[i] = Character.getNumericValue(this.getLiczbaStr().charAt(i));
			} else {
				System.out.println();
				throw new BlednaLiczbaException();
			}
		}
		for (int i = 0; i < dl; i++) {
			resultArray[i] = (i < array.length ? array[(array.length - 1) - i] : 0);
		}
		return resultArray;
	}
	public String arrayToString(int[] addArray) {
		String add = "";
		boolean firstNonZero = false;
		for (int i = addArray.length - 1; i >= 0; i--) {

			if (!firstNonZero && addArray[i] == 0) {
				continue;
			} else {
				firstNonZero = true;
			}
			add += addArray[i];
		}
		String sumStr = add.length() == 0 ? "0" : add;
		return sumStr;
	}
	public String getLiczbaStr() throws BlednaLiczbaException {
		return strNotNull() ? liczbaStr : intNotNull() ? arrayToString(this.getLiczbaInt()) : null;
	}

	public void setLiczbaStr(String liczbaStr) {
		this.liczbaStr = liczbaStr;
	}

	public int[] getLiczbaInt() throws BlednaLiczbaException {
		return  intNotNull() ? liczbaInt : strNotNull() ? stringToArray() : null;
	}

	private boolean strNotNull() {
		return liczbaStr!= null;
	}

	private boolean intNotNull() {
		return liczbaInt!=null;
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
