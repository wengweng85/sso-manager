package com.insigma.mvc.service.WEBPERM_001_001.systype;

import java.util.HashMap;
import java.util.List;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.SSysType;


/**
 *  系统参数service
 * @author admin
 *
 */
public interface WebSystypeService {
	
	public List<SSysType> getList();
	
	public HashMap<String, Object> getPageList(SSysType sParam);
	
	public AjaxReturnMsg<String>  updateSystype(SSysType sParam);
	
	public AjaxReturnMsg<String>  deleteSystypebyId(String  paramid);
	
	
}
