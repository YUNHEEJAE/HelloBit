package org.kb141.domain;

import java.util.Date;

//SY
public class NoticeVO {
	private Integer nno;
	private String nwriter;
	private String ntitle;
	private String ncontent;
	private Date nregdate;
	private Date nupdatedate;

	public Integer getNno() {
		return nno;
	}

	public void setNno(Integer nno) {
		this.nno = nno;
	}

	public String getNwriter() {
		return nwriter;
	}

	public void setNwriter(String nwriter) {
		this.nwriter = nwriter;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public Date getNregdate() {
		return nregdate;
	}

	public void setNregdate(Date nregdate) {
		this.nregdate = nregdate;
	}

	public Date getNupdatedate() {
		return nupdatedate;
	}

	public void setNupdatedate(Date nupdatedate) {
		this.nupdatedate = nupdatedate;
	}

	@Override
	public String toString() {
		return "NoticeVO [nno=" + nno + ", nwriter=" + nwriter + ", ntitle=" + ntitle + ", ncontent=" + ncontent
				+ ", nregdate=" + nregdate + ", nupdatedate=" + nupdatedate + "]";
	}

}
