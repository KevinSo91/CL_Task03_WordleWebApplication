package mainPackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mainPackage.wort.WortService;

@Controller
@RequestMapping("/settings")
public class SettingsController {

	private final WortService wortService;
	
	@Autowired
	public SettingsController(WortService wortService) {
		this.wortService = wortService;
	}
	
	@GetMapping("/dictionary")
	public String getDictionary(Model model) {
		model.addAttribute("woerterListe", wortService.findeAlleWoerter());
		return "dictionary";
	}
	
	@GetMapping("/manual")
	public String getManual() {
		return "manual";
	}
	
	@GetMapping("/highscoreList")
	public String getHighscoreList() {
		return "highscoreList";
	}
}
