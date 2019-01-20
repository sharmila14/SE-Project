package com.dpa.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dao.RequestDao;
import com.dpa.dao.RetrieveUsersDao;
import com.dpa.model.Register;
import com.dpa.model.Request;

@Service
public class RetrieveUsersServiceImpl implements RetrieveUsersService{
	@Autowired
	RetrieveUsersDao retrieveStudentsDao;
	@Autowired
	RetrieveUsersDao retrieveUsersDao;
	public List<Request> getMyStudents(String userName) {
		// TODO Auto-generated method stub
		List<Request> myStudents = retrieveStudentsDao.getMyStudents(userName);
		Iterator myStudent = myStudents.iterator();
		while(myStudent.hasNext()) {
			Request temp = (Request) myStudent.next();
			try {
			if((temp.getDegreePlanStatus()).equals("yes")) {
				temp.setDegreePlanStatus("View Degree Plan");
			}else {
				temp.setDegreePlanStatus("Not Yet Submitted");
			}
			}catch(Exception e) {
				temp.setDegreePlanStatus("Not Yet Submitted");
			}
		}
		return myStudents;
	}
	public List<Request> getMyAdvisors(String userName) {
		// TODO Auto-generated method stub
		List<Request> myAdvisors = retrieveStudentsDao.getMyAdvisors(userName);
		return myAdvisors;
	}
	public List<Register> getStudentList() {
		// TODO Auto-generated method stub
		List<Register> students = retrieveStudentsDao.getStudentList();
		return students;
	}
	@Override
	public List<Register> getNeedApprovalList() {
		List<Register> needApprovalList = retrieveUsersDao.getToApprovalList();
		return needApprovalList;
	}
	@Override
	public List<Register> getstaffList() {
		List<Register> staffList = retrieveUsersDao.getstaffList();
		return staffList;
	}

}
