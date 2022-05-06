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
	
	
	
	public boolean pruefeEingabeVersuch (EingabeVersuch eingabeVersuch) {
		
			// Lokale Variablen zur besseren Eingabeverarbeitung
		
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
			
			// Iteriere über Felder des aktuellen Eingabeversuchs
			
			int index = 0;
			
			for(Feld feld : 
				this.gameSession.getSpielfeld().getEingabeVersuchElement(this.getGameSession().getVersuche()).getBuchstabenFelder()) {
				
				// Setze Buchstaben in Feld ein
				
				feld.setBuchstabe(eingabeVersuchArray_Temp[index]);				
				
				// Überprüfe Vorkommen und setze Farbe
				
				if(this.gameSession.getErfolg()) {
					
					feld.setFarbe("green");
				}
				// Falls: Lösungswort enthält den Buchstaben
				else if (this.gameSession.getLoesungWort().contains(feld.getBuchstabe()) && feld.getBuchstabe() != "" && feld.getBuchstabe() != " "){					
					
					// Prüfe mehrfaches Vorkommen des Buchstaben in EingabeVersuch und Lösungswort
					int anzahlVorkommenEingabe = 0;
					
					for(int i = 0; i < eingabeVersuchString_Temp.length(); i++) {
						if (eingabeVersuchString_Temp.substring(i,i+1).equals(feld.getBuchstabe())){
							anzahlVorkommenEingabe++;
						}
					}
					
					int anzahlVorkommenLoesung = 0;
					for(int i = 0; i < this.gameSession.getWortLaenge(); i++) {
						if (this.gameSession.getLoesungWort().substring(i,i+1).equals(feld.getBuchstabe())){
							anzahlVorkommenLoesung++;
						}
					}
					
					// Fall: der Buchstabe im Lösungswort mindestens so oft vorkommt wie im EingabeVersuch
					if(anzahlVorkommenLoesung >= anzahlVorkommenEingabe) {
						feld.setFarbe("orange");
						
					}
					else {
						feld.setFarbe("grey");
					}										
										
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
