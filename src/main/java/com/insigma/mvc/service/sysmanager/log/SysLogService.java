package com.insigma.mvc.service.sysmanager.log;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.insigma.mvc.model.SysErrorLog;
import com.insigma.mvc.model.SysLog;


/**
 * 框架系统日志服务
 * @author admin
 *
 */
public interface SysLogService  {
	
	 String saveLogInfo(SysLog slog);
	
	 String sysErrorLog(Exception e, HttpServletRequest request);
	
	 HashMap<String, Object> queryLogList(SysLog slog);
	
	 HashMap<String, Object> queryErrorLogList(SysErrorLog sErrorLog);
	
	 SysLog queryLogById(String logid);
	
	 SysErrorLog queryErrorLogById(String logid);
}
