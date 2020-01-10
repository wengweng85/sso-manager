package com.insigma.mvc.controller.api.API_MGMT_001_002;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.model.DemoAc01;
import com.insigma.mvc.model.SysApiChannel;
import com.insigma.mvc.model.SysApiInterface;
import com.insigma.mvc.service.api.API_MGMT_001_002.SysApiChannelService;


/**
*  ��������ҳ��
 * @author admin
 *
 */
@Controller
@RequestMapping("/api/channel")
public class SysApiChannelController extends MvcHelper {
	
	@Resource
	private SysApiChannelService sApiChannelService;
	
	
	/**
	 * ��ת��������ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("api/API_MGMT_001_002/channelList");
        return modelAndView;
	}
	
	
	/**
	 * ��ȡ�����б�
	 * @param request
	 * @return
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public HashMap<String,Object> getList(HttpServletRequest request,Model model, SysApiChannel SApiChannel ) throws Exception {
		return  sApiChannelService.getList(SApiChannel);
	}
	
	
	/**
	 * ��ת����������ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("api/API_MGMT_001_002/channelAdd");
        return modelAndView;
	}
	
	/**
	 * ��ת�������༭ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/toEdit/{channelId}")
	public ModelAndView toEdit(HttpServletRequest request,Model model,@PathVariable String channelId) throws Exception {
		ModelAndView modelAndView=new ModelAndView("api/API_MGMT_001_002/channelEdit");
		SysApiChannel SApiChannel=sApiChannelService.getSApiChannelById(channelId);
		modelAndView.addObject("sapichannel",SApiChannel);  
        return modelAndView;
	}
	
	
	/**
	 * ��ת�������鿴
	 * @param request
	 * @return
	 */
	@RequestMapping("/toView/{channelId}")
	public ModelAndView toView(HttpServletRequest request,Model model,@PathVariable String channelId) throws Exception {
		ModelAndView modelAndView=new ModelAndView("api/API_MGMT_001_002/channelView");
		SysApiChannel SApiChannel=sApiChannelService.getSApiChannelDataById(channelId);
		modelAndView.addObject("sapichannel",SApiChannel);  
        return modelAndView;
	}
	/**
	 * ���»򱣴�
	 * @param request
	 * @return
	 */
	@RequestMapping("/savedata")
	@ResponseBody
	public AjaxReturnMsg<String> savedata(HttpServletRequest request,Model model,@Valid SysApiChannel SApiChannel,BindingResult result) throws Exception {
		//��������
		if (result.hasErrors()){
			return validate(result);
		}
		return sApiChannelService.saveData(SApiChannel);
	}
	
	/**
	 * ������
	 * @param request
	 * @return
	 */
	@RequestMapping("/treedata")
	@ResponseBody
	public List<SysApiInterface> getApiInterfaceTree(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
		String id=request.getParameter("id");
		return sApiChannelService.getApiInterfaceTree(id);
	}
	
	/**
	 * �����������ܰ�
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveChannelInterface")
	@ResponseBody
	public AjaxReturnMsg saveChannelInterface(HttpServletRequest request,Model model,SysApiChannel sApiChannel) throws Exception {
		return sApiChannelService.saveChannelInterface(sApiChannel);
	}
	
	/**
	 * ״̬����
	 * @param request
	 * @return
	 */
	@RequestMapping("/updatestatus")
	@ResponseBody
	public AjaxReturnMsg<String> updatestatus(HttpServletRequest request,Model model,SysApiChannel sApiChannel) throws Exception {
		return sApiChannelService.updatestatus(sApiChannel);
	}

}