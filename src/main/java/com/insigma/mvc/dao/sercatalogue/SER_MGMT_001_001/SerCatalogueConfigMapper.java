package com.insigma.mvc.dao.sercatalogue.SER_MGMT_001_001;

import java.util.List;

import com.insigma.mvc.model.catalogue.*;


/**
 * 服务目录配置管理
 * @author admin
 *
 */
public interface SerCatalogueConfigMapper {
	
	/**服务事项管理*/
	public List<ServiceEventType> getAllEventTypeList();
	
	public int saveEventType(ServiceEventType serviceEventType);
	
	public int updateEventType(ServiceEventType serviceEventType);
	
	public ServiceEventType getEventTypeById(String event_type_id);
	
	public ServiceEventType getEventTypeByCode(String event_type_code);
	
	public int deleteEventTypeByid(String event_type_id);
	
    /**受理部门管理*/
    public List<ServiceDepartment> getAllDepartmentList();
	
	public int saveDepartment(ServiceDepartment ServiceDepartment);
	
	public int updateDepartment(ServiceDepartment ServiceDepartment);
	
	public ServiceDepartment getDepartmentById(String department_id);
	
	public int deleteDepartmentByid(String department_id);
	
	
	 /**业务分类管理*/
    public List<ServiceBusType> getAllBustypeList();
	
	public int saveBustype(ServiceBusType serviceBusType);
	
	public int updateBustype(ServiceBusType serviceBusType);
	
	public ServiceBusType getBustypeById(String bus_type_id);
	
	public int deleteBustypeByid(String bus_type_id);
	
	
	 /**服务对象管理*/
    public List<ServiceConsumerType> getAllConsumertypeList();
	
	public int saveConsumertype(ServiceConsumerType serviceConsumerType);
	
	public int updateConsumertype(ServiceConsumerType serviceConsumerType);
	
	public ServiceConsumerType getConsumertypeById(String consumer_type_id);
	
	public int deleteConsumertypeByid(String consumer_type_id);
	
	
	 /**权力类型*/
    public List<ServicePowerType> getAllPowertypeList();
	
	public int savePowertype(ServicePowerType servicePowerType);
	
	public int updatePowertype(ServicePowerType servicePowerType);
	
	public ServicePowerType getPowertypeById(String power_type_id);
	
	public int deletePowertypeByid(String power_type_id);


}
