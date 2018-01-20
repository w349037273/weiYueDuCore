package com.weiyuedu.core.dao.mapper;

import com.weiyuedu.core.module.portal.pojo.BookList;
import com.weiyuedu.core.module.portal.pojo.BookListDesc;

import java.util.List;

public interface BookListDescMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookListDesc record);

    int insertSelective(BookListDesc record);

    BookListDesc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookListDesc record);

    int updateByPrimaryKey(BookListDesc record);

    List<BookListDesc> selectByBookListId(Integer id);
}