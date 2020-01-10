package com.insigma.mvc.model.catalogue;

/**
 * 事项表
 */
public class ServiceCatalogue extends Common {

    private String cata_id;
    private String cata_code;
    private String cata_name;
    private String cata_pingyin;
    private String cata_desc;
    private int cata_sort;
    private String bus_type_id;
    private String event_type_id;
    private String consumer_type_id;
    private String power_type_id;
    private String department_id;
    private String cata_hand_time_limit;
    private String cata_promise_time_limit;
    private String cata_complaint_tel;
    private String cata_is_net;

    private String cata_video_url;
    private String cata_is_charge;
    private String cata_establish;
    private String cata_hand_term;
    private String cata_app_material;
    private String cata_process;
    private String cata_process_pic;
    private String cata_process_type;

    private String department_tel;
    private String department_linkman;
    private Double department_longitude;
    private Double department_latitude;
    private String department_address;
    private String department_route;
    private String department_work_time;

    private String bus_type_name;
    private String event_type_name;
    private String consumer_type_name;
    private String power_type_name;
    private String department_name;

    private String cata_url;

    private String is_collect = "0"; // 该事项是否已收藏

    private String id;
    private String name;
    private String isParent;
    private String type;

    private String userId;

    private String groupid;
    private String groupname;

    private String cata_type;//办件类型
    private String result_department_id;//决定机构
    private String result_department_name;//决定机构
    private String work_time;//办公时间
    private String duty_office;//责任科室
    private String apply_service;//申请方式
    private String control_phone;//监督投诉电话
    private String apply_result;//审批结果
    private String local_number;//办事者到办事现场次数


    private String code_type;
    private String code_value;
    private String code_name;

    //服务事项跟踪统计
    private int ybjcou;
    private int wbjcou;
    private int cqwbj;
    private int sum;
    private String area_code;
    private String start_time;
    private String end_time;
    private String areaname;
    private String areatree;


    public String getAreatree() {
        return areatree;
    }

    public void setAreatree(String areatree) {
        this.areatree = areatree;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }



    public int getYbjcou() {
        return ybjcou;
    }

    public void setYbjcou(int ybjcou) {
        this.ybjcou = ybjcou;
    }

    public int getWbjcou() {
        return wbjcou;
    }

    public void setWbjcou(int wbjcou) {
        this.wbjcou = wbjcou;
    }

    public int getCqwbj() {
        return cqwbj;
    }

