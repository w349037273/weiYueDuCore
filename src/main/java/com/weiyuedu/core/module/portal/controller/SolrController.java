package com.weiyuedu.core.module.portal.controller;

import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.common.utils.ResponseResultUtill;
import com.weiyuedu.core.module.portal.dto.SearchResult;
import com.weiyuedu.core.module.portal.service.SolrService;
import com.weiyuedu.core.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-17
 * 时间: 10:49
 */
@Controller
public class SolrController {

    @Autowired
    private SolrService solrService;

    @RequestMapping("/solr/addindex")
    @ResponseBody
    public ResponseResult addIndex(){
        try {
            System.out.println("a");
            return solrService.addIndex();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseResultUtill.unauthorized();
    }



    @RequestMapping(value="/query", method= RequestMethod.GET)
    private ModelAndView search(@RequestParam("q")String queryString,
                                  @RequestParam(defaultValue="1")Integer page,
                                  @RequestParam(defaultValue="60")Integer rows){
        //查询条件不能为空
        if (StringUtils.isBlank(queryString)){
            return null;
        }
        SearchResult searchResult = null;
        try {
            queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
            try {
                searchResult = solrService.searchSolr(queryString, page, rows);
                ModelAndView modelAndView = new ModelAndView();
                if (searchResult.getRecordCount()>0){
                    modelAndView.addObject("books",searchResult.getBookList());
                    modelAndView.addObject("count",searchResult.getRecordCount());
                    modelAndView.setViewName("/serachresult");
                }else {
                    modelAndView.addObject("key",queryString);
                    modelAndView.setViewName("/other/nothing");
                }
                return modelAndView;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SolrServerException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value="/query1", method= RequestMethod.GET)
    @ResponseBody
    private ResponseResult searchTwo(@RequestParam("q")String queryString,
                                @RequestParam(defaultValue="1")Integer page,
                                @RequestParam(defaultValue="60")Integer rows){
        //查询条件不能为空
        if (StringUtils.isBlank(queryString)){
            return null;
        }
        SearchResult searchResult = null;
        try {
            queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
            try {
                searchResult = solrService.searchSolr(queryString, page, rows);
                return ResponseResultUtill.ok(searchResult);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SolrServerException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
