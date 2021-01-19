package com.ks.keshuoservice.dao.Interface;

import com.ks.keshuoservice.entity.Interface.TbUpInfoEntity;
import com.ks.keshuoservice.utils.common.PageData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface InterManageDao {

    List<TbUpInfoEntity> queryManageInfo(PageData pd);

    void saveUpInfo(PageData pd);

    void updateUpInfo(PageData pd);

    @Update("update tb_uptodowninfo set upstatus = #{upstatus} where serial = #{serial}")
    void updateUpToDownUpStatus(@Param("serial") String serial, @Param("upstatus") String upstatus);

    void batchUpdateUpInfo(HashMap<String,Object> map);

}
