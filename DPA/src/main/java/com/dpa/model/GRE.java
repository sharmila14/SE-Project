package com.dpa.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GRE {
	private int verbal;
	private int quantitative;
	private int analytical;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateTaken;
	@Override
	public String toString() {
		return "GRE [verbal=" + verbal + ", quantitative=" + quantitative + ", analytical=" + analytical
				+ ", dateTaken=" + dateTaken + "]";
	}
	public int getVerbal() {
		return verbal;
	}
	public GRE() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setVerbal(int verbal) {
		this.verbal = verbal;
	}
	public int getQuantitative() {
		return quantitative;
	}
	public void setQuantitative(int quantitative) {
		this.quantitative = quantitative;
	}
	public int getAnalytical() {
		return analytical;
	}
	public void setAnalytical(int analytical) {
		this.analytical = analytical;
	}
	public Date getDateTaken() {
		return dateTaken;
	}
	public void setDateTaken(Date dateTaken) {
		this.dateTaken = dateTaken;
	}

}
