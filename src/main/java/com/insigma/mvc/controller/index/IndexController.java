package com.insigma.mvc.controller.index;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import com.insigma.common.listener.AppConfig;
import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.model.SysPermission;
import com.insigma.mvc.model.WebsocketMessage;
import com.insigma.mvc.service.index.IndexService;
import com.insigma.shiro.realm.SysUserUtil;
import com.insigma.websocket.MyWSHandler;



/**
 * ��������ҳcontoller
 * @author admin
 *
 */
@Controller
public class IndexController extends MvcHelper<SysPermission> {
	
	@Bean//���ע����Spring�����ó�Bean
    public MyWSHandler infoHandler() {
        return new MyWSHandler();
    }
	 
	@Resource
    private IndexService indexService;
	
	/**
	 * ��������ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView gotoAdminIndex(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("index/admin_index");
	    String systitle=AppConfig.getProperties("SYS_TITLE");
		if(systitle!=null&&!systitle.equals("")){
			modelAndView.addObject("SYS_TITLE", systitle);
		}else{
			modelAndView.addObject("SYS_TITLE", "��ά��");
		}
		modelAndView.addObject("suser", SysUserUtil.getCurrentUser());
    	modelAndView.addObject("permlist",SysUserUtil.getCurrentUser().getPermlist());
        return modelAndView;
	}
	
	
	/**
	 * ϵͳ��ҳ
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView gotoIndex(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("index/index");
		modelAndView.addObject("alluser", infoHandler().users);
		modelAndView.addObject("suser", SysUserUtil.getCurrentUser());
        return modelAndView;
	}
	
	/**
	 * http 404 ����
	 * @param request
	 * @return
	 */
	@RequestMapping("/404")
	public ModelAndView error404(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("error/404");
        return modelAndView;
	}
	
	/**
	 * http 500 ����
	 * @param request
	 * @return
	 */
	@RequestMapping("/500")
	public ModelAndView error500(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("error/500");
        return modelAndView;
	}
	
	/**
	 *  δ��Ȩ
	 * @param request
	 * @return
	 */
	@RequestMapping("/unrecognized")
	public ModelAndView unrecognized(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("error/unrecognized");
        return modelAndView;
	}
	
	/**
	 *  δ��Ȩ
	 * @param request
	 * @return
	 */
	@RequestMapping("/resubmit")
	public ModelAndView resubmit(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("error/resubmit");
        return modelAndView;
	}
	
	/**
	 * websocket����
	 * @param request
	 * @return
	 */
	@RequestMapping("/websocket/send")
    @ResponseBody
    public AjaxReturnMsg send(HttpServletRequest request,WebsocketMessage websocketMessage) {
		JSONObject jsonobject=JSONObject.fromObject(websocketMessage);
        infoHandler().sendMessageToUser(websocketMessage,new TextMessage(jsonobject.toString()));
        return this.success("���ͳɹ�");
    }
	/**
	 * websocket����
	 * @param request
	 * @return
	 */
	@RequestMapping("/websocket/sendall")
    @ResponseBody
    public AjaxReturnMsg sendall(HttpServletRequest request,WebsocketMessage websocketMessage) {
		JSONObject jsonobject=JSONObject.fromObject(websocketMessage);
        infoHandler().sendMessageToUsers(websocketMessage,new TextMessage(jsonobject.toString()));
        return this.success("���ͳɹ�");
    }
	
}
