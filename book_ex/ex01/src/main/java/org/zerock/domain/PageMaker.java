package org.zerock.domain;

public class PageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean next;
	private boolean prev;
	
	private int displayPageNum = 10;
	
	private Criteria cri;
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}
	
	private void calcData() {
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		
		int totalCountEndPage = (int) Math.ceil(totalCount / (double)cri.getPerPageNum());
		
		if(endPage > totalCountEndPage) {
			endPage = totalCountEndPage;
		}
		
	}
}
