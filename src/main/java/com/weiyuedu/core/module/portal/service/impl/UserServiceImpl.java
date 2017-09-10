package com.weiyuedu.core.module.portal.service.impl;

import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.common.utils.ResponseResultUtill;
import com.weiyuedu.core.dao.mapper.UserMapper;
import com.weiyuedu.core.module.portal.pojo.User;
import com.weiyuedu.core.module.portal.service.UserService;
import com.weiyuedu.core.utils.MD5Util;
import com.weiyuedu.core.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-05
 * 时间: 10:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 数据校验，验证用户名是否重复
     * @param userName
     * @return
     */
    public ResponseResult checkData(String userName) {
        System.out.println(userName);
        //todo ajax请求未处理
        if (userName == null){
            System.out.println("userName == null");
            return ResponseResultUtill.unauthorized();
        }
        User user = userMapper.selectByUsername(userName);
        System.out.println("userMapper");
        if (user == null){
            System.out.println("该用户名尚未注册");
            return ResponseResultUtill.build(200,"该用户名尚未注册",true);
        }
        System.out.println("该用户名已经注册");
        return ResponseResultUtill.build(200,"该用户名已注册",false);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    public ResponseResult creatUser(User user) {

        //补充用户数据DigestUtils
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setPassword(MD5Util.MD5(user.getPassword()));
        user.setNickname(user.getUsername());
        int insert = userMapper.insert(user);
        if (!(insert >0)){
            return ResponseResultUtill.build(200,"新增用户失败",false);
        }
        return ResponseResultUtill.build(200,"新增用户成功",true);
    }

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @return
     */
    public ResponseResult login(String userName,String passWord){
        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(passWord)){
            return ResponseResultUtill.build(201,"账号和密码不能为空",false);
        }
        User user = userMapper.selectByUsername(userName);
        if (user == null){
            return ResponseResultUtill.build(202,"用户不存在",false);
        }
        if (!MD5Util.MD5(passWord).equals(user.getPassword())){
            return ResponseResultUtill.build(203,"密码错误",false);
        }
        //验证通过
        user.setPassword(StringUtils.EMPTY);
        return ResponseResultUtill.build(200,"登录成功",user);
    }

    //修改密码

    /**
     * 重置用户密码
     * @param passwordOld
     * @param passwordNew
     * @param userName
     * @return
     */
    public ResponseResult resetPassword(String passwordOld,String passwordNew,String userName){
        //验证参数是否正确
        if (StringUtils.isEmpty(passwordNew)||StringUtils.isEmpty(passwordOld)||StringUtils.isEmpty(userName)){
            return ResponseResultUtill.unauthorized();
        }
        //根据用户名获取用户
        User user = userMapper.selectByUsername(userName);
         String password = MD5Util.MD5(passwordOld);
        //防止横向越权,需要验证旧密码
        if (user.getPassword().equals(password)){
            return ResponseResultUtill.unauthorized();
        }
        //更新用户密码
        user.setPassword(password);
        user.setCreateTime(new Date());
        //更新数据库
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i >0){
            return ResponseResultUtill.ok();
        }
        return ResponseResultUtill.serverInternalError();
    }

    //找回密码

    /**
     * 修改昵称
     * @param user
     * @return
     */
    public ResponseResult updateUserInfo(User user){
        user.setPassword(null);
        user.setUsername(null);
        user.setCreateTime(null);
        user.setUpdateTime(new Date());
        int i = userMapper.updateByPrimaryKeySelective(user);
        System.out.println(i);
        if (i>0){
            return ResponseResultUtill.ok();
        }
        return ResponseResultUtill.unauthorized();
    }

    /**
     * 获取个人信息
     * @param userId
     * @return
     */
    public ResponseResult getUserInfo(Integer userId ){
        if (userId == null){
            ResponseResultUtill.unauthorized();
        }
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null){
            ResponseResultUtill.build(405,"用户不存在",false);
        }
        return ResponseResultUtill.ok(user);
    }

}
