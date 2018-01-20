package com.weiyuedu.core.dao.mapper;

import com.weiyuedu.core.module.portal.pojo.BookLack;

public interface BookLackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookLack record);

    int insertSelective(BookLack record);

    BookLack selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookLack record);

    int updateByPrimaryKey(BookLack record);
}