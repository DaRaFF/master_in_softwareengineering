package testpreparation.alphabetinstantiation;

public class B extends A {

    private F mF;

    B() {
        mF = new F();
        System.out.print("B ");
    }

    B(int i) {
        mF = new F();
        System.out.print("B1 ");
    }
}
