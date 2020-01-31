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
import com.skilldistillery.travelboard.entities.GroupComment;
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
		model.addAttribute("notAttending", daoEvent.findUserEvent(event.getId(), user.getId()));

		
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
	public String attentEvent(Integer eventId, HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		user = daoUser.findUserById(user.getId());
		Event event = daoSearch.findEventById(eventId);
		UserEvent userEvent =daoEvent.createUserEvent(event, user);
		model.addAttribute("event", event);
		model.addAttribute("userEvent", userEvent);
		model.addAttribute("notAttending", daoEvent.findUserEvent(eventId, user.getId()));
		return "event";
	}

	@RequestMapping(path = "unattend.do", method = RequestMethod.POST)
	public String unattentEvent(Integer eventId, HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		user = daoUser.findUserById(user.getId());
		Event event = daoSearch.findEventById(eventId);
		daoEvent.deleteUserEvent(event, user);
		model.addAttribute("event", event);
		model.addAttribute("notAttending", daoEvent.findUserEvent(eventId, user.getId()));
		return "event";
	}
	
	@RequestMapping(path = "createEventComment.do", method = RequestMethod.POST)
	public String createEventComment (Integer eventId, String comment, HttpSession session, Model model) {
		EventComment eComment = new EventComment();
		eComment.setContent(comment);
		eComment.setCreateDate(LocalDateTime.now().toString());
		eComment.setUser((User) session.getAttribute("loggedInUser"));
		eComment.setEvent(daoSearch.findEventById(eventId));
		
		eComment = daoEvent.submitComment(eComment);
		
		List<EventComment> commentList = daoEvent.getEventCommentsByEventId(eventId);
		
		model.addAttribute("event", daoSearch.findEventById(eventId));
		model.addAttribute("commentList", commentList);
		model.addAttribute("notAttending", daoEvent.findUserEvent(eventId, ((User) session.getAttribute("loggedInUser")).getId()));
		return "event";
	}
	@RequestMapping(path = "deleteEventComment.do", method = RequestMethod.POST)
	public String deleteEventComment(EventComment eComment, HttpSession session, Model model) {
		
		daoEvent.deleteComment(eComment.getId());
		
		return "event";
	}
}
