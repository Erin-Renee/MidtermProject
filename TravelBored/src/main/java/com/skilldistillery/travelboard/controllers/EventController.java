package com.skilldistillery.travelboard.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import com.skilldistillery.travelboard.entities.Location;
import com.skilldistillery.travelboard.entities.User;
import com.skilldistillery.travelboard.entities.UserEvent;
import com.skilldistillery.travelboard.entities.UserEventId;

@Controller
public class EventController {

	@Autowired
	private DAOEvent daoEvent;
	
	@Autowired
	private DAOUser daoUser;
	
	@Autowired
	private DAOSearch daoSearch;

	@RequestMapping(path = "createEvent.do", method = RequestMethod.POST)
	public String createEvent(Event event, Integer locationId, Model model, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		user = daoUser.findUserById(user.getId());
		
		
		String createDate = LocalDateTime.now().toString();
		
		event.setActive(true);
		event.setCreateDate(createDate);
		event.setLocation(daoSearch.getLocation(locationId));
		event = daoEvent.create(event);
		
		UserEventId uEId = new UserEventId(user.getId(), event.getId());	
		UserEvent uEvent = new UserEvent();
		uEvent.setUser(user);
		uEvent.setEvent(event);
		uEvent.setCreateDate(createDate);
		uEvent.setCreator(true);
		uEvent.setActive(true);
		uEvent.setId(uEId);
		
		
		uEvent = daoEvent.setUserEvent(uEvent);
		
		event.addUserEvent(uEvent);
		user.addUserEvent(uEvent);
		user = daoUser.findUserById(user.getId());

		session.removeAttribute("loggedInUser");
		session.setAttribute("loggedInUser", user);
		
		model.addAttribute("event", event);
		
		
		return "event";
	}

	@RequestMapping(path = "updateEvent.do", method = RequestMethod.POST)
	public String updateEvent(Event event, HttpSession session, Model model, Integer locationId) {
		User user = (User) session.getAttribute("loggedInUser");
		user = daoUser.findUserById(user.getId());
		List<UserEvent> userevents = user.getUserEvents();
		Location location =user.getLocation();
		String createDate = LocalDateTime.now().toString();
		
		for (UserEvent userEvent : userevents) {
			if (userEvent.getEvent().getId().equals(event.getId())) {
				if (userEvent.getCreator()) {
					event.setActive(true);
					event.setCreateDate(createDate);
					event.setLocation(daoSearch.getLocation(locationId));
					event = daoEvent.update(event, event.getId());
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
		daoEvent.deleteUserEvent(event, user);
		return "event";
	}
	
	@RequestMapping(path = "createEventComment.do", method = RequestMethod.POST)
	public String createEventComment(Event event, String comment, HttpSession session, Model model) {
		EventComment eComment = new EventComment();
		eComment.setContent(comment);
		eComment.setCreateDate(LocalDateTime.now().toString());
		eComment.setEvent(event);
		eComment.setUser((User) session.getAttribute("loggedInUser"));
		
		eComment = daoEvent.submitComment(eComment);
		model.addAttribute("comment", eComment);
		
		return "event";
	}
	@RequestMapping(path = "deleteEventComment.do", method = RequestMethod.POST)
	public String deleteEventComment(EventComment eComment, HttpSession session, Model model) {
		
		daoEvent.deleteComment(eComment.getId());
		
		return "event";
	}
}
