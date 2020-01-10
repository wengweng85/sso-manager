package com.insigma.mvc.dao.WEBPERM_001_001.userrole;

import java.util.List;

import com.insigma.mvc.model.SGroup;
import com.insigma.mvc.model.SRole;
import com.insigma.mvc.model.SUser;


/**
 * 管理功能之机构、用户角色管理
 * @author admin
 *
 */
public interface WebUserRoleMapper {
	
	public List<SGroup> getAllGroupList(String parentid);
	
	public SGroup getGroupDataById(String groupid);
	
	public List<SGroup> getGroupListByType(String grouptype);
	
	public List<SUser> getUserListByGroupid(String groupid);
	
	public List<SRole> getUserRoleByUserId(String userid);
	
	public int deleteUserRoleByUserId(String userid);
	
	public int saveUserRole(SRole srole);
	
	public int saveSUserInfo(SUser suser);
	
	public int saveSGroupUser(SUser suser);
	
	public SUser getSUserInfoById(String username);
	
	public int passReset(SUser suser);
	
}
