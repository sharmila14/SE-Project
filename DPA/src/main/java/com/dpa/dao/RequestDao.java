package com.dpa.dao;

import java.util.List;

import com.dpa.model.Request;


public interface RequestDao {

	int sendAdvisorRequest(Request sendRequest);
	List<Request> getSentRequests(String userName);
	List<Request> getReceivedRequests(String userName);
	int acceptRequest(String sName, String sMajor, String pName,String pEmail);
	List<Request> getacceptedRequests(String userName);
	int deleteRequest(String pEmail, String sName);
	

}
