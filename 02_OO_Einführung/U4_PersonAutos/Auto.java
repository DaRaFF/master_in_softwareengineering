/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daraff
 */
class Auto {

    String marke = "";
    String kennzeichen = "";

    Auto(String marke, String kennzeichen) {
        this.marke = marke;
        this.kennzeichen = kennzeichen;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getMarke() {
        return marke;
    }

    String getKennzeichen() {
        return this.kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    
}
