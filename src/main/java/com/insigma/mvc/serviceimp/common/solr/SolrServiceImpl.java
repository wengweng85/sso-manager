package com.insigma.mvc.serviceimp.common.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.insigma.common.util.WebFormatter;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.model.SolrQueryBean;
import com.insigma.mvc.model.SolrResultBean;
import com.insigma.mvc.service.common.solr.SolrService;

/**
 * 搜索服务
 * @author admin
 *
 */
@Service
public class SolrServiceImpl extends MvcHelper implements SolrService {


	Log log=LogFactory.getLog(SolrServiceImpl.class);
	
	@Value("${solr_url}")
	private String solrurl;
	/**
	 * 搜索
	 * 
	 * @param collection
	 * @param q
	 * @param type
	 * @param start
	 * @param rows
	 * @return
	 */
	@Override
	public void search_lucene_info(SolrQueryBean solrQueryBean)  throws IOException,SolrServerException{
		String query_param = "*:*";
		if (!solrQueryBean.getQ().equals("")) {
			query_param = "title:" + solrQueryBean.getQ() + " or content:" + solrQueryBean.getQ();
		}
		HttpSolrClient client = new HttpSolrClient(solrurl);
		client.setConnectionTimeout(30000);
		client.setDefaultMaxConnectionsPerHost(100);
		client.setMaxTotalConnections(100);
		client.setSoTimeout(30000);
		SolrQuery query = new SolrQuery();
		query.setQuery(query_param);
		query.setFields("id", "title","content", "link_url","publish_date","img");
		query.setStart(new Integer(solrQueryBean.getStart()).intValue());
		query.setRows(new Integer(solrQueryBean.getRows()).intValue());
		query.addHighlightField("title");
		query.addHighlightField("content");
		query.setHighlight(true);
		query.setHighlightSimplePre("<font color='red'>");
		query.setHighlightSimplePost("</font>");
		List<SolrResultBean> list = new ArrayList<SolrResultBean>();
		QueryResponse rsp = client.query(query);
		SolrDocumentList docs = rsp.getResults();
		//高亮数据  第一个Map的键是文档的ID，第二个Map的键是高亮显示的字段名 
		Map<String, Map<String, List<String>>> highlightmap= rsp.getHighlighting();
		//返回查询时间
		log.info("查询内容:" + query);
		log.info("文档数量：" + docs.getNumFound());
		log.info("查询花费时间:" + rsp.getQTime());
		for (SolrDocument doc : docs) {
			SolrResultBean bean = new SolrResultBean();
			String id = (String) doc.getFieldValue("id");
			String link_url = (String) doc.getFieldValue("link_url");
			String title = (String) doc.getFieldValue("title");
			String img = (String) doc.getFieldValue("img");
			String content = WebFormatter.html2text((String) doc.getFieldValue("content"));
			bean.setId(id);
			SolrResultBean reuslt=new SolrResultBean();
			reuslt.setLink_url(link_url);
			reuslt.setId(id);
			reuslt.setImg(img);
			reuslt.setTitle(title);
			reuslt.setContent(content);
			if(highlightmap.get(id)!=null && highlightmap.get(id).get("title")!=null){
				reuslt.setTitle(highlightmap.get(id).get("title").get(0));
			}
			
			if(highlightmap.get(id)!=null && highlightmap.get(id).get("content")!=null){
				reuslt.setContent(highlightmap.get(id).get("content").get(0));
			}
			
			if(reuslt.getContent().length()>200){
				reuslt.setContent(reuslt.getContent().substring(0,200)+"...");
			}
			list.add(reuslt);
		}
		//查询结果
		solrQueryBean.setList(list);
		solrQueryBean.setQttime(rsp.getQTime());
		solrQueryBean.setNumFound(docs.getNumFound());
	}
		
}