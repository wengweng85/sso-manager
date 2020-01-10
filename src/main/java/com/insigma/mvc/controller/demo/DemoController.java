package com.insigma.mvc.controller.demo;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.model.DemoAc01;
import com.insigma.mvc.model.DemoAc01Group;
import com.insigma.mvc.service.demo.DemoService;


/**
 * demo���Գ���
 * @author admin
 *
 */
@Controller
@RequestMapping("/demo")
public class DemoController extends MvcHelper<DemoAc01> {
	
	@Resource
	private DemoService demoService;
	
	
	/**
	 * ��ת����ѯҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/toquery")
	public ModelAndView index(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("demo/demoQuery");
        return modelAndView;
	}


	@RequestMapping("/toqueryjob")
	public ModelAndView indexJob(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("train/demoQueryJob");
		return modelAndView;
	}

	@RequestMapping("/towelfareyjob")
	public ModelAndView indexWelfareyJob(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("train/demoWelfareyJob");
		return modelAndView;
	}

	@RequestMapping("/towelfareyjobs")
	public ModelAndView indexWelfareyJobs(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("train/demoWelfareyJobs");
		return modelAndView;
	}

	@RequestMapping("/toqueryjobs")
	public ModelAndView indexJobs(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("train/demoQueryJobs");
		return modelAndView;
	}
	
	
	/**
	 * ��ת����ѯҳ�� ��ҵ���������ҵ�Ǽ�
	 * @param request
	 * @return
	 */
	@RequestMapping("/batch")
	public ModelAndView batch(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("train/batch");
        return modelAndView;
	}
	
	/**
	 * ��ת����ѯҳ�� ��ҵ��������ʧҵ�Ǽ�
	 * @param request
	 * @return
	 */
	@RequestMapping("/batch2")
	public ModelAndView batch2(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("train/batch2");
        return modelAndView;
	}
	
	
	
	/**
	 * ��ת����ѯҳ�� ��ʧҵ�Ǽ�
	 * @param request
	 * @return
	 */
	@RequestMapping("/train")
	public ModelAndView add(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("train/add");
        return modelAndView;
	}
	
	
	
	
	/**
	 * ��ת����ѯҳ�� ��ҵ��������
	 * @param request
	 * @return
	 */
	@RequestMapping("/subsidy")
	public ModelAndView subsidy(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("train/subsidy");
        return modelAndView;
	}
	
	
	/**
	 * ��ת����ѯҳ�� ��ҵ��������
	 * @param request
	 * @return
	 */
	@RequestMapping("/Entrepreneurship")
	public ModelAndView Entrepreneurship(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("train/Entrepreneurship");
        return modelAndView;
	}
	
	
	/**
	 * ��ȡ��Ա��Ϣ�б�
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAc01List")
	@ResponseBody
	public HashMap<String,Object> getAc01List(HttpServletRequest request,Model model, DemoAc01 ac01 ) throws Exception {
		return demoService.getDemoAc01List(ac01);
	}
	
	
	/**
	 * ͨ��idɾ����Աdemo��Ϣ
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/deletebyid/{id}")
	@ResponseBody
	public AjaxReturnMsg<String> deleteDemoDataById(HttpServletRequest request,Model model,@PathVariable String id){
		return demoService.deleteDemoById(id);
	}
	
	
	/**
	 * ��ת���༭ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/toedit/{id}")
	public ModelAndView toedit(HttpServletRequest request,Model model,@PathVariable String id) throws Exception {
		ModelAndView modelAndView=new ModelAndView("demo/demoEdit");
		DemoAc01 ac01=demoService.getDemoById(id);
		modelAndView.addObject("ac01",ac01);  
        return modelAndView;
	}
	
	
	/**
	 * ��ת���鿴ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/toview/{id}")
	public ModelAndView toview(HttpServletRequest request,Model model,@PathVariable String id) throws Exception {
		ModelAndView modelAndView=new ModelAndView("demo/demoView");
		DemoAc01 ac01=demoService.getDemoNameById(id);
		modelAndView.addObject("ac01",ac01);  
        return modelAndView;
	}
	
	
	/**
	 * ����ɾ��
	 * @param request
	 * @param model
	 * @param ac01
	 * @return
	 */
	@RequestMapping("/batdelete")
	@ResponseBody
	public AjaxReturnMsg<String> batDeleteDemodata(HttpServletRequest request,Model model,DemoAc01 ac01){
		return demoService.batDeleteDemoData(ac01);
	}
	
	
	/**
	 * ��ת���༭(����)ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/toadd")
	public ModelAndView toadd(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("demo/demoAdd");
        return modelAndView;
	}


	/**
	 * ��ת���༭(����)ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/toaddjob")
	public ModelAndView toaddjob(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("train/demoAddJob");
		return modelAndView;
	}

	/**
	 * ��ת���༭(����)ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/toaddjobs")
	public ModelAndView toaddjobs(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("train/demoAddJobs");
		return modelAndView;
	}
	
	/**
	 * ��Աѡ���
	 * @param request
	 * @return
	 */
	@RequestMapping("/toselect")
	public ModelAndView selectindex(HttpServletRequest request,Model model) throws Exception {
		String callback_fun_name=request.getParameter("callback_fun_name");
		ModelAndView modelAndView=new ModelAndView("demo/demoSelect");
        modelAndView.addObject("callback_fun_name", callback_fun_name);
        return modelAndView;
	}
	
