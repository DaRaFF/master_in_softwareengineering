package WarenAutomat;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;


/**
 * Der Warenbestand führt alle aktuellen Produkte im Automaten
 * Der Warenbestand fürt alle vergangenen Produkte, die verkauft wurden
 * (Produkte, welche nicht verkauft worden und entfernt worden sind, müssen sauber aus dem Warenbestand gelöscht werden)
 * 
 * @author Ralph Meier
 */
public class Warenbestand {
	private Automat automat;
	private Vector<Produkt> produkte = new Vector<Produkt>();
	
	public static void main(String[] args) throws ParseException {
		Automat automat = new Automat();
		Warenbestand warenbestand = new Warenbestand(automat);
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMAN);
				
		// Teste total Warenwert
		System.out.println("=== Warenwert-Test: =================================");
		SystemSoftware.setzeAktuellesDatum(df.parse("09.06.2010"));
		Produkt produkt;
		produkt = new Produkt(df.parse("10.06.2010"), 100, "Snickers1");
		System.out.println("*** Neues Produkt: " + produkt.getPreisInFranken());
		warenbestand.produktHinzufuegen(produkt);
		produkt = new Produkt(df.parse("10.06.2010"), 150, "Snickers2");
		warenbestand.produktHinzufuegen(produkt);
		System.out.println("*** Neues Produkt: " + produkt.getPreisInFranken());
		produkt = new Produkt(df.parse("10.06.2010"), 200, "Snickers3");
		warenbestand.produktHinzufuegen(produkt);
		System.out.println("*** Neues Produkt: " + produkt.getPreisInFranken());
		System.out.println("*** Warenwert Total in Franken: " + warenbestand.gibTotalWarenWert());
		System.out.println("*** Produkt entfernen: " + produkt.getPreisInFranken());
		warenbestand.produktEntfernen(produkt);
		System.out.println("*** Warenwert Total in Franken: " + warenbestand.gibTotalWarenWert());
		produkt = new Produkt(df.parse("08.06.2010"), 200, "Snickers3");
		warenbestand.produktHinzufuegen(produkt);
		System.out.println("*** Neues abgelaufenes Produkt: " + produkt.getPreisInFranken());
		System.out.println("*** Warenwert Total in Franken: " + warenbestand.gibTotalWarenWert());
		System.out.println("=== Warenwert-Test. =================================");
	}

	public Warenbestand(Automat automat){
		this.automat = automat;
	}


	/**
	 * Wurde gemäss Vorgabe in Kasse implementiert - wie kann ich das lösen?
	 */
//	public double gibTotalVerkaufterWarenwertInFranken(){
//		return 0.0;
//	}
//TODO

	
	/**
	 * Gibt den aktuellen Wert aller im Automaten enthaltenen Waren in Franken zurück (excl. abgelaufene Waren).
	 * @return 
	 */
	public double gibTotalWarenWert(){
		double totalWarenWert = 0.0;
		for (int i = 0; i < this.produkte.size(); i++) {
			Boolean produktNichtAbgelaufen = !this.produkte.get(i).istAbgelaufen(SystemSoftware.gibAktuellesDatum());
			Boolean produktNichtVerkauft = !this.produkte.get(i).getIstVerkauft();
			if(produktNichtAbgelaufen & produktNichtVerkauft){
				totalWarenWert += this.produkte.get(i).getPreisInFranken();
			}
		}	
		return totalWarenWert;
	}
	
    /**
     * Gibt die Anzahl der verkauften Ware 'pName' seit (>=) 'pDatum' als Zahl zurück.
     */
	public int gibVerkaufsStatistik(String pName, Date pDatum) {
		int anzProdukteVerkauft = 0;
		for (int i = 0; i < this.produkte.size(); i++) {
			Boolean istProduktVerkauft = this.produkte.get(i).getIstVerkauft();
			if(istProduktVerkauft){
				Date verkaufsDatumProdukt = this.produkte.get(i).getVerkaufsDatum();
				if(!pDatum.after(verkaufsDatumProdukt)){
					String nameVerkauftesProdukt = this.produkte.get(i).gibWarenname();
					if(nameVerkauftesProdukt.equals(pName)){
						anzProdukteVerkauft++;
					}
				}
				
			}
		}	
		return anzProdukteVerkauft;
	 }

	/**
	 * Wird ein Produkt aus dem Automat entfernt, ohne verkauft zu werden, soll das Produkt aus dem Warenbestand entfernt werden
	 * @param altesProdukt
	 */
	public void produktEntfernen(Produkt altesProdukt){
		for (int i = 0; i < this.produkte.size(); i++) {
			if(this.produkte.get(i) == altesProdukt){
				this.produkte.remove(i);
			}
		}
	}

	/**
	 * Neues Produkt zu Warenbestand hinzufügen (Produkt wird in Automat gelegt)
	 * @param neuesProdukt
	 */
	public void produktHinzufuegen(Produkt neuesProdukt){
		this.produkte.add(neuesProdukt);
	}
	
	/**
	 * Gibt die Anzahl der Produkte zurück, welche Verfügbar sind und gekauft werden können
	 * @param produktName
	 * @return
	 */
	public int getAnzahlWaren(String produktName){
		int anzProdukte = 0;
		for (int i = 0; i < this.produkte.size(); i++) {
			Boolean istProduktNichtVerkauft = !this.produkte.get(i).getIstVerkauft();
			Boolean istProduktNichtAbgelaufen = !this.produkte.get(i).istAbgelaufen(SystemSoftware.gibAktuellesDatum());
			Boolean istGesuchtesProdukt = this.produkte.get(i).gibWarenname().equals(produktName);
			if(istProduktNichtVerkauft & istGesuchtesProdukt & istProduktNichtAbgelaufen){
				anzProdukte++;
			}
		}	
		return anzProdukte;
	}
	


}