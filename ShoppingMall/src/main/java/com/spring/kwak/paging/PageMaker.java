package com.spring.kwak.paging;

public class PageMaker {
	private CriteriaVO cri;
	private int totalCount; // 총 게시글 수
	private int startPage; // 화면에 보여질 첫번째 페이지 번호, 시작 페이지 번호
	private int endPage; // 화면에 보여질 마지막 페이지 번호, 끝 페이지 번호
	private boolean prev;
	private boolean next;
	private int displayPageNum = 5; // 화면에 보여질 페이지 번호의 갯수
	
	public CriteriaVO getCri() {
		return cri;
	}
	public void setCri(CriteriaVO cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	private void calcData() {
		endPage = (int) (Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		//화면 끝 페이지 번호 = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 갯수) * 화면에 보여질 페이지 번호의 갯수
		int tempEndPage = (int)(Math.ceil(totalCount / (double) cri.getPerPageNum()));
		//마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글의 갯수
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		startPage = (endPage - displayPageNum) + 1;
		if(startPage <= 0 )
			startPage = 1;
		// 화면 첫 페이지 번호
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
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
    public boolean isPrev() {
        return prev;
    }
    public void setPrev(boolean prev) {
        this.prev = prev;
    }
    public boolean isNext() {
        return next;
    }
    public void setNext(boolean next) {
        this.next = next;
    }
    public int getDisplayPageNum() {
        return displayPageNum;
    }
    public void setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
    }
}
