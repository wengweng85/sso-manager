package com.insigma.mvc.service.common.excel;

import java.util.HashMap;
import java.util.List;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.Ac60ExcelTemp;
import com.insigma.mvc.model.ExcelExportModel;
import com.insigma.mvc.model.SysExcelBatch;




/**
 * excel״̬service
 * @author admin
 *
 */
public interface FuPingExcelImportService {
	
	 HashMap<String,Object> getList( SysExcelBatch sExcelBatch );
	
	 HashMap<String,Object> queryPovertyDataTotalByexcelBatchNumber( Ac60ExcelTemp ac60ExcelTemp );
	
	 HashMap<String,Object> getPovertyImprtDataList( Ac60ExcelTemp ac60ExcelTemp );
	
	 AjaxReturnMsg<String> deleteTempDataByNumber(String number);
	
	 List<ExcelExportModel> queryExportDataByNumber(String number);
	 
	 AjaxReturnMsg<String> exportData(String number);
	 
	 Ac60ExcelTemp queryImpDataById(String aac002);
}
