package com.insigma.mvc.service.api.API_LOG_001_001;

import java.util.HashMap;

import com.insigma.mvc.model.SAppLog;
import com.insigma.mvc.model.SErrorLog;
import com.insigma.mvc.model.SLog;
import com.insigma.mvc.model.SysErrorLog;


/**
 * api 日志查询服务
 * @author admin
 *
 */
public interface ApiLogQueryService  {
	
	 HashMap<String, Object> queryLogList(SLog slog);
	
	 HashMap<String, Object> queryErrorLogList(SErrorLog sErrorLog);

	 HashMap<String, Object> queryAppLogList(SAppLog sAppLog);
	
	 SLog queryLogById(String logid);
	
	 SErrorLog queryErrorLogById(String logid);

	 HashMap<String, Object> querySysErrorLogList(SysErrorLog sErrorLog);

	 SysErrorLog querySysErrorLogById(String logid);
}
