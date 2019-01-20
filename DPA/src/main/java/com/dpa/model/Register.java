package com.dpa.model;

public class Register {
	
	private String name;
	private String email;
	private String role;
	private String userName;
	private String password;
	private String approvalStatus;
	
	@Override
	public String toString() {
		return "Register [name=" + name + ", email=" + email + ", role=" + role + ", userName=" + userName
				+ ", password=" + password + ", approvalStatus=" + approvalStatus + "]";
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	}
