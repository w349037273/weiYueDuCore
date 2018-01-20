package com.weiyuedu.core.module.portal.controller;

import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.module.portal.pojo.BookListDesc;
import com.weiyuedu.core.module.portal.service.BookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-21
 * 时间: 16:29
 */
@Controller
public class BookListController {

    @Autowired
    private BookListService bookListService;

    @RequestMapping("/bookList")
    @ResponseBody
    public ResponseResult selectAllBookList() {
        return bookListService.selectAllBookList();
    }


    @RequestMapping(value = "/bookListDesc", method = RequestMethod.GET)
    public ModelAndView selectBoolListDesc1(Integer bookListId) {
        ModelAndView modelAndView = new ModelAndView();
        ResponseResult result = bookListService.selectBoolListDesc(bookListId);

        if (result.getData() != null){
            modelAndView.setViewName("/booklist/booklistdesc");
            modelAndView.addObject("booklistdesces", (HashMap<String, List<BookListDesc>>) result.getData());
        }else {
            modelAndView.setViewName("/other/nothing");
        }
        return modelAndView;
    }

}
