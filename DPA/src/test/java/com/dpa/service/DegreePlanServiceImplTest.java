package com.dpa.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dpa.dao.DegreePlanDao;
import com.dpa.model.Course;
import com.dpa.model.Courses;
import com.dpa.model.DegreePlan;
import com.dpa.model.GRE;
import com.dpa.model.InterestArea;
import com.dpa.model.Login;

public class DegreePlanServiceImplTest {
	private List<Courses> mockCourseList;
	
	@Mock
	private DegreePlanDao degreePlanDao;
	
	@InjectMocks
	private DegreePlanServiceImpl degreePlanService;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testGetGroupACourses() {
		Course c1 = new Course();c1.setCourseName("CSCE 5500");c1.setGroupId("A");c1.setMajor("CS");
		Course c2 = new Course();c2.setCourseName("CSCE 5400");c2.setGroupId("B");c2.setMajor("CE");
		Course c3 = new Course();c3.setCourseName("CSCE 5600");c3.setGroupId("A");c3.setMajor("CE");
		Course c4 = new Course();c4.setCourseName("CSCE 5200");c4.setGroupId("A");c4.setMajor("CE");
		List<Course> mockList = new ArrayList<Course>();
		mockList.add(c1);mockList.add(c2);mockList.add(c3);mockList.add(c4);
		when(degreePlanDao.getCoreCourses()).thenReturn(mockList);
		List<Course> result = degreePlanService.getGroupACourses("CE");
		assertEquals(2, result.size());
	}

	@Test
	public void testGetGroupBCourses() {
		Course c1 = new Course();c1.setCourseName("CSCE 5500");c1.setGroupId("B");c1.setMajor("CS");
		Course c2 = new Course();c2.setCourseName("CSCE 5400");c2.setGroupId("B");c2.setMajor("CS");
		Course c3 = new Course();c3.setCourseName("CSCE 5600");c3.setGroupId("B");c3.setMajor("CS");
		Course c4 = new Course();c4.setCourseName("CSCE 5200");c4.setGroupId("D");c4.setMajor("CE");
		List<Course> mockList = new ArrayList<Course>();
		mockList.add(c1);mockList.add(c2);mockList.add(c3);mockList.add(c4);
		when(degreePlanDao.getCoreCourses()).thenReturn(mockList);
		List<Course> result = degreePlanService.getGroupBCourses("CS");
		assertNotEquals(3, result.size());
	}

	@Test
	public void testGetGroupCCourses() {
		Course c1 = new Course();c1.setCourseName("CSCE 5500");c1.setGroupId("A");c1.setMajor("CS");
		Course c2 = new Course();c2.setCourseName("CSCE 5400");c2.setGroupId("B");c2.setMajor("CE");
		Course c3 = new Course();c3.setCourseName("CSCE 5600");c3.setGroupId("C");c3.setMajor("CS");
		Course c4 = new Course();c4.setCourseName("CSCE 5200");c4.setGroupId("C");c4.setMajor("CE");
		List<Course> mockList = new ArrayList<Course>();
		mockList.add(c1);mockList.add(c2);mockList.add(c3);mockList.add(c4);
		when(degreePlanDao.getCoreCourses()).thenReturn(mockList);
		List<Course> result = degreePlanService.getGroupCCourses("CE");
		assertEquals(1, result.size());
	}

	@Test
	public void testGetGroupDCourses() {
		Course c1 = new Course();c1.setCourseName("CSCE 5500");c1.setGroupId("A");c1.setMajor("CS");
		Course c2 = new Course();c2.setCourseName("CSCE 5400");c2.setGroupId("B");c2.setMajor("CE");
		Course c3 = new Course();c3.setCourseName("CSCE 5600");c3.setGroupId("D");c3.setMajor("CS");
		Course c4 = new Course();c4.setCourseName("CSCE 5200");c4.setGroupId("D");c4.setMajor("CE");
		List<Course> mockList = new ArrayList<Course>();
		mockList.add(c1);mockList.add(c2);mockList.add(c3);mockList.add(c4);
		when(degreePlanDao.getCoreCourses()).thenReturn(mockList);
		List<Course> result = degreePlanService.getGroupDCourses("CS");
		assertEquals(1, result.size());
	}

	@Test
	public void testGetOptionalCourses() {
		List<String> mockCourseList = Arrays.asList("CSCE 5350 SE", "CSCE5450 CS");
		when(degreePlanDao.getOptionalCourses()).thenReturn(mockCourseList);
		List<String> result = new ArrayList<String>();
		result = degreePlanService.getOptionalCourses();
		assertEquals(2, result.size());
	}

	@Test
	public void testSubmitDegreePlan() {
		when(degreePlanDao.submitDegreePlan(any(), anyString())).thenReturn(1);
		int result = degreePlanService.submitDegreePlan(any(), anyString());
		assertEquals(1, result);
	}
	
											//Test cases phase-II
	@Test
	public void testViewDegreePlan() {
		DegreePlan degreePlan = new DegreePlan();
		when(degreePlanDao.getDegreePlan(anyString(), anyString())).thenReturn(degreePlan);
		DegreePlan result = degreePlanService.viewDegreePlan(anyString(), anyString());
		assertEquals(degreePlan, result);
	}
	
	@Test
	public void testGetGREScores() {
		GRE gre = new GRE();
		when(degreePlanDao.getGREScores(anyString())).thenReturn(gre);
		GRE result = degreePlanService.getGREScores(anyString());
		assertEquals(gre, result);
	}
	
