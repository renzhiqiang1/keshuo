package com.ks.keshuoservice.entity.Redirect;

import com.ks.keshuoservice.utils.common.DateUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

public class TbUpManangeParamInfoEntity implements Serializable {

    private String serial;
    private String upserial;
    private String code;
    private String value;
    private String createtime;
    private String createuser;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }
}
