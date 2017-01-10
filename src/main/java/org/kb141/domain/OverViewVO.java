package org.kb141.domain;

public class OverViewVO {

	private Integer attend;
	private Integer late;
	private Integer absent;
	private Integer total;
	public Integer getAttend() {
		return attend;
	}
	public void setAttend(Integer attend) {
		this.attend = attend;
	}
	public Integer getLate() {
		return late;
	}
	public void setLate(Integer late) {
		this.late = late;
	}
	public Integer getAbsent() {
		return absent;
	}
	public void setAbsent(Integer absent) {
		this.absent = absent;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "OverViewVO [attend=" + attend + ", late=" + late + ", absent=" + absent + ", total=" + total + "]";
	}
	
}
