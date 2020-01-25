package com.skilldistillery.travelboard.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.travelboard.entities.User;

public class RedirectController {
	
	
	@RequestMapping(path = {"landing.do", "/"}, method= RequestMethod.GET)
	private String landingPage() {
		
		return "WEB-INF/landing.jsp";
	}

	@RequestMapping(path = "home.do", method= RequestMethod.GET)
	public String home(Model model, HttpSession session, User user) {
		if (user == null) {
			return "WEB-INF/landing.jsp";
		} else {
			
			session.setAttribute("loggedInUser", user);
			return "WEB-INF/home.jsp";
		}
		
	}
	@RequestMapping(path = "login.do", method= RequestMethod.GET)
	public String login() {
		return "WEB-INF/landing.jsp";
		
	}
	
	@RequestMapping(path = "register.do", method = RequestMethod.GET)
	private String goToRegister() {
		
		return "WEB-INF/register.jsp";
	}
	
	@RequestMapping(path = "profile.do", method = RequestMethod.GET)
	private String goToProfile() {
		
		return "WEB-INF/profile.jsp";
	}
	
	@RequestMapping(path = "event.do", method = RequestMethod.GET)
	private String goToEvent() {
		
		return "WEB-INF/event.jsp";
		
	}
	
	@RequestMapping(path = "crUpdateEvent.do", method = RequestMethod.GET)
	private String goToCrUpdateEvent() {
		
		return "WEB-INF/crUpdateEvent.jsp";
		
	}
	
	
	
}
