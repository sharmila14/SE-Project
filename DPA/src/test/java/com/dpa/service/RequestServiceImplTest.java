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

import com.dpa.dao.LoginDao;
import com.dpa.dao.RequestDao;
import com.dpa.model.Login;

public class RequestServiceImplTest {
	@Mock
	RequestDao requestdao;

	@InjectMocks
	private RequestServiceImpl requestService;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSplitString() {
		RequestService requestService = new RequestServiceImpl();
		String details = "{'userName':['sharanya'],'professorName':['Bryant Barett'],'professorEmail':['BryantBarett@unt.edu'],'studentMajor':['CS']}";
		String[] result = requestService.splitString(details);
		assertEquals(4, result.length);
	}
	@Test
	public void testSplit() {
		RequestService requestService = new RequestServiceImpl();
		String details = "{'professorEmail':['BryantBarett@unt.edu'], 'userName':['sharanya']}";
		String[] result = requestService.split(details);
		assertEquals(2, result.length);
	}
	
	@Test
	public void testDeleteRequest() {
		when(requestdao.deleteRequest(anyString(), anyString())).thenReturn(1);
		int result = requestService.deleteRequest(anyString(), anyString());
		assertEquals(1, result);
	}
}
