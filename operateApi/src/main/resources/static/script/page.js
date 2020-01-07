/**
 * 用于刷新页码显示区域
 * @param totalSize 总数据条数
 * @param pageSize 每页显示的数据条数
 * @param pageRange 显示的页码范围，如5页
 * @param pageIndex 当前页码
 */
function pageRefresh(totalSize,pageSize,pageRange,pageIndex) {
    if (pageRange<5) {
        pageRange=5;
    }
    var pageCount = Math.floor(totalSize/pageSize);
    if (totalSize==0 || totalSize%pageSize>0) {
        pageCount = pageCount+1;
    }
    var pager=$("#data-pager");
    if (pageIndex==0) {
        pager.html("<li class=\"disabled\"><span><span aria-hidden=\"true\">&laquo;</span></span></li>");
        pager.html(pager.html()+"<li class=\"active\"><span>1 <span class=\"sr-only\">(current)</span></span></li>");
    } else {
        var lastPage = pageIndex-1;
        pager.html("<li><a href=\"javascript:void(0);\" onclick=\"javacript:query("+lastPage+")\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
    }
    if (pageCount==1) {
    } else if (pageCount<=pageRange) {
        for (var i = 0; i < pageCount; i++) {
            if (pageIndex==0 && i==0) {
                continue;
            }
            var pageI = i+1;
            if (pageIndex==i) {
                pager.html(pager.html()+"<li class=\"active\"><span>"+pageI+" <span class=\"sr-only\">(current)</span></span></li>");
                continue;
            }
            pager.html(pager.html()+"<li><a href=\"javascript:void(0);\" onclick=\"javacript:query("+i+")\">"+pageI+"</a></li>");
        }
    } else {
        var beginPageIndex=1;
        var endPageIndex=pageRange;

        var halfRange=Math.floor(pageRange/2);
        var rangeLeft = Math.floor(pageRange/2);
        var rangeRight = rangeLeft;
        if (pageRange%2!=0) {
            halfRange = halfRange+1;
        } else {
            rangeLeft=rangeLeft-1;
        }
        if (pageIndex>rangeLeft) {
            if (pageIndex+rangeRight>pageCount) {
                beginPageIndex=pageCount-pageRange;
                endPageIndex=pageCount;
            } else {
                beginPageIndex=pageIndex-rangeLeft;
                endPageIndex=pageIndex+rangeRight;
            }
        }
        for (var i = beginPageIndex-1; i < endPageIndex; i++) {
            if (pageIndex==0 && i==0) {
                continue;
            }
            var pageI = i+1;
            if (pageIndex==i) {
                pager.html(pager.html()+"<li class=\"active\"><span>"+pageI+" <span class=\"sr-only\">(current)</span></span></li>");
                continue;
            }
            pager.html(pager.html()+"<li><a href=\"javascript:void(0);\" onclick=\"javacript:query("+i+")\">"+pageI+"</a></li>");
        }
    }
    if (pageIndex+1==pageCount) {
        pager.html(pager.html()+"<li class=\"disabled\"><span><span aria-hidden=\"true\">&raquo;</span></span></li>");
    } else {
        pager.html(pager.html()+"<li><a href=\"#\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
    }
    $("#data-pager-top").html(pager.html());
    $("#page-current-index").html(pageIndex);
}