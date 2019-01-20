package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dpa.model.Register;

public class StaffExtractor {

	public Register extractData(ResultSet rs) throws SQLException {
		Register register = new Register();
		register.setName(rs.getString(1));
		register.setEmail(rs.getString(2));
		register.setRole(rs.getString(3));
		return register;
	}

}
