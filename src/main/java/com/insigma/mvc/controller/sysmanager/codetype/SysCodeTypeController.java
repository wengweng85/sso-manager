package com.insigma.mvc.controller.sysmanager.codetype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.insigma.mvc.model.CodeValue;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.insigma.common.listener.AppConfig;
import com.insigma.common.util.CodeValueUtil;
import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.model.CodeType;
import com.insigma.mvc.model.CodeTypeSort;
import com.insigma.mvc.service.sysmanager.codetype.SysCodeTypeService;
import com.insigma.resolver.AppException;

/**
 * Created by admin on 2015-01-14.
 */
@Controller
@RequestMapping("/sys/codetype")
public class SysCodeTypeController extends MvcHelper<CodeValue> {

	@Resource
	private SysCodeTypeService sysCodeTypeService;
	
	/**
	 * 跳转到代码搜索页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws com.insigma.resolver.AppException
	 */
	@RequestMapping(value = "/toCodeValuesuggest")
	public ModelAndView toCodeValuesuggest(HttpServletRequest request, HttpServletResponse response,CodeValue codevalue) throws AppException {
		String callback_fun_name=request.getParameter("callback_fun_name");
		String codetype=request.getParameter("codetype");
		ModelAndView modelAndView=new ModelAndView("sysmanager/codevalue/codeValueSelect");
        modelAndView.addObject("callback_fun_name", callback_fun_name);
        modelAndView.addObject("codetype", codetype);
        return modelAndView;
	}
	
	/**
	 *codevalue 代码树
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws com.insigma.resolver.AppException
	 */
	@RequestMapping(value = "/treedata/{code_type}")
	@ResponseBody
	public List<CodeValue> treedata(HttpServletRequest request, HttpServletResponse response,@PathVariable String code_type) throws AppException {
		String id=request.getParameter("id");
		if(StringUtils.isEmpty(id)){
			id="000000";
		}
		CodeValue codevalue=new CodeValue();
		codevalue.setPar_code_value(id);
		codevalue.setCode_type(code_type.toUpperCase());
		return sysCodeTypeService.getCodeValueTree(codevalue);
	}
	
	/**
	 * 根据代码类型及代码父类名获取代码值
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws com.insigma.resolver.AppException
	 */
	@RequestMapping(value = "/queryByCodeTypeAndParent")
	@ResponseBody
	public List<CodeValue> queryByCodeTypeAndParent(HttpServletRequest request, HttpServletResponse response,CodeValue codevalue) throws AppException {
		return sysCodeTypeService.queryCodeValueByCodeTypeAndParent(codevalue);
	}
	
	
	/**
	 * 从缓存中获取代码值
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws com.insigma.resolver.AppException
	 */
	@RequestMapping(value = "/getCodeValueFromCache")
	@ResponseBody
	public HashMap<String,List<CodeValue>> getCodeValueFromCache(HttpServletRequest request, HttpServletResponse response,CodeValue codevalue) throws AppException {
		return sysCodeTypeService.getCodeValueFromCache(codevalue);
	}
	
	
	
	/**
	 * 跳转至代码管理页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,Model model,CodeType codetype) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sysmanager/codevalue/sysCodeTypeIndex");
		modelAndView.addObject("codetype",codetype);  
        return modelAndView;
	}
	
	
	/**
	 *codetype 代码树
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws com.insigma.resolver.AppException
	 */
	@RequestMapping(value = "/codetype_treedata")
	@ResponseBody
	public List<CodeType> codetype_treedata(HttpServletRequest request, HttpServletResponse response,CodeType codetype) throws AppException {
		return sysCodeTypeService.getCodeTypeTreeData(codetype);
	}
	
	
	/**
	 *跳转至代码值树编辑页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws com.insigma.resolver.AppException
	 */
	@RequestMapping(value = "/toCodeValueTreePage/{id}")
	@ResponseBody
	public ModelAndView toCodeValueTreePage(HttpServletRequest request, HttpServletResponse response,@PathVariable String id) throws AppException {
		CodeType codetype=sysCodeTypeService.getCodeTypeInfo(id);
		ModelAndView modelAndView=new ModelAndView("sysmanager/codevalue/sysCodeTypeEdit");
		modelAndView.addObject("codetype", codetype);
        return modelAndView;
	}
	
