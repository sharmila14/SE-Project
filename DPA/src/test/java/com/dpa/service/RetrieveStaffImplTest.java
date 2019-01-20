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

import com.dpa.dao.RetrieveStaffDao;
import com.dpa.model.Register;

public class RetrieveStaffImplTest {
	@Mock
	private RetrieveStaffDao retrieveStaffDao;
	
	@InjectMocks
	private RetrieveStaffImpl retrieveStaffImpl;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testRetrieveProfessors() {
		List<Register> mockList = new ArrayList<Register>();
		when(retrieveStaffDao.getStaffDirectory()).thenReturn(mockList);
		List<Register> result = retrieveStaffImpl.retrieveProfessors();
		assertEquals(mockList, result);
	}

}
