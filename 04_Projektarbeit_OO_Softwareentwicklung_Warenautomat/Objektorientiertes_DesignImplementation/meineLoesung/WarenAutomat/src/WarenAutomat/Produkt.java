package WarenAutomat;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * @author Ralph Meier
 */
public class Produkt {

	private String warenname;
	private int preisInRappen;
	private Date verfallsDatum;
	private Date verkaufsDatum;
	private Boolean istVerkauft = false;
	
	public static void main(String[] args) throws ParseException {
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMAN);
				
		
		// Teste ob Produkt abgelaufen ist
		Produkt produkt = new Produkt(df.parse("10.06.2010"), 170, "Snickers");
		System.out.println("Produkt (Verfallsdatum 10.06.2010) ist am 10.06.2010 abgelaufen: " + produkt.istAbgelaufen(df.parse("10.06.2010")));
		System.out.println("Produkt (Verfallsdatum 10.06.2010) ist am 09.06.2010 abgelaufen: " + produkt.istAbgelaufen(df.parse("09.06.2010")));
	}
	
	
	/**
	 * Ein Produkt wird erzeugt
	 * 
	 * @param verfallsDatum
	 * @param preis
	 * @param warenname
	 */
	public Produkt(Date verfallsDatum, int preisInRappen, String warenname){
		this.verfallsDatum = verfallsDatum;
		this.preisInRappen = preisInRappen;
		this.warenname = warenname;
	}

	
	/**
	 * Prüft, ob das Produkt an einem bestimmten Datum abgelaufen ist
	 * @param aktuellesDatum
	 * @return true = Produkt abgelaufen / false = Produkt nicht abgelaufen
	 */
	public Boolean istAbgelaufen(Date aktuellesDatum){
		if(this.getVerfallsDatum().after(aktuellesDatum)){
			return false;
		}
		return true;
	}

	public int getPreisInRappen(){
		return this.preisInRappen;
	}
	
	public double getPreisInFranken(){
		double betragInFranken = this.preisInRappen / 100.0;
		return betragInFranken;		
	}


	public Date getVerfallsDatum(){
		return this.verfallsDatum;
	}
	
	public String gibWarenname(){
		return this.warenname;
	}
	
	public void verkaufen(){
		this.setVerkaufsDatum();
		this.setIstVerkauft(true);
	}
	
	public Boolean getIstVerkauft() {
		return istVerkauft;
	}


	private void setIstVerkauft(Boolean istVerkauft) {
		this.istVerkauft = istVerkauft;
	}


	private void setVerkaufsDatum(){
		this.verkaufsDatum = SystemSoftware.gibAktuellesDatum();
	}


	public Date getVerkaufsDatum() {
		return verkaufsDatum;
	}
}