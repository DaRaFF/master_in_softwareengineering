//==============================================================================
// Project   : Master of Advanced Studies in Software-Engineering 2010
// Modul     : Projektarbeit OO Softwareentwicklung "Warenautomat"
//             Teil: Design&Implementation
// Title     : Test-Applikation
// Author    : `Ihr Name`
// Tab-Width : 2
/*///===========================================================================

* Description:
Test-Applikation um die Klassen-Bibliothek des Waren-Automaten zu testen.

* History    :
14.09.2005: Initial-Version.
02.06.2008: GUI hinzugef�gt.
CVS: $Revision: 1.5 $  $Date: 2010/06/07 19:08:15 $ 
/*///===========================================================================
//       1         2         3         4         5         6         7         8
//345678901234567890123456789012345678901234567890123456789012345678901234567890
//==============================================================================

import WarenAutomat.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

public class WarenAutomatTest { 

  public static void main(String[] args) throws ParseException {

    DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMAN);

    { 
      Automat automat = new Automat();
      System.out.println("=== Drehteller-Test: =================================");
      
      System.out.println("*** Drehteller Nr.1 mit einem \"Eins\" f�llen:");
      automat.fuelleFach(1, "Eins", 1.00, df.parse("01.01.2001"));
      System.out.println("*** automat.drehen():");      
      automat.drehen();
//      System.out.println("*** Drehteller Nr.2 mit einem \"Zwei\" f�llen:");
//      automat.fuelleFach(2, "Zwei", 2.00, df.parse("01.01.2002"));
//      SystemSoftware.output(false);
//      System.out.println("*** automat.drehen():");      
//      automat.drehen();
//      SystemSoftware.output(true);
//      System.out.println("*** Drehteller Nr.3 mit einem \"Drei\" f�llen:");
//      automat.fuelleFach(3, "Drei", 3.00, df.parse("01.01.2003"));
//      SystemSoftware.output(false);
//      System.out.println("*** Drehen bis Fach Nr.16 vor der �ffnung ist:");
//      for (int i = 4; i <= 16; i++) {
//        automat.drehen();
//      }
//      SystemSoftware.output(true);
//      System.out.println("*** automat.drehen(): jetzt Fach Nr. 1:");      
//      automat.drehen();
//      System.out.println("*** automat.drehen(): jetzt Fach Nr. 2:");      
//      automat.drehen();
//      System.out.println("*** automat.drehen(): jetzt Fach Nr. 3:");      
//      automat.drehen();
//        
//      System.out.println("=== Drehteller-Test. =================================");
// 
      
//      System.out.println("=== �ffnen-Test: =====================================");
//
//      System.out.println("*** Drehteller Nr.5 mit einem Mars f�llen:");
//      automat.fuelleFach(5, "Mars", 1.50, df.parse("01.01.2100"));
//      System.out.println("*** Automat.gibTotalenWarenWert() = " 
//          + automat.gibTotalenWarenWert());
//      Kasse kasse = automat.gibKasse();
//      System.out.println("*** kasse.einnehmen(1.00):");
//      kasse.einnehmen(1.00);
//      System.out.println("*** kasse.einnehmen(0.50):");
//      kasse.einnehmen(0.50);
//      System.out.println("*** automat.oeffnen(5):");
//      System.out.println("*** automat.oeffnen(5): " + automat.oeffnen(5));
//      
//      System.out.println("=== �ffnen-Test. =====================================");
//     
//      // ... etc. ...
      
    }
    
  }

}


