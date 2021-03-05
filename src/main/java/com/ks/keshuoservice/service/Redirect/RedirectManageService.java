package com.ks.keshuoservice.service.Redirect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ks.keshuoservice.dao.Redirect.RedirectManageDao;
import com.ks.keshuoservice.entity.Redirect.TbUpManangeInfoEntity;
import com.ks.keshuoservice.entity.Redirect.TbUpManangeParamInfoEntity;
import com.ks.keshuoservice.utils.common.PageData;
import com.ks.keshuoservice.utils.common.PageHelperData;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RedirectManageService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedirectManageDao redirectManageDao;

    @Value("${redirectUrl}")
    private String redirectUrl;

    public PageData queryUpManageInfo(PageHelperData pageHelperData){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "查询成功";
        PageData pd = pageHelperData.getPd();
        PageHelper.startPage(pageHelperData);
        List<TbUpManangeInfoEntity> list = redirectManageDao.queryUpManageInfo(pd);
        PageInfo<TbUpManangeInfoEntity> resultList = new PageInfo<TbUpManangeInfoEntity>(list);
        resultPd.put("resultList", resultList);
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }



    public PageData queryUpManageParamInfo(PageData pd){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "查询成功";
        String serial = (String) pd.get("serial");
        List<TbUpManangeParamInfoEntity> list = redirectManageDao.queryUpManageParamByUpSerialInfo(serial);
        resultPd.put("resultList", list);
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }

    public PageData saveUpManageInfo(PageData pd){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "保存成功";
        if(!pd.isEmpty()){
            String serial = redirectManageDao.getUUID();
            pd.put("serial",serial);
            redirectManageDao.saveUpManageInfo(pd);
            List<HashMap<String, Object>> listMap = (List<HashMap<String, Object>>) pd.get("list");
            if(listMap!=null && listMap.size()>0){
                String createuser = (String) pd.get("createuser");
                for(HashMap<String, Object> m:listMap){
                    String code = (String) m.get("code");
                    String value = (String) m.get("value");
                    PageData parPd = new PageData();
                    parPd.put("code",code);
                    parPd.put("value",value);
                    parPd.put("createuser",createuser);
                    parPd.put("upserial",serial);
                    redirectManageDao.saveUpManageParamInfo(parPd);
                }
            }

        }else{
            success = "error";
            message = "参数不能为空";
        }
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }





    public PageData updateUpManageInfo(PageData pd){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "修改成功";
        if(!pd.isEmpty()){
            String serial = (String) pd.get("serial");
            if(StringUtils.isNotBlank(serial)){
                redirectManageDao.updateUpManageInfo(pd);
                redirectManageDao.deleteUpManageParamInfo(serial);
                List<HashMap<String, Object>> listMap = (List<HashMap<String, Object>>) pd.get("list");
                if(listMap!=null && listMap.size()>0){
                    String createuser = (String) pd.get("updateuser");
                    for(HashMap<String, Object> m:listMap){
                        String code = (String) m.get("code");
                        String value = (String) m.get("value");
                        PageData parPd = new PageData();
                        parPd.put("code",code);
                        parPd.put("value",value);
                        parPd.put("createuser",createuser);
                        parPd.put("upserial",serial);
                        redirectManageDao.saveUpManageParamInfo(parPd);
                    }
                }
            }

        }else{
            success = "error";
            message = "参数不能为空";
        }
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }

    public PageData buildUpMangeInfo(PageData pd){
        PageData resultPd = new PageData();
        List<PageData> resultList = new ArrayList();
        String success = "success";
        String message = "生成成功";
        if(!pd.isEmpty()){
            String serial = (String) pd.get("serial");
            String url = (String) pd.get("url");
            String createuser = (String) pd.get("createuser");
            String number = (String) pd.get("number");
            List<HashMap<String, Object>> listMap = (List<HashMap<String, Object>>) pd.get("list");
            if(StringUtils.isNotBlank(serial)){
                List<TbUpManangeParamInfoEntity> list = redirectManageDao.queryUpManageParamByUpSerialInfo(serial);
                if(StringUtils.isNotBlank(url)){

                    if(listMap!=null && listMap.size()>0){
                        for(HashMap<String, Object> m:listMap){
                            String downSerial = (String) m.get("downserial");
                            if(StringUtils.isNotBlank(number) && Integer.valueOf(number)>0){
                                int num = Integer.valueOf(number);
                                for(int i=0;i<num;i++){
                                    StringBuffer sb = new StringBuffer();
                                    sb.append(url);
                                    String privateSerial = redirectManageDao.getUUID();
                                    sb.append("?private="+privateSerial);
                                    sb.append("&callback={callback}");

                                    if(list!=null && list.size()>0){
                                            for(TbUpManangeParamInfoEntity p:list){
                                                String code = p.getCode();
                                                String value = p.getValue();
                                                if(StringUtils.isBlank(value)){
                                                    value = "{"+code+"}";
                                                    sb.append("&"+code+"="+value);
                                                }
                                            }
                                    }
                                    PageData buildPd = new PageData();
                                    String sbUrl = sb.toString();
                                    String resutlUrl = "";
                                    if(sbUrl.contains("?")){
                                        resutlUrl = redirectUrl+sbUrl.substring(sbUrl.indexOf("?"),sbUrl.length());
                                    }else{
                                        resutlUrl = sbUrl;
                                    }
                                    buildPd.put("url",resutlUrl);
                                    buildPd.put("serial",privateSerial);
                                    buildPd.put("upserial",serial);
                                    buildPd.put("downserial",downSerial);
                                    buildPd.put("status","1");
                                    buildPd.put("createuser",createuser);
                                    redirectManageDao.saveMappingInfo(buildPd);
                                    resultList.add(buildPd);
                                }
                            }
                        }
                    }else{
                        success = "error";
                        message = "请选择要下游";
                    }
                }
            }else{
                success = "error";
                message = "上游serial不能为空";
            }
        }else{
            success = "error";
            message = "参数不能为空";
        }
        resultPd.put("resultList", resultList);
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }





    public PageData batchUpdateUpMangeInfo(PageData pd){
        String success = "success";
        String message = "修改成功";
        PageData resultPd = new PageData();
        String status = (String) pd.get("status");
        String remark = (String) pd.get("remark");
        String updateuser = (String) pd.get("updateuser");
        List<HashMap<String,Object>> listMap = (List<HashMap<String, Object>>) pd.get("list");
        if(listMap!=null && listMap.size()>0){
            for (HashMap<String, Object> m : listMap) {
                PageData upPd = new PageData();
                upPd.put("remark",remark);
                upPd.put("updateuser",updateuser);
                upPd.put("status",status);
                upPd.put("serial",m.get("serial"));
                redirectManageDao.updateUpManageInfo(upPd);
            }
        }
        resultPd.put("success", success);
        resultPd.put("message", message);
        return resultPd;
    }







}
