package org.kb141.domain;
//copyright zetsubou
public class FaculityVO {
	
	private String fname;
	private String fid;
	private String fpw;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFpw() {
		return fpw;
	}
	public void setFpw(String fpw) {
		this.fpw = fpw;
	}
	@Override
	public String toString() {
		return "FaculityVO [fname=" + fname + ", fid=" + fid + ", fpw=" + fpw + "]";
	}
	
	
	
	
	
	

}
