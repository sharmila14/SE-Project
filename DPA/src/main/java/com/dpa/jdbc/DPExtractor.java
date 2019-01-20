package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dpa.model.DegreePlan;

public class DPExtractor {

	public DegreePlan extractData(ResultSet rs) throws SQLException {
		DegreePlan dp = new DegreePlan();
		dp.setName(rs.getString(1));
		dp.setStudentId(rs.getInt(2));
		dp.setEmail(rs.getString(3));
		dp.setDegreePlanStatus(rs.getString(4));
		return dp;
	}

}
