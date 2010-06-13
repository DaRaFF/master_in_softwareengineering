package WarenAutomat;

import java.text.ParseException;
import java.util.Collections;
import java.util.Vector;

import WarenAutomat.SystemSoftware;

/**
 * Die Kasse verwaltet das eingenommene Geld sowie das Wechselgeld. Die Kasse
 * hat fünf Münz-Säulen für: - 10 Rappen - 20 Rappen - 50 Rappen - 1 Franken - 2
 * Franken
 */
public class Kasse {

	private int[] erlaubteMuenzenInRappen = { 200, 100, 50, 20, 10 };
	private Vector<Integer> muenzen = new Vector<Integer>();
	private int eingeworfenerBetragInRappen = 0;
	private int totalBetragVerkaufteWarenInRappen = 0;

	public static void main(String[] args) throws ParseException {
		Kasse kasse = new Kasse();	
		// Teste Kasse fuellen
		boolean erlaubt;
		erlaubt = kasse.fuelleKasse(0.10, 100);
		System.out.println("fuelle Kasse mit 10 Rappen sollte erlaubt sein: " + erlaubt);
		erlaubt = kasse.fuelleKasse(0.20, 100);
		System.out.println("fuelle Kasse mit 20 Rappen sollte erlaubt sein: " + erlaubt);
		erlaubt = kasse.fuelleKasse(0.50, 100);
		System.out.println("fuelle Kasse mit 50 Rappen sollte erlaubt sein: " + erlaubt);
		erlaubt = kasse.fuelleKasse(1.00, 100);
		System.out.println("fuelle Kasse mit 100 Rappen sollte erlaubt sein: " + erlaubt);
		erlaubt = kasse.fuelleKasse(2.00, 100);
		System.out.println("fuelle Kasse mit 200 Rappen sollte erlaubt sein: " 	+ erlaubt);
		erlaubt = kasse.fuelleKasse(5.00, 100);
		System.out.println("fuelle Kasse mit 500 Rappen sollte nicht erlaubt sein: " + erlaubt);
		
		// Teste Münze einwerfen
		Kasse kasse2 = new Kasse();
		kasse2.einnehmen(1.00);
		System.out.println("Eingeworfener Betrag sollte 100 Rappen sein.");	
		kasse2.einnehmen(0.20);
		System.out.println("Eingeworfener Betrag sollte 120 Rappen sein.");	
		kasse2.einnehmen(0.50);
		System.out.println("Eingeworfener Betrag sollte 170 Rappen sein.");	
		kasse2.einnehmen(2.00);
		System.out.println("Eingeworfener Betrag sollte 370 Rappen sein.");	
		
		//Test Wechselgeld möglich
		System.out.println("\nWechseln auf 200 Rappen sollte möglich sein: ");
		System.out.println("Wechseln möglich : " + kasse2.istWechselgeldMoeglich(200));
		System.out.println("\nWechseln auf 100 Rappen sollte möglich sein: ");
		System.out.println("Wechseln möglich: " + kasse2.istWechselgeldMoeglich(100));
		System.out.println("\nWechseln auf 10 Rappen sollte nicht möglich sein: ");
		System.out.println("Wechseln möglich: " + kasse2.istWechselgeldMoeglich(10));
		System.out.println("\nWechseln auf 270 Rappen sollte möglich sein: ");
		System.out.println("Wechseln möglich: " + kasse2.istWechselgeldMoeglich(270));
		
		//Test Wechselgeld möglich -> dieser Fall wurde noch nicht implementiert (ist aber auch nicht gefordert)
		kasse2.einnehmen(0.20);
		kasse2.einnehmen(0.20);
		System.out.println("\nWechseln auf 60 Rappen sollte möglich sein (aktuell nicht korrekt implementiert): ");
		System.out.println("Wechseln möglich: " + kasse2.istWechselgeldMoeglich(60));		
		
	}

	/**
	 * Default-Konstruktor.
	 * 
	 * @roseuid 3CB089BF0331
	 */
	public Kasse() {
	}

	/**
	 * Füllt Kasse mit einer bestimmten Münzart (in Franken ausgedrückt) für die
	 * Wechselgeld-Ausgabe. Wenn o.k. positives Resultat. Wenn Münze nicht
	 * unterstützt wird (z.B. 5 Franken) negatives Resultat.
	 * 
	 * @roseuid 3B0BDE9D012B
	 */
	public boolean fuelleKasse(double pMuenzenBetrag, int pAnzahl) {
		if (pruefeMuenze(pMuenzenBetrag)) {
			for (int i = 0; i < pAnzahl; i++) {
				int muenzenBetraginRappen = gibRappen(pMuenzenBetrag);
				this.muenzen.add(new Integer(muenzenBetraginRappen));
			}
			SystemSoftware.zeigeMuenzenInGui(pMuenzenBetrag, pAnzahl);
			return true;
		}
		return false;
	}

