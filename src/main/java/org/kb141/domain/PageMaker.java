package org.kb141.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int total, startPage, endPage;
	private Boolean prev, next;

	private int displayPageNum = 10;
	private Criteria cri;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		calcData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public Boolean getPrev() {
		return prev;
	}

	public void setPrev(Boolean prev) {
		this.prev = prev;
	}

	public Boolean getNext() {
		return next;
	}

	public void setNext(Boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	private void calcData() {
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;

		int tempEndPage = (int) (Math.ceil(total / (double) cri.getPerPageNum()));

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= total ? false : true;
	}
	
	public String makeSearch(int page){
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page).queryParam("keyword", ((Criteria)cri).getKeyword()).build();
	
		return uriComponents.toUriString();
	}

	@Override
	public String toString() {
		return "PageMaker [total=" + total + ", startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev
				+ ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}

}
