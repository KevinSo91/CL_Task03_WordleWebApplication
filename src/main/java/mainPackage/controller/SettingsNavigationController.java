package mainPackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mainPackage.wort.WortService;

@Controller
@RequestMapping("/settings")
public class SettingsNavigationController {
	
	@Autowired
	public SettingsNavigationController(WortService wortService) {
	}
	
	
	@GetMapping("/manual")
	public String getManual(Model model) {
		model.addAttribute("activePage", "settings");
		return "manual";
	}
	
	@GetMapping("/highscoreList")
	public String getHighscoreList(Model model) {
		model.addAttribute("activePage", "settings");
		return "highscoreList";
	}
}
