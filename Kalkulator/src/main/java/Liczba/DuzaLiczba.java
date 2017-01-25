package Liczba;

import Kalkulator.BlednaLiczbaException;

public class DuzaLiczba {
	public String liczbaStr;
	public int[] liczbaInt;
	public int dlugosc;

	public DuzaLiczba(String liczbaStr) throws BlednaLiczbaException {
		this.liczbaStr = liczbaStr;
		this.dlugosc = liczbaStr.length();
		this.liczbaInt = Konwersja.stringToArray(liczbaStr);
	}

	public DuzaLiczba(int[] liczbaInt) throws BlednaLiczbaException {
		this.liczbaInt = liczbaInt;
		this.dlugosc = liczbaInt.length;
		this.liczbaStr = Konwersja.arrayToString(liczbaInt);
	}

	public DuzaLiczba() {
	}

	public void setLiczbaStr(String liczbaStr) {
		this.liczbaStr = liczbaStr;
		this.dlugosc = liczbaStr.length();
	}

	public String getLiczbaStr() {
		return liczbaStr != null ? liczbaStr : liczbaInt != null ? Konwersja.arrayToString(liczbaInt) : null;
	}

	public void setLiczbaInt(int[] liczbaInt) {
		this.liczbaInt = liczbaInt;
		this.dlugosc = liczbaInt.length;
	}

	public int[] getLiczbaInt() throws BlednaLiczbaException {
		return liczbaInt != null ? liczbaInt : liczbaStr != null ? Konwersja.stringToArray(liczbaStr) : null;
	}

	public int[] getLiczbaIntForDivide() throws BlednaLiczbaException {
		return Konwersja.stringToArrayDivide(liczbaStr);
	}

	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}
	
	public int getDlugosc() {
		return dlugosc;
	}
}
