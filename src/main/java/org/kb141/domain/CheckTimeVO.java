package org.kb141.domain;

import java.util.Date;

public class CheckTimeVO {

	private String sid;
	private Integer pno;
	private Date firsttime, lasttime;
	private String states;
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
	public Date getFirsttime() {
		return firsttime;
	}
	public void setFirsttime(Date firsttime) {
		this.firsttime = firsttime;
	}
	public Date getLasttime() {
		return lasttime;
	}
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	
	@Override
	public String toString() {
		return "CheckTimeVO [sid=" + sid + ", pno=" + pno + ", firsttime=" + firsttime + ", lasttime=" + lasttime
				+ ", states=" + states + "]";
	}
	
	
}
