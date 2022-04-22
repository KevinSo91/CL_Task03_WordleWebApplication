package mainPackage.game;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;


public class GameSession {
	
	// ****************************************************** Attribute **********************************************************************
		
	private int wortLaenge;
	
	private String sprache;
	
	private String eingabeWort;
	
	char[] eingabeWortArray;
	
	private String loesungWort;
	
	char[] loesungWortArray;
	
	ArrayList<Character> loesungWortListe;
	
	private boolean erfolg;
	
	private int versucheMax;
	
	private int versuche;
	
	private Spielfeld spielfeld;
	
	
	// ***************************************************** Konstruktoren *********************************************************************
	
	@Autowired
	public GameSession(){		
	}
	
	@Autowired
	public GameSession(String sprache, int wortLaenge, String loesungWort) {		
		this.sprache = sprache;
		this.loesungWort = loesungWort.toUpperCase();
		this.wortLaenge = wortLaenge;
		this.versucheMax = wortLaenge;
		this.versuche = 0;
		this.spielfeld = new Spielfeld(versucheMax, wortLaenge);
		
		loesungWortArray = this.loesungWort.toCharArray();
		loesungWortListe = new ArrayList<Character>();
		for(char c : loesungWortArray) {
			loesungWortListe.add(c);
		}
	}

	
	// ***************************************************** Getter/Setter *********************************************************************

	
	public int getWortLaenge() {
		return wortLaenge;
	}

	public void setWortLaenge(int wortLaenge) {
		this.wortLaenge = wortLaenge;
	}

	public String getSprache() {
		return sprache;
	}

	public void setSprache(String sprache) {
		this.sprache = sprache;
	}

	public String getEingabeWort() {
		return eingabeWort;
	}

	public void setEingabeWort(String eingabeWort) {
		this.eingabeWort = eingabeWort.toUpperCase();
	}

	public String getLoesungWort() {
		return loesungWort;
	}

	public void setLoesungWort(String loesungWort) {
		this.loesungWort = loesungWort.toUpperCase();
	}

	public boolean isErfolg() {
		return erfolg;
	}

	public void setErfolg(boolean erfolg) {
		this.erfolg = erfolg;
	}

	public int getVersucheMax() {
		return versucheMax;
	}

	public void setVersucheMax(int versucheMax) {
		this.versucheMax = versucheMax;
	}

	public int getVersuche() {
		return versuche;
	}

	public void setVersuche(int versuche) {
		this.versuche = versuche;
	}

	public Spielfeld getSpielfeld() {
		return spielfeld;
	}

	public void setSpielfeld(Spielfeld spielfeld) {
		this.spielfeld = spielfeld;
	}
	
	
	// ***************************************************** Methoden *********************************************************************
	
//	public void eingabeWortSpeichern(String eingabe) {
//		
//		this.eingabeWort = eingabe.toUpperCase();
//		eingabeWortArray = eingabeWort.toCharArray();		
//		
//		// Fülle Felder mit EingabeWort
//		int stelleEingabe = 0;		
//		for(char buchstabe : eingabeWortArray) {
//			spielfeld.getFelderArray()[this.versuche][stelleEingabe] = new Feld(buchstabe);
//			stelleEingabe++;
//		}
//	}
//	
//	
//	public void pruefeEingabeWort() {		
//		
//		// Fall: richtige Lösung
//		if(eingabeWort.equals(loesungWort)) {			
//			
//			int indexFeld = 0;
//			for(char eingabeChar : eingabeWortArray) {
//				
//			// Setze Farbe in Feldern auf Grün
//			spielfeld.getFelderArray()[this.versuche][indexFeld].setFarbe("green");
//			
//			indexFeld++;
//			
//			}
//			
//			erfolg = true;
//			System.out.print("\nErfolg !\n");
//			
//		}//ENDE richtige Lösung
//		
//		// Fall: falsche Lösung
//		else{	
//			
//			int stelleEingabe = 0;
//			// Iteriere über Buchstaben der Eingabe
//			for(char eingabeChar : eingabeWortArray) {
//				
////				// Setze Buchstaben in Feld
////				spielfeld.getFelderArray()[this.versuche][stelleEingabe].setBuchstabe(eingabeChar);
//				
//				// Prüfe auf 'Treffer' und setze entsprechende Farbe
//				
//				// Fall: Buchstabe nicht in Lösung vorhanden
//				if(!loesungWortListe.contains(eingabeChar))
//				{
//					spielfeld.getFelderArray()[this.versuche][stelleEingabe].setFarbe("gray");
//				}
//				
//				// Fall: Buchstabe in Lösung vorhanden			
//				else {
//					// Fall: Buchstabe an richtiger Stelle
//					if(eingabeChar == loesungWortArray[stelleEingabe]) {
//						spielfeld.getFelderArray()[this.versuche][stelleEingabe].setFarbe("green");
////						// Bei mehrfachem Vorkommen des gleich Buchstaben -> Prüfe auf weitere Vorkommen
////						loesungWortArray[stelleEingabe] = ' ';
//					}
//					// Fall: Buchstabe an falscher Stelle
//					else {
//						spielfeld.getFelderArray()[this.versuche][stelleEingabe].setFarbe("orange");
////						// Bei mehrfachem Vorkommen des gleich Buchstaben -> Prüfe auf weitere Vorkommen
////						loesungWortArray[stelleEingabe] = ' ';
//					}				
//				
//				}
//				
//				stelleEingabe++;
//			}
//			
//			erfolg = false;
//			System.out.print("\nKein Erfolg !\n");
//			
//		}//ENDE flasche Lösung
//		
//		//********** Test ************			
//		
//		System.out.print("Lösung:  " + this.loesungWort + "\n");
//		System.out.print("Eingabe: " + this.eingabeWort + "\n");
//		
//		for(Feld feld : spielfeld.getFelderArray()[versuche]) {
//			System.out.print(feld.getFarbe() + " ");
//			
//		//********ENDE Test **********
//		}
//		
//		System.out.print("\n");
//			
//			
//		versuche++;
//				
//	}//ENDE pruefeEingabe()	
	
	
}//ENDE Game
