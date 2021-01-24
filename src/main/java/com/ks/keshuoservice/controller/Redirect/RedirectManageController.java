package com.ks.keshuoservice.controller.Redirect;

import com.ks.keshuoservice.service.Redirect.RedirectManageService;
import com.ks.keshuoservice.utils.common.ControllerUtils;
import com.ks.keshuoservice.utils.common.PageData;
import com.ks.keshuoservice.utils.common.PageHelperData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/redirectManage")
public class RedirectManageController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedirectManageService redirectManageService;


    /**
     * 查询上游信息
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/queryUpManageInfo")
    public void queryUpManageInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PageData pd = new PageData(request);
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
            PageData resultPd = redirectManageService.queryUpManageInfo(pageHelperData);
            if(resultPd.get("success").equals("success")){
                ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
            }else{
                ControllerUtils.returnJsonError(request, response, "查询失败",-1);
            }
    }

    /**
     * 查询上游的参数信息
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/queryUpManageParamInfo")
    public void queryUpManageParamInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PageData pd = new PageData(request);
        PageData resultPd = redirectManageService.queryUpManageParamInfo(pd);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "查询失败",-1);
        }
    }





    /**
     * 新增上游信息
     * @param request
     * @param response
     * @param pd
     * @throws IOException
     */
    @RequestMapping("/saveUpManageInfo")
    public void saveUpManageInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageData pd) throws IOException {
        PageData resultPd = redirectManageService.saveUpManageInfo(pd);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "保存失败",-1);
        }
    }


    /**
     * 修改上游信息
     * @param request
     * @param response
     * @param pd
     * @throws IOException
     */
    @RequestMapping("/updateUpManageInfo")
    public void updateUpManageInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageData pd) throws IOException {
        PageData resultPd = redirectManageService.updateUpManageInfo(pd);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "修改失败",-1);
        }
    }


    /**
     * 根据上游地址生成自己的url
     * @param request
     * @param response
     * @param pd
     * @throws IOException
     */
    @RequestMapping("/buildUpMangeInfo")
    public void buildUpMangeInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageData pd) throws IOException {
        PageData resultPd = redirectManageService.buildUpMangeInfo(pd);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "生成失败",-1);
        }
    }


    /**
     * 批量修改上游状态
     *
     * @param request
     * @param response
     * @param pd
     * @throws IOException
     */
    @RequestMapping("/batchUpdateUpMangeInfo")
    public void batchUpdateUpMangeInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageData pd) throws IOException {
        PageData resultPd = redirectManageService.batchUpdateUpMangeInfo(pd);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "修改失败",-1);
        }
    }







}
