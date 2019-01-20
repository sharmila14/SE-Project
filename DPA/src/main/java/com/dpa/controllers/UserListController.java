package com.dpa.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dpa.model.Register;
import com.dpa.model.Request;
import com.dpa.service.RequestService;
import com.dpa.service.RetrieveStaff;
import com.dpa.service.RetrieveUsersService;


@Controller
public class UserListController {
	@Autowired
	private RetrieveStaff retrieveStaff;
	
	@Autowired
	RequestService requestService;
	
	@Autowired 
	RetrieveUsersService retrieveStudents;
	
	@RequestMapping(value = "/staffdirectory", method = RequestMethod.GET)
	public String getStaffList(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		List<Register> professors = new ArrayList<Register>();
		professors = retrieveStaff.retrieveProfessors();
		List<Request> sentRequests = new ArrayList<Request>();
		List<Request> acceptedRequests = new ArrayList<Request>();
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			sentRequests = requestService.getSentRequests(userName);
			acceptedRequests = requestService.getAcceptedRequests(userName);
		}
		Iterator itr = professors.iterator();  
		Iterator itr1 = sentRequests.iterator();
		Iterator itr2 =acceptedRequests.iterator();
		while(itr1.hasNext()) {
			Request temp1 = (Request) itr1.next();
			while(itr.hasNext()) {
				Register temp = (Register) itr.next();
				String profName = temp1.getProfessorName();
				String name = temp.getName();
				if(profName.equals(name)) {
					itr.remove();
				}
			}
		}
		while(itr2.hasNext()) {
			Request temp2 = (Request) itr2.next();
			while(itr.hasNext()) {
				Register temp3 = (Register) itr.next();
				String profName = temp2.getProfessorName();
				String name = temp3.getName();
				if(profName.equals(name)) {
					itr.remove();
				}
			}
		}
		model.addAttribute("professors", professors);
		return "staffdirectory";
	}

	@RequestMapping(value = "/studentlist", method = RequestMethod.GET)
	public String getStudentList(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			model.addAttribute("students", retrieveStudents.getStudentList());
			return "studentlist";
		} else {
		return "login";
		}
	}
	
	@RequestMapping(value = "/slist", method = RequestMethod.GET)
	public String getStudents(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			model.addAttribute("students", retrieveStudents.getStudentList());
			return "slist";
		} else {
		return "login";
		}
	}
	
	@RequestMapping(value = "/slistAS", method = RequestMethod.GET)
	public String getStudents1(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			model.addAttribute("students", retrieveStudents.getStudentList());
			return "slistAS";
		} else {
		return "login";
		}
	}
}
