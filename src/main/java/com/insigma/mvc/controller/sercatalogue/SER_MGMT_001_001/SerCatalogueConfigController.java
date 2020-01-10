package com.insigma.mvc.controller.sercatalogue.SER_MGMT_001_001;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import com.insigma.mvc.model.catalogue.ServiceConsumerType;
import com.insigma.mvc.model.catalogue.ServiceDepartment;
import com.insigma.mvc.model.catalogue.ServiceEventType;
import com.insigma.mvc.model.catalogue.ServicePowerType;
import com.insigma.mvc.service.sercatalogue.SER_MGMT_001_001.SerCatalogueConfigService;



/**
 * 服务目录配置
 * @author admin
 *
 */
@Controller
public class SerCatalogueConfigController extends MvcHelper {
	
	@Resource
	private SerCatalogueConfigService serCatalogueConfigService;
	/**
	 * 服务事项类型配置 event type
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/eventtype/index",method=RequestMethod.GET)
	public ModelAndView eventtype_index() throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/eventtype/eventTypeIndex");
        return modelAndView;
	}
	
	/**
	 * 服务事项类型配置 event type
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/eventtype/add",method=RequestMethod.GET)
	public ModelAndView eventtype_add() throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/eventtype/eventTypeAdd");
        return modelAndView;
	}
	
	/**
	 * 服务事项类型配置 event type
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/eventtype/edit/{event_type_id}",method=RequestMethod.GET)
	public ModelAndView eventtype_edit(@PathVariable String event_type_id) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/eventtype/eventTypeEdit");
		ServiceEventType serviceEventType=serCatalogueConfigService.getEventTypeById(event_type_id);
		modelAndView.addObject("serviceEventType",serviceEventType);  
        return modelAndView;
	}
	
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/eventtype/del/{event_type_id}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg eventtype_del(@PathVariable String event_type_id) throws Exception {
		  return serCatalogueConfigService.deleteEventTypeByid(event_type_id);
	}
	
	
	/**
	 * 服务事项类型列表查询
	 * @return
	 */
	@RequestMapping(value="/cata/eventtype/querylist",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String,Object> eventtype_querylist(ServiceEventType serviceeventtype) throws Exception {
		return serCatalogueConfigService.getAllEventTypeList(serviceeventtype);
	}
	
	
	/**
	 * 更新或保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/eventtype/saveorupdate",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg eventtype_saveorupdate(HttpServletRequest request,@Valid ServiceEventType serviceEventType,BindingResult result) throws Exception {
		SysUser sysuser=(SysUser)request.getSession().getAttribute("SHIRO_CURRENT_USER_INFO");
		serviceEventType.setUserid(sysuser.getUserid());
		serviceEventType.setGroupid(sysuser.getGroupid());
		serviceEventType.setEdituserid(sysuser.getUserid());
		serviceEventType.setEditgroupid(sysuser.getGroupid());
		//检验输入
		if (result.hasErrors()){
			return validate(result);
		}
		return serCatalogueConfigService.saveEventType(serviceEventType);
	}
	
	
	
	
	/**
	 * 服务事项类型配置 department
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/departmnt/index",method=RequestMethod.GET)
	public ModelAndView department_index() throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/department/departMentIndex");
        return modelAndView;
	}
	
	/**
	 * 服务事项类型列表查询
	 * @return
	 */
	@RequestMapping(value="/cata/departmnt/querylist",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String,Object> department_querylist(ServiceDepartment serviceDepartment) throws Exception {
		return serCatalogueConfigService.getAllDepartmentList(serviceDepartment);
	}
	
	/**
	 * 服务事项类型配置 event type
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/departmnt/add",method=RequestMethod.GET)
	public ModelAndView department_add() throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/department/departMentAdd");
        return modelAndView;
	}
	
	/**
	 * 服务事项类型配置 event type
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/departmnt/edit/{department_id}",method=RequestMethod.GET)
	public ModelAndView department_edit(@PathVariable String department_id) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/department/departMentEdit");
		ServiceDepartment serviceDepartment=serCatalogueConfigService.getDepartmentById(department_id);
		modelAndView.addObject("serviceDepartment",serviceDepartment);  
        return modelAndView;
	}
	
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/departmnt/del/{department_id}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg department_del(@PathVariable String department_id) throws Exception {
		  return serCatalogueConfigService.deleteDepartmentByid(department_id);
	}

	
	
	/**
	 * 更新或保存角色
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/departmnt/saveorupdate",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg department_saveorupdate(HttpServletRequest request,@Valid ServiceDepartment serviceDepartment,BindingResult result) throws Exception {
		SysUser sysuser=(SysUser)request.getSession().getAttribute("SHIRO_CURRENT_USER_INFO");
		serviceDepartment.setUserid(sysuser.getUserid());
		serviceDepartment.setGroupid(sysuser.getGroupid());
		serviceDepartment.setEdituserid(sysuser.getUserid());
		serviceDepartment.setEditgroupid(sysuser.getGroupid());
		//检验输入
		if (result.hasErrors()){
			return validate(result);
		}
		return serCatalogueConfigService.saveDepartment(serviceDepartment);
	}
	
	
	
	/**
	 * 服务事项类型配置 department
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/bustype/index",method=RequestMethod.GET)
	public ModelAndView bustype_index() throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/bustype/busTypeIndex");
        return modelAndView;
	}
	
	/**
	 * 服务事项类型列表查询
	 * @return
	 */
	@RequestMapping(value="/cata/bustype/querylist",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String,Object> bustype_querylist(ServiceBusType serviceBusType) throws Exception {
		return serCatalogueConfigService.getAllBustypeList(serviceBusType);
	}
	
	/**
	 * 服务事项类型配置 event type
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/bustype/add",method=RequestMethod.GET)
	public ModelAndView bustype_add() throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/bustype/busTypeAdd");
        return modelAndView;
	}
	
	/**
	 * 服务事项类型配置 event type
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/bustype/edit/{bus_type_id}",method=RequestMethod.GET)
	public ModelAndView bustype_edit(@PathVariable String bus_type_id) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/bustype/busTypeEdit");
		ServiceBusType serviceBustype=serCatalogueConfigService.getBustypeById(bus_type_id);
		modelAndView.addObject("serviceBustype",serviceBustype);  
        return modelAndView;
	}
	
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/bustype/del/{bus_type_id}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg bustype_del(@PathVariable String bus_type_id) throws Exception {
		  return serCatalogueConfigService.deleteBustypeByid (bus_type_id);
	}

	
	/**
	 * 更新或保存角色
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/bustype/saveorupdate",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg bustype_saveorupdate(HttpServletRequest request,@Valid ServiceBusType serviceBusType,BindingResult result) throws Exception {
		SysUser sysuser=(SysUser)request.getSession().getAttribute("SHIRO_CURRENT_USER_INFO");
		serviceBusType.setUserid(sysuser.getUserid());
		serviceBusType.setGroupid(sysuser.getGroupid());
		serviceBusType.setEdituserid(sysuser.getUserid());
		serviceBusType.setEditgroupid(sysuser.getGroupid());
		//检验输入
		if (result.hasErrors()){
			return validate(result);
		}
		return serCatalogueConfigService.saveBustype(serviceBusType);
	}
	
	
	/**
	 * 服务事项类型配置 department
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/consumertype/index",method=RequestMethod.GET)
	public ModelAndView consumertype_index() throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/consumertype/consumertypeIndex");
        return modelAndView;
	}
	
	/**
	 * 服务事项类型列表查询
	 * @return
	 */
	@RequestMapping(value="/cata/consumertype/querylist",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String,Object> consumertype_querylist(ServiceConsumerType serviceConsumerType) throws Exception {
		return serCatalogueConfigService.getAllConsumertypeList(serviceConsumerType);
	}
	
	/**
	 * 服务事项类型配置 event type
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/consumertype/add",method=RequestMethod.GET)
	public ModelAndView consumertype_add() throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/consumertype/consumertypeAdd");
        return modelAndView;
	}
	
	/**
	 * 服务事项类型配置 event type
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/consumertype/edit/{consumer_type_id}",method=RequestMethod.GET)
	public ModelAndView consumertype_edit(@PathVariable String consumer_type_id) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/consumertype/consumertypeEdit");
		ServiceConsumerType serviceConsumerType=serCatalogueConfigService.getConsumertypeById(consumer_type_id);
		modelAndView.addObject("type",serviceConsumerType);  
        return modelAndView;
	}
	
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/consumertype/del/{consumer_type_id}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg consumertype_del(@PathVariable String consumer_type_id) throws Exception {
		  return serCatalogueConfigService.deleteConsumertypeByid (consumer_type_id);
	}

	
	/**
	 * 更新或保存角色
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/consumertype/saveorupdate",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg consumertype_saveorupdate(HttpServletRequest request,@Valid ServiceConsumerType serviceConsumerType,BindingResult result) throws Exception {
		SysUser sysuser=(SysUser)request.getSession().getAttribute("SHIRO_CURRENT_USER_INFO");
		serviceConsumerType.setUserid(sysuser.getUserid());
		serviceConsumerType.setGroupid(sysuser.getGroupid());
		serviceConsumerType.setEdituserid(sysuser.getUserid());
		serviceConsumerType.setEditgroupid(sysuser.getGroupid());
		//检验输入
		if (result.hasErrors()){
			return validate(result);
		}
		return serCatalogueConfigService.saveConsumertype (serviceConsumerType);
	}
	
	
	
	/**
	 * 服务事项类型配置 department
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/powertype/index",method=RequestMethod.GET)
	public ModelAndView powertype_index() throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/powertype/powertypeIndex");
        return modelAndView;
	}
	
	/**
	 * 服务事项类型列表查询
	 * @return
	 */
	@RequestMapping(value="/cata/powertype/querylist",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String,Object> powertype_querylist(ServicePowerType servicePowerType) throws Exception {
		return serCatalogueConfigService.getAllPowertypeList(servicePowerType);
	}
	
	/**
	 * 服务事项类型配置 event type
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/powertype/add",method=RequestMethod.GET)
	public ModelAndView powertype_add() throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/powertype/powertypeAdd");
        return modelAndView;
	}
	
	/**
	 * 服务事项类型配置 event type
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/powertype/edit/{power_type_id}",method=RequestMethod.GET)
	public ModelAndView powertype_edit(@PathVariable String power_type_id) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sercatalogue/SER_MGMT_001_001/powertype/powertypeEdit");
		ServicePowerType servicePowerType=serCatalogueConfigService.getPowertypeById (power_type_id);
		modelAndView.addObject("type",servicePowerType);  
        return modelAndView;
	}
	
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/powertype/del/{power_type_id}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg powertype_del(@PathVariable String power_type_id) throws Exception {
		  return serCatalogueConfigService.deletePowertypeByid(power_type_id);
	}

	
	/**
	 * 更新或保存角色
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cata/powertype/saveorupdate",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnMsg powertype_saveorupdate(HttpServletRequest request,@Valid ServicePowerType servicePowerType,BindingResult result) throws Exception {
		SysUser sysuser=(SysUser)request.getSession().getAttribute("SHIRO_CURRENT_USER_INFO");
		servicePowerType.setUserid(sysuser.getUserid());
		servicePowerType.setGroupid(sysuser.getGroupid());
		servicePowerType.setEdituserid(sysuser.getUserid());
		servicePowerType.setEditgroupid(sysuser.getGroupid());
		//检验输入
		if (result.hasErrors()){
			return validate(result);
		}
		return serCatalogueConfigService.savePowertype (servicePowerType);
	}
	
	
}
