package com.insigma.mvc.service.sysmanager.log;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.insigma.mvc.model.SysErrorLog;
import com.insigma.mvc.model.SysLog;


/**
 * ���ϵͳ��־����
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
