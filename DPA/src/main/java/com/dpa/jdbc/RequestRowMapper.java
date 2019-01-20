package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dpa.model.Request;

public class RequestRowMapper implements RowMapper<Request> {

	public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		RequestExtractor requestExtractor = new RequestExtractor();
		return requestExtractor.extractData(rs);
	}

}
