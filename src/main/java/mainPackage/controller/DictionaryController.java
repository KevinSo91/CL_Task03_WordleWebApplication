package mainPackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mainPackage.wort.Wort;
import mainPackage.wort.WortService;

@Controller
@RequestMapping("/settings/dictionary")
public class DictionaryController {
	
	private final WortService wortService;
	
	@Autowired
	public DictionaryController(WortService wortService) {
		this.wortService = wortService;		
	}

	@GetMapping()
	public String getDictionary(Model model, @ModelAttribute("neuesWort") Wort neuesWort) {
		model.addAttribute("activePage", "settings");		
		model.addAttribute("woerterListe", wortService.findeAlleWoerter());	
		return "dictionary";
	}
	
	@PostMapping("/save")
	public String postWord(Model model, @ModelAttribute("neuesWort") Wort neuesWort) {
		model.addAttribute("activePage", "settings");
		wortService.speichereNeuesWort(neuesWort);
		return "redirect:/settings/dictionary";
	}
	
	@PostMapping("/delete")
	public String deleteWord(Model model, @RequestParam String altesWort) {
		model.addAttribute("activePage", "settings");
		wortService.loescheAltesWort(altesWort.toUpperCase());
		return "redirect:/settings/dictionary";
	}
	
}
