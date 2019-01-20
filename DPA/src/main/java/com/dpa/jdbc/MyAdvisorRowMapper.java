package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.dpa.model.Request;

public class MyAdvisorRowMapper implements RowMapper<Request>{

	public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdvisorExtractor advisorExtractor = new AdvisorExtractor();
		return advisorExtractor.extractData(rs);
	}

}
