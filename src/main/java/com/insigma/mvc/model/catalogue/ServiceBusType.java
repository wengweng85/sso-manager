package com.insigma.mvc.model.catalogue;

/**
 * 服务目录业务分类表
 */
public class ServiceBusType extends Common {

    private String bus_type_id;
    private String bus_area_code;
    private String bus_type_code;
    private String bus_type_name;
    private int bus_type_sort;
    private String bus_type_pingyin;
    private String bus_type_bigimg;
    private String bus_type_desc;
    private String count;

    public String getBus_type_id() {
        return bus_type_id;
    }

    public void setBus_type_id(String bus_type_id) {
        this.bus_type_id = bus_type_id;
    }

    public String getBus_area_code() {
        return bus_area_code;
    }

    public void setBus_area_code(String bus_area_code) {
        this.bus_area_code = bus_area_code;
    }

    public String getBus_type_code() {
        return bus_type_code;
    }

    public void setBus_type_code(String bus_type_code) {
        this.bus_type_code = bus_type_code;
    }

    public String getBus_type_name() {
        return bus_type_name;
    }

    public void setBus_type_name(String bus_type_name) {
        this.bus_type_name = bus_type_name;
    }

    public int getBus_type_sort() {
        return bus_type_sort;
    }

    public void setBus_type_sort(int bus_type_sort) {
        this.bus_type_sort = bus_type_sort;
    }

    public String getBus_type_pingyin() {
        return bus_type_pingyin;
    }

    public void setBus_type_pingyin(String bus_type_pingyin) {
        this.bus_type_pingyin = bus_type_pingyin;
    }

    public String getBus_type_desc() {
        return bus_type_desc;
    }

    public void setBus_type_desc(String bus_type_desc) {
        this.bus_type_desc = bus_type_desc;
    }

	public String getBus_type_bigimg() {
		return bus_type_bigimg;
	}

	public void setBus_type_bigimg(String bus_type_bigimg) {
		this.bus_type_bigimg = bus_type_bigimg;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

   
}
