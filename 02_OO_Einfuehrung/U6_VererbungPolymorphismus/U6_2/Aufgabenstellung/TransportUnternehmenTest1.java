

public class TransportUnternehmenTest1 {
  
  public static void main(String[] args) {
    
    TransportUnternehmen transUnt = new TransportUnternehmen();
    transUnt.neuesFahrzeug(new Strassenfahrzeug( 3,  4, 0));
    transUnt.neuesFahrzeug(new Strassenfahrzeug(-3, -4, 0));
    transUnt.neuesFahrzeug(new Wasserfahrzeug(   9, 12, 0));
    transUnt.neuesFahrzeug(new Wasserfahrzeug(  -9, 12, 0));
    transUnt.printlnInfos();
    transUnt.allesFahren(0, 0);   // alle kommen nach hause ;-)
    transUnt.printlnInfos();
   
  }
  
} 


/* Session-Log:

TransportUnternehmen.printInfos():
Fz 1: Koord = 3.0/4.0  KM = 0.0
Fz 2: Koord = -3.0/-4.0KM = 0.0
Fz 3: Koord = 9.0/12.0 SM = 0.0
Fz 4: Koord = -9.0/12.0SM = 0.0
TransportUnternehmen.allesFahren(): 0.0/0.0
Fahrzeug.fahren(): 5.0
Strassenfahrzeug.fahren(): total KM: 5.0
Fahrzeug.fahren(): 5.0
Strassenfahrzeug.fahren(): total KM: 5.0
Fahrzeug.fahren(): 15.0
Wasserfahrzeug.fahren(): total SM: 8.099352051835853
Fahrzeug.fahren(): 15.0
Wasserfahrzeug.fahren(): total SM: 8.099352051835853
TransportUnternehmen.printInfos():
Fz 1: Koord = 0.0/0.0  KM = 5.0
Fz 2: Koord = 0.0/0.0  KM = 5.0
Fz 3: Koord = 0.0/0.0  SM = 8.099352051835853
Fz 4: Koord = 0.0/0.0  SM = 8.099352051835853

*/
