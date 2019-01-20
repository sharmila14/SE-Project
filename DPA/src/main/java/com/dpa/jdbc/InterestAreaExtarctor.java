package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dpa.model.InterestArea;

public class InterestAreaExtarctor {

	public InterestArea extractData(ResultSet rs) throws SQLException {
		InterestArea interestArea = new InterestArea();
		interestArea.setInterestArea(rs.getString(1));
		interestArea.setMajor(rs.getString(2));
		return interestArea;
	}

}
