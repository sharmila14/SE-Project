package com.dpa.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dpa.model.Register;
import com.dpa.service.AccountInformationService;

@Controller
public class MyAccountController {
	@Autowired
	AccountInformationService accountInformationService;
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String accountInformation(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			model.addAttribute("accountDetails", accountInformationService.getAccountDetails(userName));
			return "accountdetails";
		} else {
			return "login";
		}
	}
	
	@RequestMapping(value = "/updateaccount", method = RequestMethod.POST)
	public String updateAccountInformation(@ModelAttribute Register register, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			int result = accountInformationService.updateAccountDetails(register);
			if(result != 0) {
				model.addAttribute("accountDetails", accountInformationService.getAccountDetails(userName));
				model.put("success", "Account details updated Successfully");
				return "accountdetaills";
			}else {
				model.put("error", "Update Failed, please try again");
				return "accountdetaills";
			}
		} else {
			return "login";
		}
	}

}