/* Session-Log:

=== Drehteller-Test: =================================
*** Drehteller Nr.1 mit einem "Eins" f�llen:
SystemSoftware::zeigeWarenPreisAn():  1: 1.0
SystemSoftware::zeigeVerfallsDatum(): 1: 2
*** automat.drehen():
SystemSoftware::zeigeWarenPreisAn():  1: 0.0
SystemSoftware::zeigeVerfallsDatum(): 1: 0
SystemSoftware::zeigeWarenPreisAn():  2: 0.0
SystemSoftware::zeigeVerfallsDatum(): 2: 0
SystemSoftware::zeigeWarenPreisAn():  3: 0.0
SystemSoftware::zeigeVerfallsDatum(): 3: 0
SystemSoftware::zeigeWarenPreisAn():  4: 0.0
SystemSoftware::zeigeVerfallsDatum(): 4: 0
SystemSoftware::zeigeWarenPreisAn():  5: 0.0
SystemSoftware::zeigeVerfallsDatum(): 5: 0
SystemSoftware::zeigeWarenPreisAn():  6: 0.0
SystemSoftware::zeigeVerfallsDatum(): 6: 0
SystemSoftware::zeigeWarenPreisAn():  7: 0.0
SystemSoftware::zeigeVerfallsDatum(): 7: 0
*** Drehteller Nr.2 mit einem "Zwei" f�llen:
SystemSoftware::zeigeWarenPreisAn():  2: 2.0
SystemSoftware::zeigeVerfallsDatum(): 2: 2
SystemSoftware::output(): false
*** automat.drehen():
SystemSoftware::output(): true
*** Drehteller Nr.3 mit einem "Drei" f�llen:
SystemSoftware::zeigeWarenPreisAn():  3: 3.0
SystemSoftware::zeigeVerfallsDatum(): 3: 2
SystemSoftware::output(): false
*** Drehen bis Fach Nr.16 vor der �ffnung ist:
SystemSoftware::output(): true
*** automat.drehen(): jetzt Fach Nr. 1:
SystemSoftware::zeigeWarenPreisAn():  1: 1.0
SystemSoftware::zeigeVerfallsDatum(): 1: 2
SystemSoftware::zeigeWarenPreisAn():  2: 0.0
SystemSoftware::zeigeVerfallsDatum(): 2: 0
SystemSoftware::zeigeWarenPreisAn():  3: 0.0
SystemSoftware::zeigeVerfallsDatum(): 3: 0
SystemSoftware::zeigeWarenPreisAn():  4: 0.0
SystemSoftware::zeigeVerfallsDatum(): 4: 0
SystemSoftware::zeigeWarenPreisAn():  5: 0.0
SystemSoftware::zeigeVerfallsDatum(): 5: 0
SystemSoftware::zeigeWarenPreisAn():  6: 0.0
SystemSoftware::zeigeVerfallsDatum(): 6: 0
SystemSoftware::zeigeWarenPreisAn():  7: 0.0
SystemSoftware::zeigeVerfallsDatum(): 7: 0
*** automat.drehen(): jetzt Fach Nr. 2:
SystemSoftware::zeigeWarenPreisAn():  1: 0.0
SystemSoftware::zeigeVerfallsDatum(): 1: 0
SystemSoftware::zeigeWarenPreisAn():  2: 2.0
SystemSoftware::zeigeVerfallsDatum(): 2: 2
SystemSoftware::zeigeWarenPreisAn():  3: 0.0
SystemSoftware::zeigeVerfallsDatum(): 3: 0
SystemSoftware::zeigeWarenPreisAn():  4: 0.0
SystemSoftware::zeigeVerfallsDatum(): 4: 0
SystemSoftware::zeigeWarenPreisAn():  5: 0.0
SystemSoftware::zeigeVerfallsDatum(): 5: 0
SystemSoftware::zeigeWarenPreisAn():  6: 0.0
SystemSoftware::zeigeVerfallsDatum(): 6: 0
SystemSoftware::zeigeWarenPreisAn():  7: 0.0
SystemSoftware::zeigeVerfallsDatum(): 7: 0
*** automat.drehen(): jetzt Fach Nr. 3:
SystemSoftware::zeigeWarenPreisAn():  1: 0.0
SystemSoftware::zeigeVerfallsDatum(): 1: 0
SystemSoftware::zeigeWarenPreisAn():  2: 0.0
SystemSoftware::zeigeVerfallsDatum(): 2: 0
SystemSoftware::zeigeWarenPreisAn():  3: 3.0
SystemSoftware::zeigeVerfallsDatum(): 3: 2
SystemSoftware::zeigeWarenPreisAn():  4: 0.0
SystemSoftware::zeigeVerfallsDatum(): 4: 0
SystemSoftware::zeigeWarenPreisAn():  5: 0.0
SystemSoftware::zeigeVerfallsDatum(): 5: 0
SystemSoftware::zeigeWarenPreisAn():  6: 0.0
SystemSoftware::zeigeVerfallsDatum(): 6: 0
SystemSoftware::zeigeWarenPreisAn():  7: 0.0
SystemSoftware::zeigeVerfallsDatum(): 7: 0
=== Drehteller-Test. =================================
=== �ffnen-Test: =====================================
*** Drehteller Nr.5 mit einem Mars f�llen:
SystemSoftware::zeigeWarenPreisAn():  5: 1.5
SystemSoftware::zeigeVerfallsDatum(): 5: 1
*** Automat.gibTotalenWarenWert() = 1.5
*** kasse.einnehmen(1.00):
SystemSoftware::zeigeBetragAn(): 1.0
*** kasse.einnehmen(0.50):
SystemSoftware::zeigeBetragAn(): 1.5
*** automat.oeffnen(5):
Drehteller::oeffnen(): mDrehtellerNr = 5 / mFachVorOeffnung = 3
SystemSoftware::zeigeBetragAn(): 0.0
SystemSoftware::entriegeln(): 5
SystemSoftware::zeigeWarenPreisAn():  5: 0.0
SystemSoftware::zeigeVerfallsDatum(): 5: 0
*** automat.oeffnen(5): true
=== �ffnen-Test. =====================================

*/
