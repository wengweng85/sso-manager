package com.insigma.mvc.dao.sysmanager.login;


import java.util.List;

import com.insigma.mvc.model.SysGroup;
import com.insigma.mvc.model.SysLoginInf;
import com.insigma.mvc.model.SysPermission;
import com.insigma.mvc.model.SysRole;
import com.insigma.mvc.model.SysUser;


/**
 * ��¼service�ӿ�
 * @author admin
 *
 */
public interface SysLoginMapper {
	/**
	 * ͨ���û�����ȡ��Ա����Ϣ
	 * @param username
	 * @return �û���
	 * @
	 */
	 SysUser getUserAndGroupInfo(String username);

	/**
	 * ��ȡ��ǰ����������������Ϣ
	 * @param groupid
	 * @return
	 * @
	 */
	 SysGroup getGroupAreaInfo(String groupid);



	
	
	/**
	 * ͨ���û�id��ȡ�û���ɫ����
	 * @param loginname
	 * @return ��ɫ����
	 * @ 
	 */
	 List<SysRole> findRolesStr(String loginname) ;
	
	
	/**
	 * ͨ���û�id��ȡ�û�Ȩ�޼���
	 * @param loginname
	 * @return Ȩ�޼���
	 * @ 
	 */
	 List<SysPermission> findPermissionStr(String loginname) ;
	
	
	/**
	 * ����hashinfo
	 * @param inf
	 */
	 void saveLoginHashInfo(SysLoginInf inf);
	
	
	 List<SysLoginInf> findLoginInfoByhashcode(String loginhash);

}
