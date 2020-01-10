package com.insigma.mvc.dao.WEBPERM_001_001.systype;

import java.util.List;

import com.insigma.mvc.model.SSysType;



/**
 * admin
 * @author admin
 *
 */
public interface WebSystypeMapper {
	
	List<SSysType> getList();
	List<SSysType> getPageList(SSysType type);
	SSysType getSystypeByid(String paramid);
	int addSystype(SSysType sParam);
	int updateSystype(SSysType sParam);
	int deleteSystypebyId(String paramid);
}
