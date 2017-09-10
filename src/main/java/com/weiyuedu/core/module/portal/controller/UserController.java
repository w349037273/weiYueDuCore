package com.weiyuedu.core.module.portal.controller;

import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.common.utils.ResponseResultUtill;
import com.weiyuedu.core.module.portal.pojo.User;
import com.weiyuedu.core.module.portal.service.UserService;
import com.weiyuedu.core.utils.CookieUtils;
import com.weiyuedu.core.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-05
 * 时间: 10:21
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 校验用户名是否注册
     * @param username
     * @return
     */
    @RequestMapping("/checkdata/{username}")
    @ResponseBody
    public ResponseResult checkData(@PathVariable String username){

        System.out.println("bbbb");
        return userService.checkData(username);
    }

    /**
     * 用户注册
     * @param
     * @return
     */
    @RequestMapping("/creat/{username}/{password}")
    @ResponseBody
    public ResponseResult creatUser(@PathVariable("username") String username,@PathVariable("password") String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.creatUser(user);
    }

    /**
     * 基于token的用户登录
     * @param request
     * @param response
     * @param userName
     * @param passWord
     * @return
     */
    @RequestMapping("/login/{userName}/{passWord}")
    @ResponseBody
    public ResponseResult login(HttpServletRequest request, HttpServletResponse response, @PathVariable String userName, @PathVariable String passWord){
        ResponseResult result = userService.login(userName, passWord);
        User user = (User)result.getData();
        if (result.getStatus() == 200){
            //生成token
            try {
                String token = JwtUtil.createJWT(UUID.randomUUID().toString(), user, 3000);
                //往Cookie写入token,utf8编码,有效期30分钟
                CookieUtils.setCookie(request,response,"token",token,3000,true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResponseResultUtill.build(205,"登录异常",false);
    }

    /**
     * 安全退出
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public ResponseResult logout(HttpServletRequest request,HttpServletResponse response){
        CookieUtils.deleteCookie(request,response,"token");
        System.out.println("logout");
        return ResponseResultUtill.ok();
    }

    /**
     * 重置密码
     * @param passwordOld
     * @param passwordNew
     * @param userName
     * @return
     */
    @RequestMapping("/reset/{passwordOld}/{passwordNew}/{userName}")
    @ResponseBody
    public ResponseResult resetPassword(@PathVariable String passwordOld,@PathVariable String passwordNew,@PathVariable String userName){
        ResponseResult result = userService.resetPassword(passwordOld, passwordNew, userName);
        return result;
    }

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    @RequestMapping("/getuserinfo/{userId}")
    @ResponseBody
    public ResponseResult getUserInfo(@PathVariable Integer userId){
        if (userId == null){
            return ResponseResultUtill.unauthorized();
        }
        ResponseResult userInfo = userService.getUserInfo(userId);
        return userInfo;
    }

    /**
     * 更新个人资料
     * @param userId
     * @param nickname
     * @return
     */
    @RequestMapping("/update/{userId}/{nickname}")
    @ResponseBody
    public ResponseResult updateUserInfo(@PathVariable Integer userId,@PathVariable String nickname){
        User user = new User();
        user.setId(userId);
        user.setNickname(nickname);
        ResponseResult result = userService.updateUserInfo(user);
        return result;
    }


}
