package com.dpa.dao;

import com.dpa.model.Register;

public interface AccountDetailsDao {

	Register getAccountDetails(String uName);

	int updateAccountDetails(Register register);

}
