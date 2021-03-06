package com.insigma.mvc.controller.WEBPERM_001_001.userrole;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.model.SGroup;
import com.insigma.mvc.model.SRole;
import com.insigma.mvc.model.SUser;
import com.insigma.mvc.service.WEBPERM_001_001.userrole.WebUserRoleService;

/**
 * 用户组与用户管理
 * @author admin
 *
 */
@Controller
@RequestMapping("/web/userrole")
public class WebUserRoleController extends MvcHelper {
	
	@Resource
	private WebUserRoleService webUserRoleService;
	/**
	 * 页面初始化
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("webperm/WEBPERM_001_001/userrole/webUserRoleIndex");
        return modelAndView;
	}
	
	
	/**
	 *通过机构类型获取机构信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/getGroupListByType")
	@ResponseBody
	public HashMap<String,Object> getGroupListByType(HttpServletRequest request,Model model,  SGroup  sgroup ) throws Exception {
		return webUserRoleService.getGroupListByType(sgroup);
	}
	
	/**
	 * 机构树数据
	 * @param request
	 * @return
	 */
	@RequestMapping("/treedata")
	@ResponseBody
	public  List<SGroup>  getGroupTreeData(HttpServletRequest request,Model model) throws Exception {
		String parentid=request.getParameter("id");
		if(parentid.equals("")){
			parentid="G001";
		}
		return webUserRoleService.getAllGroupList(parentid);
	}
	
	
	/**
	 * 通过机构编号获取机构信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/getgroupdatabyid/{id}")
	@ResponseBody
	public AjaxReturnMsg getgroupdata(HttpServletRequest request,Model model,@PathVariable String id ) throws Exception {
		return webUserRoleService.getGroupDataById(id);
	}
	
	/**
	 * 获取人员信息列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getUserListDataByid")
	@ResponseBody
	public HashMap<String,Object> getUserListByGroupid(HttpServletRequest request,Model model,SGroup sgroup ) throws Exception {
		return webUserRoleService.getUserListByGroupid(sgroup);
	}
	
	
	/**
	 * 通用用户id获取角色列表及选中状态
	 * @param request
	 * @return
	 */
	@RequestMapping("/getRoleByUserId")
	@ResponseBody
	public HashMap<String,Object> getRoleByUserId(HttpServletRequest request,Model model,SRole srole ) throws Exception {
		if(StringUtils.isEmpty(srole.getUserid())){
			srole.setUserid("");
		}
		return webUserRoleService.getUserRoleByUserId(srole);
	}
	
	
	/**
	 * 保存用户对应角色
	 * @param request
	 * @param model
	 * @param srole
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/saveUserRole")
	@ResponseBody
	public AjaxReturnMsg saveUserRole(HttpServletRequest request,Model model,SRole srole ) throws Exception {
		return webUserRoleService.saveUserRole(srole);
	}
	
	
	/**
	 * 创建系统用户
	 * @param request
	 * @return
	 */
	@RequestMapping("/addWebUser/{groupid}")
	public ModelAndView addSUser(HttpServletRequest request,Model model,@PathVariable String groupid ) throws Exception {
		ModelAndView modelAndView=new ModelAndView("webperm/WEBPERM_001_001/userrole/addWebUser");
		modelAndView.addObject("groupid", groupid);
        return modelAndView;
	}
	
	/**
	 * 保存系统用户信息
	 * @param request
	 * @param model
	 * @param suser
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/saveWebUser")
	@ResponseBody
	public AjaxReturnMsg saveSUser(HttpServletRequest request,Model model,SUser suser) throws Exception {
		return webUserRoleService.saveSUser(suser);
	}
	
	/**
	 * 密码重置
	 * @param request
	 * @param model
	 * @param suser
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/passreset/{userid}")
	@ResponseBody
	public AjaxReturnMsg passReset(HttpServletRequest request,Model model,@PathVariable String userid ) throws Exception {
		SUser suser=new SUser();
		suser.setUserid(userid);
		return webUserRoleService.passReset(suser);
	}
	
}
