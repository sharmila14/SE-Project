package com.dpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dao.RegisterDao;
import com.dpa.model.Register;

//calls the registerDao to insert user into the database
@Service
public class RegisterServiceImpl implements RegisterService{
	@Autowired
	RegisterDao registerDao;
	public int insertUser(Register register, String approvalStatus) {
		// TODO Auto-generated method stub
		/*String role = register.getRole();
		String approvalStatus;
		if(role.equals("professor") || role.equals("student"))
		{
			approvalStatus = "pending";
		}else {
			approvalStatus = "approved";
		}*/
		register.setApprovalStatus(approvalStatus);
		int result = registerDao.insertUserDetails(register);
		return result;
	}

}