	/**
	 *codevalue 代码树
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws com.insigma.resolver.AppException
	 */
	@RequestMapping(value = "/codevalue_treedata")
	@ResponseBody
	public List<CodeType> codevalue_treedata(HttpServletRequest request, HttpServletResponse response,CodeType  codetype) throws AppException {
		return sysCodeTypeService.getCodeValueTreeData(codetype);
	}
	
	
	
	/**
	 * 跳转至代码类型树结点编辑页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toCodeTypeEdit/{id}")
	public ModelAndView toCodeTypeEdit(HttpServletRequest request,Model model,@PathVariable String id) throws Exception {
		CodeType codetype=sysCodeTypeService.getCodeTypeInfo(id);
		ModelAndView modelAndView=new ModelAndView("sysmanager/codevalue/sysCodeTypeInfoEdit");
		modelAndView.addObject("codetype", codetype);
        return modelAndView;
	}
	
	
	/**
	 * 跳转至代码类型新增页面
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toCodeTypeAdd")
	public ModelAndView toCodeTypeAdd(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sysmanager/codevalue/sysCodeTypeInfoAdd");
        return modelAndView;
	}
	
	
	/**
	 * 更新或保存代码类型
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveOrUpdateCodeType")
	@ResponseBody
	public AjaxReturnMsg<String> saveOrUpdateCodeTypedata(HttpServletRequest request,Model model,@Valid CodeType codetype,BindingResult result) throws Exception {
		//检验输入
		if (result.hasErrors()){
			return validate(result);
		}
		return sysCodeTypeService.saveOrUpdateCodeType(codetype);
	}
	
	
	/**
	 * 跳转至代码值明细编辑页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toCodeTypeDetailEdit/{id}")
	public ModelAndView toCodeTypeDetailEdit(HttpServletRequest request,Model model,@PathVariable String id) throws Exception {
		CodeValue codevalue=sysCodeTypeService.getCodeTypeDetailInfo(id);
		ModelAndView modelAndView=new ModelAndView("sysmanager/codevalue/sysCodeTypeDetailInfoEdit");
		modelAndView.addObject("codevalue", codevalue);
        return modelAndView;
	}
	
	
	/**
	 * 跳转至代码值明细页面
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toCodeTypeDetailAddFromRoot/{code_type}")
	public ModelAndView toCodeTypeDetailAddFromRoot(HttpServletRequest request,Model model,@PathVariable String code_type) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sysmanager/codevalue/sysCodeTypeDetailInfoAdd");
		//通过代码类型获取代码明细
		CodeType codetype=sysCodeTypeService.getCodeTypeInfo(code_type);
		CodeValue codevalue=new CodeValue();
	    //在根结点下新增加代码值明细时默认的父节点代码值为代码类型表中的code_root_value
		codevalue.setCode_type(code_type);
		codevalue.setPar_code_value(codetype.getCode_root_value());
		modelAndView.addObject("codevalue", codevalue);
        return modelAndView;
	}
	
	/**
	 * 跳转至代码值明细页面
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toCodeTypeDetailAddFromNode/{par_code_seq}")
	public ModelAndView toCodeTypeDetailAddFromNode(HttpServletRequest request,Model model,@PathVariable String par_code_seq) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sysmanager/codevalue/sysCodeTypeDetailInfoAdd");
		CodeValue codevalue=sysCodeTypeService.getCodeTypeDetailInfo(par_code_seq);
		//设置当前节点的父结点信息为选中的结点的信息
		codevalue.setPar_code_value(codevalue.getCode_value());
		codevalue.setPar_code_name(codevalue.getCode_name());
		modelAndView.addObject("codevalue", codevalue);
        return modelAndView;
	}
	
	
	/**
	 * 更新或保存代码类型
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveOrUpdateCodeTypeDetail")
	@ResponseBody
	public AjaxReturnMsg<String> saveOrUpdateCodeTypeDetail(HttpServletRequest request,Model model,@Valid CodeValue codevalue,BindingResult result) throws Exception {
		//检验输入
		if (result.hasErrors()){
			return validate(result);
		}
		return sysCodeTypeService.saveOrUpdateCodeTypeDetail(codevalue);
	}
	
	
	/**
	 * 删除代码类型
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteCodeType/{code_type}")
	@ResponseBody
	public AjaxReturnMsg<String> deleteCodeType(HttpServletRequest request,Model model,@PathVariable String code_type) throws Exception {
		return sysCodeTypeService.deleteCodeType(code_type);
	}
	
	
	/**
	 * 删除代码值
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteCodeValue/{code_seq}")
	@ResponseBody
	public AjaxReturnMsg<String> deleteCodeValue(HttpServletRequest request,Model model,@PathVariable String code_seq) throws Exception {
		return sysCodeTypeService.deleteCodeValue(code_seq);
	}
	
	
	/**
	 * 跳转至代码类型查询页面
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toCodeTypeQuery")
	public ModelAndView toCodeTypeQuery(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sysmanager/codevalue/sysCodeTypeInfoQuery");
        return modelAndView;
	}
	
	
	/**
	 * 跳转至代码类型查询页面
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toCodeValueQuery")
	public ModelAndView toCodeValueQuery(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sysmanager/codevalue/sysCodeTypeDetailInfoQuery");
        return modelAndView;
	}
	
	  
	 /**
	  * 通过代码类型、过滤条件获取代码 
	  * @param request
	  * @param response
	  * @param codevalue
	  * @return
	  * @throws AppException
	  */
	 @RequestMapping(value = "/getCodeValueList")
	 @ResponseBody
	 public List<CodeValue> getCodeValueList(HttpServletRequest request, HttpServletResponse response,CodeType codetype) throws AppException {
		   return sysCodeTypeService.getInitCodeValueList(codetype);
	 }

