package com.insigma.mvc.model.catalogue;

import java.util.List;

/**
 * 服务目录事项环节信息表
 */
public class ServiceCatalogueDetail extends Common {

    private String cata_detail_id;
    private String cata_detail_code;
    private String cata_id;
    private String cata_detail_name;
    private String cata_detail_pingyin;
    private String cata_detail_desc;
    private Integer cata_detail_sort;
    private String cata_detail_bigimg;
    private String cata_detail_bigimgtype;
    private String cata_detail_smallimg;
    private String cata_detail_smalltype;

    private List<ServiceCatalogueAttach> attachList;

    public String getCata_detail_id() {
        return cata_detail_id;
    }

    public void setCata_detail_id(String cata_detail_id) {
        this.cata_detail_id = cata_detail_id;
    }

    public String getCata_detail_code() {
        return cata_detail_code;
    }

    public void setCata_detail_code(String cata_detail_code) {
        this.cata_detail_code = cata_detail_code;
    }

    public String getCata_id() {
        return cata_id;
    }

    public void setCata_id(String cata_id) {
        this.cata_id = cata_id;
    }

    public String getCata_detail_name() {
        return cata_detail_name;
    }

    public void setCata_detail_name(String cata_detail_name) {
        this.cata_detail_name = cata_detail_name;
    }

    public String getCata_detail_pingyin() {
        return cata_detail_pingyin;
    }

    public void setCata_detail_pingyin(String cata_detail_pingyin) {
        this.cata_detail_pingyin = cata_detail_pingyin;
    }

    public String getCata_detail_desc() {
        return cata_detail_desc;
    }

    public void setCata_detail_desc(String cata_detail_desc) {
        this.cata_detail_desc = cata_detail_desc;
    }

    public Integer getCata_detail_sort() {
        return cata_detail_sort;
    }

    public void setCata_detail_sort(Integer cata_detail_sort) {
        this.cata_detail_sort = cata_detail_sort;
    }

    public String getCata_detail_bigimg() {
        return cata_detail_bigimg;
    }

    public void setCata_detail_bigimg(String cata_detail_bigimg) {
        this.cata_detail_bigimg = cata_detail_bigimg;
    }

    public String getCata_detail_bigimgtype() {
        return cata_detail_bigimgtype;
    }

    public void setCata_detail_bigimgtype(String cata_detail_bigimgtype) {
        this.cata_detail_bigimgtype = cata_detail_bigimgtype;
    }

    public String getCata_detail_smallimg() {
        return cata_detail_smallimg;
    }

    public void setCata_detail_smallimg(String cata_detail_smallimg) {
        this.cata_detail_smallimg = cata_detail_smallimg;
    }

    public String getCata_detail_smalltype() {
        return cata_detail_smalltype;
    }

    public void setCata_detail_smalltype(String cata_detail_smalltype) {
        this.cata_detail_smalltype = cata_detail_smalltype;
    }

    public List<ServiceCatalogueAttach> getAttachList() {
        return attachList;
    }

    public void setAttachList(List<ServiceCatalogueAttach> attachList) {
        this.attachList = attachList;
    }
}
