package com.dpa.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dpa.model.Request;
import com.dpa.service.RequestService;

@Controller
public class RequestController {
	@Autowired
	RequestService requestService;
	
//returns advisor request form	
	@RequestMapping(value = "/sendrequest", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
		} 
		return "advisorrequest";
	}
//calls send request of requestService and redirects student to studenthome
	@RequestMapping(value = "/sendrequest", method = RequestMethod.POST)
	public String sendRequest(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Request sendRequest, ModelMap model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
		} 
		int result = requestService.sendRequest(sendRequest);
		return "studenthome";
	}
//calls getSentRequests method of requestService and redirects student to sentrequests
	@RequestMapping(value = "/sentrequests", method = RequestMethod.GET)
	public String getSentRequests(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		HttpSession session = request.getSession(false);
		List<Request> sentRequests = new ArrayList<Request>();
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			model.addAttribute("sentRequests", requestService.getSentRequests(userName));
			return "sentrequests";
		}else {
		return "login";
		}
	}
//calls getReceivedRequests method of requestService and redirects professor to receivedrequests
	@RequestMapping(value = "/receivedrequests", method = RequestMethod.GET)
	public String getReceivedRequests(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		HttpSession session = request.getSession(false);
		List<Request> receivedRequests = new ArrayList<Request>();
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			model.addAttribute("receivedRequests", requestService.getReceivedRequests(userName));
			return "receivedrequests";
		}else {
		return "login";
		}
	}
//calls acceptRequest method of requestService and redirects professor to professorhome	
	@RequestMapping(value = "/acceptrequest", method = RequestMethod.POST, consumes="application/json")
	public String acceptRequest(@RequestBody String details, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		String[] requestDetails = requestService.splitString(details);
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			int Result = requestService.acceptRequest(requestDetails[0], requestDetails[1], requestDetails[2], requestDetails[3]);
			return "professorhome";
		}else {
		return "login";
		}
	}
//calls deleteRequest method of requestService and redirects user to their home
	@RequestMapping(value = "/deleterequest", method = RequestMethod.POST, consumes="application/json")
	public String deleteRequest(@RequestBody String details, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		String[] receivedDetails = requestService.split(details);
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			int Result = requestService.deleteRequest(receivedDetails[0], receivedDetails[1]);
			return "studenthome";
		}else {
		return "login";
		}
	}
	
}
