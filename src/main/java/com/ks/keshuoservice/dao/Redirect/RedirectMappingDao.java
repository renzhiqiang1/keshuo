package com.ks.keshuoservice.dao.Redirect;

import com.ks.keshuoservice.entity.Redirect.*;
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

    @Update("update tb_mappinginfo set clickrate = #{clickrate} where  serial = #{serial}")
    void updateMappingClickrateInfo(@Param("serial") String serial,@Param("clickrate") Integer clickrate);

    @Select("select * from tb_mappinginfo  where serial = #{serial}")
    List<TbMappingInfoEntity> queryMappingBySerial(@Param("serial") String serial);
    @Select("select * from tb_downmanageinfo  where serial = #{serial}")
    List<TbDownManageInfoEntity> queryDownManageBySerial(@Param("serial") String serial);

    @Select("select * from tb_upmanageinfo  where serial = #{serial}")
    List<TbUpManangeInfoEntity> queryUpManageBySerial(@Param("serial") String serial);

    @Update("update tb_upmanageinfo set clickrate = #{clickrate} where  serial = #{serial}")
    void updateUpManageClickrateInfo(@Param("serial") String serial,@Param("clickrate") Integer clickrate);

    void saveDownMappingInfo(PageData pd);

    @Select("select * from tb_downmappinginfo where mappingserial = #{mappingserial} and idfa = #{idfa}")
    List<TbDownMappingInfoEntity> queryDownMappingInfo(@Param("mappingserial") String mappingserial, @Param("idfa") String idfa);



    @Update("update tb_downmappinginfo set pars=#{pars},callback=#{callback} where  serial = #{serial}")
    void updateDownMappingInfo(@Param("serial") String serial,@Param("pars") String pars,@Param("callback") String callback);

}
