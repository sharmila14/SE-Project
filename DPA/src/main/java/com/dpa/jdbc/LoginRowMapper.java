package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dpa.model.Login;

public class LoginRowMapper implements RowMapper<Login>{

	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoginExtractor loginExtractor = new LoginExtractor();
		return loginExtractor.extractData(rs);
	}

}
