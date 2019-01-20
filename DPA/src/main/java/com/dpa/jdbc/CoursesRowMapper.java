package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.dpa.model.Course;
import com.dpa.model.Courses;

public class CoursesRowMapper implements RowMapper<Courses> {

	@Override
	public Courses mapRow(ResultSet rs, int rowNum) throws SQLException {
		CoursesExtractor coursesExtractor = new CoursesExtractor();
		return coursesExtractor.extractData(rs);
	}

}
