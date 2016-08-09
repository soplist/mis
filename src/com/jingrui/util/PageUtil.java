package com.jingrui.util;

import com.jingrui.domain.Page;

public class PageUtil {
	public static Page createPage(int everyPage,Long totalCount,int currentPage) {  
        everyPage = getEveryPage(everyPage);  
        currentPage = getCurrentPage(currentPage);  
        Long totalPage = getTotalPage(everyPage, totalCount);  
        int beginIndex = getBeginIndex(everyPage, currentPage);  
        boolean hasPrePage = getHasPrePage(currentPage);  
        boolean hasNextPage = getHasNextPage(totalPage, currentPage);  
        return new Page(everyPage, totalCount, totalPage, currentPage,  
                beginIndex, hasPrePage,  hasNextPage);  
    }  
	
	public static int getEveryPage(int everyPage) {  
        return everyPage == 0 ? 10 : everyPage;  
    }  
      
    public static int getCurrentPage(int currentPage) {  
        return currentPage == 0 ? 1 : currentPage;  
    }  
      
    public static Long getTotalPage(int everyPage,Long totalCount) {  
        Long totalPage = 0L;  
        if(totalCount % everyPage == 0) {  
            totalPage = totalCount / everyPage;  
        } else {  
            totalPage = totalCount / everyPage + 1;  
        }  
        return totalPage;  
    }  
      
    public static int getBeginIndex(int everyPage,int currentPage) {  
        return (currentPage - 1) * everyPage;  
    }  
      
    public static boolean getHasPrePage(int currentPage) {  
        return currentPage == 1 ? false : true;  
    }  
      
    public static boolean getHasNextPage(Long totalPage, int currentPage) {  
        return currentPage == totalPage || totalPage == 0 ? false : true;  
    }  
      
}  

