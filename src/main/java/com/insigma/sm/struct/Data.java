package com.insigma.sm.struct;

import com.insigma.common.util.JsonUtils;
import com.insigma.sm.constraint.SMContraint;
import com.insigma.sm.util.SM4Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by wengsh on 2019/6/5.
 */
public class Data {
    private Header header;
    private HashMap body;

    public Data(HashMap body){
        this.header=initHeader();
        this.body=body;
        sign();
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public HashMap getBody() {
        return body;
    }

    public void setBody(HashMap body) {
        this.body = body;
    }

    private Header initHeader(){
        Header header=new Header();
        header.setServiceCode(SMContraint.SERVICEAREACODE);
        header.setAppCode(SMContraint.APPCODE);
        header.setServiceAreaCode(SMContraint.SERVICEAREACODE);
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMddhhmmss");
        header.setServiceReqTime(dateFormat.format(calendar.getTime()));
        dateFormat= new SimpleDateFormat("yyyyMMdd");
        header.setServiceReqId(SMContraint.APPCODE+dateFormat.format(calendar.getTime()));
        return header;
    }

    private void sign(){
        this.header.setSignature(SM4Utils.encryptData_ECB(JsonUtils.objectToJson(body)));
    }

    public String beanToJson(){
       return JsonUtils.objectToJson(this);
    }

    public Object jsonToBean(String json){
       return JsonUtils.jsonToPojo(json,Data.class);
    }

    public static void main(String [] args){
        HashMap map=new HashMap();
        map.put("name","wengsh");
        Data data=new Data(map);
        System.out.println(data.beanToJson());
    }
}
