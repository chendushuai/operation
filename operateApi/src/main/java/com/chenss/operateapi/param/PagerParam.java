package com.chenss.operateapi.param;

public class PagerParam {
    private int pageSize = 20;
    /**
     * 页码，从0开始
     */
    private int pageIndex = 0;
    private int pageBegin;

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
}
