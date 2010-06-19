
package WarenAutomat;

import java.text.ParseException;
import java.util.Date;
import java.util.Vector;


/**
   Der Automat besteht aus 7 Drehtellern welche wiederum je aus 16 Fächer bestehen.
   Der erste Drehteller und das jeweils erste Fach haben jeweils die Nummer 1 (nicht 0!).
   Im weitern hat der Automat eine Kasse.
   Diese wird vom Automaten instanziert.
   @author Ralph Meier
 */
public class Automat {
	private final static int ANZ_DREHTELLER = 7;
    private Drehteller[] drehteller = new Drehteller[Automat.ANZ_DREHTELLER];
    private Kasse mKasse;
    private Warenbestand warenbestand;
    private Vector<Bestellung> bestellung = new Vector<Bestellung>();
    
	public static void main(String[] args) throws ParseException {
		// Teste konfiguration Bestellung
		Automat automat = new Automat();
		automat.konfiguriereBestellung("Fanta", 5, 10);
		automat.konfiguriereBestellung("Cola", 2, 5);
		automat.konfiguriereBestellung("Sprite", 2, 5);
		automat.konfiguriereBestellung("Snickers", 2, 5);
		automat.konfiguriereBestellung("Fanta", 11, 11);
		
		for (int i = 0; i < automat.bestellung.size(); i++) {
			String warenname = automat.bestellung.get(i).getWarenname();
			int grenze = automat.bestellung.get(i).getGrenze();
			int bestellungAnzahl = automat.bestellung.get(i).getBestellungAnzahl();
			System.out.println("Produkt: " + warenname + " | Grenze: " + grenze + " | Bestellung Anzahl: " + bestellungAnzahl);
		}
		
	}
    
    /**
       Default-Konstruktor.
       @roseuid 3B0F474603AE
     */
    public Automat() {
		for (int i = 0; i < drehteller.length; i++) {
			this.drehteller[i] = new Drehteller(i+1);
		}
		this.mKasse = new Kasse();
		this.warenbestand = new Warenbestand(this);
    }
   
    /**
       Füllt ein Fach mit Ware.
       Wenn das Service-Personal den Automaten füllt, wird mit einem Bar-Code-Leser zuerst die Ware gescannt.
       Daraufhin wird die Schiebe-Tür geöffnet.
       Das Service-Person legt die neue Ware ins Fach und schliesst das Fach.
       Die Hardware resp. System-Software ruft die Methode Automat.fuelleFach() auf.
       Die Adressierung der Drehteller und Faecher beginnt bei 1 (nicht 0!).
       @roseuid 3B076F5F0325
     */
    public void fuelleFach(int pDrehtellerNr, String pWarenName, double pPreis, Date pVerfallsDatum) {
    	if(!this.getDrehteller(pDrehtellerNr).pruefeFachLeer()){
    		Produkt altesProdukt = this.getDrehteller(pDrehtellerNr).getAktuellesFach().gibProdukt();
    		this.gibWarenbestand().produktEntfernen(altesProdukt);
    	}
    	Produkt neuesProdukt = new Produkt(pVerfallsDatum, this.gibKasse().gibRappen(pPreis), pWarenName);
    	Drehteller aktuellerDrehteller = this.getDrehteller(pDrehtellerNr);
    	aktuellerDrehteller.fuelleAktuellesFach(neuesProdukt);
    	this.gibWarenbestand().produktHinzufuegen(neuesProdukt);
    }
    
    /**
       Gibt die Objekt-Referenz auf die Kasse zurück.
       @roseuid 3B0BD09C0382
     */
    public Kasse gibKasse() {
      return mKasse;
    }
    
    /**
       Wird von der System-Software jedesmal aufgerufen wenn der gelbe Dreh-Knopf gedrückt wird.
       Die Applikations-Software führt die Drehteller-Anzeigen nach (Warenpreis, Verfallsdatum).
       Das Ansteuern des Drehteller-Motors übernimmt hat die System-Software  (muss nicht von der Applikations-Software gesteuert werden.).
       Die System-Software stellt sicher, dass 'drehen' nicht durchgeführt wird wenn ein Fach offen ist.
       @roseuid 3B0BD112002F
     */
    public void drehen() {
    	SystemSoftware.dreheWarenInGui();
    	for (int i = 0; i < this.drehteller.length; i++) {
    		this.getDrehteller(i+1).drehen();
    	}      
    }
    
