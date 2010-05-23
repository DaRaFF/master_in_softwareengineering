import java.lang.Math;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


class Fahrzeug {
    private double posX;
    private double posY;
    private Date ersteInverkehrsSetzung;
    private String Marke;
    private double LiterPro100km;
    private TransportUnternehmen transportUnternehmen;
    private double VerbrauchterTreibstoff = 0;


    public Fahrzeug(double Xinit, double Yinit, String Marke, Date pErsteInverkehrsSetzung, double LiterPro100km) {
        this.posX = Xinit;
        this.posY = Yinit;
        this.ersteInverkehrsSetzung = pErsteInverkehrsSetzung;
        this.Marke = Marke;
        this.LiterPro100km = LiterPro100km;
    }

    public String getMarke() {
        return Marke;
    }

    public double fahren(double X, double Y){
        double km;
        double diffX = this.posX - X;
        double diffY = this.posY - Y;
        double neuVerbrauchterTreibstoff;
        km = Math.sqrt(diffX*diffX + diffY*diffY);
        this.posX = X;
        this.posY = Y;
        System.out.print("Fahrzeug.fahren(): ");
        System.out.println(km);
        neuVerbrauchterTreibstoff = km * this.LiterPro100km / 100;
        this.VerbrauchterTreibstoff += neuVerbrauchterTreibstoff;
        this.transportUnternehmen.neuVerbrauchterTreibstoff(neuVerbrauchterTreibstoff);
        return km;
    }

    protected void printInfos(String Prefix){
        System.out.print(Prefix + ": Koord = " + this.posX + "/" + this.posY + "\t"
                    + this.getMarke() + "\t"
                    + DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMAN).format(ersteInverkehrsSetzung) + "\t"
                    + "Trst = " + this.VerbrauchterTreibstoff + "\t"
                );
    }

    public void printlnInfos(String Prefix){
        this.printInfos(Prefix);
        System.out.println();
    }

    public Date getErsteInverkehrsSetzung() {
        return ersteInverkehrsSetzung;
    }

    void setTransportUnternehmen(TransportUnternehmen transportUnternehmen) {
        this.transportUnternehmen = transportUnternehmen;
    }

    

}