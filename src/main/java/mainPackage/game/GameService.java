package mainPackage.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainPackage.wort.WortService;

@Service
public class GameService {

	@Autowired
	private GameSession gameSession;
	
	@Autowired
	private WortService wortService;
	
	@Autowired
	public GameService() {
		this.gameSession = new GameSession();
	}
	
	public void starteSpiel() {
		this.gameSession = new GameSession();		
	}

	public GameSession getGameSession() {
		return gameSession;
	}

	public void setGameSession(GameSession gameSession) {
		this.gameSession = gameSession;
	}
	
//	public void pruefeEingabeVersuch (EingabeVersuch eingabeVersuch) {
//		
//		int feld_id = 0;
//		for(Feld feld : eingabeVersuch.getBuchstabenFelder()) {	
//			// Trage den Buchstaben in das entsprechende Feld im Spielfeld ein
//			this.gameSession.getSpielfeld()
//			.getEingabeVersuchElement(this.gameSession.getVersuche())
//			.getBuchstabenFelder()[feld_id].setBuchstabe(feld.getBuchstabe().toUpperCase());
//			
//			// Prüfe Vorkommen in Lösungswort und setze Farbe
//			
//			
//			feld_id ++;
//		}	
//		
//		// FOLGT...: Vergleiche Eingabe mit Lösung
//		
//		// Versuche + 1
//		this.gameSession.setVersuche(this.gameSession.getVersuche() + 1);
//	}
	
	public boolean pruefeEingabeVersuch (EingabeVersuch eingabeVersuch) {
		
			String[] eingabeVersuchArray_Temp = new String[eingabeVersuch.getBuchstabenFelder().length];
			String eingabeVersuchString_Temp = "";
			for (int i = 0; i < eingabeVersuch.getBuchstabenFelder().length; i++) {
				eingabeVersuchArray_Temp[i] = eingabeVersuch.getBuchstabenFelder()[i].getBuchstabe().toUpperCase();
				eingabeVersuchString_Temp += eingabeVersuch.getBuchstabenFelder()[i].getBuchstabe().toUpperCase();
			}
	
			// Prüfe ob Eingabe = Lösungswort -> erfolg = true
			
			if (eingabeVersuchString_Temp.equals(this.gameSession.getLoesungWort())) {
				this.gameSession.setErfolg(true);
			}
			
			int index = 0;
			
			for(Feld feld : 
				this.gameSession.getSpielfeld().getEingabeVersuchElement(this.getGameSession().getVersuche()).getBuchstabenFelder()) {
				
				feld.setBuchstabe(eingabeVersuchArray_Temp[index]);
				
				if(this.gameSession.getErfolg()) {
					
					feld.setFarbe("green");
				}				
				else if (this.gameSession.getLoesungWort().contains(feld.getBuchstabe()) && feld.getBuchstabe() != "" && feld.getBuchstabe() != " "){
					
					
					feld.setFarbe("orange");
					
										
					if(feld.getBuchstabe().equals(String.valueOf(this.gameSession.getLoesungWortArray()[index]))) {
						feld.setFarbe("green");
					}
				}
				else {
					feld.setFarbe("grey");
				}
				
				index++;
				
			}
			
			// Versuche + 1
			this.gameSession.setVersuche(this.gameSession.getVersuche() + 1);
					
			if(this.gameSession.getVersuche() == this.gameSession.getVersucheMax()) {
				this.gameSession.setLose(true);
			}
			
			// Falls Erfolg: return TRUE
			
			if(this.gameSession.getErfolg()) {
				return true;
			}
							
				return false;
		}
			
			
			
			
			
			
			
			
//			int feldeingabeUser_index = 0; // Zähler für das BuchstabenFelder-Array
//			
//			// Iteriere über die BuchstabenFelder des EingabeVersuchs
//			
//			for(Feld feld_eingabeUser : eingabeVersuch.getBuchstabenFelder()) {	
//				
//				// -> UpperCase
//				feld_eingabeUser.setBuchstabe(feld_eingabeUser.getBuchstabe().toUpperCase());
//				
//				// Trage den Buchstaben in das entsprechende Feld im Spielfeld ein
//				
//				this.gameSession.getSpielfeld()
//				.getEingabeVersuchElement(this.gameSession.getVersuche())
//				.getBuchstabenFelder()[feldeingabeUser_index].setBuchstabe(feld_eingabeUser.getBuchstabe());
//				
//				
//				if(this.gameSession.getErfolg()) {
//					
//				}
				
//				 *************** Prüfe Vorkommen in Lösungswort und setze Farbe *********************
				
				
				
//				// Iteriere über Char-ARRAY des Lösungsworts
//				
//				int eingabeVersuch_index = 0;
//				
//				for (Feld feld_eingabeVersuch : 
//					this.gameSession.getSpielfeld().getEingabeVersuchElement(eingabeVersuch_index).getBuchstabenFelder()) {
//					// Fall: Buchstabe Eingabe = Buchstabe Lösung
//					if (feld_eingabeUser.getBuchstabe() == feld_eingabeVersuch.getBuchstabe()) {
//						
//						if(feldeingabeUser_index == eingabeVersuch_index) {
//							feld_eingabeVersuch.setFarbe("green");
////							buchstabe = ' ';
//						}
//						else {
//							feld_eingabeVersuch.setFarbe("orange");
////						buchstabe = ' ';	
//						}
//						
//					}
//					else {
//						feld_eingabeVersuch.setFarbe("grey");
//					}
//					
//					eingabeVersuch_index ++;
//				}
				
				
//				// Fall: Buchstabe kommt NICHT im Lösungswort vor (Prüfe LISTE)
//				if (!this.gameSession.getLoesungWortListe().contains(feld.getBuchstabe().charAt(0))){
//					feld.setFarbe("grey");
//				}
//				
//				// Fall: Buchstabe kommt in Lösungswort vor
//				else {
//					// Iteriere über Char-ARRAY des Lösungsworts
//					for (char buchstabe : this.gameSession.getLoesungWortArray()) {
//						// Fall: Buchstabe Eingabe = Buchstabe Lösung
//						if (buchstabe == feld.getBuchstabe().charAt(0)) {
//							feld.setFarbe("green");
//							
//						}
//					}
//				}
//				
//				
//				
//				feldeingabeUser_index ++;
//			}	
//			
//			// Stelle LoesungswortArray wieder her
//			this.gameSession.setLoesungWortArray(this.gameSession.getLoesungWort().toCharArray());
			
			
			
			
			
	
	public String erzeugeLoesungsWort (String languageOption, String wordLengthOption) {
		
		String loesungswort;	
		
		// Setze Lösungswort aus Datenbank
		if(languageOption.equals("all") && wordLengthOption.equals("0")) {
			loesungswort = wortService.findeZufallsWort();
		}
		else if(!languageOption.equals("all") && wordLengthOption.equals("0")) {
			loesungswort = wortService.findeZufallsWortAusSprache(languageOption);
		}
		else if(languageOption.equals("all") && !wordLengthOption.equals("0")) {
			loesungswort = wortService.findeZufallsWortMitWortlaenge(Integer.parseInt(wordLengthOption));
		}
		else {
			loesungswort = wortService.findeZufallsWortAusSpracheMitWortlaenge(languageOption, Integer.parseInt(wordLengthOption));
		}
		
		return loesungswort;
		
	}
}
