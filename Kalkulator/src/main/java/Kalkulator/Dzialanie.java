package Kalkulator;

import Liczba.Arytmetyka;
import Liczba.DuzaLiczba;

public class Dzialanie {
	private String pamiec = new String("0");
	private String liczba = new String("0");

	private RodzajDzialania operacja = RodzajDzialania.WYNIK;
	private Arytmetyka arytmetyka = new Arytmetyka();
	public Dzialanie() {
	}

	public void run(String text, RodzajDzialania operacja) throws BlednaLiczbaException, Dzielenie0Exception, DzielenikZaDuzyException {
		if (operacja ==RodzajDzialania.CANCEL){ 
			pamiec = new String("0");
		} else{
			pamiec = wykonajDzialanie(text, this.operacja);
		}
		this.operacja = operacja;
		liczba = new String("0");
	}

	public String wykonajDzialanie(String text, RodzajDzialania oper) throws Dzielenie0Exception, BlednaLiczbaException, DzielenikZaDuzyException {
		String wynik = text;
		DuzaLiczba d1 = new DuzaLiczba(getPamiec());
		DuzaLiczba d2 = new DuzaLiczba(text);

		if (oper ==RodzajDzialania.PLUS){
			wynik = arytmetyka.add(d1,  d2);
		} 	else if (oper ==RodzajDzialania.MINUS){
			wynik = arytmetyka.subtract(d1,  d2);
		} else if (oper ==RodzajDzialania.MNOZENIE){
			wynik = arytmetyka.multiply(d1,  d2);
		} else if (oper ==RodzajDzialania.DZIELENIE){
			wynik = arytmetyka.divide(d1,  d2.getLiczbaStr());
		} 
		return wynik;
	}

	public String przeliczLiczbe(String text) {
		if (getLiczba().equals("0")){
			liczba = text;
		} else {
			liczba = getLiczba() +text;
		}
		return liczba;
	}
	public String getPamiec() {
		return pamiec.toString();
	}
	public void setPamiec(String string) {
		pamiec = new String(string);
	}

	public String getLiczba() {
		return liczba;
	}

	public RodzajDzialania getOperacja() {
		return operacja;
	}

	public Arytmetyka getArytmetyka() {
		return arytmetyka;
	}

	public void setArytmetyka(Arytmetyka arytmetyka) {
		this.arytmetyka = arytmetyka;
	}	
	
}
