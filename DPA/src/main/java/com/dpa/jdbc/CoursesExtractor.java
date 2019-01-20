package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dpa.model.Courses;

public class CoursesExtractor {

	public Courses extractData(ResultSet rs) throws SQLException {
		Courses courses = new Courses();
		courses.setCourseCatergory(rs.getString(2));
		courses.setCourse(rs.getString(3));
		courses.setSemesterTaken(rs.getString(4));
		courses.setcHrs(rs.getInt(5));
		courses.setGrade(rs.getString(6));
		return courses;
	}

}
