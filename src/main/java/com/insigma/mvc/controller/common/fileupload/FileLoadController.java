package com.insigma.mvc.controller.common.fileupload;

import com.insigma.common.util.FileType;
import com.insigma.common.util.FileUtil;
import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.controller.common.suggest.SuggestSearchController;
import com.insigma.mvc.model.CodeValue;
import com.insigma.mvc.model.SysExcelBatch;
import com.insigma.mvc.model.SysExcelType;
import com.insigma.mvc.model.SysFileRecord;
import com.insigma.mvc.service.common.fileupload.FileLoadService;
import com.insigma.mvc.service.sysmanager.codetype.SysCodeTypeService;
import com.insigma.resolver.AppException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 文件上传及下载
 */
@Controller
@RequestMapping(value = "/common/fileload")
public class FileLoadController extends MvcHelper<SysFileRecord> {


    Log log = LogFactory.getLog(SuggestSearchController.class);

    @Resource
    private FileLoadService fileloadservice;
    
    @Resource
    private SysCodeTypeService syscodetypeservice;
    
    
    /**
   	 * 跳转至上传页面
   	 * @param request
   	 * @return
   	 */
   	@RequestMapping("/tofilelist")
   	public ModelAndView tofilelist(HttpServletRequest request,Model model,SysFileRecord sFileRecord ) throws Exception {
   		ModelAndView modelAndView=new ModelAndView("common/fileupload/filelist");
   		if(sFileRecord.getFile_bus_id()==null){
   			throw new Exception("业务编号不能为空");
   		}
   		if(sFileRecord.getFile_bus_type()==null){
   			throw new Exception("业务图片类型不能为空");
   		}
   		CodeValue codevalue=new CodeValue();
   		codevalue.setCode_type("FILE_BUS_TYPE");
   		codevalue.setCode_value(sFileRecord.getFile_bus_type());
   		if(syscodetypeservice.getCodeValueByValue(codevalue)==null){
   			throw new Exception("业务图片类型编码"+sFileRecord.getFile_bus_type()+"不存在,请检查代码类型FILE_BUS_TYPE中是否存在!");
   		}
   		sFileRecord.setFile_name("管理");
   		modelAndView.addObject("filerecord", sFileRecord);
   		return modelAndView;
   	}
   	
	/**
	 * 通过人员id获取文件列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getFileList")
	@ResponseBody
	public HashMap<String,Object> getUserListByGroupid(HttpServletRequest request,Model model,SysFileRecord sFileRecord ) throws Exception {
		return fileloadservice.getFileList(sFileRecord);
	}
	
    
    /**
	 * 跳转至图片上传页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toImgUpload")
	public ModelAndView toupload(HttpServletRequest request,Model modell,SysFileRecord sFileRecord) throws Exception {
		ModelAndView modelAndView=new ModelAndView("common/fileupload/imgUpload");
		modelAndView.addObject("filerecord", sFileRecord);
		return modelAndView;
	}
	
   /**
	 * 跳转至文件上传页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toFileUpload")
	public ModelAndView toFileUpload(HttpServletRequest request,Model modell,SysFileRecord sFileRecord) throws Exception {
		ModelAndView modelAndView=new ModelAndView("common/fileupload/fileUpload");
		modelAndView.addObject("filerecord", sFileRecord);
		return modelAndView;
	}
	
	
	/**
     * 文件上传
     *
     * @param request
     * @param response
     * @return
     * @throws AppException
     */
    @RequestMapping("/upload")
    @ResponseBody
    public AjaxReturnMsg<String>  upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String file_bus_id=request.getParameter("file_bus_id");
		String file_bus_type=request.getParameter("file_bus_type");

		System.out.println("file_bus_id="+file_bus_id);
		System.out.println("file_bus_type="+file_bus_type);

        //检查业务编号参数
        if(null==file_bus_id||file_bus_id.equals("")){
        	return this.error( "业务编号参数为空,请检查");
        }
        
		//检查业务编号参数
        if(null==file_bus_type||file_bus_type.equals("")){
			return this.error( "文件业务类型参数为空,请检查");
        }

		long MAX_SIZE = 20* 1024 * 1024L;//100m
		
