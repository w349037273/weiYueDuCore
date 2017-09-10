package com.weiyuedu.core.module.portal.dto;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-05
 * 时间: 09:59
 */
public class BookSimple {
    private Integer id;

    private String bookName;

    private String bookDesc;

    private Double price;

    private String bgPicture;

    private Integer downloadNum;

    private Integer starLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBgPicture() {
        return bgPicture;
    }

    public void setBgPicture(String bgPicture) {
        this.bgPicture = bgPicture;
    }

    public Integer getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(Integer downloadNum) {
        this.downloadNum = downloadNum;
    }

    public Integer getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(Integer starLevel) {
        this.starLevel = starLevel;
    }
}
