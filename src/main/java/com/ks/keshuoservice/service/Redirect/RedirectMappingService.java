package com.ks.keshuoservice.service.Redirect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ks.keshuoservice.dao.Redirect.RedirectMappingDao;
import com.ks.keshuoservice.entity.Redirect.TbMappingInfoEntity;
import com.ks.keshuoservice.utils.common.PageData;
import com.ks.keshuoservice.utils.common.PageHelperData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RedirectMappingService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedirectMappingDao redirectMappingDao;


    public PageData queryMappingInfo(PageHelperData pageHelperData){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "查询成功";
        PageData pd = pageHelperData.getPd();
        PageHelper.startPage(pageHelperData);
        List<TbMappingInfoEntity> list = redirectMappingDao.queryMappingInfo(pd);
        PageInfo<TbMappingInfoEntity> resultList = new PageInfo<TbMappingInfoEntity>(list);
        resultPd.put("resultList", resultList);
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }





    public PageData updateMappingInfo(PageData pd){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "修改成功";
        if(!pd.isEmpty()){
                redirectMappingDao.updateMappingInfo(pd);
        }else{
            success = "error";
            message = "参数不能为空";
        }
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }

    public PageData batchUpdateMappingInfo(PageData pd){
        String success = "success";
        String message = "修改成功";
        PageData resultPd = new PageData();
        String status = (String) pd.get("status");
        String updateuser = (String) pd.get("updateuser");
        List<HashMap<String,Object>> listMap = (List<HashMap<String, Object>>) pd.get("list");
        if(listMap!=null && listMap.size()>0){
            for (HashMap<String, Object> m : listMap) {
                PageData upPd = new PageData();
                upPd.put("updateuser",updateuser);
                upPd.put("status",status);
                upPd.put("serial",m.get("serial"));
                redirectMappingDao.updateMappingInfo(upPd);
            }
        }
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }







}
