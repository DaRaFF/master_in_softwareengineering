class Wasserfahrzeug extends Fahrzeug {

    private double smTotal;

    public Wasserfahrzeug(double Xinit, double Yinit, double SMinit) {
        super(Xinit, Yinit);
    }

    public double fahren(double X, double Y){
        double km = super.fahren(X, Y);
        this.smTotal += km / 1.852;
        System.out.println("Wasserfahrzeug.fahren(): total SM: " + this.smTotal);
        return km;
    }

    public void printlnInfos(String Prefix){
        super.printInfos(Prefix);
        System.out.println("    SM = " + this.smTotal);
    }
  
}
