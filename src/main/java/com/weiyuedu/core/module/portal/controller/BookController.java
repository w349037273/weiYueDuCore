package com.weiyuedu.core.module.portal.controller;

import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.module.portal.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-05
 * 时间: 10:22
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/select/book/{pageNum}/{pageSize}")
    @ResponseBody
    public ResponseResult selectAllBook(@PathVariable int pageNum,@PathVariable int pageSize){
        ResponseResult result = bookService.selectAllBook(pageNum, pageSize);
        System.out.println(result);
        return result;
    }

    @RequestMapping("/selectc/{categoryId}")
    @ResponseBody
    public ResponseResult selectByCategoryId(@PathVariable int categoryId){
        return bookService.selectByCategoryId(categoryId);
    }

    @RequestMapping("/selectdesc/{id}")
    @ResponseBody
    public ResponseResult selectByPrimaryKey(@PathVariable int id){
        return bookService.selectByPrimaryKey(id);
    }

    @RequestMapping("/")
    public ModelAndView selectBookBySort(){
        int[] numbers = {1,2,3,4};
        ResponseResult result = bookService.selectBookBySort();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("books",(List)result.getData());
        modelAndView.addObject("numbers",numbers);
        return modelAndView;
    }



}
