package mainPackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class NavigationController{	
	
	
	@Autowired
	public NavigationController(){			
	}
	
	@GetMapping(value = {"/", "/home"})
	public String getHome(Model model) {
		model.addAttribute("activePage", "home");
		return "home";
	}
	
	@GetMapping("/settings")
	public String getSettings(Model model) {
		model.addAttribute("activePage", "settings");
		return "settings";
	}
	
	
		
}