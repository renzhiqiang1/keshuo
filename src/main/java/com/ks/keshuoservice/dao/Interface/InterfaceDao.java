package com.ks.keshuoservice.dao.Interface;

import com.ks.keshuoservice.entity.Interface.TbUpInfoEntity;
import com.ks.keshuoservice.entity.Interface.TbUpToDownInfoEntity;
import com.ks.keshuoservice.utils.common.PageData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 用户接口
 *
 */
@Repository
public interface InterfaceDao {

    @Select("select * from tb_uptodowninfo where downip = #{ip} and serial = #{serial}")
    List<TbUpToDownInfoEntity> queryuptoDownInfo(@Param("ip") String ip,@Param("serial") String serial);

    @Select("select * from tb_upinfo where serial = #{serial}")
    List<TbUpInfoEntity> queryupInfo(@Param("serial") String serial);

    void saveResultInfo(PageData pd);

}
