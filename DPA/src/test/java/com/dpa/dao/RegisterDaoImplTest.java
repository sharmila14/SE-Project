package com.dpa.dao;

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
import org.springframework.jdbc.core.JdbcTemplate;

import com.dpa.model.Register;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RegisterDaoImpl.class, JdbcTemplate.class })
public class RegisterDaoImplTest {
	
	private JdbcTemplate mockJDBCTemplate;

	private	int mockresult;
	@Captor
	ArgumentCaptor<Object[]> objCap;

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
	public void testValidateUpdatePositive() {
		mockresult=1;
		when(mockJDBCTemplate.update(Matchers.anyString(),objCap.capture() ))
		.thenReturn(mockresult);
		Register register=new Register();
	
	RegisterDaoImpl mockobj=new RegisterDaoImpl();
	int actualresult=mockobj.insertUserDetails(register);
	Assert.assertEquals(actualresult, mockresult);

		}

	@Test
	public void testValidateUpdateNegative() {
		mockresult=0;
		when(mockJDBCTemplate.update(Matchers.anyString(),objCap.capture()))
		.thenReturn(mockresult);
		Register register=new Register();
	RegisterDaoImpl mockobj=new RegisterDaoImpl();
	int actualresult=mockobj.insertUserDetails(register);
	Assert.assertEquals(actualresult, mockresult);
	}
}