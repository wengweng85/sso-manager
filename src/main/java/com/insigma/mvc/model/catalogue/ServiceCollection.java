package com.insigma.mvc.model.catalogue;

import com.insigma.mvc.model.PageInfoClModel;

/**
 * 服务收藏记录表
 */
public class ServiceCollection extends PageInfoClModel {

    private String collect_id;
    private String cata_id;
    private String userId;
    private String createTime;
    private String status;
    private String cata_name;
    private String cata_url;

    public String getCollect_id() {
        return collect_id;
    }

    public void setCollect_id(String collect_id) {
        this.collect_id = collect_id;
    }

    public String getCata_id() {
        return cata_id;
    }

    public void setCata_id(String cata_id) {
        this.cata_id = cata_id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getCata_name() {
        return cata_name;
    }

    public void setCata_name(String cata_name) {
        this.cata_name = cata_name;
    }

    public String getCata_url() {
        return cata_url;
    }

    public void setCata_url(String cata_url) {
        this.cata_url = cata_url;
    }
}
