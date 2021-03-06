package com.insigma.mvc.serviceimp.sysmanager.codetype;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.insigma.mvc.model.CodeValue;
import net.sf.ehcache.Element;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insigma.common.util.EhCacheUtil;
import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.dao.sysmanager.codetype.SysCodeTypeMapper;
import com.insigma.mvc.model.CodeType;
import com.insigma.mvc.model.CodeTypeSort;
import com.insigma.mvc.service.sysmanager.codetype.SysCodeTypeService;

/**
 * 系统管理之代码管理
 * @author admin
 *
 */
@Service
public class SysCodeTypeServiceImpl extends MvcHelper implements SysCodeTypeService {

	@Resource
	private SysCodeTypeMapper sysCodeTypeMapper;
	
	
	public List<CodeValue> queryCodeValueByCodeTypeAndParent(CodeValue codevalue){
		return sysCodeTypeMapper.queryCodeValueByCodeTypeAndParent(codevalue);
	}
	
	public HashMap<String,List<CodeValue>> getCodeValueFromCache(CodeValue codevalue){
		Object object=EhCacheUtil.getParamFromCache(codevalue.getCode_type().toUpperCase());
		List<CodeValue> list = (List<CodeValue>) object;
		HashMap map=new HashMap();
		map.put("value", list);
		return map;
	}


	
	@Override
	public List<CodeValue> getCodeValueTree(CodeValue codevalue) {
		 return sysCodeTypeMapper.getCodeValueTree(codevalue);
	}

	@Override
	public List<CodeType> getInitcodetypeList() {
		// TODO Auto-generated method stub
	   return sysCodeTypeMapper.getInitcodetypeList();
	}

	@Override
	public List<CodeValue> getInitCodeValueList(CodeType codetype) {
		// TODO Auto-generated method stub
		return sysCodeTypeMapper.getInitCodeValueList(codetype);
	}

	@Override
	public List<CodeType> getCodeTypeTreeData(CodeType codetype) {
		return sysCodeTypeMapper.getCodeTypeTreeData(codetype);
	}

	@Override
	public List<CodeType> getCodeValueTreeData(CodeType codetype) {
		//初次加载
		if(codetype.getId()==null&& codetype.getCode_root_value()==null){
			return sysCodeTypeMapper.getCodeValueByType(codetype);
		}else{
			if(codetype.getId()!=null){
				codetype.setCode_root_value(codetype.getId());
			}
			return sysCodeTypeMapper.getCodeValueByTypeAndRoot(codetype);
		}
	}

	@Override
	public CodeType getCodeTypeInfo(String code_type) {
		return sysCodeTypeMapper.getCodeTypeInfo(code_type);
	}

	
	@Override
	public AjaxReturnMsg<String> saveOrUpdateCodeType(CodeType codetype) {
		//更新
		if(codetype.getIsupdate() .equals("1")){
			sysCodeTypeMapper.updateCodeType(codetype);
			return this.success("修改成功",codetype);
		}
		//新增
		else{
			//判断codetype是否重复
			if(sysCodeTypeMapper.getCodeTypeInfo(codetype.getCode_type())!=null){
                  return this.error("已经存在代码类型为"+codetype.getCode_type()+"的代码,不能重复,请确认输入");				
			}
			sysCodeTypeMapper.addCodeType(codetype);
			return this.success("新增成功",codetype);
		}
	}
	
	
	@Override
	public CodeValue getCodeTypeDetailInfo(String code_seq) {
		return sysCodeTypeMapper.getCodeTypeDetailInfo(code_seq);
	}
	
	@Override
	public AjaxReturnMsg<String> saveOrUpdateCodeTypeDetail(CodeValue codevalue) {
		//新增
		if(codevalue.getCode_seq() .equals("")){
			//判断codetype是否重复
			if(sysCodeTypeMapper.getCodeTypeDetailByValue(codevalue)!=null){
                  return this.error("已经存在代码值为"+codevalue.getCode_value()+"的代码,不能重复,请确认输入");				
			}
			
			sysCodeTypeMapper.addCodeTypeDetail(codevalue);
			//更新代码缓存
			setSelectCacheData(codevalue.getCode_type());
			return this.success("新增成功",codevalue);
		}
		//修改
		else{
			sysCodeTypeMapper.updateCodeTypeDetail(codevalue);
			//更新代码缓存
			setSelectCacheData(codevalue.getCode_type());
			return this.success("修改成功",codevalue);
		}
	}
	
	
	@Override
	@Transactional
	public AjaxReturnMsg<String> deleteCodeType(String code_type){
		sysCodeTypeMapper.deleteCodeTypeByType(code_type);
		sysCodeTypeMapper.deleteCodeValueByType(code_type);
		//更新代码缓存
		setSelectCacheData(code_type);
		return this.success("删除代码"+code_type+"成功");
	}
	
	
	@Override
	public AjaxReturnMsg<String> deleteCodeValue(String code_seq){
		CodeValue codevalue=sysCodeTypeMapper.getCodeTypeDetailInfo(code_seq);
		if(codevalue!=null){
			sysCodeTypeMapper.deleteCodeValueBySeq(code_seq);
			//更新代码缓存
			setSelectCacheData(codevalue.getCode_type());
			return this.success("删除"+codevalue.getCode_type()+"的"+codevalue.getCode_name()+"代码成功");
		}else{
			return this.error("删除失败,");
		}
		
	}
	
	/**
	 * 修改代码缓存
	 */
	@Override
	public  void setSelectCacheData(String code_type){
		CodeType codetype=new CodeType();
		codetype.setCode_type(code_type);
		List<CodeValue> list_code_value =getInitCodeValueList(codetype);
		if (list_code_value.size() > 0) {
			try{
				//将代码参加加载到ehcache缓存中
				EhCacheUtil.getManager().getCache("webcache").put(new Element(code_type,list_code_value));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public CodeValue getCodeValueByValue(CodeValue codevalue) {
		return sysCodeTypeMapper.getCodeValueByValue(codevalue);
	}

	@Override
	public HashMap<String, Object> getCodeTypeSortList(CodeTypeSort codeTypeSort) {
		PageHelper.offsetPage(codeTypeSort.getOffset(), codeTypeSort.getLimit());
		List<CodeTypeSort> list=sysCodeTypeMapper.getCodeTypeSortList(codeTypeSort);
		PageInfo<CodeTypeSort> pageinfo = new PageInfo<CodeTypeSort>(list);
		return this.success_hashmap_response(pageinfo);
	}

	@Override
	public AjaxReturnMsg<String> updateCodeTypeSort(CodeTypeSort codeTypeSort) {
		CodeTypeSort temp=sysCodeTypeMapper.getCodeTypeSortByid(codeTypeSort.getType_sort_id());
		//更新
		if(temp!=null){
			sysCodeTypeMapper.updateCodeTypeSort(codeTypeSort);
			return this.success("更新成功");
		}
	    //新增
		{
			int addnum=sysCodeTypeMapper.addCodeTypeSort(codeTypeSort);
			return this.success("新增成功");
		}
	}

	@Override
	public AjaxReturnMsg<String> deleteCodeTypeSortById(String codesortid) {
		int deletenum=sysCodeTypeMapper.deleteCodeTypeSort(codesortid);
		return this.success("删除成功");
	}
	
}