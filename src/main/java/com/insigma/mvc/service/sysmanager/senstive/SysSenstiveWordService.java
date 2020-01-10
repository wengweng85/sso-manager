package com.insigma.mvc.service.sysmanager.senstive;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.SysSenstiveWord;

import java.util.HashMap;
import java.util.List;


/**
 *  ϵͳ�ؼ���service
 * @author admin
 *
 */
public interface SysSenstiveWordService {

	 List<SysSenstiveWord> getList();

	 HashMap<String, Object> getPageList(SysSenstiveWord sParam);

	 AjaxReturnMsg<String>  updateparam(SysSenstiveWord sParam);

	 AjaxReturnMsg<String>  deleteparambyid(String paramid);
	
	
}
