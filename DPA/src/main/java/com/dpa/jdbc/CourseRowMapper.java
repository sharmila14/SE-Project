package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.dpa.model.Course;
import com.dpa.model.Register;

//extracts the rows from the result set
public class CourseRowMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		CourseExtractor courseExtractor = new CourseExtractor();
		return courseExtractor.extractData(rs);
	}

}
