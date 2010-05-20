//==============================================================================
//        * Letsch Informatik *       www.LetsInfo.ch       CH-8636 Wald
//          Beratung, Ausbildung und Realisation in Software-Engineering
//==============================================================================
// Project   : Master of Advanced Studies in Software-Engineering 2010
// Modul     : OO-Einführung mit UML und Java
//             Teil: UML -> Java
// Title     : Übung 5: Klassen-Hierarchie 'Fahrzeuge'
// Author    : Thomas Letsch
// Tab-Width : 2
/*///===========================================================================

* Description: 
Klassen-Hierarchie mit "Fahrzeug" als Basis-Klasse. 
Klasse "Strassenfahrzeug" und "Wasserfahrzeug" davon abgeleitet.
Strassenfahrzeug zusätzlich mit zurückgelegten Kilometer.
Wasserfahrzeug zusätzlich mit zurückgelegten Seemeilen.

* History    :
02.05.1999: Initial-Version 
07.05.2000: WIN32
10.05.2001: WIN32-spezielle Anpassungen gelöscht.
14.05.2001: Fahrzeug::fahren() mit korrektem Trace. 
18.04.2002: Von C++ auf Java portiert.
07.05.2003: Neue File-Aufteilung betref Eclipse.
06.05.2004: Kosmetik.
21.08.2005: Fahrzeug::printInfos(); public -> protected.
07.05.2007: Referenz-Typ nur noch 'Fahrzeug'.
CVS: $Revision: 1.10 $  $Date: 2008/05/05 12:30:56 $ 
/*///===========================================================================
//       1         2         3         4         5         6         7         8
//345678901234567890123456789012345678901234567890123456789012345678901234567890
//==============================================================================


public class FahrzeugeTest {

  public static void main(String[] args) {
        
    System.out.println("\n=== fz = new Fahrzeug(0, 0): ================");
    Fahrzeug fz = new Fahrzeug(0, 0);
    System.out.println("=== fz.fahren(3, 4): ========================");
    fz.fahren(3, 4);
    fz.printlnInfos("fz");
    System.out.println("\n=== fz.fahren(-1, 1): =======================");
    fz.fahren(-1, 1);
    fz.printlnInfos("fz");
    
    System.out.println("\n=== sfz = new Strassenfahrzeug(0, 0, 0): ===");
    Fahrzeug sfz = new Strassenfahrzeug(0, 0, 0);
    System.out.println("=== sfz.fahren(3, 4): ======================");
    sfz.fahren(3, 4);
    sfz.printlnInfos("sfz");
    System.out.println("\n=== sfz.fahren(-1, 1): =====================");
    sfz.fahren(-1, 1);
    sfz.printlnInfos("sfz");
    
    System.out.println("\n=== wfz = new Wasserfahrzeug(0, 0, 0): ===");
    Fahrzeug wfz = new Wasserfahrzeug(0, 0, 0);
    System.out.println("=== wfz.fahren(3, 4): ======================");
    wfz.fahren(3, 4);
    wfz.printlnInfos("wfz");
    
  }

}


/* Session-Log:

=== fz = new Fahrzeug(0, 0): ================
=== fz.fahren(3, 4): ========================
Fahrzeug.fahren(): 5.0
fz: Koord = 3.0/4.0

=== fz.fahren(-1, 1): =======================
Fahrzeug.fahren(): 5.0
fz: Koord = -1.0/1.0

=== sfz = new Strassenfahrzeug(0, 0, 0): ===
=== sfz.fahren(3, 4): ======================
Fahrzeug.fahren(): 5.0
Strassenfahrzeug.fahren(): total KM: 5.0
sfz: Koord = 3.0/4.0    KM = 5.0

=== sfz.fahren(-1, 1): =====================
Fahrzeug.fahren(): 5.0
Strassenfahrzeug.fahren(): total KM: 10.0
sfz: Koord = -1.0/1.0   KM = 10.0

=== wfz = new Wasserfahrzeug(0, 0, 0): ===
=== wfz.fahren(3, 4): ======================
Fahrzeug.fahren(): 5.0
Wasserfahrzeug.fahren(): total SM: 2.6997840172786174
wfz: Koord = 3.0/4.0    SM = 2.6997840172786174

*/
