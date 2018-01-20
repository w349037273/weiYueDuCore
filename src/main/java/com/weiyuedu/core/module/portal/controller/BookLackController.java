package com.weiyuedu.core.module.portal.controller;

import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.module.portal.pojo.BookLack;
import com.weiyuedu.core.module.portal.service.BookLackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-10-31
 * 时间: 17:15
 */
@Controller
public class BookLackController {

    @Autowired
    private BookLackService bookLackService;

    @RequestMapping(value = "/book/booklack",method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult addBookLack(@RequestParam String key, HttpServletRequest request){
        try {
            key =new String(request.getParameter("key").getBytes("iso8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BookLack bookLack = new BookLack();
        bookLack.setBookName(key);
        bookLack.setCreateTime(new Date());
        ResponseResult result = bookLackService.addBookLack(bookLack);
        return result;
    }



}
