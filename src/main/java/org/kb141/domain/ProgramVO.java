package org.kb141.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	private String persongroupid;
	private String category;
	private String pcontent;

	public String getPersongroupid() {
		return persongroupid;
	}

	public void setPersongroupid(String persongroupid) {
		this.persongroupid = persongroupid;
	}

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

	public String getOpendate() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 String month = opendate.toString();
		
		return month;
	}
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setOpendate(String opendate) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date tempDate = format.parse(opendate);
		this.opendate = tempDate;
	}

	public Date getClosedate() {
		return closedate;
	}

	public void setClosedate(String closedate) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date tempDate = format.parse(closedate);
		this.closedate = tempDate;
	}

	public Integer getMaximum() {
		return maximum;
	}

	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}
	
	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}


	@Override
	public String toString() {
		return "ProgramVO [pno=" + pno + ", pcourse=" + pcourse + ", roomname=" + roomname + ", torder=" + torder
				+ ", opendate=" + opendate + ", closedate=" + closedate + ", maximum=" + maximum + ", persongroupid="
				+ persongroupid + ", category=" + category + ", pcontent=" + pcontent + "]";
	}





}
