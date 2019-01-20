package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OptionalCourseExtractor {

	public String extractData(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		String result = rs.getString(1);
		return result;
	}

}
