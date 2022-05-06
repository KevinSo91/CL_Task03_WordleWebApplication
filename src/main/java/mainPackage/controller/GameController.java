package mainPackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mainPackage.game.EingabeVersuch;
import mainPackage.game.Feld;
import mainPackage.game.GameService;
import mainPackage.game.GameSession;
import mainPackage.game.Spielfeld;
import mainPackage.wort.WortService;

@Controller
@RequestMapping(value="/game")
public class GameController {
	
	@Autowired
	private GameService gameService;
			
	@Autowired
	public GameController() {		
	}
		
	
	// Zeige Auswahl an Spieloptionen
	
	@GetMapping()
	public String getGame(Model model){
		model.addAttribute("activePage", "game");
		return "game";
	}
		
	// ************************************** Spielablauf ******************************************************
	
	@GetMapping("/play")
	public String getPlay(Model model, @ModelAttribute("eingabeVersuch") EingabeVersuch eingabeVersuch)
	{
		model.addAttribute("activePage", "game");		
		
		model.addAttribute("gameSession", this.gameService.getGameSession());
		
		return "play";
	}
	
	
	@PostMapping("/play")
	public String startPlay(Model model,@ModelAttribute("eingabeVersuch") EingabeVersuch eingabeVersuch,
										@RequestParam(defaultValue = "all") String languageOption,
										@RequestParam(defaultValue = "0") String wordLengthOption){		
		
		model.addAttribute("activePage", "game");	
		
		// Erstelle Spiel-Session mit einem Lösungswort abhängig von den Request-Parametern
		String loesungswort = this.gameService.erzeugeLoesungsWort(languageOption, wordLengthOption);
		this.gameService.setGameSession(new GameSession(languageOption, loesungswort.length(), loesungswort));
									
		// Befülle Model
		model.addAttribute("gameSession", this.gameService.getGameSession());
		
		return "redirect:/game/play";
	}
	
	
	@PostMapping("/play/checkWord")
	public String checkWord(Model model, @ModelAttribute("eingabeVersuch") EingabeVersuch eingabeVersuch){		
		model.addAttribute("activePage", "game");
		
		// Setzt die Buchstaben in die Felder und vergleich die Eingabe mit dem Lösungswort
		boolean erfolg = this.gameService.pruefeEingabeVersuch(eingabeVersuch);
		
		// Befülle Model
		model.addAttribute("gameSession", this.gameService.getGameSession());
		
		
		if(erfolg || this.gameService.getGameSession().getVersuche() > this.gameService.getGameSession().getVersucheMax()-1) {
			return "result";
		}		
		
		else {
			return "redirect:/game/play";
		}
		
	}
	

}
