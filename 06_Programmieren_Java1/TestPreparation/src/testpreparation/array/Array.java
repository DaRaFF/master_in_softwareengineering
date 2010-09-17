package testpreparation.array;

public class Array {

    public static void main(String[] args) {
        X[] xArr = new X[10];
        for (int x = 0; x < xArr.length; x++) {
            if (xArr[x] != null) {
                for (int y = 0; y < xArr[x].mYArr.length; y++) {
                    if (xArr[x].mYArr[y] != null
                            && xArr[x].mYArr[y].mValue == 4711) {
                        System.out.println(xArr[x].mYArr[y].mName);
                    }
                }


            }

        }
    }
}
