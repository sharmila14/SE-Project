package com.dpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dao.RequestDao;
import com.dpa.model.Request;

@Service
public class RequestServiceImpl implements RequestService{
	@Autowired
	RequestDao requestDao;
	
	public int sendRequest(Request sendRequest) {
		// TODO Auto-generated method stub
		int result = requestDao.sendAdvisorRequest(sendRequest);
		return result;
	}

	public List<Request> getSentRequests(String userName) {
		// TODO Auto-generated method stub
		List<Request> requests = new ArrayList<Request>();
		requests = requestDao.getSentRequests(userName);
		return requests;
	}

	public List<Request> getReceivedRequests(String userName) {
		// TODO Auto-generated method stub
		List<Request> receivedRequests = new ArrayList<Request>();
		receivedRequests = requestDao.getReceivedRequests(userName);
		return receivedRequests;
	}

	public int acceptRequest(String sName, String sMajor, String pName,String pEmail) {
		// TODO Auto-generated method stub
		int result = requestDao.acceptRequest(sName, sMajor, pName, pEmail);
		return result;
	}

	public List<Request> getAcceptedRequests(String userName) {
		List<Request> acceptedRequests = new ArrayList<Request>();
		acceptedRequests = requestDao.getacceptedRequests(userName);
		return acceptedRequests;
	}

	public int deleteRequest(String pEmail, String sName) {
		int deleteStatus = requestDao.deleteRequest(pEmail, sName);
		return deleteStatus;
	}

	@Override
	public String[] splitString(String details) {
		// TODO Auto-generated method stub
		String[] majorProfessor = details.split("\\[");
		String[] studentName = majorProfessor[1].split("\\]");
		String[] studentMajor = majorProfessor[2].split("\\]");
		String[] professorName = majorProfessor[3].split("\\]");
		String[] professorEmail = majorProfessor[4].split("\\]");
		String sName = studentName[0].replaceAll("^\"|\"$", "");
		String pName = studentMajor[0].replaceAll("^\"|\"$", "");
		String pEmail = professorName[0].replaceAll("^\"|\"$", "");
		String sMajor = professorEmail[0].replaceAll("^\"|\"$", "");
		String[] requestDetails = {sName, sMajor, pName, pEmail};
		return requestDetails;
	}

	@Override
	public String[] split(String details) {
		// TODO Auto-generated method stub
		String[] toDelete = details.split("\\[");
		String[] professorEmail = toDelete[1].split("\\]");
		String[] studentName = toDelete[2].split("\\]");
		String pEmail = professorEmail[0].replaceAll("^\"|\"$", "");
		String sName = studentName[0].replaceAll("^\"|\"$", "");
		String[] requestDetails = {pEmail, sName};
		return requestDetails;
	}

}