	/**
	 * ��ת���༭(����)ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/getDemoById/{id}")
	@ResponseBody
	public AjaxReturnMsg<DemoAc01> getDemoById(HttpServletRequest request,Model model,@PathVariable String id) throws Exception {
		return this.success(demoService.getDemoById(id));
	}
	
	
	
	/**
	 * ���»򱣴�
	 * @param ac01
	 * @return
	 */
	@RequestMapping("/savedata")
	@ResponseBody
	public AjaxReturnMsg<String> savedata(@Validated({DemoAc01Group.Add.class}) DemoAc01 ac01, BindingResult result) throws Exception {
		//��������
		if (result.hasErrors()){
			return validate(result);
		}
		
		return demoService.saveDemoData(ac01);
		
	}
	
	/**
	 * ���»򱣴� ͨ�������༭����
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateDataByXedit")
	@ResponseBody
	public AjaxReturnMsg<String> updateDataByXedit(HttpServletRequest request,Model mode, DemoAc01 ac01) throws Exception {
		return demoService.saveDemoData(ac01);
	}
	
	
	/**
	 * ���¸���ͼƬ���
	 * @param request
	 * @return
	 */
	@RequestMapping("/updatefile/{id}/{bus_uuid}")
	@ResponseBody
	public AjaxReturnMsg<String> updatefile(HttpServletRequest request,Model model,@PathVariable String id,@PathVariable String bus_uuid) throws Exception {
		DemoAc01 ac01=new DemoAc01();
		ac01.setAac001(id);
		ac01.setBus_uuid (bus_uuid);
		return demoService.updateDemoAc01DemBusUuid(ac01);
	}
	
	/**
	 * ɾ������ͼƬ
	 * @param request
	 * @return
	 */
	@RequestMapping("/deletefile/{id}/{bus_uuid}")
	@ResponseBody
	public AjaxReturnMsg<String> deletefile(HttpServletRequest request,Model model,@PathVariable String id,@PathVariable String bus_uuid) throws Exception {
		DemoAc01 ac01=new DemoAc01();
		ac01.setAac001(id);
		ac01.setBus_uuid(bus_uuid);
		return demoService.deletefile(ac01);
	}
	
	/**
	 * ��ת��wizard step����ҳ
	 * @param request
	 * @return
	 */
	@RequestMapping("/open_wizard_step")
	public ModelAndView open_wizard_step(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("demo/demoWizardStep");
        return modelAndView;
	}
	
	/**
	 * ��ת��wizard step����ҳ
	 * @param request
	 * @return
	 */
	@RequestMapping("/open_wizard_form_step")
	public ModelAndView open_wizard_form_step(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("demo/demoWizardStep_form");
        return modelAndView;
	}
	
	
	/**
	 * ��ת�������Ը�λ�Ǽ�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/welfareJob")
	public ModelAndView welfareJob(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("demo/welfareJob");
        return modelAndView;
	}
	
	/**
	 * ��ת����λ����ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/jobAdd")
	public ModelAndView jobAdd(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("demo/jobAdd");
        return modelAndView;
	}
	
	/**
	 * ��ת�������Ը�λ��������ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/welfareMoney")
	public ModelAndView welfareMoney(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("demo/welfareMoney");
        return modelAndView;
	}
	
	
	/**
	 * thymeleaf ҳ����� 
	 * @param request
	 * @return
	 */
	@RequestMapping("/thymeleaf")
	public ModelAndView thymeleaf(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("demo/thymeleaf");
		model.addAttribute("name", "���ܻ�");
        return modelAndView;
	}
	
	
	

}
