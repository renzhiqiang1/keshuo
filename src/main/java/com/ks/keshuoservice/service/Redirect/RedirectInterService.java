package com.ks.keshuoservice.service.Redirect;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ks.keshuoservice.dao.Redirect.RedirectManageDao;
import com.ks.keshuoservice.dao.Redirect.RedirectMappingDao;
import com.ks.keshuoservice.entity.Redirect.*;
import com.ks.keshuoservice.utils.common.PageData;
import com.ks.keshuoservice.utils.common.PageHelperData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@Service
public class RedirectInterService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedirectMappingDao redirectMappingDao;
    @Autowired
    private RedirectManageDao redirectManageDao;

    public String redirect(PageData pd) throws UnsupportedEncodingException {
        String url = "";
        if(!pd.isEmpty()){
            for (Object map : pd.entrySet()){
                String key = (String) ((Map.Entry)map).getKey();
                String value = (String) ((Map.Entry)map).getValue();
                if(!StringUtils.isEmpty(value) && value.contains("{")){
                    pd.put(key,"");
                }
            }
        }
        String serial = (String) pd.get("private");

        if(!StringUtils.isEmpty(serial)){
            //添加一个响应表，用来将下游反馈的结果和上游的地址进行关联，方便后期callback 的结果进行反馈

            PageData downMappingPd = new PageData();
            downMappingPd.put("mappingserial",serial);
            downMappingPd.put("pars",pd.toString());
            String idfa = (String) pd.get("idfa");
            downMappingPd.put("idfa",idfa);
            String callback = (String) pd.get("callback");
            downMappingPd.put("callback",callback);
            List<TbDownMappingInfoEntity> downMappingInfo = redirectMappingDao.queryDownMappingInfo(serial,idfa);
            if(downMappingInfo!=null && downMappingInfo.size()>0){
                TbDownMappingInfoEntity tbDownMappingInfoEntity = downMappingInfo.get(0);
                redirectMappingDao.updateDownMappingInfo(tbDownMappingInfoEntity.getSerial(),pd.toString(),callback);
            }else{
                redirectMappingDao.saveDownMappingInfo(downMappingPd);
            }
            List<TbMappingInfoEntity> list = redirectMappingDao.queryMappingBySerial(serial);
            if (list != null && list.size() > 0) {
                TbMappingInfoEntity tbMappingInfoEntity = list.get(0);
                Integer clickrate = tbMappingInfoEntity.getClickrate();
                if(clickrate!=null && clickrate>0){
                    clickrate++;
                }else{
                    clickrate = 1;
                }
                redirectMappingDao.updateMappingClickrateInfo(serial,clickrate);
                if (tbMappingInfoEntity.getStatus().equals("1")) {
                    String downSerial = tbMappingInfoEntity.getDownserial();
                    List<TbDownManageInfoEntity> downList = redirectMappingDao.queryDownManageBySerial(downSerial);
                    if (downList != null && downList.size() > 0) {
                        TbDownManageInfoEntity downInfo = downList.get(0);
                        if (downInfo.getStatus().equals("1")) {
                            String upSerial = tbMappingInfoEntity.getUpserial();
                            List<TbUpManangeInfoEntity> upList = redirectMappingDao.queryUpManageBySerial(upSerial);
                            if (upList != null && upList.size() > 0) {
                                TbUpManangeInfoEntity upInfo = upList.get(0);
                                Integer upClickrate = upInfo.getClickrate();
                                if(upClickrate!=null && upClickrate>0){
                                    upClickrate++;
                                }else{
                                    upClickrate = 1;
                                }
                                redirectMappingDao.updateUpManageClickrateInfo(upSerial,upClickrate);
                                if (upInfo.getStatus().equals("1")) {
                                    List<TbUpManangeParamInfoEntity> upManangeParamInfoEntityList = redirectManageDao.queryUpManageParamByUpSerialInfo(upSerial);
                                    if(upManangeParamInfoEntityList!=null && upManangeParamInfoEntityList.size()>0){
                                        for(TbUpManangeParamInfoEntity p:upManangeParamInfoEntityList){
                                            String value = p.getValue();
                                            String code = p.getCode();
                                            if(!StringUtils.isEmpty(value)){
                                                pd.put(code,value);
                                            }
                                        }
                                    }
                                    String upUrl = upInfo.getUrl();
                                    pd.remove("private");
                                    pd.remove("callback");
                                    url = upUrl+"?"+createLinkStringByGet(pd);
                                }
                            }
                        }
                    }
                }
            }
        }

        return url;
    }


    /**
     * 　　* 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * 　　* @param params 需要排序并参与字符拼接的参数组
     * 　　* @return 拼接后字符串
     * 　　* @throws UnsupportedEncodingException
     *
     */
    public String createLinkStringByGet(Map<String, String> params) throws UnsupportedEncodingException {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
//            value = URLEncoder.encode(value, "UTF-8");
            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }


}
