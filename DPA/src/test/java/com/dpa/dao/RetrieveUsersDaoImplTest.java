package com.dpa.dao;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dpa.jdbc.MyAdvisorRowMapper;
import com.dpa.jdbc.MyStudentRowMapper;
import com.dpa.jdbc.ProfessorRowMapper;
import com.dpa.model.Register;
import com.dpa.model.Request;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ RetrieveUsersDaoImpl.class, JdbcTemplate.class })
public class RetrieveUsersDaoImplTest {
	
	private List<Request> mockMyStudentList;
	private List<Request> mockMyAdvisorRequestList;
	private List<Register> mockStudentList;

	private JdbcTemplate mockJDBCTemplate;

	@Before
	public void setup() {
		
	    mockJDBCTemplate = Mockito.mock(JdbcTemplate.class);
		try {
			PowerMockito.whenNew(JdbcTemplate.class).withAnyArguments().thenReturn(mockJDBCTemplate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
	@Test
	public void testGetmyStudentsForPopulatedList() {
		
		mockMyStudentList = new ArrayList<Request>();
		mockMyStudentList.add(new Request());
		when(mockJDBCTemplate.query(Matchers.anyString(), Matchers.any(MyStudentRowMapper.class)))
		.thenReturn(mockMyStudentList);
		RetrieveUsersDaoImpl mockObj = new RetrieveUsersDaoImpl();		
		List<Request> actualStudentList = mockObj.getMyStudents("uName");
		Assert.assertEquals(mockMyStudentList, actualStudentList);
		
	}

	@Test
	public void testGetMyAdvisorsForPopulatedList() {

		
		mockMyAdvisorRequestList = new ArrayList<Request>();
		mockMyAdvisorRequestList.add(new Request());
		when(mockJDBCTemplate.query(Matchers.anyString(), Matchers.any(MyAdvisorRowMapper.class)))
		.thenReturn(mockMyAdvisorRequestList);
		
		RetrieveUsersDaoImpl mockObj = new RetrieveUsersDaoImpl();		
		List<Request> actualMyAdvisorRequestList = mockObj.getMyAdvisors("userName");
		Assert.assertEquals(mockMyAdvisorRequestList, actualMyAdvisorRequestList);
		
	}
	@Test
	public void testGetStudentListForPopulatedList() {

		mockStudentList = new ArrayList<Register>();
		mockStudentList.add(new Register());
		when(mockJDBCTemplate.query(Matchers.anyString(), Matchers.any(ProfessorRowMapper.class)))
		.thenReturn(mockStudentList);
		
		RetrieveUsersDaoImpl mockObj = new RetrieveUsersDaoImpl();		
		List<Register> actualStudentList = mockObj.getStudentList();
		Assert.assertEquals(mockStudentList, actualStudentList);
		
	}
	
	
	
	
	
	
	
	
	
	
}