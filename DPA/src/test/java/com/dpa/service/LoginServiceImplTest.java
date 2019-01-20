package com.dpa.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.dpa.dao.LoginDao;
import com.dpa.model.Login;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {
	private List<Login> mockLoginList;
	@Mock
	private LoginDao logindao;
	
	@InjectMocks
	private LoginServiceImpl loginService;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testLoginServiceImpl() {
		mockLoginList = new ArrayList<Login>();
		mockLoginList.add(new Login());
		when(logindao.validateUser(anyString(), anyString(), anyString())).thenReturn(mockLoginList);
		List<Login> result = new ArrayList<Login>();
		result = loginService.checkCredentials("sharanya", "d232704062b0fea5c8d5b869cddef2a5", "student");
		assertEquals(1, result.size());
	}

}

