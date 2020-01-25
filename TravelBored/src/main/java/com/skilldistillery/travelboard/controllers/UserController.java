package com.skilldistillery.travelboard.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.travelboard.entities.User;

@Controller
public class UserController {
	
	@RequestMapping(path="logout.do", method = RequestMethod.GET)
	public String userLogout() {
		return "landing";
		
	}

}
