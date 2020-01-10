package com.insigma.mvc.service.common.fileupload;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.SysExcelBatch;
import com.insigma.mvc.model.SysExcelType;
import com.insigma.mvc.model.SysFileRecord;
import org.springframework.web.multipart.MultipartFile;


/**
 * 文件上传service
 * @author admin
 *
 */
public interface FileLoadService {
	  SysFileRecord getFileInfo(String file_uuid);
      byte[]  download(String file_path);
      String upload_old(String file_bus_id,String file_bus_type,MultipartFile multipartFile);
	  String upload(String file_bus_id,String file_bus_type,MultipartFile multipartFile);
 	  HashMap<String,Object> getFileList( SysFileRecord sFileRecord );
 	  AjaxReturnMsg<String> deleteFileByFileid(String file_uuid);
 	  AjaxReturnMsg<String> batDeleteData(SysFileRecord sFileRecord) ;
 	  AjaxReturnMsg<String> batupdateBusIdByFileuuidArray(Map<String,Object> map);
 	  String uploadexcel(String originalFilename,SysExcelType sysExcelType,String userid,InputStream in) throws Exception;
 	  SysExcelBatch getExcelBatchByNumber(String number);
 	  int updateExelBatchErrorFilePath(SysExcelBatch sExcelBatch);
 	  SysExcelType getExcelFileTypeInfo(String businesstype);
}
