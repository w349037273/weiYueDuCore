package com.weiyuedu.core.module.portal.service.impl;

import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.common.utils.ResponseResultUtill;
import com.weiyuedu.core.dao.mapper.BookLackMapper;
import com.weiyuedu.core.module.portal.pojo.BookLack;
import com.weiyuedu.core.module.portal.service.BookLackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-10-31
 * 时间: 17:09
 */
@Service
public class BookLackServiceimpl implements BookLackService {

    @Autowired
    private BookLackMapper bookLackMapper;

    public ResponseResult addBookLack(BookLack bookLack) {

        int insert = bookLackMapper.insert(bookLack);
        if (insert >0){
            return ResponseResultUtill.ok();
        }
        return ResponseResultUtill.unauthorized();
    }
}
