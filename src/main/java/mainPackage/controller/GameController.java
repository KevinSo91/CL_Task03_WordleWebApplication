package mainPackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/game")
public class GameController {
	
	@Autowired
	public GameController() {		
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
	public String postPlay(Model model, @RequestParam(defaultValue = "all") String languageFilter,
										@RequestParam(defaultValue = "0") String wordLengthFilter){		
		model.addAttribute("activePage", "game");
		
		//Anzeige für ausgewählte Spieloptionen (Sprache, Wortlänge)
		String[] anzeigeAktiveFilter = {languageFilter, wordLengthFilter};
		if(anzeigeAktiveFilter[1].equals("0")) {
			anzeigeAktiveFilter[1] = "all";
		}
		model.addAttribute("aktiveFilter", anzeigeAktiveFilter);
		
		return "play";
	}
	
	
	@PostMapping("/play/checkWord")
	public String postCheckWord(Model model, @RequestParam String word){		
		model.addAttribute("activePage", "game");
		
		return "play";
	}
	

}
