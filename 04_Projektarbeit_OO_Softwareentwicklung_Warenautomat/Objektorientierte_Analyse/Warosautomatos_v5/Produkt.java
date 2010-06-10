package ch.hsr.mas2010;

/**
 * @author FSB
 * @version 1.0
 * @created 10-Jun-2010 06:23:39
 */
public class Produkt {

	private String warenname;
	private Fixed(2,2) preis;
	private Date verfallsDatum;
	private Date verkaufsDatum;
	private Boolean /istVerkauft;

	public Produkt(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param verfallsDatum
	 * @param preis
	 * @param warenname
	 */
	public Produkt(Date verfallsDatum, Fixed(2,2) preis, String warenname){

	}

	public Date getVerfallsDatum(){
		return null;
	}

	public Fixed(2,2) getPreis(){
		return null;
	}

	/**
	 * 
	 * @param verkaufsDatum
	 */
	public void setVerkaufsDatum(Date verkaufsDatum){

	}

}