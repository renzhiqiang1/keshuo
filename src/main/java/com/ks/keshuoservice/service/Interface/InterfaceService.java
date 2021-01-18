package com.ks.keshuoservice.service.Interface;

import com.alibaba.fastjson.JSONObject;
import com.ks.keshuoservice.dao.Interface.InterfaceDao;
import com.ks.keshuoservice.entity.Interface.TbUpInfoEntity;
import com.ks.keshuoservice.entity.Interface.TbUpToDownInfoEntity;
import com.ks.keshuoservice.utils.common.PageData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Executor;

@Service
public class InterfaceService {

    private Executor executor;

    @Autowired
    private InterfaceDao interfaceDao;

    public PageData getUpstreamInfo(HttpServletRequest request, HttpServletResponse response, PageData pd){
        PageData resultPd = new PageData();
        String success = "success";
        String message = "获取数据成功";
        String resultStr = "";
        String ip = request.getRemoteAddr();
//        String ip = "127.0.0.1";
        String serial = (String) pd.get("id");
//        String serial = "1";
        if(StringUtils.isNotBlank(ip)){
            //查询数据库判断是否有权限访问
            List<TbUpToDownInfoEntity> downList = interfaceDao.queryuptoDownInfo(ip,serial);
            if(downList!=null && downList.size()>0){
                for(TbUpToDownInfoEntity tbDownInfoEntity:downList){
                    String status = tbDownInfoEntity.getDownstatus();
                    if(StringUtils.isNotBlank(status)&&status.equals("1")){
                        //查看上游接口状态及访问地址
                        List<TbUpInfoEntity> upList = interfaceDao.queryupInfo(serial);
                        if(upList!=null && upList.size()>0){
                            TbUpInfoEntity tbUpInfoEntity = upList.get(0);
                            String upStatus = tbUpInfoEntity.getStatus();
                            if(StringUtils.isNotBlank(upStatus)&& upStatus.equals("1")){
                                String upIp = tbUpInfoEntity.getUpip();
                                if(StringUtils.isNotBlank(upIp)){
                                    RestTemplate restTemplate = new RestTemplate();
                                    restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
//                                    PageData json = new PageData();
                                    JSONObject json = new JSONObject();
                                    String channel = tbUpInfoEntity.getChannel();
                                    String adid = tbUpInfoEntity.getAdid();
                                    String idfa = tbUpInfoEntity.getIdfa();
                                    json.put("channel",channel);
                                    json.put("adid",adid);
                                    json.put("idfa",idfa);
                                    resultStr = restTemplate.postForObject(upIp, json, String.class);
                                    if(StringUtils.isNotBlank(resultStr)){
                                        //结果数据存库
                                        PageData savePd = new PageData();
                                        savePd.put("upserial",serial);
                                        savePd.put("result",resultStr);
                                        savePd.put("downip",ip);
                                        interfaceDao.saveResultInfo(savePd);
                                    }else{
                                        message = "接口数据为空";
                                    }
                                }
                            }else{
                                success = "error";
                                message = "无访上游接口权限,请于管理员联系";
                            }
                        }else{
                            success = "error";
                            message = "无访上游接口权限,请于管理员联系";
                        }
                    }else{
                        success = "error";
                        message = "无访问权限,请于管理员联系";
                    }
                }
            }else{
                success = "error";
                message = "无访问权限,请于管理员联系";
            }

        }
        resultPd.put("result",resultStr);
        resultPd.put("success",success);
        resultPd.put("message",message);
        return resultPd;
    }




    public PageData getCallUpstreamInfo(HttpServletRequest request, HttpServletResponse response, PageData pd){
        PageData resultPd = new PageData();
        String channel = (String) pd.get("channel");
        String adid = (String) pd.get("adid");
        String idfa = (String) pd.get("idfa");
        String url = (String) pd.get("url");
        String success = "success";
        String message = "获取数据成功";
        String resultStr = "";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        JSONObject json = new JSONObject();
        json.put("channel",channel);
        json.put("adid",adid);
        json.put("idfa",idfa);
        resultStr = restTemplate.postForObject(url, json, String.class);
        resultPd.put("result",resultStr);
        resultPd.put("success",success);
        resultPd.put("message",message);
        return resultPd;
    }



}
