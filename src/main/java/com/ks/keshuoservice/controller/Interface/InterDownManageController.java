package com.ks.keshuoservice.controller.Interface;

import com.ks.keshuoservice.service.Interface.InterDownManageService;
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
@RequestMapping("/interDownManage")
public class InterDownManageController {

    @Autowired
    private InterDownManageService interDownManageService;
    /**
     * 查询下游信息分页
     * @param request
     * @param response
     * @param pageHelperData
     */
    @RequestMapping("/queryDownManageInfo")
    public void queryDownManageInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageHelperData pageHelperData) throws IOException {
        PageData resultPd = interDownManageService.queryDownManageInfo(pageHelperData);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "查询失败",-1);
        }
    }

    /**
     * 新增下游接口信息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/saveDownInfo")
    public void saveDownInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageData pd) throws IOException {
        PageData resultPd = interDownManageService.saveDownInfo(pd);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "保存失败",-1);
        }
    }


    /**
     * 修改下游接口信息
     * @param request
     * @param response
     * @param pd
     * @throws IOException
     */
    @RequestMapping("/updateDownInfo")
    public void updateDownInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageData pd) throws IOException {
        PageData resultPd = interDownManageService.updateDownInfo(pd);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "修改失败",-1);
        }
    }


}
