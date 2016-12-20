package org.kb141.domain;

import java.util.Date;

// Seo In Hyo
public class CheckVO {

	private Integer cno;
	private String sid;
	private Integer pno;
	private Date checktime;
	private String emotion;
	
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
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
	public Date getChecktime() {
		return checktime;
	}
	public void setChecktime(Date checktime) {
		this.checktime = checktime;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	
	@Override
	public String toString() {
		return "CheckVO [cno=" + cno + ", sid=" + sid + ", pno=" + pno + ", checktime=" + checktime + ", emotion="
				+ emotion + "]";
	}
	
	
	
}
