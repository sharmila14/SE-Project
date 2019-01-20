package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dpa.model.Request;

public class StudentExtractor {

	public Request extractData(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Request request = new Request();
		request.setUserName(rs.getString(1));
		request.setDepartment(rs.getString(2));
		request.setDegreePlanStatus(rs.getString(5));
		return request;
	}

}
