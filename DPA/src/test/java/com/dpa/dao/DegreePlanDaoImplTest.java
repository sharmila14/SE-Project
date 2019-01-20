package com.dpa.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dpa.jdbc.CourseRowMapper;
import com.dpa.jdbc.CoursesRowMapper;
import com.dpa.jdbc.DPRowMapper;
import com.dpa.jdbc.InterestAreaRowMapper;
import com.dpa.jdbc.OptionalCourseRowMapper;
import com.dpa.model.Course;
import com.dpa.model.Courses;
import com.dpa.model.DegreePlan;
import com.dpa.model.GRE;
import com.dpa.model.InterestArea;
import com.dpa.model.Register;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ DegreePlanDaoImpl.class, JdbcTemplate.class })
public class DegreePlanDaoImplTest {
	
	private JdbcTemplate mockJDBCTemplate;
	@Captor
	ArgumentCaptor<Object[]> objCap;
	@Before
	public void setup() {
		
	    mockJDBCTemplate = Mockito.mock(JdbcTemplate.class);
		try {
			PowerMockito.whenNew(JdbcTemplate.class).withAnyArguments().thenReturn(mockJDBCTemplate);
			//PowerMockito.whenNew(JdbcTemplate.class).

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//getCoreCourses()
	@Test
	public void testGetCoreCourses() {
		
		List<Course> mockCourselist =new ArrayList<Course>();
		mockCourselist.add(new Course());
		when(mockJDBCTemplate.query(Matchers.anyString(), Matchers.any(CourseRowMapper.class)))
		.thenReturn( mockCourselist);
		
		DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();
		List<Course> actualCourseList=mockObj.getCoreCourses();
		Assert.assertEquals(actualCourseList,mockCourselist);
		
	}
	
	@Test
	public void testGetOptionalCourses() {
		
		List <String> mockStringList=new ArrayList<String>() ;
		mockStringList.add(new String());
		when(mockJDBCTemplate.query(Matchers.anyString(), Matchers.any(OptionalCourseRowMapper.class)))
		.thenReturn( mockStringList);
		DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();
		List actualStringList=mockObj.getOptionalCourses();
		Assert.assertEquals(actualStringList,mockStringList);
		
			}
	/*@Test
	public void testSubmitDegreePlan() {
		int mockresult=1;
		when(mockJDBCTemplate.update (Matchers.anyString() , objCap.capture() )).thenReturn(mockresult);
		DegreePlan dp=new DegreePlan();
	dp.setEmail("abc");
		DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();
		int actualresult = mockObj.submitDegreePlan( dp,"userName");
				Assert.assertEquals(actualresult,mockresult);
		
	}*/
@Test
public void testGetDegreePlan() {
	
	DegreePlan mockDegreePlan =new DegreePlan();
	
	when(mockJDBCTemplate.queryForObject(Matchers.anyString(), Matchers.any(BeanPropertyRowMapper.class)))
	.thenReturn( mockDegreePlan);
	DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();
	DegreePlan actualDegreePlan =mockObj.getDegreePlan("sName", "userName");
	Assert.assertEquals(mockDegreePlan, actualDegreePlan);
	
}

//GRE getGREScores(String sName)
@Test
public void testGetGREScores() {
	
	GRE mockgre = new GRE();	
	
	when(mockJDBCTemplate.queryForObject(Matchers.anyString(), Matchers.any(BeanPropertyRowMapper.class)))
	.thenReturn(  mockgre);
	DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();
	GRE actualgre =mockObj.getGREScores("sName");
	Assert.assertEquals(mockgre, actualgre);
	
}

//List<Courses> getCourses(String sName)
@Test
public void testGetCourses() {
	List<Courses> mockCourselist =new ArrayList<Courses>();
	mockCourselist.add(new Courses());
	when(mockJDBCTemplate.query(Matchers.anyString(), Matchers.any(CoursesRowMapper.class)))
	.thenReturn( mockCourselist);
	DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();
	List<Courses> actualCourselist   = mockObj.getCourses("sName");
	Assert.assertEquals(actualCourselist, mockCourselist);

}

//int submitDPToAdminSpecialist(String userName, String sName, String sign)
@Test
public void testSubmitDPToAdminSpecialist() {
int mockval=1;
when(mockJDBCTemplate.update(Matchers.anyString(),objCap.capture()))
.thenReturn(mockval);
DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();
int actualresult= mockObj.submitDPToAdminSpecialist("userName", "sName", "sign");
Assert.assertEquals(actualresult, mockval);
		
}

//int dPProfessorReject(String userName, String studentName, String comments)
/*@Test
public void testDPProfessorReject() {
	
	int mockval=1;
	when(mockJDBCTemplate.update(Matchers.anyString(),objCap.capture())).thenReturn(mockval);
	DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();
	int actualresult= mockObj.dPProfessorReject("userName", "sName", "comments");
	Assert.assertEquals(actualresult, mockval);
}*/

//getDPStatus(String userName, String majorProfessor)
@Test
public void testGetDPStatus() {

	String Mockval="str";
	when(mockJDBCTemplate.queryForObject(Matchers.anyString(), Matchers.any(Class.class))).thenReturn(Mockval);
	DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();

	String Actualval=mockObj.getDPStatus("userName", "majorProfessor");
	Assert.assertEquals(Actualval, Mockval);

}


//getComments(String userName, String majorProfessor)
@Test
public void testGetComments() {

	String Mockval="str";
	when(mockJDBCTemplate.queryForObject(Matchers.anyString(), Matchers.any(Class.class))).thenReturn(Mockval);
	DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();

	String Actualval=mockObj.getComments("userName", "majorProfessor");
	Assert.assertEquals(Actualval, Mockval);

}

//DegreePlan getDegreePlanData(String userName)
@Test
public void testGetDegreePlanData() {
	
	
DegreePlan mockDegreePlan =new DegreePlan();
	
	when(mockJDBCTemplate.queryForObject(Matchers.anyString(), Matchers.any(BeanPropertyRowMapper.class)))
	.thenReturn( mockDegreePlan);
	DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();
	DegreePlan actualDegreePlan =mockObj.getDegreePlanData( "userName");
	Assert.assertEquals(mockDegreePlan, actualDegreePlan);
	
}

//List<DegreePlan> receivedDegreePlansLevel3(String userName) 

@Test
public void testReceivedDegreePlansLevel3() {
	
	List <DegreePlan> mockDPList=new ArrayList<DegreePlan>() ;
	mockDPList.add(new DegreePlan());
	when(mockJDBCTemplate.query(Matchers.anyString(), Matchers.any(DPRowMapper.class)))
	.thenReturn(mockDPList);
	DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();
	List <DegreePlan> actualDPList=mockObj.receivedDegreePlansLevel3("userName");
	Assert.assertEquals(actualDPList,mockDPList);
}

//phase 3 tests

	@Test
	public void testgetDPI() {
		String real="sample text";
		when(mockJDBCTemplate.queryForObject(Matchers.anyString(), Matchers.any(Class.class)))
		.thenReturn(real);
		DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();
		String result = mockObj.getDPI();
		assertEquals(real, result);
	}
	
	@Test
	public void testgetInterestAreas() {
		List <InterestArea> mockDPList=new ArrayList<InterestArea>() ;
		mockDPList.add(new InterestArea());
		when(mockJDBCTemplate.query(Matchers.anyString(), Matchers.any(InterestAreaRowMapper.class)))
		.thenReturn(mockDPList);
		DegreePlanDaoImpl mockObj= new DegreePlanDaoImpl();
		List <InterestArea> actualDPList=mockObj.getInterestAreas();
		Assert.assertEquals(actualDPList,mockDPList);
	}
}