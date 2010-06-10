
package WarenAutomat;

import java.util.Date;
import java.util.Vector;


/**
   Der Automat besteht aus 7 Drehtellern welche wiederum je aus 16 Fächer bestehen.
   Der erste Drehteller und das jeweils erste Fach haben jeweils die Nummer 1 (nicht 0!).
   Im weitern hat der Automat eine Kasse.
   Diese wird vom Automaten instanziert.
 */
public class Automat {
    public static final int NR_DREHTELLER = 7;
    private Drehteller mDrehteller[];
    private Kasse mKasse;
    
    /**
       Default-Konstruktor.
       @roseuid 3B0F474603AE
     */
    public Automat() {
      // TODO
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
      // TODO
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
      // TODO
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
      return true; // TODO
    }
    
    /**
       Gibt den aktuellen Wert aller im Automaten enthaltenen Waren in Franken zurück (excl. abgelaufene Waren).
       Analyse: 
       Abgeleitetes Attribut
       @roseuid 3B0F58B30045
     */
    public double gibTotalenWarenWert() {
      return 0.0; // TODO
    }
    
    /**
       Gibt die Anzahl der verkauften Ware 'pName' seit (>=) 'pDatum' als Zahl zurück.
       @roseuid 40C3937A0382
     */
    public int gibVerkaufsStatistik(String pName, Date pDatum) {
      return 0; // TODO
    }
}
