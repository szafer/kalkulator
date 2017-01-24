package Liczba;

import Kalkulator.BlednaLiczbaException;

public class DuzaLiczba {
	public String liczbaStr;
	public int[] liczbaInt;
	public int dlugosc;

	@SuppressWarnings("static-access")
	public DuzaLiczba(String liczbaStr) throws BlednaLiczbaException {
		this.liczbaStr = liczbaStr;
		this.dlugosc = liczbaStr.length();
		this.liczbaInt = Konwersja.stringToArray(liczbaStr, liczbaStr.length());
	}

	@SuppressWarnings("static-access")
	public DuzaLiczba(int[] liczbaInt) throws BlednaLiczbaException {
		this.liczbaInt = liczbaInt;
		this.liczbaStr = Konwersja.arrayToString(liczbaInt);
	}

	public DuzaLiczba() {
	}

	@SuppressWarnings("static-access")
	public String getLiczbaStr() {
		return liczbaStr != null ? liczbaStr : liczbaInt != null ? Konwersja.arrayToString(liczbaInt) : null;
	}

	public void setLiczbaStr(String liczbaStr) {
		this.liczbaStr = liczbaStr;
	}

	@SuppressWarnings("static-access")
	public int[] getLiczbaInt() throws BlednaLiczbaException {
		return liczbaInt != null ? liczbaInt : liczbaStr != null ? Konwersja.stringToArray(liczbaStr, dlugosc) : null;
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
