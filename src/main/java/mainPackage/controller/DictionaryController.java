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
		
		if(languageFilter == null) {
			languageFilter = "all";
		}
		
		if(wordLengthFilter == null) {
			wordLengthFilter = "0";
		}
		
		// Keine Filter(RequestParams) angegeben oder Filter: Alles anzeigen
		if((languageFilter == "all" && wordLengthFilter == "0") || (languageFilter == null && wordLengthFilter == null)) {
			model.addAttribute("woerterListe", wortService.findeAlleWoerter());
		}
		
		else {			
			// Nur Filter für Sprache ausgewählt
			if(languageFilter != "all" && wordLengthFilter == "0") {
				model.addAttribute("woerterListe", wortService.findeAlleWoerterAusSprache(languageFilter));
			}
			// Nur Filter für Wortlänge ausgewählt
			else if(languageFilter == "all" && wordLengthFilter != "0") {			
				model.addAttribute("woerterListe", wortService.findeAlleWoerterMitWortLaenge(Integer.parseInt(wordLengthFilter)));			
			}
			// Filter für Sprache und Wortlänge ausgewählt
			else {			
				model.addAttribute("woerterListe", wortService.findeAlleWoerterAusSpracheMitWortlaenge(languageFilter, Integer.parseInt(wordLengthFilter)));
			}			
		}		
		
		// Anzeige der aktiven Filter
		String[] filterParams = {languageFilter, wordLengthFilter};
		if(filterParams[1] == "0") {
			filterParams[1] = "all";
		}
		model.addAttribute("filter", filterParams);
		
		return "dictionary";
	}
	
}
