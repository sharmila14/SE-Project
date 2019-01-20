package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.dpa.model.DegreePlan;
import com.dpa.model.Register;

public class StaffRowMapper implements RowMapper<Register> {

	@Override
	public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
		StaffExtractor staffExtractor = new StaffExtractor();
		return staffExtractor.extractData(rs);
	}

}
