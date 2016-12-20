package org.kb141.domain;

import java.util.Date;

/*
 *  make by Lee Jong Pil
 */

public class ProgramVO {

	private Integer pno;
	private String pcourse;
	private String roomname;
	private String torder;
	private Date opendate;
	private Date closedate;
	private Integer maximum;

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public String getPcourse() {
		return pcourse;
	}

	public void setPcourse(String pcourse) {
		this.pcourse = pcourse;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getTorder() {
		return torder;
	}

	public void setTorder(String torder) {
		this.torder = torder;
	}

	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	public Date getClosedate() {
		return closedate;
	}

	public void setClosedate(Date closedate) {
		this.closedate = closedate;
	}

	public Integer getMaximum() {
		return maximum;
	}

	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}

	@Override
	public String toString() {
		return "ProgramVO [pno=" + pno + ", pcourse=" + pcourse + ", roomname=" + roomname + ", torder=" + torder
				+ ", opendate=" + opendate + ", closedate=" + closedate + ", maximum=" + maximum + "]";
	}

}
