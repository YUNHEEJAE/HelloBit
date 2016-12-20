package org.kb141.domain;
//copyright ju young
public class TeacherSubjectVO {
	
	private Integer tsno;
	private String tid;
	private Integer subno;
	
	public Integer getTsno() {
		return tsno;
	}
	public void setTsno(Integer tsno) {
		this.tsno = tsno;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public Integer getSubno() {
		return subno;
	}
	public void setSubno(Integer subno) {
		this.subno = subno;
	}
	@Override
	public String toString() {
		return "TeacherSubjectVO [tsno=" + tsno + ", tid=" + tid + ", subno=" + subno + "]";
	}
	
	
	
	

}
