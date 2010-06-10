package ch.hsr.mas2010;

/**
 * @author FSB
 * @version 1.0
 * @created 10-Jun-2010 06:23:33
 */
public class AnzeigeServicePanel {

	private Fixed(5,2) totalWarenwert;
	private Fixed(5,2) totalVerkaufterWarenwert;
	private Fixed(2,2) muenzArt;
	private UInteger muenzAnzahl;
	private String produktName;
	private Fixed(2,2) produktPreis;
	private Date produktVerfallsdatum;
	private String statistikName;
	private Date statistikAbDatum;
	private UInteger statistikAnzahl;



	public void finalize() throws Throwable {

	}

	public AnzeigeServicePanel(){

	}

	/**
	 * 
	 * @param art
	 * @param anzahl
	 */
	public void aktualisiereMuenze(Fixed(2,2) art, UInteger anzahl){

	}

	/**
	 * 
	 * @param name
	 * @param preis
	 * @param verfallsdatum
	 */
	public void aktualisiereProdukt(String name, Fixed(2,2) preis, Date verfallsdatum){

	}

	/**
	 * 
	 * @param name
	 * @param abDatum
	 */
	public void aktualisiereStatistik(String name, Date abDatum){

	}

	/**
	 * 
	 * @param totalVerkaufterWarenwert
	 * @param totalWarenwert
	 */
	public void aktualisiereWarenwert(Fixed(5,2) totalVerkaufterWarenwert, Fixed(5,2) totalWarenwert){

	}

	private void zehnSekAnzeige(){

	}

}