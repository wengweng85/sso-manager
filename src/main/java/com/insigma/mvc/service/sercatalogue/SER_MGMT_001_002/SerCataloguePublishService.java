package com.insigma.mvc.service.sercatalogue.SER_MGMT_001_002;

import java.util.List;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.catalogue.ServiceCatalogue;
import com.insigma.mvc.model.catalogue.ServiceCatalogueDetail;



/**
 * 服务事项发布管理
 * @author admin
 *
 */
public interface SerCataloguePublishService {

	public List<ServiceCatalogue> getCataTree(String id);
	
	public ServiceCatalogueDetail getCataDetailById(String id);
	
	public AjaxReturnMsg saveCataDetail(ServiceCatalogueDetail serviceCatalogueDetail);
		
	public ServiceCatalogue getCataById(String id);
	
    public AjaxReturnMsg saveCata(ServiceCatalogue serviceCatalogue);
    
	public AjaxReturnMsg deleteCata(String id);
	
	public AjaxReturnMsg deleteCataDetail(String id);

}
