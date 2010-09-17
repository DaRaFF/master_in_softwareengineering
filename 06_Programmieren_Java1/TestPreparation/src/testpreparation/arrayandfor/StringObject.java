package testpreparation.arrayandfor;

public class StringObject {
    public static void main(String[] args) {
        char[] charData = {'A','n','j','a'};
        String data1 = new String(charData);
        String data2 = "Anja";
        String data3 = "Anja";
        String data4 = new String("Anja");
        if(data2 == data3){
           System.out.println("Die beiden Referenzen data2 und data3 zeigen auf das gleiche Objekt");
        }
        if(data2.equals(data3)){
           System.out.println("Die beiden Objekte data2 und data3 sind die gleichen");
        }
        if(data2 == data4){
           System.out.println("Die beiden Referenzen data2 und data4 zeigen auf das gleiche Objekt");
        }
        if(data2.equals(data4)){
           System.out.println("Die beiden Objekte data2 und data4 sind die gleichen");
        }
    }
}
