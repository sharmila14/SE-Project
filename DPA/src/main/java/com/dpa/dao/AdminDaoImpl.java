package com.dpa.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class AdminDaoImpl implements AdminDao{

	@Autowired 
	DataSource dataSource;
	
	@Override
	public int approveUser(String uName) {
		String approvalStatus = "approved";
		String sql =  "update register set approvalStatus=? where userName = ?";
		String sql1 =  "update login set approvalStatus=? where userName = ?";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		jdbcTemp.update(sql1, new Object[] {approvalStatus, uName});
		int result = jdbcTemp.update(sql, new Object[] {approvalStatus, uName});
		return result;
	}

	@Override
	public int rejectUser(String uName) {
		String sql = "delete from register where userName='" + uName + "'";  
		String sql1 = "delete from login where userName='" + uName + "'";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		jdbcTemplate.update(sql);
		jdbcTemplate.update(sql1);
		return 0;
	}
	
}
