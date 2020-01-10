package com.insigma.mvc.service.sysmanager.userrole;

import java.util.HashMap;
import java.util.List;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.SysGroup;
import com.insigma.mvc.model.SysRole;
import com.insigma.mvc.model.SysUser;




/**
 * 管理功能之权限管理service
 * @author admin
 *
 */
public interface SysUserRoleService {
	
     List<SysGroup>  getAllGroupList(String parentid);
    
     AjaxReturnMsg getGroupDataById(String groupid);
	
	 HashMap<String,Object> getUserListByGroupid(SysGroup sgroup);
	
	 HashMap<String,Object> getUserRoleByUserId(SysRole srole);
	
	 AjaxReturnMsg saveUserRole(SysRole srole);
	
	 AjaxReturnMsg saveAddSysUser(SysUser suser);
	
	 AjaxReturnMsg saveAddSysAgency(SysGroup sgroup);
	
	 AjaxReturnMsg deleteSysAgency(String groupid);
	
}
