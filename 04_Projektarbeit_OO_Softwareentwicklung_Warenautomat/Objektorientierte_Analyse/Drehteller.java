package ch.hsr.mas2010;

/**
 * @author ProjectNutzer
 * @version 1.0
 * @created 27-Mai-2010 15:09:35
 */
public class Drehteller {

	public int aktuellesFach;
	public DrehtellerAnzeige drehtellerAnzeige;
	public boolean istOffen;
	public Fach m_Fach;
	public DrehtellerAnzeige m_DrehtellerAnzeige;

	public Drehteller(){

	}

	public void finalize() throws Throwable {

	}

	public boolean aktualisiereAnzeige(){
		return false;
	}

	public boolean drehen(){
		return false;
	}

	public void entriegeln(){

	}

	public boolean oeffnen(){
		return false;
	}

	public void schliessen(){

	}

}