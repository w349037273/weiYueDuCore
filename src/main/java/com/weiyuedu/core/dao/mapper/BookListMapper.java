package com.weiyuedu.core.dao.mapper;

import com.weiyuedu.core.module.portal.pojo.BookList;

import java.util.List;

public interface BookListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookList record);

    int insertSelective(BookList record);

    BookList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookList record);

    int updateByPrimaryKey(BookList record);

    List<BookList> selectAllBookList();
}