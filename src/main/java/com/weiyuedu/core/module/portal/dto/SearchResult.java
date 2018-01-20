package com.weiyuedu.core.module.portal.dto;

import com.weiyuedu.core.module.portal.pojo.Book;

import java.util.List;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-17
 * 时间: 22:04
 */
public class SearchResult {
    //商品列表
    private List<Book> bookList;
    //总记录数
    private long recordCount;
    //总页数
    private long pageCount;
    //当前页
    private long curPage;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public long getCurPage() {
        return curPage;
    }

    public void setCurPage(long curPage) {
        this.curPage = curPage;
    }
}
