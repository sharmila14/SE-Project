package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dpa.model.DegreePlan;

public class DegreePlanExtractor {

	public DegreePlan extractData(ResultSet rs) throws SQLException {
		DegreePlan degreePlan = new DegreePlan();
		degreePlan.setName(rs.getString(1));
		degreePlan.setStudentId(rs.getInt(2));
		degreePlan.setLocalAddress(rs.getString(3));
		degreePlan.setEmail(rs.getString(4));
		degreePlan.setDegree(rs.getString(5));
		degreePlan.setMajor(rs.getString(6));
		degreePlan.setMinor(rs.getString(7));
		degreePlan.setInterestArea(rs.getString(8));
		degreePlan.setMajorProfessor(rs.getString(9));
		degreePlan.setCoMajorProfessor(rs.getString(10));
		degreePlan.setTotalCreditHours(rs.getInt(11));
		return degreePlan;
	}
}
