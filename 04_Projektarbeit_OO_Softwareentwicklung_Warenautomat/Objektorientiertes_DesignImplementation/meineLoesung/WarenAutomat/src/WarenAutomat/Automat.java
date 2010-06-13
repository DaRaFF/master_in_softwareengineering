
package WarenAutomat;

import java.util.Date;


/**
   Der Automat besteht aus 7 Drehtellern welche wiederum je aus 16 F�cher bestehen.
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
       F�llt ein Fach mit Ware.
       Wenn das Service-Personal den Automaten f�llt, wird mit einem Bar-Code-Leser zuerst die Ware gescannt.
       Daraufhin wird die Schiebe-T�r ge�ffnet.
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
       Gibt die Objekt-Referenz auf die Kasse zur�ck.
       @roseuid 3B0BD09C0382
     */
    public Kasse gibKasse() {
      return mKasse;
    }
    
    /**
       Wird von der System-Software jedesmal aufgerufen wenn der gelbe Dreh-Knopf gedr�ckt wird.
       Die Applikations-Software f�hrt die Drehteller-Anzeigen nach (Warenpreis, Verfallsdatum).
       Das Ansteuern des Drehteller-Motors �bernimmt hat die System-Software  (muss nicht von der Applikations-Software gesteuert werden.).
       Die System-Software stellt sicher, dass 'drehen' nicht durchgef�hrt wird wenn ein Fach offen ist.
       @roseuid 3B0BD112002F
     */
    public void drehen() {
    	SystemSoftware.dreheWarenInGui();
    	for (int i = 0; i < this.drehteller.length; i++) {
    		this.getDrehteller(i+1).drehen();
    	}      
    }
    
    /**
       Beim Versuch eine Schiebet�re  zu �ffnen ruft die System-Software die Methode oeffnen() der Klasse  'Automat' mit Parameter Drehteller-Nummer auf.
       Es wird �berpr�ft ob alles o.k. ist:
       - Fach nicht leer
       - Verfalls-Datum noch nicht erreicht
       - genug Geld eingeworfen
       - genug Wechselgeld vorhanden
       Wenn nicht genug Geld  eingeworfen wurde wird dies mit SystemSoftware.zeigeZuWenigGeldAn() signalisiert.
       Wenn nicht genug Wechselgeld vorhanden ist wird dies mit SystemSoftware.zeigeZuWenigWechselGeldAn() signalisiert.
       Wenn o.k. wird entriegelt (SystemSoftware.entriegeln()) und positives Resultat, sonst negatives Resultat.
       Es wird von der System-Software sichergestellt, dass zu einem bestimmten Zeitpunkt nur eine Schiebet�re offen sein kann.
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
    	}
    	return oeffnenOk;
    }
    
    /**
       Gibt den aktuellen Wert aller im Automaten enthaltenen Waren in Franken zur�ck (excl. abgelaufene Waren).
       Analyse: 
       Abgeleitetes Attribut
       @roseuid 3B0F58B30045
     */
    public double gibTotalenWarenWert() {
      return this.gibWarenbestand().gibTotalWarenWert();
    }
    
    /**
       Gibt die Anzahl der verkauften Ware 'pName' seit (>=) 'pDatum' als Zahl zur�ck.
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
    
    
}
