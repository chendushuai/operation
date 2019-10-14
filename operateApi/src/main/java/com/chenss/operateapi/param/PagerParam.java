package com.chenss.operateapi.param;

public class PagerParam {
    private int pageSize = 20;
    private int pageIndex = 0;
    private int pageBegin;
    private int pageEnd;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageBegin() {
        this.pageBegin = pageIndex * pageSize;
        return pageBegin;
    }

    public int getPageEnd() {
        this.pageEnd = (pageIndex+1) * pageSize;
        return pageEnd;
    }
}
