package com.weiyuedu.core.module.portal.service;

import com.weiyuedu.core.common.pojo.ResponseResult;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-05
 * 时间: 10:22
 */
public interface BookService {

    ResponseResult selectAllBook(int pageNum,int pageSize);

    ResponseResult selectByCategoryId(int categoryId,int pageNum,int pageSize);

    ResponseResult selectByPrimaryKey(int id);

    ResponseResult selectBookBySort();

//    ResponseResult selectBookBuUUID(String uuid);
}
