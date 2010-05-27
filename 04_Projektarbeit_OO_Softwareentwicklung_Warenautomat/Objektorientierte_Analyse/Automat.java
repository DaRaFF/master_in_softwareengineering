package ch.hsr.mas2010;

/**
 * @version 1.0
 * @created 27-Mai-2010 15:09:34
 */
public class Automat {

	public Fixed(2,2) eingeworfenerBetrag;
	public Drehteller m_Drehteller;
	public Kasse m_Kasse;
	public Anzeige m_Anzeige;

	public Automat(){

	}

	public void finalize() throws Throwable {

	}

	public void aktualisiereAnzeige(){

	}

	public void drehen(){

	}

	/**
	 * 
	 * @param Preis
	 * @param WarenName
	 * @param drehtellerNr
	 */
	public void fuelleFach(final Fixed(2,2) Preis, String WarenName, Unsigned Integer drehtellerNr){

	}

	/**
	 * 
	 * @param betrag
	 */
	public void gibRestgeld(Fixed(5,2) betrag){

	}

	public Fixed(5,2) gibTotalWarenWert(){
		return null;
	}

	/**
	 * 
	 * @param seit
	 * @param wahrenname
	 */
	public Integer gibVerkaufsstatistik(Date seit, String wahrenname){
		return 0;
	}

	/**
	 * 
	 * @param muenze
	 */
	public void muenzeEinwerfen(Muenze muenze){

	}

	/**
	 * 
	 * @param drehtellerNr
	 */
	public boolean oeffneSchiebetuer(UInteger drehtellerNr){
		return false;
	}

	public boolean pruefeDrehteller(){
		return false;
	}

	/**
	 * 
	 * @param muenze
	 */
	public boolean pruefeMuenze(Muenze muenze){
		return false;
	}

	/**
	 * 
	 * @param drehteller
	 */
	public boolean pruefeSchiebetuer(Drehteller drehteller){
		return false;
	}

	/**
	 * 
	 * @param drehteller
	 */
	public boolean pruefeVerfallsdatum(Drehteller drehteller){
		return false;
	}

}