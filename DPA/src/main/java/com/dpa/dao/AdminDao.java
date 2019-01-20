package com.dpa.dao;

public interface AdminDao {

	int approveUser(String uName);

	int rejectUser(String uName);

}
