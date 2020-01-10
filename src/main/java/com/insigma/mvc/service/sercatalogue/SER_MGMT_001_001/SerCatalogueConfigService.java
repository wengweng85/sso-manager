package com.insigma.mvc.service.sercatalogue.SER_MGMT_001_001;

import java.util.HashMap;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.catalogue.ServiceBusType;
import com.insigma.mvc.model.catalogue.ServiceConsumerType;
import com.insigma.mvc.model.catalogue.ServiceDepartment;
import com.insigma.mvc.model.catalogue.ServiceEventType;
import com.insigma.mvc.model.catalogue.ServicePowerType;


/**
 * 服务目录配置管理
 * @author admin
 *
 */
public interface SerCatalogueConfigService {
	
	public HashMap<String,Object>  getAllEventTypeList(ServiceEventType serviceEventType);
	
	public AjaxReturnMsg saveEventType(ServiceEventType serviceEventType);
	
	public ServiceEventType getEventTypeById(String event_type_id);
	
	public AjaxReturnMsg deleteEventTypeByid(String event_type_id);
	
	/**受理部门管理*/
    public HashMap<String,Object>  getAllDepartmentList(ServiceDepartment serviceDepartment);
	
	public AjaxReturnMsg saveDepartment(ServiceDepartment serviceEventType);
	
	public ServiceDepartment getDepartmentById(String department_id);
	
	public AjaxReturnMsg deleteDepartmentByid(String department_id);
	
	
	 /**业务分类管理*/
    public HashMap<String,Object> getAllBustypeList(ServiceBusType serviceBusType);
	
	public AjaxReturnMsg saveBustype(ServiceBusType serviceBusType);
	
	public ServiceBusType getBustypeById(String bus_type_id);
	
	public AjaxReturnMsg deleteBustypeByid(String bus_type_id);
	
	
	 /**服务对象管理*/
    public HashMap<String,Object> getAllConsumertypeList(ServiceConsumerType serviceConsumerType);
	
	public AjaxReturnMsg saveConsumertype(ServiceConsumerType serviceConsumerType);
	
	public ServiceConsumerType getConsumertypeById(String consumer_type_id);
	
	public AjaxReturnMsg deleteConsumertypeByid(String consumer_type_id);
	
	
	 /**权力类型管理*/
    public HashMap<String,Object> getAllPowertypeList(ServicePowerType servicePowerType);
	
	public AjaxReturnMsg savePowertype(ServicePowerType servicePowerType);
	
	public ServicePowerType getPowertypeById(String power_type_id);
	
	public AjaxReturnMsg deletePowertypeByid(String power_type_id);
	

}
