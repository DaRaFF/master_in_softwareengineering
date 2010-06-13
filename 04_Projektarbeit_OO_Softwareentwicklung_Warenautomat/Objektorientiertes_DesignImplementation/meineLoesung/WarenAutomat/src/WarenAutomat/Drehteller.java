package WarenAutomat;

import WarenAutomat.SystemSoftware;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * @author Ralph Meier
 */
public class Drehteller {

	private final static int ANZ_FAECHER = 16;
	private int aktuelleFachNr;
	private int drehtellerNr;
	private Fach[] faecher = new Fach[Drehteller.ANZ_FAECHER];

	public static void main(String[] args) throws ParseException {
		//init drehtellerTest
		Drehteller drehtellerTest = new Drehteller(1);
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMAN);
		
		//Teste Fach Nr nach dem drehen
		for (int i = 0; i < Drehteller.ANZ_FAECHER; i++) {
			System.out.println("Aktuelles Fach Nr sollte " + (i+1) + " sein: FachNr = " + drehtellerTest.getAktuelleFachNr());
			drehtellerTest.drehen();
		}
		System.out.println("Aktuelles Fach Nr sollte 1 sein: FachNr = " + drehtellerTest.getAktuelleFachNr());
		
		//Teste aktualisiereAnzeigeVerfallsDatum
		System.out.println("\nAktuelles Datum auf 11.06.2010 setzen.");
		SystemSoftware.setzeAktuellesDatum(df.parse("11.06.2010"));
		System.out.println("HW-Display Lampenstatus 0 = leeres Fach.");
		System.out.println("HW-Display Lampenstatus 1 = Produkt nicht abgelaufen.");
		System.out.println("HW-Display Lampenstatus 2 = Produkt abgelaufen.");
		System.out.println("Fach leeren.");
		drehtellerTest.getAktuellesFach().leeren();
		drehtellerTest.aktualisiereAnzeigeVerfallsDatum();		
		System.out.println("Produkt erzeugen, welches am 12.06.2010 abgelaufen ist.");
		Produkt produkt2 = new Produkt(df.parse("12.06.2010"), 170, "Snickers");
		drehtellerTest.fuelleAktuellesFach(produkt2);
		drehtellerTest.aktualisiereAnzeigeVerfallsDatum();		
		System.out.println("Produkt erzeugen, welches am 10.06.2010 abgelaufen ist.");
		Produkt produkt1 = new Produkt(df.parse("10.06.2010"), 170, "Snickers");
		drehtellerTest.fuelleAktuellesFach(produkt1);
		drehtellerTest.aktualisiereAnzeigeVerfallsDatum();	
		
