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
     */
    @RequestMapping("/queryDownManageInfo")
    public void queryDownManageInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PageData pd = new PageData(request);
        if(pd.isEmpty()){
            ControllerUtils.returnJsonError(request, response, "参数不能为空",-1);
        }else {
            String pageNum = (String) pd.get("pageNum");
            String pageSize = (String) pd.get("pageSize");
            String direction = (String) pd.get("direction");
            String order = (String) pd.get("order");
            PageHelperData pageHelperData = new PageHelperData();
            pageHelperData.setOrder(order);
            pageHelperData.setDirection(direction);
            pageHelperData.setPageNum(Integer.valueOf(pageNum));
            pageHelperData.setPageSize(Integer.valueOf(pageSize));
            pd.remove("pageNum");
            pd.remove("order");
            pd.remove("direction");
            pd.remove("pageSize");
            pageHelperData.setPd(pd);
            PageData resultPd = interDownManageService.queryDownManageInfo(pageHelperData);
            if (resultPd.get("success").equals("success")) {
                ControllerUtils.returnJsonSuccess(request, response, resultPd, 1);
            } else {
                ControllerUtils.returnJsonError(request, response, "查询失败", -1);
            }
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


    /**
     * 批量修改下游接口信息
     * @param request
     * @param response
     * @param pd
     * @throws IOException
     */
    @RequestMapping("/batchUpdateDownInfo")
    public void batchUpdateDownInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageData pd) throws IOException {
        PageData resultPd = interDownManageService.batchUpdateDownInfo(pd);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "修改失败",-1);
        }
    }



}
