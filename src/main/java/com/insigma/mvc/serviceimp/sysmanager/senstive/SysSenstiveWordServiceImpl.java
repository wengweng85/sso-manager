package com.insigma.mvc.serviceimp.sysmanager.senstive;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insigma.common.util.EhCacheUtil;
import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.dao.sysmanager.senstive.SysSenstiveWordMapper;
import com.insigma.mvc.model.SysSenstiveWord;
import com.insigma.mvc.service.sysmanager.senstive.SysSenstiveWordService;
import net.sf.ehcache.Element;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 系统参数service
 * @author admin
 *
 */
@Service
public class SysSenstiveWordServiceImpl extends MvcHelper implements SysSenstiveWordService {

	@Resource
	private SysSenstiveWordMapper sysSenstiveWordMapper;

	@Override
	public List<SysSenstiveWord> getList(){
		return sysSenstiveWordMapper.getList();
	}
	
	
	@Override
	public HashMap<String, Object> getPageList(SysSenstiveWord sysSenstiveWord) {
		PageHelper.offsetPage(sysSenstiveWord.getOffset(), sysSenstiveWord.getLimit());
		List<SysSenstiveWord> list=sysSenstiveWordMapper.getPageList(sysSenstiveWord);
		PageInfo<SysSenstiveWord> pageinfo = new PageInfo<SysSenstiveWord>(list);
		return this.success_hashmap_response(pageinfo);
	}


	@Override
	public AjaxReturnMsg<String> updateparam(SysSenstiveWord sysSenstiveWord) {
		return null;
	}


	@Override
	public AjaxReturnMsg<String> deleteparambyid(String paramid) {
		// TODO Auto-generated method stub
		int deletenum=sysSenstiveWordMapper.deleteparambyid(paramid);
		return this.success("删除成功");
	}

}