package com.insigma.mvc.service.WEBPERM_001_001.userrole;

import java.util.HashMap;
import java.util.List;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.SGroup;
import com.insigma.mvc.model.SRole;
import com.insigma.mvc.model.SUser;




/**
 * 管理功能之权限管理service
 * @author admin
 *
 */
public interface WebUserRoleService {
	
    public List<SGroup>  getAllGroupList(String parentid);
    
    public HashMap<String,Object> getGroupListByType(SGroup sGroup); 
    
    public AjaxReturnMsg getGroupDataById(String groupid);
	
	public HashMap<String,Object> getUserListByGroupid(SGroup sgroup);
	
	public HashMap<String,Object> getUserRoleByUserId(SRole srole);
	
	public AjaxReturnMsg saveUserRole(SRole srole);
	
	public AjaxReturnMsg saveSUser(SUser suser);
	
	public AjaxReturnMsg saveSUserAndGroupRef(SUser suser);
	
	public AjaxReturnMsg saveUserRoleRef(SRole srole);
	
	public AjaxReturnMsg passReset(SUser suer);
	
}
