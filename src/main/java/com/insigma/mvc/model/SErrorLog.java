package com.insigma.mvc.model;

import java.util.Date;

/**
 * SErrorLog
 */
public class SErrorLog extends PageInfo implements java.io.Serializable{

    private String logid;
    private String message;
    private String stackmsg;
    private Date logtime;
    private String exceptiontype;
    private String usergent;
    private String ipaddr;
    private String url;
    private transient String logtime_string;//����ʱ��
    private String referer;
    private String userid;

    
    public String getLogtime_string() {
		return logtime_string;
	}

	public void setLogtime_string(String logtime_string) {
		this.logtime_string = logtime_string;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
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

    private String cookie;


    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
