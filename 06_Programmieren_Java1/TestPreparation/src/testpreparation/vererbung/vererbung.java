package testpreparation.vererbung;

public class vererbung {

    public static void main(String[] args) {
            X x = new Y();
    }
}

class X {

    X() {
        System.out.println("X.X()");
        meth();
    }

    protected void meth() {
        System.out.println("X.meth()");
    }
}

class Y extends X {

    Y() {
        System.out.println("Y.Y()");
    }

    protected void meth() {
        System.out.println("Y.meth(): ");
    }
}
