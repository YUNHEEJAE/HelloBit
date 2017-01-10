package org.kb141.domain;

import java.util.Date;

public class StudentCheckKLogVO {
		
	private String sname;
	private Date checktime;
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getChecktime() {
		return checktime;
	}
	public void setChecktime(Date checktime) {
		this.checktime = checktime;
	}
	
	@Override
	public String toString() {
		return "StudentCheckKLogVO [sname=" + sname + ", checktime=" + checktime + "]";
	}
	
	
}
