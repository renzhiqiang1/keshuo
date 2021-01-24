package com.ks.keshuoservice.service.Redirect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ks.keshuoservice.dao.Interface.InterDownManageDao;
import com.ks.keshuoservice.dao.Redirect.RedirectDownManageDao;
import com.ks.keshuoservice.entity.Interface.TbUpToDownInfoEntity;
import com.ks.keshuoservice.entity.Redirect.TbDownManageInfoEntity;
import com.ks.keshuoservice.utils.common.PageData;
import com.ks.keshuoservice.utils.common.PageHelperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RedirectDownManageService {

    @Autowired
    private RedirectDownManageDao redirectDownManageDao;

    public PageData queryDownManageInfo(PageHelperData pageHelperData){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "查询成功";
        PageData pd = pageHelperData.getPd();
        PageHelper.startPage(pageHelperData);
        List<TbDownManageInfoEntity> list = redirectDownManageDao.queryDownManageInfo(pd);
        PageInfo<TbDownManageInfoEntity> resultList = new PageInfo<TbDownManageInfoEntity>(list);
        resultPd.put("resultList", resultList);
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }


    public PageData saveDownManageInfo(PageData pd){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "保存成功";
        redirectDownManageDao.saveDownManageInfo(pd);
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }

    public PageData updateDownManageInfo(PageData pd){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "修改成功";
        redirectDownManageDao.updateDownManageInfo(pd);
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }



    public PageData batchUpdateDownManageInfo(PageData pd){
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
                redirectDownManageDao.batchUpdateDownManageInfo(m);
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
