package mainPackage.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

	@Autowired
	private GameSession gameSession;
	
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
	
	
	
}
