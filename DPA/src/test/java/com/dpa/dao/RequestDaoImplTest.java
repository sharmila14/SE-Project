package com.dpa.dao;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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

import com.dpa.jdbc.ReceivedRequestRowMapper;
import com.dpa.jdbc.RequestRowMapper;
import com.dpa.model.Request;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ RequestDaoImpl.class, JdbcTemplate.class })
public class RequestDaoImplTest {

	private JdbcTemplate mockJDBCTemplate;
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
	public void testSendAdvisorRequest() {
		int mockresult=1;
		when(mockJDBCTemplate.update(Matchers.anyString(),objCap.capture() ))
		.thenReturn(mockresult);
		Request request=new Request();	
		RequestDaoImpl mockobj=new RequestDaoImpl();
		int actualresult=mockobj.sendAdvisorRequest(request);
		Assert.assertEquals(actualresult, mockresult);

	}
	
	
	@Test
	public void testGetSentRequests() {
		
	List mockSentRequestList = new ArrayList<Request>();
	mockSentRequestList.add(new Request());
		when(mockJDBCTemplate.query(Matchers.anyString(), Matchers.any(ReceivedRequestRowMapper.class)))
		.thenReturn(mockSentRequestList);
		RequestDaoImpl mockobj=new RequestDaoImpl();

		List<Request> actualSentRequestList = mockobj.getSentRequests("userName");
		Assert.assertEquals(mockSentRequestList, actualSentRequestList);
		
	}
	
	@Test
	public void testGetacceptedRequests() {
		
	List mockRequestList = new ArrayList<Request>();
	mockRequestList.add(new Request());
		when(mockJDBCTemplate.query(Matchers.anyString(), Matchers.any(RequestRowMapper.class)))
		.thenReturn(mockRequestList);
		RequestDaoImpl mockobj=new RequestDaoImpl();

		List<Request> actualRequestList = mockobj.getacceptedRequests("userName");
		Assert.assertEquals(mockRequestList, actualRequestList);
		
	}
	
}