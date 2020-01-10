package com.insigma.mvc.model.catalogue;

/**
 * 服务目录事项环节附件信息表
 */
public class ServiceCatalogueAttach extends Common {

    private String cata_attch_id;
    private String cata_attch_code;
    private String cata_detail_id;
    private String cata_attch_name;
    private String cata_attch_pingyin;
    private String cata_attch_desc;
    private int cata_attch_sort;
    private String cata_attch_filetype;
    private long cata_attch_filesize;
    private String cata_attch_file_location;
    private String cata_attch_file_blob;

    public String getCata_attch_id() {
        return cata_attch_id;
    }

    public void setCata_attch_id(String cata_attch_id) {
        this.cata_attch_id = cata_attch_id;
    }

    public String getCata_attch_code() {
        return cata_attch_code;
    }

    public void setCata_attch_code(String cata_attch_code) {
        this.cata_attch_code = cata_attch_code;
    }

    public String getCata_detail_id() {
        return cata_detail_id;
    }

    public void setCata_detail_id(String cata_detail_id) {
        this.cata_detail_id = cata_detail_id;
    }

    public String getCata_attch_name() {
        return cata_attch_name;
    }

    public void setCata_attch_name(String cata_attch_name) {
        this.cata_attch_name = cata_attch_name;
    }

    public String getCata_attch_pingyin() {
        return cata_attch_pingyin;
    }

    public void setCata_attch_pingyin(String cata_attch_pingyin) {
        this.cata_attch_pingyin = cata_attch_pingyin;
    }

    public String getCata_attch_desc() {
        return cata_attch_desc;
    }

    public void setCata_attch_desc(String cata_attch_desc) {
        this.cata_attch_desc = cata_attch_desc;
    }

    public int getCata_attch_sort() {
        return cata_attch_sort;
    }

    public void setCata_attch_sort(int cata_attch_sort) {
        this.cata_attch_sort = cata_attch_sort;
    }

    public String getCata_attch_filetype() {
        return cata_attch_filetype;
    }

    public void setCata_attch_filetype(String cata_attch_filetype) {
        this.cata_attch_filetype = cata_attch_filetype;
    }

    public long getCata_attch_filesize() {
        return cata_attch_filesize;
    }

    public void setCata_attch_filesize(long cata_attch_filesize) {
        this.cata_attch_filesize = cata_attch_filesize;
    }

    public String getCata_attch_file_location() {
        return cata_attch_file_location;
    }

    public void setCata_attch_file_location(String cata_attch_file_location) {
        this.cata_attch_file_location = cata_attch_file_location;
    }

    public String getCata_attch_file_blob() {
        return cata_attch_file_blob;
    }

    public void setCata_attch_file_blob(String cata_attch_file_blob) {
        this.cata_attch_file_blob = cata_attch_file_blob;
    }
}
