package com.chenss.operateapi.request;

public class PageResponse {
    private int pageIndex;
    private int totalCount;
    private int pageSize=20;
    private int pageCount;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount=totalCount/pageSize;
        if (totalCount%pageSize>0) {
            pageCount=pageCount+1;
        }
        return pageCount;
    }
}
