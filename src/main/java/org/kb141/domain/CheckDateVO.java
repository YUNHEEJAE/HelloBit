package org.kb141.domain;

public class CheckDateVO {

	private Integer attend;
	private Integer late;
	private Integer absent;

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

	@Override
	public String toString() {
		return "CheckDateVO [attend=" + attend + ", late=" + late + ", absent=" + absent + "]";
	}

}
