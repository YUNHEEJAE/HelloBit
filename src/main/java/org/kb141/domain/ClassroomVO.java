package org.kb141.domain;

/*
 *  make by Lee Jong Pil
 */

public class ClassroomVO {

	private Integer classno;
	private String roomname;
	private Boolean empty;

	public Integer getClassno() {
		return classno;
	}

	public void setClassno(Integer classno) {
		this.classno = classno;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Boolean getEmpty() {
		return empty;
	}

	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}

	@Override
	public String toString() {
		return "ClassroomVO [classno=" + classno + ", roomname=" + roomname + ", empty=" + empty + "]";
	}

}
