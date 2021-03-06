package com.insigma.mvc.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

/**
 * 系统框架表之系统日志表
 * @author admin
 *
 */
//@Table(name="sys_log")//默认情况下可以不写表名与持久化类名相同
//@Entity //表明这是一个持久化类
public class SysLog  extends PageInfo implements java.io.Serializable{
	//@GeneratedValue(generator="system-uuid")
	//@GenericGenerator(name="system-uuid",strategy="uuid")
	//@Id //定义数据列
	private String logid	;//			日志id
	//@Transient
	private String messagetype;//消息类型
    private String interfacetype	;//			接口类型代码
    private String message	;//		日志标题

	//@Temporal(TemporalType.DATE)
    private Date logtime	;//		发生时间
	//@Transient
    private String logtime_string;//发生时间
    private String cost;//		请求耗费时间
    //@Lob
    private String stackmsg	;//		异常栈信息
    private String exceptiontype	;//		异常类型
    private String usergent	;//		user-agent
    private String ipaddr	;//		客户端ip地址
    private String referer	;//		refer
    private String url	;//		请求的地址
    private String userid	;//		当前操作人员id
    private String cookie	;//		cookie
    private String appkey	;//		appkey
    //@Lob
    private String queryparam	;//		请求参数信息
    private String method	;//		请求方法类型
    private String success	;//	请求是否成功
    //@Lob
    private String responsemsg ;//	返回信息
    private String token;//请求jwt状态码

	public String getLogtime_string() {
		return logtime_string;
	}
	public void setLogtime_string(String logtime_string) {
		this.logtime_string = logtime_string;
	}
	public String getMessagetype() {
		return messagetype;
	}
	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getLogid() {
		return logid;
	}
	public void setLogid(String logid) {
		this.logid = logid;
	}
	public String getInterfacetype() {
		return interfacetype;
	}
	public void setInterfacetype(String interfacetype) {
		this.interfacetype = interfacetype;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getLogtime() {
		return logtime;
	}
	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getStackmsg() {
		return stackmsg;
	}
	public void setStackmsg(String stackmsg) {
		this.stackmsg = stackmsg;
	}
	public String getExceptiontype() {
		return exceptiontype;
	}
	public void setExceptiontype(String exceptiontype) {
		this.exceptiontype = exceptiontype;
	}
	public String getUsergent() {
		return usergent;
	}
	public void setUsergent(String usergent) {
		this.usergent = usergent;
	}
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public String getReferer() {
		return referer;
	}
	public void setReferer(String referer) {
		this.referer = referer;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public String getAppkey() {
		return appkey;
	}
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	public String getQueryparam() {
		return queryparam;
	}
	public void setQueryparam(String queryparam) {
		this.queryparam = queryparam;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getResponsemsg() {
		return responsemsg;
	}
	public void setResponsemsg(String responsemsg) {
		this.responsemsg = responsemsg;
	}
    
}