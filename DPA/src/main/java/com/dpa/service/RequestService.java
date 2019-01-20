package com.dpa.service;

import java.util.List;

import com.dpa.model.Request;

public interface RequestService {
	
	int sendRequest(Request sendRequest);
	List<Request> getSentRequests(String userName);
	List<Request> getReceivedRequests(String userName);
	int acceptRequest(String sName, String sMajor, String pName,String pEmail);
	List<Request> getAcceptedRequests(String userName);
	int deleteRequest(String pEmail, String sName);
	String[] splitString(String details);
	String[] split(String details);

}
