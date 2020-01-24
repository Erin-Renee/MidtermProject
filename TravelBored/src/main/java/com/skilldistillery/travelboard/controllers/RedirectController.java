package com.skilldistillery.travelboard.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RedirectController {
	
	
	@RequestMapping(path = {"landing.do", "/"}, method= RequestMethod.GET)
	private String landingPage() {
		
		return "WEB-INF/landing.jsp";
	}

	@RequestMapping(path = "home.do", method= RequestMethod.GET)
	private String homePage() {
		
		return "WEB-INF/home.jsp";
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
