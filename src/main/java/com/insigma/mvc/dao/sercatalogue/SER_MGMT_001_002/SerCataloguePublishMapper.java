package com.insigma.mvc.dao.sercatalogue.SER_MGMT_001_002;

import java.util.List;

import com.insigma.mvc.model.catalogue.ServiceCatalogue;
import com.insigma.mvc.model.catalogue.ServiceCatalogueDetail;


/**
 * 服务事项发布管理
 * @author admin
 *
 */
public interface SerCataloguePublishMapper {
	
	public List<ServiceCatalogue> getCataTree(String id);
	
	public ServiceCatalogueDetail getCataDetailById(String id);
	
    public int saveCataDetail(ServiceCatalogueDetail serviceCatalogueDetail);
	
	public int updateCataDetail(ServiceCatalogueDetail serviceCatalogueDetail);
	
	public int deleteCataDetail(String id);
	
	public ServiceCatalogue getCataById(String id);
	
    public int saveCata(ServiceCatalogue serviceCatalogue);
	
	public int updateCata(ServiceCatalogue serviceCatalogue);
	
	public int deleteCata(String id);
	
}