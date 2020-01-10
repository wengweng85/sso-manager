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
 * �û���ɫ����
 * @author admin
 *
 */
@Service
public class WebUserRoleServiceImpl extends MvcHelper implements WebUserRoleService {

	@Resource
    private WebUserRoleMapper webUserRoleMapper;
	
	/**
	 * ��ȡ������Ϣ��
	 */
	@Override
	public List<SGroup> getAllGroupList(String parentid) {
		 return webUserRoleMapper.getAllGroupList(parentid);
	}
	
	
	/**
	 * ��ȡ������Ϣ
	 */
	@Override
	public AjaxReturnMsg getGroupDataById(String groupid) {
		return this.success(webUserRoleMapper.getGroupDataById(groupid));
	}
	
	
	/**
	 * ��ȡ��������Ա��Ϣ
	 */
	@Override
	public HashMap<String,Object> getUserListByGroupid(SGroup sgroup) {
		PageHelper.offsetPage(sgroup.getOffset(), sgroup.getLimit());
		List<SUser> list=webUserRoleMapper.getUserListByGroupid(sgroup.getGroupid());
		PageInfo<SUser> pageinfo = new PageInfo<SUser>(list);
		return this.success_hashmap_response(pageinfo);
	}


	/**
	 * ͨ����Աid��ȡ��ɫѡ��״̬
	 */
	@Override
	public HashMap<String,Object> getUserRoleByUserId(SRole srole) {
		PageHelper.offsetPage(srole.getOffset(), srole.getLimit());
		List<SRole> list=webUserRoleMapper.getUserRoleByUserId(srole.getUserid());
		PageInfo<SRole> pageinfo = new PageInfo<SRole>(list);
		return this.success_hashmap_response(pageinfo);
	}


	/**
	 * �����û���ɫ
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
		return this.success("�û���Ȩ�ɹ�");
	}
	
	/**
	 * �����û���Ϣ
	 */
	@Override
	public AjaxReturnMsg saveSUser(SUser suser) {
		if(null!=suser.getUsername()&&!suser.getUsername().equals("")){
			SUser tempuser = webUserRoleMapper.getSUserInfoById(suser.getUsername());
			if(tempuser!=null){
				return this.error("�Ѿ������û���"+tempuser.getUsername()+"���˻�,�����˻���");
			}else{
				if(null!=suser.getPassword()&&!suser.getPassword().equals("")){
					suser.setPassword(MD5Util.MD5Encode(suser.getPassword()));
				}else{
					suser.setPassword(MD5Util.MD5Encode("123456"));
				}
				suser.setUsertype("1");//�û�����
				suser.setEnabled("1");//��Ч
				suser.setIsblacklist("0");//���Ǻ�����
				suser.setIsmainaccount("0");//�������˻�
				suser.setIscertified("0");//δ֤֤
				//����ϵͳ�û���
				int insertNum = webUserRoleMapper.saveSUserInfo(suser);
				//д���û��û��������
				int insertGroupUser = webUserRoleMapper.saveSGroupUser(suser);
				if(insertNum==1 && insertGroupUser == 1){
					return this.success("�û������ɹ�");
				}else {
					return this.error("�û�����ʧ��");
				}
			}
		}else{
			return this.error("�û�������Ϊ��");
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
		//д���û��û��������
		int insertGroupUser = webUserRoleMapper.saveSGroupUser(suser);
		if(insertGroupUser == 1){
			return this.success("�û��������Ȩ�ɹ�");
		}else {
			return this.error("�û��������Ȩ�ɹ�");
		}
	}

	@Override
	public AjaxReturnMsg saveUserRoleRef(SRole srole) {
		int insertnum =webUserRoleMapper.saveUserRole(srole);
		if(insertnum == 1){
			return this.success("�û���Ȩ�ɹ�");
		}else {
			return this.success("�û���Ȩʧ��");
		}
	}


	@Override
	public AjaxReturnMsg passReset(SUser suer) {
		suer.setPassword(MD5Util.MD5Encode("123456"));
		int insertnum =webUserRoleMapper.passReset(suer);
		if(insertnum == 1){
			return this.success("�û����óɹ�,������Ϊ123456");
		}else {
			return this.success("�û�����ʧ��");
		}
	}
}
