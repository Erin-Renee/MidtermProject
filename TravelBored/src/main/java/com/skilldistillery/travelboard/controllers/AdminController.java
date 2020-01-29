package com.skilldistillery.travelboard.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.travelboard.data.DAOAdmin;
import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.EventComment;
import com.skilldistillery.travelboard.entities.Group;
import com.skilldistillery.travelboard.entities.GroupComment;
import com.skilldistillery.travelboard.entities.User;
import com.skilldistillery.travelboard.entities.UserRole;

@Controller
public class AdminController {

	@Autowired
	private DAOAdmin daoAdmin;
	
	public Model refresh(Model model) {
		List<User> activeUsers = daoAdmin.getActiveUsers();
		model.addAttribute("activeUsers", activeUsers);
		
		List<User> deactivatedUsers = daoAdmin.getDeactivatedUsers();
		model.addAttribute("deactivatedUsers", deactivatedUsers);
		
		List<Event> activeEvents = daoAdmin.getActiveEvents();
		model.addAttribute("activeEvents", activeEvents);
		
		List<Event> deactivatedEvents = daoAdmin.getDeactivatedEvents();
		model.addAttribute("deactivatedEvents", deactivatedEvents);
		
		List<Group> activeGroups = daoAdmin.getActiveGroups();
		model.addAttribute("activeGroups", activeGroups);
		
		List<Group> deactivatedGroups = daoAdmin.getDeactivatedGroups();
		model.addAttribute("deactivatedGroups", deactivatedGroups);
		
		return model;
	}

	public boolean checkIfAdmin(HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		if (user.getRole().equals(UserRole.admin)) {
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping(path = "adminSettings.do", method = RequestMethod.GET)
	public String adminSettings(HttpSession session, Model model) {
		if (checkIfAdmin(session) == true) {
			
			model = refresh(model);
			
			return "admin";
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}

	@RequestMapping(path = "deactivateUser.do", method = RequestMethod.POST)
	public String deactivateUser(HttpSession session, Integer userId, Model model) {
		if (checkIfAdmin(session) == true) {
			User user = daoAdmin.deactivateUser(userId);
			model = refresh(model);
			return "admin";
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}
	@RequestMapping(path = "activateUser.do", method = RequestMethod.POST)
	public String activateUser(HttpSession session, Integer userId, Model model) {
		if (checkIfAdmin(session) == true) {
			User user = daoAdmin.activateUser(userId);
			model = refresh(model);
			return "admin";
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}

	@RequestMapping(path = "deactivateEvent.do", method = RequestMethod.POST)
	public String deactivateEvent(HttpSession session, Integer eventId, Model model) {
		if (checkIfAdmin(session) == true) {
			Event event = daoAdmin.deactivateEvent(eventId);
			model = refresh(model);
			return "admin";
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}
	@RequestMapping(path = "activateEvent.do", method = RequestMethod.POST)
	public String activateEvent(HttpSession session, Integer eventId, Model model) {
		if (checkIfAdmin(session) == true) {
			Event event = daoAdmin.activateEvent(eventId);
			model = refresh(model);
			return "admin";
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}

	@RequestMapping(path = "deactivateGroup.do", method = RequestMethod.POST)
	public String deactivateGroup(HttpSession session, Integer groupId, Model model) {
		if (checkIfAdmin(session) == true) {
			Group group = daoAdmin.deactivateGroup(groupId);
			model = refresh(model);
			return "admin";
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}
	@RequestMapping(path = "activateGroup.do", method = RequestMethod.POST)
	public String activateGroup(HttpSession session, Integer groupId, Model model) {
		if (checkIfAdmin(session) == true) {
			Group group = daoAdmin.activateGroup(groupId);
			model = refresh(model);
			return "admin";
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}

	

	

	
	@RequestMapping(path = "deleteGroupComments.do", method = RequestMethod.POST)
	public String deleteGroupComments(HttpSession session,GroupComment gComment, Model model) {
		if (checkIfAdmin(session) == true) {
			daoAdmin.deleteGroupComment(gComment.getId());
			model = refresh(model);
			return "admin";
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}
	@RequestMapping(path = "deleteEventComments.do", method = RequestMethod.POST)
	public String deleteEventComments(HttpSession session,EventComment eComment, Model model) {
		if (checkIfAdmin(session) == true) {
			daoAdmin.deleteGroupComment(eComment.getId());
			model = refresh(model);
			return "admin";
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}
	
	

}
