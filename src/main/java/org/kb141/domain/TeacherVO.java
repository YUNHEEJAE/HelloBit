package org.kb141.domain;

//copyright ju young


public class TeacherVO {

	// copyright ju young

	private String tname;
	private String tid;
	private String tpw;

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTpw() {
		return tpw;
	}

	public void setTpw(String tpw) {
		this.tpw = tpw;
	}

	@Override
	public String toString() {
		return "TeacherVO [tname=" + tname + ", tid=" + tid + ", tpw=" + tpw + "]";
	}

}
