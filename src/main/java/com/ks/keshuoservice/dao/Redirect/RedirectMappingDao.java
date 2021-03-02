package com.ks.keshuoservice.dao.Redirect;

import com.ks.keshuoservice.entity.Redirect.TbDownManageInfoEntity;
import com.ks.keshuoservice.entity.Redirect.TbMappingInfoEntity;
import com.ks.keshuoservice.entity.Redirect.TbUpManangeInfoEntity;
import com.ks.keshuoservice.entity.Redirect.TbUpManangeParamInfoEntity;
import com.ks.keshuoservice.utils.common.PageData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedirectMappingDao {

    @Select("select UUID_SHORT() ")
    String getUUID();

    List<TbMappingInfoEntity> queryMappingInfo(PageData pd);

    void updateMappingInfo(PageData pd);

    @Select("select * from tb_mappinginfo  where serial = #{serial}")
    List<TbMappingInfoEntity> queryMappingBySerial(@Param("serial") String serial);
    @Select("select * from tb_downmanageinfo  where serial = #{serial}")
    List<TbDownManageInfoEntity> queryDownManageBySerial(@Param("serial") String serial);

    @Select("select * from tb_upmanageinfo  where serial = #{serial}")
    List<TbUpManangeInfoEntity> queryUpManageBySerial(@Param("serial") String serial);

}
