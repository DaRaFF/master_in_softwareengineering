
package WarenAutomat;

import WarenAutomat.SystemSoftware;

/**
   Die Kasse verwaltet das eingenommene Geld sowie das Wechselgeld.
   Die Kasse hat fünf Münz-Säulen für:
   - 10 Rappen
   - 20 Rappen
   - 50 Rappen
   - 1 Franken
   - 2 Franken
 */
public class Kasse {
    
    /**
       Default-Konstruktor.
       @roseuid 3CB089BF0331
     */
    public Kasse() {
      // TODO
    }
    
    /**
       Füllt Kasse mit einer bestimmten Münzart (in Franken ausgedrückt) für die Wechselgeld-Ausgabe.
       Wenn o.k. positives Resultat.
       Wenn Münze nicht unterstützt wird (z.B. 5 Franken) negatives Resultat.
       @roseuid 3B0BDE9D012B
     */
    public boolean fuelleKasse(double pMuenzenBetrag, int pAnzahl) {
      return false;  // TODO
    }
    
    /**
       Führt den eingenommenen Betrag (in Franken) entsprechend nach.
       Stellt den nach dem Einwerfen vorhandenen Betrag im Kassen-Display dar.
       Die Münzen werden von der Hardware-Kasse geprüft, d.h. diese Methode wird nur aufgerufen wenn ein Münzeinwurf erfolgreich war (und die eingeworfene Münze nicht gleich wieder ausgeworfen wurde).
       Eingenommenes Geld steht sofort als Wechselgeld zur Verfügung.
       pMuenzenBetrag: Betrag der eingeworfenen Münze in Franken.
       @roseuid 3B0BE0A40206
     */
    public void einnehmen(double pMuenzenBetrag) {
      // TODO
    }
        
    /**
       Diese Methode bewirkt den Auswurf des Restbetrages.
       @roseuid 3B0BDDE60041
     */
    public void gibWechselGeld() {
      // TODO
    }
        
    /**
       Gibt den Gesamtbetrag der bisher verkauften Waren zurück.
       Analyse: 
       Abgeleitetes Attribut
       @roseuid 3B288F60022E
     */
    public double gibBetragVerkaufteWaren() {
      return 0.0;  // TODO
    }
}
