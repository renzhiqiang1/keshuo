package com.ks.keshuoservice.entity.Interface;

import com.ks.keshuoservice.utils.common.DateUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

public class TbResultInfoEntity implements Serializable {

    private String serial;
    private String upserial;
    private String createtime;
    private String result;
    private String downip;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getUpserial() {
        return upserial;
    }

    public void setUpserial(String upserial) {
        this.upserial = upserial;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) throws ParseException {
        if(createtime!=null){
            this.createtime = DateUtil.dateToStringSs(createtime);
        }else{
            this.createtime = null;
        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDownip() {
        return downip;
    }

    public void setDownip(String downip) {
        this.downip = downip;
    }
}
