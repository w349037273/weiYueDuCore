package com.weiyuedu.core.module.portal.pojo;

import java.util.Date;

public class Book {
    private Integer id;

//    private String bookUUID;

    private String bookName;

    private String author;

    private String bookDesc;

    private Integer categoryId;

    private Double price;

    private String bgPicture;

    private Integer downloadNum;

    private Integer starLevel;

    private String downloadUrl;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public String getBookUUID() {
//        return bookUUID;
//    }
//
//    public void setBookUUID(String bookUUID) {
//        this.bookUUID = bookUUID;
//    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc == null ? null : bookDesc.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
        this.bgPicture = bgPicture == null ? null : bgPicture.trim();
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

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl == null ? null : downloadUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}