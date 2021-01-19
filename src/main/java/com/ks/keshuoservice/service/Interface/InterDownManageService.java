package com.ks.keshuoservice.service.Interface;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ks.keshuoservice.dao.Interface.InterDownManageDao;
import com.ks.keshuoservice.dao.Interface.InterManageDao;
import com.ks.keshuoservice.entity.Interface.TbUpInfoEntity;
import com.ks.keshuoservice.entity.Interface.TbUpToDownInfoEntity;
import com.ks.keshuoservice.utils.common.PageData;
import com.ks.keshuoservice.utils.common.PageHelperData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class InterDownManageService {

    @Autowired
    private InterDownManageDao interDownManageDao;

    public PageData queryDownManageInfo(PageHelperData pageHelperData){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "查询成功";
        PageData pd = pageHelperData.getPd();
        PageHelper.startPage(pageHelperData);
        List<TbUpToDownInfoEntity> list = interDownManageDao.queryDownManageInfo(pd);
        PageInfo<TbUpToDownInfoEntity> resultList = new PageInfo<TbUpToDownInfoEntity>(list);
        resultPd.put("resultList", resultList);
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }


    public PageData saveDownInfo(PageData pd){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "保存成功";
        interDownManageDao.saveDownInfo(pd);
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }

    public PageData updateDownInfo(PageData pd){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "修改成功";
        interDownManageDao.updateDownInfo(pd);
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }



    public PageData batchUpdateDownInfo(PageData pd){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "修改成功";
        String remark = (String) pd.get("remark");
        String updateuser = (String) pd.get("updateuser");
        String downstatus = (String) pd.get("downstatus");
        List<HashMap<String, Object>> listMap = (List<HashMap<String, Object>>) pd.get("list");
        if(listMap!=null && listMap.size()>0){
            for (HashMap<String, Object> m : listMap) {
                m.put("remark",remark);
                m.put("updateuser",updateuser);
                m.put("downstatus",downstatus);
                interDownManageDao.batchUpdateDownInfo(m);
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
