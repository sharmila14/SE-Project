package com.dpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminDao adminDao;
	
	@Override
	public int ApproveUser(String uName) {
		int result = adminDao.approveUser(uName);
		return result;
	}

	@Override
	public int rejectUser(String uName) {
		int result = adminDao.rejectUser(uName);
		return result;
	}

}
