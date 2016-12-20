package org.kb141.domain;
//SY

public class CurriculumVO {

	private Integer uno;
	private Integer pno;
	private Integer tsno;

	public Integer getUno() {
		return uno;
	}

	public void setUno(Integer uno) {
		this.uno = uno;
	}

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public Integer getTsno() {
		return tsno;
	}

	public void setTsno(Integer tsno) {
		this.tsno = tsno;
	}

	@Override
	public String toString() {
		return "Curriculum [uno=" + uno + ", pno=" + pno + ", tsno=" + tsno + "]";
	}

}
