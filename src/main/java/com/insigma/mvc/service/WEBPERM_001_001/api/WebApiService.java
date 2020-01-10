package com.insigma.mvc.service.WEBPERM_001_001.api;

import com.insigma.dto.AjaxReturnMsg;




/**
 * web项目用户及角色api
 * @author admin
 *
 */
public interface WebApiService {
	
	//增加用户并绑定关系
	public AjaxReturnMsg addUser(String groupid,String username,String password);
    //绑定用户与机构关系
	public AjaxReturnMsg addUserAndGroupref(String groupid,String userid);
    //绑定用户与角色关系
	public AjaxReturnMsg addUserAndRoleRef(String userid,String rolecode);
	
}
