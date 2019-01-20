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

import com.dpa.jdbc.ProfessorRowMapper;
import com.dpa.model.Register;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ RetrieveStaffDaoImpl.class, JdbcTemplate.class })
public class RetrieveStaffDaoImplTest {

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
	public void testGetStaffDirectory() {

	List<Register> mockProfList = new ArrayList<Register>();
	mockProfList.add(new Register());
		when(mockJDBCTemplate.query(Matchers.anyString(), Matchers.any(ProfessorRowMapper.class)))
		.thenReturn(mockProfList);
		
		RetrieveStaffDaoImpl mockrsdi = new RetrieveStaffDaoImpl();	
		List<Register> actualprofList=mockrsdi.getStaffDirectory();
		Assert.assertEquals(mockProfList, actualprofList);
		
	}
	

}