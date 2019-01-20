package com.dpa.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dpa.General.Pdf;
import com.dpa.model.Courses;
import com.dpa.model.DegreePlan;
import com.dpa.model.GRE;
import com.dpa.model.Request;
import com.dpa.service.DegreePlanService;
import com.dpa.service.RetrieveUsersService;

//handles the view, submit, save and all other degree plan action requests
@Controller
public class DegreePlanController {
	@Autowired
	DegreePlanService degreePlanService;
	@Autowired
	RetrieveUsersService retrieveUsersService;
	@Autowired 
	RetrieveUsersService retrieveStudents;
	
//gets mandatory and optional courses form the database and makes them available to the view degreepla.jsp
	@RequestMapping(value = "/degreeplan", method = RequestMethod.POST)
	public String openDegreePlan(@RequestParam String selectPlan,@RequestParam String majProfessor, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		model.put("major", selectPlan);
		model.put("majorProfessor", majProfessor);
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			List<Integer> optionalCourses = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
			model.addAttribute("groupACourses", degreePlanService.getGroupACourses(selectPlan));
			model.addAttribute("groupBCourses", degreePlanService.getGroupBCourses(selectPlan));
			model.addAttribute("groupCCourses", degreePlanService.getGroupCCourses(selectPlan));
			model.addAttribute("groupDCourses", degreePlanService.getGroupDCourses(selectPlan));
			model.addAttribute("optionalCourses", optionalCourses);
			model.addAttribute("optionalCourseLists", degreePlanService.getOptionalCourses());
			return "degreeplan";
		} else {
			return "login";
		}
	}
