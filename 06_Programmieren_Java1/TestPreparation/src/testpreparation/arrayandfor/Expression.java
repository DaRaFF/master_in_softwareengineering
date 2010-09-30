package testpreparation.arrayandfor;

public class Expression {

    public static void main(String[] args) {
        int d = 5;
        System.out.println("Postinkrement von "+d+ " = " + d++);
        System.out.println("Präinkrement von "+d+ " = " + ++d);

        System.out.println("Ausdruck 8/3 = "+ 8/3);
        System.out.println("Ausdruck 8.0/3 = "+ 8.0/3);
        System.out.println("Ausdruck 11 % 8 = "+ 11 % 8);

        System.out.println("Ausdruck von 2 > 5 / 2 = "+ (7 > 5 / 2));

        System.out.println("Ein Leerstring ist vom Typ "+ "".getClass().getName());
    }
}

