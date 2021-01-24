package com.ks.keshuoservice.service.Redirect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ks.keshuoservice.dao.Redirect.RedirectMappingDao;
import com.ks.keshuoservice.entity.Redirect.TbDownManageInfoEntity;
import com.ks.keshuoservice.entity.Redirect.TbMappingInfoEntity;
import com.ks.keshuoservice.entity.Redirect.TbUpManangeInfoEntity;
import com.ks.keshuoservice.utils.common.PageData;
import com.ks.keshuoservice.utils.common.PageHelperData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@Service
public class RedirectInterService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedirectMappingDao redirectMappingDao;

    public String redirect(PageData pd) throws UnsupportedEncodingException {
        String url = "";
        String serial = (String) pd.get("private");
        List<TbMappingInfoEntity> list = redirectMappingDao.queryMappingBySerial(serial);
        if (list != null && list.size() > 0) {
            TbMappingInfoEntity tbMappingInfoEntity = list.get(0);
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
                            if (upInfo.getStatus().equals("1")) {
                                String upUrl = upInfo.getUrl();
                                pd.remove("private");
                                url = upUrl+"?"+createLinkStringByGet(pd);
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
            value = URLEncoder.encode(value, "UTF-8");
            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }


}
