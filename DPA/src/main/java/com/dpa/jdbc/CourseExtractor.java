package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dpa.model.Course;

//sets the values from result set to the model object
public class CourseExtractor {
	public Course extractData(ResultSet rs) throws SQLException{
		// TODO Auto-generated method stub
		Course course = new Course();
		course.setCourseName(rs.getString(1));
		course.setGroupId(rs.getString(2));
		course.setMajor(rs.getString(3));
		return course;
	}

}
