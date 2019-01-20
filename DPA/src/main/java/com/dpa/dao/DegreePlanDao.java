package com.dpa.dao;

import java.util.List;

import com.dpa.model.CoreUpdate;
import com.dpa.model.Course;
import com.dpa.model.Courses;
import com.dpa.model.DegreePlan;
import com.dpa.model.GRE;
import com.dpa.model.InterestArea;

public interface DegreePlanDao {

	List<Course> getCoreCourses();

	List<String> getOptionalCourses();

	int submitDegreePlan(DegreePlan degreePlan, String userName);

	DegreePlan getDegreePlan(String sName, String userName);

	GRE getGREScores(String sName);

	List<Courses> getCourses(String sName);

	int submitDPToAdminSpecialist(String userName, String sName, String sign);

	int dPProfessorReject(String userName, String studentName, String comments);

	String getDPStatus(String userName, String majorProfessor);

	String getComments(String userName, String majorProfessor);

	DegreePlan getDegreePlanData(String userName);

	int updateDegreePlan(DegreePlan degreePlan, String userName);

	List<DegreePlan> getDegreePlans();

	DegreePlan getReceivedDegreePlan(String sName, String sId);

	int submitDPToAssociateChair(int studentId, String sName);

	List<DegreePlan> receivedDegreePlansLevel2(String userName);

	int submitDPToASL2(String userName, String sName, String sign);

	int submitDPToChair(int studentId, String sName);

	List<DegreePlan> receivedDegreePlansLevel3(String userName);

	int submitDPToASL3(String userName, String sName, String sign);

	int sendApprovaltoStudent(int studentId, String sName);

	String getDPI();

	List<InterestArea> getInterestAreas();

	int updateDPIInfo(String dpi);

	int updateDPICC(CoreUpdate coreUpdate);

	int addOpCourse(String oPName);

	int deleteOpCourse(String oPName);


}
