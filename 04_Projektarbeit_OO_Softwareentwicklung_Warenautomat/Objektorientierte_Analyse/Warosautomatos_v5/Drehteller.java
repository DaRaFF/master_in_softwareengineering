package ch.hsr.mas2010;

/**
 * @author FSB
 * @version 1.0
 * @created 10-Jun-2010 06:23:35
 */
public class Drehteller {

	private UInteger aktuellesFach;
	private boolean istOffen;
	public Fach m_Fach;
	public AnzeigeDrehteller m_AnzeigeDrehteller;



	public void finalize() throws Throwable {

	}

	public Drehteller(){

	}

	public Boolean dreheAktuellesFach(){
		return false;
	}

	public void entriegeln(){

	}

	/**
	 * 
	 * @param neuesProdukt
	 */
	public void fuelleAktuellesFach(Produkt neuesProdukt){

	}

	public Boolean getIstOffen(){
		return false;
	}

	public Boolean oeffnen(){
		return false;
	}

	private Boolean pruefeFachLeer(){
		return false;
	}

	private Boolean pruefeVerfallsDatum(){
		return false;
	}

	public void schliessen(){

	}

	public Fixed(2,2) getAktuellesFach(){
		return null;
	}

}