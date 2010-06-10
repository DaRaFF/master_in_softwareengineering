
package WarenAutomat;

import WarenAutomat.SystemSoftware;

/**
   Die Kasse verwaltet das eingenommene Geld sowie das Wechselgeld.
   Die Kasse hat f�nf M�nz-S�ulen f�r:
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
       F�llt Kasse mit einer bestimmten M�nzart (in Franken ausgedr�ckt) f�r die Wechselgeld-Ausgabe.
       Wenn o.k. positives Resultat.
       Wenn M�nze nicht unterst�tzt wird (z.B. 5 Franken) negatives Resultat.
       @roseuid 3B0BDE9D012B
     */
    public boolean fuelleKasse(double pMuenzenBetrag, int pAnzahl) {
      return false;  // TODO
    }
    
    /**
       F�hrt den eingenommenen Betrag (in Franken) entsprechend nach.
       Stellt den nach dem Einwerfen vorhandenen Betrag im Kassen-Display dar.
       Die M�nzen werden von der Hardware-Kasse gepr�ft, d.h. diese Methode wird nur aufgerufen wenn ein M�nzeinwurf erfolgreich war (und die eingeworfene M�nze nicht gleich wieder ausgeworfen wurde).
       Eingenommenes Geld steht sofort als Wechselgeld zur Verf�gung.
       pMuenzenBetrag: Betrag der eingeworfenen M�nze in Franken.
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
       Gibt den Gesamtbetrag der bisher verkauften Waren zur�ck.
       Analyse: 
       Abgeleitetes Attribut
       @roseuid 3B288F60022E
     */
    public double gibBetragVerkaufteWaren() {
      return 0.0;  // TODO
    }
}
