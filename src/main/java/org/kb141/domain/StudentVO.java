package org.kb141.domain;

public class StudentVO  {

	private String sname;
	private String sid;
	private String spw;
	private String semail;
	

	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSpw() {
		return spw;
	}
	public void setSpw(String spw) {
		this.spw = spw;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	@Override
	public String toString() {
		return "StudentVO [sname=" + sname + ", sid=" + sid + ", spw=" + spw + ", semail=" + semail + "]";
	}
	
	
      
}
