import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author daraff
 */
class TransportUnternehmen {

    private final static int MAX_FAHRZEUG = 10;
    private int anzFahrzeuge = 0;
    private Vector<Fahrzeug> fahrzeuge = new Vector<Fahrzeug>();

    public boolean neuesFahrzeug(Fahrzeug fahrzeug) {
        if(this.anzFahrzeuge < this.MAX_FAHRZEUG){
            this.fahrzeuge.add(fahrzeug);
            this.anzFahrzeuge++;
            return true;
        }
        return false;
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

}
