package com.weiyuedu.core.module.portal.service.impl;

import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.common.utils.ResponseResultUtill;
import com.weiyuedu.core.constants.BookListDescEnum;
import com.weiyuedu.core.dao.mapper.BookListDescMapper;
import com.weiyuedu.core.dao.mapper.BookListMapper;
import com.weiyuedu.core.module.portal.pojo.BookList;
import com.weiyuedu.core.module.portal.pojo.BookListDesc;
import com.weiyuedu.core.module.portal.service.BookListService;
import com.weiyuedu.core.utils.QniuUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-21
 * 时间: 16:22
 */
@Service
public class BookListServiceImpl implements BookListService {


    @Autowired
    private BookListMapper bookListMapper;

    @Autowired
    private BookListDescMapper bookListDescMapper;

    public ResponseResult selectAllBookList() {

        List<BookList> bookLists = bookListMapper.selectAllBookList();
        for (BookList blist : bookLists){
            try {
                blist.setBgPicture(QniuUtill.fileURL(blist.getBgPicture()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.out.println("读取失败");
            }
        }
        if (bookLists == null || bookLists.size() == 0){
            return ResponseResultUtill.notFound();
        }
        return ResponseResultUtill.ok(bookLists);
    }

    public ResponseResult selectBoolListDesc(Integer bookListId) {

        List<BookListDesc> bookListDescs = bookListDescMapper.selectByBookListId(bookListId);
        //设置图片访问路径
        for (BookListDesc bdesc: bookListDescs) {
            try {
                bdesc.setBgPicture(QniuUtill.fileURL(bdesc.getBgPicture()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.out.println("读取失败");
            }
        }
        if (bookListDescs != null && bookListDescs.size()>0){
            HashMap<String, List<BookListDesc>> stringListHashMap = new HashMap<String, List<BookListDesc>>();
            ArrayList<BookListDesc> juniorList = new ArrayList<BookListDesc>();
            ArrayList<BookListDesc> intermediateList = new ArrayList<BookListDesc>();
            ArrayList<BookListDesc> seniorList = new ArrayList<BookListDesc>();
            for (BookListDesc bookListDesc : bookListDescs){
                switch (bookListDesc.getLevel()){
                    case 1:
                        juniorList.add(bookListDesc);
                        break;
                    case 2:
                        intermediateList.add(bookListDesc);
                        break;
                    case 3:
                        seniorList.add(bookListDesc);
                        break;
                }
            }
            if (juniorList.size()>0){
                stringListHashMap.put(BookListDescEnum.Junior.getGrade(),juniorList);
            }
            if (intermediateList.size()>0){
                stringListHashMap.put(BookListDescEnum.Intermediate.getGrade(),intermediateList);
            }
            if (seniorList.size()>0){
                stringListHashMap.put(BookListDescEnum.Senior.getGrade(),seniorList);
            }
            return ResponseResultUtill.ok(stringListHashMap);
        }
        return ResponseResultUtill.notFound();
    }
}