    public void setCqwbj(int cqwbj) {
        this.cqwbj = cqwbj;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getCode_type() {
        return code_type;
    }

    public void setCode_type(String code_type) {
        this.code_type = code_type;
    }

    public String getCode_value() {
        return code_value;
    }

    public void setCode_value(String code_value) {
        this.code_value = code_value;
    }

    public String getCode_name() {
        return code_name;
    }

    public void setCode_name(String code_name) {
        this.code_name = code_name;
    }

    public String getCata_type() {
        return cata_type;
    }

    public void setCata_type(String cata_type) {
        this.cata_type = cata_type;
    }

    public String getResult_department_id() {
        return result_department_id;
    }

    public void setResult_department_id(String result_department_id) {
        this.result_department_id = result_department_id;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getDuty_office() {
        return duty_office;
    }

    public void setDuty_office(String duty_office) {
        this.duty_office = duty_office;
    }

    public String getApply_service() {
        return apply_service;
    }

    public void setApply_service(String apply_service) {
        this.apply_service = apply_service;
    }

    public String getControl_phone() {
        return control_phone;
    }

    public void setControl_phone(String control_phone) {
        this.control_phone = control_phone;
    }

    public String getApply_result() {
        return apply_result;
    }

    public void setApply_result(String apply_result) {
        this.apply_result = apply_result;
    }

    public String getLocal_number() {
        return local_number;
    }

    public void setLocal_number(String local_number) {
        this.local_number = local_number;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }


    private String file_table_name;//附件表
    private String img_table_name;//图片表



    public String getFile_table_name() {
        return file_table_name;
    }

    public void setFile_table_name(String file_table_name) {
        this.file_table_name = file_table_name;
    }

    public String getImg_table_name() {
        return img_table_name;
    }

    public void setImg_table_name(String img_table_name) {
        this.img_table_name = img_table_name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    public String getCata_id() {
        return cata_id;
    }

    public void setCata_id(String cata_id) {
        this.cata_id = cata_id;
    }

    public String getCata_code() {
        return cata_code;
    }

    public void setCata_code(String cata_code) {
        this.cata_code = cata_code;
    }

    public String getCata_name() {
        return cata_name;
    }

    public void setCata_name(String cata_name) {
        this.cata_name = cata_name;
    }

    public String getCata_pingyin() {
        return cata_pingyin;
    }

    public void setCata_pingyin(String cata_pingyin) {
        this.cata_pingyin = cata_pingyin;
    }

    public String getCata_desc() {
        return cata_desc;
    }

    public void setCata_desc(String cata_desc) {
        this.cata_desc = cata_desc;
    }

    public int getCata_sort() {
        return cata_sort;
    }

    public void setCata_sort(int cata_sort) {
        this.cata_sort = cata_sort;
    }

    public String getBus_type_id() {
        return bus_type_id;
    }

    public void setBus_type_id(String bus_type_id) {
        this.bus_type_id = bus_type_id;
    }

    public String getEvent_type_id() {
        return event_type_id;
    }

    public void setEvent_type_id(String event_type_id) {
        this.event_type_id = event_type_id;
    }

    public String getConsumer_type_id() {
        return consumer_type_id;
    }

    public void setConsumer_type_id(String consumer_type_id) {
        this.consumer_type_id = consumer_type_id;
    }

    public String getPower_type_id() {
        return power_type_id;
    }

    public void setPower_type_id(String power_type_id) {
        this.power_type_id = power_type_id;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
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

    public String getCata_hand_time_limit() {
        return cata_hand_time_limit;
    }

    public void setCata_hand_time_limit(String cata_hand_time_limit) {
        this.cata_hand_time_limit = cata_hand_time_limit;
    }

    public String getCata_promise_time_limit() {
        return cata_promise_time_limit;
    }

    public void setCata_promise_time_limit(String cata_promise_time_limit) {
        this.cata_promise_time_limit = cata_promise_time_limit;
    }

    public String getCata_complaint_tel() {
        return cata_complaint_tel;
    }

    public void setCata_complaint_tel(String cata_complaint_tel) {
        this.cata_complaint_tel = cata_complaint_tel;
    }

    public String getCata_is_net() {
        return cata_is_net;
    }

    public void setCata_is_net(String cata_is_net) {
        this.cata_is_net = cata_is_net;
    }

    public String getCata_video_url() {
        return cata_video_url;
    }

    public void setCata_video_url(String cata_video_url) {
        this.cata_video_url = cata_video_url;
    }

    public String getCata_is_charge() {
        return cata_is_charge;
    }

    public void setCata_is_charge(String cata_is_charge) {
        this.cata_is_charge = cata_is_charge;
    }

    public String getCata_establish() {
        return cata_establish;
    }

    public void setCata_establish(String cata_establish) {
        this.cata_establish = cata_establish;
    }

    public String getCata_hand_term() {
        return cata_hand_term;
    }

    public void setCata_hand_term(String cata_hand_term) {
        this.cata_hand_term = cata_hand_term;
    }

    public String getCata_app_material() {
        return cata_app_material;
    }

    public void setCata_app_material(String cata_app_material) {
        this.cata_app_material = cata_app_material;
    }

    public String getCata_process() {
        return cata_process;
    }

    public void setCata_process(String cata_process) {
        this.cata_process = cata_process;
    }

    public String getBus_type_name() {
        return bus_type_name;
    }

    public void setBus_type_name(String bus_type_name) {
        this.bus_type_name = bus_type_name;
    }

    public String getEvent_type_name() {
        return event_type_name;
    }

    public void setEvent_type_name(String event_type_name) {
        this.event_type_name = event_type_name;
    }

    public String getConsumer_type_name() {
        return consumer_type_name;
    }

    public void setConsumer_type_name(String consumer_type_name) {
        this.consumer_type_name = consumer_type_name;
    }

    public String getPower_type_name() {
        return power_type_name;
    }

    public void setPower_type_name(String power_type_name) {
        this.power_type_name = power_type_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getCata_process_pic() {
        return cata_process_pic;
    }

    public void setCata_process_pic(String cata_process_pic) {
        this.cata_process_pic = cata_process_pic;
    }

    public Double getDepartment_longitude() {
        return department_longitude;
    }

    public void setDepartment_longitude(Double department_longitude) {
        this.department_longitude = department_longitude;
    }

    public Double getDepartment_latitude() {
        return department_latitude;
    }

    public void setDepartment_latitude(Double department_latitude) {
        this.department_latitude = department_latitude;
    }

    public String getDepartment_address() {
        return department_address;
    }

    public void setDepartment_address(String department_address) {
        this.department_address = department_address;
    }

    public String getDepartment_route() {
        return department_route;
    }

    public void setDepartment_route(String department_route) {
        this.department_route = department_route;
    }

    public String getDepartment_work_time() {
        return department_work_time;
    }

    public void setDepartment_work_time(String department_work_time) {
        this.department_work_time = department_work_time;
    }

    public String getCata_url() {
        return cata_url;
    }

    public void setCata_url(String cata_url) {
        this.cata_url = cata_url;
    }

    public String getIs_collect() {
        return is_collect;
    }

    public void setIs_collect(String is_collect) {
        this.is_collect = is_collect;
    }

    public String getCata_process_type() {
        return cata_process_type;
    }

    public void setCata_process_type(String cata_process_type) {
        this.cata_process_type = cata_process_type;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getResult_department_name() {
        return result_department_name;
    }

    public void setResult_department_name(String result_department_name) {
        this.result_department_name = result_department_name;
    }
}
