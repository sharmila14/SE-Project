package com.dpa.service;

import com.dpa.model.Register;

public interface RegisterService {

	int insertUser(Register register, String approvalStatus);
	
}
