package testpreparation.vererbung;

public class vererbung {

    public static void main(String[] args) {
            Y n = new Y();
    }
}

class X {

    Integer mI = new Integer(7777);

    X() {
        this.mI = new Integer(19);
        meth();
    }

    protected void meth() {
        System.out.println("X.meth()" + mI);
    }
}

class Y extends X {

    Integer mI = new Integer(4711);

    Y() {
        this.mI = new Integer(18);
        super.meth();
        meth();
    }

    protected void meth() {
        System.out.println("Y.meth(): " + mI);
    }
}
