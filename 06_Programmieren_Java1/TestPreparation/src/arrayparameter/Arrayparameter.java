package arrayparameter;

public class Arrayparameter {

    public int[] intArr;
    public int a;

    public static void main(String[] args) {
        Arrayparameter arrpar = new Arrayparameter();
        arrpar.intArr = new int[10];
        for (int i = 0; i < arrpar.intArr.length; i++) {
            arrpar.intArr[i] = i;
            System.out.println("arrpar vor function:" + arrpar.intArr[i]);
        }
        arrpar.testArr(arrpar.intArr);
        for (int i = 0; i < arrpar.intArr.length; i++) {
            System.out.println("arrpar nach function:" + arrpar.intArr[i]);
        }

        arrpar.a = 0;
        System.out.println("intvar vor function:" + arrpar.a);
        arrpar.testFunc(arrpar.a);
        System.out.println("intvar nach function:" + arrpar.a);
    }

    public void testArr(int[] arr){
        arr[0] = 10;
        arr[8] = 18;
    }

    public void testFunc(int a){
        a = 77;
    }
}
