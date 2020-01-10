package com.insigma.mvc.serviceimp.sercatalogue.SER_MGMT_001_001;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.dao.sercatalogue.SER_MGMT_001_001.SerCatalogueConfigMapper;
import com.insigma.mvc.model.catalogue.ServiceBusType;
import com.insigma.mvc.model.catalogue.ServiceConsumerType;
import com.insigma.mvc.model.catalogue.ServiceDepartment;
import com.insigma.mvc.model.catalogue.ServiceEventType;
import com.insigma.mvc.model.catalogue.ServicePowerType;
import com.insigma.mvc.service.sercatalogue.SER_MGMT_001_001.SerCatalogueConfigService;

/**
 *服务目录配置管理
 * @author admin
 *
 */
@Service
@Transactional
public class SerCatalogueConfigServiceImpl  extends MvcHelper  implements SerCatalogueConfigService {

	Log log = LogFactory.getLog(SerCatalogueConfigServiceImpl.class);

	@Resource
	private SerCatalogueConfigMapper serCatalogueConfigMapper;
		
	@Override
	public HashMap<String,Object> getAllEventTypeList( ServiceEventType serviceEventType) {
		PageHelper.offsetPage(serviceEventType.getOffset(), serviceEventType.getLimit());
		List<ServiceEventType> list=serCatalogueConfigMapper.getAllEventTypeList();
		PageInfo<ServiceEventType> pageinfo = new PageInfo<ServiceEventType>(list);
		return this.success_hashmap_response (pageinfo);
	}

	@Override
	public AjaxReturnMsg saveEventType(ServiceEventType serviceEventType) {
		//新增
		if(StringUtils.isEmpty(serviceEventType.getEvent_type_id())){
			 if(serCatalogueConfigMapper.getEventTypeByCode(serviceEventType.getEvent_type_code())==null){
				 serCatalogueConfigMapper.saveEventType(serviceEventType);
				 return this.success("新增成功");
			 }else{
				 return this.error("已经存在事项编号为"+serviceEventType.getEvent_type_code()+"的事项,不能重复");
			 }
		}else{
			serCatalogueConfigMapper.updateEventType(serviceEventType);
			return this.success("更新成功");
		}
	}

	@Override
	public ServiceEventType getEventTypeById(String event_type_id) {
		return serCatalogueConfigMapper.getEventTypeById(event_type_id);
	}

	@Override
	public AjaxReturnMsg deleteEventTypeByid(String event_type_id) {
		int deletenum=serCatalogueConfigMapper.deleteEventTypeByid(event_type_id);
		if(deletenum==1){
			return this.success("删除成功");
		}else{
			return this.success("删除失败");
		}
	}

	
	@Override
	public HashMap<String,Object> getAllDepartmentList( ServiceDepartment serviceDepartment) {
		PageHelper.offsetPage(serviceDepartment.getOffset(), serviceDepartment.getLimit());
		List<ServiceDepartment> list=serCatalogueConfigMapper.getAllDepartmentList();
		PageInfo<ServiceDepartment> pageinfo = new PageInfo<ServiceDepartment>(list);
		return this.success_hashmap_response (pageinfo);
	}

	@Override
	public AjaxReturnMsg saveDepartment(ServiceDepartment serviceDepartment) {
		//新增
		if(StringUtils.isEmpty(serviceDepartment.getDepartment_id())){
				 serCatalogueConfigMapper.saveDepartment(serviceDepartment);
				 return this.success("新增成功");
		}else{
			serCatalogueConfigMapper.updateDepartment(serviceDepartment);
			return this.success("更新成功");
		}
	}

	@Override
	public ServiceDepartment getDepartmentById(String department_id) {
		return serCatalogueConfigMapper.getDepartmentById(department_id);
	}

