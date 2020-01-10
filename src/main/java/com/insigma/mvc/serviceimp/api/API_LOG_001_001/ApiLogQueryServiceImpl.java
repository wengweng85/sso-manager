package com.insigma.mvc.serviceimp.api.API_LOG_001_001;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.insigma.mvc.model.SAppLog;
import com.insigma.mvc.model.SysErrorLog;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.dao.api.API_LOG_001_001.ApiLogQueryMapper;
import com.insigma.mvc.model.SErrorLog;
import com.insigma.mvc.model.SLog;
import com.insigma.mvc.service.api.API_LOG_001_001.ApiLogQueryService;

/**
 * 
 * api »’÷æ≤È—Ø
 * @author admin
 *
 */

@Service
public class ApiLogQueryServiceImpl extends MvcHelper implements ApiLogQueryService {

	
	@Resource
	private ApiLogQueryMapper apilogMapper;


	@Override
	public HashMap<String, Object> queryLogList(SLog slog) {
		PageHelper.offsetPage(slog.getOffset(), slog.getLimit());
		List<SLog> list=apilogMapper.queryLogList(slog);
		PageInfo<SLog> pageinfo = new PageInfo<SLog>(list);
		return this.success_hashmap_response(pageinfo);
	}


	@Override
	public HashMap<String, Object> queryErrorLogList(SErrorLog sErrorLog) {
		// TODO Auto-generated method stub
		PageHelper.offsetPage(sErrorLog.getOffset(), sErrorLog.getLimit());
		List<SErrorLog> list=apilogMapper.queryErrorLogList(sErrorLog);
		PageInfo<SErrorLog> pageinfo = new PageInfo<SErrorLog>(list);
		return this.success_hashmap_response(pageinfo);
	}

	@Override
	public HashMap<String, Object> queryAppLogList(SAppLog sAppLog) {
		PageHelper.offsetPage(sAppLog.getOffset(), sAppLog.getLimit());
		List<SAppLog> list=apilogMapper.queryAppLogList(sAppLog);
		PageInfo<SAppLog> pageinfo = new PageInfo<SAppLog>(list);
		return this.success_hashmap_response(pageinfo);
	}


	@Override
	public SLog queryLogById(String logid) {
		// TODO Auto-generated method stub
		return apilogMapper.queryLogById(logid);
	}


	@Override
	public SErrorLog queryErrorLogById(String logid) {
		// TODO Auto-generated method stub
		return apilogMapper.queryErrorLogById(logid);
	}

	@Override
	public HashMap<String, Object> querySysErrorLogList(SysErrorLog sErrorLog) {
		// TODO Auto-generated method stub
		PageHelper.offsetPage(sErrorLog.getOffset(), sErrorLog.getLimit());
		List<SysErrorLog> list=apilogMapper.querySysErrorLogList(sErrorLog);
		PageInfo<SysErrorLog> pageinfo = new PageInfo<SysErrorLog>(list);
		return this.success_hashmap_response(pageinfo);
	}

	@Override
	public SysErrorLog querySysErrorLogById(String logid) {
		// TODO Auto-generated method stub
		return apilogMapper.querySysErrorLogById(logid);
	}

	
}