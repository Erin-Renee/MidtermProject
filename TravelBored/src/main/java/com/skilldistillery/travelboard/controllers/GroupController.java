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

import com.skilldistillery.travelboard.data.DAOGroup;
import com.skilldistillery.travelboard.data.DAOSearch;
import com.skilldistillery.travelboard.data.DAOUser;
import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.Group;
import com.skilldistillery.travelboard.entities.GroupComment;
import com.skilldistillery.travelboard.entities.Location;
import com.skilldistillery.travelboard.entities.User;
import com.skilldistillery.travelboard.entities.UserEvent;

@Controller
public class GroupController {
	
	@Autowired
	private DAOGroup daoGroup;
	
	@Autowired
	private DAOUser daoUser;
	
	@Autowired
	private DAOSearch daoSearch;
	
	public Model refresh(User user, Model model) {
		List<Location> locations = daoSearch.findAllLocations();
		
		model.addAttribute("locations", locations);
		List<Event> events = new ArrayList<>();
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
		
		model.addAttribute("creatorEvents", creatorEvents);
		
		List<Group> creatorGroups = daoSearch.searchGroupByUser(user.getId());
		
		model.addAttribute("creatorGroups", creatorGroups);
		
		return model;
	}
	
	@RequestMapping(path = "createGroup.do", method = RequestMethod.POST)
	public String createGroup(Group group, Model model, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		user = daoUser.findUserById(user.getId());
		
		
		group.setActive(true);
		group.setCreateDate(LocalDateTime.now().toString());
		group.setUser(user);
		group = daoGroup.create(group);
		
		user.addGroup(group);
		
		session.removeAttribute("loggedInUser");
		session.setAttribute("loggedInUser", user);
		
		model.addAttribute("group", group);
		
		return "group";
	}
	
	@RequestMapping(path = "updateGroup.do", method = RequestMethod.POST)
	public String updateGroup(Group group, HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		
		Group oldGroup = daoGroup.getGroupById(group.getId());
		
		oldGroup.setTitle(group.getTitle());
		oldGroup.setHook(group.getHook());
		
		daoGroup.update(oldGroup, group.getId());
		
		model = refresh(user, model);
		model.addAttribute("sectionNumber", 4);
		
		return "profile";
	}
	
	@RequestMapping(path = "disableGroup.do", method = RequestMethod.POST)
	public String disableGroup(Group group, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		if (group.getUser().getId().equals(user.getId())) {
			group.setActive(false);
		}
		return "group";
	}
	
	@RequestMapping(path = "createGroupComment.do", method = RequestMethod.POST)
	public String createGroupComment (Integer groupId, String comment, HttpSession session, Model model) {
		GroupComment gComment = new GroupComment();
		gComment.setContent(comment);
		gComment.setCreateDate(LocalDateTime.now().toString());
		gComment.setUser((User) session.getAttribute("loggedInUser"));
		gComment.setGroup(daoGroup.getGroupById(groupId));
		
		gComment = daoGroup.submitComment(gComment);
		
		List<GroupComment> commentList = daoGroup.getGroupCommentsByGroupId(groupId);
		
		model.addAttribute("comment", gComment);
		model.addAttribute("group", daoGroup.getGroupById(groupId));
		model.addAttribute("commentList", commentList);
		return "group";
	}
	
	@RequestMapping(path = "deleteGroupComment.do", method = RequestMethod.POST)
	public String deleteGroupComment (GroupComment gComment, HttpSession session, Model model) {
		daoGroup.deleteComment(gComment.getId());
		
		return "group";
	}
	@RequestMapping(path = "gotoGroup.do", method = RequestMethod.GET)
	public String gotoGroup(Integer groupId, HttpSession session, Model model) {
		Group group = daoGroup.getGroupById(groupId);
		
		model.addAttribute("group", group);
		
		List<GroupComment> commentList = daoGroup.getGroupCommentsByGroupId(group.getId());
		model.addAttribute("commentList", commentList);
		
		return "group";
	}
	

}
