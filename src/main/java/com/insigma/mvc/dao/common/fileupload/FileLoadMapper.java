package com.insigma.mvc.dao.common.fileupload;

import java.util.List;
import java.util.Map;

import com.insigma.mvc.model.SysExcelBatch;
import com.insigma.mvc.model.SysExcelType;
import com.insigma.mvc.model.SysFileRecord;



/**
 * 文件记录保存
 * @author admin
 *
 */
public interface FileLoadMapper {

	/**
	 * 保存文件记录
	 * @param sfilerecord
	 */
	public void saveFileRecord( SysFileRecord sfilerecord);


	/**
	 * 通过业务id查询文件
	 * @param file_uuid
	 * @return
	 */
	public SysFileRecord getFileRecordByFileId(String file_uuid);

	/**
	 *
	 * @param sFileRecord
	 * @return
	 */
	public List<SysFileRecord> getFileRecordListByFileId(SysFileRecord sFileRecord);

	/**
	 * 通过文件编号删除文件
	 * @param file_uuid
	 * @return
	 */
	public int deleteFileByFileId(String file_uuid);

	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	public int batDeleteData(String[] ids);

	/**
	 *  通过文件id数组更新业务id及业务状态为有效状态
	 * @return
	 */
	public int batupdateBusIdByBusUuidArray(Map<String,Object> map);


	/**
	 * 保存excel文件上传记录表
	 * @param sExcelBatch
	 */
	public void saveExelBatch(SysExcelBatch sExcelBatch);


	/**
	 * 更新文件记录表
	 * @param sExcelBatch
	 */
	public void updateExelBatch(SysExcelBatch sExcelBatch);

	/**
	 * 通过id获取批次号
	 * @param id
	 * @return
	 */
	public SysExcelBatch getExcelBatchById(String id);


	public SysExcelBatch getExcelBatchByNumber(String number);
	/**
	 * 分页查询
	 * @param sExcelBatch
	 * @return
	 */
	public List<SysExcelBatch> getExcelBatchList(SysExcelBatch sExcelBatch);

	/**
	 * 通过批次号删除批次信息
	 * @param number
	 * @return
	 */
	public int deleteExcelBatchByNumber(String number);



	public int updateExelBatchErrorFilePath(SysExcelBatch sExcelBatch);


	/**
	 * 获取文件类型信息
	 * @param businesstype
	 * @return
	 */
	SysExcelType getExcelFileTypeInfo(String businesstype);
}
