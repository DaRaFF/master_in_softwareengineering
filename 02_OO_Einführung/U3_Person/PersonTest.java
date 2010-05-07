package u3_person;



//==============================================================================
//        * Letsch Informatik *       www.LetsInfo.ch       CH-8636 Wald
//          Beratung, Ausbildung und Realisation in Software-Engineering
//==============================================================================
// Project   : Master of Advanced Studies in Software-Engineering 2010
// Modul     : OO-Einf�hrung mit UML und Java
//             Teil: UML -> Java
// Title     : �bung 3: Klasse Person
// Author    : Thomas Letsch 
// Tab-Width : 2
/*///===========================================================================
* Description: Klasse Person.
* History    :
02.05.1999: Initial-Version
07.05.2000: WIN32
05.05.2001: WIN32-spezielle Anpassungen gel�scht
12.04.2002: Von C++ auf Java portiert.
02.05.2003: Neue File-Aufteilung betref Eclipse.
29.04.2004: Kosmetik
CVS: $Revision: 1.11 $  $Date: 2010/05/02 21:00:03 $
/*///===========================================================================
//       1         2         3         4         5         6         7         8
//345678901234567890123456789012345678901234567890123456789012345678901234567890
//==============================================================================


public class PersonTest { 
  
  public static void main(String[] args) { 
    
    Person pers = new Person();		 
    String name = "John";
    pers.setName(name);
    pers.setAlter(40);
    System.out.println("Name der Person  : " + pers.getName());
    System.out.println("Alter der Person : " + pers.getAlter());
    
  }
}


/* Session-Log:

Name der Person  : John
Alter der Person : 40

*/
