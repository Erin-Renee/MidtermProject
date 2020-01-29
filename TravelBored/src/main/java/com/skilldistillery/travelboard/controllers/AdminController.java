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

	public boolean checkIfAdmin(HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		if (user.getRole().equals(UserRole.admin)) {
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping(path = "adminSettings.do", method = RequestMethod.GET)
	public String adminSettings(HttpSession session) {
		if (checkIfAdmin(session) == true) {
			return "admin";
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}

	@RequestMapping(path = "deactivateUser.do", method = RequestMethod.POST)
	public String deactivateUser(HttpSession session, User user, Model model) {
		if (checkIfAdmin(session) == true) {
			user = daoAdmin.deactivateUser(user.getId());
			model.addAttribute("user", user);
			return null;
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}

	@RequestMapping(path = "deactivateEvent.do", method = RequestMethod.POST)
	public String deactivateEvent(HttpSession session, Event event, Model model) {
		if (checkIfAdmin(session) == true) {
			event = daoAdmin.deactivateEvent(event.getId());
			model.addAttribute("event", event);
			return null;
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}

	@RequestMapping(path = "deactivateGroup.do", method = RequestMethod.POST)
	public String deactivateGroup(HttpSession session, Group group, Model model) {
		if (checkIfAdmin(session) == true) {
			group = daoAdmin.deactivateGroup(group.getId());
			model.addAttribute("group", group);
			return null;
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}

	@RequestMapping(path = "deactivatedUsers.do", method = RequestMethod.POST)
	public String deactivatedUsers(HttpSession session, Model model) {
		if (checkIfAdmin(session) == true) {
			List<User> deactivatedUsers = daoAdmin.getDeactivatedUsers();
			model.addAttribute("deactivatedUsers", deactivatedUsers);
			return null;
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}

	@RequestMapping(path = "deactivatedGroups.do", method = RequestMethod.POST)
	public String deactivatedGroups(HttpSession session, Model model) {
		if (checkIfAdmin(session) == true) {
			List<Group> deactivatedGroups = daoAdmin.getDeactivatedGroups();
			model.addAttribute("deactivatedGroups", deactivatedGroups);
			return null;
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}

	@RequestMapping(path = "deactivatedEvents.do", method = RequestMethod.POST)
	public String deactivatedEvents(HttpSession session, Model model) {
		if (checkIfAdmin(session) == true) {
			List<Event> deactivatedEvents = daoAdmin.getDeactivatedEvents();
			model.addAttribute("deactivatedEvents", deactivatedEvents);
			return null;
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}

	@RequestMapping(path = "activatedUsers.do", method = RequestMethod.POST)
	public String activatedUsers(HttpSession session, Model model) {
		if (checkIfAdmin(session) == true) {
			List<User> activeUsers = daoAdmin.getActiveUsers();
			model.addAttribute("activeUsers", activeUsers);
			return null;
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}

	@RequestMapping(path = "activatedEvents.do", method = RequestMethod.POST)
	public String activatedEvents(HttpSession session, Model model) {
		if (checkIfAdmin(session) == true) {
			List<Event> activeEvents = daoAdmin.getActiveEvents();
			model.addAttribute("activeEvents", activeEvents);
			return null;
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}

	@RequestMapping(path = "activatedGroups.do", method = RequestMethod.POST)
	public String activatedGroups(HttpSession session, Model model) {
		if (checkIfAdmin(session) == true) {
			List<Group> activeGroups = daoAdmin.getActiveGroups();
			model.addAttribute("activeGroups", activeGroups);
			return null;
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}
	@RequestMapping(path = "deleteGroupComments.do", method = RequestMethod.POST)
	public String deleteGroupComments(HttpSession session,GroupComment gComment, Model model) {
		if (checkIfAdmin(session) == true) {
			daoAdmin.deleteGroupComment(gComment.getId());
			return null;
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}
	@RequestMapping(path = "deleteEventComments.do", method = RequestMethod.POST)
	public String deleteEventComments(HttpSession session,EventComment eComment, Model model) {
		if (checkIfAdmin(session) == true) {
			daoAdmin.deleteGroupComment(eComment.getId());
			return null;
		} else {
			session.removeAttribute("loggedInUser");
			return "landing";
		}
	}
	
	

}
