package com.ks.keshuoservice.dao.Redirect;

import com.ks.keshuoservice.entity.Redirect.TbUpManangeInfoEntity;
import com.ks.keshuoservice.entity.Redirect.TbUpManangeParamInfoEntity;
import com.ks.keshuoservice.utils.common.PageData;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedirectManageDao {

    @Select("select UUID_SHORT() ")
    String getUUID();
    List<TbUpManangeInfoEntity> queryUpManageInfo(PageData pd);
    List<TbUpManangeParamInfoEntity> queryUpManageParamByUpSerialInfo(String serial);
    void saveUpManageInfo(PageData pd);
    void saveUpManageParamInfo(PageData pd);
    void updateUpManageInfo(PageData pd);
    void deleteUpManageParamInfo(String serial);
    void saveMappingInfo(PageData pd);

}
