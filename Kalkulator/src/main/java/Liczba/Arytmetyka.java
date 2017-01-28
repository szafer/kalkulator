package Liczba;

import Kalkulator.BlednaLiczbaException;
import Kalkulator.Dzielenie0Exception;
import Kalkulator.DzielenikZaDuzyException;

/**
 * Klasa odpowiedzialna za wykonywanie działań arytetycznych
 * 
 * @author HK - MS
 *
 */
public class Arytmetyka {
	final static int BASE = 1000000000;
	final static int BASE_DECIMAL_DIGITS = 9;

	public String add(DuzaLiczba tex, DuzaLiczba text) throws BlednaLiczbaException {
		int length = Math.max(tex.getDlugosc(), text.getDlugosc());
		return add(Konwersja.wyrownajDlugosc(tex.getLiczbaInt(), length),
				Konwersja.wyrownajDlugosc(text.getLiczbaInt(), length));
	}

	public String subtract(DuzaLiczba tex, DuzaLiczba text) throws BlednaLiczbaException {
		int length = Math.max(tex.getDlugosc(), text.getDlugosc());

		if (wiekszaTex(tex, text)) {
			return subtract(Konwersja.wyrownajDlugosc(tex.getLiczbaInt(), length),
					Konwersja.wyrownajDlugosc(text.getLiczbaInt(), length));
		} else {
			return "-" + subtract(Konwersja.wyrownajDlugosc(text.getLiczbaInt(), length),
					Konwersja.wyrownajDlugosc(tex.getLiczbaInt(), length));
		}
	}

	private boolean wiekszaTex(DuzaLiczba tex, DuzaLiczba text) throws BlednaLiczbaException {
		return tex.getDlugosc() > text.getDlugosc() || tex.getDlugosc() > text.getDlugosc() && tex
				.getLiczbaInt()[tex.getLiczbaInt().length - 1] > text.getLiczbaInt()[text.getLiczbaInt().length - 1];
	}

	public String multiply(DuzaLiczba tex, DuzaLiczba text) throws BlednaLiczbaException {
		int length = Math.max(tex.getDlugosc(), text.getDlugosc());
		return multiply(Konwersja.wyrownajDlugosc(tex.getLiczbaInt(), length),
				Konwersja.wyrownajDlugosc(text.getLiczbaInt(), length));
	}

	public String divide(DuzaLiczba d1, DuzaLiczba d2)
			throws BlednaLiczbaException, Dzielenie0Exception, DzielenikZaDuzyException {
		int dzielnik = 1;
		if (d2.getLiczbaInt().length > BASE_DECIMAL_DIGITS) {
			throw new DzielenikZaDuzyException();
		}
		if (d2.getLiczbaInt().length > 0) {
			try {
				dzielnik = Integer.parseInt(Konwersja.arrayToString(d2.getLiczbaInt()));
			} catch (Exception e) {
				throw new BlednaLiczbaException();
			}
		}
		if (dzielnik == 0) {
			throw new Dzielenie0Exception();
		}
		return Konwersja.arrayToString(divide(d1, dzielnik).getLiczbaInt());
	}

	public String add(int[] tablica1, int[] tablica2) {
		int wynik = 0;
		int result[] = new int[tablica1.length + 1];

		for (int i = 0; i < tablica1.length; i++) {
			result[i] = (tablica1[i] + tablica2[i] + wynik) % 10;
			wynik = (tablica1[i] + tablica2[i] + wynik) / 10;
		}
		result[tablica1.length] = wynik;
		return Konwersja.arrayToString(result);
	}

	private int getCyfra(int longint, int index) {
		return Integer.parseInt(Integer.toString(longint).substring(index, index + 1));
	}

	private String subtract(int[] tablica1, int[] tablica2) {
		int brak = 0;
		int sub[] = new int[tablica1.length + 1];

		for (int i = 0; i < tablica1.length; i++) {
			if (tablica1[i] - brak >= tablica2[i]) {
				sub[i] = (tablica1[i] - brak) - tablica2[i];
				brak = 0;
			} else {
				if (i + 1 < tablica1.length){
					sub[i] = (tablica1[i] - brak + 10) - tablica2[i];
					brak = 1;
				} else {
					sub[i] = Math.abs((tablica1[i] - brak) - tablica2[i]);
				}
			}
		}
		return Konwersja.arrayToString(sub);
	}

	private int[] intToArray(int inti, int intiLength, int tabLength) {

		int array[] = new int[tabLength];
		for (int i = 0; i < tabLength; i++) {
			array[i] = (i < intiLength ? getCyfra(inti, intiLength - i - 1) : 0);
		}
		return array;
	}

	private int intLenght(int bigInt) {
		return Integer.toString(bigInt).length();
	}

	public String multiply(int[] tablica1, int[] tablica2) {
		int wynik[] = new int[tablica1.length + tablica2.length];
		for (int i = 0; i < tablica1.length; i++) {
			for (int j = 0; j < tablica2.length; j++) {

				int wyn = tablica1[i] * tablica2[j];
				int wynLength = intLenght(wyn);
				int wynTab[] = intToArray(wyn, wynLength, wynLength);

				for (int k = 0; k < wynTab.length; k++) {
					wynik[i + j + k] += wynTab[k];

					int wartoscBiezaca = wynik[i + j + k];
					if (wartoscBiezaca > 9) {
						wynik[i + j + k] = 0;
						int wartoscBiezacaLength = intLenght(wartoscBiezaca);
						int wartoscBiezacaTab[] = intToArray(wartoscBiezaca, wartoscBiezacaLength,
								wartoscBiezacaLength);
						for (int l = 0; l < wartoscBiezacaTab.length; l++) {
							wynik[i + j + k + l] += wartoscBiezacaTab[l];
						}
					}
				}
			}
		}
		return Konwersja.arrayToString(wynik);
	}

	private int divideCyfra(int[] result, int resultIndex, int dzielna, int ostatniaReszta, int dzielnik) {
		final long BASE_DIV = 10;
		long podziel = dzielna + BASE_DIV * ostatniaReszta;

		long wynik = podziel / dzielnik;
		long rem = podziel % dzielnik;

		result[resultIndex] = (int) wynik;
		return (int) rem;
	}

	private int divideCyfry(int[] result, int resultIndex, int[] dzielna, int dzielnaIndex, int dzielnik) {
		int reszta = 0;
		for (; dzielnaIndex < dzielna.length; dzielnaIndex++, resultIndex++) {
			reszta = divideCyfra(result, resultIndex, dzielna[dzielnaIndex], reszta, dzielnik);
		}
		return reszta;
	}

	private DuzaLiczba divide(DuzaLiczba dzielna, int dzielnik)
			throws Dzielenie0Exception, BlednaLiczbaException, DzielenikZaDuzyException {
		if (dzielnik <= 0) {
			throw new Dzielenie0Exception();
		}

		int[] result = new int[dzielna.getDlugosc()];
		divideCyfry(result, 0, dzielna.getLiczbaIntForDivide(), 0, dzielnik);

		DuzaLiczba liczba = new DuzaLiczba(odwrotny(result));
		return liczba;
	}

	private int[] odwrotny(int[] result) {
		int[] resultArray = new int[result.length];
		for (int i = 0; i < result.length; i++) {
			resultArray[i] = result[(result.length - 1) - i];
		}
		return resultArray;
	}

}
