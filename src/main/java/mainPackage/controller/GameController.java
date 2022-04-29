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
		
		return "redirect:/game/play";
	}
	
	
	@PostMapping("/play/checkWord")
	public String checkWord(Model model, @ModelAttribute("eingabeVersuch") EingabeVersuch eingabeVersuch){		
		model.addAttribute("activePage", "game");
			
		// Trage die Buchstaben des EingabeVersuchs in das Spielfeld ein
		int feld_id = 0;
		for(Feld feld : eingabeVersuch.getBuchstabenFelder()) {	
			
			this.gameService.getGameSession().getSpielfeld().getEingabeVersuchElement(this.gameService.getGameSession().getVersuche()).getBuchstabenFelder()[feld_id].setBuchstabe(feld.getBuchstabe());
			
			feld_id ++;
		}
		
//		this.gameService.getGameSession().getSpielfeld().getEingabeVersuchElement
//							(this.gameService.getGameSession().getVersuche()).setBuchstabenFelder(eingabeVersuch.getBuchstabenFelder());
				
		
		// FOLGT...: Vergleiche Eingabe mit Lösung
		
		// Versuche + 1
		this.gameService.getGameSession().setVersuche(this.gameService.getGameSession().getVersuche() + 1);
		
		// Befülle Model
		model.addAttribute("gameSession", this.gameService.getGameSession());
				
		return "play";
	}
	

}
