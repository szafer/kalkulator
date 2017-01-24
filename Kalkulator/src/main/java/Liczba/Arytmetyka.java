package Liczba;

import Kalkulator.BlednaLiczbaException;
import Kalkulator.Dzielenie0Exception;
import Kalkulator.DzielenikZaDuzyException;

public class Arytmetyka {
	final static int BASE = 1000000000;
	final static int BASE_DECIMAL_DIGITS = 9;

	private int intLenght(int bigInt) {
		return Integer.toString(bigInt).length();
	}

	public String add(int[] array1, int[] array2) {
		int carry = 0;
		int addArray[] = new int[array1.length + 1];

		for (int i = 0; i < array1.length; i++) {
			addArray[i] = (array1[i] + array2[i] + carry) % 10;
			carry = (array1[i] + array2[i] + carry) / 10;
		}
		addArray[array1.length] = carry;
		return Konwersja.arrayToString(addArray);
	}

	private int getDigitAtIndex(int longint, int index) {
		return Integer.parseInt(Integer.toString(longint).substring(index, index + 1));
	}

	

	public String sub(int[] array1, int[] array2) {
		int carry = 0;
		int sub[] = new int[array1.length + 1];

		for (int i = 0; i < array1.length; i++) {
			sub[i] = (array1[i] - array2[i] + carry) % 10; // sum digits +
															// carry; then
															// extract last
															// digit
			carry = (array1[i] - array2[i] + carry) / 10; // Compute carry
		}
		sub[array1.length] = carry;
		return Konwersja.arrayToString(sub);
	}

	private int[] intToArray(int bigInt, int bigIntLength, int arrayLength) {

		int array[] = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			array[i] = (i < bigIntLength ? getDigitAtIndex(bigInt, bigIntLength - i - 1) : 0);
		}
		return array;
	}

	public String multiply(int[] array1, int[] array2) {
		int product[] = new int[array1.length + array2.length];
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {

				int prod = array1[i] * array2[j];
				int prodLength = intLenght(prod);
				int prodAsArray[] = intToArray(prod, prodLength, prodLength);

				for (int k = 0; k < prodAsArray.length; k++) {
					product[i + j + k] += prodAsArray[k];

					int currentValue = product[i + j + k];
					if (currentValue > 9) {
						product[i + j + k] = 0;
						int curValueLength = intLenght(currentValue);
						int curValueAsArray[] = intToArray(currentValue, curValueLength, curValueLength);
						for (int l = 0; l < curValueAsArray.length; l++) {
							product[i + j + k + l] += curValueAsArray[l];
						}
					}
				}
			}
		}
		return Konwersja.arrayToString(product);
	}

	public String check(String bigInt1, String bigInt2) {
		int difference;
		StringBuilder first = new StringBuilder(bigInt1);
		StringBuilder second = new StringBuilder(bigInt2);

		if (bigInt1.length() > bigInt2.length()) {
			difference = bigInt1.length() - bigInt2.length();
			for (int x = difference; x > 0; x--) {
				second.insert(0, "0");

			}
			bigInt2 = second.toString();
			return bigInt2;

		} else {
			difference = bigInt2.length() - bigInt1.length();
			for (int x = difference; x > 0; x--) {
				first.insert(0, "0");
			}
			bigInt1 = first.toString();
			return bigInt1;
		}
	}

	public String add(DuzaLiczba tex, DuzaLiczba text) throws BlednaLiczbaException {
		int length = Math.max(tex.getLiczbaStr().length(), text.getLiczbaStr().length());

		tex.setDlugosc(length);
		text.setDlugosc(length);
		return add(Konwersja.stringToArray(tex.getLiczbaStr(), length), 
				   Konwersja.stringToArray(text.getLiczbaStr(), length));
	}

	public String subtract(DuzaLiczba tex, DuzaLiczba text) throws BlednaLiczbaException {
		int length = Math.max(tex.getLiczbaStr().length(), text.getLiczbaStr().length());
		tex.setDlugosc(length);
		text.setDlugosc(length);
		return sub(Konwersja.stringToArray(tex.getLiczbaStr(), length), 
				   Konwersja.stringToArray(text.getLiczbaStr(), length));
	}

	public String multiply(DuzaLiczba tex, DuzaLiczba text) throws BlednaLiczbaException {
		int length = Math.max(tex.getLiczbaStr().length(), text.getLiczbaStr().length());
		tex.setDlugosc(length);
		text.setDlugosc(length);
		return multiply(Konwersja.stringToArray(tex.getLiczbaStr(), length), 
						Konwersja.stringToArray(text.getLiczbaStr(), length));
	}

	public int divide(int bigInt1, int bigInt2) throws Dzielenie0Exception {
		if (bigInt2 == 0) {
			throw new Dzielenie0Exception();
		}
		int sign = 1;
		if (bigInt1 < 0) {
			bigInt1 = -bigInt1;
			sign = -sign;
		}
		if (bigInt2 < 0) {
			bigInt2 = -bigInt2;
			sign = -sign;

		}
		int result = 0;
		while (bigInt1 >= 0) {
			bigInt1 -= bigInt2;
			result++;
		}
		return (result - 1) * sign;
	}

	private int divideDigit(int[] result, int resultIndex, int divident, int lastRemainder, int divisor) {
		assert divisor < BASE;
		assert lastRemainder < divisor;

		long ent = divident + (long) BASE * lastRemainder;

		long quot = ent / divisor;
		long rem = ent % divisor;

		assert quot < BASE;
		assert rem < divisor;

		result[resultIndex] = (int) quot;
		return (int) rem;
	}

	private int divideDigits(int[] result, int resultIndex, int[] divident, int dividentIndex, int divisor) {
		int remainder = 0;
		for (; dividentIndex < divident.length; dividentIndex++, resultIndex++) {
			remainder = divideDigit(result, resultIndex, divident[dividentIndex], remainder, divisor);
		}
		return remainder;
	}
	
	public DuzaLiczba divide(DuzaLiczba number, int divisor) throws Dzielenie0Exception, BlednaLiczbaException, DzielenikZaDuzyException
	{
	    if(divisor <= 0 ) {
	        throw new Dzielenie0Exception();
	    }
	    if( BASE <= divisor) {
	        throw new DzielenikZaDuzyException();
	    }
	    int[] result = new int[number.getDlugosc()];
	    divideDigits(result, 0,
	    		     number.getLiczbaInt(), 0,
	                 divisor);
	    DuzaLiczba bigNumber = new DuzaLiczba(result);
	    return bigNumber;	    
	}

	public String divide(DuzaLiczba d1, String dzielnikStr) throws BlednaLiczbaException, Dzielenie0Exception, DzielenikZaDuzyException {
		int  dzielnik = 1;
		;
		if (dzielnikStr.length() > 0) {
			try {
				dzielnik = Integer.parseInt(dzielnikStr);
			} catch (Exception e) {
				throw new BlednaLiczbaException();
			}
		}
		return divide(d1, dzielnik).getLiczbaStr();
	}
}
