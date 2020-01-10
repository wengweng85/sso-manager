package com.insigma.sm.struct;

/**
 * Created by wengsh on 2019/6/5.
 */
public class Header {

    //�������
    private String serviceCode;
    //��Ϣϵͳ�ڵ����
    private String appCode;
    //�����������
    private String serviceAreaCode;
    //������ˮ�� 9λ����ҵ��ϵͳID+8λ����+9λ��ˮ�š�����ˮ�Ų������ظ�
    private String serviceReqId;
    //ҵ���������� YYYYMMDDHH24MISS
    private String serviceReqTime;
    //	��Ӧ��ˮ��
    private String serviceResId;
    //ҵ����Ӧ���� YYYYMMDDHH24MISS
    private String serviceResTime;
    /**
     *   00ҵ��ɹ�
         90��������
         10ҵ��ʧ��
         20ϵͳ����
         30ǩ��ʧ��
         40����ʧ��
         50Ȩ�޲���
     */
    private String commStatus;//��Ӧ״̬
    private String busiStatus;//ҵ��״̬
    private String msg;//������Ϣ

    //����ǩ��
    private String signature;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getServiceAreaCode() {
        return serviceAreaCode;
    }

    public void setServiceAreaCode(String serviceAreaCode) {
        this.serviceAreaCode = serviceAreaCode;
    }

    public String getServiceReqId() {
        return serviceReqId;
    }

    public void setServiceReqId(String serviceReqId) {
        this.serviceReqId = serviceReqId;
    }

    public String getServiceReqTime() {
        return serviceReqTime;
    }

    public void setServiceReqTime(String serviceReqTime) {
        this.serviceReqTime = serviceReqTime;
    }

    public String getServiceResId() {
        return serviceResId;
    }

    public void setServiceResId(String serviceResId) {
        this.serviceResId = serviceResId;
    }

    public String getServiceResTime() {
        return serviceResTime;
    }

    public void setServiceResTime(String serviceResTime) {
        this.serviceResTime = serviceResTime;
    }

    public String getCommStatus() {
        return commStatus;
    }

    public void setCommStatus(String commStatus) {
        this.commStatus = commStatus;
    }

    public String getBusiStatus() {
        return busiStatus;
    }

    public void setBusiStatus(String busiStatus) {
        this.busiStatus = busiStatus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
