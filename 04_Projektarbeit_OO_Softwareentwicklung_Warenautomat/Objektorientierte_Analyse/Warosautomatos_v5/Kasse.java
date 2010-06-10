package ch.hsr.mas2010;

/**
 * @author FSB
 * @version 1.0
 * @created 10-Jun-2010 06:23:37
 */
public class Kasse {

	public Muenze m_Muenze;
	public Automat m_Automat;



	public void finalize() throws Throwable {

	}

	public Kasse(){

	}

	/**
	 * 
	 * @param wert
	 * @param waehrung
	 */
	public void addiereBetrag(Fixed(5,2) wert, String waehrung){

	}

	public Fixed(5,2) gibTotalBetrag(){
		return null;
	}

	/**
	 * 
	 * @param wechselGeld
	 */
	public Boolean istWechselgeldMoeglich(Fixed(2.2) wechselGeld){
		return false;
	}

	/**
	 * 
	 * @param wert
	 * @param waehrung
	 */
	public void reduziereBetrag(Fixed(5,2) wert, String waehrung){

	}

}