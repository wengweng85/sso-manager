package com.insigma.mvc.serviceimp.sysmanager.login;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.insigma.mvc.dao.sysmanager.login.SysLoginMapper;
import com.insigma.mvc.model.SysGroup;
import com.insigma.mvc.model.SysLoginInf;
import com.insigma.mvc.model.SysPermission;
import com.insigma.mvc.model.SysRole;
import com.insigma.mvc.model.SysUser;
import com.insigma.mvc.service.sysmanager.login.SysLoginService;


/**
 * 登录service接口
 * @author admin
 *
 */

@Service
public class SysLoginServiceImpl implements SysLoginService {

	//登录dao
	@Resource
	private SysLoginMapper sysloginmapper;
	
	@Override
	public SysUser getUserAndGroupInfo(String loginname)  {
		SysUser suser=sysloginmapper.getUserAndGroupInfo(loginname);
		if(suser==null){
			return null;
		}else {
			if(suser.getGrouptype().equals("1")){
				return suser;
			}else {
				return cacheFetchGroupInfo(suser, suser.getGroupparentid());
			}
		}
	}

	/**
	 * 循环递归获取父机构信息
	 * @param sysuser
	 * @param parentid
	 */
	private SysUser cacheFetchGroupInfo(SysUser sysuser,String parentid){
		SysGroup sysGroup=sysloginmapper.getGroupAreaInfo(parentid);
		if(sysGroup!=null) {
			if("1".equals(sysGroup.getGrouptype())){//当前数据为行政区划
				sysuser.setAab301(sysGroup.getGroupid());
				sysuser.setAab301name(sysGroup.getGroupname());
				return sysuser;
			}else{
				return cacheFetchGroupInfo(sysuser,sysGroup.getParentid());
			}
		}else{
			return sysuser;
		}
	}

	@Override
	public List<SysRole> findRolesStr(String loginname)  {
		List<SysRole> list= sysloginmapper.findRolesStr(loginname);
		return list;
	}

	@Override
	public List<SysPermission>  findPermissionStr(String loginname)  {
		List<SysPermission> list=sysloginmapper.findPermissionStr(loginname);
		return list;
	}

	@Override
	public void saveLoginHashInfo(SysLoginInf inf) {
		sysloginmapper.saveLoginHashInfo(inf);
	}

	@Override
	public List<SysLoginInf> findLoginInfoByhashcode(String loginhash) {
		return sysloginmapper.findLoginInfoByhashcode(loginhash);
	}


}
