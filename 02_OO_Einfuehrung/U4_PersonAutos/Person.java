/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author daraff
 */
public class Person {
    String name;
    String kennzeichen;

    public String getKennzeichen() {
        return this.kennzeichen;
    }
    int alter;
    Auto[] auto = new Auto[5];
    int anzAutos = 0;

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    Boolean addAuto(Auto auto) {
        if((anzAutos+1) <= this.auto.length ){
            this.auto[anzAutos] = auto;
            anzAutos++;
            return true;
        }
        else{
            return false;
        }
    }

    void printAutos() {
      for(int i = 0; i < auto.length; i++){
          if(auto[i] != null){
              System.out.println("Auto Nr. " + (i+1) + ":");
              System.out.println("\t Marke \t : " + auto[i].getMarke());
              System.out.println("\t Kennzeichen : " + auto[i].getKennzeichen());
          }
          else{
              System.out.println("Auto Nr. " + (i+1) + ": null");
          }
      }
    }

    

}