	@Test
	public void testGetCourses() {
		List<Courses> mockCourseList = new ArrayList<Courses>();
		when(degreePlanDao.getCourses(anyString())).thenReturn(mockCourseList);
		List<Courses> result = new ArrayList<Courses>();
		result = degreePlanService.getCourses("sharanya");
		assertEquals(mockCourseList.size(), result.size());
	}
	
	@Test
	public void testSubmitToAdminSpecialist() {
		when(degreePlanDao.submitDPToAdminSpecialist(anyString(), anyString(), anyString())).thenReturn(1);
		int result = degreePlanService.submitToAdminSpecialist(anyString(), anyString(), anyString());
		assertEquals(1, result);
	}

	@Test
	public void testDPProfessorreject() {
		when(degreePlanDao.dPProfessorReject(anyString(), anyString(), anyString())).thenReturn(1);
		int result = degreePlanService.dPProfessorreject(anyString(), anyString(), anyString());
		assertEquals(1, result);
	}
	
	@Test
	public void testGetDPStatus() {
		String Status = "With Professor";
		when(degreePlanDao.getDPStatus(anyString(), anyString())).thenReturn(Status);
		String actualResult = degreePlanService.getDPStatus(anyString(), anyString());
		assertEquals(Status, actualResult);
	}
	
	@Test
	public void testGetComments() {
		when(degreePlanDao.getComments(anyString(), anyString())).thenReturn("Please change core course 3");
		String result = degreePlanService.getComments(anyString(), anyString());
		assertEquals("Please change core course 3", result);
	}
	
	@Test
	public void testGetDegreePlan() {
		DegreePlan degreePlan = new DegreePlan();
		when(degreePlanDao.getDegreePlanData(anyString())).thenReturn(degreePlan);
		DegreePlan result = degreePlanService.getDegreePlan(anyString());
		assertEquals(degreePlan, result);
	}
	
	@Test
	public void testUpdateDegreePlan() {
		when(degreePlanDao.updateDegreePlan(any(), anyString())).thenReturn(1);
		int result = degreePlanService.updateDegreePlan(any(), anyString());
		assertEquals(1, result);
	}
	
	@Test
	public void testGetDegreePlans() {
		List<DegreePlan> degreePlans = new ArrayList<DegreePlan>();
		when(degreePlanDao.getDegreePlans()).thenReturn(degreePlans);
		List<DegreePlan> result = degreePlanService.getDegreePlans();
		assertEquals(degreePlans, result);
	}
	
	@Test
	public void testGetReceivedDP() {
		DegreePlan dp = new DegreePlan();
		when(degreePlanDao.getReceivedDegreePlan(anyString(), anyString())).thenReturn(dp);
		DegreePlan result = degreePlanService.getReceivedDP(anyString(), anyString());
		assertEquals(dp, result);
	}
	
	@Test
	public void testSubmitToAssociateChair() {
		when(degreePlanDao.submitDPToAssociateChair(anyInt(), anyString())).thenReturn(1);
		int result = degreePlanService.submitToAssociateChair(anyInt(), anyString());
		assertEquals(1, result);
	}
	
	@Test
	public void testGetReceivedDegreePlansLevel2() {
		List<DegreePlan> mockDegreePlans = new ArrayList<DegreePlan>();
		when(degreePlanDao.receivedDegreePlansLevel2(anyString())).thenReturn(mockDegreePlans);
		List<DegreePlan> result = degreePlanService.getReceivedDegreePlansLevel2(anyString());
		assertEquals(mockDegreePlans, result);
	}
	
	@Test
	public void testSubmitToASL2() {
		when(degreePlanDao.submitDPToASL2(anyString(), anyString(), anyString())).thenReturn(1);
		int result = degreePlanService.submitToASL2(anyString(), anyString(), anyString());
		assertEquals(1, result);
	}
	
	@Test
	public void testSubmitToChair() {
		when(degreePlanDao.submitDPToChair(anyInt(), anyString())).thenReturn(1);
		int result = degreePlanService.submitToChair(anyInt(), anyString());
		assertEquals(1, result);
	}
	
	@Test
	public void testGetReceivedDegreePlansLevel3() {
		List<DegreePlan> degreePlans = new ArrayList<DegreePlan>();
		when(degreePlanDao.receivedDegreePlansLevel3(anyString())).thenReturn(degreePlans);
		List<DegreePlan> result = degreePlanService.getReceivedDegreePlansLevel3(anyString());
		assertEquals(degreePlans, result);
	}
	
	@Test
	public void testSubmitToASL3() {
		when(degreePlanDao.submitDPToASL3(anyString(), anyString(), anyString())).thenReturn(1);
		int result = degreePlanService.submitToASL3(anyString(), anyString(), anyString());
		assertEquals(1, result);
	}
	
	@Test
	public void testSendApprovaltoStudent() {
		when(degreePlanDao.sendApprovaltoStudent(anyInt(), anyString())).thenReturn(1);
		int result = degreePlanService.sendApprovaltoStudent(anyInt(), anyString());
		assertEquals(1, result);
	}
	//phase 3 tests
	
	@Test
	public void testgetDPI() {
		String real="sample text";
		when(degreePlanDao.getDPI()).thenReturn(real);
		String result = degreePlanService.getDPI();
		assertEquals(real, result);
	}
	
	@Test
	public void testgetInterestAreas() {
		List<InterestArea> mockInterestAreas = new ArrayList<InterestArea>();
		when(degreePlanDao.getInterestAreas()).thenReturn(mockInterestAreas);
		List<InterestArea> result = degreePlanService.getInterestAreas();
		assertEquals(mockInterestAreas.size(), result.size());
	}
	
}
