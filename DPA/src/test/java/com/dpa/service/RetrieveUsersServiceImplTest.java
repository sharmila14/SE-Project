package com.dpa.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dpa.dao.RetrieveUsersDao;
import com.dpa.model.Register;
import com.dpa.model.Request;

public class RetrieveUsersServiceImplTest {
	@Mock
	private RetrieveUsersDao retrieveUsersDao;
	
	@InjectMocks
	private RetrieveUsersServiceImpl retrieveUsersServiceImpl;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetMyStudents() {
		List<Request> mockList = new ArrayList<Request>();
		when(retrieveUsersDao.getMyStudents(anyString())).thenReturn(mockList);
		List<Request> result = retrieveUsersServiceImpl.getMyStudents(anyString());
		assertEquals(mockList.size(), result.size());
	}

	@Test
	public void testGetMyAdvisors() {
		List<Request> mockList = new ArrayList<Request>();
		when(retrieveUsersDao.getMyAdvisors(anyString())).thenReturn(mockList);
		List<Request> result = retrieveUsersServiceImpl.getMyAdvisors(anyString());
		assertEquals(mockList, result);
	}

	@Test
	public void testGetStudentList() {
		List<Register> mockList = new ArrayList<Register>();
		when(retrieveUsersDao.getStudentList()).thenReturn(mockList);
		List<Register> result = retrieveUsersServiceImpl.getStudentList();
		assertEquals(mockList, result);
	}

	/*@Test
	public void testGetNeedApprovalList() {
		List<Register> mockList = new ArrayList<Register>();
		when(retrieveUsersDao.getToApprovalList()).thenReturn(mockList);
		List<Register> result = retrieveUsersServiceImpl.getNeedApprovalList();
		assertEquals(mockList, result);
	}

	@Test
	public void testGetstaffList() {
		List<Register> mockList = new ArrayList<Register>();
		when(retrieveUsersDao.getstaffList()).thenReturn(mockList);
		List<Register> result = retrieveUsersServiceImpl.getstaffList();
		assertEquals(mockList, result);
	}*/

}
