package com.weiyuedu.core.common.pojo;

/**
 * 描述:返回给前台的数据对象
 * 创建人: w349037273@163.com
 * 日期: 2017-09-05
 * 时间: 10:34
 */
public class ResponseResult {

    private Integer status;//错误状态码

    private String message;//响应信息

    private Object data;//响应数据

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    //构造方法
    public ResponseResult(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    //无参构造方法
    public ResponseResult() {
    }



}
