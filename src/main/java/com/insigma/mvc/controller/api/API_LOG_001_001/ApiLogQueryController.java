package com.insigma.mvc.controller.api.API_LOG_001_001;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.insigma.mvc.model.SAppLog;
import com.insigma.mvc.model.SysErrorLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.model.SErrorLog;
import com.insigma.mvc.model.SLog;
import com.insigma.mvc.service.api.API_LOG_001_001.ApiLogQueryService;


/**
 * api  ��־��ѯ controller
 * @author admin
 *
 */
@Controller
@RequestMapping("/api/log")
public class ApiLogQueryController extends MvcHelper {
	
	Log log=LogFactory.getLog(ApiLogQueryController.class);
	
	@Resource
	private ApiLogQueryService apilogService;
	
	/**
	 * ��ת����־��ѯҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("api/API_LOG_001_001/apiLogList");
        return modelAndView;
	}
	
	/**
	 * ��ȡ��־�б�
	 * @param request
	 * @return
	 */
	@RequestMapping("/getLogList")
	@ResponseBody
	public HashMap<String,Object> getLogList(HttpServletRequest request,Model model,  SLog slog ) throws Exception {
		return apilogService.queryLogList(slog);
	}
	
	
	/**
	 * ��ת��������־��ѯҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/errorlogindex")
	public ModelAndView errorlogindex(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("api/API_LOG_001_001/apiErrorLogList");
        return modelAndView;
	}
	
	/**
	 * ��ȡ������־�б�
	 * @param request
	 * @return
	 */
	@RequestMapping("/getErrogLogList")
	@ResponseBody
	public HashMap<String,Object> getErrogLogList(HttpServletRequest request,Model model,  SErrorLog sErrorLog ) throws Exception {
		return apilogService.queryErrorLogList(sErrorLog);
	}

	/**
	 * ͨ����־��Ż�ȡ�쳣��־��ϸ��Ϣ
	 * @param request
	 * @return
	 */
	@RequestMapping("/getErrorLogById/{logid}")
	public ModelAndView getErrorLogById(HttpServletRequest request,Model model,@PathVariable String logid) throws Exception {
		ModelAndView modelAndView=new ModelAndView("api/API_LOG_001_001/apiErrorlogview");
		SErrorLog slog = apilogService.queryErrorLogById(logid);
		modelAndView.addObject("slog",slog);
		return modelAndView;
	}
	/**
	 * ��ȡ������־�б�
	 * @param request
	 * @return
	 */
	@RequestMapping("/getSysErrogLogList")
	@ResponseBody
	public HashMap<String,Object> getSysErrogLogList(HttpServletRequest request,Model model,  SysErrorLog sErrorLog ) throws Exception {
		return apilogService.querySysErrorLogList(sErrorLog);
	}

	/**
	 * ͨ����־��Ż�ȡ�쳣��־��ϸ��Ϣ
	 * @param request
	 * @return
	 */
	@RequestMapping("/getSysErrorLogById/{logid}")
	public ModelAndView getSysErrorLogById(HttpServletRequest request,Model model,@PathVariable String logid) throws Exception {
		ModelAndView modelAndView=new ModelAndView("api/API_LOG_001_001/apiErrorlogview");
		SysErrorLog slog = apilogService.querySysErrorLogById(logid);
		modelAndView.addObject("slog",slog);
		return modelAndView;
	}

	
	/**
	 * ͨ����־��Ż�ȡ��־��ϸ��Ϣ
	 * @param request
	 * @return
	 */
	@RequestMapping("/getLogById/{logid}")
	public ModelAndView getLogById(HttpServletRequest request,Model model,@PathVariable String logid) throws Exception {
		ModelAndView modelAndView=new ModelAndView("api/API_LOG_001_001/apiLogview");
		SLog slog = apilogService.queryLogById(logid);
		modelAndView.addObject("slog",slog);  
        return modelAndView;
	}
	



	/**
	 * ��תӦ�÷���
	 * @param request
	 * @return
	 */
	@RequestMapping("/applogindex")
	public ModelAndView applogindex(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("api/API_LOG_001_001/apiAppLogList");
		return modelAndView;
	}

	/**
	 * ��ȡӦ�÷�����־
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAppLogList")
	@ResponseBody
	public HashMap<String,Object> getAppLogList(HttpServletRequest request,Model model,  SAppLog sAppLog ) throws Exception {
		return apilogService.queryAppLogList(sAppLog);
	}
}
