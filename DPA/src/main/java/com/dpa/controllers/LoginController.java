package com.dpa.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpa.model.DegreePlan;
import com.dpa.model.Login;
import com.dpa.model.Request;
import com.dpa.security.Hashing;
import com.dpa.service.DegreePlanService;
import com.dpa.service.LoginService;
import com.dpa.service.RetrieveUsersService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	RetrieveUsersService retrieveUsersService;
	@Autowired
	DegreePlanService degreePlanService;
//It redirects all the users to the login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
//This method is called upon hitting login button and validates user
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String userName, @RequestParam String password,
			@RequestParam String role, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		List<Login> result = new ArrayList<Login>();
		Hashing hashing = new Hashing();
		String pwd = hashing.hashString(password, "MD5");
		result = loginService.checkCredentials(userName, pwd, role);
		int appStatus = 0;
		for(Login l:result) {  
		    if((l.getApprovalStatus()).equals("pending")) {
		    	appStatus = 1;
		    }
		} 
		if (result.isEmpty() == true) {
			model.put("errorMsg", "Invalid Credentials");
			return "login";
		}
		else if(appStatus == 1) {
			model.put("errorMsg", "Need Admin Approval(Usually takes 3-5 days)");
			return "login";
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("userName",userName); 
			if (role.equals("admin")) {
				return "adminhome";
			} else if(role.equals("student")) {
				List<Request> myAdvisors = retrieveUsersService.getMyAdvisors(userName);
				model.addAttribute("myAdvisors", myAdvisors);
				return "studenthome";
			} else if(role.equals("professor")) {
				model.addAttribute("myStudents", retrieveUsersService.getMyStudents(userName));
				return "professorhome";
			}else if(role.equals("chair")) {
				model.addAttribute("receivedDegreePlansLevel3", degreePlanService.getReceivedDegreePlansLevel3(userName));
				model.addAttribute("myStudents", retrieveUsersService.getMyStudents(userName));
				return "chairhome";
			}else if(role.equals("associateChair")) {
				model.addAttribute("myStudents", retrieveUsersService.getMyStudents(userName));
				model.addAttribute("receivedDegreePlansLevel2", degreePlanService.getReceivedDegreePlansLevel2(userName));
				return "associatechairhome";
			}else if(role.equals("adminspecialist")) {
				model.addAttribute("degreePlans", degreePlanService.getDegreePlans());
				return "adminspecialisthome";
			}else {
				return "login";
			}
		}
	}
}
