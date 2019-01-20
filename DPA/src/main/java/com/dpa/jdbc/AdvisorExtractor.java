package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dpa.model.Request;

public class AdvisorExtractor {

	public Request extractData(ResultSet rs) throws SQLException {
		Request request = new Request();
		request.setProfessorName(rs.getString(1));
		request.setProfessorEmail(rs.getString(2));
		return request;
	}

}