//redirects user to the degree plan page with the success message upon success else to the degree plan with error message
	@RequestMapping(value = "/degreeplanform", method = RequestMethod.POST)
	public String submitDegreePlan(@ModelAttribute DegreePlan degreePlan, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			int result = degreePlanService.submitDegreePlan(degreePlan, userName);
			model.put("success", "Degree Plan Submitted Successfully");
			return "degreeplan";
		} else {
			model.put("error", "Submission Failed");
			return "degreeplan";
		}
	}
	
	//method that returns a vieDegreePlan page with the model data of the page
		@RequestMapping(value = "/viewdegreeplan", method = RequestMethod.GET)
		public String viewPlan(@RequestParam(value = "uName", required = false) String uName, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				model.addAttribute("degreePlan", degreePlanService.viewDegreePlan(uName, userName));
				model.addAttribute("gre", degreePlanService.getGREScores(uName));
				model.addAttribute("courses", degreePlanService.getCourses(uName));
				return "viewdegreeplan";
			} else {
				return "login";
			}
		}
		
		//This method submits the degree plan to the administrative specialist
		@RequestMapping(value = "/submitToAdminSpecialist", method = RequestMethod.POST)
		public String submitToAdminSpecialist(@RequestParam String sign, @RequestParam String sName, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				model.addAttribute("degreePlan", degreePlanService.viewDegreePlan(sName, userName));
				model.addAttribute("gre", degreePlanService.getGREScores(sName));
				model.addAttribute("courses", degreePlanService.getCourses(sName));
				int result = degreePlanService.submitToAdminSpecialist(userName, sName, sign);
				if(result != 0) {
					model.put("success", "Degree Plan Successfully submitted to Admin Specialist");
					return "viewdegreeplan";
				}else {
					model.put("error", "Submission Failed, try again");
					return "viewdegreeplan";	
				}
			} else {
				return "login";
			}
		}
		
		//This method submits the degree plan to the administrative specialist
		@RequestMapping(value = "/submitToAS", method = RequestMethod.POST)
		public String submitToASL2(@RequestParam String sign, @RequestParam String sName, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				int result = degreePlanService.submitToASL2(userName, sName, sign);
				if(result != 0) {
					model.put("success", "Degree Plan approved");
					model.addAttribute("receivedDegreePlansLevel2", degreePlanService.getReceivedDegreePlansLevel2(userName));
					model.addAttribute("myStudents", retrieveStudents.getMyStudents(userName));
					return "associatechairhome";
				}else {
					model.put("error", "Approval Failed");
					model.addAttribute("receivedDegreePlansLevel2", degreePlanService.getReceivedDegreePlansLevel2(userName));
					model.addAttribute("myStudents", retrieveStudents.getMyStudents(userName));
					return "associatechairhome";	
				}
			} else {
				return "login";
			}
		}
		
		@RequestMapping(value = "/submitToAS2", method = RequestMethod.POST)
		public String submitToASL3(@RequestParam String sign, @RequestParam String sName, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				int result = degreePlanService.submitToASL3(userName, sName, sign);
				if(result != 0) {
					model.put("success", "Degree Plan approved");
					model.addAttribute("receivedDegreePlansLevel3", degreePlanService.getReceivedDegreePlansLevel3(userName));
					model.addAttribute("myStudents", retrieveStudents.getMyStudents(userName));
					return "associatechairhome";
				}else {
					model.put("error", "Approval Failed");
					model.addAttribute("receivedDegreePlansLevel3", degreePlanService.getReceivedDegreePlansLevel3(userName));
					model.addAttribute("myStudents", retrieveStudents.getMyStudents(userName));
					return "associatechairhome";	
				}
			} else {
				return "login";
			}
		}
		
		//This method submits the degree plan to the administrative specialist
		@RequestMapping(value = "/submitToAssociateChair", method = RequestMethod.POST)
		public String submitToAssociateChair(@RequestParam String sName, @RequestParam int studentId, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				int result = degreePlanService.submitToAssociateChair(studentId, sName);
				if(result != 0) {
					model.put("success", "Degree Plan Successfully submitted to Associate Chair");
					model.addAttribute("degreePlans", degreePlanService.getDegreePlans());
					return "adminspecialisthome";
				}else {
					model.put("error", "Submission Failed, try again");
					return "adminspecialisthome";	
				}
			} else {
				return "login";
			}
		}
		
		//This method submits the degree plan to the administrative specialist
		@RequestMapping(value = "/submitToChair", method = RequestMethod.POST)
		public String submitToChair(@RequestParam String sName, @RequestParam int studentId, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				int result = degreePlanService.submitToChair(studentId, sName);
				if(result != 0) {
					model.put("success", "Degree Plan Successfully submitted to Associate Chair");
					model.addAttribute("degreePlans", degreePlanService.getDegreePlans());
					return "adminspecialisthome";
				}else {
					model.put("error", "Submission Failed, try again");
					return "adminspecialisthome";	
				}
			} else {
				return "login";
			}
		}
		
		//This method submits the degree plan to the administrative specialist
		@RequestMapping(value = "/sendApprovaltoStudent", method = RequestMethod.POST)
		public String sendApprovaltoStudent(@RequestParam String sName, @RequestParam int studentId, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				int result = degreePlanService.sendApprovaltoStudent(studentId, sName);
				if(result != 0) {
					model.put("success", "Approval Sent to student");
					model.addAttribute("degreePlans", degreePlanService.getDegreePlans());
					return "adminspecialisthome";
				}else {
					model.put("error", "Sending Failed, try again");
					return "adminspecialisthome";	
				}
			} else {
				return "login";
			}
		}
				
		//It redirects professor to add reject comments page
		@RequestMapping(value = "/rejectDP", method = RequestMethod.POST)
		public String rejectComments(@RequestBody String sName, ModelMap model) {
			String[] sUname = sName.split("=");
			String studentName = sUname[1];
			model.put("studentName", studentName);
			return "rejectcomments";
		}
		
		//This method submits the degree plan to the administrative specialist
		@RequestMapping(value = "/degreePlanReject", method = RequestMethod.POST)
		public String dPProfessorReject(@RequestParam String studentName, @RequestParam String comments, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				int result = degreePlanService.dPProfessorreject(userName, studentName, comments);
				if(result != 0) {
					model.put("success", "Comments submitted to the student");
					return "rejectcomments";
				}else {
					model.addAttribute("degreePlan", degreePlanService.viewDegreePlan(studentName, userName));
					model.addAttribute("gre", degreePlanService.getGREScores(studentName));
					model.addAttribute("courses", degreePlanService.getCourses(studentName));
					return "viewdegreeplan";
				}
			} else {
				return "login";
			}
		}
		//This method submits the degree plan to the administrative specialist
		@RequestMapping(value = "/viewDPStatus", method = RequestMethod.POST)
		public String viewDPStatus(@RequestParam String majorProfessor, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				String dpStatus = degreePlanService.getDPStatus(userName, majorProfessor);
				if(dpStatus.equals("submitted")) {
					dpStatus = "With Professor";
				}
				model.put("degreePlanStatus", dpStatus);
				List<Request> myAdvisors = retrieveUsersService.getMyAdvisors(userName);
				model.addAttribute("myAdvisors", myAdvisors);
				if(dpStatus.equals("Professor Rejected") || dpStatus.equals("AdminSpecialist Rejected") || dpStatus.equals("AssociateChair Rejected") || dpStatus.equals("Chair Rejected")) {
					String rejectComments = degreePlanService.getComments(userName, majorProfessor);
					model.put("rejectComments", rejectComments);
					model.put("resubmitDP", "Update and resubmit the Degree Plan");
				}else if(dpStatus.equals("Degree Plan approved in the CSCE Department")) {
					model.put("downloadDP","Download the Approved Degree Plan");
				}
				return "studenthome";
			} else {
				return "login";
			}
		}
		
		//This method submits the degree plan to the administrative specialist
		@RequestMapping(value = "/updateDegreePlan", method = RequestMethod.POST)
		public String updateDegreePlan(HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				model.addAttribute("degreePlan", degreePlanService.getDegreePlan(userName));
				model.addAttribute("gre", degreePlanService.getGREScores(userName));
				model.addAttribute("courses", degreePlanService.getCourses(userName));
				List<Request> myAdvisors = retrieveUsersService.getMyAdvisors(userName);
				model.addAttribute("myAdvisors", myAdvisors);
				return "updatedegreeplan";
			} else {
				return "login";
			}
		}
		
		//updates and resubmits degree plan
		@RequestMapping(value = "/updatedegreeplan", method = RequestMethod.POST)
		public String updatetDegreePlan(@ModelAttribute DegreePlan degreePlan, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				degreePlanService.updateDegreePlan(degreePlan, userName);
				model.put("success", "Degree Plan Submitted Successfully");
				return "degreeplan";
			} else {
				model.put("error", "Submission Failed");
				return "degreeplan";
			}
		}
		
		//This method gets the submitted degree plan data
		@RequestMapping(value = "/receivedDegreePlan", method = RequestMethod.POST)
		public String receivedDegreePlan(@RequestBody String studentDetails, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
			HttpSession session = request.getSession(false);
			if (session != null) {
			String[] sDetails = studentDetails.split("=");
			String[] sD = sDetails[1].split("&");
			String sName = sD[0];
			String sId = sDetails[2];
			DegreePlan degreePlan = degreePlanService.getReceivedDP(sName, sId);
			model.addAttribute("degreePlan", degreePlan);
			model.addAttribute("gre", degreePlanService.getGREScores(sName));
			model.addAttribute("courses", degreePlanService.getCourses(sName));
				if((degreePlan.getDegreePlanStatus()).equals("With Administrative Specialist")) {
					return "dp_AS_View";
				}else if((degreePlan.getDegreePlanStatus()).equals("Chair Approved")){
					return "dp_AS_S_View";
				}else if((degreePlan.getDegreePlanStatus()).equals("Degree Plan approved in the CSCE Department")){
					return "dp_AS_S_View";
				}else {
					return "dp_AS_C_View";
				}
			} else {
				return "login";
			}
		}
		
		//This method gets the submitted degree plan data
		@RequestMapping(value = "/receivedDegreePlanAS", method = RequestMethod.POST)
		public String receivedDegreePlanAS(@RequestBody String studentDetails, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
			HttpSession session = request.getSession(false);
			if (session != null) {
			String[] sDetails = studentDetails.split("=");
			String[] sD = sDetails[1].split("&");
			String sName = sD[0];
			String sId = sDetails[2];
			model.addAttribute("degreePlan", degreePlanService.getReceivedDP(sName, sId));
			model.addAttribute("gre", degreePlanService.getGREScores(sName));
			model.addAttribute("courses", degreePlanService.getCourses(sName));
				return "dpAssociateChairView";
			} else {
				return "login";
			}

		}
		//This method gets the submitted degree plan data
		@RequestMapping(value = "/receivedDegreePlanAS2", method = RequestMethod.POST)
		public String receivedDegreePlanAS2(@RequestBody String studentDetails, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
			HttpSession session = request.getSession(false);
			if (session != null) {
			String[] sDetails = studentDetails.split("=");
			String[] sD = sDetails[1].split("&");
			String sName = sD[0];
			String sId = sDetails[2];
			model.addAttribute("degreePlan", degreePlanService.getReceivedDP(sName, sId));
			model.addAttribute("gre", degreePlanService.getGREScores(sName));
			model.addAttribute("courses", degreePlanService.getCourses(sName));
				return "dpChairView";
			} else {
				return "login";
			}

		}
		
		//This method will download the approved degree plan
		@RequestMapping(value = "/viewApprovedDP", method = RequestMethod.POST)
		public void  downloadApprovedDP(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				DegreePlan degreePlan = degreePlanService.getDegreePlan(userName);
				GRE gre = degreePlanService.getGREScores(userName);
				List<Courses> courses = degreePlanService.getCourses(userName);
				List<Request> myAdvisors = retrieveUsersService.getMyAdvisors(userName);
				model.addAttribute("myAdvisors", myAdvisors);
				Pdf pdf = new Pdf();
				int r = pdf.generatePdf(degreePlan, gre, courses);
				
				String dataDirectory = request.getServletContext().getRealPath("../../../");
		        Path file = Paths.get(dataDirectory, "DegreePlan.pdf");
		            response.setContentType("application/pdf");
		            response.addHeader("Content-Disposition", "attachment; filename="+"DegreePlan.pdf");
		            try
		            {
		                Files.copy(file, response.getOutputStream());
		                response.getOutputStream().flush();
		            }
		            catch (IOException ex) {
		                ex.printStackTrace();
		            }
			}
		}
}



