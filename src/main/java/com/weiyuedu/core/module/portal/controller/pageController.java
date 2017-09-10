package com.weiyuedu.core.module.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-05
 * 时间: 10:29
 */
@Controller
public class pageController {

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/index1")
    public String index(){
        return "index";
    }


}
