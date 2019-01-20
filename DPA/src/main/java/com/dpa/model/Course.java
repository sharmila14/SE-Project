package com.dpa.model;

public class Course {
	private String courseName;
	private String groupId;
	private String major;
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", groupId=" + groupId + ", major=" + major + "]";
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	

}
