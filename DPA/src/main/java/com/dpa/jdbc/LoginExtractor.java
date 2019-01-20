package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.dpa.model.Login;

public class LoginExtractor {
	public Login extractData(ResultSet rs) throws SQLException{

		Login login = new Login();

		login.setUserName(rs.getString(1));
		login.setPassword(rs.getString(2));
		login.setRole(rs.getString(3));
		login.setApprovalStatus(rs.getString(4));
		
		return login;
	}
}
