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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpa.model.CoreUpdate;
import com.dpa.service.DegreePlanService;

@Controller
public class AdminSpecialistController {
	@Autowired
	DegreePlanService degreePlanService;
	
	//It redirects all the admin specialist to adminspecialist home page
		@RequestMapping(value = "/adminspecialisthome", method = RequestMethod.GET)
		public String adminHome(Model model) {
			model.addAttribute("degreePlans", degreePlanService.getDegreePlans());
			return "adminspecialisthome";
		}
		
		//It gets the Degree Plan Information
		@RequestMapping(value = "/viewDPI", method = RequestMethod.POST)
		public String getDPI(HttpServletRequest request, HttpServletResponse response, Model model) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				model.addAttribute("dpi", degreePlanService.getDPI());
				model.addAttribute("interestareas", degreePlanService.getInterestAreas());
			}
			return "dpi";
		}
		
		//It gets Interest Area Courses
		@RequestMapping(value = "/getInterestCourses", method = RequestMethod.POST)
		public String getInterestCourses(@RequestBody String major, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
			HttpSession session = request.getSession(false);
			String[] mjor = major.split("=");
			String[] m1 = mjor[1].split("&");
			String m = m1[0];
			String interest1 = mjor[2];
			String interest = interest1.replaceAll("\\+", " ");
			model.put("interest", interest);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				List<Integer> optionalCourses = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
				model.addAttribute("groupACourses", degreePlanService.getGroupACourses(m));
				model.addAttribute("groupBCourses", degreePlanService.getGroupBCourses(m));
				model.addAttribute("groupCCourses", degreePlanService.getGroupCCourses(m));
				model.addAttribute("groupDCourses", degreePlanService.getGroupDCourses(m));
				model.addAttribute("optionalCourses", optionalCourses);
				model.addAttribute("optionalCourseLists", degreePlanService.getOptionalCourses());
			}
			return "dpi_courses";
		}
		
		//It redirects all the admin specialist to adminspecialist home page
		@RequestMapping(value = "/updateDPI", method = RequestMethod.GET)
		public String updateDPI(HttpServletRequest request, HttpServletResponse response, Model model) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				model.addAttribute("dpi", degreePlanService.getDPI());
				List<Integer> optionalCourses = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
				model.addAttribute("groupACourses", degreePlanService.getGroupACourses("computerScience"));
				model.addAttribute("groupBCourses", degreePlanService.getGroupBCourses("computerScience"));
				model.addAttribute("groupCCourses", degreePlanService.getGroupCCourses("computerScience"));
				model.addAttribute("groupDCourses", degreePlanService.getGroupDCourses("computerScience"));
				model.addAttribute("groupACoursesCE", degreePlanService.getGroupACourses("CE"));
				model.addAttribute("groupBCoursesCE", degreePlanService.getGroupBCourses("CE"));
				model.addAttribute("groupCCoursesCE", degreePlanService.getGroupCCourses("CE"));
				model.addAttribute("groupDCoursesCE", degreePlanService.getGroupDCourses("CE"));
				model.addAttribute("optionalCourses", optionalCourses);
				model.addAttribute("optionalCourseLists", degreePlanService.getOptionalCourses());
				return "updatedpi";	
			}else {
			return "login";	
			}
		}
		
		//This method updates Degree Plan Information
		@RequestMapping(value = "/updateDPInfo", method = RequestMethod.POST)
		public String updateDPIInfo(@RequestParam String dPIInfo, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				int result = degreePlanService.updateDPIInfo(dPIInfo);
				if(result == 1) {
					model.put("success", "Updated Successfully");
				}else {
					model.put("error", "Update failed");
				}
				model.addAttribute("dpi", degreePlanService.getDPI());
				List<Integer> optionalCourses = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
				model.addAttribute("groupACourses", degreePlanService.getGroupACourses("computerScience"));
				model.addAttribute("groupBCourses", degreePlanService.getGroupBCourses("computerScience"));
				model.addAttribute("groupCCourses", degreePlanService.getGroupCCourses("computerScience"));
				model.addAttribute("groupDCourses", degreePlanService.getGroupDCourses("computerScience"));
				model.addAttribute("groupACoursesCE", degreePlanService.getGroupACourses("CE"));
				model.addAttribute("groupBCoursesCE", degreePlanService.getGroupBCourses("CE"));
				model.addAttribute("groupCCoursesCE", degreePlanService.getGroupCCourses("CE"));
				model.addAttribute("groupDCoursesCE", degreePlanService.getGroupDCourses("CE"));
				model.addAttribute("optionalCourses", optionalCourses);
				model.addAttribute("optionalCourseLists", degreePlanService.getOptionalCourses());
				return "updatedpi";	
			}else {
				return "login";
			}
		}
		//This method updates Degree Plan Information
				@RequestMapping(value = "/updateCoreCourses", method = RequestMethod.POST)
				public String updateDPICC(@ModelAttribute CoreUpdate coreUpdate, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
					HttpSession session = request.getSession(false);
					if (session != null) {
						String userName = (String) session.getAttribute("userName");
						coreUpdate = degreePlanService.checkChangedCourse(coreUpdate);
						int result = degreePlanService.updateDPICC(coreUpdate);
						if(result == 1) {
							model.put("success", "Updated Successfully");
						}else {
							model.put("error", "Update failed");
						}
						model.addAttribute("dpi", degreePlanService.getDPI());
						List<Integer> optionalCourses = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
						model.addAttribute("groupACourses", degreePlanService.getGroupACourses("computerScience"));
						model.addAttribute("groupBCourses", degreePlanService.getGroupBCourses("computerScience"));
						model.addAttribute("groupCCourses", degreePlanService.getGroupCCourses("computerScience"));
						model.addAttribute("groupDCourses", degreePlanService.getGroupDCourses("computerScience"));
						model.addAttribute("groupACoursesCE", degreePlanService.getGroupACourses("CE"));
						model.addAttribute("groupBCoursesCE", degreePlanService.getGroupBCourses("CE"));
						model.addAttribute("groupCCoursesCE", degreePlanService.getGroupCCourses("CE"));
						model.addAttribute("groupDCoursesCE", degreePlanService.getGroupDCourses("CE"));
						model.addAttribute("optionalCourses", optionalCourses);
						model.addAttribute("optionalCourseLists", degreePlanService.getOptionalCourses());
						return "updatedpi";	
					}else {
						return "login";
					}
				}
				
				//This method adds optional course
				@RequestMapping(value = "/addOpCourse", method = RequestMethod.POST)
				public String addOpCourse(@RequestBody String cName, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
					HttpSession session = request.getSession(false);
					if (session != null) {
						String userName = (String) session.getAttribute("userName");
						String[] coName = cName.split("=");
						String courseName = coName[1];
						String oPName = courseName.replaceAll("\\+", " ");
						int result = degreePlanService.addOpCourse(oPName);
						if(result == 1) {
							model.put("success", "Added Successfully");
						}else {
							model.put("error", "Add failed");
						}
						model.addAttribute("dpi", degreePlanService.getDPI());
						List<Integer> optionalCourses = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
						model.addAttribute("groupACourses", degreePlanService.getGroupACourses("computerScience"));
						model.addAttribute("groupBCourses", degreePlanService.getGroupBCourses("computerScience"));
						model.addAttribute("groupCCourses", degreePlanService.getGroupCCourses("computerScience"));
						model.addAttribute("groupDCourses", degreePlanService.getGroupDCourses("computerScience"));
						model.addAttribute("groupACoursesCE", degreePlanService.getGroupACourses("CE"));
						model.addAttribute("groupBCoursesCE", degreePlanService.getGroupBCourses("CE"));
						model.addAttribute("groupCCoursesCE", degreePlanService.getGroupCCourses("CE"));
						model.addAttribute("groupDCoursesCE", degreePlanService.getGroupDCourses("CE"));
						model.addAttribute("optionalCourses", optionalCourses);
						model.addAttribute("optionalCourseLists", degreePlanService.getOptionalCourses());
						return "updatedpi";	
					}else {
						return "login";
					}
				}
				
				//This method deletes optional course
				@RequestMapping(value = "/deleteOpCourse", method = RequestMethod.POST)
				public String deleteOpCourse(@RequestBody String cName, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
					HttpSession session = request.getSession(false);
					if (session != null) {
						String userName = (String) session.getAttribute("userName");
						String[] coName = cName.split("=");
						String courseName = coName[1];
						String oPName = courseName.replaceAll("\\+", " ");
						int result = degreePlanService.deleteOpCourse(oPName);
						if(result == 1) {
							model.put("success", "Deleted Successfully");
						}else {
							model.put("error", "Delete failed");
						}
						model.addAttribute("dpi", degreePlanService.getDPI());
						List<Integer> optionalCourses = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
						model.addAttribute("groupACourses", degreePlanService.getGroupACourses("computerScience"));
						model.addAttribute("groupBCourses", degreePlanService.getGroupBCourses("computerScience"));
						model.addAttribute("groupCCourses", degreePlanService.getGroupCCourses("computerScience"));
						model.addAttribute("groupDCourses", degreePlanService.getGroupDCourses("computerScience"));
						model.addAttribute("groupACoursesCE", degreePlanService.getGroupACourses("CE"));
						model.addAttribute("groupBCoursesCE", degreePlanService.getGroupBCourses("CE"));
						model.addAttribute("groupCCoursesCE", degreePlanService.getGroupCCourses("CE"));
						model.addAttribute("groupDCoursesCE", degreePlanService.getGroupDCourses("CE"));
						model.addAttribute("optionalCourses", optionalCourses);
						model.addAttribute("optionalCourseLists", degreePlanService.getOptionalCourses());
						return "updatedpi";	
					}else {
						return "login";
					}
				}
				
}
