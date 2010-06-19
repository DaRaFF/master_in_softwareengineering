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
 02.06.2008: GUI hinzugefï¿½gt.
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
			SystemSoftware.erzeugeGUI(automat);
			System.out.println("=== Drehteller-Test: =================================");
			System.out.println("*** Drehteller Nr.1 mit einem \"Eins\" füllen:");
			automat.fuelleFach(1, "Eins", 1.00, df.parse("01.01.2001"));
			System.out.println("*** automat.drehen():");
			automat.drehen();
			System.out.println("*** Drehteller Nr.2 mit einem \"Zwei\" füllen:");
			automat.fuelleFach(2, "Zwei", 2.00, df.parse("01.01.2002"));
			SystemSoftware.output(false);
			System.out.println("*** automat.drehen():");
			automat.drehen();
			SystemSoftware.output(true);
			System.out.println("*** Drehteller Nr.3 mit einem \"Drei\" füllen:");
			automat.fuelleFach(3, "Drei", 3.00, df.parse("01.01.2003"));
			SystemSoftware.output(false);
			System.out.println("*** Drehen bis Fach Nr.16 vor der öffnung ist:");
			for (int i = 4; i <= 16; i++) {
				automat.drehen();
			}
			SystemSoftware.output(true);
			System.out.println("*** automat.drehen(): jetzt Fach Nr. 1:");
			automat.drehen();
			System.out.println("*** automat.drehen(): jetzt Fach Nr. 2:");
			automat.drehen();
			System.out.println("*** automat.drehen(): jetzt Fach Nr. 3:");
			automat.drehen();
			        
			System.out.println("=== Drehteller-Test. =================================");
			 

			 System.out.println("=== öffnen-Test: =====================================");
			
			 System.out.println("*** Drehteller Nr.5 mit einem Mars füllen:");
			 automat.fuelleFach(5, "Mars", 1.50, df.parse("01.01.2100"));
			 System.out.println("*** Automat.gibTotalenWarenWert() = "
			 + automat.gibTotalenWarenWert());
			 Kasse kasse = automat.gibKasse();
			 System.out.println("*** kasse.einnehmen(1.00):");
			 kasse.einnehmen(1.00);
			 System.out.println("*** kasse.einnehmen(0.50):");
			 kasse.einnehmen(0.50);
			 System.out.println("*** automat.oeffnen(5):");
			 System.out.println("*** automat.oeffnen(5): " + automat.oeffnen(5));
			      
			 System.out.println("=== öffnen-Test. =====================================");
			 
			 System.out.println("=== öffnen-Test2: =====================================");
				
			 System.out.println("*** Drehteller Nr.5 (leeres Fach) oeffnen:");
			 System.out.println("*** automat.oeffnen(5): " + automat.oeffnen(5));
			 System.out.println("*** Drehteller Nr.5 mit Bounty das abgelaufen ist füllen:");
			 automat.fuelleFach(5, "Bounty", 1.50, df.parse("01.01.2000"));
			 System.out.println("*** automat.oeffnen(5): " + automat.oeffnen(5));
			 System.out.println("*** Drehteller Nr.6 mit Bounty das nicht abgelaufen ist füllen, aber es wurde zu wenig Geld eingeworfen:");
			 kasse.einnehmen(1.00);
			 automat.fuelleFach(6, "Bounty", 1.70, df.parse("01.01.2100"));
			 System.out.println("*** automat.oeffnen(6): " + automat.oeffnen(6));
			 System.out.println("*** Drehteller Nr.7 mit Bounty füllen, genug Geld, aber kein Wechselgeld:");
			 automat.fuelleFach(7, "Bounty", 0.60, df.parse("01.01.2100"));
			 System.out.println("*** automat.oeffnen(7): " + automat.oeffnen(7));	
			 System.out.println("=== öffnen-Test2. =====================================");
			 
			 
			 System.out.println("=== öffnen-Test3 - Betrag verkaufte Waren: =====================================");
				
			 System.out.println("*** Drehteller Nr.6:");
			 System.out.println("*** kasse.gibBetragVerkaufteWaren vorher: " + kasse.gibBetragVerkaufteWaren());
			 SystemSoftware.output(false);
			 automat.drehen();
			 automat.fuelleFach(1, "Bounty", 2.00, df.parse("01.01.2011"));
			 automat.fuelleFach(2, "Bounty", 2.00, df.parse("01.01.2011"));
			 automat.fuelleFach(3, "Bounty", 2.00, df.parse("01.01.2011"));
			 automat.fuelleFach(4, "Bounty", 2.00, df.parse("01.01.2011"));
			 kasse.einnehmen(2.00);
			 System.out.println("*** automat.oeffnen(1): " + automat.oeffnen(1));
			 kasse.einnehmen(2.00);
			 System.out.println("*** automat.oeffnen(2): " + automat.oeffnen(2));
			 kasse.einnehmen(2.00);
			 System.out.println("*** automat.oeffnen(3): " + automat.oeffnen(3));
			 kasse.einnehmen(2.00);
			 System.out.println("*** automat.oeffnen(4): " + automat.oeffnen(4));
			 kasse.einnehmen(2.00);
			 System.out.println("*** kasse.gibBetragVerkaufteWaren: " + kasse.gibBetragVerkaufteWaren());
			 SystemSoftware.output(true);
			 System.out.println("=== öffnen-Test3. =====================================");
			 
			 System.out.println("=== Total Warenwert-Test: =====================================");
				
			 System.out.println("*** Drehteller Nr.7:");
			 SystemSoftware.output(false);
			 automat.drehen();
			 SystemSoftware.output(true);
			 automat.fuelleFach(1, "Bounty", 2.00, df.parse("01.01.2011"));
			 System.out.println("*** Totaler Warenwert start: " + automat.gibTotalenWarenWert());
			 automat.fuelleFach(2, "Bounty", 2.00, df.parse("01.01.2011"));
			 System.out.println("*** Totaler Warenwert: " + automat.gibTotalenWarenWert());
			 automat.fuelleFach(3, "Bounty", 2.00, df.parse("01.01.2011"));
			 System.out.println("*** Totaler Warenwert: " + automat.gibTotalenWarenWert());
			 automat.fuelleFach(4, "Bounty", 2.00, df.parse("01.01.2009"));
			 System.out.println("*** Totaler Warenwert: " + automat.gibTotalenWarenWert());
			 SystemSoftware.output(false);
			 kasse.einnehmen(2.00);
			 System.out.println("*** automat.oeffnen(1): " + automat.oeffnen(1));
			 kasse.einnehmen(2.00);
			 System.out.println("*** automat.oeffnen(2): " + automat.oeffnen(2));
			 kasse.einnehmen(2.00);
			 System.out.println("*** automat.oeffnen(3): " + automat.oeffnen(3));
			 kasse.einnehmen(2.00);
			 System.out.println("*** automat.oeffnen(4): " + automat.oeffnen(4));
			 kasse.einnehmen(2.00);
			 System.out.println("*** Totaler Warenwert: " + automat.gibTotalenWarenWert());
			 SystemSoftware.output(true);
			 System.out.println("=== Total Warenwert-Test. =====================================");
			 
			 
			 System.out.println("=== Anzeige Statistik-Test: =====================================");
			 SystemSoftware.output(false);
			 
			 SystemSoftware.setzeAktuellesDatum(df.parse("01.01.1990"));
			 automat.fuelleFach(1, "Bounty", 2.00, df.parse("01.01.2011"));
			 kasse.einnehmen(2.00);
			 automat.oeffnen(1);
			 
			 SystemSoftware.setzeAktuellesDatum(df.parse("01.01.1991"));
			 automat.fuelleFach(1, "Bounty", 2.00, df.parse("01.01.2011"));
			 kasse.einnehmen(2.00);
			 automat.oeffnen(1);
			 
			 SystemSoftware.setzeAktuellesDatum(df.parse("01.01.1992"));
			 automat.fuelleFach(1, "Bounty", 2.00, df.parse("01.01.2011"));
			 kasse.einnehmen(2.00);
			 automat.oeffnen(1);
			 
			 SystemSoftware.setzeAktuellesDatum(df.parse("02.01.1992"));
			 automat.fuelleFach(1, "Bounty", 2.00, df.parse("01.01.2011"));
			 kasse.einnehmen(2.00);
			 automat.oeffnen(1);
			 
			 System.out.println("*** Anzeige Statistik - Verkaufte Bountys: " + automat.gibVerkaufsStatistik("Bounty", df.parse("01.01.1991")));
			 System.out.println("*** Anzeige Statistik - Verkaufte Bountys: " + automat.gibVerkaufsStatistik("Bounty", df.parse("01.01.1992")));
			 System.out.println("*** Anzeige Statistik - Verkaufte Bountys: " + automat.gibVerkaufsStatistik("Bounty", df.parse("01.01.1993")));

			 
			 SystemSoftware.output(true);
			 
			 
			 System.out.println("=== Bestellung-Test. =====================================");
			 SystemSoftware.setzeAktuellesDatum(df.parse("01.01.2020"));
			 automat.konfiguriereBestellung("Fanta", 5, 20);
			 automat.konfiguriereBestellung("Cola", 4, 5);			 
			 automat.drehen(); //Fach6
			 for (int i = 1; i <= 6; i++) {
					automat.fuelleFach(i, "Fanta", 2.00, df.parse("01.01.2021"));
			 }
			 automat.fuelleFach(7, "Fanta", 2.00, df.parse("01.01.2019"));
			 automat.drehen(); //Fach7
			 for (int i = 1; i <= 6; i++) {
				 automat.fuelleFach(i, "Cola", 2.00, df.parse("01.01.2021"));
			 }
			 automat.fuelleFach(7, "Fanta", 2.00, df.parse("01.01.2021"));
			 System.out.println("=== Bestellung-Test. =====================================");
		}

	}

}

/* Session-Log:

=== Drehteller-Test: =================================
*** Drehteller Nr.1 mit einem "Eins" füllen:
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
*** Drehteller Nr.2 mit einem "Zwei" füllen:
SystemSoftware::zeigeWarenPreisAn():  2: 2.0
SystemSoftware::zeigeVerfallsDatum(): 2: 2
SystemSoftware::output(): false
*** automat.drehen():
SystemSoftware::output(): true
*** Drehteller Nr.3 mit einem "Drei" füllen:
SystemSoftware::zeigeWarenPreisAn():  3: 3.0
SystemSoftware::zeigeVerfallsDatum(): 3: 2
SystemSoftware::output(): false
*** Drehen bis Fach Nr.16 vor der öffnung ist:
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
=== öffnen-Test: =====================================
*** Drehteller Nr.5 mit einem Mars füllen:
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
=== öffnen-Test. =====================================

*/