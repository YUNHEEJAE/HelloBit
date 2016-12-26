package org.kb141.domain;

/*
 *  make by Lee Jong Pil
 */

public class ClassroomVO {

	private String roomname;
	private Boolean rempty;

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Boolean getRempty() {
		return rempty;
	}

	public void setRempty(Boolean rempty) {
		this.rempty = rempty;
	}

	@Override
	public String toString() {
		return "ClassroomVO [roomname=" + roomname + ", rempty=" + rempty + "]";
	}


}
