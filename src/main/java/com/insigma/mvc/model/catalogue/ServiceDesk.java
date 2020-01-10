package com.insigma.mvc.model.catalogue;

/**
 * 服务办理记录表
 */
public class ServiceDesk {

    private String desk_id;
    private String desk_code;
    private String cata_id;
    private String userid;
    private String createTime;
    private String status;

    public String getDesk_id() {
        return desk_id;
    }

    public void setDesk_id(String desk_id) {
        this.desk_id = desk_id;
    }

    public String getDesk_code() {
        return desk_code;
    }

    public void setDesk_code(String desk_code) {
        this.desk_code = desk_code;
    }

    public String getCata_id() {
        return cata_id;
    }

    public void setCata_id(String cata_id) {
        this.cata_id = cata_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
