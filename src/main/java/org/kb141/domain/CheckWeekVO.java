package org.kb141.domain;

public class CheckWeekVO {

	private Integer mon, tue, wed, thu, fri;

	public Integer getMon() {
		return mon;
	}

	public void setMon(Integer mon) {
		this.mon = mon;
	}

	public Integer getTue() {
		return tue;
	}

	public void setTue(Integer tue) {
		this.tue = tue;
	}

	public Integer getWed() {
		return wed;
	}

	public void setWed(Integer wed) {
		this.wed = wed;
	}

	public Integer getThu() {
		return thu;
	}

	public void setThu(Integer thu) {
		this.thu = thu;
	}

	public Integer getFri() {
		return fri;
	}

	public void setFri(Integer fri) {
		this.fri = fri;
	}

	@Override
	public String toString() {
		return "WeekDataVO [mon=" + mon + ", tue=" + tue + ", wed=" + wed + ", thu=" + thu + ", fri=" + fri + "]";
	}

}
