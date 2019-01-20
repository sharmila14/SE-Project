package com.dpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dpa.jdbc.LoginRowMapper;
import com.dpa.model.Login;

//Checks if the combination of username, password and role exist in the database
@Service
public class LoginDaoImpl implements LoginDao {

	@Autowired 
	DataSource dataSource;
	
	public List<Login> validateUser(String userName, String password, String role) {
		// TODO Auto-generated method stub
		List<Login> loginList = new ArrayList<Login>();  
		String sql = "select * from login where userName='" + userName + "' and password= '" + password + "' and role= '" + role +"'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		loginList = jdbctem.query(sql, new LoginRowMapper());
		return loginList;
	}

}
