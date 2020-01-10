package com.insigma.mvc.service.sysmanager.perm;

import java.util.List;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.SysPermission;




/**
 * 管理功能之权限管理service
 * @author admin
 *
 */
public interface SysPermService {
	
	 List<SysPermission>  getPermTreeList();
	
	 AjaxReturnMsg getPermDataById(String id);
	
	 AjaxReturnMsg saveOrUpdatePermData(SysPermission spermission);
	
     AjaxReturnMsg getPermListDataByParentid(String parentid);
	
	 AjaxReturnMsg deletePermDataById(String id);
	
	 AjaxReturnMsg batdeletePermData(SysPermission spermission);
	
	 AjaxReturnMsg<String> moveNode(String id);

}
