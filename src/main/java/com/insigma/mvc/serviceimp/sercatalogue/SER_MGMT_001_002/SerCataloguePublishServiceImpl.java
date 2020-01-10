package com.insigma.mvc.serviceimp.sercatalogue.SER_MGMT_001_002;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.dao.sercatalogue.SER_MGMT_001_002.SerCataloguePublishMapper;
import com.insigma.mvc.model.catalogue.ServiceCatalogue;
import com.insigma.mvc.model.catalogue.ServiceCatalogueDetail;
import com.insigma.mvc.service.sercatalogue.SER_MGMT_001_002.SerCataloguePublishService;
import com.insigma.mvc.serviceimp.sercatalogue.SER_MGMT_001_001.SerCatalogueConfigServiceImpl;

/**
 * 服务事项发布管理
 *
 */
@Service
@Transactional
public class SerCataloguePublishServiceImpl  extends MvcHelper  implements SerCataloguePublishService {

	Log log = LogFactory.getLog(SerCatalogueConfigServiceImpl.class);

	@Resource
	private SerCataloguePublishMapper serCataloguePublishMapper;

	@Override
	public List<ServiceCatalogue> getCataTree(String id) {
		return serCataloguePublishMapper.getCataTree(id);
	}

	@Override
	public ServiceCatalogueDetail getCataDetailById(String id) {
		return serCataloguePublishMapper.getCataDetailById(id);
	}

	@Override
	public ServiceCatalogue getCataById(String id) {
		return serCataloguePublishMapper.getCataById(id);
	}

	@Override
	public AjaxReturnMsg saveCataDetail(ServiceCatalogueDetail serviceCatalogueDetail) {
		if(StringUtils.isEmpty(serviceCatalogueDetail.getCata_detail_id())){
			     serCataloguePublishMapper.saveCataDetail(serviceCatalogueDetail);
				 return this.success("新增成功");
		}else{
			    serCataloguePublishMapper.updateCataDetail(serviceCatalogueDetail);
			    return this.success("更新成功");
		}
	}

	@Override
	public AjaxReturnMsg saveCata(ServiceCatalogue serviceCatalogue) {
		if(StringUtils.isEmpty(serviceCatalogue.getCata_id())){
		     serCataloguePublishMapper.saveCata(serviceCatalogue);
			 return this.success("新增成功");
		}else{
			    serCataloguePublishMapper.updateCata(serviceCatalogue);
			    return this.success("更新成功");
		}
	}

	@Override
	public AjaxReturnMsg deleteCata(String id) {
		  serCataloguePublishMapper.deleteCata(id);
		  return this.success("删除成功");
	}

	@Override
	public AjaxReturnMsg deleteCataDetail(String id) {
		serCataloguePublishMapper.deleteCataDetail(id);
		  return this.success("删除成功");
	}

}