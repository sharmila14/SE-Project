package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.dpa.model.DegreePlan;
import com.dpa.model.InterestArea;

public class InterestAreaRowMapper implements RowMapper<InterestArea> {

	@Override
	public InterestArea mapRow(ResultSet rs, int rowNum) throws SQLException {
		InterestAreaExtarctor interestAreaExtarctor = new InterestAreaExtarctor();
		return interestAreaExtarctor.extractData(rs);
	}

}
