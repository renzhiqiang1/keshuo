package com.ks.keshuoservice.entity.Redirect;

import java.io.Serializable;
import java.util.Date;

public class TbDownMappingInfoEntity implements Serializable {

    private String serial;
    private String mappingserial;
    private String pars;
    private Date createtime;
    private String idfa;
    private String callback;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMappingserial() {
        return mappingserial;
    }

    public void setMappingserial(String mappingserial) {
        this.mappingserial = mappingserial;
    }


    public String getPars() {
        return pars;
    }

    public void setPars(String pars) {
        this.pars = pars;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
