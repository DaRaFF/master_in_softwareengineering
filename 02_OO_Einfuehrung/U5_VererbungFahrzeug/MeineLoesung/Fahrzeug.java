import java.lang.Math;

class Fahrzeug {
    private double posX;
    private double posY;

    public Fahrzeug(double Xinit, double Yinit) {
        this.posX = Xinit;
        this.posY = Yinit;
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
        System.out.print(Prefix + ": Koord = " + this.posX + "/" + this.posY);
    }

    public void printlnInfos(String Prefix){
        this.printInfos(Prefix);
        System.out.println();
    }

}