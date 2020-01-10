package com.insigma.mvc.dao.sysmanager.senstive;

import com.insigma.mvc.model.SysSenstiveWord;

import java.util.List;


/**
 * admin
 * @author admin
 *
 */
public interface SysSenstiveWordMapper {
	
	List<SysSenstiveWord> getList();
	List<SysSenstiveWord> getPageList(SysSenstiveWord sParam);
	SysSenstiveWord getParamByid(String paramid);
	int addparam(SysSenstiveWord sParam);
	int updateparam(SysSenstiveWord sParam);
	int deleteparambyid(String paramid);
}
