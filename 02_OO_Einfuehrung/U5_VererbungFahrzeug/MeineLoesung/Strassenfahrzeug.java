class Strassenfahrzeug extends Fahrzeug {

    private double kmTotal;

    public Strassenfahrzeug(double Xinit, double Yinit, double KMinit) {
        super(Xinit, Yinit);
        this.kmTotal = KMinit;
    }
    public double fahren(double X, double Y){
        double km = super.fahren(X, Y);
        this.kmTotal += km;
        System.out.println("Strassenfahrzeug.fahren(): total KM: " + this.kmTotal);
        return km;
    }

    public void printlnInfos(String Prefix){
        super.printInfos(Prefix);
        System.out.println("    KM = " + this.kmTotal);
    }
}