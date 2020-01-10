package com.insigma.mvc.dao.sercatalogue.SER_MGMT_001_001;

import java.util.List;

import com.insigma.mvc.model.catalogue.*;


/**
 * ����Ŀ¼���ù���
 * @author admin
 *
 */
public interface SerCatalogueConfigMapper {
	
	/**�����������*/
	public List<ServiceEventType> getAllEventTypeList();
	
	public int saveEventType(ServiceEventType serviceEventType);
	
	public int updateEventType(ServiceEventType serviceEventType);
	
	public ServiceEventType getEventTypeById(String event_type_id);
	
	public ServiceEventType getEventTypeByCode(String event_type_code);
	
	public int deleteEventTypeByid(String event_type_id);
	
    /**�����Ź���*/
    public List<ServiceDepartment> getAllDepartmentList();
	
	public int saveDepartment(ServiceDepartment ServiceDepartment);
	
	public int updateDepartment(ServiceDepartment ServiceDepartment);
	
	public ServiceDepartment getDepartmentById(String department_id);
	
	public int deleteDepartmentByid(String department_id);
	
	
	 /**ҵ��������*/
    public List<ServiceBusType> getAllBustypeList();
	
	public int saveBustype(ServiceBusType serviceBusType);
	
	public int updateBustype(ServiceBusType serviceBusType);
	
	public ServiceBusType getBustypeById(String bus_type_id);
	
	public int deleteBustypeByid(String bus_type_id);
	
	
	 /**����������*/
    public List<ServiceConsumerType> getAllConsumertypeList();
	
	public int saveConsumertype(ServiceConsumerType serviceConsumerType);
	
	public int updateConsumertype(ServiceConsumerType serviceConsumerType);
	
	public ServiceConsumerType getConsumertypeById(String consumer_type_id);
	
	public int deleteConsumertypeByid(String consumer_type_id);
	
	
	 /**Ȩ������*/
    public List<ServicePowerType> getAllPowertypeList();
	
	public int savePowertype(ServicePowerType servicePowerType);
	
	public int updatePowertype(ServicePowerType servicePowerType);
	
	public ServicePowerType getPowertypeById(String power_type_id);
	
	public int deletePowertypeByid(String power_type_id);


}
