package com.insigma.mvc.model.catalogue;

/**
 * �����������������
 */
public class SearchCondition {

    private String searchType = "1"; // Ĭ�ϰ���������
    private String busTypeId;
    private String departmentId;
    private String keyword;
    private String consumerType; // �����������

    private String userId;

    public String getBusTypeId() {
        return busTypeId;
    }

    public void setBusTypeId(String busTypeId) {
        this.busTypeId = busTypeId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getConsumerType() {
        return consumerType;
    }

    public void setConsumerType(String consumerType) {
        this.consumerType = consumerType;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
