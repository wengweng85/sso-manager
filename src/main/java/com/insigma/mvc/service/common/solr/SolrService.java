package com.insigma.mvc.service.common.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;

import com.insigma.mvc.model.SolrQueryBean;

public interface  SolrService {
	
	 void search_lucene_info(SolrQueryBean solrQueryBean) throws IOException ,SolrServerException;

}
