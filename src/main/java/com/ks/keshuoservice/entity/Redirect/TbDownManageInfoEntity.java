package com.ks.keshuoservice.entity.Redirect;

import com.ks.keshuoservice.utils.common.DateUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

public class TbDownManageInfoEntity implements Serializable {

    private String serial;
    private String createtime;
    private String createuser;
    private String updatetime;
    private String updateuser;
    private String remark;
    private String status;
    private String percent;
    private String name;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
