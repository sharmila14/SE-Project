package com.dpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dao.AccountDetailsDao;
import com.dpa.model.Register;

@Service
public class AccountInformationServiceImpl implements AccountInformationService{
	@Autowired
	AccountDetailsDao accountDetailsDao;
	@Override
	public Register getAccountDetails(String uName) {
		// TODO Auto-generated method stub
		Register register = accountDetailsDao.getAccountDetails(uName);
		return register;
	}
	@Override
	public int updateAccountDetails(Register register) {
		int result = accountDetailsDao.updateAccountDetails(register);
		return result;
	}

}
