package com.dpa.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dpa.service.DegreePlanService;
import com.dpa.service.RetrieveUsersService;

@Controller
public class ProfessorController {
	@Autowired 
	RetrieveUsersService retrieveStudents;
	@Autowired
	DegreePlanService degreePlanService;
	
	@RequestMapping(value = "/professorhome", method = RequestMethod.GET)
	public String professorHome(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			model.addAttribute("myStudents", retrieveStudents.getMyStudents(userName));
			return "professorhome";
		} else {
		return "login";
		}
	}
	
	@RequestMapping(value = "/associatechairhome", method = RequestMethod.GET)
	public String viewAssociateChairHome(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			model.addAttribute("receivedDegreePlansLevel2", degreePlanService.getReceivedDegreePlansLevel2(userName));
			model.addAttribute("myStudents", retrieveStudents.getMyStudents(userName));
			return "associatechairhome";
		} else {
		return "login";
		}
	}
	
	@RequestMapping(value = "/chairhome", method = RequestMethod.GET)
	public String viewChairHome(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			model.addAttribute("receivedDegreePlansLevel3", degreePlanService.getReceivedDegreePlansLevel3(userName));
			model.addAttribute("myStudents", retrieveStudents.getMyStudents(userName));
			return "chairhome";
		} else {
		return "login";
		}
	}
	
	@RequestMapping(value = "/mystudents", method = RequestMethod.GET)
	public String getMyStudents(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			model.addAttribute("myStudents", retrieveStudents.getMyStudents(userName));
			return "mystudents";
		} else {
		return "login";
		}
	}
}
