package com.weiyuedu.core.module.portal.controller;

import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.module.portal.pojo.Book;
import com.weiyuedu.core.module.portal.pojo.BookList;
import com.weiyuedu.core.module.portal.service.BookListService;
import com.weiyuedu.core.module.portal.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private BookListService bookListService;

    @RequestMapping(value = "/select/books",method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult selectAllBook(int pageNum,int pageSize){
        ResponseResult result = bookService.selectAllBook(pageNum, pageSize);
        return result;
    }

    @RequestMapping(value = "/select/booksbycategory",method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult selectByCategoryId( int categoryId,int pageNum,int pageSize){
        return bookService.selectByCategoryId(categoryId,pageNum,pageSize);
    }

    @RequestMapping("/select/bookdesc/{id}")
    public ModelAndView selectByPrimaryKey(@PathVariable int id){
        ResponseResult result = bookService.selectByPrimaryKey(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookdesc");
        modelAndView.addObject("book",(Book)result.getData());
        return modelAndView;
    }



    @RequestMapping("/")
    public ModelAndView selectBookBySort(){
        ResponseResult result = bookService.selectBookBySort();
        ResponseResult bookList = bookListService.selectAllBookList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("books",(List)result.getData());
        modelAndView.addObject("booklistses",(List)bookList.getData());
        return modelAndView;
    }



}
