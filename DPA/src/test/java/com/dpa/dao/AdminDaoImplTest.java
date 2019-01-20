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

@RunWith(PowerMockRunner.class)
@PrepareForTest({ AdminDaoImpl.class, JdbcTemplate.class })
public class AdminDaoImplTest {
	
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
	public void testApproveUser() {
		int mockval=1;
		when(mockJDBCTemplate.update(Matchers.anyString(),objCap.capture()))
		.thenReturn(mockval);
		AdminDaoImpl mockObj= new AdminDaoImpl();
		int actualresult= mockObj.approveUser("userName");
		Assert.assertEquals(actualresult, mockval);
	}

	@Test
	public void testRejectUser() {
		int mockval=0;
		when(mockJDBCTemplate.update(Matchers.anyString(),objCap.capture()))
		.thenReturn(mockval);
		AdminDaoImpl mockObj= new AdminDaoImpl();
		int actualresult= mockObj.rejectUser("userName");
		Assert.assertEquals(actualresult, mockval);
	}

}
