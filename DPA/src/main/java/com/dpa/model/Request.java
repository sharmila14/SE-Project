package com.dpa.model;

public class Request {
	
	private String userName;
	private String professorName;
	private String professorEmail;
	private String department;
	private String admissionSemester;
	private long admissionYear;
	private String message;
	private String requestStatus;
	private String degreePlanStatus;
	
	
	public String getDegreePlanStatus() {
		return degreePlanStatus;
	}

	public void setDegreePlanStatus(String degreePlanStatus) {
		this.degreePlanStatus = degreePlanStatus;
	}

	public Request() {
	}
	
	public Request(String userName, String professorName, String professorEmail, String department,
			String admissionSemester, long admissionYear, String message, String requestStatus,
			String degreePlanStatus) {
		super();
		this.userName = userName;
		this.professorName = professorName;
		this.professorEmail = professorEmail;
		this.department = department;
		this.admissionSemester = admissionSemester;
		this.admissionYear = admissionYear;
		this.message = message;
		this.requestStatus = requestStatus;
		this.degreePlanStatus = degreePlanStatus;
	}

	@Override
	public String toString() {
		return "Request [userName=" + userName + ", professorName=" + professorName + ", professorEmail="
				+ professorEmail + ", department=" + department + ", admissionSemester=" + admissionSemester
				+ ", admissionYear=" + admissionYear + ", message=" + message + ", requestStatus=" + requestStatus
				+ ", degreePlanStatus=" + degreePlanStatus + "]";
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getProfessorEmail() {
		return professorEmail;
	}
	public void setProfessorEmail(String professorEmail) {
		this.professorEmail = professorEmail;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAdmissionSemester() {
		return admissionSemester;
	}
	public void setAdmissionSemester(String admissionSemester) {
		this.admissionSemester = admissionSemester;
	}
	public long getAdmissionYear() {
		return admissionYear;
	}
	public void setAdmissionYear(long admissionYear) {
		this.admissionYear = admissionYear;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	

}
