//==============================================================================
//        * Letsch Informatik *       www.LetsInfo.ch       CH-8636 Wald
//          Beratung, Ausbildung und Realisation in Software-Engineering
//==============================================================================
// Project   : Master of Advanced Studies in Software-Engineering 2010
// Modul     : OO-Einf�hrung mit UML und Java
//             Teil: UML -> Java
// Title     : �bung 4: Assoziation: Klassen Person und Autos
// Author    : Thomas Letsch 
// Tab-Width : 2
/*///===========================================================================
* Description: Klassen Person mit Klasse Auto mittels Array.
* History    :
02.05.1999: Initial-Version
07.05.2000: mAnzahlAutos, WIN32
05.05.2001: WIN32-spezielle Anpassungen gel�scht
12.04.2002: Von C++ auf Java portiert.
02.05.2003: Neue File-Aufteilung betref Eclipse.
29.04.2004: Kosmetik
CVS: $Revision: 1.11 $  $Date: 2010/05/02 21:22:24 $
/*///===========================================================================
//       1         2         3         4         5         6         7         8
//345678901234567890123456789012345678901234567890123456789012345678901234567890
//==============================================================================




// Test-Applikation:

public class PersonAutosTest {
  
  public static void main(String[] args) {
    
    Person pers = new Person();
    System.out.println("\naddAuto()'s:");
    Auto wagen1 = new Auto("Marke1", "Kennzeichen1");
    System.out.println("pers.addAuto(wagen1) = " + pers.addAuto(wagen1));
    Auto wagen2 = new Auto("Marke2", "Kennzeichen2");
    System.out.println("pers.addAuto(wagen2) = " + pers.addAuto(wagen2));
    System.out.println("\nprintAutos():");
    pers.printAutos();
    System.out.println("\naddAuto()'s:");
    Auto wagen3 = new Auto("Marke3", "Kennzeichen3");
    System.out.println("pers.addAuto(wagen3) = " + pers.addAuto(wagen3));
    Auto wagen4 = new Auto("Marke4", "Kennzeichen4");
    System.out.println("pers.addAuto(wagen4) = " + pers.addAuto(wagen4));
    Auto wagen5 = new Auto("Marke5", "Kennzeichen5");
    System.out.println("pers.addAuto(wagen5) = " + pers.addAuto(wagen5));
    Auto wagen6 = new Auto("Marke6", "Kennzeichen6");
    System.out.println("pers.addAuto(wagen6) = " + pers.addAuto(wagen6));
    System.out.println("\nprintAutos():");
    pers.printAutos();
    
  }
  
}


/* Session-Log:

addAuto()'s:
pers.addAuto(wagen1) = true
pers.addAuto(wagen2) = true

printAutos():
Auto Nr. 1: 
  Marke       : Marke1
  Kennzeichen : Kennzeichen1
Auto Nr. 2: 
  Marke       : Marke2
  Kennzeichen : Kennzeichen2
Auto Nr. 3: null
Auto Nr. 4: null
Auto Nr. 5: null

addAuto()'s:
pers.addAuto(wagen3) = true
pers.addAuto(wagen4) = true
pers.addAuto(wagen5) = true
pers.addAuto(wagen6) = false

printAutos():
Auto Nr. 1: 
  Marke       : Marke1
  Kennzeichen : Kennzeichen1
Auto Nr. 2: 
  Marke       : Marke2
  Kennzeichen : Kennzeichen2
Auto Nr. 3: 
  Marke       : Marke3
  Kennzeichen : Kennzeichen3
Auto Nr. 4: 
  Marke       : Marke4
  Kennzeichen : Kennzeichen4
Auto Nr. 5: 
  Marke       : Marke5
  Kennzeichen : Kennzeichen5

*/
