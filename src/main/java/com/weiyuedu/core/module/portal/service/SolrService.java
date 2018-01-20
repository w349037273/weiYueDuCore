package com.weiyuedu.core.module.portal.service;

import com.weiyuedu.core.common.pojo.ResponseResult;
import com.weiyuedu.core.module.portal.dto.SearchResult;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrException;

import java.io.IOException;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-16
 * 时间: 22:07
 */
public interface SolrService {

    ResponseResult addIndex() throws SolrException,IOException;

    SearchResult searchSolr(String queryString, int page, int rows) throws IOException, SolrServerException;


}
