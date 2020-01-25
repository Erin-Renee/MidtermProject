package com.skilldistillery.travelboard.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.travelboard.data.DAOSearch;
import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.Location;
import com.skilldistillery.travelboard.entities.User;

@Controller
public class SearchController {
	@Autowired
	private DAOSearch daoSearch;

	@RequestMapping(path = "search.do", method = RequestMethod.GET)
	public String search(Model model, String keyword, String location, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");

		if (location == null && user != null) {
			
			int locId = user.getLocation().getId();
			List<User> userList = daoSearch.searchUsername(keyword);
			List<Event> eventList = daoSearch.searchEvent(keyword, locId);
			model.addAttribute("userList", userList);
			model.addAttribute("eventList", eventList);
			
		} else if (location == null && user == null) {
			
			int locId = 0;
			List<Event> eventList = daoSearch.searchEvent(keyword, locId);
			model.addAttribute("eventList", eventList);

		} else if (location != null && user == null) {
			
			Location loc = daoSearch.searchLocation(location);
			int locId = loc.getId();
			List<Event> eventList = daoSearch.searchEvent(keyword, locId);
			model.addAttribute("eventList", eventList);

		} else if (location != null && user != null) {

			Location loc = daoSearch.searchLocation(location);
			int locId = loc.getId();
			List<Event> eventList = daoSearch.searchEvent(keyword, locId);
			List<User> userList = daoSearch.searchUsername(keyword);
			model.addAttribute("eventList", eventList);
			model.addAttribute("userList", userList);

		}

		return "results";

	}

}
