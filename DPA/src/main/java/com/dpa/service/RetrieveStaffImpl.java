package com.dpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dao.RetrieveStaffDao;
import com.dpa.model.Register;

@Service
public class RetrieveStaffImpl implements RetrieveStaff{

	@Autowired
	private RetrieveStaffDao retrieveStaffdao;
	
	public List<Register> retrieveProfessors() {
		// TODO Auto-generated method stub
		List<Register> professorList = new ArrayList<Register>();
		professorList = retrieveStaffdao.getStaffDirectory();
		return professorList;
	}

}
