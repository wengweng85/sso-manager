package com.insigma.mvc.serviceimp.sysmanager.perm;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.dao.sysmanager.perm.SysPermMapper;
import com.insigma.mvc.model.SysPermission;
import com.insigma.mvc.service.sysmanager.perm.SysPermService;
import com.mysql.jdbc.StringUtils;


/**
 * 管理功能之权限管理service impl 
 * @author admin
 *
 */

@Service
public class SysPermServiceImpl extends MvcHelper implements SysPermService {

	@Resource
	private SysPermMapper sysPermMapper;
	
	
	/**
	 * 获取权限数据
	 */
	@Override
	public List<SysPermission> getPermTreeList() {
		// TODO Auto-generated method stub
		return  sysPermMapper.getPermTreeList();
	}

	/**
	 * 通过权限id获取权限数据
	 */
	@Override
	public AjaxReturnMsg getPermDataById(String id) {
		return this.success(sysPermMapper.getPermDataById(id));
	}

	
    /**
     * 保存或更新权限数据
     */
	@Override
	@Transactional
	public AjaxReturnMsg saveOrUpdatePermData(SysPermission spermission) {
	   SysPermission isPermsionCodeexist=sysPermMapper.isPermCodeExist(spermission);
	   if(isPermsionCodeexist!=null){
		   return this.error("此权限"+spermission.getPermcode()+"编号已经存在,请重新输入一个新的权限编号");
	   }

	   SysPermission isPermsionUrlexist=sysPermMapper.isPermUrlExist(spermission);
	   if(isPermsionUrlexist!=null){
		   return this.error("此权限"+spermission.getUrl()+"路径地址已经存在,请重新输入一个新的路径地址");
	   }
		   
	   //判断是否更新操作
	   if(StringUtils.isNullOrEmpty(spermission.getPermissionid())){
		 int insertnum=sysPermMapper.savePermissionData(spermission);
		 if(insertnum==1){
			 return this.success(spermission.getPermissionid());
		 }else{
			 return this.error("新增失败");
		 }
	   }else{
		 int updatenum=sysPermMapper.updatePermissionData(spermission);
		 if(updatenum==1){
			 return this.success(spermission.getPermissionid());
		 }else{
			 return this.error(spermission.getPermissionid());
		 }
	   }
	}

	/**
	 * 通过父节点获取权限子节点数据
	 */
	@Override
	public AjaxReturnMsg getPermListDataByParentid(String parentid) {
		return this.success(sysPermMapper.getPermListDataByParentid(parentid));
	}

	
	/**
	 * 通过权限id删除权限相关数据
	 */
	@Override
	@Transactional
	public AjaxReturnMsg deletePermDataById(String id) {
		if(sysPermMapper.getPermListDataByParentid(id).size()>0){
			return this.error("当前权限还存在子权限数据,请先删除子权限数据");
		}else{
			int deletenum=sysPermMapper.deletePermDataById(id);
			if(deletenum==1){
				return this.success("删除成功");
			}else{
				return this.success("删除失败");
			}
			
		}
	}

	
	/**
	 * 节点移动
	 */
	@Override
	public AjaxReturnMsg<String> moveNode(String id) {
		String[]  ids=id.split("_");
		//要移动的节点id
		String movetreenodeid=ids[0];
		//目标节点id
		String targettreenodeid=ids[1];
		//要移动的节点
		SysPermission moveSpermission=sysPermMapper.getPermDataById(movetreenodeid);
		//目标节点
		SysPermission targetSpermission=sysPermMapper.getPermDataById(targettreenodeid);
		
		//同级移动,只修改排序号
		if(moveSpermission.getParentid().equals(targetSpermission.getParentid())){
			moveSpermission.setSortnum(targetSpermission.getSortnum());
		}
		//非同级移动、修改当前节点的父节点为目标节点id
		else{
			moveSpermission.setParentid(targetSpermission.getPermissionid());
		}
		sysPermMapper.updatePermissionData(moveSpermission);
		return this.success("成功");
	}

	/**
	 * 批量删除权限
	 */
	@Override
	public AjaxReturnMsg batdeletePermData(SysPermission spermission) {
		// TODO Auto-generated method stub
		String[] selectnodes= spermission.getSelectnodes().split(",");
		sysPermMapper.batdeletePermData(selectnodes);
		return this.success("成功");
	}
}
