package com.skilldistillery.travelboard.controllers;

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
import com.skilldistillery.travelboard.entities.Group;
import com.skilldistillery.travelboard.entities.GroupComment;
import com.skilldistillery.travelboard.entities.Location;
import com.skilldistillery.travelboard.entities.User;
import com.skilldistillery.travelboard.entities.UserDetail;
import com.skilldistillery.travelboard.entities.UserEvent;
import com.skilldistillery.travelboard.entities.UserRole;

@Controller
public class UserController {
	@Autowired
	private DAOUser daoUser;

	@Autowired
	private DAOSearch daoSearch;
	
	@Autowired
	private DAOEvent daoEvent;
	
	
	
	public Model refresh(User user, Model model) {
		List<Location> locations = daoSearch.findAllLocations();
		
		model.addAttribute("locations", locations);
		List<Event> events = new ArrayList<>();
		if (user.getUserEvents() == null) {
			user.setUserEvents(new ArrayList<>());
		}
		for (UserEvent uEvent: user.getUserEvents()) {
			if(uEvent.getCreator() == false) {
				events.add(uEvent.getEvent()); 
			}
		}
		
		model.addAttribute("eventList", events);
		
		List<Event> creatorEvents = new ArrayList<>();
		for (UserEvent uEvent: user.getUserEvents()) {
			if(uEvent.getCreator() == true) {
				creatorEvents.add(uEvent.getEvent());	
			}
		}
		
		List<GroupComment> groupComments = user.getGroupComments();
		model.addAttribute("groupComments", groupComments);
		
		model.addAttribute("creatorEvents", creatorEvents);
		
		List<Group> creatorGroups = daoSearch.searchGroupByUser(user.getId());
		
		model.addAttribute("creatorGroups", creatorGroups);
		
		return model;
	}
	
	@RequestMapping(path = "login.do", method= RequestMethod.POST)
	public String home( HttpSession session, String email, String password, Model model) {
		
		User user = daoUser.login(email, password);
		model = refresh(user, model);
		
		if (user == null) {
			return "landing";
		} else {
			
			session.setAttribute("loggedInUser", user);
			model.addAttribute("sectionNumber", 1);
			return "profile";
		}
		
	}
	
	@RequestMapping(path = "gotoProfile.do", method = RequestMethod.GET)
	private String goToProfile(HttpSession session, Model model) {
		User user =	(User) session.getAttribute("loggedInUser");
		user = daoUser.findUserById(user.getId());
		session.setAttribute("loggedInUser", user);
		if (user == null) {
			return "landing";
		}else {
			
			refresh(user, model);
			model.addAttribute("sectionNumber", 1);
		
			
			return "profile";
		}
	}
	@RequestMapping(path = "gotoUser.do", method = RequestMethod.GET)
	private String goToUser(HttpSession session, Model model, Integer userId) {
		User user =	(User) session.getAttribute("loggedInUser");
		user = daoUser.findUserById(user.getId());
		session.setAttribute("loggedInUser", user);
		if (user == null) {
			return "landing";
		}else {
			user = daoUser.findUserById(userId);
			model.addAttribute("user", user);
			List<UserEvent> userEvents = user.getUserEvents();
			model.addAttribute("userEvents", userEvents);
			List<GroupComment> groupComments = user.getGroupComments();
			model.addAttribute("groupComments", groupComments);
			return "profileview";
		}
	}

	@RequestMapping(path = "logout.do", method = RequestMethod.GET)
	public String userLogout(HttpSession session) {
		session.removeAttribute("loggedInUser");
		return "landing";

	}

	@RequestMapping(path = "register.do", method = RequestMethod.POST)
	public String register(HttpSession session, User user, Model model,  Integer locationId) {
		
		
		user.setLocation(daoSearch.getLocation(locationId));
		user.setActive(true);
		user.setRole(UserRole.user);
		user = daoUser.create(user);
		session.setAttribute("loggedInUser", user);
		List<Location> locations = daoSearch.findAllLocations();
		model.addAttribute("locations", locations);
		return "profile";
	}

	@RequestMapping(path = "disableProfile.do", method = RequestMethod.GET)
	public String disable(HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		user.setActive(false);
		return "adminsettings";

	}
	@RequestMapping(path = "createUserDetail.do", method = RequestMethod.POST)
	public String createUserDetail(UserDetail userDetail, HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		
		user = daoUser.findUserById(user.getId());
		
		userDetail.setUser(user);
		
		userDetail = daoUser.createUserDetail(userDetail);
		
		user.addUserDetail(userDetail);
		
		
		session.setAttribute("loggedInUser", user);
		refresh(user, model);
		model.addAttribute("sectionNumber", 1);
		
		return "profile";
		
	}
	@RequestMapping(path = "deleteUserDetail.do", method = RequestMethod.POST)
	public String deleteUserDetail(Integer detailId, HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		
		
		daoUser.deleteUserDetail(detailId);
		
		user = daoUser.findUserById(user.getId());
		
		session.setAttribute("loggedInUser", user);
		refresh(user, model);
		model.addAttribute("sectionNumber", 1);
		
		return "profile";
		
	}

	@RequestMapping(path = "updateProfile.do", method = RequestMethod.POST)
	public String update(User user, HttpSession session,Model model, Integer locationId) {
		User iduser = (User) session.getAttribute("loggedInUser");
		
		iduser.setFirstName(user.getFirstName());
		iduser.setLastName(user.getLastName());
		iduser.setUsername(user.getUsername());
		iduser.setPassword(user.getPassword());
		iduser.setEmail(user.getEmail());
		iduser.setLocation(daoSearch.getLocation(locationId));
		iduser.setUserImgUrl(user.getUserImgUrl());
		
		
	
		iduser = daoUser.updateBasicUserInfo(iduser, iduser.getId());
		session.setAttribute("loggedInUser",iduser);
		model.addAttribute("sectionNumber", 2);
		refresh(iduser, model);
		return "profile";
	}
	
	@RequestMapping(path = "updateEvent.do", method = RequestMethod.POST)
	public String updateEvent(Event event, HttpSession session, Model model, Integer locationId) {
		User user = (User) session.getAttribute("loggedInUser");
		user = daoUser.findUserById(user.getId());
		List<UserEvent> userevents = user.getUserEvents();
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
		refresh(user, model);
		model.addAttribute("sectionNumber", 3);
		return "profile";
	}
	
}

