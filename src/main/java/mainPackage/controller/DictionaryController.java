package mainPackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String getDictionary(Model model, @RequestParam(required = false) String languageFilter, @RequestParam(required = false) String wordLengthFilter) {
		if (languageFilter != "all" && wordLengthFilter != "0") {
			model.addAttribute("woerterListe", wortService.findeAlleWoerterAusSpracheMitWortlaenge(languageFilter, Integer.parseInt(wordLengthFilter)));
		}
		else if(languageFilter != "all" && wordLengthFilter == "0") {
			model.addAttribute("woerterListe", wortService.findeAlleWoerterAusSprache(languageFilter));
		}
		else if(languageFilter == "all" && wordLengthFilter != "0") {			
			model.addAttribute("woerterListe", wortService.findeAlleWoerterMitWortLaenge(Integer.parseInt(wordLengthFilter)));			
		}
		else {			
			model.addAttribute("woerterListe", wortService.findeAlleWoerter());
		}		
		
		return "dictionary";
	}
	
}
