package com.dpa.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

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

import com.dpa.model.DegreePlan;
import com.dpa.model.Register;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ AccountDetailsDaoImpl.class, JdbcTemplate.class })
public class AccountDetailsDaoImplTest {
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

	@Test
	public void testGetAccountDetails() {
		Register mockRegister =new Register();
		
		when(mockJDBCTemplate.queryForObject(Matchers.anyString(), Matchers.any(BeanPropertyRowMapper.class)))
		.thenReturn( mockRegister);
		AccountDetailsDaoImpl mockObj= new AccountDetailsDaoImpl();
		Register actualRegister =mockObj.getAccountDetails( "userName");
		Assert.assertEquals(mockRegister, actualRegister);
	}

	@Test
	public void testUpdateAccountDetails() {
		int mockval=1;
		when(mockJDBCTemplate.update(Matchers.anyString(),objCap.capture()))
		.thenReturn(mockval);
		AccountDetailsDaoImpl mockObj= new AccountDetailsDaoImpl();
		Register register = new Register();
		int actualresult= mockObj.updateAccountDetails(register);
		Assert.assertEquals(actualresult, mockval);
	}

}
