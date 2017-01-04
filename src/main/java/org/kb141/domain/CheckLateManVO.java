package org.kb141.domain;

public class CheckLateManVO {

	private String sname;
	private Integer delaycnt;
	
	public String getSid() {
		return sname;
	}
	public void setSid(String sid) {
		this.sname = sid;
	}
	public Integer getDelaycnt() {
		return delaycnt;
	}
	public void setDelaycnt(Integer delaycnt) {
		this.delaycnt = delaycnt;
	}
	
	@Override
	public String toString() {
		return "CheckLateManVO [sname=" + sname + ", delaycnt=" + delaycnt + "]";
	}
	
}
