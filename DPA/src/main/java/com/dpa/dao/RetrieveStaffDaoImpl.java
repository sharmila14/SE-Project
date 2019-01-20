package com.dpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dpa.jdbc.ProfessorRowMapper;
import com.dpa.model.Register;

//This service class retrieves professor list to display when requested by student
@Service
public class RetrieveStaffDaoImpl implements RetrieveStaffDao{
	@Autowired 
	DataSource dataSource;
	
	public List<Register> getStaffDirectory() {
		// TODO Auto-generated method stub
		List<Register> professorList = new ArrayList<Register>();
		String professor = "professor";
		String chair = "chair";
		String associatechair = "associatechair";
		String sql = "select name, email from register where role='" + professor + "' or role= '" + chair + "' or role= '" + associatechair +"'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		professorList = jdbctem.query(sql, new ProfessorRowMapper());
		return professorList;
	}

}
