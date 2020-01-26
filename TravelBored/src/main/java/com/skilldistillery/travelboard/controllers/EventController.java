package com.skilldistillery.travelboard.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.travelboard.data.DAOEvent;
import com.skilldistillery.travelboard.data.DAOSearch;
import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.Location;
import com.skilldistillery.travelboard.entities.User;
import com.skilldistillery.travelboard.entities.UserEvent;

@Controller
public class EventController {

	@Autowired
	private DAOEvent daoEvent;
	
	@Autowired
	private DAOSearch daoSearch;

	@RequestMapping(path = "createEvent.do", method = RequestMethod.POST)
	public String createEvent(Event event, String keyword, Model model) {
		System.out.println("before " + event);
		Location location =daoSearch.searchLocation(keyword);
		
		String createDate = LocalDateTime.now().toString();
		
		event.setActive(true);
		
		event.setCreateDate(createDate);
		event.setLocation(location);
		event = daoEvent.create(event);
		model.addAttribute("event", event);
		System.out.println("after " + event);
		
		return "event";
	}

	@RequestMapping(path = "updateEvent.do", method = RequestMethod.POST)
	public String updateEvent(Event event, HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		List<UserEvent> userevents = user.getUserEvents();
		for (UserEvent userEvent : userevents) {
			if (userEvent.getEvent().getId().equals(event.getId())) {
				if (userEvent.getCreator()) {
					daoEvent.update(event, event.getId());
					break;
				}
			}
		}
		model.addAttribute("event", event);
		return "event";
	}

	@RequestMapping(path = "disableEvent.do", method = RequestMethod.POST)
	public String disableEvent(Event event, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		UserEvent userevent = daoEvent.findUserEvent(event.getId(), user.getId());
		userevent.setActive(false);
		return "event";
	}

	@RequestMapping(path = "attend.do", method = RequestMethod.POST)
	public String attentEvent(Event event, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		daoEvent.createUserEvent(event, user);
		return "event";
	}

	@RequestMapping(path = "unattend.do", method = RequestMethod.POST)
	public String unattentEvent(Event event, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		daoEvent.createUserEvent(event, user);
		return "event";
	}
}