    /**
       Beim Versuch eine Schiebetüre  zu öffnen ruft die System-Software die Methode oeffnen() der Klasse  'Automat' mit Parameter Drehteller-Nummer auf.
       Es wird überprüft ob alles o.k. ist:
       - Fach nicht leer
       - Verfalls-Datum noch nicht erreicht
       - genug Geld eingeworfen
       - genug Wechselgeld vorhanden
       Wenn nicht genug Geld  eingeworfen wurde wird dies mit SystemSoftware.zeigeZuWenigGeldAn() signalisiert.
       Wenn nicht genug Wechselgeld vorhanden ist wird dies mit SystemSoftware.zeigeZuWenigWechselGeldAn() signalisiert.
       Wenn o.k. wird entriegelt (SystemSoftware.entriegeln()) und positives Resultat, sonst negatives Resultat.
       Es wird von der System-Software sichergestellt, dass zu einem bestimmten Zeitpunkt nur eine Schiebetüre offen sein kann.
       @roseuid 3B0BD3CE0198
     */
    public boolean oeffnen(int pDrehtellerNr) {
    	Boolean oeffnenOk = true;
    	Boolean fachLeer = this.getDrehteller(pDrehtellerNr).pruefeFachLeer();
    	
    	//test Fach leer
    	if(fachLeer){
    		oeffnenOk &= false;
    	}
    	//test Produkt abgelaufen
    	if(oeffnenOk){
    		Boolean produktNichtAbgelaufen = !this.getDrehteller(pDrehtellerNr).pruefeProduktAbgelaufen(); 
    		oeffnenOk &= produktNichtAbgelaufen;
    	}
    	//test Genug Geld eingeworfen / Test Wechselgeld vorhanden
    	if(oeffnenOk){
    		int eingeworfenerBetragInRappen = this.gibKasse().getEingeworfenerBetragInRappen();
    		int warenwertInRappen = this.getDrehteller(pDrehtellerNr).getAktuellesFach().gibProdukt().getPreisInRappen();
    		if(eingeworfenerBetragInRappen < warenwertInRappen){
    			oeffnenOk &= false;
    			SystemSoftware.zeigeZuWenigGeldAn();
    		}
    		Boolean istWechselgeldMoeglich = this.gibKasse().istWechselgeldMoeglich(eingeworfenerBetragInRappen - warenwertInRappen);
    		if(!istWechselgeldMoeglich){
    			oeffnenOk &= false;
    			SystemSoftware.zeigeZuWenigWechselGeldAn();
    		}
    	}

    	//alle Tests ok
    	if(oeffnenOk){
    		SystemSoftware.entriegeln(pDrehtellerNr);
    		Produkt verkauftesProdukt = this.getDrehteller(pDrehtellerNr).getAktuellesFach().gibProdukt();
    		int produktPreis = verkauftesProdukt.getPreisInRappen();
    		this.gibKasse().verkaufen(produktPreis);
    		this.getDrehteller(pDrehtellerNr).oeffnen();
    		this.gibKasse().gibWechselGeld();
    		wareBestellen(verkauftesProdukt);
    		
    	}
    	return oeffnenOk;
    }
    
    /**
     * Bestellt eine Ware nach, wenn die Grenze der Anzahl einer Ware erreicht ist
     * @param verkauftesProdukt
     * @return
     */
    public Boolean wareBestellen(Produkt verkauftesProdukt) {
		Boolean wareBestellen = false;
		String produktName = verkauftesProdukt.gibWarenname();
		Bestellung bestellungZuProdukt = this.getBestellung(produktName);
		if(bestellungZuProdukt != null){
			int grenze = bestellungZuProdukt.getGrenze();
			int warenBestandAktuellesProdukt = this.gibWarenbestand().getAnzahlWaren(produktName);
			if(grenze >= warenBestandAktuellesProdukt){
				wareBestellen = true;
			}
		}
		
		if(wareBestellen){
			int anzahlNachbestellen = bestellungZuProdukt.getBestellungAnzahl();
			SystemSoftware.bestellen(produktName, anzahlNachbestellen);
		}
		
		return wareBestellen;
	}

	/**
       Gibt den aktuellen Wert aller im Automaten enthaltenen Waren in Franken zurück (excl. abgelaufene Waren).
       Analyse: 
       Abgeleitetes Attribut
       @roseuid 3B0F58B30045
     */
    public double gibTotalenWarenWert() {
      return this.gibWarenbestand().gibTotalWarenWert();
    }
    
    /**
       Gibt die Anzahl der verkauften Ware 'pName' seit (>=) 'pDatum' als Zahl zurück.
       @roseuid 40C3937A0382
     */
    public int gibVerkaufsStatistik(String pName, Date pDatum) {
      return this.gibWarenbestand().gibVerkaufsStatistik(pName, pDatum);
    }

	public Drehteller getDrehteller(int drehtellerNr) {
		return this.drehteller[drehtellerNr-1];
	}
	
	public Warenbestand gibWarenbestand(){
		return this.warenbestand;
	}
	
    /**
    Konfiguration einer automatischen Bestellung.
    Der Automat setzt automatisch Bestellungen ab mittels 
    SystemSoftware.bestellen() wenn eine Ware ausgeht.

    pWarenName: Warenname derjenigen Ware, für welchen eine automatische 
    Bestellung konfiguriert wird.

    pGrenze: bei welcher Anzahl von verbleibenden, nicht abgelaufener 
    Waren im Automat eine Bestellung abgesetzt werden soll (Bestellung 
    wenn Waren-Anzahl nicht abgelaufener Waren <= pGrenze).

	pBestellAnzahl: wieviele neue Waren jeweils bestellt werden sollen.
    */

	public void konfiguriereBestellung(String pWarenName, int pGrenze, int pBestellAnzahl) {
		Bestellung neueBestellung = new Bestellung(pWarenName, pGrenze, pBestellAnzahl);
		
		for (int i = 0; i < this.bestellung.size(); i++) {
			String nameProduktAktuelleBestellung = this.bestellung.get(i).getWarenname();
			
			if(nameProduktAktuelleBestellung.equals(pWarenName)){
				this.bestellung.remove(i);
			}
		}
		this.bestellung.add(neueBestellung);
	}


	/**
	 * Gibt die Bestellung einer bestimmten Ware zurück
	 * @param warenName
	 * @return
	 */
	private Bestellung getBestellung(String warenName){
		for (int i = 0; i < this.bestellung.size(); i++) {
			String nameAktuelleBestellung = this.bestellung.get(i).getWarenname();
			if(nameAktuelleBestellung.equals(warenName)){
				return this.bestellung.get(i);
			}
		}
		return null;
	}
	
	
    
    
}
