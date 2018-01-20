package com.weiyuedu.core.module.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.common.utils.ResponseResultUtill;
import com.weiyuedu.core.dao.mapper.BookMapper;
import com.weiyuedu.core.module.portal.dto.BookSimple;
import com.weiyuedu.core.module.portal.dto.EUDateGridResultDto;
import com.weiyuedu.core.module.portal.pojo.Book;
import com.weiyuedu.core.module.portal.service.BookService;
import com.weiyuedu.core.utils.QniuUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-05
 * 时间: 10:22
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    /**
     * 查询全部书籍,带分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ResponseResult selectAllBook(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EUDateGridResultDto euDateGridResultDto = new EUDateGridResultDto();
        List<Book> books = bookMapper.selectAllBook();
        List<BookSimple> bookSimples = new ArrayList<BookSimple>();
        if (books != null && books.size()>0){
            for (int i = 0;i <books.size();i++){
                Book book = books.get(i);
                BookSimple bookSimple = new BookSimple();
                bookSimple.setId(book.getId());
                try {
                    bookSimple.setBgPicture(QniuUtill.fileURL(book.getBgPicture()));
                } catch (UnsupportedEncodingException e) {
                    System.out.println("图片读取异常");
                    e.printStackTrace();
                }
                bookSimple.setStarLevel(book.getStarLevel());
                bookSimple.setBookDesc(book.getBookDesc());
                bookSimple.setBookName(book.getBookName());
                bookSimple.setPrice(book.getPrice());
                bookSimple.setAuthor(book.getAuthor());
                bookSimple.setDownloadNum(book.getDownloadNum());
                bookSimples.add(bookSimple);
            }
        }
        PageInfo pageInfo = new PageInfo(books);
        euDateGridResultDto.setTotal(pageInfo.getTotal());
        euDateGridResultDto.setRows(bookSimples);
        return ResponseResultUtill.build(200,"ok",euDateGridResultDto);
    }

    /**
     * 查询类目下的各书籍
     * @param categoryId
     * @return
     */
    public ResponseResult selectByCategoryId(int categoryId,int pageNum,int pageSize){

        PageHelper.startPage(pageNum,pageSize);
        List<Book> books = bookMapper.selectByCategoryId(categoryId);
        EUDateGridResultDto euDateGridResultDto = new EUDateGridResultDto();
        List<BookSimple> bookSimples = new ArrayList<BookSimple>();
        if (books != null && books.size()>0){
            for (int i = 0;i <books.size();i++){
                Book book = books.get(i);
                BookSimple bookSimple = new BookSimple();
                bookSimple.setId(book.getId());
                try {
                    bookSimple.setBgPicture(QniuUtill.fileURL(book.getBgPicture()));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    System.out.println("图片读取失败");
                }
                bookSimple.setStarLevel(book.getStarLevel());
                bookSimple.setBookDesc(book.getBookDesc());
                bookSimple.setBookName(book.getBookName());
                bookSimple.setAuthor(book.getAuthor());
                bookSimple.setPrice(book.getPrice());
                bookSimple.setDownloadNum(book.getDownloadNum());
                bookSimples.add(bookSimple);
            }
        }
        PageInfo pageInfo = new PageInfo(books);
        euDateGridResultDto.setTotal(pageInfo.getTotal());
        euDateGridResultDto.setRows(bookSimples);
        return ResponseResultUtill.build(200,"ok",euDateGridResultDto);
    }

    /**
     * 查询书籍详情
     * @param id
     * @return
     */
    public ResponseResult selectByPrimaryKey(int id) {
        Book book = bookMapper.selectByPrimaryKey(id);
        try {
            book.setBgPicture(QniuUtill.fileURL(book.getBgPicture()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("图像读取失败");
        }
        return ResponseResultUtill.ok(book);
    }


    public ResponseResult selectBookBySort(){
        List<Book> books = bookMapper.selectBookBySort();
        return ResponseResultUtill.ok(books);
    }

//    public ResponseResult selectBookBuUUID(String uuid) {
//        List<Book> books = bookMapper.selectByBookUUID(uuid);
//        return ResponseResultUtill.ok(books.get(0));
//    }

}
