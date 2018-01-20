package com.weiyuedu.core.module.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    private static final transient Logger log = LoggerFactory.getLogger(pageController.class);

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/yunyingmiao")
    public String yunYingMiao(){
        return "/bookgroup/yunyingmiao";
    }

    @RequestMapping("/chanpinwang")
    public String chanPinWang(){
        return "/bookgroup/chanpinwang";
    }

    @RequestMapping("/chengxuyuan")
    public String chengXuYuan(){
        return "/bookgroup/chengxuyuan";
    }

    @RequestMapping("/nothing")
    public String nothing(){
        return "/other/nothing";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("info");
        return "login";
    }


}
