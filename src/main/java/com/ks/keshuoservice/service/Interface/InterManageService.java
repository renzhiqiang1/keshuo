package com.ks.keshuoservice.service.Interface;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ks.keshuoservice.dao.Interface.InterManageDao;
import com.ks.keshuoservice.entity.Interface.TbUpInfoEntity;
import com.ks.keshuoservice.utils.common.PageData;
import com.ks.keshuoservice.utils.common.PageHelperData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InterManageService {

    @Autowired
    private InterManageDao interManageDao;

    public PageData queryManageInfo(PageHelperData pageHelperData){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "查询成功";
        PageData pd = pageHelperData.getPd();
        PageHelper.startPage(pageHelperData);
        List<TbUpInfoEntity> list = interManageDao.queryManageInfo(pd);
        PageInfo<TbUpInfoEntity> resultList = new PageInfo<TbUpInfoEntity>(list);
        resultPd.put("resultList", resultList);
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }


    public PageData saveUpInfo(PageData pd){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "保存成功";
        interManageDao.saveUpInfo(pd);
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }

    public PageData updateUpInfo(PageData pd){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "修改成功";
        interManageDao.updateUpInfo(pd);
        String upstatus = (String) pd.get("upstatus");
        String serial = (String) pd.get("serial");
        if(StringUtils.isNotBlank(upstatus)&& StringUtils.isNotBlank(serial)){
            //修改tb_uptodowninfo 中状态
            interManageDao.updateUpToDownUpStatus(serial,upstatus);
        }
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }



    public PageData batchUpdateUpInfo(PageData pd){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "修改成功";

        String remark = (String) pd.get("remark");
        String updateuser = (String) pd.get("updateuser");
        String status = (String) pd.get("status");
        List<HashMap<String, Object>> listMap = (List<HashMap<String, Object>>) pd.get("list");
        if(listMap!=null && listMap.size()>0){
            for (HashMap<String, Object> m : listMap) {
                m.put("remark",remark);
                m.put("updateuser",updateuser);
                m.put("status",status);
                interManageDao.batchUpdateUpInfo(m);
            }

            for (HashMap<String, Object> m : listMap) {
                String serial = (String) m.get("serial");
                interManageDao.updateUpToDownUpStatus(serial,status);
            }
        }else{
            success = "error";
            message = "请选择要修改的信息";
        }
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }

}
