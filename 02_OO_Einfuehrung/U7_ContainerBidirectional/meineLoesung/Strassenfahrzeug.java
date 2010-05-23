
import java.util.Date;
import java.lang.String;

class Strassenfahrzeug extends Fahrzeug {

    private double kmTotal;

    public Strassenfahrzeug(double Xinit, double Yinit, String Marke, double KMinit, Date pErsteInverkehrsSetzung, double LiterPro100km) {
        super(Xinit, Yinit, Marke, pErsteInverkehrsSetzung, LiterPro100km);
        this.kmTotal = KMinit;
    }


    public double fahren(double X, double Y){
        double km = super.fahren(X, Y);
        this.kmTotal += km;
        System.out.println("Strassenfahrzeug.fahren(): total KM: " + getFormattedKMTotal());
        return km;
    }

    public void printlnInfos(String Prefix){
        super.printInfos(Prefix);
        System.out.println("    KM = " + getFormattedKMTotal());
    }

    public String getFormattedKMTotal(){
        String kmTotalFormatted = String.format("%4.2f", this.kmTotal);
        return kmTotalFormatted;
    }
}