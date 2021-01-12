package com.ks.keshuoservice.controller.Interface;

import com.ks.keshuoservice.service.Interface.InterfaceService;
import com.ks.keshuoservice.utils.common.ControllerUtils;
import com.ks.keshuoservice.utils.common.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping(value = "/api/interface")
public class InterfaceController {

    @Autowired
    private InterfaceService interfaceService;

    /**
     * 下游接口调用获取上游接口数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/getUpstreamInfo")
    public void getUpstreamInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PageData pd = new PageData(request);
        if(pd.isEmpty()){
            ControllerUtils.returnJsonError(request, response, "参数不能为空",-1);
        }else {
            PageData resultPd = interfaceService.getUpstreamInfo(request, response, pd);
            if (resultPd.get("success").equals("success")) {
                ControllerUtils.returnJsonSuccess(request, response, resultPd, 1);
            } else {
                ControllerUtils.returnJsonError(request, response, "查询失败", -1);
            }
        }
    }


    @RequestMapping(value = "/getCallUpstreamInfo")
    public void getCallUpstreamInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PageData pd = new PageData(request);
        if(pd.isEmpty()){
            ControllerUtils.returnJsonError(request, response, "参数不能为空",-1);
        }else {
            PageData resultPd = interfaceService.getCallUpstreamInfo(request, response, pd);
            if (resultPd.get("success").equals("success")) {
                ControllerUtils.returnJsonSuccess(request, response, resultPd, 1);
            } else {
                ControllerUtils.returnJsonError(request, response, "查询失败", -1);
            }
        }
    }




}
