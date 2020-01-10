package com.insigma.mvc.dao.common.excel;

import java.util.List;

import com.insigma.mvc.model.Ac60ExcelTemp;
import com.insigma.mvc.model.ExcelExportModel;
import com.insigma.mvc.model.SysExcelBatch;


/**
 * PovertyEmployInfoImportMapper
 * @author admin
 *
 */
public interface FuPingExcelImportMapper {
	
     void insertExcelTempData(Ac60ExcelTemp ac60Temp);
    
     void executePovertyData(SysExcelBatch sExcelBatch);
    
     List<Ac60ExcelTemp> queryPovertyDataTotalByexcelBatchNumber(Ac60ExcelTemp ac60ExcelTemp);
    
     List<Ac60ExcelTemp> queryPovertyDataByexcelBatchNumber(Ac60ExcelTemp ac60ExcelTemp);
    
     int deleteTempDataByNumber(String number);
    
     List<ExcelExportModel> queryExportDataByNumber(String number);
    
      Ac60ExcelTemp queryImpDataById(String aac001);
   
    
}
