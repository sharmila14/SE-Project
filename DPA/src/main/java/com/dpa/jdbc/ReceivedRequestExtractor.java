package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dpa.model.Request;

public class ReceivedRequestExtractor {

	public Request extractData(ResultSet rs) {
		// TODO Auto-generated method stub
		Request request = new Request();
		try {
			request.setUserName(rs.getString(1));
			request.setProfessorName(rs.getString(2));
			request.setProfessorEmail(rs.getString(3));
			request.setDepartment(rs.getString(4));
			request.setAdmissionSemester(rs.getString(5));
			request.setAdmissionYear(rs.getInt(6));
			request.setMessage(rs.getString(7));
			request.setRequestStatus(rs.getString(8));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return request;
	}

}
