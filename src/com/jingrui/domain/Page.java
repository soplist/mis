package com.jingrui.domain;

public class Page implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6397804430158286148L;
	private int everyPage;
    private Long totalCount;
    private Long totalPage;
    private int currentPage;
    private int beginIndex;
    private boolean hasPrePage;
    private boolean hasNextPage;
    
    public Page(){}
    
    public Page(int everyPage, Long totalCount, Long totalPage, int currentPage,  
            int beginIndex, boolean hasPrePage, boolean hasNextPage) {  
        this.everyPage = everyPage;  
        this.totalCount = totalCount;  
        this.totalPage = totalPage;  
        this.currentPage = currentPage;  
        this.beginIndex = beginIndex;  
        this.hasPrePage = hasPrePage;  
        this.hasNextPage = hasNextPage;  
    }
    
    public int getEveryPage() {  
        return everyPage;  
    }  
  
    public void setEveryPage(int everyPage) {  
        this.everyPage = everyPage;  
    }  
  
    public Long getTotalCount() {  
        return totalCount;  
    }  
  
    public void setTotalCount(Long totalCount) {  
        this.totalCount = totalCount;  
    }  
  
    public Long getTotalPage() {  
        return totalPage;  
    }  
  
    public void setTotalPage(Long totalPage) {  
        this.totalPage = totalPage;  
    }  
  
    public int getCurrentPage() {  
        return currentPage;  
    }  
  
    public void setCurrentPage(int currentPage) {  
        this.currentPage = currentPage;  
    }  
  
    public int getBeginIndex() {  
        return beginIndex;  
    }  
  
    public void setBeginIndex(int beginIndex) {  
        this.beginIndex = beginIndex;  
    }  
  
    public boolean isHasPrePage() {  
        return hasPrePage;  
    }  
  
    public void setHasPrePage(boolean hasPrePage) {  
        this.hasPrePage = hasPrePage;  
    }  
  
    public boolean isHasNextPage() {  
        return hasNextPage;  
    }  
  
    public void setHasNextPage(boolean hasNextPage) {  
        this.hasNextPage = hasNextPage;  
    }  
    
}
