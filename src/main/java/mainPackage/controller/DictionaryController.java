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
		
		String filterSprache = languageFilter;
		String filterLaenge = wordLengthFilter;
		
		if(filterSprache == null) {
			filterSprache = "all";
		}
		
		if(filterLaenge == null) {
			filterLaenge = "0";
		}
		
		// Keine Filter(RequestParams) angegeben oder Filter: Alles anzeigen
		if(filterSprache == "all" && filterLaenge == "0") {
			model.addAttribute("woerterListe", wortService.findeAlleWoerter());
		}
		
		else {			
			// Nur Filter für Sprache ausgewählt
			if(filterSprache != "all" && filterLaenge == "0") {
				model.addAttribute("woerterListe", wortService.findeAlleWoerterAusSprache(filterSprache));
			}
			// Nur Filter für Wortlänge ausgewählt
			else if(filterSprache == "all" && filterLaenge != "0") {			
				model.addAttribute("woerterListe", wortService.findeAlleWoerterMitWortLaenge(Integer.parseInt(filterLaenge)));			
			}
			// Filter für Sprache und Wortlänge ausgewählt
			else {			
				model.addAttribute("woerterListe", wortService.findeAlleWoerterAusSpracheMitWortlaenge(filterSprache, Integer.parseInt(filterLaenge)));
			}			
		}		
		
		// Anzeige der aktiven Filter
		String[] filterParams = {filterSprache, filterLaenge};
		if(filterParams[1] == "0") {
			filterParams[1] = "all";
		}
		model.addAttribute("AnzeigeFilter", filterParams);
		
		
		return "dictionary";
	}
	
}
