package com.ks.keshuoservice.dao.Interface;

import com.ks.keshuoservice.entity.Interface.TbUpInfoEntity;
import com.ks.keshuoservice.entity.Interface.TbUpToDownInfoEntity;
import com.ks.keshuoservice.utils.common.PageData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface InterDownManageDao {

    List<TbUpToDownInfoEntity> queryDownManageInfo(PageData pd);

    void saveDownInfo(PageData pd);

    void updateDownInfo(PageData pd);

    void batchUpdateDownInfo(HashMap<String, Object> map);

}