    	try {
            //创建一个通用的多部分解析器
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            //判断 request 是否有文件上传,即多部分请求
            if (multipartResolver.isMultipart(request)) {
                //转换成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                //取得request中的所有文件名
                Iterator<String> iter = multiRequest.getFileNames();
                while (iter.hasNext()) {
                    //取得上传文件
                    MultipartFile multipartFile = multiRequest.getFile(iter.next());
                    if (multipartFile.getSize() > MAX_SIZE) {
                    	return this.error( "文件尺寸超过规定大小:" + MAX_SIZE / 1024 / 1024 + "M");
                    } else {
                    	/*FileType fileType=FileUtil.getFileType(multipartFile.getInputStream());
                    	System.out.println("文件类型="+fileType.getValue());
                        if(fileType!=null){*/
							//上传并记录日志
							String recordjson=fileloadservice.upload(file_bus_id,file_bus_type,multipartFile);
							return this.success(recordjson);
						/*}else{
							return this.error("文件格式错误");
						}*/
                    }
                }
            }
        } catch (Exception e) {
        	e.printStackTrace();
			// 处理文件尺寸过大异常
			if (e instanceof SizeLimitExceededException) {
				return this.error( "文件尺寸超过规定大小:" + MAX_SIZE / 1024 / 1024 + "M");
			}
			return this.error(e.getMessage());
        }
    	return null;

    }

    
    /**
 	 * 跳转至文件上传页面
 	 * @param request
 	 * @return
 	 */
 	@RequestMapping("/toExcelFileUpload")
 	public ModelAndView toExcelFileUpload(HttpServletRequest request,Model modell,SysExcelBatch sExcelBatch) throws Exception {
 		ModelAndView modelAndView=new ModelAndView("common/fileupload/excelfileUpload");
 		modelAndView.addObject("sExcelBatch", sExcelBatch);
 		return modelAndView;
 	}
 	
    /**
     * excel文件上传
     *
     * @param request
     * @param response
     * @return
     * @throws AppException
     */
    @RequestMapping("/excelupload")
    @ResponseBody
    public AjaxReturnMsg<String>  excelUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//excel上传文件类型
    	String excel_batch_excel_type=request.getParameter("excel_batch_excel_type");
    	//excel上传文件类型
        if(null==excel_batch_excel_type||excel_batch_excel_type.equals("")){
        	return this.error( "上传文件类型数为空,请检查");
        }
        
        SysExcelType sysExcelType=fileloadservice.getExcelFileTypeInfo(excel_batch_excel_type);
        
        if(null==sysExcelType){
        	return this.error( "找不到 excel业务类型为"+excel_batch_excel_type+"的配置信息,请检查");
        }
        
        String userid="admin";
        
		long MAX_SIZE = 100* 1024 * 1024L;//100M
		
    	try {
            //创建一个通用的多部分解析器
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            //判断 request 是否有文件上传,即多部分请求
            if (multipartResolver.isMultipart(request)) {
                //转换成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                //取得request中的所有文件名
                Iterator<String> iter = multiRequest.getFileNames();
                while (iter.hasNext()) {
                    //取得上传文件
                    MultipartFile multipartFile = multiRequest.getFile(iter.next());
                    if (multipartFile.getSize() > MAX_SIZE) {
                    	return this.error( "文件尺寸超过规定大小:" + MAX_SIZE / 1024 / 1024 + "M");
                    } else {
                        // 得到去除路径的文件名
                        String originalFilename = multipartFile.getOriginalFilename();
                        int indexofdoute = originalFilename.lastIndexOf(".");

						if(FileUtil.getFileType(multipartFile.getInputStream())!= FileType.XLS_DOC){
                             /**获取文件的后缀**/
							String endfix = "";
							if (indexofdoute != -1) {
								// 尾
								endfix = originalFilename.substring(indexofdoute).toLowerCase();
								if(endfix.equals(".xlsx")) {
									//上传并记录日志
									String recordjson=fileloadservice.uploadexcel(originalFilename,sysExcelType,userid,multipartFile.getInputStream() );
									log.info(recordjson);
									return this.success(recordjson);
								}else{
									return this.error("文件格式不正确,请确认,只允许上传格式为xlsx格式的文件");
								}
							}else{
								return this.error("文件格式错误");
							}
						}else{
							return this.error("文件格式错误");
						}

                    }
                }
            }
        } catch (Exception e) {
        	e.printStackTrace();
			// 处理文件尺寸过大异常
			if (e instanceof SizeLimitExceededException) {
				return this.error( "文件尺寸超过规定大小:" + MAX_SIZE / 1024 / 1024 + "M");
			}
			return this.error(e.getMessage());
        }
    	return null;

    }

    
    /**
	 * 通过id删除文件信息
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/deletebyid/{id}")
	@ResponseBody
	public AjaxReturnMsg<String> deleteFileByid(HttpServletRequest request,Model model,@PathVariable String id){
		return fileloadservice.deleteFileByFileid(id);
	}
	
	/**
	 * 批量删除
	 * @param request
	 * @param model
	 * @param sFileRecord
	 * @return
	 */
	@RequestMapping("/batdelete")
	@ResponseBody
	public AjaxReturnMsg<String> batdelete(HttpServletRequest request,Model model,SysFileRecord sFileRecord){
		return fileloadservice.batDeleteData(sFileRecord);
	}
	
    /**
     * 文件下载
     * @param request
     * @param response
     * @throws AppException
     */
    @RequestMapping(value = "/download/{bus_uuid}")
    public void download(@PathVariable(value="bus_uuid") String bus_uuid, HttpServletRequest request ,HttpServletResponse response) throws  AppException{
        try{
        	SysFileRecord filerecord=fileloadservice.getFileInfo(bus_uuid);
        	if(filerecord!=null){
        		// byte[] temp=fileloadservice.download(filerecord.getFile_path());
                 //if(temp!=null){
                 	//此行代码是防止中文乱码的关键！！
                     response.setHeader("Content-disposition","attachment; filename="+ new String(filerecord.getFile_name().getBytes("GBK"),"iso-8859-1"));
                     BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(filerecord.getFile_path())));
                     BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
                     //新建一个2048字节的缓冲区
                     byte[] buff = new byte[2048];
                     int bytesRead=0;
                     while ((bytesRead = bis.read(buff, 0, buff.length)) != -1) {
                         bos.write(buff,0,bytesRead);
                     }
                     bos.flush();
                     if (bis != null)
                         bis.close();
                     if (bos != null)
                         bos.close();
                 }else{
                 	throw new Exception("下载错误,不存在的id");
                 }
        	//}
        }catch(Exception e){
            //log.error(e.getMessage());
        }
    }
    
    /**
     * excel文件下载 
     * @param request
     * @param response
     * @throws AppException
     */
    @RequestMapping(value = "/exceldownload/{excel_batch_number}")
    public void exceldownload(@PathVariable(value="excel_batch_number") String excel_batch_number, HttpServletRequest request ,HttpServletResponse response) throws  AppException{
        try{
        	SysExcelBatch sExcelBatch=fileloadservice.getExcelBatchByNumber(excel_batch_number);
        	if(sExcelBatch!=null){
        		 byte[] temp=fileloadservice.download(sExcelBatch.getExcel_error_file_path());
                 if(temp!=null){
                	 int indexofdoute = sExcelBatch.getExcel_batch_file_name().lastIndexOf(".");
 					/**文件名及后缀*/
 					String filename = sExcelBatch.getExcel_batch_file_name().substring(0, indexofdoute)+".csv";
                 	//此行代码是防止中文乱码的关键！！
                     response.setHeader("Content-disposition","attachment; filename="+ new String(filename.getBytes("GBK"),"iso-8859-1"));
                     BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(temp));
                     BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
                     //新建一个2048字节的缓冲区
                     byte[] buff = new byte[2048];
                     int bytesRead=0;
                     while ((bytesRead = bis.read(buff, 0, buff.length)) != -1) {
                         bos.write(buff,0,bytesRead);
                     }
                     bos.flush();
                     if (bis != null)
                         bis.close();
                     if (bos != null)
                         bos.close();
                 }else{
                 	throw new Exception("下载错误,不存在的id");
                 }
        	}
        }catch(Exception e){
            //log.error(e.getMessage());
        }
    }


	/**
	 * 文件断点下载
	 */
	@RequestMapping(value="/rangedownload/{bus_uuid}")
	public void rangedownload(@PathVariable(value="bus_uuid") String bus_uuid, HttpServletRequest request ,HttpServletResponse response) throws Exception {
		SysFileRecord filerecord=fileloadservice.getFileInfo(bus_uuid);
		if(filerecord!=null) {
			String filename = filerecord.getFile_path();

			RandomAccessFile raFile = new RandomAccessFile(filename, "r");

			//通过获取头header中的range
			String range = request.getHeader("RANGE");
			int start = 0, end = 0;
			if (null != range && range.startsWith("bytes=")) {
				String[] values = range.split("=")[1].split("-");
				start = Integer.parseInt(values[0]);
				end = Integer.parseInt(values[1]);
			}
			int requestSize = 0;
			if (end != 0 && end > start) {
				requestSize = end - start + 1;
				//返回header
				response.addHeader("content-length", "" + (requestSize));
			} else {
				requestSize = Integer.MAX_VALUE;
			}

			byte[] buffer = new byte[4096];
			response.setContentType("application/x-download");
			filename = new String(filename.getBytes("UTF-8"), "ISO8859-1");
			response.addHeader("Content-Disposition", "attachment;filename=" + filename);
			ServletOutputStream os = response.getOutputStream();
			int needSize = requestSize;
			raFile.seek(start);
			while (needSize > 0) {
				int len = raFile.read(buffer);
				if (needSize < buffer.length) {
					os.write(buffer, 0, needSize);
				} else {
					os.write(buffer, 0, len);
					if (len < buffer.length) {
						break;
					}
				}
				needSize -= buffer.length;
			}

			raFile.close();
			os.close();

		}else{
			throw new Exception("下载错误,不存在的id");
		}
	}

}
