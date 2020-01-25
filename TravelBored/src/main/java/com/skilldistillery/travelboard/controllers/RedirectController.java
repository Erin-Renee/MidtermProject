package com.skilldistillery.travelboard.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.travelboard.entities.User;

@Controller
public class RedirectController {
	
	
	@RequestMapping(path = {"/", "gotolanding.do"}, method= RequestMethod.GET)
	private String landingPage() {
		return "landing";
	}

	@RequestMapping(path = "gotohome.do", method= RequestMethod.GET)
	public String home(Model model, HttpSession session, User user) {
		if (user == null) {
			return "landing";
		} else {
			
			session.setAttribute("loggedInUser", user);
			return "home";
		}
		
	}
	@RequestMapping(path = "login.do", method= RequestMethod.GET)
	public String login() {
		return "landing";
		
	}
	
	@RequestMapping(path = "gotoregister.do", method = RequestMethod.GET)
	private String goToRegister() {
		return "register";
	}
	
	@RequestMapping(path = "gotoprofile.do", method = RequestMethod.GET)
	private String goToProfile() {
		return "profile";
	}
	
	@RequestMapping(path = "gotoevent.do", method = RequestMethod.GET)
	private String goToEvent() {
		return "event";
		
	}
	
	@RequestMapping(path = "gotocrUpdateEvent.do", method = RequestMethod.GET)
	private String goToCrUpdateEvent() {
		return "crUpdateEvent";
		
	}
	
	
	
}
