package com.dpa.model;

public class Courses {
	private String course;
	private String semesterTaken;
	private int cHrs;
	private String grade;
	private String courseCatergory;
	@Override
	public String toString() {
		return "Courses [course=" + course + ", semesterTaken=" + semesterTaken + ", cHrs=" + cHrs + ", grade=" + grade
				+ ", courseCatergory=" + courseCatergory + "]";
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getSemesterTaken() {
		return semesterTaken;
	}
	public void setSemesterTaken(String semesterTaken) {
		this.semesterTaken = semesterTaken;
	}
	public int getcHrs() {
		return cHrs;
	}
	public void setcHrs(int cHrs) {
		this.cHrs = cHrs;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCourseCatergory() {
		return courseCatergory;
	}
	public void setCourseCatergory(String courseCatergory) {
		this.courseCatergory = courseCatergory;
	}
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

}