	/**
	 * 获取地区信息
	 *
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAreaData")
	public ModelAndView getAreaData(Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/common/codevalue/area_data");

		List<CodeValue> provinces = CodeValueUtil.getCodeListByCodeType("AAB800");
		List<CodeValue> citys = CodeValueUtil.getCodeListByCodeType("AAB801");
		List<CodeValue> three_citys = CodeValueUtil.getCodeListByCodeType("AAB802");

		List<CodeValue> areas = CodeValueUtil.getCodeListByCodeType("AAB301");
		List<Map<String, Object>> area_list = new ArrayList<>();
		List<Map<String, Object>> area_son_list;
		Map<String, Object> hm_father;
		Map<String, Object> hm_son;

		// 获取省级及其下属地区
		for (CodeValue province : provinces) {
			area_son_list = new ArrayList<>();
			hm_father = new HashMap<>();
			if (citys != null) {
				for (CodeValue city : citys) {
					if (province.getCode_value().equals(city.getPar_code_value())) {
						hm_son = new HashMap<>();
						hm_son.put("son", city.getCode_value());
						area_son_list.add(hm_son);
					}
				}
			}
			if (area_son_list.size() > 0) {
				hm_father.put("father", province.getCode_value());
				hm_father.put("son_list", area_son_list);
				area_list.add(hm_father);
			}
		}

		//获取市级及其下属地区
		for (CodeValue city : citys) {
			area_son_list = new ArrayList<>();
			hm_father = new HashMap<>();
			if (three_citys != null) {
				for (CodeValue three_city : three_citys) {
					if (city.getCode_value().equals(three_city.getPar_code_value())) {
						hm_son = new HashMap<>();
						hm_son.put("son", three_city.getCode_value());
						area_son_list.add(hm_son);
					}
				}
			}
			if (area_son_list.size() > 0) {
				hm_father.put("father", city.getCode_value());
				hm_father.put("son_list", area_son_list);
				area_list.add(hm_father);
			}
		}

		//本地城市编码
		String localcity = AppConfig.getProperties("localcity");
		model.addAttribute("localcity", localcity);

		//全部地区
		model.addAttribute("areas", areas);
		//地区及其下属地区
		model.addAttribute("area_list", area_list);
		//省级地区
		model.addAttribute("provinces", provinces);
		return modelAndView;
	}


	/**
	 * 获取工种信息
	 *
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getJobData")
	public ModelAndView getJobData(Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/common/codevalue/job_data");

		List<CodeValue> job_one_list = CodeValueUtil.getCodeListByCodeType("AAB803");
		List<CodeValue> job_two_list = CodeValueUtil.getCodeListByCodeType("AAB804");
		List<CodeValue> job_three_list = CodeValueUtil.getCodeListByCodeType("AAB805");

		List<CodeValue> jobs = CodeValueUtil.getCodeListByCodeType("ACA112");
		List<Map<String, Object>> job_list = new ArrayList<>();
		List<Map<String, Object>> job_son_list;
		Map<String, Object> hm_father;
		Map<String, Object> hm_son;
		//获取一级工种及其下级
		for (CodeValue job_one : job_one_list) {
			job_son_list = new ArrayList<>();
			hm_father = new HashMap<>();
			for (CodeValue job_two : job_two_list) {
				if (job_one.getCode_value().equals(job_two.getPar_code_value())) {
					hm_son = new HashMap<>();
					hm_son.put("son", job_two.getCode_value());
					job_son_list.add(hm_son);
				}
			}
			if (job_son_list.size() > 0) {
				hm_father.put("father", job_one.getCode_value());
				hm_father.put("son_list", job_son_list);
				job_list.add(hm_father);
			}
		}
		//获取二级工种及其下级
		for (CodeValue job_two : job_two_list) {
			job_son_list = new ArrayList<>();
			hm_father = new HashMap<>();
			for (CodeValue job_three : job_three_list) {
				if (job_two.getCode_value().equals(job_three.getPar_code_value())) {
					hm_son = new HashMap<>();
					hm_son.put("son", job_three.getCode_value());
					job_son_list.add(hm_son);
				}
			}
			if (job_son_list.size() > 0) {
				hm_father.put("father", job_two.getCode_value());
				hm_father.put("son_list", job_son_list);
				job_list.add(hm_father);
			}
		}

		//全部工种
		model.addAttribute("jobs", jobs);
		//工种及其下级
		model.addAttribute("job_list", job_list);
		//一级工种
		model.addAttribute("job_one_list", job_one_list);
		return modelAndView;
	}


	/**
	 * 获取行业信息
	 *
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getIndustryData")
	public ModelAndView getIndustryData(Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/common/codevalue/industry_data");

		List<CodeValue> industry_one_list = CodeValueUtil.getCodeListByCodeType("AAB807");
		List<CodeValue> industry_two_list = CodeValueUtil.getCodeListByCodeType("AAB808");

		List<CodeValue> industrys = CodeValueUtil.getCodeListByCodeType("AAA115");
		List<Map<String, Object>> industry_list = new ArrayList<>();
		List<Map<String, Object>> industry_son_list;
		Map<String, Object> hm_father;
		Map<String, Object> hm_son;

		//获取一级行业及其下级
		for (CodeValue industry_one : industry_one_list) {
			industry_son_list = new ArrayList<>();
			hm_father = new HashMap<>();
			for (CodeValue industry_two : industry_two_list) {
				if (industry_one.getCode_value().equals(industry_two.getPar_code_value())) {
					hm_son = new HashMap<>();
					hm_son.put("son", industry_two.getCode_value());
					industry_son_list.add(hm_son);
				}
			}
			if (industry_son_list.size() > 0) {
				hm_father.put("father", industry_one.getCode_value());
				hm_father.put("son_list", industry_son_list);
				industry_list.add(hm_father);
			}
		}

		//全部行业
		model.addAttribute("industrys", industrys);
		//行业及其下级
		model.addAttribute("industry_list", industry_list);
		//一级行业
		model.addAttribute("industry_one_list", industry_one_list);
		return modelAndView;
	}


	/**
	 * 获取专业信息
	 *
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMajorData")
	public ModelAndView getMajorData(Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/common/codevalue/major_data");

		List<CodeValue> major_one_list = CodeValueUtil.getCodeListByCodeType("AAB809");
		List<CodeValue> major_two_list = CodeValueUtil.getCodeListByCodeType("AAB810");
		List<CodeValue> major_three_list = CodeValueUtil.getCodeListByCodeType("AAB811");

		List<CodeValue> majors = CodeValueUtil.getCodeListByCodeType("AAC183");
		List<Map<String, Object>> major_list = new ArrayList<>();
		List<Map<String, Object>> major_son_list;
		Map<String, Object> hm_father;
		Map<String, Object> hm_son;

		//获取一级专业及其下级
		for (CodeValue major_one : major_one_list) {
			major_son_list = new ArrayList<>();
			hm_father = new HashMap<>();
			for (CodeValue major_two : major_two_list) {
				if (major_one.getCode_value().equals(major_two.getPar_code_value())) {
					hm_son = new HashMap<>();
					hm_son.put("son", major_two.getCode_value());
					major_son_list.add(hm_son);
				}
			}
			if (major_son_list.size() > 0) {
				hm_father.put("father", major_one.getCode_value());
				hm_father.put("son_list", major_son_list);
				major_list.add(hm_father);
			}
		}
		//获取二级专业及其下级
		for (CodeValue major_two : major_two_list) {
			major_son_list = new ArrayList<>();
			hm_father = new HashMap<>();
			for (CodeValue major_three : major_three_list) {
				if (major_two.getCode_value().equals(major_three.getPar_code_value())) {
					hm_son = new HashMap<>();
					hm_son.put("son", major_three.getCode_value());
					major_son_list.add(hm_son);
				}
			}
			if (major_son_list.size() > 0) {
				hm_father.put("father", major_two.getCode_value());
				hm_father.put("son_list", major_son_list);
				major_list.add(hm_father);
			}
		}

		//全部专业
		model.addAttribute("majors", majors);
		//专业及其下级
		model.addAttribute("major_list", major_list);
		//一级专业
		model.addAttribute("major_one_list", major_one_list);
		return modelAndView;
	}
	
	/**
	 * 跳转至参数类别管理页
	 * @param request
	 * @return
	 */
	@RequestMapping("/codetypesort/index")
	public ModelAndView toCodeTypeSortIndex(HttpServletRequest request,Model model) throws Exception {
		ModelAndView modelAndView=new ModelAndView("sysmanager/codevalue/sysCodeTypeSortIndex");
        return modelAndView;
	}
	
	
	/**
	 * 获取代码类别列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/codetypesort/list")
	@ResponseBody
	public HashMap<String,Object> getCodeTypeSortList(HttpServletRequest request,Model model,CodeTypeSort	codeTypeSort) throws Exception {
			return sysCodeTypeService.getCodeTypeSortList(codeTypeSort);
	}
	
	
	/**
	 * 代码类别更新
	 * @param request
	 * @return
	 */
	@RequestMapping("/codetypesort/update")
	@ResponseBody
	public AjaxReturnMsg<String> updateCodeTypeSort(HttpServletRequest request,Model mode,CodeTypeSort codeTypeSort) throws Exception {
		return sysCodeTypeService.updateCodeTypeSort(codeTypeSort);
		
	}
	
	/**
	 * 代码类别删除
	 * @param request
	 * @return
	 */
	@RequestMapping("/codetypesort/delete/{paramid}")
	@ResponseBody
	public AjaxReturnMsg<String> deleteCodeTypeSortById(HttpServletRequest request,Model mode,@PathVariable String  paramid) throws Exception {
		return sysCodeTypeService.deleteCodeTypeSortById(paramid);
	}
}