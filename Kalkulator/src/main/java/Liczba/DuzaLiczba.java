package Liczba;

import Kalkulator.BlednaLiczbaException;
/**
 * Klasa DuzaLiczba przechowuje tablice int zawierająca liczby 
 * na których wykonywane są działania matematyczne
 * @author HK - MS
 *
 */
public class DuzaLiczba {
	public int[] liczbaInt;
	public int dlugosc;

	public DuzaLiczba(String liczbaStr) throws BlednaLiczbaException {
		this.dlugosc = liczbaStr.length();
		this.liczbaInt = Konwersja.stringToArray(liczbaStr);
	}

	public DuzaLiczba(int[] liczbaInt) throws BlednaLiczbaException {
		this.liczbaInt = liczbaInt;
		this.dlugosc = liczbaInt.length;
	}

	public DuzaLiczba() {
	}

	public void setLiczbaInt(int[] liczbaInt) {
		this.liczbaInt = liczbaInt;
		this.dlugosc = liczbaInt.length;
	}

	public int[] getLiczbaInt() throws BlednaLiczbaException {
		return liczbaInt;
	}

	public int[] getLiczbaIntForDivide() throws BlednaLiczbaException {
		return Konwersja.odwrocKolejnosc(liczbaInt);
	}

	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}

	public int getDlugosc() {
		return dlugosc;
	}
}
