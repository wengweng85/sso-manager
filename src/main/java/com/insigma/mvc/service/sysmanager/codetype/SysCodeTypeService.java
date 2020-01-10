package com.insigma.mvc.service.sysmanager.codetype;

import java.util.HashMap;
import java.util.List;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.CodeType;
import com.insigma.mvc.model.CodeTypeSort;
import com.insigma.mvc.model.CodeValue;


/**
 * Ö÷Ò³service
 * @author admin
 *
 */
public interface SysCodeTypeService {
	
	 List<CodeType> getInitcodetypeList();
	 List<CodeValue> getInitCodeValueList(CodeType codetype);
	 List<CodeValue> queryCodeValueByCodeTypeAndParent(CodeValue codevalue);
	 CodeValue getCodeValueByValue(CodeValue codevalue);
	 HashMap<String,List<CodeValue>> getCodeValueFromCache(CodeValue codevalue);
	 List<CodeValue> getCodeValueTree(CodeValue codevalue);
	 List<CodeType> getCodeTypeTreeData(CodeType codetype);
	 List<CodeType> getCodeValueTreeData(CodeType codetype);
	 CodeType getCodeTypeInfo(String code_type);
	 AjaxReturnMsg<String> saveOrUpdateCodeType(CodeType codetype);
	 CodeValue getCodeTypeDetailInfo(String code_seq);
	 AjaxReturnMsg<String> saveOrUpdateCodeTypeDetail(CodeValue codevalue);
	 void setSelectCacheData(String code_type);
	 AjaxReturnMsg<String> deleteCodeType(String code_type);
	 AjaxReturnMsg<String> deleteCodeValue(String code_seq);
	 HashMap<String, Object> getCodeTypeSortList(CodeTypeSort codeTypeSort);
	 AjaxReturnMsg<String>  updateCodeTypeSort(CodeTypeSort codeTypeSort);
	 AjaxReturnMsg<String>  deleteCodeTypeSortById(String codesortid);
	
}
