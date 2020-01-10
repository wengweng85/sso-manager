package com.insigma.mvc.serviceimp.WEBPERM_001_001.systype;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.dao.WEBPERM_001_001.systype.WebSystypeMapper;
import com.insigma.mvc.model.SSysType;
import com.insigma.mvc.service.WEBPERM_001_001.systype.WebSystypeService;

/**
 * 系统类型管理service
 * @author admin
 *
 */
@Service
public class WebSystypeServiceImpl extends MvcHelper implements WebSystypeService {

	@Resource
	private WebSystypeMapper webSystypeMapper;

	@Override
	public List<SSysType> getList(){
		return webSystypeMapper.getList();
	}
	
	
	@Override
	public HashMap<String, Object> getPageList(SSysType type) {
		PageHelper.offsetPage(type.getOffset(), type.getLimit());
		List<SSysType> list=webSystypeMapper.getPageList(type);
		PageInfo<SSysType> pageinfo = new PageInfo<SSysType>(list);
		return this.success_hashmap_response(pageinfo);
	}


	@Override
	public AjaxReturnMsg<String> updateSystype(SSysType type) {
		SSysType istypeexist=webSystypeMapper.getSystypeByid(type.getSystypeid());
		//更新
		if(istypeexist!=null){
			webSystypeMapper.updateSystype(type);
			return this.success("更新成功");
		}
	    //新增
		{
			int addnum=webSystypeMapper.addSystype(type);
			return this.success("新增成功");
		}
	}


	@Override
	public AjaxReturnMsg<String> deleteSystypebyId(String paramid) {
		// TODO Auto-generated method stub
		int deletenum=webSystypeMapper.deleteSystypebyId(paramid);
		return this.success("删除成功");
	}

}