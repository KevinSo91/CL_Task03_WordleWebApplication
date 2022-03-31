package mainPackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mainPackage.wort.WortService;

@Controller
@RequestMapping(value = {"/words", "/woerter"})
public class WortController {
		
//	private final WortService wortService;
//	
//	@Autowired
//	public WortController(WortService wortService) {
//		this.wortService = wortService;
//	}
//
//	@GetMapping(value = {"","/all", "/alle"})
//	public String zeigeWoerter(Model woerterModel){
//		woerterModel.addAttribute("woerterListe", wortService.findeAlleWoerter());
//		return "woerter";		
//	}
//	
//	@GetMapping(value = {"/german", "/deutsch", "/de"})
//	public String zeigeWoerterDE(Model woerterModel) {
//		woerterModel.addAttribute("woerterListe", wortService.findeAlleWoerterAusSprache("deutsch"));
//		woerterModel.addAttribute("sprache", "deutsch");
//		return "woerter";
//	}
//	
//	@GetMapping(value = {"/english", "/englisch", "/en"})
//	public String zeigeWoerterEN(Model woerterModel) {
//		woerterModel.addAttribute("woerterListe", wortService.findeAlleWoerterAusSprache("englisch"));
//		woerterModel.addAttribute("sprache", "englisch");
//		return "woerter";
//	}
//		
//	@GetMapping(value = {"/zufall"})
//	public String zeigeZufall(Model wortModel){
//		wortModel.addAttribute("zufallWort", wortService.findeZufallsWortAusSpracheMitWortlaenge("englisch", 5));
//		return "zufall";
//	}
}
