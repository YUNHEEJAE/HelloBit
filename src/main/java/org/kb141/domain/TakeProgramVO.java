package org.kb141.domain;

import java.util.Date;

//SY, IH
public class TakeProgramVO {
	private String sid;
	private Integer pno;
	private Boolean state;
	private Date tregdate;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public Date getTregdate() {
		return tregdate;
	}
	public void setTregdate(Date tregdate) {
		this.tregdate = tregdate;
	}
	
	@Override
	public String toString() {
		return "TakeProgramVO [sid=" + sid + ", pno=" + pno + ", state=" + state + ", tregdate=" + tregdate + "]";
	}
	
	

}
