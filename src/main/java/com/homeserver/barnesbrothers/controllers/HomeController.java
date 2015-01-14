package com.homeserver.barnesbrothers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {		
		return "redirect:currentinventory";
	}
	
	@RequestMapping(value = "/currentinventory", method = RequestMethod.GET)
	public String inventory(Model model) {
		
		return "currentinventory";
	}
	
	@RequestMapping(value = "/vieworders", method = RequestMethod.GET)
	public String vieworders(Model model) {
		
		return "vieworders";
	}
	
	@RequestMapping(value = "/placeorder", method = RequestMethod.GET)
	public String placeorder(Model model) {
		
		return "placeorder";
	}
	
	@RequestMapping(value = "/viewlog", method = RequestMethod.GET)
	public String viewlog(Model model) {
		
		return "viewlog";
	}
	
}