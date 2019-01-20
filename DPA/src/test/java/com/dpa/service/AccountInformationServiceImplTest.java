package com.dpa.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dpa.dao.AccountDetailsDao;
import com.dpa.dao.AdminDao;
import com.dpa.model.Register;

public class AccountInformationServiceImplTest {
	@Mock
	private AccountDetailsDao accountDetailsDao;
	
	@InjectMocks
	private AccountInformationServiceImpl accountInformationServiceImpl;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAccountDetails() {
		Register mock = new Register();
		when(accountDetailsDao.getAccountDetails(anyString())).thenReturn(mock);
		Register result = accountInformationServiceImpl.getAccountDetails(anyString());
		assertEquals(mock, result);
	}

	@Test
	public void testUpdateAccountDetails() {
		Register register = new Register();
		when(accountDetailsDao.updateAccountDetails(register)).thenReturn(1);
		int result = accountInformationServiceImpl.updateAccountDetails(register);
		assertEquals(1, result);
	}

}
