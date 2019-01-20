package com.dpa.model;

public class InterestArea {
	private String interestArea;
	private String major;
	public InterestArea(String interestArea, String major) {
		super();
		this.interestArea = interestArea;
		this.major = major;
	}
	public String getInterestArea() {
		return interestArea;
	}
	public void setInterestArea(String interestArea) {
		this.interestArea = interestArea;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public InterestArea() {
		super();
	}

}
