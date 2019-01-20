package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.dpa.model.Course;

public class OptionalCourseRowMapper implements RowMapper<String> {

	@Override
	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		OptionalCourseExtractor optionalCourseExtractor = new OptionalCourseExtractor();
		return optionalCourseExtractor.extractData(rs);
	}

}
