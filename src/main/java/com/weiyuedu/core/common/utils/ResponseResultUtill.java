package com.weiyuedu.core.common.utils;

import com.weiyuedu.core.common.pojo.ResponseResult;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-06
 * 时间: 14:44
 */
public class ResponseResultUtill {

    /**
     * 响应结果：200，有数据
     * @param data
     * @return
     */
    public static ResponseResult ok(Object data){
        return new ResponseResult(200,"ok",data);
    }

    /**
     * 响应结果：200，没有数据
     * @return
     */
    public static ResponseResult ok(){
        return new ResponseResult(200,"ok",(Object) null);
    }

    /**
     * 404错误请求
     * @return
     */
    public static ResponseResult notFound(){
        return new ResponseResult(404,"not fuond",(Object) null);
    }

    /**
     * 403错误请求
     * @return
     */
    public static ResponseResult forbidden(){
        return new ResponseResult(403,"Forbidden",(Object) null);
    }

    /**
     * 401错误请求，非法请求
     * @return
     */
    public static ResponseResult unauthorized() {
        return new ResponseResult(401, "unauthorized",(Object) null);
    }

    /**
     * 500错误，服务器内部错误
     * @return
     */
    public static ResponseResult serverInternalError() {
        return new ResponseResult(500, "Server Internal Error",(Object) null);
    }

    /**
     * 1001错误，客户端异常
     * @return
     */
    public static ResponseResult customerError() {
        return new ResponseResult(1001, "Customer Error",(Object) null);
    }

    /**
     * 自定义错误
     * @return
     */
    public static ResponseResult build(Integer status, String message, Object data){
        return new ResponseResult(status,message,data);
    }


}
