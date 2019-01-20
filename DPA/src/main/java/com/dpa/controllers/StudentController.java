package com.dpa.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dpa.model.Request;
import com.dpa.service.RetrieveUsersService;

@Controller
public class StudentController {
	@Autowired
	RetrieveUsersService retrieveUsersService;

	@RequestMapping(value = "/studenthome", method = RequestMethod.GET)
	public String studentHome(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			List<Request> myAdvisors = retrieveUsersService.getMyAdvisors(userName);
			model.addAttribute("myAdvisors", myAdvisors);
			return "studenthome";
		} else {
			return "login";
		}
		
	}
}
