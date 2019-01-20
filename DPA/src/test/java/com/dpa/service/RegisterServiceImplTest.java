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

import com.dpa.dao.RegisterDao;
import com.dpa.model.Register;

public class RegisterServiceImplTest {
	@Mock
	private RegisterDao registerDao;
	
	@InjectMocks
	private RegisterServiceImpl registerServiceImpl;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testInsertUser() {
		Register register = new Register();
		when(registerDao.insertUserDetails(register)).thenReturn(1);
		int result = registerServiceImpl.insertUser(register, anyString());
		assertEquals(1, result);
	}

}
