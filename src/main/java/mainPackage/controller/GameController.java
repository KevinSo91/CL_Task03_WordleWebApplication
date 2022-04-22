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
import mainPackage.wort.WortService;

@Controller
@RequestMapping(value="/game")
public class GameController {
	
	private final GameService gameService;
	
	private final WortService wortService;
	
	@Autowired
	public GameController(GameService gameService, WortService wortService) {
		this.gameService = gameService;
		this.wortService = wortService;	
	}
	
	
	@GetMapping()
	public String getGame(Model model){
		model.addAttribute("activePage", "game");
		return "game";
	}
		
	
	@GetMapping("/play")
	public String getPlay(Model model)
	{
		model.addAttribute("activePage", "game");
		return "play";
	}
	
	
	@PostMapping("/play")
	public String startPlay(Model model, @ModelAttribute("gameServiceAttribute") GameService gameServiceAttribute,
										@RequestParam(defaultValue = "all") String languageFilter,
										@RequestParam(defaultValue = "0") String wordLengthFilter){		
		model.addAttribute("activePage", "game");		
				
		this.gameService.starteSpiel(languageFilter, Integer.parseInt(wordLengthFilter), wortService.findeZufallsWortAusSpracheMitWortlaenge(languageFilter, Integer.parseInt(wordLengthFilter)));
		
		this.gameService.getGameSession().setSprache(languageFilter);
		this.gameService.getGameSession().setWortLaenge(Integer.parseInt(wordLengthFilter));
		
		model.addAttribute("gameService", this.gameService);
		
		//Anzeige für ausgewählte Spieleinstellungen (Sprache, Wortlänge)
		String[] anzeigeSpielEinstellungen = {languageFilter, wordLengthFilter};
		if(anzeigeSpielEinstellungen[1].equals("0")) {
			anzeigeSpielEinstellungen[1] = "all";
		}
		model.addAttribute("spielEinstellungen", anzeigeSpielEinstellungen);
		
		return "play";
	}
	
	
	@PostMapping("/play/checkWord")
	public String postCheckWord(Model model, @RequestParam(required = false) String word){		
		model.addAttribute("activePage", "game");
		
		return "play";
	}
	

}
