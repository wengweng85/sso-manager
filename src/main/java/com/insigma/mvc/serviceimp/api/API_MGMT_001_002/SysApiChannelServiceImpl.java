package com.insigma.mvc.serviceimp.api.API_MGMT_001_002;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.insigma.common.util.RandomNumUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insigma.common.util.UUIDGenerator;
import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.MvcHelper;
import com.insigma.mvc.dao.api.API_MGMT_001_002.SysApiChannelMapper;
import com.insigma.mvc.model.SysApiChannel;
import com.insigma.mvc.model.SysApiChannelInterface;
import com.insigma.mvc.model.SysApiInterface;
import com.insigma.mvc.service.api.API_MGMT_001_002.SysApiChannelService;

/**
 *
 * ��������ӿ�ʵ��
 * @author admin
 *
 */
@Service
@Transactional
public class SysApiChannelServiceImpl  extends MvcHelper<SysApiChannel> implements SysApiChannelService {

	
	@Resource
	private SysApiChannelMapper  sApiChannelMapper;
	
	
	
	@Override
	public HashMap<String, Object> getList(SysApiChannel sApiChannel) {
		PageHelper.offsetPage(sApiChannel.getOffset(), sApiChannel.getLimit());
		List<SysApiChannel> list=sApiChannelMapper.getList(sApiChannel);
		PageInfo<SysApiChannel> pageinfo = new PageInfo<SysApiChannel>(list);
		return this.success_hashmap_response(pageinfo);
	}


	@Override
	@Transactional
	public AjaxReturnMsg<String> saveData(SysApiChannel sApiChannel) {
		//�ж��Ƿ���� ����
		if(StringUtils.isEmpty(sApiChannel.getChannelId())){
			//����appkey���� 8λ�����
			sApiChannel.setChannelAppkey(RandomNumUtil.getRandomString(8));
			sApiChannel.setChannelStatus("-1");//�����
			sApiChannel.setAddtime(new Date());//����ʱ��
			int insertnum=sApiChannelMapper.insert(sApiChannel);
			if(insertnum==1){
				return this.success("�����ɹ�");
			}else{
				return this.error("�����ɹ�,��ȷ�ϴ˷����Ƿ��Ѿ���ɾ��");
			}
		}else{
			int updatenum=sApiChannelMapper.updateByPrimaryKeySelective(sApiChannel);
			if(updatenum==1){
				return this.success("���³ɹ�");
			}else{
				return this.error("����ʧ��,��ȷ�ϴ˷����Ƿ��Ѿ���ɾ��");
			}
		}
	}

	@Override
	public SysApiChannel getSApiChannelById(String interfaceId) {
		return sApiChannelMapper.selectByPrimaryKey(interfaceId);
	}


	@Override
	public SysApiChannel getSApiChannelDataById(String interfaceId) {
		return sApiChannelMapper.selectDataByPrimaryKey(interfaceId);
	}


	@Override
	public AjaxReturnMsg<String> updatestatus(SysApiChannel sApiChannel) {
		int updatenum=sApiChannelMapper.updateByPrimaryKeySelective(sApiChannel);
		if(updatenum==1){
			return this.success("���³ɹ�");
		}else{
			return this.error("����ʧ��,��ȷ�ϴ˷����Ƿ��Ѿ���ɾ��");
		}
	}

	@Override
	public List<SysApiInterface> getApiInterfaceTree(String channelid) {
		return sApiChannelMapper.getApiInterfaceTree(channelid);
	}

	@Override
	public AjaxReturnMsg<String> saveChannelInterface(SysApiChannel sApiChannel) {
		sApiChannelMapper.deleteChannelInterfaceByChannelId(sApiChannel.getChannelId());
		String[] selectnodes= sApiChannel.getSelectnodes().split(",");
		List<SysApiChannelInterface> list=new ArrayList<SysApiChannelInterface>();
		for(int i=0;i<selectnodes.length;i++){
			String tempid=selectnodes[i];
			if(null!=tempid&&!tempid.equals("")){
				SysApiChannelInterface tempinterface=new SysApiChannelInterface();
				tempinterface.setChannelId(sApiChannel.getChannelId());
				tempinterface.setInterfaceId(tempid);
				tempinterface.setIsvalid("1");
				tempinterface.setAddtime(new Date());
				list.add(tempinterface);
			}
		}
		if(list.size()>0){
			sApiChannelMapper.batIinsertChannelInterface(list);
		}	
	   return this.success("����������³ɹ�");
	}


	@Override
	public SysApiChannel getApiChannelByAppkey(String appkey) {
		return sApiChannelMapper.getApiChannelByAppkey(appkey);
	}


	@Override
	public List<SysApiChannel> getAllApiChannelList() {
		return sApiChannelMapper.getAllApiChannelList();
	}


}