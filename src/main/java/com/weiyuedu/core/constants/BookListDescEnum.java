package com.weiyuedu.core.constants;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-23
 * 时间: 23:24
 */
public enum BookListDescEnum {

    Junior("初级",1),
    Intermediate("中级",2),
    Senior("高级",3)
    ;

    private String grade;

    private int index;

    BookListDescEnum(String grade, int index) {
        this.grade = grade;
        this.index = index;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
