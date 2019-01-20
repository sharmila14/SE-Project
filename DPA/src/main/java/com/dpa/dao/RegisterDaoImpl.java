package com.dpa.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dpa.model.Register;

@Service
public class RegisterDaoImpl implements RegisterDao {
	@Autowired 
	DataSource dataSource;

	//insert the new users into the database
	public int insertUserDetails(Register register) {
		// TODO Auto-generated method stub
		String role = register.getRole();
		/*String approvalStatus;
		if(role.equals("professor") || role.equals("student"))
		{
			approvalStatus = "pending";
		}else {
			approvalStatus = "approved";
		}*/
		if(role == "chair" || role == "associatechair")
		{
			role = "professor";
		}
		int result;
		try {
		String sql = "INSERT INTO register " + "(name, email, role, userName, password, approvalStatus) VALUES (?, ?, ?, ?, ?, ?)"; 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		result = jdbcTemplate.update(sql, new Object[] {register.getName(), register.getEmail(), register.getRole(), register.getUserName(), register.getPassword(), register.getApprovalStatus()});
		String sql1 =  "INSERT INTO login " + "(userName, password, role, approvalStatus) VALUES (?, ?, ?, ?)";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		int result1 = jdbcTemp.update(sql1, new Object[] {register.getUserName(),register.getPassword(),role, register.getApprovalStatus()});
		}catch(Exception e) {
		  result = 0;
		}
		return result;
	}

}
