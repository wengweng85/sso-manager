package com.insigma.mvc.controller.WEBPERM_001_001.systype;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.model.SSysType;
import com.insigma.mvc.service.WEBPERM_001_001.systype.WebSystypeService;


/**
 * 公共服务网子系统类型管理
 * @author admin
 *
 */
@Controller
@RequestMapping("/web/systype")
public class WebSystypeController extends MvcHelper {
	
	
	@Resource
	private WebSystypeService websystypeservice;
	
	/**
	 * 跳转至查询页面
	 * @systype request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("webperm/WEBPERM_001_001/systype/webSysTypeIndex");
        return modelAndView;
	}
	
	
	/**
	 * 获取参数列表
	 * @systype request
	 * @return
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public HashMap<String,Object> getList(HttpServletRequest request,Model model,SSysType ssystype  ) throws Exception {
			return websystypeservice.getPageList(ssystype);
	}
	
	
	/**
	 * 参数更新
	 * @systype request
	 * @return
	 */
	@RequestMapping("/updatesystype")
	@ResponseBody
	public AjaxReturnMsg<String> updatesystype(HttpServletRequest request,Model mode,SSysType ssystype) throws Exception {
		return websystypeservice.updateSystype(ssystype);
		
	}
	
	/**
	 * 根据参数id删除参数信息
	 * @systype request
	 * @return
	 */
	@RequestMapping("/deletesystypebyid/{systypeid}")
	@ResponseBody
	public AjaxReturnMsg<String> deletesystypebyid(HttpServletRequest request,Model mode,@PathVariable String  systypeid) throws Exception {
		return websystypeservice.deleteSystypebyId(systypeid);
	}
	

}
