package com.insigma.mvc.service.common.excel;

import java.util.List;

import com.insigma.mvc.model.SysExcelBatch;
import com.insigma.resolver.AppException;




/**
 * excel¥¶¿Ì
 * @author admin
 *
 */
public interface ExcelVS {
	
     void executeListToTemp(List<String[]> list,SysExcelBatch sExcelBatch) throws AppException;
	
	 void executeProc(SysExcelBatch sExcelBatch)throws AppException;
}
