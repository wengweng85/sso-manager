package com.insigma.mvc.service.sercatalogue.SER_MGMT_001_001;

import java.util.HashMap;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.catalogue.ServiceBusType;
import com.insigma.mvc.model.catalogue.ServiceConsumerType;
import com.insigma.mvc.model.catalogue.ServiceDepartment;
import com.insigma.mvc.model.catalogue.ServiceEventType;
import com.insigma.mvc.model.catalogue.ServicePowerType;


/**
 * ����Ŀ¼���ù���
 * @author admin
 *
 */
public interface SerCatalogueConfigService {
	
	public HashMap<String,Object>  getAllEventTypeList(ServiceEventType serviceEventType);
	
	public AjaxReturnMsg saveEventType(ServiceEventType serviceEventType);
	
	public ServiceEventType getEventTypeById(String event_type_id);
	
	public AjaxReturnMsg deleteEventTypeByid(String event_type_id);
	
	/**�����Ź���*/
    public HashMap<String,Object>  getAllDepartmentList(ServiceDepartment serviceDepartment);
	
	public AjaxReturnMsg saveDepartment(ServiceDepartment serviceEventType);
	
	public ServiceDepartment getDepartmentById(String department_id);
	
	public AjaxReturnMsg deleteDepartmentByid(String department_id);
	
	
	 /**ҵ��������*/
    public HashMap<String,Object> getAllBustypeList(ServiceBusType serviceBusType);
	
	public AjaxReturnMsg saveBustype(ServiceBusType serviceBusType);
	
	public ServiceBusType getBustypeById(String bus_type_id);
	
	public AjaxReturnMsg deleteBustypeByid(String bus_type_id);
	
	
	 /**����������*/
    public HashMap<String,Object> getAllConsumertypeList(ServiceConsumerType serviceConsumerType);
	
	public AjaxReturnMsg saveConsumertype(ServiceConsumerType serviceConsumerType);
	
	public ServiceConsumerType getConsumertypeById(String consumer_type_id);
	
	public AjaxReturnMsg deleteConsumertypeByid(String consumer_type_id);
	
	
	 /**Ȩ�����͹���*/
    public HashMap<String,Object> getAllPowertypeList(ServicePowerType servicePowerType);
	
	public AjaxReturnMsg savePowertype(ServicePowerType servicePowerType);
	
	public ServicePowerType getPowertypeById(String power_type_id);
	
	public AjaxReturnMsg deletePowertypeByid(String power_type_id);
	

}
