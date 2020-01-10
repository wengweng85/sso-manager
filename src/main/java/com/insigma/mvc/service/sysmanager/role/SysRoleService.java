package com.insigma.mvc.service.sysmanager.role;

import java.util.HashMap;
import java.util.List;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.SysRole;




/**
 * 管理功能之权限管理service
 * @author admin
 *
 */
public interface SysRoleService {
	
     HashMap<String,Object>  getAllRoleList( SysRole role);
	
	 AjaxReturnMsg getRoleDataById(String id);
	
	 SysRole getRoleById(String id);
	
	 AjaxReturnMsg saveOrUpdateRoleData(SysRole srole);
	
	 AjaxReturnMsg deleteRoleDataById(String id);
	
	 List<SysRole> getRolePermTreeData(String roleid);
	
	 AjaxReturnMsg saveRolePermData(SysRole srole);

}
