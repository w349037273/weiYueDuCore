package com.weiyuedu.core.constants;

/**
 * 描述:  配置了jwt相关信息
 * 创建人: w349037273@163.com
 * 日期: 2017-09-06
 * 时间: 11:09
 */
public class JwtConstant {

    public static final String JWT_ID = "jwt";
    public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";
    public static final int JWT_TTL = 60*60*1000;  //millisecond
    public static final int JWT_REFRESH_INTERVAL = 55*60*1000;  //millisecond
    public static final int JWT_REFRESH_TTL = 12*60*60*1000;  //millisecond
}
