package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.dpa.model.Course;
import com.dpa.model.DegreePlan;

public class DegreePlanRowMapper implements RowMapper<DegreePlan> {

	@Override
	public DegreePlan mapRow(ResultSet rs, int rowNum) throws SQLException {
		DegreePlanExtractor degreePlanExtractor = new DegreePlanExtractor();
		return degreePlanExtractor.extractData(rs);
	}

}
