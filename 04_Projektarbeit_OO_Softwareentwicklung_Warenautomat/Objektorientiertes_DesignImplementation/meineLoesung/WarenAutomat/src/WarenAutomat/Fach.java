package WarenAutomat;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;


/**
 * @author Ralph Meier
 */
public class Fach {

	private Boolean istLeer = true;
	public Produkt produkt = null;

	public static void main(String[] args) throws ParseException {
		Fach fachTest = new Fach();
	
		//Teste istLeer
		System.out.println("Fach ist leer: " + fachTest.getIstLeer());
		System.out.println("Fach wird mit einem Produkt gefüllt.");
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMAN);
		Produkt produkt = new Produkt(df.parse("10.06.2010"), 170, "Snickers");
		fachTest.setzeProdukt(produkt);
		System.out.println("Fach ist leer: " + fachTest.getIstLeer());
		System.out.println("Fach wird geleert.");
		fachTest.leeren();
		System.out.println("Fach ist leer: " + fachTest.getIstLeer());
		
	}
	
	public Fach(){
	}

	/**
	 * Ein Fach wird geleert
	 */
	public void leeren(){
		this.istLeer = true;
		this.produkt = null;
	}
	
	/**
	 * Ein Produkt wird in ein Fach gelegt
	 * @param neuesProdukt
	 */
	public void setzeProdukt(Produkt neuesProdukt){
		this.leeren();
		this.produkt = neuesProdukt;
		this.istLeer = false;
	}

	public Produkt gibProdukt(){
		return this.produkt;
	}

	public Boolean getIstLeer(){
		return this.istLeer;
	}

}