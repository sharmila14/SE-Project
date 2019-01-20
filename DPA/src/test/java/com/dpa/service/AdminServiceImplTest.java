package com.dpa.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dpa.dao.AdminDao;

public class AdminServiceImplTest {
	@Mock
	private AdminDao adminDao;
	
	@InjectMocks
	private AdminServiceImpl adminServiceImpl;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	public void testApproveUser() {
		when(adminDao.approveUser(anyString())).thenReturn(1);
		int result = adminServiceImpl.ApproveUser(anyString());
		assertEquals(1, result);
	}

	@Test
	public void testRejectUser() {
		when(adminDao.rejectUser(anyString())).thenReturn(1);
		int result = adminServiceImpl.rejectUser(anyString());
		assertEquals(1, result);
	}

}
