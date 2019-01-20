package com.dpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dpa.jdbc.ReceivedRequestRowMapper;
import com.dpa.jdbc.RequestRowMapper;
import com.dpa.model.Request;

//handles all the database operations of requests and responses
@Service
public class RequestDaoImpl implements RequestDao{
	@Autowired 
	DataSource dataSource;
//inserts request into the database
	public int sendAdvisorRequest(Request sendRequest) {
		// TODO Auto-generated method stub
		int result;
		String requestStatus = "Request Sent";
		String sql = "INSERT INTO requests " + "(userName, professorName,professorEmail, department, admissionSemester, admissionYear, message, requestStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		result = jdbcTemplate.update(sql, new Object[] {sendRequest.getUserName(), sendRequest.getProfessorName(), sendRequest.getProfessorEmail(), sendRequest.getDepartment(), sendRequest.getAdmissionSemester(), sendRequest.getAdmissionYear(),sendRequest.getMessage(), requestStatus});
		return result;
	}
//get the sent requests
	public List<Request> getSentRequests(String userName) {
		// TODO Auto-generated method stub
		List<Request> requests = new ArrayList<Request>();
		String requestStatus = "Request Sent";
		String sql = "select * from requests where userName='" + userName + "' and requestStatus='" + requestStatus + "'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		requests = jdbctem.query(sql, new ReceivedRequestRowMapper());
		return requests;
	}
//get the accepted requests	
	public List<Request> getacceptedRequests(String userName) {
		// TODO Auto-generated method stub
		List<Request> requests = new ArrayList<Request>();
		String requestStatus = "Request Accepted";
		String sql = "select professorName, requestStatus from requests where userName='" + userName + "' and requestStatus='" + requestStatus + "'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		requests = jdbctem.query(sql, new RequestRowMapper());
		return requests;
	}
//get received requests
	public List<Request> getReceivedRequests(String userName) {
		// TODO Auto-generated method stub
		List<Request> receivedRequests = new ArrayList<Request>();
		String requestStatus = "Request Sent";
		String sql = "select email from register where userName='" + userName + "'" ;
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		String email = jdbctem.queryForObject(sql, String.class);
		String sql1 = "select * from requests where professorEmail='" + email + "'and requestStatus='" + requestStatus + "'";
		JdbcTemplate jdbctem1 = new JdbcTemplate(dataSource);
		receivedRequests = jdbctem1.query(sql1, new ReceivedRequestRowMapper());
		return receivedRequests;
	}
//accept the request
	public int acceptRequest(String sName, String sMajor, String pName,String pEmail) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO majorprofessor " + "(studentName, StudentMajor, professorName, professorEmail) VALUES (?, ?, ?, ?)"; 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int result = jdbcTemplate.update(sql, new Object[] {sName, sMajor, pName, pEmail});
		String requestStatus = "Request Accepted";
		String sql1 =  "update requests set requestStatus = ? where userName = ? and professorEmail = ?";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		int result1 = jdbcTemp.update(sql1, new Object[] {requestStatus, sName, pEmail});
		return result;
	}
//delete the sent request
	public int deleteRequest(String pEmail, String sName) {
		String sql = "delete from requests where professorEmail='" + pEmail + "' and userName='" + sName + "'";  
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		jdbcTemplate.update(sql);
		return 0;
	}

}
