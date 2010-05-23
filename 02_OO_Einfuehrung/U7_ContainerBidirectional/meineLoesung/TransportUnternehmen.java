import java.util.Date;
import java.util.Vector;

/**
 *
 * @author daraff
 */
class TransportUnternehmen {

    private int anzFahrzeuge = 0;
    private Vector<Fahrzeug> fahrzeuge = new Vector<Fahrzeug>();
    private double TotalVerbrauchterTreibstoff = 0;

    public boolean neuesFahrzeug(Fahrzeug fahrzeug) {
            fahrzeug.setTransportUnternehmen(this);
            this.fahrzeuge.add(fahrzeug);
            this.anzFahrzeuge++;
            return true;
    }

    public void allesFahren(double X, double Y) {
        System.out.println("Transportunternehmen.allesFahren(): " + X + "/" + Y);
        for (int i = 0; i < anzFahrzeuge; i++) {
            fahrzeuge.get(i).fahren(X, Y);
        }
    }

    public void printlnInfos() {
        System.out.println("Transportunternehmen.printInfos()");
        for (int i = 0; i < anzFahrzeuge; i++) {
          fahrzeuge.get(i).printlnInfos("Fz " + (i+1));
        }
        System.out.println("Total verbrauchter Treibstoff = " + this.TotalVerbrauchterTreibstoff);
    }

    public Vector<Fahrzeug> getFzAelterAls(Date pDatum){
        Vector<Fahrzeug> fahrzeugeAelter = new Vector<Fahrzeug>();
        for (int i = 0; i < anzFahrzeuge; i++) {
            if( fahrzeuge.get(i).getErsteInverkehrsSetzung().before(pDatum)){
                fahrzeugeAelter.add(fahrzeuge.get(i));
            }
        }
        return fahrzeugeAelter;
    }

    Vector<Fahrzeug> getFzMitMarke(String string) {
        Vector<Fahrzeug> vec = new Vector<Fahrzeug>();
        for (int i = 0; i < anzFahrzeuge; i++) {
            if( fahrzeuge.get(i).getMarke() == string){
                vec.add(fahrzeuge.get(i));
            }
        }
        return vec;
    }

    public void neuVerbrauchterTreibstoff(double Liter) {
        this.TotalVerbrauchterTreibstoff += Liter;
    }

}
