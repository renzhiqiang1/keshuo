package com.ks.keshuoservice.dao.Redirect;

import com.ks.keshuoservice.entity.Interface.TbUpToDownInfoEntity;
import com.ks.keshuoservice.entity.Redirect.TbDownManageInfoEntity;
import com.ks.keshuoservice.utils.common.PageData;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface RedirectDownManageDao {

    List<TbDownManageInfoEntity> queryDownManageInfo(PageData pd);

    void saveDownManageInfo(PageData pd);

    void updateDownManageInfo(PageData pd);

    void batchUpdateDownManageInfo(HashMap<String, Object> map);

}
