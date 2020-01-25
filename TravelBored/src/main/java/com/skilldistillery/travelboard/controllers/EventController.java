package com.skilldistillery.travelboard.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.travelboard.data.DAOEvent;
import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.User;
import com.skilldistillery.travelboard.entities.UserEvent;

@Controller
public class EventController {

	@Autowired
	private DAOEvent daoEvent;

	@RequestMapping(path = "createEvent.do", method = RequestMethod.POST)
	public String createEvent(Event event, Model model) {
		event = daoEvent.create(event);
		model.addAttribute("event", event);
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
