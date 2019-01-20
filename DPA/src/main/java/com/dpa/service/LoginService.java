package com.dpa.service;

import java.util.List;

import com.dpa.model.Login;

public interface LoginService {

	List<Login> checkCredentials(String userName, String password, String role);

}
