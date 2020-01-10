package com.insigma.mvc.model.catalogue;

/**
 * 服务目录事项类型表
 */
public class ServiceEventType extends Common {

    private String event_type_id;
    private String bus_area_code;
    private String event_type_code;
    private String event_type_name;
    private Integer event_type_sort;
    private String event_type_pingyin;
    private String event_type_desc;
    private String event_type_bigimg;
    private String event_type_bigimgtype;
    private String event_type_smallimg;
    private String event_type_smalltype;
    private String parent_event_type_id;

    public String getEvent_type_id() {
        return event_type_id;
    }

    public void setEvent_type_id(String event_type_id) {
        this.event_type_id = event_type_id;
    }

    public String getBus_area_code() {
        return bus_area_code;
    }

    public void setBus_area_code(String bus_area_code) {
        this.bus_area_code = bus_area_code;
    }

    public String getEvent_type_code() {
        return event_type_code;
    }

    public void setEvent_type_code(String event_type_code) {
        this.event_type_code = event_type_code;
    }

    public String getEvent_type_name() {
        return event_type_name;
    }

    public void setEvent_type_name(String event_type_name) {
        this.event_type_name = event_type_name;
    }

    public Integer getEvent_type_sort() {
        return event_type_sort;
    }

    public void setEvent_type_sort(Integer event_type_sort) {
        this.event_type_sort = event_type_sort;
    }

    public String getEvent_type_pingyin() {
        return event_type_pingyin;
    }

    public void setEvent_type_pingyin(String event_type_pingyin) {
        this.event_type_pingyin = event_type_pingyin;
    }

    public String getEvent_type_desc() {
        return event_type_desc;
    }

    public void setEvent_type_desc(String event_type_desc) {
        this.event_type_desc = event_type_desc;
    }

    public String getEvent_type_bigimg() {
        return event_type_bigimg;
    }

    public void setEvent_type_bigimg(String event_type_bigimg) {
        this.event_type_bigimg = event_type_bigimg;
    }

    public String getEvent_type_bigimgtype() {
        return event_type_bigimgtype;
    }

    public void setEvent_type_bigimgtype(String event_type_bigimgtype) {
        this.event_type_bigimgtype = event_type_bigimgtype;
    }

    public String getEvent_type_smallimg() {
        return event_type_smallimg;
    }

    public void setEvent_type_smallimg(String event_type_smallimg) {
        this.event_type_smallimg = event_type_smallimg;
    }

    public String getEvent_type_smalltype() {
        return event_type_smalltype;
    }

    public void setEvent_type_smalltype(String event_type_smalltype) {
        this.event_type_smalltype = event_type_smalltype;
    }

    public String getParent_event_type_id() {
        return parent_event_type_id;
    }

    public void setParent_event_type_id(String parent_event_type_id) {
        this.parent_event_type_id = parent_event_type_id;
    }
}
