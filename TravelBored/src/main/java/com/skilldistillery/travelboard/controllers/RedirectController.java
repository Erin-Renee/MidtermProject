package com.skilldistillery.travelboard.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.travelboard.data.DAOSearch;
import com.skilldistillery.travelboard.data.DAOUser;
import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.Location;
import com.skilldistillery.travelboard.entities.User;
import com.skilldistillery.travelboard.entities.UserEvent;

@Controller
public class RedirectController {
	
	@Autowired
	private DAOUser daoUser;
	
	@Autowired
	private DAOSearch daoSearch;
	
	@RequestMapping(path = {"/", "gotoLanding.do"}, method= RequestMethod.GET)
	private String landingPage(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			session.removeAttribute("loggedInUser");
		}
		return "landing";
	}


	@RequestMapping(path = "gotoHome.do", method= RequestMethod.GET)
	public String login(HttpSession session) {
	User user =	(User) session.getAttribute("loggedInUser");
		
		if (user == null) {
			return "landing";
		} else {
			
			return "profileView";
		}
		
	}
	
	@RequestMapping(path = "gotoRegister.do", method = RequestMethod.GET)
	private String goToRegister(HttpSession session, Model model) {
		User user =	(User) session.getAttribute("loggedInUser");

		
		if (user == null) {
			List<Location> locations = daoSearch.findAllLocations();
			model.addAttribute("locations", locations);
			return "register";
		} else {
			
			return "home";
		}
		
		
	}
	
	
	

	
	@RequestMapping(path = "gotoCrUpdateEvent.do", method = RequestMethod.GET)
	private String goToCrUpdateEvent(HttpSession session, Model model) {
		User user =	(User) session.getAttribute("loggedInUser");

		if (user == null) {
			return "event";
		}else {
			List<Location> locations = daoSearch.findAllLocations();
			model.addAttribute("locations", locations);
		return "crupdateevent";
		}
		
	}
	
	
	
}
