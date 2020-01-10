package com.insigma.mvc.dao.sysmanager.login;


import java.util.List;

import com.insigma.mvc.model.SysGroup;
import com.insigma.mvc.model.SysLoginInf;
import com.insigma.mvc.model.SysPermission;
import com.insigma.mvc.model.SysRole;
import com.insigma.mvc.model.SysUser;


/**
 * 登录service接口
 * @author admin
 *
 */
public interface SysLoginMapper {
	/**
	 * 通过用户名获取会员表信息
	 * @param username
	 * @return 用户表
	 * @
	 */
	 SysUser getUserAndGroupInfo(String username);

	/**
	 * 获取当前机构的行政区划信息
	 * @param groupid
	 * @return
	 * @
	 */
	 SysGroup getGroupAreaInfo(String groupid);



	
	
	/**
	 * 通过用户id获取用户角色集合
	 * @param loginname
	 * @return 角色集合
	 * @ 
	 */
	 List<SysRole> findRolesStr(String loginname) ;
	
	
	/**
	 * 通过用户id获取用户权限集合
	 * @param loginname
	 * @return 权限集合
	 * @ 
	 */
	 List<SysPermission> findPermissionStr(String loginname) ;
	
	
	/**
	 * 保存hashinfo
	 * @param inf
	 */
	 void saveLoginHashInfo(SysLoginInf inf);
	
	
	 List<SysLoginInf> findLoginInfoByhashcode(String loginhash);

}