	@Override
	public AjaxReturnMsg deleteDepartmentByid(String department_id) {
		int deletenum=serCatalogueConfigMapper.deleteDepartmentByid(department_id);
		if(deletenum==1){
			return this.success("删除成功");
		}else{
			return this.success("删除失败");
		}
	}
	
	
	@Override
	public HashMap<String,Object> getAllBustypeList( ServiceBusType serviceBusType) {
		PageHelper.offsetPage(serviceBusType.getOffset(), serviceBusType.getLimit());
		List<ServiceBusType> list=serCatalogueConfigMapper.getAllBustypeList();
		PageInfo<ServiceBusType> pageinfo = new PageInfo<ServiceBusType>(list);
		return this.success_hashmap_response (pageinfo);
	}

	@Override
	public AjaxReturnMsg saveBustype(ServiceBusType serviceBusType) {
		//新增
		if(StringUtils.isEmpty(serviceBusType.getBus_type_id())){
				 serCatalogueConfigMapper.saveBustype(serviceBusType);
				 return this.success("新增成功");
		}else{
			serCatalogueConfigMapper.updateBustype(serviceBusType);
			return this.success("更新成功");
		}
	}

	@Override
	public ServiceBusType getBustypeById(String department_id) {
		return serCatalogueConfigMapper.getBustypeById(department_id);
	}

	@Override
	public AjaxReturnMsg deleteBustypeByid(String department_id) {
		int deletenum=serCatalogueConfigMapper.deleteBustypeByid(department_id);
		if(deletenum==1){
			return this.success("删除成功");
		}else{
			return this.success("删除失败");
		}
	}

	@Override
	public HashMap<String, Object> getAllConsumertypeList(ServiceConsumerType serviceConsumerType) {
		PageHelper.offsetPage(serviceConsumerType.getOffset(), serviceConsumerType.getLimit());
		List<ServiceConsumerType> list=serCatalogueConfigMapper.getAllConsumertypeList();
		PageInfo<ServiceConsumerType> pageinfo = new PageInfo<ServiceConsumerType>(list);
		return this.success_hashmap_response (pageinfo);
	}

	@Override
	public AjaxReturnMsg saveConsumertype( ServiceConsumerType serviceConsumerType) {
		if(StringUtils.isEmpty(serviceConsumerType.getConsumer_type_id())){
			 serCatalogueConfigMapper.saveConsumertype(serviceConsumerType);
			 return this.success("新增成功");
	}else{
		serCatalogueConfigMapper.updateConsumertype(serviceConsumerType);
		return this.success("更新成功");
	}
	}

	@Override
	public ServiceConsumerType getConsumertypeById(String consumer_type_id) {
		return serCatalogueConfigMapper.getConsumertypeById(consumer_type_id);
	}

	@Override
	public AjaxReturnMsg deleteConsumertypeByid(String consumer_type_id) {
		int deletenum=serCatalogueConfigMapper.deleteConsumertypeByid(consumer_type_id);
		if(deletenum==1){
			return this.success("删除成功");
		}else{
			return this.success("删除失败");
		}
	}

	@Override
	public HashMap<String, Object> getAllPowertypeList( ServicePowerType servicePowerType) {
		// TODO Auto-generated method stub
		PageHelper.offsetPage(servicePowerType.getOffset(), servicePowerType.getLimit());
		List<ServicePowerType> list=serCatalogueConfigMapper.getAllPowertypeList();
		PageInfo<ServicePowerType> pageinfo = new PageInfo<ServicePowerType>(list);
		return this.success_hashmap_response (pageinfo);
	}

	@Override
	public AjaxReturnMsg savePowertype(ServicePowerType servicePowerType) {
		//新增
		if(StringUtils.isEmpty(servicePowerType.getPower_type_id())){
				 serCatalogueConfigMapper.savePowertype(servicePowerType);
				 return this.success("新增成功");
		}else{
			serCatalogueConfigMapper.updatePowertype(servicePowerType);
			return this.success("更新成功");
		}
	}

	@Override
	public ServicePowerType getPowertypeById(String power_type_id) {
		return serCatalogueConfigMapper.getPowertypeById(power_type_id);
	}

	@Override
	public AjaxReturnMsg deletePowertypeByid(String power_type_id) {
		int deletenum=serCatalogueConfigMapper.deletePowertypeByid(power_type_id);
		if(deletenum==1){
			return this.success("删除成功");
		}else{
			return this.success("删除失败");
		}
	}

	

}