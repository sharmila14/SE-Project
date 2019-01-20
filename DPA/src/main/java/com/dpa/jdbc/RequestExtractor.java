package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dpa.model.Register;
import com.dpa.model.Request;

public class RequestExtractor {

	public Request extractData(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Request request = new Request();
		request.setProfessorName(rs.getString(1));
		request.setRequestStatus(rs.getString(2));
		return request;
	}

}
