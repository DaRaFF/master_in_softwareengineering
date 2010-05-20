//==============================================================================
//        * Letsch Informatik *       www.LetsInfo.ch       CH-8636 Wald
//          Beratung, Ausbildung und Realisation in Software-Engineering
//==============================================================================
// Project   : Master of Advanced Studies in Software-Engineering 2010
// Modul     : OO-Einführung mit UML und Java
//             Teil: UML -> Java
// Title     : Übung 6: Vererbung+Polymorphismus und Date-Klasse
// Author    : Thomas Letsch
// Tab-Width : 2
/*///===========================================================================

* Description:
Klassen-Hierarchie mit "Fahrzeug" als Basis-Klasse.
Klasse "Strassenfahrzeug" und "Wasserfahrzeug" davon abgeleitet.
Strassenfahrzeug zusätzlich mit zurückgelegten Kilometer.
Wasserfahrzeug zusätzlich mit zurückgelegten Seemeilen.
Transport-Unternehmen mit mehreren Fahrzeugen.
Fahrzeug mit Datum der ersten Inverkehrssetzung.

* History    :
09.05.1999: Initial-Version
10.05.2000: WIN32
14.05.2001: Überall Elementinitialisierungsliste.
            WIN32-spezielle Anpassungen gelöscht.
25.04.2002: Von C++ auf Java portiert.
14.05.2003: Neue File-Aufteilung betref Eclipse.
14.05.2004: Kosmetik. 
16.05.2005: TransportUnternehmenTest::printInfos() -> printlnInfos.
15.05.2006: 'ErsteInverkehrsSetzung' von Übung 7 in Übung 6.
CVS: $Revision: 1.16 $  $Date: 2010/05/11 08:40:07 $ 
/*///===========================================================================
//       1         2         3         4         5         6         7         8
//345678901234567890123456789012345678901234567890123456789012345678901234567890
//==============================================================================

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Vector;

public class TransportUnternehmenTest2 {
  
  public static void main(String[] args) throws ParseException {
    
    DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMAN);
    
    TransportUnternehmen transUnt = new TransportUnternehmen();
    transUnt.neuesFahrzeug(new Strassenfahrzeug( 3,  4, 0, 
                           df.parse("01.02.1995")));
    transUnt.neuesFahrzeug(new Strassenfahrzeug(-3, -4, 0, 
                           df.parse("03.04.1997")));
    transUnt.neuesFahrzeug(new Wasserfahrzeug(   9, 12, 0,
                           df.parse("05.06.1996")));
    transUnt.neuesFahrzeug(new Wasserfahrzeug(  -9, 12, 0,
                           df.parse("07.08.1998")));
    transUnt.printlnInfos();
    transUnt.allesFahren(0, 0);   // alle kommen nach hause ;-)
    transUnt.printlnInfos();
    String datum = "03.04.1997";
    System.out.println("Fahrzeuge aelter als " + datum + ":");
    Vector<Fahrzeug> vec = transUnt.getFzAelterAls(df.parse(datum));
    for (int i = 0; i < vec.size(); i++) {
      vec.elementAt(i).printlnInfos(datum + " > ");
    }
   
  }
  
} 


/* Session-Log:

TransportUnternehmen.printInfos():
Fz 1: Koord = 3.0/4.0   01.02.1995      KM = 0.0
Fz 2: Koord = -3.0/-4.0 03.04.1997      KM = 0.0
Fz 3: Koord = 9.0/12.0  05.06.1996      SM = 0.0
Fz 4: Koord = -9.0/12.0 07.08.1998      SM = 0.0
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
Fz 1: Koord = 0.0/0.0   01.02.1995      KM = 5.0
Fz 2: Koord = 0.0/0.0   03.04.1997      KM = 5.0
Fz 3: Koord = 0.0/0.0   05.06.1996      SM = 8.099352051835853
Fz 4: Koord = 0.0/0.0   07.08.1998      SM = 8.099352051835853
Fahrzeuge aelter als 03.04.1997:
03.04.1997 > : Koord = 0.0/0.0  01.02.1995      KM = 5.0
03.04.1997 > : Koord = 0.0/0.0  05.06.1996      SM = 8.099352051835853

*/
