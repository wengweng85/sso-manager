package com.insigma.mvc.dao.sysmanager.codetype;

import java.util.List;

import com.insigma.mvc.model.CodeType;
import com.insigma.mvc.model.CodeTypeSort;
import com.insigma.mvc.model.CodeValue;


/**
 * @author admin
 *
 */
public interface SysCodeTypeMapper {
	
	 List<CodeType> getInitcodetypeList();
	 List<CodeValue> getInitCodeValueList(CodeType codetype);
	 List<CodeValue> queryCodeValueByCodeTypeAndParent(CodeValue codevalue);
	 List<CodeValue> getCodeValueTree(CodeValue codevalue);
	 List<CodeType> getCodeTypeTreeData(CodeType codetype);
	 List<CodeType> getCodeValueByType(CodeType codetype);
	 List<CodeType> getCodeValueByTypeAndRoot(CodeType codetype);
	 CodeType getCodeTypeInfo(String code_type);
	 CodeValue getCodeValueByValue(CodeValue codevalue);
	 int addCodeType(CodeType codetype);
	 int updateCodeType(CodeType codetype);
	 CodeValue getCodeTypeDetailInfo(String code_seq);
	 CodeValue getCodeTypeDetailByValue(CodeValue codeValue);
	 int addCodeTypeDetail(CodeValue codetype);
	 int updateCodeTypeDetail(CodeValue codetype);
	 int deleteCodeTypeByType(String code_type);
	 int deleteCodeValueByType(String code_type);
	 int deleteCodeValueBySeq(String code_seq);
	 List<CodeValue> getInitCodeValueList(String code_type);
	 List<CodeTypeSort> getCodeTypeSortList(CodeTypeSort codeTypeSort);
	 CodeTypeSort getCodeTypeSortByid(String codesortid);
	 int addCodeTypeSort(CodeTypeSort codeTypeSort);
	 int updateCodeTypeSort(CodeTypeSort codeTypeSort);
	 int deleteCodeTypeSort(String codesortid);
}
