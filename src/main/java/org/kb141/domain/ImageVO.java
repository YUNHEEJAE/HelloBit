package org.kb141.domain;

// Seo In Hyo
public class ImageVO {
	
	private Integer ino;
	private String sid;
	private String filename;
	
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	@Override
	public String toString() {
		return "ImageVO [ino=" + ino + ", sid=" + sid + ", filename=" + filename + "]";
	}
	
	

}
