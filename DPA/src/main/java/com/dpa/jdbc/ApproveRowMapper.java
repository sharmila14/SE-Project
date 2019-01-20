package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.dpa.model.Register;

public class ApproveRowMapper implements RowMapper<Register> {

	public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
		ApproveExtractor approveExtractor = new ApproveExtractor();
		return approveExtractor.extractData(rs);
	}

}
