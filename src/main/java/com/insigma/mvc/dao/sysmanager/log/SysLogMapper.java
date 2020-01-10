package com.insigma.mvc.dao.sysmanager.log;

import java.util.List;

import com.insigma.mvc.model.SysErrorLog;
import com.insigma.mvc.model.SysLog;


/**
 * 
 * 框架系统日志记录mapper
 * @author admin
 *
 */
public interface SysLogMapper {
	 void saveLogInfo(SysLog slog);
	 void saveSysErrorLog(SysErrorLog sErrorLog);
	 List<SysLog> queryLogList(SysLog slog);
	 SysLog queryLogById(String logid);
	 List<SysErrorLog>  queryErrorLogList(SysErrorLog sErrorLog);
	 SysErrorLog queryErrorLogById(String logid);
}
