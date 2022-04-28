package mainPackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mainPackage.game.GameService;
import mainPackage.game.GameSession;
import mainPackage.wort.WortService;

@Controller
@RequestMapping(value="/game")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private WortService wortService;
	
	@Autowired
	public GameController() {		
	}
	
//	@Autowired
//	public GameController(GameService gameService, WortService wortService) {
//		this.gameService = gameService;
//		this.wortService = wortService;	
//	}
	
	// ************************************* Spieloptionen *****************************************************
	
	@GetMapping()
	public String getGame(Model model){
		model.addAttribute("activePage", "game");
		return "game";
	}
		
	// ************************************** Spielablauf ******************************************************
	
	@GetMapping("/play")
	public String getPlay(Model model)
	{
		model.addAttribute("activePage", "game");
		return "play";
	}
	
	
	@PostMapping("/play")
	public String startPlay(Model model,@RequestParam(defaultValue = "all") String languageOption,
										@RequestParam(defaultValue = "0") String wordLengthOption){		
		
		model.addAttribute("activePage", "game");	
		
		String loesungswort;
		
		// ************************* Setze Properties der Gamesession **************************************
		
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
				
		this.gameService.setGameSession(new GameSession(languageOption, loesungswort.length(), loesungswort));
			
		// Befülle Model
		model.addAttribute("gameSession", this.gameService.getGameSession());			
		
		return "play";
	}
	
	
	@PostMapping("/play/checkWord")
	public String postCheckWord(Model model, @RequestParam(required = false) String word){		
		model.addAttribute("activePage", "game");
		
		return "play";
	}
	

}
