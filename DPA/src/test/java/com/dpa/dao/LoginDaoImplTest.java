package com.dpa.dao;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dpa.jdbc.LoginRowMapper;
import com.dpa.model.Login;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ LoginDaoImpl.class, JdbcTemplate.class })
public class LoginDaoImplTest {

	private List<Login> mockLoginList;
	private JdbcTemplate mockJDBCTemplate;

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
	public void testValidateUserForPopulatedList() {
		mockLoginList = new ArrayList<Login>();
		mockLoginList.add(new Login());
		when(mockJDBCTemplate.query(Matchers.anyString(), Matchers.any(LoginRowMapper.class)))
		.thenReturn(mockLoginList);
		LoginDaoImpl mockObj = new LoginDaoImpl();
		List<Login> actualLoginList = mockObj.validateUser("user", "password", "role");
		Assert.assertEquals(mockLoginList, actualLoginList);
		
	}

	@Test
	public void testValidateUserForBlankList() {
		mockLoginList = new ArrayList<Login>();
		when(mockJDBCTemplate.query(Matchers.anyString(), Matchers.any(LoginRowMapper.class)))
		.thenReturn(new ArrayList<Login>());
		LoginDaoImpl mockObj = new LoginDaoImpl();
		List<Login> actualLoginList = mockObj.validateUser("user", "password", "role");
		Assert.assertEquals(mockLoginList, actualLoginList);
	}

}