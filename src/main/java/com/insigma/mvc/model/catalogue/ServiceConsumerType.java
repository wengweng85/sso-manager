package com.insigma.mvc.model.catalogue;

/**
 * 服务目录服务对象表
 */
public class ServiceConsumerType extends Common {

    private String consumer_type_id;
    private String bus_area_code;
    private String consumer_type_code;
    private String consumer_type_name;
    private Integer consumer_type_sort;
    private String consumer_type_pingyin;
    private String consumer_type_desc;

    public String getConsumer_type_id() {
        return consumer_type_id;
    }

    public void setConsumer_type_id(String consumer_type_id) {
        this.consumer_type_id = consumer_type_id;
    }

    public String getBus_area_code() {
        return bus_area_code;
    }

    public void setBus_area_code(String bus_area_code) {
        this.bus_area_code = bus_area_code;
    }

    public String getConsumer_type_code() {
        return consumer_type_code;
    }

    public void setConsumer_type_code(String consumer_type_code) {
        this.consumer_type_code = consumer_type_code;
    }

    public String getConsumer_type_name() {
        return consumer_type_name;
    }

    public void setConsumer_type_name(String consumer_type_name) {
        this.consumer_type_name = consumer_type_name;
    }

    public Integer getConsumer_type_sort() {
        return consumer_type_sort;
    }

    public void setConsumer_type_sort(Integer consumer_type_sort) {
        this.consumer_type_sort = consumer_type_sort;
    }

    public String getConsumer_type_pingyin() {
        return consumer_type_pingyin;
    }

    public void setConsumer_type_pingyin(String consumer_type_pingyin) {
        this.consumer_type_pingyin = consumer_type_pingyin;
    }

    public String getConsumer_type_desc() {
        return consumer_type_desc;
    }

    public void setConsumer_type_desc(String consumer_type_desc) {
        this.consumer_type_desc = consumer_type_desc;
    }
}
