package com.insigma.mvc.service.sysmanager.param;

import java.util.HashMap;
import java.util.List;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.SysParam;


/**
 *  系统参数service
 * @author admin
 *
 */
public interface SysParamService {
	
	 List<SysParam> getList();
	
	 HashMap<String, Object> getPageList(SysParam sParam);
	
	 AjaxReturnMsg<String>  updateparam(SysParam sParam);
	
	 AjaxReturnMsg<String>  deleteparambyid(String  paramid);
	
	
}
