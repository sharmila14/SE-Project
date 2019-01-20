package com.dpa.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.dpa.model.Register;
import com.dpa.security.Hashing;
import com.dpa.service.AdminService;
import com.dpa.service.RegisterService;
import com.dpa.service.RetrieveUsersService;

@Controller
public class AdminController {
	@Autowired
	RegisterService registerService;
	@Autowired
	RetrieveUsersService retrieveUsersService;
	@Autowired
	AdminService adminService;
	
//directs user to adminhome	
	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	public String login() {
		return "adminhome";
	}
//returns add user page
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String manageChair(HttpServletRequest request, HttpServletResponse response, @RequestParam String add, Model model) {
		model.addAttribute("user", add);
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
		} 
		return "adduser";
	}
//calls insertUser() of registerService class to add chair, associate chair and admin specialist to the database	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute Register register, ModelMap model) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Hashing hashing = new Hashing();
		String pwd = hashing.hashString(register.getPassword(), "MD5");
		register.setPassword(pwd);
		String role = register.getRole();
		String approvalStatus;
		if(role.equals("professor") || role.equals("student"))
		{
			approvalStatus = "pending";
		}else {
			approvalStatus = "approved";
		}
		int result = registerService.insertUser(register, approvalStatus);
		if (result == 1) {
			model.put("success", "User registered successfully");
			return "adduser";
		} else {
			model.put("error", "Username already existing");
			return "adduser";
		}
	}
	
	//Approve Users
		@RequestMapping(value = "/approveUsers", method = RequestMethod.GET)
		public String approveUsers(HttpServletRequest request, HttpServletResponse response, Model model) {
			model.addAttribute("toBeApprovedUsers", retrieveUsersService.getNeedApprovalList());
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
			} 
			return "toApproveList";
		}
		
		//Approve User
		@RequestMapping(value = "/approveUser", method = RequestMethod.POST)
		public String approveUser(@RequestBody String userName, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
			HttpSession session = request.getSession(false);
			if (session != null) {
			String[] sUname = userName.split("=");
			String uName = sUname[1];
			adminService.ApproveUser(uName);
			model.put("success", "User Approved");
			model.addAttribute("toBeApprovedUsers", retrieveUsersService.getNeedApprovalList());
				return "toApproveList";
			} else {
				return "login";
			}

		}
		
		//Reject User
		@RequestMapping(value = "/rejectUser", method = RequestMethod.POST)
		public String rejectUser(@RequestBody String userName, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
			HttpSession session = request.getSession(false);
			if (session != null) {
			String[] sUname = userName.split("=");
			String uName = sUname[1];
			adminService.rejectUser(uName);
			model.put("success", "User Rejected");
			model.addAttribute("toBeApprovedUsers", retrieveUsersService.getNeedApprovalList());
				return "toApproveList";
			} else {
				return "login";
			}

		}
		
		//returns staff list
		@RequestMapping(value = "/staffDirectory", method = RequestMethod.POST)
		public String staffDirectory(HttpServletRequest request, HttpServletResponse response, Model model) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				model.addAttribute("staffLists", retrieveUsersService.getstaffList());
			} 
			return "staffList";
		}
		
		//returns contact us page
		@RequestMapping(value = "/contactUs", method = RequestMethod.POST)
		public String contactUs(HttpServletRequest request, HttpServletResponse response, Model model) {
			return "contactUs";
		}
}
