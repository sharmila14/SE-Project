package com.dpa.service;

import java.util.List;

import com.dpa.model.Register;
import com.dpa.model.Request;

public interface RetrieveUsersService {

	List<Request> getMyStudents(String userName);

	List<Request> getMyAdvisors(String userName);

	List<Register> getStudentList();

	List<Register> getNeedApprovalList();

	List<Register> getstaffList();

}
