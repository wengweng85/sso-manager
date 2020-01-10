package com.insigma.mvc.serviceimp.WEBPERM_001_001.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.model.SRole;
import com.insigma.mvc.model.SUser;
import com.insigma.mvc.service.WEBPERM_001_001.api.WebApiService;
import com.insigma.mvc.service.WEBPERM_001_001.role.WebRoleService;
import com.insigma.mvc.service.WEBPERM_001_001.userrole.WebUserRoleService;

/**
 * web��Ŀ�û�����ɫapi
 * ��ƽ̨���ݿ������ ����ʵ�����½ӿ�
 * @author admin
 *
 */
@Service
public class WebApiServiceImpl extends MvcHelper implements WebApiService {

	@Resource
	private WebUserRoleService webUserRoleService;
	
	@Resource
	private WebRoleService webRoleService;
	
	
	@Override
	public AjaxReturnMsg addUser(String groupid, String username, String password) {
		SUser suser=new SUser();
		suser.setGroupid(groupid);
		suser.setUsername(username);
		suser.setPassword(password);
		return webUserRoleService.saveSUser(suser);
	}

	@Override
	public AjaxReturnMsg addUserAndGroupref(String groupid, String userid) {
		SUser suser=new SUser();
		suser.setGroupid(groupid);
		suser.setUserid(userid);
		return webUserRoleService.saveSUserAndGroupRef(suser);
	}

	@Override
	public AjaxReturnMsg addUserAndRoleRef(String userid, String rolecode) {
		// TODO Auto-generated method stub
		SRole srole=webRoleService.getRoleByRoleCode(rolecode);
		if(srole!=null){
			return this.error("�����ڱ���Ϊ"+rolecode+"�Ľ�ɫ,����ϵ����Ա");
		}else{
			srole.setUserid(userid);
			return webUserRoleService.saveUserRoleRef(srole);
		}
	}
	
}
