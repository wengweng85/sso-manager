package com.insigma.mvc.controller.sercatalogue.SER_MGMT_001_002;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.model.SysUser;
import com.insigma.mvc.model.catalogue.ServiceBusType;
import com.insigma.mvc.model.catalogue.ServiceCatalogue;
import com.insigma.mvc.model.catalogue.ServiceCatalogueDetail;
import com.insigma.mvc.service.sercatalogue.SER_MGMT_001_001.SerCatalogueConfigService;
import com.insigma.mvc.service.sercatalogue.SER_MGMT_001_002.SerCataloguePublishService;
import com.insigma.resolver.AppException;


/**
 * 服务目录发布管理
 * @author admin
 *
 */
@Controller
public class SerCataloguePublishController extends MvcHelper {
	
	
	@Resource
	private SerCataloguePublishService serCataloguePublishService;
	
	@Resource
	private SerCatalogueConfigService serCatalogueConfigService;
	
	/**
	 * 服务事项类型配置 event type
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/publish/index",method=RequestMethod.GET)
	public ModelAndView eventtype_index() throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_002/cata/cataIndex");
        return modelAndView;
	}
	
	/**
	 * 服务事项树
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws com.insigma.resolver.AppException
	 */
	@RequestMapping(value = "/cata/publish/treedata")
	@ResponseBody
	public List<ServiceCatalogue> treedata(HttpServletRequest request) throws AppException {
		String id=request.getParameter("id");
		if(StringUtils.isEmpty(id)){
			id="0";
		}
		return serCataloguePublishService.getCataTree(id);
	}
	

	/**
	 * 服务事项
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/publish/add/{bus_type_id}",method=RequestMethod.GET)
	public ModelAndView cata_add(@PathVariable String bus_type_id) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_002/cata/cataAdd");
		ServiceBusType serviceBusType=serCatalogueConfigService.getBustypeById(bus_type_id);
		modelAndView.addObject("bustype",serviceBusType);  
        return modelAndView;
	}
	
	/**
	 * 服务事项
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/publish/edit/{cata_id}",method=RequestMethod.GET)
	public ModelAndView cata_edit(@PathVariable String cata_id) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_002/cata/cataEdit");
		ServiceCatalogue serviceCatalogue=serCataloguePublishService.getCataById(cata_id);
		modelAndView.addObject("cata",serviceCatalogue);  
        return modelAndView;
	}
	
	/**
	 * 更新或保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/publish/saveorupdate",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg cata_saveorupdate(HttpServletRequest request,@Valid ServiceCatalogue serviceCatalogue,BindingResult result) throws Exception {
		SysUser sysuser=(SysUser)request.getSession().getAttribute("SHIRO_CURRENT_USER_INFO");
		serviceCatalogue.setUserid(sysuser.getUserid());
		serviceCatalogue.setGroupid(sysuser.getGroupid());
		serviceCatalogue.setEdituserid(sysuser.getUserid());
		serviceCatalogue.setEditgroupid(sysuser.getGroupid());
		//检验输入
		if (result.hasErrors()){
			return validate(result);
		}
		return serCataloguePublishService.saveCata(serviceCatalogue);
	}
	
	
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/publish/delete/{cata_id}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg cata_delete(@PathVariable String cata_id) throws Exception {
		return serCataloguePublishService.deleteCata(cata_id);
	}

	/**
	 * 服务事项明细编辑页面跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/publish/detail/add/{cata_id}",method=RequestMethod.GET)
	public ModelAndView cata_detail_add(@PathVariable String cata_id) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_002/cata/cataDetailAdd");
		ServiceCatalogue serviceCatalogue=serCataloguePublishService.getCataById(cata_id);
		modelAndView.addObject("cata",serviceCatalogue);  
        return modelAndView;
	}
	
	/**
	 * 服务事项明细编辑页面跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/publish/detail/edit/{detail_id}",method=RequestMethod.GET)
	public ModelAndView cata_detail_edit(@PathVariable String detail_id) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_002/cata/cataDetailEdit");
		ServiceCatalogueDetail serviceCatalogueDetail=serCataloguePublishService.getCataDetailById(detail_id);
		modelAndView.addObject("catadetail",serviceCatalogueDetail);  
        return modelAndView;
	}
	
	/**
	 * 更新或保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/publish/detail/saveorupdate",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg catadetail_saveorupdate(HttpServletRequest request,@Valid ServiceCatalogueDetail serviceCatalogueDetail,BindingResult result) throws Exception {
		SysUser sysuser=(SysUser)request.getSession().getAttribute("SHIRO_CURRENT_USER_INFO");
		serviceCatalogueDetail.setUserid(sysuser.getUserid());
		serviceCatalogueDetail.setGroupid(sysuser.getGroupid());
		serviceCatalogueDetail.setEdituserid(sysuser.getUserid());
		serviceCatalogueDetail.setEditgroupid(sysuser.getGroupid());
		//检验输入
		if (result.hasErrors()){
			return validate(result);
		}
		return serCataloguePublishService.saveCataDetail(serviceCatalogueDetail);
	}
	
	
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/publish/detail/delete/{cata_detail_id}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg cata_detail_delete(@PathVariable String cata_detail_id) throws Exception {
		return serCataloguePublishService.deleteCataDetail(cata_detail_id);
	}
}
