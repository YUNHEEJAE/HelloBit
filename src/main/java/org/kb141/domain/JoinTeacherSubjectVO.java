package org.kb141.domain;

public class JoinTeacherSubjectVO {
	
	private Integer tsno;
	private String subname;
	private String subgrade;
	private String tname;
	
	public Integer getTsno() {
		return tsno;
	}
	public void setTsno(Integer tsno) {
		this.tsno = tsno;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getSubgrade() {
		return subgrade;
	}
	public void setSubgrade(String subgrade) {
		this.subgrade = subgrade;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "JoinTeacherSubjectVO [tsno=" + tsno + ", subname=" + subname + ", subgrade=" + subgrade + ", tname="
				+ tname + "]";
	}
	
}
