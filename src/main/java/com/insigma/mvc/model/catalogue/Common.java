package com.insigma.mvc.model.catalogue;

import com.insigma.mvc.model.PageInfoClModel;

public class Common extends PageInfoClModel {

    protected String userid;
    protected String createtime;
    protected String groupid;
    protected String edituserid;
    protected String editgroupid;
    protected String edittime;
    protected String status;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getEdittime() {
		return edittime;
	}
	public void setEdittime(String edittime) {
		this.edittime = edittime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getEditgroupid() {
		return editgroupid;
	}
	public void setEditgroupid(String editgroupid) {
		this.editgroupid = editgroupid;
	}
	public String getEdituserid() {
		return edituserid;
	}
	public void setEdituserid(String edituserid) {
		this.edituserid = edituserid;
	}
	
	

    
}
