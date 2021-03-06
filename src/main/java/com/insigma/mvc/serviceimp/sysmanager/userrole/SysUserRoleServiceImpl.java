package com.insigma.mvc.serviceimp.sysmanager.userrole;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insigma.common.util.MD5Util;
import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.dao.sysmanager.userrole.SysUserRoleMapper;
import com.insigma.mvc.model.SysGroup;
import com.insigma.mvc.model.SysRole;
import com.insigma.mvc.model.SysUser;
import com.insigma.mvc.service.sysmanager.userrole.SysUserRoleService;

/**
 * 用户角色管理
 * @author admin
 *
 */
@Service
public class SysUserRoleServiceImpl extends MvcHelper implements SysUserRoleService {

	@Resource
    private SysUserRoleMapper sysUserRoleMapper;
	
	/**
	 * 获取机构信息树
	 */
	@Override
	public List<SysGroup> getAllGroupList(String parentid) {
		return sysUserRoleMapper.getAllGroupList(parentid);
	}
	
	
	/**
	 * 获取机构信息
	 */
	@Override
	public AjaxReturnMsg getGroupDataById(String groupid) {
		return this.success(sysUserRoleMapper.getGroupDataById(groupid));
	}
	
	
	/**
	 * 获取机构下人员信息
	 */
	@Override
	public HashMap<String,Object> getUserListByGroupid(SysGroup sgroup) {
		PageHelper.offsetPage(sgroup.getOffset(), sgroup.getLimit());
		List<SysUser> list=sysUserRoleMapper.getUserListByGroupid(sgroup.getGroupid());
		PageInfo<SysUser> pageinfo = new PageInfo<SysUser>(list);
		return this.success_hashmap_response(pageinfo);
	}


	/**
	 * 通过人员id获取角色选中状态
	 */
	@Override
	public HashMap<String,Object> getUserRoleByUserId(SysRole srole) {
		PageHelper.offsetPage(srole.getOffset(), srole.getLimit());
		List<SysRole> list=sysUserRoleMapper.getUserRoleByUserId(srole.getUserid());
		PageInfo<SysRole> pageinfo = new PageInfo<SysRole>(list);
		return this.success_hashmap_response(pageinfo);
	}


	/**
	 * 保存用户角色
	 */
	@Override
	public AjaxReturnMsg saveUserRole(SysRole srole) {
		sysUserRoleMapper.deleteUserRoleByUserId(srole.getUserid());
		String[] selectnodes= srole.getSelectnodes().split(",");
		for(int i=0;i<selectnodes.length;i++){
			SysRole temp=new SysRole();
			temp.setUserid(srole.getUserid());
			temp.setRoleid(selectnodes[i]);
			sysUserRoleMapper.saveUserRole(temp);
		}
		return this.success("用户授权成功");
	}
	
	/**
	 * 保存用户信息
	 */
	@Override
	public AjaxReturnMsg saveAddSysUser(SysUser suser) {
		if(!"".equals(suser.getUsername())||suser.getUsername()!=null){
			//查询管理机构用户表
			SysUser isusernameexist = sysUserRoleMapper.getSysUserInfoById(suser.getUsername());
			if(isusernameexist!=null){
				return this.error("系统中已经存在名为"+suser.getUsername()+"的用户.请选择其它用户名");
			}else{
				suser.setPassword(MD5Util.MD5Encode(suser.getUsername()));
				suser.setEnabled("1");
				//保存系统用户表
				int insertNum = sysUserRoleMapper.saveSysUserInfo(suser);
				//写入用户用户组关联表
				SysUser suserGroup  = new SysUser();
				suserGroup.setUserid(suser.getUserid());
				suserGroup.setGroupid(suser.getGroupid());
				int insertGroupUser = sysUserRoleMapper.saveSysGroupUser(suserGroup);
				if(insertNum==1 && insertGroupUser == 1){
					return this.success("系统用户创建成功,默认密码为用户名");
				}else {
					return this.error("系统用户创建失败");
				}
			}
		}else{
			return this.error("用户名不能为空");
		}
	}

	/**
	 * 保存系统机构信息
	 */
	@Override
	public AjaxReturnMsg saveAddSysAgency(SysGroup sgroup) {
		if(!"".equals(sgroup.getGroupname())||sgroup.getGroupname()!=null){
			SysGroup sgroup_ = sysUserRoleMapper.getSysAgencyById(sgroup.getGroupname());
			if(sgroup_!=null){
				return this.error("该系统机构名称已存在,请换一个试试");
			}
		}
		sgroup.setGrouptype("2");
		sgroup.setStatus("1");
		int insertNum = sysUserRoleMapper.saveSysAgency(sgroup);
		if(insertNum ==1){
			return this.success("系统机构创建成功");
		}else {
			return this.error("系统机构创建失败");
		}
	}
	
	/**
	 * 删除系统机构信息
	 */
	@Override
	public AjaxReturnMsg deleteSysAgency(String groupid) {
		int deleteNum =0;
		List<SysGroup> list = sysUserRoleMapper.getSysAgencyForChildById(groupid);
		if(list.size()>0){
			return this.error("该机构下有子节点，不能删除!");
		}else {
			List<SysUser> listUser = sysUserRoleMapper.getUserListByGroupid(groupid);
			if(listUser.size()>0){
				return this.error("该机构下有用户信息，请先删除机构下的用户!");
			}else {
				deleteNum =sysUserRoleMapper.deleteSysAgencyInfoByGroupId(groupid);
			}
		}
		if(deleteNum==1){
			return this.success("系统机构删除成功!");
		}else {
			return this.error("系统机构删除失败!");
		}
	}
}
