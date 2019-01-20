package com.dpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dpa.model.Register;

public class ProfessorRowMapper implements RowMapper<Register>{

	public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProfessorExtractor professorExtractor = new ProfessorExtractor();
		return professorExtractor.extractData(rs);
	}

}
