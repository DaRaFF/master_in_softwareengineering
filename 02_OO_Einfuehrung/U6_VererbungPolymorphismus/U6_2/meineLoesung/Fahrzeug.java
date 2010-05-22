import java.lang.Math;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


class Fahrzeug {
    private double posX;
    private double posY;
    private Date ersteInverkehrsSetzung;

    public Fahrzeug(double Xinit, double Yinit, Date pErsteInverkehrsSetzung) {
        this.posX = Xinit;
        this.posY = Yinit;
        this.ersteInverkehrsSetzung = pErsteInverkehrsSetzung;
    }

    public double fahren(double X, double Y){
        double km;
        double diffX = this.posX - X;
        double diffY = this.posY - Y;
        km = Math.sqrt(diffX*diffX + diffY*diffY);
        this.posX = X;
        this.posY = Y;
        System.out.print("Fahrzeug.fahren(): ");
        System.out.println(km);
        return km;
    }

    protected void printInfos(String Prefix){
        System.out.print(Prefix + ": Koord = " + this.posX + "/" + this.posY + "\t"
                    + DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMAN).format(ersteInverkehrsSetzung)
                );
    }

    public void printlnInfos(String Prefix){
        this.printInfos(Prefix);
        System.out.println();
    }

    public Date getErsteInverkehrsSetzung() {
        return ersteInverkehrsSetzung;
    }

    

}