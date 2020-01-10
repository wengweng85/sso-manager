package com.insigma.mvc.serviceimp.WEBPERM_001_001.userrole;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insigma.common.util.MD5Util;
import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.dao.WEBPERM_001_001.userrole.WebUserRoleMapper;
import com.insigma.mvc.model.SGroup;
import com.insigma.mvc.model.SRole;
import com.insigma.mvc.model.SUser;
import com.insigma.mvc.service.WEBPERM_001_001.userrole.WebUserRoleService;

/**
 * 用户角色管理
 * @author admin
 *
 */
@Service
public class WebUserRoleServiceImpl extends MvcHelper implements WebUserRoleService {

	@Resource
    private WebUserRoleMapper webUserRoleMapper;
	
	/**
	 * 获取机构信息树
	 */
	@Override
	public List<SGroup> getAllGroupList(String parentid) {
		 return webUserRoleMapper.getAllGroupList(parentid);
	}
	
	
	/**
	 * 获取机构信息
	 */
	@Override
	public AjaxReturnMsg getGroupDataById(String groupid) {
		return this.success(webUserRoleMapper.getGroupDataById(groupid));
	}
	
	
	/**
	 * 获取机构下人员信息
	 */
	@Override
	public HashMap<String,Object> getUserListByGroupid(SGroup sgroup) {
		PageHelper.offsetPage(sgroup.getOffset(), sgroup.getLimit());
		List<SUser> list=webUserRoleMapper.getUserListByGroupid(sgroup.getGroupid());
		PageInfo<SUser> pageinfo = new PageInfo<SUser>(list);
		return this.success_hashmap_response(pageinfo);
	}


	/**
	 * 通过人员id获取角色选中状态
	 */
	@Override
	public HashMap<String,Object> getUserRoleByUserId(SRole srole) {
		PageHelper.offsetPage(srole.getOffset(), srole.getLimit());
		List<SRole> list=webUserRoleMapper.getUserRoleByUserId(srole.getUserid());
		PageInfo<SRole> pageinfo = new PageInfo<SRole>(list);
		return this.success_hashmap_response(pageinfo);
	}


	/**
	 * 保存用户角色
	 */
	@Override
	public AjaxReturnMsg saveUserRole(SRole srole) {
		webUserRoleMapper.deleteUserRoleByUserId(srole.getUserid());
		String[] selectnodes= srole.getSelectnodes().split(",");
		for(int i=0;i<selectnodes.length;i++){
			SRole temp=new SRole();
			temp.setUserid(srole.getUserid());
			temp.setRoleid(selectnodes[i]);
			webUserRoleMapper.saveUserRole(temp);
		}
		return this.success("用户授权成功");
	}
	
	/**
	 * 保存用户信息
	 */
	@Override
	public AjaxReturnMsg saveSUser(SUser suser) {
		if(null!=suser.getUsername()&&!suser.getUsername().equals("")){
			SUser tempuser = webUserRoleMapper.getSUserInfoById(suser.getUsername());
			if(tempuser!=null){
				return this.error("已经存在用户名"+tempuser.getUsername()+"的账户,其它账户名");
			}else{
				if(null!=suser.getPassword()&&!suser.getPassword().equals("")){
					suser.setPassword(MD5Util.MD5Encode(suser.getPassword()));
				}else{
					suser.setPassword(MD5Util.MD5Encode("123456"));
				}
				suser.setUsertype("1");//用户类型
				suser.setEnabled("1");//有效
				suser.setIsblacklist("0");//不是黑名单
				suser.setIsmainaccount("0");//不是主账户
				suser.setIscertified("0");//未证证
				//保存系统用户表
				int insertNum = webUserRoleMapper.saveSUserInfo(suser);
				//写入用户用户组关联表
				int insertGroupUser = webUserRoleMapper.saveSGroupUser(suser);
				if(insertNum==1 && insertGroupUser == 1){
					return this.success("用户创建成功");
				}else {
					return this.error("用户创建失败");
				}
			}
		}else{
			return this.error("用户名不能为空");
		}
	}


	@Override
	public HashMap<String, Object> getGroupListByType(SGroup sGroup) {
		PageHelper.offsetPage(sGroup.getOffset(), sGroup.getLimit());
		List<SGroup> list=webUserRoleMapper.getGroupListByType(sGroup.getGrouptype());
		PageInfo<SGroup> pageinfo = new PageInfo<SGroup>(list);
		return this.success_hashmap_response(pageinfo);
	}


	@Override
	public AjaxReturnMsg saveSUserAndGroupRef(SUser suser) {
		//写入用户用户组关联表
		int insertGroupUser = webUserRoleMapper.saveSGroupUser(suser);
		if(insertGroupUser == 1){
			return this.success("用户与机构授权成功");
		}else {
			return this.error("用户与机构授权成功");
		}
	}

	@Override
	public AjaxReturnMsg saveUserRoleRef(SRole srole) {
		int insertnum =webUserRoleMapper.saveUserRole(srole);
		if(insertnum == 1){
			return this.success("用户授权成功");
		}else {
			return this.success("用户授权失败");
		}
	}


	@Override
	public AjaxReturnMsg passReset(SUser suer) {
		suer.setPassword(MD5Util.MD5Encode("123456"));
		int insertnum =webUserRoleMapper.passReset(suer);
		if(insertnum == 1){
			return this.success("用户重置成功,新密码为123456");
		}else {
			return this.success("用户重置失败");
		}
	}
}
