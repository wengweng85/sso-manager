package com.insigma.mvc.dao.api.API_LOG_001_001;

import java.util.List;

import com.insigma.mvc.model.SAppLog;
import com.insigma.mvc.model.SErrorLog;
import com.insigma.mvc.model.SLog;
import com.insigma.mvc.model.SysErrorLog;


/**
 * 
 * api »’÷æ≤È—Ømapper
 * @author admin
 *
 */
public interface ApiLogQueryMapper {
	 List<SLog> queryLogList(SLog slog);
	 SLog queryLogById(String logid);
	 List<SErrorLog>  queryErrorLogList(SErrorLog sErrorLog);
	 List<SAppLog>  queryAppLogList(SAppLog sErrorLog);
	 SErrorLog queryErrorLogById(String logid);
	 SLog queryLogById2(String logid2);
	 List<SysErrorLog> querySysErrorLogList(SysErrorLog sErrorLog);
	 SysErrorLog querySysErrorLogById(String logid);
}
