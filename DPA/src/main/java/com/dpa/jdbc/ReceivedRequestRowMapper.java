package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.dpa.model.Request;

public class ReceivedRequestRowMapper implements RowMapper<Request> {

	public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ReceivedRequestExtractor receivedRequestExtractor = new ReceivedRequestExtractor();
		return receivedRequestExtractor.extractData(rs);
	}

}
