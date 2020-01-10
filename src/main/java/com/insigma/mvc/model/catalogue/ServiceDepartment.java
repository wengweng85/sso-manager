package com.insigma.mvc.model.catalogue;


/**
 * 受理部门基本信息
 */
public class ServiceDepartment extends Common  {

    private String department_id;
    private String department_address;
    private String department_longitude;
    private String department_latitude;
    private String department_tel;
    private String department_linkman;
    private String userid;
    private String createtime;
    private String status;
    private String department_name;
    private String groupId;
    private String department_name_abb;

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_address() {
        return department_address;
    }

    public void setDepartment_address(String department_address) {
        this.department_address = department_address;
    }

    public String getDepartment_longitude() {
        return department_longitude;
    }

    public void setDepartment_longitude(String department_longitude) {
        this.department_longitude = department_longitude;
    }

    public String getDepartment_latitude() {
        return department_latitude;
    }

    public void setDepartment_latitude(String department_latitude) {
        this.department_latitude = department_latitude;
    }

    public String getDepartment_tel() {
        return department_tel;
    }

    public void setDepartment_tel(String department_tel) {
        this.department_tel = department_tel;
    }

    public String getDepartment_linkman() {
        return department_linkman;
    }

    public void setDepartment_linkman(String department_linkman) {
        this.department_linkman = department_linkman;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_name_abb() {
        return department_name_abb;
    }

    public void setDepartment_name_abb(String department_name_abb) {
        this.department_name_abb = department_name_abb;
    }
}
