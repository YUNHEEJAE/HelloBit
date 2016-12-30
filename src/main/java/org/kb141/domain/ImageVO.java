package org.kb141.domain;

// Seo In Hyo
public class ImageVO {
	
	private Integer ino;
	private String sid;
	private String persistedfaceid;
	public Integer getIno() {
		return ino;
	}
	public void setIno(Integer ino) {
		this.ino = ino;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getPersistedfaceid() {
		return persistedfaceid;
	}
	public void setPersistedfaceid(String persistedfaceid) {
		this.persistedfaceid = persistedfaceid;
	}
	@Override
	public String toString() {
		return "ImageVO [ino=" + ino + ", sid=" + sid + ", persistedfaceid=" + persistedfaceid + "]";
	}
	

	
	

}
