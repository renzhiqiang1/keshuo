package com.ks.keshuoservice.controller.Redirect;

import com.ks.keshuoservice.service.Redirect.RedirectManageService;
import com.ks.keshuoservice.service.Redirect.RedirectMappingService;
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
@RequestMapping("/redirectMapping")
public class RedirectMappingController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedirectMappingService redirectMappingService;


    /**
     * 查询上游信息
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/queryMappingInfo")
    public void queryMappingInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            PageData resultPd = redirectMappingService.queryMappingInfo(pageHelperData);
            if(resultPd.get("success").equals("success")){
                ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
            }else{
                ControllerUtils.returnJsonError(request, response, "查询失败",-1);
            }
    }


    /**
     * 修改重定向状态信息
     * @param request
     * @param response
     * @param pd
     * @throws IOException
     */
    @RequestMapping("/updateMappingInfo")
    public void updateMappingInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageData pd) throws IOException {
        PageData resultPd = redirectMappingService.updateMappingInfo(pd);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "修改失败",-1);
        }
    }

    /**
     * 批量修改状态
     *
     * @param request
     * @param response
     * @param pd
     * @throws IOException
     */
    @RequestMapping("/batchUpdateMappingInfo")
    public void batchUpdateMappingInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PageData pd) throws IOException {
        PageData resultPd = redirectMappingService.batchUpdateMappingInfo(pd);
        if(resultPd.get("success").equals("success")){
            ControllerUtils.returnJsonSuccess(request, response, resultPd,1);
        }else{
            ControllerUtils.returnJsonError(request, response, "修改失败",-1);
        }
    }







}
