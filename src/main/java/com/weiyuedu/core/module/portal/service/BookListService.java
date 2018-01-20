package com.weiyuedu.core.module.portal.service;

import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.module.portal.pojo.BookList;

import java.util.List;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-21
 * 时间: 16:20
 */
public interface BookListService {

        ResponseResult selectAllBookList();

        ResponseResult selectBoolListDesc(Integer bookListId);

}
