package com.dpa.service;

import com.dpa.model.Register;

public interface AccountInformationService {

	Register getAccountDetails(String uName);

	int updateAccountDetails(Register register);

}
