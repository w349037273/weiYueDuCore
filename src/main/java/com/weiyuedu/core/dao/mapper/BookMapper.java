package com.weiyuedu.core.dao.mapper;

import com.weiyuedu.core.module.portal.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> selectByCategoryId(@Param("categoryId") Integer categoryId);

    List<Book> selectAllBook();

    List<Book> selectBookBySort();

}