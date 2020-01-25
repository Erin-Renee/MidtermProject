package com.skilldistillery.travelboard.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.travelboard.data.DAOUser;
import com.skilldistillery.travelboard.entities.Location;
import com.skilldistillery.travelboard.entities.User;

@Controller
public class UserController {
	@Autowired
	private DAOUser daoUser;

	@RequestMapping(path = "logout.do", method = RequestMethod.GET)
	public String userLogout(HttpSession session) {
		session.removeAttribute("loggedInUser");
		return "landing";

	}

	@RequestMapping(path = "register.do", method = RequestMethod.POST)
	public String register(HttpSession session, User user) {
		Location location = new Location();
		location.setId(1);
		user.setLocation(location);
		user = daoUser.create(user);
		session.setAttribute("loggedInUser", user);
		return "profile";
	}

	@RequestMapping(path = "disableProfile.do", method = RequestMethod.GET)
	public String disable(HttpSession session) {

		User user = (User) session.getAttribute("loggedInUser");
		user.setActive(false);
		return "adminsettings";

	}
	@RequestMapping(path = "updateProfile.do", method = RequestMethod.POST)
	public String update(User user, int userId) {
		user = daoUser.updateBasicUserInfo(user, userId);
		return "profile";
	}
}
