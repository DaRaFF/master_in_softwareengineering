package ch.hsr.mas2010;

/**
 * @author FSB
 * @version 1.0
 * @created 10-Jun-2010 06:23:34
 */
public class Automat {

	private Fixed(5,2) eingeworfenerBetrag;
	private Boolean serviceMode;
	public Drehteller m_Drehteller;
	public AnzeigeAutomat m_AnzeigeAutomat;
	public AnzeigeServicePanel m_AnzeigeServicePanel;
	public Warenbestand m_Warenbestand;



	public void finalize() throws Throwable {

	}

	public Automat(){

	}

	public void drehen(){

	}

	/**
	 * 
	 * @param betrag
	 * @param waehrung
	 */
	public void muenzeEinwerfen(Fixed(2,2) betrag, String waehrung){

	}

	/**
	 * 
	 * @param drehtellerNr
	 */
	public Boolean oeffneSchiebeTuer(UInteger drehtellerNr){
		return false;
	}

	/**
	 * 
	 * @param drehteller
	 */
	public Boolean pruefeSchiebetuer(Drehteller drehteller){
		return false;
	}

	/**
	 * 
	 * @param drehtellerNr
	 */
	public Boolean schliesseSchiebeTuer(UInteger drehtellerNr){
		return false;
	}

	public void aktualisiereAnzeigeAutomat(){

	}

	public void oeffneServicePanel(){

	}

	public Fixed(5,2) gibTotalenWarenWert(){
		return null;
	}

	/**
	 * 
	 * @param seit
	 * @param warenname
	 */
	public Integer gibVerkaufsstatistik(Date seit, String warenname){
		return 0;
	}

	/**
	 * 
	 * @param verfallsDatum
	 * @param preis
	 * @param warenname
	 * @param drehtellerNr
	 */
	public void fuelleFach(Date verfallsDatum, Fixed(2,2) preis, String warenname, UInteger drehtellerNr){

	}

	/**
	 * 
	 * @param verfallsdatum
	 * @param preis
	 * @param warenName
	 */
	public void scanneWare(Date verfallsdatum, Fixed(2,2) preis, String warenName){

	}

	/**
	 * 
	 * @param betrag
	 * @param waehrung
	 * @param anzahl
	 */
	public void fuelleGeld(Fixed(2,2) betrag, String waehrung, UInteger anzahl){

	}

	public Boolean geldAuffuellenBestaetigen(){
		return false;
	}

	public Fixed(5,2) gibRestgeld(){
		return null;
	}

	private boolean pruefeDrehteller(){
		return false;
	}

	/**
	 * Hat der Kunde genug Geld eingeworfen
	 */
	private Boolean pruefeGenugGeld(){
		return false;
	}

	/**
	 * 
	 * @param waehrung
	 * @param wert
	 */
	private Boolean pruefeMuenze(String waehrung, Fixed(2,2) wert){
		return false;
	}

	/**
	 * 
	 * @param betrag
	 */
	public void setEingeworfenerBetrag(Fixed(5,2) betrag){

	}

}