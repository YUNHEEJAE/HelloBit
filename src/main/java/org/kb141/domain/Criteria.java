package org.kb141.domain;

public class Criteria {

	private int page;
	private int perPageNum;
	
	private String sType, keyword;
	
	public Criteria(){
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0){
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100){
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	
	public int getPageStart(){
		return (this.page-1)*perPageNum;
	}
	
	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public String getKeyword() {
		return "%"+keyword+"%";
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", sType=" + sType + ", keyword=" + keyword
				+ "]";
	}

}
