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
	
//	public void pruefeEingabe(String eingabe) {
//		this.gameSession.eingabeWortSpeichern(eingabe);
//		this.gameSession.pruefeEingabeWort();
//	}
	
	public void pruefeEingabeVersuch (EingabeVersuch eingabeVersuch) {
	
			int feld_id = 0;
			for(Feld feld : eingabeVersuch.getBuchstabenFelder()) {	
				// Trage den Buchstaben in das entsprechende Feld im Spielfeld ein
				this.gameSession.getSpielfeld()
				.getEingabeVersuchElement(this.gameSession.getVersuche())
				.getBuchstabenFelder()[feld_id].setBuchstabe(feld.getBuchstabe());
				
				// Prüfe Vorkommen in Lösungswort und setze Farbe
				
				
				feld_id ++;
			}	
			
			// FOLGT...: Vergleiche Eingabe mit Lösung
			
			// Versuche + 1
			this.gameSession.setVersuche(this.gameSession.getVersuche() + 1);
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
