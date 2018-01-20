package com.weiyuedu.core.module.portal.service.impl;

import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.common.utils.ResponseResultUtill;
import com.weiyuedu.core.dao.mapper.BookMapper;
import com.weiyuedu.core.module.portal.dto.SearchResult;
import com.weiyuedu.core.module.portal.pojo.Book;
import com.weiyuedu.core.module.portal.service.SolrService;
import com.weiyuedu.core.utils.QniuUtill;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述:使用solrj调用solr服务
 * 创建人: w349037273@163.com
 * 日期: 2017-09-16
 * 时间: 22:18
 */
@Service
public class SolrServiceImpl implements SolrService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private HttpSolrClient solrClient;


    /**
     * 使用solrjx向索引库添加数据,暂时向solr索引库插入20条数据
     * @return
     * @throws SolrException
     * @throws IOException
     */
    public ResponseResult addIndex() throws SolrException, IOException {

        //从数据库中查询数据
        List<Book> books = bookMapper.selectAllBook();
        System.out.println(books.size());
        if (books == null && books.size()==0){
            return ResponseResultUtill.notFound();
        }
        ArrayList<SolrInputDocument> solrInputDocuments = new ArrayList<SolrInputDocument>();
        //遍历添加文档，在此先控制为20个
        for (int i = 0;i<20;i++){
            //构造一篇文档
            SolrInputDocument solrInputFields = new SolrInputDocument();
            //向文档添加字段，该字段必须是在solr定义过
            solrInputFields.addField("id",books.get(i).getId());
            solrInputFields.addField("book_name",books.get(i).getBookName());
            solrInputFields.addField("author",books.get(i).getAuthor());
            solrInputFields.addField("book_desc",books.get(i).getBookDesc());
            solrInputFields.addField("category_id",books.get(i).getCategoryId());
            solrInputFields.addField("price",books.get(i).getPrice());
            solrInputFields.addField("bg_picture",books.get(i).getBgPicture());
            solrInputFields.addField("download_num",books.get(i).getDownloadNum());
            solrInputFields.addField("dowmload_url",books.get(i).getDownloadUrl());
            solrInputFields.addField("start_level",books.get(i).getStarLevel());
            solrInputDocuments.add(solrInputFields);
            }
        try {
            solrClient.add(solrInputDocuments);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        try {
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
            solrClient.close();
        return ResponseResultUtill.ok();
    }


    /**
     * 根据关键字查询索引库,并高亮显示查询结果
     * @param queryString
     * @param page
     * @param rows
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    public SearchResult searchSolr(String queryString, int page, int rows) throws IOException, SolrServerException {
        queryString = java.net.URLDecoder.decode(queryString,"UTF-8");
        //创建查询条件
        SolrQuery solrQuery = new SolrQuery();
        //设置查询条件,设置关键字
        solrQuery.setQuery("book_name"+":"+"*"+queryString+"*");
        //设置起始记录
        solrQuery.setStart((page-1)*rows);
        //设置页数
        solrQuery.setRows(rows);
        //设置默认搜索域，根据自己的业务字段
        //solrQuery.set("book_name",queryString);
        //设置高亮,开启高亮
        solrQuery.setHighlight(true);
        //设置高亮显示字段
        solrQuery.addHighlightField("book_name");
        //设置高亮样式
        solrQuery.setHighlightSimplePre("<font color='red'>");//标记，高亮关键字前缀
        solrQuery.setHighlightSimplePost("</font>");//后缀
        //获取查询结果
        SearchResult result = search(solrQuery);
        long pageCount = result.getRecordCount()/rows;
        if (result.getRecordCount()%rows>0){
            pageCount++;
        }
        result.setPageCount(pageCount);
        return result;
    }



    private SearchResult search(SolrQuery solrQuery) throws IOException, SolrServerException {

//        HttpSolrClient solrClient = new HttpSolrClient("http://101.132.133.227:8081/solr/collection1");
        //创建查询结果对象
        SearchResult searchResult = new SearchResult();
        //查询solr索引库
        QueryResponse response = solrClient.query(solrQuery);
        //获取查询结果
        SolrDocumentList results = response.getResults();
        //高亮显示记录
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();

        //获取记录
        List<Book> books = new ArrayList<Book>();
        for (SolrDocument solrDocument : results){
            Book book = new Book();
            book.setId(Integer.parseInt((String) solrDocument.get("id")));
            String bookName = "";
            //获取高亮结果
            List<String> list = highlighting.get(solrDocument.get("id")).get("book_name");
            if (list != null && list.size()>0){
                bookName = list.get(0);
            }else {
                bookName = (String) solrDocument.get("book_name");
            }
            book.setBookName(bookName);
            book.setBookDesc((String) solrDocument.get("book_desc"));
            book.setAuthor((String) solrDocument.get("author"));
            book.setCategoryId(Integer.parseInt((String) solrDocument.get("category_id")));
            book.setPrice(Double.parseDouble(String.valueOf(solrDocument.get("price"))));
            book.setBgPicture(QniuUtill.fileURL((String) solrDocument.get("bg_picture")));
            book.setDownloadNum(Integer.parseInt(String.valueOf(solrDocument.get("download_num"))));
            book.setDownloadUrl((String) solrDocument.get("dowmload_url"));
            book.setStarLevel(Integer.parseInt(String.valueOf(solrDocument.get("start_level"))));
            books.add(book);
        }
        //设置记录总数
        searchResult.setRecordCount(results.getNumFound());
        searchResult.setBookList(books);
        return searchResult;
    }
}
