package org.kb141.domain;

//SY
public class TakeProgramVO {
	private String sid;
	private Integer pno;

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

	@Override
	public String toString() {
		return "TakeProgram [sid=" + sid + ", pno=" + pno + "]";
	}

}
