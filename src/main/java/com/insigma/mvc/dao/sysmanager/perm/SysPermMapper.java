package com.insigma.mvc.dao.sysmanager.perm;

import java.util.List;

import com.insigma.mvc.model.SysPermission;


/**
 * 管理功能之权限管理
 * @author admin
 *
 */
public interface SysPermMapper {
	
	 List<SysPermission> getPermTreeList();
	
	 SysPermission getPermDataById(String id);
	
	 SysPermission isPermCodeExist(SysPermission spermission);
	
	 SysPermission isPermUrlExist(SysPermission spermission);
	
	 int savePermissionData(SysPermission spermission);
	
	 int updatePermissionData(SysPermission spermission);
	
	 List<SysPermission> getPermListDataByParentid(String parentid);
	
	 int deletePermDataById(String id);
	
	 int batdeletePermData(String []  ids);
	
	

}
