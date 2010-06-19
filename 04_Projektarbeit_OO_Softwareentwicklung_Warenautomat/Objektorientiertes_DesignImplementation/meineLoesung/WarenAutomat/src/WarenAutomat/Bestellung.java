package WarenAutomat;

public class Bestellung {
	private String warenname;
	private int grenze;
	private int bestellungAnzahl;
	
	
	
	public Bestellung(String warenname, int grenze, int bestellungAnzahl) {
		this.warenname = warenname;
		this.grenze = grenze;
		this.bestellungAnzahl = bestellungAnzahl;
	}
	public String getWarenname() {
		return warenname;
	}
	public int getGrenze() {
		return grenze;
	}
	public int getBestellungAnzahl() {
		return bestellungAnzahl;
	}	
	
}
