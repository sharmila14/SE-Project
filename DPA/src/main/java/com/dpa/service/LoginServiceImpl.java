package com.dpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dao.LoginDao;
import com.dpa.model.Login;

@Service
public class LoginServiceImpl implements LoginService{

@Autowired
LoginDao loginDao;

	public List<Login> checkCredentials(String userName, String password, String role) {
		List<Login> result = new ArrayList<Login>(); 
		result = loginDao.validateUser(userName, password, role);
		return result;
	}
}
