package mainPackage.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

	private GameSession gameSession;
	
	@Autowired
	public GameService() {
		this.gameSession = new GameSession();
	}
	
	public void starteSpiel(String sprache, int wortLaenge, String loesungWort) {	

		this.gameSession = new GameSession(sprache, wortLaenge, loesungWort);
		
	}

	public GameSession getGameSession() {
		return gameSession;
	}
	
//	public void pruefeEingabe(String eingabe) {
//		this.gameSession.eingabeWortSpeichern(eingabe);
//		this.gameSession.pruefeEingabeWort();
//	}
	
	
	
}
