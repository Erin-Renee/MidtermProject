package com.skilldistillery.travelboard.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.travelboard.data.DAOEvent;
import com.skilldistillery.travelboard.data.DAOSearch;
import com.skilldistillery.travelboard.data.DAOUser;
import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.EventComment;
import com.skilldistillery.travelboard.entities.Group;
import com.skilldistillery.travelboard.entities.Location;
import com.skilldistillery.travelboard.entities.User;

@Controller
public class SearchController {
	@Autowired
	private DAOSearch daoSearch;
	
	@Autowired
	private DAOUser daoUser;
	@Autowired
	private DAOEvent daoEvent;

	@RequestMapping(path = "search.do", method = RequestMethod.GET)
	public String search(Model model, String keyword, String location, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");

		if (location == null && user != null) {

			int locId = user.getLocation().getId();
			System.out.println(user.getLocation()); 
			List<User> userList = daoSearch.searchUsername(keyword);
			List<Event> eventList = daoSearch.searchEvent(keyword, locId);
			List<Group> groupList = daoSearch.searchGroup(keyword);
			model.addAttribute("groupList", groupList);
			model.addAttribute("userList", userList);
			model.addAttribute("eventList", eventList);
			model.addAttribute("keyword", keyword);

		} else if (location == null && user == null) {

			int locId = 0;
			List<Event> eventList = daoSearch.searchEvent(keyword, locId);
			model.addAttribute("eventList", eventList);
			model.addAttribute("keyword", keyword);

		} else if (location != null && user == null) {

			Location loc = daoSearch.searchLocation(location);
			int locId = loc.getId();
			List<Event> eventList = daoSearch.searchEvent(keyword, locId);
			model.addAttribute("eventList", eventList);
			model.addAttribute("keyword", keyword);

		} else if (location != null && user != null) {

			Location loc = daoSearch.searchLocation(location);
			int locId = loc.getId();
			List<Event> eventList = daoSearch.searchEvent(keyword, locId);
			List<User> userList = daoSearch.searchUsername(keyword);
			List<Group> groupList = daoSearch.searchGroup(keyword);
			model.addAttribute("groupList", groupList);
			model.addAttribute("eventList", eventList);
			model.addAttribute("userList", userList);
			model.addAttribute("keyword", keyword);

		}

		return "results";

	}

	@RequestMapping(path = "gotoEvent.do", method = RequestMethod.GET)
	private String goToEvent(Integer eventId, Model model, HttpSession session) {

		Event event = daoSearch.findEventById(eventId);
		model.addAttribute("event", event);
		
		User user =	(User) session.getAttribute("loggedInUser");
		if (user == null) {
			
			return "event";
		}
		user = daoUser.findUserById(user.getId());
		session.setAttribute("loggedInUser", user);
		
        List<EventComment> commentList = daoEvent.getEventCommentsByEventId(eventId);
		
		model.addAttribute("event", daoSearch.findEventById(eventId));
		model.addAttribute("commentList", commentList);
		
		model.addAttribute("notAttending", daoEvent.findUserEvent(eventId, user.getId()));
		return "event";
	}
	
	

}
