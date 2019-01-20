package com.dpa.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dpa.jdbc.ProfessorRowMapper;
import com.dpa.model.DegreePlan;
import com.dpa.model.Register;

@Service
public class AccountDetailsDaoImpl implements AccountDetailsDao{
	@Autowired 
	DataSource dataSource;
	@Override
	public Register getAccountDetails(String uName) {
		// TODO Auto-generated method stub
		Register register = new Register();
		String sql = "select * from register where userName= '" + uName +"'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		register = (Register) jdbctem.queryForObject(sql, new BeanPropertyRowMapper(Register.class));
		return register;
	}
	@Override
	public int updateAccountDetails(Register register) {
		// TODO Auto-generated method stub
		String uName = register.getUserName();
		String sql1 =  "update register set name=?, email = ? where userName = ?";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		int result = jdbcTemp.update(sql1, new Object[] {register.getName(), register.getEmail(), uName});
		return result;
	}

}
