package com.ks.keshuoservice.service.Interface;

import com.alibaba.fastjson.JSON;
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
        JSONObject resultJson = new JSONObject();
//        String ip = request.getRemoteAddr();
        String ip = "127.0.0.1";
        String serial = (String) pd.get("id");
//        String serial = "1";
        if(StringUtils.isNotBlank(ip)){
            JSONObject json = JSONObject.parseObject(JSON.toJSONString(pd));
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
                                String percent = tbDownInfoEntity.getPercent();
                                if(StringUtils.isNotBlank(upIp)){
                                    RestTemplate restTemplate = new RestTemplate();
                                    restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
                                    String resultStr = restTemplate.postForObject(upIp, json, String.class);
                                    if(StringUtils.isNotBlank(resultStr)){
                                        resultJson = JSONObject.parseObject(resultStr);
                                        //结果数据存库
                                        PageData savePd = new PageData();
                                        savePd.put("upserial",serial);
                                        savePd.put("result",resultStr);
                                        savePd.put("downip",ip);
                                        interfaceDao.saveResultInfo(savePd);
                                        if(StringUtils.isNotBlank(percent)){
                                            //总数/percent 取整数
                                            Integer count = 100;
                                            String countStr = String.valueOf(count);
                                            Double perDou = Double.parseDouble(percent);
                                            Double countDou = Double.parseDouble(countStr);
                                            if(perDou<=100){
                                                int size = (int) Math.ceil(countDou/perDou);
                                                System.out.println(size);
                                                //循环结果进行反馈
                                            }
//                                            Integer size = Math.ceil(num);
                                        }
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
        resultPd.put("result",resultJson);
        resultPd.put("success",success);
        resultPd.put("message",message);
        return resultPd;
    }




    public PageData getCallUpstreamInfo(HttpServletRequest request, HttpServletResponse response, PageData pd){
        PageData resultPd = new PageData();
        String url = (String) pd.get("url");
        String success = "success";
        String message = "获取数据成功";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(pd));
        String resultStr = restTemplate.postForObject(url, json, String.class);
        JSONObject resultJson = new JSONObject();
        if(StringUtils.isNotBlank(resultStr)){
            resultJson = JSONObject.parseObject(resultStr);
        }
        resultPd.put("result",resultJson);
        resultPd.put("success",success);
        resultPd.put("message",message);
        return resultPd;
    }



}
