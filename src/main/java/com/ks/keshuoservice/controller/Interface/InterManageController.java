package com.ks.keshuoservice.controller.Interface;

import com.ks.keshuoservice.dao.Interface.InterManageDao;
import com.ks.keshuoservice.service.Interface.InterManageService;
import com.ks.keshuoservice.utils.common.ControllerUtils;
import com.ks.keshuoservice.utils.common.PageData;
import com.ks.keshuoservice.utils.common.PageHelperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/interManage")
public class InterManageController {

    @Autowired
    private InterManageService interManageService;
    /**
     * 查询分页信息
     * @param request
     * @param response
     * @param pageHelperData
     */
    @RequestMapping("/queryManageInfo")
    public void queryManageInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageHelperData pageHelperData) throws IOException {
        PageData resultPd = interManageService.queryManageInfo(pageHelperData);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "查询失败",-1);
        }
    }

    /**
     * 新增上游接口信息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/saveUpInfo")
    public void saveUpInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageData pd) throws IOException {
        PageData resultPd = interManageService.saveUpInfo(pd);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "保存失败",-1);
        }
    }


    /**
     * 修改上游接口信息
     * @param request
     * @param response
     * @param pd
     * @throws IOException
     */
    @RequestMapping("/updateUpInfo")
    public void updateUpInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageData pd) throws IOException {
        PageData resultPd = interManageService.updateUpInfo(pd);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "修改失败",-1);
        }
    }


    /**
     * 批量修改状态 未完成
     * @param request
     * @param response
     * @param pd
     * @throws IOException
     */
   /* @RequestMapping("/batchUpdateUpStatusInfo")
    public void batchUpdateUpStatusInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageData pd) throws IOException {
        PageData resultPd = interManageService.batchUpdateUpStatusInfo(pd);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "查询失败",-1);
        }
    }*/



}