		//Teste aktualisiereAnzeigeWarenpreis
		System.out.println("\nFach leeren.");
		drehtellerTest.getAktuellesFach().leeren();
		drehtellerTest.aktualisiereAnzeigeWarenpreis();
		System.out.println("Produkt erzeugen, welches 1.70 Franken kostet.");
		Produkt produkt3 = new Produkt(df.parse("12.06.2010"), 170, "Snickers");
		drehtellerTest.fuelleAktuellesFach(produkt3);
		drehtellerTest.aktualisiereAnzeigeWarenpreis();
	}
	

	public Drehteller(int drehtellerNr){
		this.setAktuelleFachNr(1);
		this.setDrehtellerNr(drehtellerNr);
		for (int i = 0; i < this.faecher.length; i++) {
			this.faecher[i] = new Fach();
		}
	}

	/**
	 * Drehteller drehen
	 */
	public void drehen(){
		if(this.getAktuelleFachNr() == Drehteller.ANZ_FAECHER){
			this.setAktuelleFachNr(1);
		}
		else{
			this.setAktuelleFachNr(this.getAktuelleFachNr()+1);
		}
		this.aktualisiereAnzeigeVerfallsDatum();
		this.aktualisiereAnzeigeWarenpreis();
	}

	/**
	 * Aktuelles Fach mit einem Produkt füllen
	 * @param neuesProdukt
	 */
	public void fuelleAktuellesFach(Produkt neuesProdukt){
		this.getAktuellesFach().setzeProdukt(neuesProdukt);
		this.aktualisiereAnzeigeVerfallsDatum();
		this.aktualisiereAnzeigeWarenpreis();
	}
	
	/**
	 * Prüft, ob das aktuelle Fach des Drehtellers leer ist
	 * @return
	 */
	public Boolean pruefeFachLeer(){
		Boolean fachLeer = this.getAktuellesFach().getIstLeer();
		return fachLeer;
	}
	
	/**
	 * Prüft ob ein Produkt abgelaufen ist
	 * @return true = abgelaufen / false = nicht abgelaufen
	 */
	public Boolean pruefeProduktAbgelaufen(){
		Date aktuellesDatum = SystemSoftware.gibAktuellesDatum();
		return this.getAktuellesFach().gibProdukt().istAbgelaufen(aktuellesDatum);
	}
	
	/**
	 * Das aktuelle Fach des Drehtellers wird zurückgegeben
	 * @return
	 */
	public Fach getAktuellesFach(){
		Fach aktuellesFach = this.faecher[this.getAktuelleFachNr()-1];
		return aktuellesFach;
	}
	
	/**
	 * Öffnet den Drehteller
	 */
	public void oeffnen(){
		this.verkaufeAktuellesProdukt();
		this.aktualisiereAnzeigeVerfallsDatum();
		this.aktualisiereAnzeigeWarenpreis();
	}
	
	/**
	 * Das aktuelle Produkt im aktuellen Fach wird verkauft
	 */
	private void verkaufeAktuellesProdukt(){
		this.getAktuellesFach().gibProdukt().verkaufen();
		this.getAktuellesFach().leeren();
	}
	
	/**
	 * Aktualisiert die Verfallsdatumanzeige vom Drehteller
	 */
	private void aktualisiereAnzeigeVerfallsDatum(){
		if(this.pruefeFachLeer()){
			SystemSoftware.zeigeVerfallsDatum(this.getDrehtellerNr(), 0);
		}
		else{
			Boolean produktAbgelaufen = this.pruefeProduktAbgelaufen();
			if(produktAbgelaufen){
				SystemSoftware.zeigeVerfallsDatum(this.getDrehtellerNr(), 2);
			}
			else{
				SystemSoftware.zeigeVerfallsDatum(this.getDrehtellerNr(), 1);
			}
		}
		this.aktualisiereWareGui();
	}
	
	/**
	 * Anzeige Warenpreis in der Hardware wird aktualisiert
	 */
	private void aktualisiereAnzeigeWarenpreis(){
		if(this.pruefeFachLeer()){
			SystemSoftware.zeigeWarenPreisAn(this.getDrehtellerNr(), 0.00);
		}
		else{
			double warenPreis = this.getAktuellesFach().gibProdukt().getPreisInFranken();
			SystemSoftware.zeigeWarenPreisAn(this.getDrehtellerNr(), warenPreis);
		}	
		this.aktualisiereWareGui();
	}
	
	/**
	 * Anzeige Ware in der Hardware wird aktualisiert
	 */
	private void aktualisiereWareGui(){
		if(this.pruefeFachLeer()){
			SystemSoftware.zeigeWareInGui(this.getDrehtellerNr(), "", null);
		}
		else{
			String aktuellerWarenname = this.getAktuellesFach().gibProdukt().gibWarenname();
			Date aktuellesVerfallsdatum = this.getAktuellesFach().gibProdukt().getVerfallsDatum();
			SystemSoftware.zeigeWareInGui(this.getDrehtellerNr(), aktuellerWarenname, aktuellesVerfallsdatum);
		}		
	}


	private int getAktuelleFachNr() {
		return this.aktuelleFachNr;
	}
	
	private void setAktuelleFachNr(int fachNr) {
		this.aktuelleFachNr = fachNr;
	}
	
	private int getDrehtellerNr(){
		return this.drehtellerNr;
	}
	
	private void setDrehtellerNr(int drehtellerNr) {
		this.drehtellerNr = drehtellerNr;
	}

}