package com.insigma.mvc.service.WEBPERM_001_001.api;

import com.insigma.dto.AjaxReturnMsg;




/**
 * web��Ŀ�û�����ɫapi
 * @author admin
 *
 */
public interface WebApiService {
	
	//�����û����󶨹�ϵ
	public AjaxReturnMsg addUser(String groupid,String username,String password);
    //���û��������ϵ
	public AjaxReturnMsg addUserAndGroupref(String groupid,String userid);
    //���û����ɫ��ϵ
	public AjaxReturnMsg addUserAndRoleRef(String userid,String rolecode);
	
}
