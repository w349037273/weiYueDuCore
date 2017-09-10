package com.weiyuedu.core.module.portal.service;

import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.module.portal.pojo.User;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-05
 * 时间: 10:21
 */
public interface UserService {

    ResponseResult checkData(String userName);

    ResponseResult creatUser(User user);

    ResponseResult login(String userName,String passWord);

    ResponseResult resetPassword(String passwordOld,String passwordNew,String userName);

    ResponseResult updateUserInfo(User user);

    ResponseResult getUserInfo(Integer userId);

}
