package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.dpa.model.Register;

public class ProfessorExtractor {

	public Register extractData(ResultSet rs) throws SQLException{
		// TODO Auto-generated method stub
		Register register = new Register();
		register.setName(rs.getString(1));
		register.setEmail(rs.getString(2));
		return register;
	}

}
