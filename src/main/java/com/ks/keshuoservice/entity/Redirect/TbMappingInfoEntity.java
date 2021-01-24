package com.ks.keshuoservice.entity.Redirect;

import com.ks.keshuoservice.utils.common.DateUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

public class TbMappingInfoEntity implements Serializable {
    private String serial;
    private String url;
    private String upserial;
    private String downserial;
    private String createtime;
    private String createuser;
    private String status;
    private String updatetime;
    private String updateuser;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUpserial() {
        return upserial;
    }

    public void setUpserial(String upserial) {
        this.upserial = upserial;
    }

    public String getDownserial() {
        return downserial;
    }

    public void setDownserial(String downserial) {
        this.downserial = downserial;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) throws ParseException {
        if(updatetime!=null){
            this.updatetime = DateUtil.dateToStringSs(updatetime);
        }else{
            this.updatetime = null;
        }
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }
}
