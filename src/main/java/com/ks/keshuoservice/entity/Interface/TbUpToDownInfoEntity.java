package com.ks.keshuoservice.entity.Interface;

import com.ks.keshuoservice.utils.common.DateUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

public class TbUpToDownInfoEntity implements Serializable {

    private String serial;
    private String upserial;
    private String createtime;
    private String createuser;
    private String updatetime;
    private String updateuser;
    private String remark;
    private String downip;
    private String downstatus;
    private String upstatus;
    private String upip;

    public String getUpip() {
        return upip;
    }

    public void setUpip(String upip) {
        this.upip = upip;
    }

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

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDownip() {
        return downip;
    }

    public void setDownip(String downip) {
        this.downip = downip;
    }

    public String getDownstatus() {
        return downstatus;
    }

    public void setDownstatus(String downstatus) {
        this.downstatus = downstatus;
    }

    public String getUpstatus() {
        return upstatus;
    }

    public void setUpstatus(String upstatus) {
        this.upstatus = upstatus;
    }
}
