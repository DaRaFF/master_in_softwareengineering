
import java.util.Date;

class Wasserfahrzeug extends Fahrzeug {

    private double smTotal;

    public Wasserfahrzeug(double Xinit, double Yinit, String Marke, double SMinit, Date pErsteInverkehrsSetzung, double LiterPro100km) {
        super(Xinit, Yinit, Marke, pErsteInverkehrsSetzung, LiterPro100km);
    }

    public double fahren(double X, double Y){
        double km = super.fahren(X, Y);
        this.smTotal += km / 1.852;
        System.out.println("Wasserfahrzeug.fahren(): total SM: " + getFormattedSMTotal());
        return km;
    }

    public void printlnInfos(String Prefix){
        super.printInfos(Prefix);
        System.out.println("    SM = " + getFormattedSMTotal());
    }

    public String getFormattedSMTotal(){
        String smTotalFormatted = String.format("%4.2f", this.smTotal);
        return smTotalFormatted;
    }
  
}
