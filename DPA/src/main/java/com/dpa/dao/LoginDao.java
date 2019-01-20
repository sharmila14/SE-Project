package com.dpa.dao;

import java.util.List;

import com.dpa.model.Login;

public interface LoginDao {

	List<Login> validateUser(String userName, String password, String role);

}
