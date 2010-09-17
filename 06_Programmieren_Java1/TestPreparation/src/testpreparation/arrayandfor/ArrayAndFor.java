package testpreparation.arrayandfor;

public class ArrayAndFor {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("lengt: "+array.length);
        for (int i = array.length - 2; i > 0; i = i - 2) {
            System.out.println(array[i]+" ");
        }
    }
}
