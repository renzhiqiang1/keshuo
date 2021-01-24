package com.ks.keshuoservice.controller.Redirect;

import com.ks.keshuoservice.service.Redirect.RedirectInterService;
import com.ks.keshuoservice.utils.common.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class RedirectInterController {

    @Autowired
    private RedirectInterService redirectInterService;

    @RequestMapping("/inter/redirect")
    public void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PageData pd = new PageData(request);
        String url = redirectInterService.redirect(pd);
        response.sendRedirect(url);
    }


}
