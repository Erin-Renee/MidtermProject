package com.skilldistillery.travelboard.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.travelboard.data.DAOGroup;
import com.skilldistillery.travelboard.data.DAOUser;
import com.skilldistillery.travelboard.entities.Group;
import com.skilldistillery.travelboard.entities.GroupComment;
import com.skilldistillery.travelboard.entities.User;

@Controller
public class GroupController {
	
	@Autowired
	private DAOGroup daoGroup;
	
	@Autowired
	private DAOUser daoUser;
	
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
		List<Group> groups = user.getGroups();
		for (Group group2 : groups) {
			if (group2.getUser().getId().equals(user.getId())) {
				daoGroup.update(group, group.getId());
				break;
			}
		}
		
		model.addAttribute("group", group);
		
		return "group";
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
	public String createGroupComment (Group group, String comment, HttpSession session, Model model) {
		GroupComment gComment = new GroupComment();
		gComment.setContent(comment);
		gComment.setCreateDate(LocalDateTime.now().toString());
		gComment.setUser((User) session.getAttribute("loggedInUser"));
		gComment.setGroup(group);
		
		gComment = daoGroup.submitComment(gComment);
		model.addAttribute("comment", gComment);
		return "group";
	}
	
	@RequestMapping(path = "deleteGroupComment.do", method = RequestMethod.POST)
	public String deleteGroupComment (GroupComment gComment, HttpSession session, Model model) {
		daoGroup.deleteComment(gComment.getId());
		
		return "group";
	}
	

}
