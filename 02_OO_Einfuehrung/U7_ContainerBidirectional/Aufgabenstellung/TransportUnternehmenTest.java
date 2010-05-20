//==============================================================================
//        * Letsch Informatik *       www.LetsInfo.ch       CH-8636 Wald
//          Beratung, Ausbildung und Realisation in Software-Engineering
//==============================================================================
// Project   : Master of Advanced Studies in Software-Engineering 2010
// Modul     : OO-Einführung mit UML und Java
//             Teil: UML -> Java
// Title     : Übung 7: Bidirektionale Kommunikation und Multiplizität * 
// Author    : Thomas Letsch
// Tab-Width : 2
/*///===========================================================================

* Description:
Klassen-Hierarchie mit "Fahrzeug" als Basis-Klasse.
Klasse "Strassenfahrzeug" und "Wasserfahrzeug" davon abgeleitet.
Strassenfahrzeug zusätzlich mit zurückgelegten Kilometer.
Wasserfahrzeug zusätzlich mit zurückgelegten Seemeilen.
Fahrzeug mit Datum der ersten Inverkehrssetzung.
Fahrzeug mit Markenname.
Rückmeldung des Treibstoffverbrauchs der Fahrzeuge an das Transport-Unternehmen.
Transport-Unternehmen mit beliebig vielen Fahrzeugen.

* History    :
15.05.2000: Initial-Version 
14.05.2001: Überall Elementinitialisierungsliste.
            WIN32-spezielle Anpassungen gelöscht.
01.05.2002: Von C++ auf Java portiert.
21.05.2003: Neue File-Aufteilung betref Eclipse.
30.05.2004: Neues Attribut 'ErsteInverkehrsSetzung' eingeführt.
01.06.2004: DateFormat ersetzt mit Date-Konstruktor (depricated!)
23.06.2005: Depricated Date-Konstruktor ersetzt.
15.05.2006: 'ErsteInverkehrsSetzung' von Übung 7 in Übung 6.
CVS: $Revision: 1.24 $  $Date: 2010/05/17 14:00:43 $ 
/*///===========================================================================
//       1         2         3         4         5         6         7         8
//345678901234567890123456789012345678901234567890123456789012345678901234567890
//==============================================================================

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Vector;

public class TransportUnternehmenTest {
  
  public static void main(String[] args) throws ParseException {

    DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMAN);

    TransportUnternehmen transUnt = new TransportUnternehmen();
    transUnt.neuesFahrzeug(new Strassenfahrzeug( 3,  4, "Fiat", 0,
                           df.parse("01.02.1995"), 20));
    transUnt.neuesFahrzeug(new Strassenfahrzeug(-3, -4, "Audi", 0,
                           df.parse("03.04.1997"), 20));
    transUnt.neuesFahrzeug(new Wasserfahrzeug(   9, 12, "Hensa", 0,
                           df.parse("05.06.1996"), 200));
    transUnt.neuesFahrzeug(new Wasserfahrzeug(  -9, 12, "Boesch", 0,
                           df.parse("07.08.1998"), 100));
    transUnt.printlnInfos();
    System.out.println("");
    transUnt.allesFahren(0, 0);
    System.out.println("");
    transUnt.printlnInfos();   
    String datum = "03.04.1997";
    System.out.println("\nFahrzeuge aelter als " + datum + ":");
    Vector<Fahrzeug> vec = transUnt.getFzAelterAls(df.parse(datum));
    for (int i = 0; i < vec.size(); i++) {
      vec.elementAt(i).printlnInfos(datum + " > ");
    }
    System.out.println("\nFahrzeuge mit Marke \"Audi\":");
    vec = transUnt.getFzMitMarke("Audi");
    for (int i = 0; i < vec.size(); i++) {
      vec.elementAt(i).printlnInfos("Audi "+(i+1));
    }

  }

} 




/* Session-Log:

TransportUnternehmen.printlnInfos():
Fz 1: Koord = 3.0/4.0   Fiat    01.02.1995      Trst = 0.0      KM = 0.0
Fz 2: Koord = -3.0/-4.0 Audi    03.04.1997      Trst = 0.0      KM = 0.0
Fz 3: Koord = 9.0/12.0  Hensa   05.06.1996      Trst = 0.0      SM = 0.00
Fz 4: Koord = -9.0/12.0 Boesch  07.08.1998      Trst = 0.0      SM = 0.00
Total verbrauchter Treibstoff = 0.0

TransportUnternehmen.allesFahren(): 0.0/0.0
Fahrzeug.fahren(): 5.0
Strassenfahrzeug.fahren(): total KM: 5.0
Fahrzeug.fahren(): 5.0
Strassenfahrzeug.fahren(): total KM: 5.0
Fahrzeug.fahren(): 15.0
Wasserfahrzeug.fahren(): total SM: 8.10
Fahrzeug.fahren(): 15.0
Wasserfahrzeug.fahren(): total SM: 8.10

TransportUnternehmen.printlnInfos():
Fz 1: Koord = 0.0/0.0   Fiat    01.02.1995      Trst = 1.0      KM = 5.0
Fz 2: Koord = 0.0/0.0   Audi    03.04.1997      Trst = 1.0      KM = 5.0
Fz 3: Koord = 0.0/0.0   Hensa   05.06.1996      Trst = 30.0     SM = 8.10
Fz 4: Koord = 0.0/0.0   Boesch  07.08.1998      Trst = 15.0     SM = 8.10
Total verbrauchter Treibstoff = 47.0

Fahrzeuge aelter als 03.04.1997:
03.04.1997 > : Koord = 0.0/0.0  Fiat    01.02.1995      Trst = 1.0      KM = 5.0
03.04.1997 > : Koord = 0.0/0.0  Hensa   05.06.1996      Trst = 30.0     SM = 8.10

Fahrzeuge mit Marke "Audi":
Audi 1: Koord = 0.0/0.0 Audi    03.04.1997      Trst = 1.0      KM = 5.0

*/