	/**
	 * Führt den eingenommenen Betrag (in Franken) entsprechend nach. Stellt den
	 * nach dem Einwerfen vorhandenen Betrag im Kassen-Display dar. Die Münzen
	 * werden von der Hardware-Kasse geprüft, d.h. diese Methode wird nur
	 * aufgerufen wenn ein Münzeinwurf erfolgreich war (und die eingeworfene
	 * Münze nicht gleich wieder ausgeworfen wurde). Eingenommenes Geld steht
	 * sofort als Wechselgeld zur Verfügung. pMuenzenBetrag: Betrag der
	 * eingeworfenen Münze in Franken.
	 * 
	 * @roseuid 3B0BE0A40206
	 */
	public void einnehmen(double pMuenzenBetrag) {
		int muenzenBetraginRappen = gibRappen(pMuenzenBetrag);
		this.muenzen.add(new Integer(muenzenBetraginRappen));
		this.eingeworfenerBetragInRappen = this.getEingeworfenerBetragInRappen() + this.gibRappen(pMuenzenBetrag);
		double eingeworfenerBetragInFranken = this.getEingeworfenerBetragInFranken();
		SystemSoftware.zeigeBetragAn(eingeworfenerBetragInFranken);
	}
	
	public void verkaufen(int muenzenBetrag){
		int eingeworfenerBetragNeu = this.getEingeworfenerBetragInRappen() - muenzenBetrag;
		this.setEingeworfenerBetragInRappen(eingeworfenerBetragNeu);
		this.totalBetragVerkaufteWarenInRappen += muenzenBetrag;
	}

	/**
	 * Diese Methode bewirkt den Auswurf des Restbetrages.
	 * 
	 * @roseuid 3B0BDDE60041
	 */
	public void gibWechselGeld() {
		Collections.sort(this.muenzen);
		int restBetragInRappen = this.getEingeworfenerBetragInRappen();
		for (int i = this.muenzen.size(); i > 0; i--) {
			if(this.muenzen.get(i - 1) <= restBetragInRappen){
				int muenzeWertInRappen = this.muenzen.get(i - 1);
				restBetragInRappen -= muenzeWertInRappen;
				this.eingeworfenerBetragInRappen -= muenzeWertInRappen;
				double muenzWertInFranken = this.gibFranken(this.muenzen.get(i - 1));
				SystemSoftware.auswerfenWechselGeld(muenzWertInFranken);
				this.muenzen.remove(i - 1);
			}
		}
		SystemSoftware.zeigeBetragAn(0.00);
		
	}

	/**
	 * Gibt den Gesamtbetrag der bisher verkauften Waren zurück. Analyse:
	 * Abgeleitetes Attribut
	 * 
	 * @roseuid 3B288F60022E
	 */
	public double gibBetragVerkaufteWaren() {
		return this.gibFranken(this.totalBetragVerkaufteWarenInRappen);
	}
	
	/**
	 * Prüft, ob der übergebene Münzbetrag gewechselt werden kann.
	 * @param muenzenBetrag
	 * @return true = möglich / false = nicht möglich
	 */
	public boolean istWechselgeldMoeglich(int muenzenBetrag){
		Collections.sort(this.muenzen);
		int restBetragInRappen = muenzenBetrag;
		for (int i = this.muenzen.size(); i > 0; i--) {
			if(this.muenzen.get(i - 1) <= restBetragInRappen){
				restBetragInRappen -= this.muenzen.get(i - 1);
			}
		}
				
		if(restBetragInRappen == 0){
			return true;
		}
		return false;
	}

	/**
	 * Prüft ob eine Münze in der Kasse erlaubt ist
	 * 
	 * @param pMuenzenBetrag
	 * @return Münze erlaubt/nicht erlaubt
	 */
	private boolean pruefeMuenze(double pMuenzenBetrag) {
		for (int i = 0; i < erlaubteMuenzenInRappen.length; i++) {
			if (erlaubteMuenzenInRappen[i] == this.gibRappen(pMuenzenBetrag)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Rechnet Franken in Rappen um
	 * 
	 * @param pMuenzenBetrag
	 * @return muenzenBetrag in Rappen
	 */
	public int gibRappen(double pMuenzenBetragInFranken) {
		int einwurfInRappen = (int) Math.round(pMuenzenBetragInFranken * 100);
		return einwurfInRappen;
	}
	
	/**
	 * Rechnet Rappen in Franken um
	 * 
	 * @param pMuenzenBetragInRappen
	 * @return muenzenBetrag in Franken
	 */
	private double gibFranken(int pMuenzenBetragInRappen) {
		double betragInFranken = pMuenzenBetragInRappen / 100.0;
		return betragInFranken;
	}

	public int getEingeworfenerBetragInRappen() {
		return this.eingeworfenerBetragInRappen;
	}
	
	public double getEingeworfenerBetragInFranken() {
		return this.gibFranken(this.eingeworfenerBetragInRappen);
	}

	public void setEingeworfenerBetragInRappen(int eingeworfenerBetragInRappen) {
		this.eingeworfenerBetragInRappen = eingeworfenerBetragInRappen;
	}
}
